package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum ToNumberPolicy extends Enum<ToNumberPolicy> implements ToNumberStrategy {
    private static final /* synthetic */ ToNumberPolicy[] $VALUES = null;
    public static final ToNumberPolicy BIG_DECIMAL = null;
    public static final ToNumberPolicy DOUBLE = null;
    public static final ToNumberPolicy LAZILY_PARSED_NUMBER = null;
    public static final ToNumberPolicy LONG_OR_DOUBLE = null;

    private static /* synthetic */ ToNumberPolicy[] $values() {
        return new ToNumberPolicy[]{DOUBLE, LAZILY_PARSED_NUMBER, LONG_OR_DOUBLE, BIG_DECIMAL};
    }

    static {
        final String r5 = "DOUBLE";
        final int r10 = 0;
        DOUBLE = new AnonymousClass1(r5, r10);
        final String r11 = "LAZILY_PARSED_NUMBER";
        final int r12 = 1;
        LAZILY_PARSED_NUMBER = new AnonymousClass2(r11, r12);
        final String r13 = "LONG_OR_DOUBLE";
        final int r14 = 2;
        LONG_OR_DOUBLE = new AnonymousClass3(r13, r14);
        final String r15 = "BIG_DECIMAL";
        final int r16 = 3;
        BIG_DECIMAL = new AnonymousClass4(r15, r16);
        $VALUES = $values();
    }

    private ToNumberPolicy(String r5, int r10) {
        super(r5, r10);
    }

    public static ToNumberPolicy valueOf(String r5) {
        return (ToNumberPolicy) Enum.valueOf(ToNumberPolicy.class, r5);
    }

    public static ToNumberPolicy[] values() {
        return (ToNumberPolicy[]) $VALUES.clone();
    }

    public /* synthetic */ ToNumberPolicy(String r5, int r10, AnonymousClass1 r11) {
        this(r5, r10);
    }
}
