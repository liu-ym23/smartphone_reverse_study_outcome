package com.facebook.imagepipeline.cache;

import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EncodedCountingMemoryCacheFactory {
    public static CountingMemoryCache a(DefaultEncodedMemoryCacheParamsSupplier r5, NoOpMemoryTrimmableRegistry r10) {
        CountingMemoryCache r11 = new CountingMemoryCache(new AnonymousClass1(), r5);
        r10.getClass();
        return r11;
    }
}
