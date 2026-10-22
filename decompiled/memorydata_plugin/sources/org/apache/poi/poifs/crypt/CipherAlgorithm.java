package org.apache.poi.poifs.crypt;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.EncryptedDocumentException;

/* JADX INFO: loaded from: classes7.dex */
public final enum CipherAlgorithm extends Enum<CipherAlgorithm> {
    private static final /* synthetic */ CipherAlgorithm[] $VALUES = null;
    public static final CipherAlgorithm aes128 = null;
    public static final CipherAlgorithm aes192 = null;
    public static final CipherAlgorithm aes256 = null;
    public static final CipherAlgorithm des = null;
    public static final CipherAlgorithm des3 = null;
    public static final CipherAlgorithm des3_112 = null;
    public static final CipherAlgorithm rc2 = null;
    public static final CipherAlgorithm rc4 = null;
    public static final CipherAlgorithm rsa = null;
    public final int[] allowedKeySize;
    public final int blockSize;
    public final int defaultKeySize;
    public final int ecmaId;
    public final int encryptedVerifierHashLength;
    public final String jceId;
    public final boolean needsBouncyCastle;
    public final CipherProvider provider;
    public final String xmlId;

    static {
        CipherAlgorithm r12 = new CipherAlgorithm("rc4", 0, CipherProvider.rc4, "RC4", 26625, 64, new int[]{40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128}, -1, 20, "RC4", false);
        rc4 = r12;
        CipherAlgorithm r0 = new CipherAlgorithm("aes128", 1, CipherProvider.aes, CryptoConst.ALGORITHM_AES, 26126, 128, new int[]{128}, 16, 32, CryptoConst.ALGORITHM_AES, false);
        aes128 = r0;
        CipherAlgorithm r2 = new CipherAlgorithm("aes192", 2, CipherProvider.aes, CryptoConst.ALGORITHM_AES, 26127, 192, new int[]{192}, 16, 32, CryptoConst.ALGORITHM_AES, false);
        aes192 = r2;
        CipherAlgorithm r5 = new CipherAlgorithm("aes256", 3, CipherProvider.aes, CryptoConst.ALGORITHM_AES, 26128, 256, new int[]{256}, 16, 32, CryptoConst.ALGORITHM_AES, false);
        aes256 = r5;
        CipherAlgorithm r7 = new CipherAlgorithm("rc2", 4, null, "RC2", -1, 128, new int[]{40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128}, 8, 20, "RC2", false);
        rc2 = r7;
        CipherAlgorithm r8 = new CipherAlgorithm("des", 5, null, "DES", -1, 64, new int[]{64}, 8, 32, "DES", false);
        des = r8;
        CipherAlgorithm r9 = new CipherAlgorithm("des3", 6, null, "DESede", -1, 192, new int[]{192}, 8, 32, "3DES", false);
        des3 = r9;
        CipherAlgorithm r6 = new CipherAlgorithm("des3_112", 7, null, "DESede", -1, 128, new int[]{128}, 8, 32, "3DES_112", true);
        des3_112 = r6;
        CipherAlgorithm r4 = new CipherAlgorithm("rsa", 8, null, "RSA", -1, 1024, new int[]{1024, 2048, 3072, 4096}, -1, -1, "", false);
        rsa = r4;
        $VALUES = new CipherAlgorithm[]{r12, r0, r2, r5, r7, r8, r9, r6, r4};
    }

    private CipherAlgorithm(String r1, int r2, CipherProvider r3, String r4, int r5, int r6, int[] r7, int r8, int r9, String r10, boolean r11) {
        super(r1, r2);
        this.provider = r3;
        this.jceId = r4;
        this.ecmaId = r5;
        this.defaultKeySize = r6;
        this.allowedKeySize = (int[]) ZeusTransformUtils.preCheckCast(r7.clone(), int[].class, "com.obric.memorydata.plugin");
        this.blockSize = r8;
        this.encryptedVerifierHashLength = r9;
        this.xmlId = r10;
        this.needsBouncyCastle = r11;
    }

    public static CipherAlgorithm fromEcmaId(int r5) {
        CipherAlgorithm[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        CipherAlgorithm r3 = r0[r2];
        if (r3.ecmaId == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new EncryptedDocumentException("cipher algorithm " + r5 + " not found");
    }

    public static CipherAlgorithm fromXmlId(String r9, int r10) {
        CipherAlgorithm[] r0 = values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L15;
        CipherAlgorithm r4 = r0[r3];
        if (r4.xmlId.equals(r9) == false) goto L13;
        int[] r5 = r4.allowedKeySize;
        int r6 = r5.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L13;
        if (r5[r7] == r10) goto L11;
        r7 = r7 + 1;
        goto L8
    L11:
        return r4;
    L13:
        r3 = r3 + 1;
        goto L3
    L15:
        throw new EncryptedDocumentException("cipher algorithm " + r9 + "/" + r10 + " not found");
    }

    public static CipherAlgorithm valueOf(String r2) {
        return (CipherAlgorithm) ZeusTransformUtils.preCheckCast(Enum.valueOf(CipherAlgorithm.class, r2), CipherAlgorithm.class, "com.obric.memorydata.plugin");
    }

    public static CipherAlgorithm[] values() {
        return (CipherAlgorithm[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CipherAlgorithm[].class, "com.obric.memorydata.plugin");
    }
}
