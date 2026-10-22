package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;

/* JADX INFO: loaded from: classes2.dex */
public class BitmapMemoryCacheGetProducer extends BitmapMemoryCacheProducer {
    public BitmapMemoryCacheGetProducer(InstrumentedMemoryCache r5, DefaultCacheKeyFactory r10, ThreadHandoffProducer r11) {
        super(r5, r10, r11);
    }

    @Override // com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer
    public final Consumer a(Consumer r5, BitmapMemoryCacheKey r10, boolean r11) {
        return r5;
    }

    @Override // com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer
    public final String b() {
        return "BitmapMemoryCacheGetProducer";
    }

    @Override // com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer
    public final String a() {
        return "pipe_ui";
    }
}
