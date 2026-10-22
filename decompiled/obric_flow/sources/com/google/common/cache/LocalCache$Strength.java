package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
abstract enum LocalCache$Strength extends Enum<LocalCache$Strength> {
    public static final LocalCache$Strength SOFT = null;
    public static final LocalCache$Strength STRONG = null;
    public static final LocalCache$Strength WEAK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocalCache$Strength[] f8682a = null;

    static {
        final String r5 = "STRONG";
        final int r10 = 0;
        LocalCache$Strength r11 = new AnonymousClass1(r5, r10);
        STRONG = r11;
        final String r12 = "SOFT";
        final int r13 = 1;
        LocalCache$Strength r14 = new AnonymousClass2(r12, r13);
        SOFT = r14;
        final String r15 = "WEAK";
        final int r16 = 2;
        LocalCache$Strength r17 = new AnonymousClass3(r15, r16);
        WEAK = r17;
        f8682a = new LocalCache$Strength[]{r11, r14, r17};
    }

    public LocalCache$Strength(String r5, int r10, n r11) {
        super(r5, r10);
    }

    public static LocalCache$Strength valueOf(String r5) {
        return (LocalCache$Strength) Enum.valueOf(LocalCache$Strength.class, r5);
    }

    public static LocalCache$Strength[] values() {
        return (LocalCache$Strength[]) f8682a.clone();
    }

    public abstract com.google.common.base.p defaultEquivalence();

    public abstract <K, V> g0 referenceValue(LocalCache$Segment<K, V> r5, v0 r10, V r11, int r12);
}
