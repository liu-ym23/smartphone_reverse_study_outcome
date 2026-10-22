package com.bytedance.android.live.core.utils.fresco;

import android.content.Context;
import com.facebook.cache.common.CacheKey;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final void b(AnimatedDrawable2 r2) {
        CountingMemoryCache<CacheKey, CloseableImage> r0 = e.a;
        e.b(r2, new DropFramesFrameScheduler(r2.getAnimationBackend()));
    }

    public static final void c(AnimatedDrawable2 r2) {
        CountingMemoryCache<CacheKey, CloseableImage> r0 = e.a;
        if (r2 != null) goto L5;
        m r1 = null;
    L6:
        if (r1 == null) goto L9;
        e.b(r2, r1);
        return;
    L9:
        return;
    L5:
        r1 = new m(r2.getAnimationBackend());
        goto L6
    }

    public static void a(PipelineDraweeController r1, Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "sourceUri");
        e.a(r2, r1, r3, false);
    }
}
