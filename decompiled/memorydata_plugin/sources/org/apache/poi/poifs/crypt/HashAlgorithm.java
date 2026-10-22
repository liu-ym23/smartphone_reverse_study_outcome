package org.apache.poi.poifs.crypt;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.EncryptedDocumentException;

/* JADX INFO: loaded from: classes7.dex */
public final enum HashAlgorithm extends Enum<HashAlgorithm> {
    private static final /* synthetic */ HashAlgorithm[] $VALUES = null;
    public static final HashAlgorithm md2 = null;
    public static final HashAlgorithm md4 = null;
    public static final HashAlgorithm md5 = null;
    public static final HashAlgorithm none = null;
    public static final HashAlgorithm ripemd128 = null;
    public static final HashAlgorithm ripemd160 = null;
    public static final HashAlgorithm ripemd256 = null;
    public static final HashAlgorithm sha1 = null;
    public static final HashAlgorithm sha224 = null;
    public static final HashAlgorithm sha256 = null;
    public static final HashAlgorithm sha384 = null;
    public static final HashAlgorithm sha512 = null;
    public static final HashAlgorithm whirlpool = null;
    public final int ecmaId;
    public final String ecmaString;
    public final int hashSize;
    public final String jceHmacId;
    public final String jceId;
    public final boolean needsBouncyCastle;
    public final String rsaOid;

    static {
        HashAlgorithm r10 = new HashAlgorithm("none", 0, "", 0, "", 0, "", false, "");
        none = r10;
        HashAlgorithm r0 = new HashAlgorithm("sha1", 1, "SHA-1", 32772, "SHA1", 20, "HmacSHA1", false, "1.3.14.3.2.26");
        sha1 = r0;
        HashAlgorithm r1 = new HashAlgorithm("sha256", 2, CryptoConst.ALGORITHM_SHA256, 32780, "SHA256", 32, "HmacSHA256", false, "2.16.840.1.101.3.4.2.1");
        sha256 = r1;
        HashAlgorithm r2 = new HashAlgorithm("sha384", 3, "SHA-384", 32781, "SHA384", 48, "HmacSHA384", false, "2.16.840.1.101.3.4.2.2");
        sha384 = r2;
        HashAlgorithm r3 = new HashAlgorithm("sha512", 4, "SHA-512", 32782, "SHA512", 64, "HmacSHA512", false, "2.16.840.1.101.3.4.2.3");
        sha512 = r3;
        HashAlgorithm r4 = new HashAlgorithm("md5", 5, CryptoConst.ALGORITHM_MD5, -1, CryptoConst.ALGORITHM_MD5, 16, "HmacMD5", false, "1.2.840.113549.2.5");
        md5 = r4;
        HashAlgorithm r5 = new HashAlgorithm("md2", 6, "MD2", -1, "MD2", 16, "Hmac-MD2", true, "1.2.840.113549.2.2");
        md2 = r5;
        HashAlgorithm r6 = new HashAlgorithm("md4", 7, "MD4", -1, "MD4", 16, "Hmac-MD4", true, "1.2.840.113549.2.4");
        md4 = r6;
        HashAlgorithm r7 = new HashAlgorithm("ripemd128", 8, "RipeMD128", -1, "RIPEMD-128", 16, "HMac-RipeMD128", true, "1.3.36.3.2.2");
        ripemd128 = r7;
        HashAlgorithm r8 = new HashAlgorithm("ripemd160", 9, "RipeMD160", -1, "RIPEMD-160", 20, "HMac-RipeMD160", true, "1.3.36.3.2.1");
        ripemd160 = r8;
        HashAlgorithm r9 = new HashAlgorithm("whirlpool", 10, "Whirlpool", -1, "WHIRLPOOL", 64, "HMac-Whirlpool", true, "1.0.10118.3.0.55");
        whirlpool = r9;
        HashAlgorithm r21 = new HashAlgorithm("sha224", 11, "SHA-224", -1, "SHA224", 28, "HmacSHA224", true, "2.16.840.1.101.3.4.2.4");
        sha224 = r21;
        HashAlgorithm r11 = new HashAlgorithm("ripemd256", 12, "RipeMD256", -1, "RIPEMD-256", 32, "HMac-RipeMD256", true, "1.3.36.3.2.3");
        ripemd256 = r11;
        $VALUES = new HashAlgorithm[]{r10, r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r21, r11};
    }

    private HashAlgorithm(String r1, int r2, String r3, int r4, String r5, int r6, String r7, boolean r8, String r9) {
        super(r1, r2);
        this.jceId = r3;
        this.ecmaId = r4;
        this.ecmaString = r5;
        this.hashSize = r6;
        this.jceHmacId = r7;
        this.needsBouncyCastle = r8;
        this.rsaOid = r9;
    }

    public static HashAlgorithm fromEcmaId(int r5) {
        HashAlgorithm[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        HashAlgorithm r3 = r0[r2];
        if (r3.ecmaId == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new EncryptedDocumentException("hash algorithm not found");
    }

    public static HashAlgorithm fromEcmaId(String r5) {
        HashAlgorithm[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        HashAlgorithm r3 = r0[r2];
        if (r3.ecmaString.equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new EncryptedDocumentException("hash algorithm not found");
    }

    public static HashAlgorithm fromString(String r5) {
        HashAlgorithm[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        HashAlgorithm r3 = r0[r2];
        if (r3.ecmaString.equalsIgnoreCase(r5) == true) goto L10;
        if (r3.jceId.equalsIgnoreCase(r5) == true) goto L10;
        r2 = r2 + 1;
    L10:
        return r3;
    L12:
        throw new EncryptedDocumentException("hash algorithm not found");
    }

    public static HashAlgorithm valueOf(String r2) {
        return (HashAlgorithm) ZeusTransformUtils.preCheckCast(Enum.valueOf(HashAlgorithm.class, r2), HashAlgorithm.class, "com.obric.memorydata.plugin");
    }

    public static HashAlgorithm[] values() {
        return (HashAlgorithm[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HashAlgorithm[].class, "com.obric.memorydata.plugin");
    }
}
