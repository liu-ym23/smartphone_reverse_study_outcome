package com.bytedance.android.live.core.utils.fresco;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends BasePostprocessor {
    public final String getName() {
        return "com.bytedance.android.live.core.utils.fresco.FrescoDrawProcessor";
    }

    public final CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey("fresco_drawable_draw_processor");
    }

    public b() {
    }

    public final CloseableReference<Bitmap> process(Bitmap r1, PlatformBitmapFactory r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        r1.prepareToDraw();
        return super.process(r1, r2);
    }
}
