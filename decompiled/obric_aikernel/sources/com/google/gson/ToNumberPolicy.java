package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum ToNumberPolicy extends Enum<ToNumberPolicy> implements p {
    private static final /* synthetic */ ToNumberPolicy[] $VALUES = null;
    public static final ToNumberPolicy BIG_DECIMAL = null;
    public static final ToNumberPolicy DOUBLE = null;
    public static final ToNumberPolicy LAZILY_PARSED_NUMBER = null;
    public static final ToNumberPolicy LONG_OR_DOUBLE = null;

    static {
        final String r10 = "DOUBLE";
        final int r11 = 0;
        ToNumberPolicy r12 = new AnonymousClass1(r10, r11);
        DOUBLE = r12;
        final String r13 = "LAZILY_PARSED_NUMBER";
        final int r14 = 1;
        ToNumberPolicy r15 = new AnonymousClass2(r13, r14);
        LAZILY_PARSED_NUMBER = r15;
        final String r16 = "LONG_OR_DOUBLE";
        final int r17 = 2;
        ToNumberPolicy r18 = new AnonymousClass3(r16, r17);
        LONG_OR_DOUBLE = r18;
        final String r19 = "BIG_DECIMAL";
        final int r20 = 3;
        ToNumberPolicy r21 = new AnonymousClass4(r19, r20);
        BIG_DECIMAL = r21;
        $VALUES = new ToNumberPolicy[]{r12, r15, r18, r21};
    }

    private ToNumberPolicy(String r10, int r11) {
        super(r10, r11);
    }

    /* synthetic */ ToNumberPolicy(String r10, int r11, AnonymousClass1 r12) {
        this(r10, r11);
    }

    public static ToNumberPolicy valueOf(String r10) {
        return (ToNumberPolicy) Enum.valueOf(ToNumberPolicy.class, r10);
    }

    public static ToNumberPolicy[] values() {
        return (ToNumberPolicy[]) $VALUES.clone();
    }

    @Override // com.google.gson.p
    public abstract /* synthetic */ Number readNumber(i6.a r10);
}
