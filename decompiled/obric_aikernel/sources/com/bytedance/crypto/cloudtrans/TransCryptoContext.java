package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crypto.engine.HKDFHelper;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class TransCryptoContext {
    private static final String TAG = "TransCryptoContext";
    private final String mAppId;
    private final Context mContext;
    private byte[] mDataIv;
    private final String mDid;
    private SecretKey mEncryptKey;
    private byte[] mKeyCipher;
    private byte[] mKeyCipherHash;

    public TransCryptoContext(Context r10, String r11, String r12) {
        this.mContext = r10;
        this.mAppId = r12;
        this.mDid = r11;
    }

    private byte[] buildFullEncDataKeyCipher(byte[] r10, byte[] r11, boolean r12, SensitiveData r13) {
        LogUtils.d(TAG, "fileEncrypt:" + r12);     // Catch: IOException -> L9
        LogUtils.d(TAG, "keyVersion:" + r13.getKeyVersion());     // Catch: IOException -> L9
        LogUtils.d(TAG, "dataIv:" + CryptoUtils.byteArrayToHexString(r11));     // Catch: IOException -> L9
        LogUtils.d(TAG, "keyCipher:" + CryptoUtils.byteArrayToHexString(r10));     // Catch: IOException -> L9
        LogUtils.d(TAG, "salt:" + CryptoUtils.byteArrayToHexString(r13.getHKDFSalt()));     // Catch: IOException -> L9
        if (r12 == false) goto L6;
        int r14 = CryptoConst.TRANS_FILE_FULL_KEY_MAGIC_NUM;
    L7:
        return TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(r14), TransUtils.longToByteArray(r13.getKeyVersion()), TransUtils.intToByteArray(r11.length + r10.length), r11, r10});
    L6:
        r14 = CryptoConst.STREAM_CIPHER_MAGIC_NUM;
    L10:
        throw new CloudTransException("data full encrypt failed, concatenate error.");
    }

    private byte[] buildPageEncDataKeyCipher(byte[] r10, byte[] r11, SensitiveData r12) {
        byte[] r13 = this.mDid.getBytes(StandardCharsets.UTF_8);     // Catch: IOException -> L4
        byte[] r14 = this.mAppId.getBytes(StandardCharsets.UTF_8);     // Catch: IOException -> L4
        this.mKeyCipherHash = CryptoUtils.messageDigest(r10, CryptoConst.ALGORITHM_MD5);     // Catch: IOException -> L4
        return TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(CryptoConst.TRANS_FILE_PAGE_KEY_MAGIC_NUM), TransUtils.intToByteArray(1), new byte[]{(byte) r13.length}, r13, new byte[]{(byte) r14.length}, r14, r12.getHKDFSalt(), TransUtils.longToByteArray(r12.getKeyVersion()), TransUtils.intToByteArray(r11.length + r10.length), r11, r10, this.mKeyCipherHash});
    L5:
        throw new CloudTransException("data page encrypt failed, concatenate error.");
    }

    private static SecretKey constructChaCha20Key(byte[] r10) {
        return new SecretKeySpec(r10, CryptoConst.ALGORITHM_CHACHA20);
    }

    public void deInitKey() {
        this.mEncryptKey = null;
        this.mKeyCipher = new byte[0];
    }

    public String getAppId() {
        return this.mAppId;
    }

    public byte[] getDataIv() {
        return this.mDataIv;
    }

    public String getDid() {
        return this.mDid;
    }

    public SecretKey getEncryptKey() {
        return this.mEncryptKey;
    }

    public byte[] getKeyCipher() {
        return this.mKeyCipher;
    }

    public byte[] getKeyCipherHash() {
        return this.mKeyCipherHash;
    }

    public boolean initEncryptKey(SensitiveData r10, boolean r11, boolean r12) {
        if (this.mContext != null) goto L8;
        String r13 = "Context is null!!";
    L5:
        LogUtils.e(TAG, r13);
        return false;
    L8:
        if (TextUtils.isEmpty(this.mDid) == false) goto L10;
    L31:
        r13 = "did or appid is empty!!";
        goto L5
    L10:
        if (TextUtils.isEmpty(this.mAppId) == true) goto L31;
        if (r10 != null) goto L14;
    L30:
        r13 = "session key is null!!";
        goto L5
    L14:
        if (r10.getSessionEncryptKey() == null) goto L30;
        SecretKey r14 = CryptoUtils.generateSymmetricKey(CryptoConst.ALGORITHM_CHACHA20, 32);
        if (r14 != null) goto L19;
        r13 = "Generate file encrypt key failed!!";
        goto L5
    L19:
        LogUtils.d(TAG, "file key len:" + r14.getEncoded().length);
        byte[] r15 = new byte[12];
        new SecureRandom().nextBytes(r15);
        byte[] r16 = DataEncryptHelper.encrypt(r14.getEncoded(), constructChaCha20Key(r10.getSessionEncryptKey()), r15, CryptoConst.TRANS_AES_KEY_AAD.getBytes());
        if (r16 != null) goto L22;
    L29:
        r13 = "File key encrypt failed!!";
        goto L5
    L22:
        if (r16.length == 0) goto L29;
        if (r11 == false) goto L26;
        this.mKeyCipher = buildPageEncDataKeyCipher(r16, r15, r10);
    L27:
        this.mEncryptKey = r14;
        return true;
    L26:
        this.mKeyCipher = buildFullEncDataKeyCipher(r16, r15, r12, r10);
        goto L27
    }

    public boolean initFullDecryptKey(byte[] r10, byte[] r11, boolean r12, SensitiveData r13) {
        if (this.mContext != null) goto L8;
        String r14 = "Context is null!!";
    L5:
        LogUtils.e(TAG, r14);
        return false;
    L8:
        if (TextUtils.isEmpty(this.mDid) == false) goto L10;
    L51:
        r14 = "did or appid is empty!!";
        goto L5
    L10:
        if (TextUtils.isEmpty(this.mAppId) == true) goto L51;
        LogUtils.i(TAG, "full file key cipher len:" + r10.length);
        byte[] r15 = new byte[4];
        if (r10.length >= 4) goto L17;
        StringBuilder r16 = new StringBuilder();
        r16.append("Input data len is too short! len:");
    L15:
        r16.append(r10.length);
    L16:
        r14 = r16.toString();
        goto L5
    L17:
        System.arraycopy(r10, 0, r15, 0, 4);
        int r17 = CryptoUtils.byteArrayToInt(r15);
        if (r12 == true) goto L20;
    L23:
        if (r12 == true) goto L28;
        if (r17 == 305450445) goto L28;
        r16 = new StringBuilder();
        String r18 = "Cannot parse input stream cipher data! magic:";
    L22:
        r16.append(r18);
        r16.append(r17);
    L28:
        if (r10.length >= 12) goto L31;
        r16 = new StringBuilder();
    L30:
        r16.append("Input data len is too short!! len:");
        goto L15
    L31:
        long r19 = TransUtils.bytesToLong(Arrays.copyOfRange(r10, 4, 12));
        LogUtils.d(TAG, "keyVersion:" + r19);
        if (r19 != r13.getKeyVersion()) goto L35;
        byte[] r110 = HKDFHelper.deriveKey(r13.getDeviceShareKey(), r11, r13.getHKDFInfo());
        SecretKeySpec r111 = new SecretKeySpec(r110, CryptoConst.ALGORITHM_AES);
        LogUtils.d(TAG, "sessionKey:" + CryptoUtils.byteArrayToHexString(r110));
        LogUtils.d(TAG, "salt:" + CryptoUtils.byteArrayToHexString(r11));
    L40:
        if (r10.length >= 16) goto L42;
        r16 = new StringBuilder();
        goto L30
    L42:
        int r112 = TransUtils.bytesToInt(Arrays.copyOfRange(r10, 12, 16));
        if (r10.length >= 28) goto L45;
        r16 = new StringBuilder();
        goto L30
    L45:
        byte[] r113 = Arrays.copyOfRange(r10, 16, 28);
        if (r10.length >= 44) goto L48;
        r16 = new StringBuilder();
        goto L30
    L48:
        byte[] r114 = DataEncryptHelper.decrypt(Arrays.copyOfRange(r10, 28, (r112 + 28) - 12), r111, r113, CryptoConst.TRANS_AES_KEY_AAD.getBytes());
        this.mKeyCipher = r10;
        this.mEncryptKey = constructChaCha20Key(r114);
        return true;
    L35:
        if (r13.isOlidKeyExist() == true) goto L37;
    L50:
        r16 = new StringBuilder();
        r16.append("key version is error, web version: ");
        r16.append(r19);
        r16.append(", current version: ");
        r16.append(r13.getKeyVersion());
        goto L16
    L37:
        if (r19 != r13.getOldKeyVersion()) goto L50;
        LogUtils.w(TAG, "use old key decrypt, key version is " + r19);
        r111 = new SecretKeySpec(HKDFHelper.deriveKey(r13.getOldDeviceShareKey(), r11, r13.getHKDFInfo()), CryptoConst.ALGORITHM_AES);
        goto L40
    L20:
        if (r17 == 305419896) goto L23;
        r16 = new StringBuilder();
        r18 = "Cannot parse input full cipher data! magic:";
        goto L22
    }

    public boolean initPageDecryptKey(byte[] r13, SensitiveData r14) {
        if (this.mContext != null) goto L8;
        String r12 = "Context is null!!";
    L5:
        LogUtils.e(TAG, r12);
        return false;
    L8:
        if (TextUtils.isEmpty(this.mDid) == false) goto L10;
    L64:
        r12 = "did or appid is empty!!";
        goto L5
    L10:
        if (TextUtils.isEmpty(this.mAppId) == true) goto L64;
        if (r13 != null) goto L14;
    L63:
        r12 = "dataKeyCipher is empty!!";
        goto L5
    L14:
        if (r13.length == 0) goto L63;
        LogUtils.i(TAG, "page file key cipher len:" + r13.length);
        byte[] r10 = new byte[4];
        if (r13.length >= 4) goto L21;
        StringBuilder r15 = new StringBuilder();
        r15.append("Input data len is too short! len:");
    L19:
        r15.append(r13.length);
    L20:
        r12 = r15.toString();
        goto L5
    L21:
        System.arraycopy(r13, 0, r10, 0, 4);
        int r11 = CryptoUtils.byteArrayToInt(r10);
        if (r11 == 591751049) goto L25;
        r15 = new StringBuilder();
        r15.append("Cannot parse input cipher data! magic:");
        r15.append(r11);
        goto L20
    L25:
        if (r13.length >= 8) goto L28;
        r15 = new StringBuilder();
    L27:
        r15.append("Input data len is too short!! len:");
        goto L19
    L28:
        byte[] r16 = new byte[4];
        System.arraycopy(r13, 4, r16, 0, 4);
        int r17 = CryptoUtils.byteArrayToInt(r16);
        if (r17 == 1) goto L32;
        r15 = new StringBuilder();
        r15.append("Input cipher data version is wrong! version:");
        r15.append(r17);
        goto L20
    L32:
        if (r13.length >= (r14.getExtraInfo().length + 8)) goto L35;
        r15 = new StringBuilder();
        goto L27
    L35:
        if (Arrays.equals(r14.getExtraInfo(), Arrays.copyOfRange(r13, 8, r14.getExtraInfo().length + 8)) == true) goto L37;
        r15 = new StringBuilder();
        r15.append("dId and appId is error, ");
        r15.append(CryptoUtils.byteArrayToHexString(Arrays.copyOfRange(r13, 8, r14.getExtraInfo().length + 8)));
        goto L20
    L37:
        int r18 = r14.getExtraInfo().length + 8;
        int r19 = r18 + 32;
        if (r13.length >= r19) goto L40;
        r15 = new StringBuilder();
        goto L27
    L40:
        byte[] r20 = Arrays.copyOfRange(r13, r18, r19);
        int r21 = r19 + 8;
        if (r13.length >= r21) goto L43;
        r15 = new StringBuilder();
        goto L27
    L43:
        long r22 = TransUtils.bytesToLong(Arrays.copyOfRange(r13, r19, r21));
        if (r22 != r14.getKeyVersion()) goto L47;
        SecretKeySpec r23 = new SecretKeySpec(HKDFHelper.deriveKey(r14.getDeviceShareKey(), r20, r14.getHKDFInfo()), CryptoConst.ALGORITHM_AES);
    L51:
        int r24 = r21 + 4;
        if (r13.length >= r24) goto L54;
        r15 = new StringBuilder();
        goto L27
    L54:
        int r110 = TransUtils.bytesToInt(Arrays.copyOfRange(r13, r21, r24));
        int r25 = r24 + 12;
        if (r13.length >= r25) goto L57;
        r15 = new StringBuilder();
        goto L27
    L57:
        byte[] r26 = Arrays.copyOfRange(r13, r24, r25);
        if (r13.length >= (r25 + 16)) goto L60;
        r15 = new StringBuilder();
        goto L27
    L60:
        this.mEncryptKey = constructChaCha20Key(DataEncryptHelper.decrypt(Arrays.copyOfRange(r13, r25, (r110 + r25) - 12), r23, r26, CryptoConst.TRANS_AES_KEY_AAD.getBytes()));
        return true;
    L47:
        if (r14.isOlidKeyExist() == true) goto L49;
    L62:
        r15 = new StringBuilder();
        r15.append("key version is error, web version: ");
        r15.append(r22);
        r15.append(", current version: ");
        r15.append(r14.getKeyVersion());
        goto L20
    L49:
        if (r22 != r14.getOldKeyVersion()) goto L62;
        LogUtils.w(TAG, "use old key decrypt, key version is " + r22);
        r23 = new SecretKeySpec(HKDFHelper.deriveKey(r14.getOldDeviceShareKey(), r20, r14.getHKDFInfo()), CryptoConst.ALGORITHM_AES);
        goto L51
    }

    public void setDataIv(byte[] r10) {
        this.mDataIv = r10;
    }
}
