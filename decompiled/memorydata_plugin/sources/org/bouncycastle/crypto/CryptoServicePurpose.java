package org.bouncycastle.crypto;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum CryptoServicePurpose extends Enum<CryptoServicePurpose> {
    private static final /* synthetic */ CryptoServicePurpose[] $VALUES = null;
    public static final CryptoServicePurpose AGREEMENT = null;
    public static final CryptoServicePurpose ANY = null;
    public static final CryptoServicePurpose AUTHENTICATION = null;
    public static final CryptoServicePurpose DECRYPTION = null;
    public static final CryptoServicePurpose ENCRYPTION = null;
    public static final CryptoServicePurpose KEYGEN = null;
    public static final CryptoServicePurpose PRF = null;
    public static final CryptoServicePurpose SIGNING = null;
    public static final CryptoServicePurpose VERIFICATION = null;
    public static final CryptoServicePurpose VERIFYING = null;

    static {
        CryptoServicePurpose r0 = new CryptoServicePurpose("AGREEMENT", 0);
        AGREEMENT = r0;
        CryptoServicePurpose r1 = new CryptoServicePurpose("ENCRYPTION", 1);
        ENCRYPTION = r1;
        CryptoServicePurpose r3 = new CryptoServicePurpose("DECRYPTION", 2);
        DECRYPTION = r3;
        CryptoServicePurpose r5 = new CryptoServicePurpose("KEYGEN", 3);
        KEYGEN = r5;
        CryptoServicePurpose r7 = new CryptoServicePurpose("SIGNING", 4);
        SIGNING = r7;
        CryptoServicePurpose r9 = new CryptoServicePurpose("VERIFYING", 5);
        VERIFYING = r9;
        CryptoServicePurpose r11 = new CryptoServicePurpose("AUTHENTICATION", 6);
        AUTHENTICATION = r11;
        CryptoServicePurpose r13 = new CryptoServicePurpose("VERIFICATION", 7);
        VERIFICATION = r13;
        CryptoServicePurpose r15 = new CryptoServicePurpose("PRF", 8);
        PRF = r15;
        CryptoServicePurpose r14 = new CryptoServicePurpose("ANY", 9);
        ANY = r14;
        $VALUES = new CryptoServicePurpose[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
    }

    private CryptoServicePurpose(String r1, int r2) {
        super(r1, r2);
    }

    public static CryptoServicePurpose valueOf(String r2) {
        return (CryptoServicePurpose) ZeusTransformUtils.preCheckCast(Enum.valueOf(CryptoServicePurpose.class, r2), CryptoServicePurpose.class, "com.obric.memorydata.plugin");
    }

    public static CryptoServicePurpose[] values() {
        return (CryptoServicePurpose[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CryptoServicePurpose[].class, "com.obric.memorydata.plugin");
    }
}
