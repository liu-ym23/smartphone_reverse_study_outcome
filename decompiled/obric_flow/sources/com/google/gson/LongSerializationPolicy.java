package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum LongSerializationPolicy extends Enum<LongSerializationPolicy> {
    private static final /* synthetic */ LongSerializationPolicy[] $VALUES = null;
    public static final LongSerializationPolicy DEFAULT = null;
    public static final LongSerializationPolicy STRING = null;

    private static /* synthetic */ LongSerializationPolicy[] $values() {
        return new LongSerializationPolicy[]{DEFAULT, STRING};
    }

    static {
        final String r5 = "DEFAULT";
        final int r10 = 0;
        DEFAULT = new AnonymousClass1(r5, r10);
        final String r11 = "STRING";
        final int r12 = 1;
        STRING = new AnonymousClass2(r11, r12);
        $VALUES = $values();
    }

    private LongSerializationPolicy(String r5, int r10) {
        super(r5, r10);
    }

    public static LongSerializationPolicy valueOf(String r5) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, r5);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) $VALUES.clone();
    }

    public abstract JsonElement serialize(Long r5);

    public abstract TypeAdapter<Number> typeAdapter();

    public /* synthetic */ LongSerializationPolicy(String r5, int r10, AnonymousClass1 r11) {
        this(r5, r10);
    }
}
