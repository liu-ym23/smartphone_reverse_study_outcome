package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crypto.bridge.IEnvBridge;
import com.bytedance.crypto.bridge.ILogBridge;
import com.bytedance.crypto.cloudtrans.response.DSKExchangeResponse;
import com.bytedance.crypto.engine.ECDHHelper;
import com.bytedance.crypto.engine.KeyPairHelper;
import com.bytedance.crypto.network.ChallengeManager;
import com.bytedance.crypto.network.NetworkConfig;
import com.bytedance.crypto.utils.CryptoConfig;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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
        this.mContext = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
        this.mSecAppId = null;
        this.mDid = null;
        this.mEnvBridge = null;
        this.mSessionKeyStartTime = 0;
        boolean r0 = TransUtils.isBDDevice();
        this.isBDDevice = r0;
        LogUtils.i(TAG, "isBDDevice: " + r0);
    }

    private String buildExchangeRequestBody(PrivateKey r2, String r3, String r4, String r5) {
        PrivateKey r1 = (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r2, PrivateKey.class, "com.obric.memorydata.plugin");
        JSONObject r6 = new JSONObject();
        String r7 = CryptoUtils.ecdsaSign(r4 + r3 + r5, r1);     // Catch: Exception -> L6
        r6.put("app_id", r4);     // Catch: Exception -> L6
        r6.put("did", r3);     // Catch: Exception -> L6
        r6.put("nonce", r5);     // Catch: Exception -> L6
        r6.put("signature", r7);     // Catch: Exception -> L6
        return r6.toString();
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
    L13:
        int r7 = 0;
        r7 = r5.available();     // Catch: Exception -> L16
    L18:
        LogUtils.i(TAG, "Stream xcrypt params check ok, mode:" + r4 + ", app:" + r3.getAppId() + ", data len:" + r7);
        return;
    L16:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Input stream available failed, error:" + e.getMessage());
        goto L18
    L11:
        if (TextUtils.isEmpty(r3.getDid()) == false) goto L13;
    L7:
        TransUtils.printErrorInfo(TAG, "Input stream is null!!");
        goto L9
    }

    private CloudDskBody dskExchangeByCert(DSKExchangeResponse r3, Context r4, String r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        LogUtils.i(TAG, "DSK exchange by cert.");
        Certificate[] r8 = initSensitive(r7, ChallengeManager.requestChallenge(), r5, r6);
    L10:
        e = move-exception;
        throw newInitFailure("dsk exchange by cert failed, ", e);
    L4:
        if (this.isBDDevice == false) goto L6;
        int r9 = r8.length - 1;     // Catch: CloudTransException -> L10
    L7:
        return r3.jsonParsing(r3.dskExchangeByCert(TransUtils.certChainsToPEM(r8, r9)));
    L6:
        r9 = r8.length;     // Catch: CloudTransException -> L10
        goto L7
    }

    private CloudDskBody dskExchangeByTempKey(DSKExchangeResponse r10, Context r11, String r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        LogUtils.i(TAG, "DSK exchange by keypair.");
        String r15 = ChallengeManager.requestChallenge();
        byte[] r0 = r12.getBytes(StandardCharsets.UTF_8);
        byte[] r1 = r13.getBytes(StandardCharsets.UTF_8);
        Object r2 = LOCK;
        monitor-enter(r2);
        this.sensitiveData.setExtraInfo(TransUtils.concatenate(new byte[][]{new byte[]{(byte) r0.length}, r0, new byte[]{(byte) r1.length}, r1}));     // Catch: Throwable -> L8 IOException -> L10
        monitor-exit(r2);     // Catch: Throwable -> L8
        KeyPair r3 = CryptoUtils.generateECCKeyPair();
        CloudDskBody r9 = r10.jsonParsing(r10.dskExchangeByTempKey(TransUtils.convertToPem(r3.getPublic()), buildExchangeRequestBody(r3.getPrivate(), r12, r13, r15)));
        r9.deviceTempPriKey = r3.getPrivate();
        return r9;
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        throw newInitFailure("initSensitive failed, DID and appId save failed, ", e);     // Catch: Throwable -> L8
    }

    private void generateSharedSecret(Context r5, CloudDskBody r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        PublicKey r0 = TransUtils.getPublicKeyFromPEM(r6.data.cloudPublicKey);     // Catch: Exception -> L42
    L39:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, generate shared secret failed, error:" + e.getMessage());
    L5:
        if (this.isBDDevice == true) goto L7;
        PrivateKey r8 = KeyPairHelper.loadKeyPair(this.alias).getPrivate();     // Catch: Exception -> L39
    L15:
        byte[] r9 = ECDHHelper.generateSharedSecret(r8, r0);     // Catch: Exception -> L39
    L45:
    L36:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, shared key hash is error", e);
    L17:
        if (CryptoUtils.byteArrayToHexString(TransUtils.sha256(r9)).equals(r6.data.sharedKeyHash) == false) goto L35;
        Object r1 = LOCK;
        monitor-enter(r1);
        this.sensitiveData.setDeviceShareKey(r9);     // Catch: Throwable -> L31
        this.sensitiveData.setKeyVersion(r6.data.keyVersion);     // Catch: Throwable -> L31
        long r10 = r6.data.expectExpiryTime * 1000;     // Catch: Exception -> L28 Throwable -> L31
        LogUtils.d(TAG, "validityPeriod:" + r10);     // Catch: Exception -> L28 Throwable -> L31
        if (r10 < System.currentTimeMillis()) goto L26;
        this.sensitiveData.setKeyValidityPeriod(r10);     // Catch: Exception -> L28 Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
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
        if (TransUtils.isDevCertExist(r7) == false) goto L10;
        r9 = ECDHHelper.generateBDSharedSecret(r7, this.alias, CryptoUtils.parseECCPublicKey(r0.getEncoded()));     // Catch: Exception -> L39
        goto L45
    L10:
        if (CloudTransConfig.isAllowTempKeyExchange() == false) goto L13;
        r8 = r6.deviceTempPriKey;     // Catch: Exception -> L39
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

    private void initInternal(Context r17, String r18, String r19, IEnvBridge r20, boolean r21) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin");
        IEnvBridge r2 = (IEnvBridge) ZeusTransformUtils.wrapperContextForParams(r20, IEnvBridge.class, "com.obric.memorydata.plugin");
        Object r9 = LOCK;
        monitor-enter(r9);
        if (r8 == null) goto L105;
        if (TextUtils.isEmpty(r18) == true) goto L103;
        if (TextUtils.isEmpty(r19) == true) goto L103;
        LogUtils.d(TAG, "init did:" + r19 + " secAppId:" + r18);     // Catch: Throwable -> L106
        if (r2 == null) goto L101;
        this.mContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");     // Catch: Throwable -> L106
        this.mSecAppId = r18;     // Catch: Throwable -> L106
        this.mDid = r19;     // Catch: Throwable -> L106
        this.mEnvBridge = r2;     // Catch: Throwable -> L106
        String r10 = "device_share_key_" + r18;     // Catch: Throwable -> L106
        boolean r5 = !isSensitiveDataReady();     // Catch: CloudTransException -> L97 Throwable -> L106
        boolean r7 = isSessionKeyExpired();     // Catch: CloudTransException -> L97 Throwable -> L106
        boolean r11 = isDidChanged(r19);     // Catch: CloudTransException -> L97 Throwable -> L106
        SensitiveData r12 = this.sensitiveData;     // Catch: CloudTransException -> L97 Throwable -> L106
        if (r12 == null) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == true) goto L18;
    L20:
        boolean r13 = false;
    L21:
        LogUtils.i(TAG, "init state, secAppId:" + r18 + " forceInit:" + r21 + " sensitiveDataNotReady:" + r5 + " sessionKeyExpired:" + r7 + " didChanged:" + r11 + " hasSensitiveData:" + r14 + " hasSessionEncryptKey:" + r13);     // Catch: CloudTransException -> L97 Throwable -> L106
        if (r5 == true) goto L30;
        if (r7 == true) goto L30;
        if (r11 == true) goto L30;
        if (r21 == true) goto L30;
        printSensitiveDebugInfo(this.sensitiveData);     // Catch: CloudTransException -> L97 Throwable -> L106
        monitor-exit(r9);     // Catch: Throwable -> L106
        return;
    L30:
        SensitiveData r6 = new SensitiveData();     // Catch: CloudTransException -> L97 Throwable -> L106
        this.sensitiveData = r6;     // Catch: CloudTransException -> L97 Throwable -> L106
        this.mSessionKeyStartTime = 0;     // Catch: CloudTransException -> L97 Throwable -> L106
        if (r6.getKeyValidityPeriod() != 0) goto L33;
        this.sensitiveData.loadSensitiveDate(r8, r10, r18, this.isBDDevice);     // Catch: CloudTransException -> L97 Throwable -> L106
        this.mSessionKeyStartTime = System.currentTimeMillis();     // Catch: CloudTransException -> L97 Throwable -> L106
    L33:
        printSensitiveDebugInfo(this.sensitiveData);     // Catch: CloudTransException -> L97 Throwable -> L106
        if (TextUtils.isEmpty(parseAppId(this.sensitiveData.getExtraInfo())) == false) goto L37;
    L41:
        if (r21 == false) goto L43;
    L47:
        NetworkConfig.getInstance().init(r2);     // Catch: Throwable -> L106
        DSKExchangeResponse r15 = new DSKExchangeResponse();     // Catch: Throwable -> L106
        if (TransUtils.isDevCertExist(r8) == false) goto L52;
        CloudDskBody r0 = dskExchangeByCert(r15, r8, r19, r18);     // Catch: Throwable -> L106
    L50:
        CloudDskBody r3 = r0;
        if (r3.code == 200) goto L113;
        LogUtils.e(TAG, "code is error, response body: " + r3.bodyJson);     // Catch: Throwable -> L106
        throw newInitFailure("init failed, response code is " + r3.code);     // Catch: Throwable -> L106
    L113:
        LogUtils.d(TAG, "expectExpiryTime:" + r3.data.expectExpiryTime);     // Catch: Exception -> L86 Throwable -> L106
        if (TransUtils.verifySignature(TransUtils.getPublicKeyFromPEM(r15.getPlublicKey()), TransUtils.concatenate(new byte[][]{r3.data.cloudPublicKey.getBytes(), r3.data.sharedKeyHash.getBytes(), TransUtils.longToByteArray(r3.data.keyVersion), TransUtils.longToByteArray(r3.data.expectExpiryTime)}), r3.data.signature) == false) goto L85;
        generateSharedSecret(r8, r3);     // Catch: CloudTransException -> L81 Throwable -> L106
        this.sensitiveData.updateSensitiveDate(r8, r10, r18);     // Catch: Exception -> L74 Throwable -> L106
    L111:
        String r1 = r15.dskExchangeResult(r15.constructBodyJson(r18, r19, r3.data.keyVersion, 1));     // Catch: Exception -> L67 Throwable -> L106
        int r4 = new JSONObject(r1).getInt("code");     // Catch: Exception -> L67 Throwable -> L106
        if (r4 != 200) goto L65;
        monitor-exit(r9);     // Catch: Throwable -> L106
        return;
    L65:
        LogUtils.e(TAG, "code is error, response body: " + r1);     // Catch: Exception -> L67 Throwable -> L106
        throw new CloudTransException("init failed, web response code is " + r4);     // Catch: Exception -> L67 Throwable -> L106
    L67:
        e = move-exception;
        this.sensitiveData.deleteSensitiveDate(r8, r10);     // Catch: Throwable -> L106
        if (ZeusTransformUtils.instanceOf(e, CloudTransException.class) == false) goto L73;
        throw newInitFailure(e.getMessage(), e.getCause());     // Catch: Throwable -> L106
    L73:
        throw newInitFailure("init failed, parse exchange result body failed", e);     // Catch: Throwable -> L106
    L74:
        e = move-exception;
        r15.dskExchangeResult(r15.constructBodyJson(r18, r19, r3.data.keyVersion, 2));     // Catch: Throwable -> L106
        if (ZeusTransformUtils.instanceOf(e, CloudTransException.class) == false) goto L80;
        throw ((CloudTransException) ZeusTransformUtils.preCheckCast(e, CloudTransException.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L106
    L80:
        throw newInitFailure("init failed, update sensitive data failed", e);     // Catch: Throwable -> L106
    L81:
        e = move-exception;
        r15.dskExchangeResult(r15.constructBodyJson(r18, r19, r3.data.keyVersion, 2));     // Catch: Throwable -> L106
        throw newInitFailure("init failed, " + e);     // Catch: Throwable -> L106
    L85:
        throw newInitFailure("init failed, verifySignature failed.");     // Catch: Exception -> L86 Throwable -> L106
    L86:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, CloudTransException.class) == false) goto L92;
        throw ((CloudTransException) ZeusTransformUtils.preCheckCast(e, CloudTransException.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L106
    L92:
        throw newInitFailure("init failed, signature is error", e);     // Catch: Throwable -> L106
    L52:
        if (CloudTransConfig.isAllowTempKeyExchange() == false) goto L95;
        r0 = dskExchangeByTempKey(r15, r8, r19, r18);     // Catch: Throwable -> L106
        goto L50
    L95:
        LogUtils.e(TAG, "init failed, device cert not exist! and temp key exchange is not allowed!");     // Catch: Throwable -> L106
        throw newInitFailure("init failed, device cert not exist! and temp key exchange is not allowed!");     // Catch: Throwable -> L106
    L43:
        if (isNeedRenegotiated(r19) == true) goto L47;
        LogUtils.i(TAG, "no need to renew");     // Catch: Throwable -> L106
        monitor-exit(r9);     // Catch: Throwable -> L106
        return;
    L37:
        if (TextUtils.equals(r18, parseAppId(this.sensitiveData.getExtraInfo())) == true) goto L41;
        throw newInitFailure("init failed, appId is not match!");     // Catch: Throwable -> L106
    L18:
        if (r12.getSessionEncryptKey() == null) goto L20;
        r13 = true;
        goto L21
    L15:
        r14 = false;
    L97:
        e = move-exception;
        throw newInitFailure("init failed, loadSensitiveDate failed", e);     // Catch: Throwable -> L106
    L101:
        throw new CloudTransException("init failed, bridge is null");     // Catch: Throwable -> L106
    L103:
        throw new CloudTransException("init failed, appId or did is empty");     // Catch: Throwable -> L106
    L105:
        throw new CloudTransException("init failed, context is null");     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        throw th;
    }

    private Certificate[] initSensitive(Context r8, String r9, String r10, String r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        this.alias = Process.myUid() + "_" + r12.getPackageName();
        String r13 = r9 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r10 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r11;
        byte[] r14 = r10.getBytes(StandardCharsets.UTF_8);
        byte[] r15 = r11.getBytes(StandardCharsets.UTF_8);
        Object r0 = LOCK;
        monitor-enter(r0);
        this.sensitiveData.setExtraInfo(TransUtils.concatenate(new byte[][]{new byte[]{(byte) r14.length}, r14, new byte[]{(byte) r15.length}, r15}));     // Catch: Throwable -> L15 IOException -> L17
        monitor-exit(r0);     // Catch: Throwable -> L15
    L12:
        e = move-exception;
        throw new CloudTransException("initSensitive failed, ", e);
    L7:
        if (this.isBDDevice == false) goto L10;
        KeyPairHelper.deleteBDKey(r12, this.alias);     // Catch: Exception -> L12
        KeyPairHelper.generateECDSABDKeyPair(r12, this.alias);     // Catch: Exception -> L12
        return KeyPairHelper.getBDCertificateChain(r12, this.alias, r13);
    L10:
        KeyPairHelper.deleteKey(this.alias);     // Catch: Exception -> L12
        KeyPairHelper.generateECDSAKeyPair(this.alias, r13);     // Catch: Exception -> L12
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

    private boolean isNeedRenegotiated(String r6) {
        Object r0 = LOCK;
        monitor-enter(r0);
        boolean r7 = isDidChanged(r6);     // Catch: Throwable -> L15
        if (r7 == false) goto L8;
        LogUtils.i(TAG, "did changed!");     // Catch: Throwable -> L15
    L8:
        if (this.sensitiveData.getKeyValidityPeriod() < System.currentTimeMillis()) goto L12;
        if (r7 == true) goto L12;
        boolean r5 = false;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r5;
    L12:
        r5 = true;
    L15:
        th = move-exception;
        throw th;
    }

    private boolean isSensitiveDataReady() {
        SensitiveData r0 = this.sensitiveData;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getSessionEncryptKey() == null) goto L7;
        return true;
    }

    private boolean isSessionKeyExpired() {
        if ((System.currentTimeMillis() - this.mSessionKeyStartTime) <= 86400000) goto L5;
        return true;
    L5:
        return false;
    }

    private CloudTransException newInitFailure(String r2) {
        this.sensitiveData = null;
        return new CloudTransException(r2);
    }

    private CloudTransException newInitFailure(String r2, Throwable r3) {
        this.sensitiveData = null;
        return new CloudTransException(r2, r3);
    }

    private String parseAppId(byte[] r4) {
        if (r4 != null) goto L5;
    L18:
        return "";
    L5:
        if (r4.length < 1) goto L18;
        int r0 = Byte.toUnsignedInt(r4[0]) + 1;
        if (r0 <= r4.length) goto L10;
        return "";
    L10:
        int r1 = r0 + 1;
        if (r1 <= r4.length) goto L13;
        return "";
    L13:
        int r2 = Byte.toUnsignedInt(r4[r0]) + r1;
        if (r2 <= r4.length) goto L17;
        return "";
    L17:
        return new String(Arrays.copyOfRange(r4, r1, r2), StandardCharsets.UTF_8);
    }

    private String parseDid(byte[] r4) {
        if (r4 != null) goto L5;
    L12:
        return "";
    L5:
        if (r4.length < 1) goto L12;
        int r0 = Byte.toUnsignedInt(r4[0]) + 1;
        if (r0 <= r4.length) goto L11;
        return "";
    L11:
        return new String(Arrays.copyOfRange(r4, 1, r0), StandardCharsets.UTF_8);
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
        byte[] r9 = DataEncryptHelper.dataDecrypt(r10, this.sensitiveData);     // Catch: CloudTransException -> L14 Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return r9;
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
        byte[] r2 = DataEncryptHelper.dataEncrypt(r3, this.sensitiveData);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r2;
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
    public void fullFileDecrypt(InputStream r3, OutputStream r4) {
        if (r3 == null) goto L4;
        if (r4 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamDecrypt(this.mContext, this.sensitiveData, true, r3, r4);
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
    public void init(Context r9, String r10, String r11, IEnvBridge r12) {
        initInternal((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), r10, r11, (IEnvBridge) ZeusTransformUtils.wrapperContextForParams(r12, IEnvBridge.class, "com.obric.memorydata.plugin"), false);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public TransCryptoContext initDecryptContext(Context r3, String r4, String r5, byte[] r6, IEnvBridge r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        init(r8, r4, r5, (IEnvBridge) ZeusTransformUtils.wrapperContextForParams(r7, IEnvBridge.class, "com.obric.memorydata.plugin"));
        TransCryptoContext r9 = new TransCryptoContext(r8, r5, r4);
    L8:
        e = move-exception;
        throw new CloudTransException("initDecryptContext failed, error:" + e.getMessage());
    L4:
        if (r9.initPageDecryptKey(r6, this.sensitiveData) == false) goto L7;
        return r9;
    L7:
        throw new CloudTransException("initDecryptContext failed, initPageDecryptKey failed");     // Catch: Exception -> L8
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public TransCryptoContext initEncryptContext(Context r9, String r10, String r11, IEnvBridge r12) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        init(r2, r10, r11, (IEnvBridge) ZeusTransformUtils.wrapperContextForParams(r12, IEnvBridge.class, "com.obric.memorydata.plugin"));
        return DataEncryptHelper.initEncryptContextInner(r2, r10, r11, this.sensitiveData, true, true);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void initLog(ILogBridge r2) {
        LogUtils.init((ILogBridge) ZeusTransformUtils.wrapperContextForParams(r2, ILogBridge.class, "com.obric.memorydata.plugin"));
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
    public void streamDecrypt(InputStream r3, OutputStream r4) {
        if (r3 == null) goto L4;
        if (r4 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamDecrypt(this.mContext, this.sensitiveData, false, r3, r4);
        return;
    L4:
        TransUtils.printErrorInfo(TAG, "Input full stream is null!!");
        goto L5
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public byte[] streamDecryptBytes(TransCryptoContext r2, byte[] r3) {
        if (r2 != null) goto L6;
        TransUtils.printErrorInfo(TAG, "TransCryptoContext is null!!");
    L6:
        if (TextUtils.isEmpty(r2.getAppId()) == false) goto L8;
    L9:
        TransUtils.printErrorInfo(TAG, "Input appid or did is empty!!");
    L10:
        if (r3 == null) goto L16;
        if (r3.length == 0) goto L16;
        return DataEncryptHelper.streamDecryptBytes(r2, r3);
    L16:
        throw new CloudTransException("streamDecryptBytes failed, cipherData is null");
    L8:
        if (TextUtils.isEmpty(r2.getDid()) == false) goto L10;
        goto L9
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public TransCryptoContext streamDecryptFirstBytes(byte[] r2) {
        if (r2 == null) goto L8;
        if (r2.length == 0) goto L8;
        return DataEncryptHelper.streamDecryptFirstBytes(this.mContext, this.sensitiveData, r2);
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
