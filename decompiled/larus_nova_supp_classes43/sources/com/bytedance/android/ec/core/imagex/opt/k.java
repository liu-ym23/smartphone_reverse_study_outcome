package com.bytedance.android.ec.core.imagex.opt;

import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements Supplier<DataSource<CloseableReference<CloseableImage>>>, com.bytedance.android.ec.core.imagex.common.j {
    public final /* synthetic */ l a;
    public final /* synthetic */ l b;

    @Override // com.bytedance.android.ec.core.imagex.common.k
    public final ImageRequest a() {
        return this.b.a();
    }

    @Override // com.bytedance.android.ec.core.imagex.common.i
    public final void b(AbstractDraweeController r10) {
        Intrinsics.checkNotNullParameter(r10, "controller");
        this.b.b(r10);
    }

    @Override // com.bytedance.android.ec.core.imagex.common.j
    public final Supplier<DataSource<CloseableReference<CloseableImage>>> c(ImageRequest[] r10, ImageRequest r11) {
        return this.b.c(r10, r11);
    }

    @Override // com.bytedance.android.ec.core.imagex.common.j
    public final RequestListener d() {
        return this.b.d();
    }

    @Override // com.bytedance.android.ec.core.imagex.common.j
    public final String e() {
        return this.b.e();
    }

    @Override // com.bytedance.android.ec.core.imagex.common.j
    public final boolean f() {
        return this.b.f();
    }

    @Override // com.bytedance.android.ec.core.imagex.common.k
    public final ImageRequest[] g() {
        return this.b.g();
    }

    @Override // com.bytedance.android.ec.core.imagex.common.k
    public final Object getCallerContext() {
        return this.b.getCallerContext();
    }

    @Override // com.bytedance.android.ec.core.imagex.common.j
    public final ImageRequest getImageRequest() {
        return this.b.getImageRequest();
    }

    public final Object get() {
        if (f() == false) goto L8;
        if (i.a(this.a.a) == false) goto L8;
        RequestListener r0 = Fresco.getImagePipelineFactory().getImagePipeline().getRequestListenerForRequest(getImageRequest(), d());
        j r1 = new j(this.a.a, getImageRequest(), e(), r0, getCallerContext());
        BitmapReuseProducer.b.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r0, "listener");
        return CloseableProducerToDataSourceAdapter.create((BitmapReuseProducer) BitmapReuseProducer.a.getValue(), r1, r0);
    L8:
        return (DataSource) c(g(), a()).get();
    }

    public k(l r10) {
        Intrinsics.checkNotNullParameter(r10, "provider");
        this.a = r10;
        this.b = r10;
    }
}
