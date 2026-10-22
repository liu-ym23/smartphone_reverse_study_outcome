package com.bytedance.android.live.core.utils.fresco;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Predicate;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class d implements Predicate {
    public /* synthetic */ d() {
    }

    public final boolean apply(Object r1) {
        CacheKey r2 = (CacheKey) r1;
        CountingMemoryCache<CacheKey, CloseableImage> r3 = e.a;
        return true;
    }
}
