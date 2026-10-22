package org.bouncycastle.crypto;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract enum PasswordConverter extends Enum<PasswordConverter> implements CharToByteConverter {
    private static final /* synthetic */ PasswordConverter[] $VALUES = null;
    public static final PasswordConverter ASCII = null;
    public static final PasswordConverter PKCS12 = null;
    public static final PasswordConverter UTF8 = null;

    static {
        final String r1 = "ASCII";
        final int r2 = 0;
        PasswordConverter r0 = new AnonymousClass1(r1, r2);
        ASCII = r0;
        final String r3 = "UTF8";
        final int r4 = 1;
        PasswordConverter r5 = new AnonymousClass2(r3, r4);
        UTF8 = r5;
        final String r6 = "PKCS12";
        final int r7 = 2;
        PasswordConverter r8 = new AnonymousClass3(r6, r7);
        PKCS12 = r8;
        $VALUES = new PasswordConverter[]{r0, r5, r8};
    }

    private PasswordConverter(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ PasswordConverter(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static PasswordConverter valueOf(String r2) {
        return (PasswordConverter) ZeusTransformUtils.preCheckCast(Enum.valueOf(PasswordConverter.class, r2), PasswordConverter.class, "com.obric.memorydata.plugin");
    }

    public static PasswordConverter[] values() {
        return (PasswordConverter[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PasswordConverter[].class, "com.obric.memorydata.plugin");
    }
}
