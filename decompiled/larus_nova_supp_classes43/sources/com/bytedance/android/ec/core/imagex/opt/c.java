package com.bytedance.android.ec.core.imagex.opt;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements com.bytedance.android.ec.core.imagex.common.m {
    public final /* synthetic */ AsyncLoadImage.AsyncLoadImageDataSourceHandler a;
    public final /* synthetic */ ImageRequest b;

    public final Object get() {
        AsyncLoadImage.AsyncLoadImageDataSourceHandler r0 = this.a;
        RequestListener r1 = Fresco.getImagePipelineFactory().getImagePipeline().getRequestListenerForRequest(this.b, this.a.d());
        r0.getClass();
        f r10 = new f(r1);
        AsyncLoadImage.AsyncLoadImageDataSourceHandler r11 = this.a;
        h r12 = new h(r11.e.c, r11.e(), r10, this.a.e.b, new AsyncLoadImage$AsyncLoadImageDataSourceHandler$cacheOrWithAsyncSupplier$1$get$settableProducerContext$1(this.a.e.e), new AsyncLoadImage$AsyncLoadImageDataSourceHandler$cacheOrWithAsyncSupplier$1$get$settableProducerContext$2(this.a));
        return CloseableProducerToDataSourceAdapter.create((AsyncLoadImage.BitmapCacheReuseProducer) AsyncLoadImage.f.getValue(), r12, r10);
    }

    @Override // com.bytedance.android.ec.core.imagex.common.m
    public final ImageRequest getImageRequest() {
        return this.b;
    }

    public c(AsyncLoadImage.AsyncLoadImageDataSourceHandler r1, ImageRequest r10) {
        this.a = r1;
        this.b = r10;
    }
}
