package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum LongSerializationPolicy extends Enum<LongSerializationPolicy> {
    private static final /* synthetic */ LongSerializationPolicy[] $VALUES = null;
    public static final LongSerializationPolicy DEFAULT = null;
    public static final LongSerializationPolicy STRING = null;

    static {
        final String r10 = "DEFAULT";
        final int r11 = 0;
        LongSerializationPolicy r12 = new AnonymousClass1(r10, r11);
        DEFAULT = r12;
        final String r13 = "STRING";
        final int r14 = 1;
        LongSerializationPolicy r15 = new AnonymousClass2(r13, r14);
        STRING = r15;
        $VALUES = new LongSerializationPolicy[]{r12, r15};
    }

    private LongSerializationPolicy(String r10, int r11) {
        super(r10, r11);
    }

    /* synthetic */ LongSerializationPolicy(String r10, int r11, AnonymousClass1 r12) {
        this(r10, r11);
    }

    public static LongSerializationPolicy valueOf(String r10) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, r10);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) $VALUES.clone();
    }

    public abstract i serialize(Long r10);
}
