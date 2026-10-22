package com.google.common.hash;

/* JADX INFO: loaded from: classes2.dex */
abstract enum BloomFilterStrategies extends Enum<BloomFilterStrategies> implements BloomFilter.Strategy {
    public static final BloomFilterStrategies MURMUR128_MITZ_32 = null;
    public static final BloomFilterStrategies MURMUR128_MITZ_64 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BloomFilterStrategies[] f9255a = null;

    static {
        final String r5 = "MURMUR128_MITZ_32";
        final int r10 = 0;
        BloomFilterStrategies r11 = new AnonymousClass1(r5, r10);
        MURMUR128_MITZ_32 = r11;
        final String r12 = "MURMUR128_MITZ_64";
        final int r13 = 1;
        BloomFilterStrategies r14 = new AnonymousClass2(r12, r13);
        MURMUR128_MITZ_64 = r14;
        f9255a = new BloomFilterStrategies[]{r11, r14};
    }

    public BloomFilterStrategies(String r5, int r10, AnonymousClass1 r11) {
        super(r5, r10);
    }

    public static BloomFilterStrategies valueOf(String r5) {
        return (BloomFilterStrategies) Enum.valueOf(BloomFilterStrategies.class, r5);
    }

    public static BloomFilterStrategies[] values() {
        return (BloomFilterStrategies[]) f9255a.clone();
    }

    @Override // com.google.common.hash.BloomFilter.Strategy
    public abstract /* synthetic */ boolean mightContain(Object r5, Funnel r10, int r11, h r12);

    @Override // com.google.common.hash.BloomFilter.Strategy
    public abstract /* synthetic */ boolean put(Object r5, Funnel r10, int r11, h r12);
}
