package com.bytedance.android.ec.core.imagex.opt;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;", "p1", "Lcom/facebook/cache/common/CacheKey;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AsyncLoadImage$AsyncLoadImageDataSourceHandler$cacheOrWithAsyncSupplier$1$get$settableProducerContext$1 extends FunctionReferenceImpl implements Function1<CacheKey, CloseableStaticBitmap> {
    public AsyncLoadImage$AsyncLoadImageDataSourceHandler$cacheOrWithAsyncSupplier$1$get$settableProducerContext$1(t0.d r10) {
        super(1, r10, t0.d.class, "getReuseImage", "getReuseImage$ec_core_saasRelease(Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;", 0);
    }

    public final CloseableStaticBitmap invoke(CacheKey r10) {
        return ((t0.d) ((CallableReference) this).receiver).c.h(r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((CacheKey) r1);
    }
}
