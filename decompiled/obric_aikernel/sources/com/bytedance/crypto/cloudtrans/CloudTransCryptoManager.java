package com.bytedance.crypto.cloudtrans;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
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

/* JADX INFO: loaded from: classes.dex */
public class CloudTransCryptoManager implements ICloudTransCrypto {
    private static final int DATA_MAX_SIZE = 10485760;
    private static final Object LOCK = null;
    private static final String TAG = "CloudTransCryptoManager";
    private static final long UPDATE_SESSION_KEY = 86400000;

    @SuppressLint({"StaticFieldLeak"})
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
        boolean r10 = TransUtils.isBDDevice();
        this.isBDDevice = r10;
        LogUtils.i(TAG, "isBDDevice: " + r10);
    }

    private String buildExchangeRequestBody(PrivateKey r10, String r11, String r12, String r13) {
        JSONObject r14 = new JSONObject();
        String r15 = CryptoUtils.ecdsaSign(r12 + r11 + r13, r10);     // Catch: Exception -> L6
        r14.put("app_id", r12);     // Catch: Exception -> L6
        r14.put("did", r11);     // Catch: Exception -> L6
        r14.put("nonce", r13);     // Catch: Exception -> L6
        r14.put("signature", r15);     // Catch: Exception -> L6
        return r14.toString();
    L6:
        e = move-exception;
        throw new CloudTransException("buildExchangeRequestBody failed, " + e.getMessage());
    }

    private void checkInputParams(TransCryptoContext r10, int r11, InputStream r12, OutputStream r13) {
        if (r10 != null) goto L5;
        TransUtils.printErrorInfo(TAG, "TransCryptoContext is null!!");
    L5:
        if (r12 == null) goto L7;
        if (r13 == null) goto L7;
    L9:
        if (TextUtils.isEmpty(r10.getAppId()) == false) goto L11;
    L12:
        TransUtils.printErrorInfo(TAG, "Input appid or did is empty!!");
    L13:
        int r14 = 0;
        r14 = r12.available();     // Catch: Exception -> L16
    L18:
        LogUtils.i(TAG, "Stream xcrypt params check ok, mode:" + r11 + ", app:" + r10.getAppId() + ", data len:" + r14);
        return;
    L16:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Input stream available failed, error:" + e.getMessage());
        goto L18
    L11:
        if (TextUtils.isEmpty(r10.getDid()) == false) goto L13;
    L7:
        TransUtils.printErrorInfo(TAG, "Input stream is null!!");
        goto L9
    }

    private CloudDskBody dskExchangeByCert(DSKExchangeResponse r10, Context r11, String r12, String r13) {
        LogUtils.i(TAG, "DSK exchange by cert.");
        Certificate[] r14 = initSensitive(r11, ChallengeManager.requestChallenge(), r12, r13);
    L10:
        e = move-exception;
        this.sensitiveData = null;
        throw new CloudTransException("dsk exchange by cert failed, ", e);
    L4:
        if (this.isBDDevice == false) goto L6;
        int r15 = r14.length - 1;     // Catch: CloudTransException -> L10
    L7:
        return r10.jsonParsing(r10.dskExchangeByCert(TransUtils.certChainsToPEM(r14, r15)));
    L6:
        r15 = r14.length;     // Catch: CloudTransException -> L10
        goto L7
    }

    private CloudDskBody dskExchangeByTempKey(DSKExchangeResponse r10, Context r11, String r12, String r13) {
        LogUtils.i(TAG, "DSK exchange by keypair.");
        String r14 = ChallengeManager.requestChallenge();
        byte[] r15 = r12.getBytes(StandardCharsets.UTF_8);
        byte[] r16 = r13.getBytes(StandardCharsets.UTF_8);
        Object r17 = LOCK;
        monitor-enter(r17);
        this.sensitiveData.setExtraInfo(TransUtils.concatenate(new byte[][]{new byte[]{(byte) r15.length}, r15, new byte[]{(byte) r16.length}, r16}));     // Catch: Throwable -> L8 IOException -> L10
        monitor-exit(r17);     // Catch: Throwable -> L8
        KeyPair r18 = CryptoUtils.generateECCKeyPair();
        CloudDskBody r19 = r10.jsonParsing(r10.dskExchangeByTempKey(TransUtils.convertToPem(r18.getPublic()), buildExchangeRequestBody(r18.getPrivate(), r12, r13, r14)));
        r19.deviceTempPriKey = r18.getPrivate();
        return r19;
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        throw new CloudTransException("initSensitive failed, DID and appId save failed, ", e);     // Catch: Throwable -> L8
    }

    private void generateSharedSecret(Context r10, CloudDskBody r11) {
        PublicKey r12 = TransUtils.getPublicKeyFromPEM(r11.data.cloudPublicKey);     // Catch: Exception -> L41
    L38:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, generate shared secret failed, error:" + e.getMessage());
    L4:
        if (this.isBDDevice == true) goto L6;
        PrivateKey r13 = KeyPairHelper.loadKeyPair(this.alias).getPrivate();     // Catch: Exception -> L38
    L14:
        byte[] r14 = ECDHHelper.generateSharedSecret(r13, r12);     // Catch: Exception -> L38
    L44:
    L35:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, shared key hash is error", e);
    L16:
        if (CryptoUtils.byteArrayToHexString(TransUtils.sha256(r14)).equals(r11.data.sharedKeyHash) == false) goto L34;
        Object r15 = LOCK;
        monitor-enter(r15);
        this.sensitiveData.setDeviceShareKey(r14);     // Catch: Throwable -> L30
        this.sensitiveData.setKeyVersion(r11.data.keyVersion);     // Catch: Throwable -> L30
        long r16 = r11.data.expectExpiryTime * 1000;     // Catch: Exception -> L27 Throwable -> L30
        LogUtils.d(TAG, "validityPeriod:" + r16);     // Catch: Exception -> L27 Throwable -> L30
        if (r16 < System.currentTimeMillis()) goto L25;
        this.sensitiveData.setKeyValidityPeriod(r16);     // Catch: Exception -> L27 Throwable -> L30
        monitor-exit(r15);     // Catch: Throwable -> L30
        return;
    L25:
        LogUtils.e(TAG, "validityPeriod is error, validityPeriod:" + r16 + " current:" + System.currentTimeMillis());     // Catch: Exception -> L27 Throwable -> L30
        throw new CloudTransException("generateSharedSecret failed, info time is error, validityPeriod is error");     // Catch: Exception -> L27 Throwable -> L30
    L27:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, info cannot be converted to time", e);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    L34:
        throw new CloudTransException("generateSharedSecret failed, shared key hash is error");     // Catch: Exception -> L35
    L6:
        if (TransUtils.isDevCertExist(r10) == false) goto L9;
        r14 = ECDHHelper.generateBDSharedSecret(r10, this.alias, CryptoUtils.parseECCPublicKey(r12.getEncoded()));     // Catch: Exception -> L38
        goto L44
    L9:
        if (CloudTransConfig.isAllowTempKeyExchange() == false) goto L12;
        r13 = r11.deviceTempPriKey;     // Catch: Exception -> L38
        goto L14
    L12:
        throw new CloudTransException("generateSharedSecret failed, device cert not exist!");     // Catch: Exception -> L38
    L42:
        throw new CloudTransException("generateSharedSecret failed, info information cannot be converted to public key");
    }

    public static CloudTransCryptoManager getInstance() {
        if (instance != null) goto L15;
        Object r10 = LOCK;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CloudTransCryptoManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private void initInternal(Context r11, String r12, String r13, IEnvBridge r14, boolean r15) {
        Object r10 = LOCK;
        monitor-enter(r10);
        if (r11 == null) goto L98;
        if (TextUtils.isEmpty(r12) == true) goto L96;
        if (TextUtils.isEmpty(r13) == true) goto L96;
        LogUtils.d(TAG, "init did:" + r13 + " secAppId:" + r12);     // Catch: Throwable -> L99
        if (r14 == null) goto L94;
        this.mContext = r11;     // Catch: Throwable -> L99
        this.mSecAppId = r12;     // Catch: Throwable -> L99
        this.mDid = r13;     // Catch: Throwable -> L99
        this.mEnvBridge = r14;     // Catch: Throwable -> L99
        String r16 = "device_share_key_" + r12;     // Catch: Throwable -> L99
    L90:
        e = move-exception;
        this.sensitiveData = null;     // Catch: Throwable -> L99
        throw new CloudTransException("init failed, loadSensitiveDate failed", e);     // Catch: Throwable -> L99
    L14:
        if (this.sensitiveData != null) goto L16;
    L24:
        SensitiveData r17 = new SensitiveData();     // Catch: CloudTransException -> L90 Throwable -> L99
        this.sensitiveData = r17;     // Catch: CloudTransException -> L90 Throwable -> L99
        this.mSessionKeyStartTime = 0;     // Catch: CloudTransException -> L90 Throwable -> L99
        if (r17.getKeyValidityPeriod() != 0) goto L27;
        this.sensitiveData.loadSensitiveDate(r11, r16, r12, this.isBDDevice);     // Catch: CloudTransException -> L90 Throwable -> L99
        this.mSessionKeyStartTime = System.currentTimeMillis();     // Catch: CloudTransException -> L90 Throwable -> L99
    L27:
        printSensitiveDebugInfo(this.sensitiveData);     // Catch: CloudTransException -> L90 Throwable -> L99
        if (TextUtils.isEmpty(parseAppId(this.sensitiveData.getExtraInfo())) == false) goto L31;
    L35:
        if (r15 == false) goto L37;
    L41:
        NetworkConfig.getInstance().init(r14);     // Catch: Throwable -> L99
        DSKExchangeResponse r18 = new DSKExchangeResponse();     // Catch: Throwable -> L99
        if (TransUtils.isDevCertExist(r11) == false) goto L45;
        CloudDskBody r19 = dskExchangeByCert(r18, r11, r13, r12);     // Catch: Throwable -> L99
    L49:
        if (r19.code == 200) goto L104;
        LogUtils.e(TAG, "code is error, response body: " + r19.bodyJson);     // Catch: Throwable -> L99
        this.sensitiveData = null;     // Catch: Throwable -> L99
        throw new CloudTransException("init failed, response code is " + r19.code);     // Catch: Throwable -> L99
    L104:
        LogUtils.d(TAG, "expectExpiryTime:" + r19.data.expectExpiryTime);     // Catch: Exception -> L79 Throwable -> L99
        if (TransUtils.verifySignature(TransUtils.getPublicKeyFromPEM(r18.getPlublicKey()), TransUtils.concatenate(new byte[][]{r19.data.cloudPublicKey.getBytes(), r19.data.sharedKeyHash.getBytes(), TransUtils.longToByteArray(r19.data.keyVersion), TransUtils.longToByteArray(r19.data.expectExpiryTime)}), r19.data.signature) == false) goto L78;
        generateSharedSecret(r11, r19);     // Catch: CloudTransException -> L74 Throwable -> L99
        this.sensitiveData.updateSensitiveDate(r11, r16, r12);     // Catch: Exception -> L67 Throwable -> L99
        String r110 = r18.dskExchangeResult(r18.constructBodyJson(r12, r13, r19.data.keyVersion, 1));     // Catch: Exception -> L60 Throwable -> L99
        int r111 = new JSONObject(r110).getInt("code");     // Catch: Exception -> L60 Throwable -> L99
        if (r111 != 200) goto L58;
        monitor-exit(r10);     // Catch: Throwable -> L99
        return;
    L58:
        LogUtils.e(TAG, "code is error, response body: " + r110);     // Catch: Exception -> L60 Throwable -> L99
        throw new CloudTransException("init failed, web response code is " + r111);     // Catch: Exception -> L60 Throwable -> L99
    L60:
        e = move-exception;
        this.sensitiveData.deleteSensitiveDate(r11, r16);     // Catch: Throwable -> L99
        this.sensitiveData = null;     // Catch: Throwable -> L99
        if ((e instanceof CloudTransException) == false) goto L66;
        throw ((CloudTransException) e);     // Catch: Throwable -> L99
    L66:
        throw new CloudTransException("init failed, parse exchange result body failed", e);     // Catch: Throwable -> L99
    L67:
        e = move-exception;
        this.sensitiveData = null;     // Catch: Throwable -> L99
        r18.dskExchangeResult(r18.constructBodyJson(r12, r13, r19.data.keyVersion, 2));     // Catch: Throwable -> L99
        if ((e instanceof CloudTransException) == false) goto L73;
        throw ((CloudTransException) e);     // Catch: Throwable -> L99
    L73:
        throw new CloudTransException("init failed, update sensitive data failed", e);     // Catch: Throwable -> L99
    L74:
        e = move-exception;
        this.sensitiveData = null;     // Catch: Throwable -> L99
        r18.dskExchangeResult(r18.constructBodyJson(r12, r13, r19.data.keyVersion, 2));     // Catch: Throwable -> L99
        throw new CloudTransException("init failed, " + e);     // Catch: Throwable -> L99
    L78:
        throw new CloudTransException("init failed, verifySignature failed.");     // Catch: Exception -> L79 Throwable -> L99
    L79:
        e = move-exception;
        this.sensitiveData = null;     // Catch: Throwable -> L99
        if ((e instanceof CloudTransException) == false) goto L85;
        throw ((CloudTransException) e);     // Catch: Throwable -> L99
    L85:
        throw new CloudTransException("init failed, signature is error", e);     // Catch: Throwable -> L99
    L45:
        if (CloudTransConfig.isAllowTempKeyExchange() == false) goto L88;
        r19 = dskExchangeByTempKey(r18, r11, r13, r12);     // Catch: Throwable -> L99
        goto L49
    L88:
        LogUtils.e(TAG, "init failed, device cert not exist! and temp key exchange is not allowed!");     // Catch: Throwable -> L99
        throw new CloudTransException("init failed, device cert not exist! and temp key exchange is not allowed!");     // Catch: Throwable -> L99
    L37:
        if (isNeedRenegotiated(r13) == true) goto L41;
        LogUtils.i(TAG, "no need to renew");     // Catch: Throwable -> L99
        monitor-exit(r10);     // Catch: Throwable -> L99
        return;
    L31:
        if (TextUtils.equals(r12, parseAppId(this.sensitiveData.getExtraInfo())) == true) goto L35;
        throw new CloudTransException("init failed, appId is not match!");     // Catch: Throwable -> L99
    L16:
        if (isSessionKeyExpired() == true) goto L24;
        if (isDidChanged(r13) == true) goto L24;
        if (r15 == true) goto L24;
        printSensitiveDebugInfo(this.sensitiveData);     // Catch: CloudTransException -> L90 Throwable -> L99
        monitor-exit(r10);     // Catch: Throwable -> L99
        return;
    L94:
        throw new CloudTransException("init failed, bridge is null");     // Catch: Throwable -> L99
    L96:
        throw new CloudTransException("init failed, appId or did is empty");     // Catch: Throwable -> L99
    L98:
        throw new CloudTransException("init failed, context is null");     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        throw th;
    }

    private Certificate[] initSensitive(Context r10, String r11, String r12, String r13) {
        this.alias = Process.myUid() + "_" + r10.getPackageName();
        String r14 = r11 + ":" + r12 + ":" + r13;
        byte[] r15 = r12.getBytes(StandardCharsets.UTF_8);
        byte[] r16 = r13.getBytes(StandardCharsets.UTF_8);
        Object r17 = LOCK;
        monitor-enter(r17);
        this.sensitiveData.setExtraInfo(TransUtils.concatenate(new byte[][]{new byte[]{(byte) r15.length}, r15, new byte[]{(byte) r16.length}, r16}));     // Catch: Throwable -> L15 IOException -> L17
        monitor-exit(r17);     // Catch: Throwable -> L15
    L12:
        e = move-exception;
        throw new CloudTransException("initSensitive failed, ", e);
    L7:
        if (this.isBDDevice == false) goto L10;
        KeyPairHelper.deleteBDKey(r10, this.alias);     // Catch: Exception -> L12
        KeyPairHelper.generateECDSABDKeyPair(r10, this.alias);     // Catch: Exception -> L12
        return KeyPairHelper.getBDCertificateChain(r10, this.alias, r14);
    L10:
        KeyPairHelper.deleteKey(this.alias);     // Catch: Exception -> L12
        KeyPairHelper.generateECDSAKeyPair(this.alias, r14);     // Catch: Exception -> L12
        return KeyPairHelper.getCertificateChain(this.alias);
    L17:
        e = move-exception;
        throw new CloudTransException("initSensitive failed, DID and appId save failed, ", e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private boolean isDidChanged(String r10) {
        SensitiveData r11 = this.sensitiveData;
        if (r11 != null) goto L6;
        return true;
    L6:
        return !TextUtils.equals(r10, parseDid(r11.getExtraInfo()));
    }

    private boolean isNeedRenegotiated(String r10) {
        Object r11 = LOCK;
        monitor-enter(r11);
        boolean r12 = isDidChanged(r10);     // Catch: Throwable -> L15
        if (r12 == false) goto L8;
        LogUtils.i(TAG, "did changed!");     // Catch: Throwable -> L15
    L8:
        if (this.sensitiveData.getKeyValidityPeriod() < System.currentTimeMillis()) goto L12;
        if (r12 == true) goto L12;
        boolean r13 = false;
    L13:
        monitor-exit(r11);     // Catch: Throwable -> L15
        return r13;
    L12:
        r13 = true;
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

    private String parseAppId(byte[] r10) {
        if (r10 != null) goto L5;
    L18:
        return "";
    L5:
        if (r10.length < 1) goto L18;
        int r11 = Byte.toUnsignedInt(r10[0]) + 1;
        if (r11 <= r10.length) goto L10;
        return "";
    L10:
        int r12 = r11 + 1;
        if (r12 <= r10.length) goto L13;
        return "";
    L13:
        int r13 = Byte.toUnsignedInt(r10[r11]) + r12;
        if (r13 <= r10.length) goto L17;
        return "";
    L17:
        return new String(Arrays.copyOfRange(r10, r12, r13), StandardCharsets.UTF_8);
    }

    private String parseDid(byte[] r10) {
        if (r10 != null) goto L5;
    L12:
        return "";
    L5:
        if (r10.length < 1) goto L12;
        int r11 = Byte.toUnsignedInt(r10[0]) + 1;
        if (r11 <= r10.length) goto L11;
        return "";
    L11:
        return new String(Arrays.copyOfRange(r10, 1, r11), StandardCharsets.UTF_8);
    }

    private void printSensitiveDebugInfo(SensitiveData r10) {
        if (CryptoConfig.isDebug() == false) goto L8;
        LogUtils.d(TAG, "keyVersion:" + r10.getKeyVersion());
        if (Build.VERSION.SDK_INT < 26) goto L9;
        DateTimeFormatter r11 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        LogUtils.d(TAG, "deviceKey Validity Period:" + r11.format(Instant.ofEpochMilli(r10.getKeyValidityPeriod())));
        LogUtils.d(TAG, "sessionKey Start Time:" + r11.format(Instant.ofEpochMilli(this.mSessionKeyStartTime)));
        LogUtils.d(TAG, "current Time:" + r11.format(Instant.ofEpochMilli(System.currentTimeMillis())));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    @NonNull
    public byte[] dataDecrypt(byte[] r10) {
        if (r10 == null) goto L25;
        if (r10.length == 0) goto L25;
        Object r11 = LOCK;
        monitor-enter(r11);
        SensitiveData r12 = this.sensitiveData;     // Catch: Throwable -> L21
        if (r12 == null) goto L20;
        if (r12.getDeviceShareKey() == null) goto L20;
        byte[] r13 = DataEncryptHelper.dataDecrypt(r10, this.sensitiveData);     // Catch: CloudTransException -> L14 Throwable -> L21
        monitor-exit(r11);     // Catch: Throwable -> L21
        return r13;
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
    @NonNull
    public byte[] dataEncrypt(byte[] r10) {
        if (r10 == null) goto L24;
        if (r10.length == 0) goto L24;
        if (r10.length > DATA_MAX_SIZE) goto L22;
        Object r11 = LOCK;
        monitor-enter(r11);
        SensitiveData r12 = this.sensitiveData;     // Catch: Throwable -> L18
        if (r12 == null) goto L17;
        if (r12.getSessionEncryptKey() == null) goto L17;
        byte[] r13 = DataEncryptHelper.dataEncrypt(r10, this.sensitiveData);     // Catch: Throwable -> L18
        monitor-exit(r11);     // Catch: Throwable -> L18
        return r13;
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
    public void fullFileDecrypt(InputStream r10, OutputStream r11) {
        if (r10 == null) goto L4;
        if (r11 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamDecrypt(this.mContext, this.sensitiveData, true, r10, r11);
        return;
    L4:
        TransUtils.printErrorInfo(TAG, "Input full stream is null!!");
        goto L5
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void fullFileEncrypt(InputStream r10, OutputStream r11) {
        if (r10 == null) goto L4;
        if (r11 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamEncrypt(DataEncryptHelper.initEncryptContextInner(this.mContext, this.mSecAppId, this.mDid, this.sensitiveData, false, true), this.sensitiveData, true, r10, r11);
        return;
    L4:
        TransUtils.printErrorInfo(TAG, "Input stream is null!!");
        goto L5
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void init(Context r10, String r11, String r12, IEnvBridge r13) {
        initInternal(r10, r11, r12, r13, false);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public TransCryptoContext initDecryptContext(Context r10, String r11, String r12, byte[] r13, IEnvBridge r14) {
        init(r10, r11, r12, r14);
        TransCryptoContext r15 = new TransCryptoContext(r10, r12, r11);
    L8:
        e = move-exception;
        throw new CloudTransException("initDecryptContext failed, error:" + e.getMessage());
    L4:
        if (r15.initPageDecryptKey(r13, this.sensitiveData) == false) goto L7;
        return r15;
    L7:
        throw new CloudTransException("initDecryptContext failed, initPageDecryptKey failed");     // Catch: Exception -> L8
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public TransCryptoContext initEncryptContext(Context r10, String r11, String r12, IEnvBridge r13) {
        init(r10, r11, r12, r13);
        return DataEncryptHelper.initEncryptContextInner(r10, r11, r12, this.sensitiveData, true, true);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void pageFileDecrypt(TransCryptoContext r10, InputStream r11, OutputStream r12) {
        checkInputParams(r10, 2, r11, r12);
        DataEncryptHelper.streamDecrypt(r10, r11, r12);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void pageFileEncrypt(TransCryptoContext r10, InputStream r11, OutputStream r12) {
        checkInputParams(r10, 1, r11, r12);
        DataEncryptHelper.streamEncrypt(r10, r11, r12);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void streamDecrypt(InputStream r10, OutputStream r11) {
        if (r10 == null) goto L4;
        if (r11 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamDecrypt(this.mContext, this.sensitiveData, false, r10, r11);
        return;
    L4:
        TransUtils.printErrorInfo(TAG, "Input full stream is null!!");
        goto L5
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public byte[] streamDecryptBytes(TransCryptoContext r10, byte[] r11) {
        if (r10 != null) goto L6;
        TransUtils.printErrorInfo(TAG, "TransCryptoContext is null!!");
    L6:
        if (TextUtils.isEmpty(r10.getAppId()) == false) goto L8;
    L9:
        TransUtils.printErrorInfo(TAG, "Input appid or did is empty!!");
    L10:
        if (r11 == null) goto L16;
        if (r11.length == 0) goto L16;
        return DataEncryptHelper.streamDecryptBytes(r10, r11);
    L16:
        throw new CloudTransException("streamDecryptBytes failed, cipherData is null");
    L8:
        if (TextUtils.isEmpty(r10.getDid()) == false) goto L10;
        goto L9
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public TransCryptoContext streamDecryptFirstBytes(byte[] r10) {
        if (r10 == null) goto L8;
        if (r10.length == 0) goto L8;
        return DataEncryptHelper.streamDecryptFirstBytes(this.mContext, this.sensitiveData, r10);
    L8:
        throw new CloudTransException("streamDecryptFirstBytes failed, cipherData is null");
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void streamEncrypt(InputStream r10, OutputStream r11) {
        if (r10 == null) goto L4;
        if (r11 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamEncrypt(DataEncryptHelper.initEncryptContextInner(this.mContext, this.mSecAppId, this.mDid, this.sensitiveData, false, false), this.sensitiveData, false, r10, r11);
        return;
    L4:
        TransUtils.printErrorInfo(TAG, "Input stream is null!!");
        goto L5
    }
}
