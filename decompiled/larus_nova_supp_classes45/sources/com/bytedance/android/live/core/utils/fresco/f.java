package com.bytedance.android.live.core.utils.fresco;

import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements AnimatedDrawableBackendProvider {
    public f() {
    }

    public final AnimatedDrawableBackend get(AnimatedImageResult r3, Rect r4) {
        if (e.f != null) goto L6;
        e.f = new AnimatedDrawableUtil();
    L6:
        return new AnimatedDrawableBackendImpl(e.f, r3, r4);
    }
}
