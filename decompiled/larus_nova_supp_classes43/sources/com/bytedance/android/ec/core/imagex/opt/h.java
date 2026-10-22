package com.bytedance.android.ec.core.imagex.opt;

import android.util.SparseArray;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h extends SettableProducerContext {
    public final SparseArray<CacheKey> a;
    public final ImageRequest[] b;
    public final Function1<CacheKey, CloseableStaticBitmap> c;
    public final Function0<Unit> d;

    public h(ImageRequest[] r14, String r15, f r16, Object r17, Function1 r18, Function0 r19) {
        Intrinsics.checkNotNullParameter(r18, "getReuseImage");
        Intrinsics.checkNotNullParameter(r19, "onBuildImageRequest");
        if (r14 == null) goto L5;
        ImageRequest r0 = (ImageRequest) ArraysKt.firstOrNull(r14);
    L6:
        super(r0, r15, r16, r17, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE, false, false, Priority.IMMEDIATE);
        this.b = r14;
        this.c = r18;
        this.d = r19;
        if (r14 == null) goto L9;
        int r1 = r14.length;
    L10:
        this.a = new SparseArray(r1);
        return;
    L9:
        r1 = 3;
        goto L10
    L5:
        r0 = null;
        goto L6
    }
}
