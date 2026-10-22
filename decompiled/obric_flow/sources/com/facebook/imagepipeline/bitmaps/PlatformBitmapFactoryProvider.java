package com.facebook.imagepipeline.bitmaps;

import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.PlatformDecoder;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PlatformBitmapFactoryProvider {
    public static PlatformBitmapFactory a(PoolFactory r5, PlatformDecoder r10, CloseableReferenceFactory r11) {
        return new ArtBitmapFactory(r5.a(), r11);
    }
}
