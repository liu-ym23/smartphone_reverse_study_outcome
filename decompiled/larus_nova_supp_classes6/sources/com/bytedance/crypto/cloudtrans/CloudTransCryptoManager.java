package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crypto.bridge.IEnvBridge;
import com.bytedance.crypto.cloudtrans.response.DSKExchangeResponse;
import com.bytedance.crypto.engine.ECDHHelper;
import com.bytedance.crypto.engine.KeyPairHelper;
import com.bytedance.crypto.network.ChallengeManager;
import com.bytedance.crypto.network.NetworkConfig;
import com.bytedance.crypto.utils.CryptoConfig;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CloudTransCryptoManager implements ICloudTransCrypto {
    private static final int DATA_MAX_SIZE = 10485760;
    private static final Object LOCK = null;
    private static final String TAG = "CloudTransCryptoManager";
    private static final long UPDATE_SESSION_KEY = 86400000;
    private static volatile CloudTransCryptoManager instance;
    private String alias;
    private final boolean isBDDevice;
    private Context mContext;
    private String mDid;
    private IEnvBridge mEnvBridge;
    private String mSecAppId;
    private long mSessionKeyStartTime;
    private SensitiveData sensitiveData;

    static {
        LOCK = new Object();
    }

    private CloudTransCryptoManager() {
        this.sensitiveData = null;
        this.mContext = null;
        this.mSecAppId = null;
        this.mDid = null;
        this.mEnvBridge = null;
        this.mSessionKeyStartTime = 0;
        boolean r0 = TransUtils.isBDDevice();
        this.isBDDevice = r0;
        LogUtils.i(TAG, "isBDDevice: " + r0);
    }

    private String buildExchangeRequestBody(PrivateKey r3, String r4, String r5, String r6) {
        JSONObject r0 = new JSONObject();
        String r7 = CryptoUtils.ecdsaSign(r5 + r4 + r6, r3);     // Catch: Exception -> L6
        r0.put("app_id", r5);     // Catch: Exception -> L6
        r0.put("did", r4);     // Catch: Exception -> L6
        r0.put("nonce", r6);     // Catch: Exception -> L6
        r0.put("signature", r7);     // Catch: Exception -> L6
        return r0.toString();
    L6:
        e = move-exception;
        throw new CloudTransException("buildExchangeRequestBody failed, " + e.getMessage());
    }

    private void checkInputParams(TransCryptoContext r3, int r4, InputStream r5, OutputStream r6) {
        if (r3 != null) goto L5;
        TransUtils.printErrorInfo(TAG, "TransCryptoContext is null!!");
    L5:
        if (r5 == null) goto L7;
        if (r6 == null) goto L7;
    L9:
        if (TextUtils.isEmpty(r3.getAppId()) == false) goto L11;
    L12:
        TransUtils.printErrorInfo(TAG, "Input appid or did is empty!!");
    L19:
        int r7 = r5.available();     // Catch: Exception -> L15
    L17:
        LogUtils.i(TAG, "Stream xcrypt params check ok, mode:" + r4 + ", app:" + r3.getAppId() + ", data len:" + r7);
        return;
    L15:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Input stream available failed, error:" + e.getMessage());
        r7 = 0;
        goto L17
    L11:
        if (TextUtils.isEmpty(r3.getDid()) == false) goto L19;
    L7:
        TransUtils.printErrorInfo(TAG, "Input stream is null!!");
        goto L9
    }

    private CloudDskBody dskExchangeByCert(DSKExchangeResponse r3, Context r4, String r5, String r6) {
        LogUtils.i(TAG, "DSK exchange by cert.");
        Certificate[] r7 = initSensitive(r4, ChallengeManager.requestChallenge(), r5, r6);
    L10:
        e = move-exception;
        this.sensitiveData = null;
        throw new CloudTransException("dsk exchange by cert failed, ", e);
    L4:
        if (this.isBDDevice == false) goto L6;
        int r8 = r7.length - 1;     // Catch: CloudTransException -> L10
    L7:
        return r3.jsonParsing(r3.dskExchangeByCert(TransUtils.certChainsToPEM(r7, r8)));
    L6:
        r8 = r7.length;     // Catch: CloudTransException -> L10
        goto L7
    }

    private CloudDskBody dskExchangeByTempKey(DSKExchangeResponse r10, Context r11, String r12, String r13) {
        LogUtils.i(TAG, "DSK exchange by keypair.");
        String r14 = ChallengeManager.requestChallenge();
        byte[] r0 = r12.getBytes(StandardCharsets.UTF_8);
        byte[] r1 = r13.getBytes(StandardCharsets.UTF_8);
        Object r2 = LOCK;
        monitor-enter(r2);
        this.sensitiveData.setExtraInfo(TransUtils.concatenate(new byte[][]{new byte[]{(byte) r0.length}, r0, new byte[]{(byte) r1.length}, r1}));     // Catch: Throwable -> L8 IOException -> L10
        monitor-exit(r2);     // Catch: Throwable -> L8
        KeyPair r3 = CryptoUtils.generateECCKeyPair();
        CloudDskBody r15 = r10.jsonParsing(r10.dskExchangeByTempKey(TransUtils.convertToPem(r3.getPublic()), buildExchangeRequestBody(r3.getPrivate(), r12, r13, r14)));
        r15.deviceTempPriKey = r3.getPrivate();
        return r15;
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        throw new CloudTransException("initSensitive failed, DID and appId save failed, ", e);     // Catch: Throwable -> L8
    }

    private void generateSharedSecret(Context r6, CloudDskBody r7) {
        PublicKey r2 = TransUtils.getPublicKeyFromPEM(r7.data.cloudPublicKey);     // Catch: Exception -> L42
    L39:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, generate shared secret failed, error:" + e.getMessage());
    L5:
        if (this.isBDDevice == true) goto L7;
        PrivateKey r8 = KeyPairHelper.loadKeyPair(this.alias).getPrivate();     // Catch: Exception -> L39
    L15:
        byte[] r9 = ECDHHelper.generateSharedSecret(r8, r2);     // Catch: Exception -> L39
    L46:
    L36:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, shared key hash is error", e);
    L17:
        if (CryptoUtils.byteArrayToHexString(TransUtils.sha256(r9)).equals(r7.data.sharedKeyHash) == false) goto L35;
        Object r3 = LOCK;
        monitor-enter(r3);
        this.sensitiveData.setDeviceShareKey(r9);     // Catch: Throwable -> L31
        this.sensitiveData.setKeyVersion(r7.data.keyVersion);     // Catch: Throwable -> L31
        long r10 = r7.data.expectExpiryTime * 1000;     // Catch: Exception -> L28 Throwable -> L31
        LogUtils.d(TAG, "validityPeriod:" + r10);     // Catch: Exception -> L28 Throwable -> L31
        if (r10 < System.currentTimeMillis()) goto L26;
        this.sensitiveData.setKeyValidityPeriod(r10);     // Catch: Exception -> L28 Throwable -> L31
        monitor-exit(r3);     // Catch: Throwable -> L31
        return;
    L26:
        LogUtils.e(TAG, "validityPeriod is error, validityPeriod:" + r10 + " current:" + System.currentTimeMillis());     // Catch: Exception -> L28 Throwable -> L31
        throw new CloudTransException("generateSharedSecret failed, info time is error, validityPeriod is error");     // Catch: Exception -> L28 Throwable -> L31
    L28:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, info cannot be converted to time", e);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L35:
        throw new CloudTransException("generateSharedSecret failed, shared key hash is error");     // Catch: Exception -> L36
    L7:
        if (TransUtils.isDevCertExist(r6) == false) goto L10;
        r9 = ECDHHelper.generateBDSharedSecret(r6, this.alias, CryptoUtils.parseECCPublicKey(r2.getEncoded()));     // Catch: Exception -> L39
        goto L46
    L10:
        if (CloudTransConfig.isAllowTempKeyExchange() == false) goto L13;
        r8 = r7.deviceTempPriKey;     // Catch: Exception -> L39
        goto L15
    L13:
        throw new CloudTransException("generateSharedSecret failed, device cert not exist!");     // Catch: Exception -> L39
    L43:
        throw new CloudTransException("generateSharedSecret failed, info information cannot be converted to public key");
    }

    public static CloudTransCryptoManager getInstance() {
        if (instance != null) goto L15;
        Object r0 = LOCK;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CloudTransCryptoManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private void initInternal(Context r19, String r20, String r21, IEnvBridge r22, boolean r23) {
        Object r13 = LOCK;
        monitor-enter(r13);
        if (r19 == null) goto L106;
    L103:
        th = th;
        Object r15 = r13;
    L108:
        monitor-exit(r15);     // Catch: Throwable -> L107
        throw th;
    L6:
        if (TextUtils.isEmpty(r20) == true) goto L102;
        if (TextUtils.isEmpty(r21) == true) goto L102;
        LogUtils.d(TAG, "init did:" + r21 + " secAppId:" + r20);     // Catch: Throwable -> L103
        if (r22 == null) goto L100;
        this.mContext = r19;     // Catch: Throwable -> L103
        this.mSecAppId = r20;     // Catch: Throwable -> L103
        this.mDid = r21;     // Catch: Throwable -> L103
        this.mEnvBridge = r22;     // Catch: Throwable -> L103
        String r11 = "device_share_key_" + r20;     // Catch: Throwable -> L103
    L95:
        e = e;
    L97:
        this.sensitiveData = null;     // Catch: Throwable -> L107
        throw new CloudTransException("init failed, loadSensitiveDate failed", e);     // Catch: Throwable -> L107
    L13:
        if (this.sensitiveData != null) goto L15;
    L23:
        SensitiveData r14 = new SensitiveData();     // Catch: CloudTransException -> L95 Throwable -> L103
        this.sensitiveData = r14;     // Catch: CloudTransException -> L95 Throwable -> L103
        r15 = r13;
        this.mSessionKeyStartTime = 0;     // Catch: CloudTransException -> L93 Throwable -> L107
        if (r14.getKeyValidityPeriod() != 0) goto L28;
        this.sensitiveData.loadSensitiveDate(r19, r11, r20, this.isBDDevice);     // Catch: CloudTransException -> L93 Throwable -> L107
        this.mSessionKeyStartTime = System.currentTimeMillis();     // Catch: CloudTransException -> L93 Throwable -> L107
    L28:
        printSensitiveDebugInfo(this.sensitiveData);     // Catch: CloudTransException -> L93 Throwable -> L107
        if (TextUtils.isEmpty(parseAppId(this.sensitiveData.getExtraInfo())) == false) goto L32;
    L36:
        if (r23 == false) goto L38;
    L42:
        NetworkConfig.getInstance().init(r22);     // Catch: Throwable -> L107
        DSKExchangeResponse r12 = new DSKExchangeResponse();     // Catch: Throwable -> L107
        if (TransUtils.isDevCertExist(r19) == false) goto L47;
        CloudDskBody r0 = dskExchangeByCert(r12, r19, r21, r20);     // Catch: Throwable -> L107
    L45:
        CloudDskBody r16 = r0;
        if (r16.code == 200) goto L121;
        LogUtils.e(TAG, "code is error, response body: " + r16.bodyJson);     // Catch: Throwable -> L107
        this.sensitiveData = null;     // Catch: Throwable -> L107
        throw new CloudTransException("init failed, response code is " + r16.code);     // Catch: Throwable -> L107
    L121:
        LogUtils.d(TAG, "expectExpiryTime:" + r16.data.expectExpiryTime);     // Catch: Exception -> L81 Throwable -> L107
        if (TransUtils.verifySignature(TransUtils.getPublicKeyFromPEM(r12.getPlublicKey()), TransUtils.concatenate(new byte[][]{r16.data.cloudPublicKey.getBytes(), r16.data.sharedKeyHash.getBytes(), TransUtils.longToByteArray(r16.data.keyVersion), TransUtils.longToByteArray(r16.data.expectExpiryTime)}), r16.data.signature) == false) goto L80;
        generateSharedSecret(r19, r16);     // Catch: CloudTransException -> L76 Throwable -> L107
    L114:
        this.sensitiveData.updateSensitiveDate(r19, r11, r20);     // Catch: Exception -> L69 Throwable -> L107
    L119:
        String r1 = r12.dskExchangeResult(r12.constructBodyJson(r20, r21, r16.data.keyVersion, 1));     // Catch: Exception -> L62 Throwable -> L107
        int r3 = new JSONObject(r1).getInt("code");     // Catch: Exception -> L62 Throwable -> L107
        if (r3 != 200) goto L60;
        monitor-exit(r15);     // Catch: Throwable -> L107
        return;
    L60:
        LogUtils.e(TAG, "code is error, response body: " + r1);     // Catch: Exception -> L62 Throwable -> L107
        throw new CloudTransException("init failed, web response code is " + r3);     // Catch: Exception -> L62 Throwable -> L107
    L62:
        e = move-exception;
        this.sensitiveData.deleteSensitiveDate(r19, r11);     // Catch: Throwable -> L107
        this.sensitiveData = null;     // Catch: Throwable -> L107
        if ((e instanceof CloudTransException) == false) goto L68;
        throw ((CloudTransException) e);     // Catch: Throwable -> L107
    L68:
        throw new CloudTransException("init failed, parse exchange result body failed", e);     // Catch: Throwable -> L107
    L69:
        e = move-exception;
        this.sensitiveData = null;     // Catch: Throwable -> L107
        r12.dskExchangeResult(r12.constructBodyJson(r20, r21, r16.data.keyVersion, 2));     // Catch: Throwable -> L107
        if ((e instanceof CloudTransException) == false) goto L75;
        throw ((CloudTransException) e);     // Catch: Throwable -> L107
    L75:
        throw new CloudTransException("init failed, update sensitive data failed", e);     // Catch: Throwable -> L107
    L76:
        e = move-exception;
        this.sensitiveData = null;     // Catch: Throwable -> L107
        r12.dskExchangeResult(r12.constructBodyJson(r20, r21, r16.data.keyVersion, 2));     // Catch: Throwable -> L107
        throw new CloudTransException("init failed, " + e);     // Catch: Throwable -> L107
    L80:
        throw new CloudTransException("init failed, verifySignature failed.");     // Catch: Exception -> L81 Throwable -> L107
    L81:
        e = move-exception;
        this.sensitiveData = null;     // Catch: Throwable -> L107
        if ((e instanceof CloudTransException) == false) goto L88;
        throw ((CloudTransException) e);     // Catch: Throwable -> L107
    L88:
        throw new CloudTransException("init failed, signature is error", e);     // Catch: Throwable -> L107
    L47:
        if (CloudTransConfig.isAllowTempKeyExchange() == false) goto L91;
        r0 = dskExchangeByTempKey(r12, r19, r21, r20);     // Catch: Throwable -> L107
        goto L45
    L91:
        LogUtils.e(TAG, "init failed, device cert not exist! and temp key exchange is not allowed!");     // Catch: Throwable -> L107
        throw new CloudTransException("init failed, device cert not exist! and temp key exchange is not allowed!");     // Catch: Throwable -> L107
    L38:
        if (isNeedRenegotiated(r21) == true) goto L42;
        LogUtils.i(TAG, "no need to renew");     // Catch: Throwable -> L107
        monitor-exit(r15);     // Catch: Throwable -> L107
        return;
    L32:
        if (TextUtils.equals(r20, parseAppId(this.sensitiveData.getExtraInfo())) == true) goto L36;
        throw new CloudTransException("init failed, appId is not match!");     // Catch: Throwable -> L107
    L93:
        e = e;
        goto L97
    L15:
        if (isSessionKeyExpired() == true) goto L23;
        if (isDidChanged(r21) == true) goto L23;
        if (r23 == true) goto L23;
        printSensitiveDebugInfo(this.sensitiveData);     // Catch: CloudTransException -> L95 Throwable -> L103
        monitor-exit(r13);     // Catch: Throwable -> L103
        return;
    L100:
        throw new CloudTransException("init failed, bridge is null");     // Catch: Throwable -> L107
    L102:
        throw new CloudTransException("init failed, appId or did is empty");     // Catch: Throwable -> L107
    L106:
        throw new CloudTransException("init failed, context is null");     // Catch: Throwable -> L107
    L107:
        th = th;
        goto L108
    }

    private Certificate[] initSensitive(Context r8, String r9, String r10, String r11) {
        this.alias = Process.myUid() + "_" + r8.getPackageName();
        String r12 = r9 + ":" + r10 + ":" + r11;
        byte[] r13 = r10.getBytes(StandardCharsets.UTF_8);
        byte[] r14 = r11.getBytes(StandardCharsets.UTF_8);
        Object r0 = LOCK;
        monitor-enter(r0);
        this.sensitiveData.setExtraInfo(TransUtils.concatenate(new byte[][]{new byte[]{(byte) r13.length}, r13, new byte[]{(byte) r14.length}, r14}));     // Catch: Throwable -> L15 IOException -> L17
        monitor-exit(r0);     // Catch: Throwable -> L15
    L12:
        e = move-exception;
        throw new CloudTransException("initSensitive failed, ", e);
    L7:
        if (this.isBDDevice == false) goto L10;
        KeyPairHelper.deleteBDKey(r8, this.alias);     // Catch: Exception -> L12
        KeyPairHelper.generateECDSABDKeyPair(r8, this.alias);     // Catch: Exception -> L12
        return KeyPairHelper.getBDCertificateChain(r8, this.alias, r12);
    L10:
        KeyPairHelper.deleteKey(this.alias);     // Catch: Exception -> L12
        KeyPairHelper.generateECDSAKeyPair(this.alias, r12);     // Catch: Exception -> L12
        return KeyPairHelper.getCertificateChain(this.alias);
    L17:
        e = move-exception;
        throw new CloudTransException("initSensitive failed, DID and appId save failed, ", e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private boolean isDidChanged(String r3) {
        SensitiveData r0 = this.sensitiveData;
        if (r0 != null) goto L6;
        return true;
    L6:
        return !TextUtils.equals(r3, parseDid(r0.getExtraInfo()));
    }

    private boolean isNeedRenegotiated(String r7) {
        Object r0 = LOCK;
        monitor-enter(r0);
        boolean r8 = isDidChanged(r7);     // Catch: Throwable -> L15
        if (r8 == false) goto L8;
        LogUtils.i(TAG, "did changed!");     // Catch: Throwable -> L15
    L8:
        if (this.sensitiveData.getKeyValidityPeriod() < System.currentTimeMillis()) goto L12;
        if (r8 == true) goto L12;
        boolean r9 = false;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r9;
    L12:
        r9 = true;
    L15:
        th = move-exception;
        throw th;
    }

    private boolean isSessionKeyExpired() {
        if ((System.currentTimeMillis() - this.mSessionKeyStartTime) <= UPDATE_SESSION_KEY) goto L5;
        return true;
    L5:
        return false;
    }

    private String parseAppId(byte[] r5) {
        if (r5 != null) goto L5;
        return "";
    L5:
        if (r5.length < 1) goto L19;
        int r1 = (r5[0] & 255) + 1;
        if (r1 <= r5.length) goto L10;
        return "";
    L10:
        int r2 = r1 + 1;
        if (r2 <= r5.length) goto L13;
        return "";
    L13:
        int r3 = (r5[r1] & 255) + r2;
        if (r3 <= r5.length) goto L17;
        return "";
    L17:
        return new String(Arrays.copyOfRange(r5, r2, r3), StandardCharsets.UTF_8);
    L19:
        return "";
    }

    private String parseDid(byte[] r5) {
        if (r5 != null) goto L5;
        return "";
    L5:
        if (r5.length < 1) goto L13;
        int r1 = (r5[0] & 255) + 1;
        if (r1 <= r5.length) goto L11;
        return "";
    L11:
        return new String(Arrays.copyOfRange(r5, 1, r1), StandardCharsets.UTF_8);
    L13:
        return "";
    }

    private void printSensitiveDebugInfo(SensitiveData r5) {
        if (CryptoConfig.isDebug() == false) goto L8;
        LogUtils.d(TAG, "keyVersion:" + r5.getKeyVersion());
        if (Build.VERSION.SDK_INT < 26) goto L9;
        DateTimeFormatter r0 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        LogUtils.d(TAG, "deviceKey Validity Period:" + r0.format(Instant.ofEpochMilli(r5.getKeyValidityPeriod())));
        LogUtils.d(TAG, "sessionKey Start Time:" + r0.format(Instant.ofEpochMilli(this.mSessionKeyStartTime)));
        LogUtils.d(TAG, "current Time:" + r0.format(Instant.ofEpochMilli(System.currentTimeMillis())));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public byte[] dataDecrypt(byte[] r10) {
        if (r10 == null) goto L25;
        if (r10.length == 0) goto L25;
        Object r0 = LOCK;
        monitor-enter(r0);
        SensitiveData r1 = this.sensitiveData;     // Catch: Throwable -> L21
        if (r1 == null) goto L20;
        if (r1.getDeviceShareKey() == null) goto L20;
        byte[] r11 = DataEncryptHelper.dataDecrypt(r10, this.sensitiveData);     // Catch: CloudTransException -> L14 Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return r11;
    L14:
        e = move-exception;
        if (e.getErrorCode() != (-22)) goto L18;
        LogUtils.e(TAG, "key version mismatch, need to force init!");     // Catch: Throwable -> L21
        initInternal(this.mContext, this.mSecAppId, this.mDid, this.mEnvBridge, true);     // Catch: Throwable -> L21
    L18:
        throw e;     // Catch: Throwable -> L21
    L20:
        throw new CloudTransException("dataDecrypt failed, not completely initialized.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L25:
        throw new CloudTransException("dataDecrypt failed, ciphertext is null");
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public byte[] dataEncrypt(byte[] r3) {
        if (r3 == null) goto L24;
        if (r3.length == 0) goto L24;
        if (r3.length > DATA_MAX_SIZE) goto L22;
        Object r0 = LOCK;
        monitor-enter(r0);
        SensitiveData r1 = this.sensitiveData;     // Catch: Throwable -> L18
        if (r1 == null) goto L17;
        if (r1.getSessionEncryptKey() == null) goto L17;
        byte[] r4 = DataEncryptHelper.dataEncrypt(r3, this.sensitiveData);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r4;
    L17:
        throw new CloudTransException("dataEncrypt failed, not completely initialized.");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        throw new CloudTransException("dataEncrypt failed, plaintext length is too large");
    L24:
        throw new CloudTransException("dataEncrypt failed, plaintext is null");
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void fullFileDecrypt(InputStream r4, OutputStream r5) {
        if (r4 == null) goto L4;
        if (r5 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamDecrypt(this.mContext, this.sensitiveData, true, r4, r5);
        return;
    L4:
        TransUtils.printErrorInfo(TAG, "Input full stream is null!!");
        goto L5
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void fullFileEncrypt(InputStream r9, OutputStream r10) {
        if (r9 == null) goto L4;
        if (r10 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamEncrypt(DataEncryptHelper.initEncryptContextInner(this.mContext, this.mSecAppId, this.mDid, this.sensitiveData, false, true), this.sensitiveData, true, r9, r10);
        return;
    L4:
        TransUtils.printErrorInfo(TAG, "Input stream is null!!");
        goto L5
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void init(Context r7, String r8, String r9, IEnvBridge r10) {
        initInternal(r7, r8, r9, r10, false);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public TransCryptoContext initDecryptContext(Context r1, String r2, String r3, byte[] r4, IEnvBridge r5) {
        init(r1, r2, r3, r5);
        TransCryptoContext r6 = new TransCryptoContext(r1, r3, r2);
    L8:
        e = move-exception;
        throw new CloudTransException("initDecryptContext failed, error:" + e.getMessage());
    L4:
        if (r6.initPageDecryptKey(r4, this.sensitiveData) == false) goto L7;
        return r6;
    L7:
        throw new CloudTransException("initDecryptContext failed, initPageDecryptKey failed");     // Catch: Exception -> L8
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public TransCryptoContext initEncryptContext(Context r7, String r8, String r9, IEnvBridge r10) {
        init(r7, r8, r9, r10);
        return DataEncryptHelper.initEncryptContextInner(r7, r8, r9, this.sensitiveData, true, true);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void pageFileDecrypt(TransCryptoContext r2, InputStream r3, OutputStream r4) {
        checkInputParams(r2, 2, r3, r4);
        DataEncryptHelper.streamDecrypt(r2, r3, r4);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void pageFileEncrypt(TransCryptoContext r2, InputStream r3, OutputStream r4) {
        checkInputParams(r2, 1, r3, r4);
        DataEncryptHelper.streamEncrypt(r2, r3, r4);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void streamDecrypt(InputStream r4, OutputStream r5) {
        if (r4 == null) goto L4;
        if (r5 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamDecrypt(this.mContext, this.sensitiveData, false, r4, r5);
        return;
    L4:
        TransUtils.printErrorInfo(TAG, "Input full stream is null!!");
        goto L5
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public byte[] streamDecryptBytes(TransCryptoContext r3, byte[] r4) {
        if (r3 != null) goto L6;
        TransUtils.printErrorInfo(TAG, "TransCryptoContext is null!!");
    L6:
        if (TextUtils.isEmpty(r3.getAppId()) == false) goto L8;
    L9:
        TransUtils.printErrorInfo(TAG, "Input appid or did is empty!!");
    L10:
        if (r4 == null) goto L16;
        if (r4.length == 0) goto L16;
        return DataEncryptHelper.streamDecryptBytes(r3, r4);
    L16:
        throw new CloudTransException("streamDecryptBytes failed, cipherData is null");
    L8:
        if (TextUtils.isEmpty(r3.getDid()) == false) goto L10;
        goto L9
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public TransCryptoContext streamDecryptFirstBytes(byte[] r3) {
        if (r3 == null) goto L8;
        if (r3.length == 0) goto L8;
        return DataEncryptHelper.streamDecryptFirstBytes(this.mContext, this.sensitiveData, r3);
    L8:
        throw new CloudTransException("streamDecryptFirstBytes failed, cipherData is null");
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void streamEncrypt(InputStream r9, OutputStream r10) {
        if (r9 == null) goto L4;
        if (r10 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamEncrypt(DataEncryptHelper.initEncryptContextInner(this.mContext, this.mSecAppId, this.mDid, this.sensitiveData, false, false), this.sensitiveData, false, r9, r10);
        return;
    L4:
        TransUtils.printErrorInfo(TAG, "Input stream is null!!");
        goto L5
    }
}
