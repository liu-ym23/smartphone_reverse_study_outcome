package com.bytedance.android.live.core.utils.fresco;

import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.factory.ExperimentalBitmapAnimationDrawableFactory;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l extends AnimatedFrameCache {
    public final void clear(int r1) {
    }

    public final CloseableReference<CloseableImage> get(int r2) {
        CloseableReference<CloseableImage> r3 = super.get(r2);
        if (r3 != null) goto L5;
    L7:
        return r3;
    L5:
        if (r3.getSharedReference() == null) goto L7;
        r3.getSharedReference().isValid();
        goto L7
    }

    public l(ExperimentalBitmapAnimationDrawableFactory.AnimationFrameCacheKey r1, CountingMemoryCache r2) {
        super(r1, r2);
    }
}
