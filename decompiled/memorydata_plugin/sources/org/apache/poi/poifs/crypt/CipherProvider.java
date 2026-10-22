package org.apache.poi.poifs.crypt;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.EncryptedDocumentException;

/* JADX INFO: loaded from: classes7.dex */
public final enum CipherProvider extends Enum<CipherProvider> {
    private static final /* synthetic */ CipherProvider[] $VALUES = null;
    public static final CipherProvider aes = null;
    public static final CipherProvider rc4 = null;
    public final String cipherProviderName;
    public final int ecmaId;
    public final String jceId;

    static {
        CipherProvider r6 = new CipherProvider("rc4", 0, "RC4", 1, "Microsoft Base Cryptographic Provider v1.0");
        rc4 = r6;
        CipherProvider r0 = new CipherProvider("aes", 1, CryptoConst.ALGORITHM_AES, 24, "Microsoft Enhanced RSA and AES Cryptographic Provider");
        aes = r0;
        $VALUES = new CipherProvider[]{r6, r0};
    }

    private CipherProvider(String r1, int r2, String r3, int r4, String r5) {
        super(r1, r2);
        this.jceId = r3;
        this.ecmaId = r4;
        this.cipherProviderName = r5;
    }

    public static CipherProvider fromEcmaId(int r5) {
        CipherProvider[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        CipherProvider r3 = r0[r2];
        if (r3.ecmaId == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new EncryptedDocumentException("cipher provider not found");
    }

    public static CipherProvider valueOf(String r2) {
        return (CipherProvider) ZeusTransformUtils.preCheckCast(Enum.valueOf(CipherProvider.class, r2), CipherProvider.class, "com.obric.memorydata.plugin");
    }

    public static CipherProvider[] values() {
        return (CipherProvider[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CipherProvider[].class, "com.obric.memorydata.plugin");
    }
}
