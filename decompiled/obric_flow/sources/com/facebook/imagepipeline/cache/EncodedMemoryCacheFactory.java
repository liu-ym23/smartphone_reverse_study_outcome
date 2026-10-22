package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EncodedMemoryCacheFactory {
    public static InstrumentedMemoryCache a(CountingMemoryCache r5, final NoOpImageCacheStatsTracker r10) {
        r10.getClass();
        return new InstrumentedMemoryCache(r5, new AnonymousClass1(r10));
    }
}
