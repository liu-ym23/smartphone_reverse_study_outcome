package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crypto.engine.HKDFHelper;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TransCryptoContext {
    private static final String TAG = "TransCryptoContext";
    private final String mAppId;
    private final Context mContext;
    private byte[] mDataIv;
    private final String mDid;
    private SecretKey mEncryptKey;
    private byte[] mKeyCipher;
    private byte[] mKeyCipherHash;

    public TransCryptoContext(Context r1, String r2, String r3) {
        this.mContext = r1;
        this.mAppId = r3;
        this.mDid = r2;
    }

    private byte[] buildFullEncDataKeyCipher(byte[] r9, byte[] r10, boolean r11, SensitiveData r12) {
        LogUtils.d(TAG, "fileEncrypt:" + r11);     // Catch: IOException -> L9
        LogUtils.d(TAG, "keyVersion:" + r12.getKeyVersion());     // Catch: IOException -> L9
        LogUtils.d(TAG, "dataIv:" + CryptoUtils.byteArrayToHexString(r10));     // Catch: IOException -> L9
        LogUtils.d(TAG, "keyCipher:" + CryptoUtils.byteArrayToHexString(r9));     // Catch: IOException -> L9
        LogUtils.d(TAG, "salt:" + CryptoUtils.byteArrayToHexString(r12.getHKDFSalt()));     // Catch: IOException -> L9
        if (r11 == false) goto L6;
        int r13 = 305419896;
    L7:
        return TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(r13), TransUtils.longToByteArray(r12.getKeyVersion()), TransUtils.intToByteArray(r10.length + r9.length), r10, r9});
    L6:
        r13 = 313201323;
    L10:
        throw new CloudTransException("data full encrypt failed, concatenate error.");
    }

    private byte[] buildPageEncDataKeyCipher(byte[] r8, byte[] r9, SensitiveData r10) {
        byte[] r0 = this.mDid.getBytes(StandardCharsets.UTF_8);     // Catch: IOException -> L4
        byte[] r1 = this.mAppId.getBytes(StandardCharsets.UTF_8);     // Catch: IOException -> L4
        this.mKeyCipherHash = CryptoUtils.messageDigest(r8, "MD5");     // Catch: IOException -> L4
        return TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(591751049), TransUtils.intToByteArray(1), new byte[]{(byte) r0.length}, r0, new byte[]{(byte) r1.length}, r1, r10.getHKDFSalt(), TransUtils.longToByteArray(r10.getKeyVersion()), TransUtils.intToByteArray(r9.length + r8.length), r9, r8, this.mKeyCipherHash});
    L5:
        throw new CloudTransException("data page encrypt failed, concatenate error.");
    }

    private static SecretKey constructChaCha20Key(byte[] r2) {
        return new SecretKeySpec(r2, "ChaCha20");
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

    public boolean initEncryptKey(SensitiveData r8, boolean r9, boolean r10) {
        if (this.mContext != null) goto L8;
        String r11 = "Context is null!!";
    L5:
        LogUtils.e(TAG, r11);
        return false;
    L8:
        if (TextUtils.isEmpty(this.mDid) == false) goto L10;
    L31:
        r11 = "did or appid is empty!!";
        goto L5
    L10:
        if (TextUtils.isEmpty(this.mAppId) == true) goto L31;
        if (r8 != null) goto L14;
    L30:
        r11 = "session key is null!!";
        goto L5
    L14:
        if (r8.getSessionEncryptKey() == null) goto L30;
        SecretKey r0 = CryptoUtils.generateSymmetricKey("ChaCha20", 32);
        if (r0 != null) goto L19;
        r11 = "Generate file encrypt key failed!!";
        goto L5
    L19:
        LogUtils.d(TAG, "file key len:" + r0.getEncoded().length);
        byte[] r3 = new byte[12];
        new SecureRandom().nextBytes(r3);
        byte[] r4 = DataEncryptHelper.encrypt(r0.getEncoded(), constructChaCha20Key(r8.getSessionEncryptKey()), r3, "cloud_trans_key_v2".getBytes());
        if (r4 != null) goto L22;
    L29:
        r11 = "File key encrypt failed!!";
        goto L5
    L22:
        if (r4.length == 0) goto L29;
        if (r9 == false) goto L26;
        this.mKeyCipher = buildPageEncDataKeyCipher(r4, r3, r8);
    L27:
        this.mEncryptKey = r0;
        return true;
    L26:
        this.mKeyCipher = buildFullEncDataKeyCipher(r4, r3, r10, r8);
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
    L50:
        r14 = "did or appid is empty!!";
        goto L5
    L10:
        if (TextUtils.isEmpty(this.mAppId) == true) goto L50;
        LogUtils.i(TAG, "full file key cipher len:" + r10.length);
        byte[] r3 = new byte[4];
        if (r10.length >= 4) goto L16;
        StringBuilder r15 = new StringBuilder("Input data len is too short! len:");
    L15:
        r15.append(r10.length);
        r14 = r15.toString();
        goto L5
    L16:
        System.arraycopy(r10, 0, r3, 0, 4);
        int r4 = CryptoUtils.byteArrayToInt(r3);
        if (r12 == true) goto L19;
    L23:
        if (r12 == true) goto L28;
        if (r4 == 305450445) goto L28;
        StringBuilder r16 = new StringBuilder("Cannot parse input stream cipher data! magic:");
    L21:
        r16.append(r4);
    L22:
        r14 = r16.toString();
    L28:
        if (r10.length >= 12) goto L30;
        r15 = new StringBuilder("Input data len is too short!! len:");
        goto L15
    L30:
        long r5 = TransUtils.bytesToLong(Arrays.copyOfRange(r10, 4, 12));
        LogUtils.d(TAG, "keyVersion:" + r5);
        if (r5 != r13.getKeyVersion()) goto L34;
        byte[] r17 = HKDFHelper.deriveKey(r13.getDeviceShareKey(), r11, r13.getHKDFInfo());
        SecretKeySpec r0 = new SecretKeySpec(r17, "AES");
        LogUtils.d(TAG, "sessionKey:" + CryptoUtils.byteArrayToHexString(r17));
        LogUtils.d(TAG, "salt:" + CryptoUtils.byteArrayToHexString(r11));
    L39:
        if (r10.length >= 16) goto L41;
        r15 = new StringBuilder("Input data len is too short!! len:");
        goto L15
    L41:
        int r18 = TransUtils.bytesToInt(Arrays.copyOfRange(r10, 12, 16));
        if (r10.length >= 28) goto L44;
        r15 = new StringBuilder("Input data len is too short!! len:");
        goto L15
    L44:
        byte[] r19 = Arrays.copyOfRange(r10, 16, 28);
        if (r10.length >= 44) goto L47;
        r15 = new StringBuilder("Input data len is too short!! len:");
        goto L15
    L47:
        byte[] r110 = DataEncryptHelper.decrypt(Arrays.copyOfRange(r10, 28, (r18 + 28) - 12), r0, r19, "cloud_trans_key_v2".getBytes());
        this.mKeyCipher = r10;
        this.mEncryptKey = constructChaCha20Key(r110);
        return true;
    L34:
        if (r13.isOlidKeyExist() == true) goto L36;
    L49:
        r16 = new StringBuilder("key version is error, web version: ");
        r16.append(r5);
        r16.append(", current version: ");
        r16.append(r13.getKeyVersion());
        goto L22
    L36:
        if (r5 != r13.getOldKeyVersion()) goto L49;
        LogUtils.w(TAG, "use old key decrypt, key version is " + r5);
        r0 = new SecretKeySpec(HKDFHelper.deriveKey(r13.getOldDeviceShareKey(), r11, r13.getHKDFInfo()), "AES");
        goto L39
    L19:
        if (r4 == 305419896) goto L23;
        r16 = new StringBuilder("Cannot parse input full cipher data! magic:");
        goto L21
    }

    public boolean initPageDecryptKey(byte[] r13, SensitiveData r14) {
        if (this.mContext != null) goto L8;
        String r15 = "Context is null!!";
    L5:
        LogUtils.e(TAG, r15);
        return false;
    L8:
        if (TextUtils.isEmpty(this.mDid) == false) goto L10;
    L63:
        r15 = "did or appid is empty!!";
        goto L5
    L10:
        if (TextUtils.isEmpty(this.mAppId) == true) goto L63;
        if (r13 != null) goto L14;
    L62:
        r15 = "dataKeyCipher is empty!!";
        goto L5
    L14:
        if (r13.length == 0) goto L62;
        LogUtils.i(TAG, "page file key cipher len:" + r13.length);
        byte[] r3 = new byte[4];
        if (r13.length >= 4) goto L20;
        StringBuilder r16 = new StringBuilder("Input data len is too short! len:");
    L19:
        r16.append(r13.length);
        r15 = r16.toString();
        goto L5
    L20:
        System.arraycopy(r13, 0, r3, 0, 4);
        int r4 = CryptoUtils.byteArrayToInt(r3);
        if (r4 == 591751049) goto L25;
        StringBuilder r17 = new StringBuilder("Cannot parse input cipher data! magic:");
        r17.append(r4);
    L23:
        r15 = r17.toString();
        goto L5
    L25:
        if (r13.length >= 8) goto L27;
        r16 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L27:
        byte[] r5 = new byte[4];
        System.arraycopy(r13, 4, r5, 0, 4);
        int r0 = CryptoUtils.byteArrayToInt(r5);
        if (r0 == 1) goto L31;
        r17 = new StringBuilder("Input cipher data version is wrong! version:");
        r17.append(r0);
        goto L23
    L31:
        if (r13.length >= (r14.getExtraInfo().length + 8)) goto L34;
        r16 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L34:
        if (Arrays.equals(r14.getExtraInfo(), Arrays.copyOfRange(r13, 8, r14.getExtraInfo().length + 8)) == true) goto L36;
        r15 = "dId and appId is error, " + CryptoUtils.byteArrayToHexString(Arrays.copyOfRange(r13, 8, r14.getExtraInfo().length + 8));
        goto L5
    L36:
        int r1 = r14.getExtraInfo().length + 8;
        int r6 = r1 + 32;
        if (r13.length >= r6) goto L39;
        r16 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L39:
        byte[] r2 = Arrays.copyOfRange(r13, r1, r6);
        int r7 = r6 + 8;
        if (r13.length >= r7) goto L42;
        r16 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L42:
        long r8 = TransUtils.bytesToLong(Arrays.copyOfRange(r13, r6, r7));
        if (r8 != r14.getKeyVersion()) goto L46;
        SecretKeySpec r9 = new SecretKeySpec(HKDFHelper.deriveKey(r14.getDeviceShareKey(), r2, r14.getHKDFInfo()), "AES");
    L50:
        int r10 = r7 + 4;
        if (r13.length >= r10) goto L53;
        r16 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L53:
        int r18 = TransUtils.bytesToInt(Arrays.copyOfRange(r13, r7, r10));
        int r11 = r10 + 12;
        if (r13.length >= r11) goto L56;
        r16 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L56:
        byte[] r12 = Arrays.copyOfRange(r13, r10, r11);
        if (r13.length >= (r11 + 16)) goto L59;
        r16 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L59:
        this.mEncryptKey = constructChaCha20Key(DataEncryptHelper.decrypt(Arrays.copyOfRange(r13, r11, (r18 + r11) - 12), r9, r12, "cloud_trans_key_v2".getBytes()));
        return true;
    L46:
        if (r14.isOlidKeyExist() == true) goto L48;
    L61:
        r17 = new StringBuilder("key version is error, web version: ");
        r17.append(r8);
        r17.append(", current version: ");
        r17.append(r14.getKeyVersion());
        goto L23
    L48:
        if (r8 != r14.getOldKeyVersion()) goto L61;
        LogUtils.w(TAG, "use old key decrypt, key version is " + r8);
        r9 = new SecretKeySpec(HKDFHelper.deriveKey(r14.getOldDeviceShareKey(), r2, r14.getHKDFInfo()), "AES");
        goto L50
    }

    public void setDataIv(byte[] r1) {
        this.mDataIv = r1;
    }
}
