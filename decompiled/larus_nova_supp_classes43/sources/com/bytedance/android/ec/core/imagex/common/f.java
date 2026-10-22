package com.bytedance.android.ec.core.imagex.common;

import com.bytedance.android.ec.core.imagex.ECImageXCompact;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class f implements j {
    public PipelineDraweeController a;
    public final Object b;
    public ImageRequest[] c;
    public ImageRequest d;

    @Override // com.bytedance.android.ec.core.imagex.common.j
    public final RequestListener d() {
        PipelineDraweeController r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRequestListener();
    }

    @Override // com.bytedance.android.ec.core.imagex.common.j
    public final boolean f() {
        int r0 = c.e;
        Intrinsics.checkNotNullParameter(this, "params");
        ImageRequest[] r1 = g();
        if (r1 != null) goto L5;
    L11:
        boolean r10 = true;
    L12:
        if (r10 == true) goto L14;
    L17:
        boolean r11 = true;
    L18:
        if (r11 == true) goto L20;
    L22:
        return false;
    L20:
        if (this.a == null) goto L22;
        return true;
    L14:
        if (a() != null) goto L17;
        r11 = false;
        goto L18
    L5:
        if (r1.length != 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L11;
        r10 = false;
        goto L12
    L7:
        r12 = false;
        goto L8
    }

    @Override // com.bytedance.android.ec.core.imagex.common.j
    public final ImageRequest getImageRequest() {
        ImageRequest[] r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (ImageRequest) ArraysKt.firstOrNull(r0);
    }

    @Override // com.bytedance.android.ec.core.imagex.common.j
    public final String e() {
        return ECImageX.b();
    }

    @Override // com.bytedance.android.ec.core.imagex.common.k
    public final ImageRequest a() {
        return this.d;
    }

    @Override // com.bytedance.android.ec.core.imagex.common.k
    public final ImageRequest[] g() {
        return this.c;
    }

    @Override // com.bytedance.android.ec.core.imagex.common.k
    public final Object getCallerContext() {
        return this.b;
    }

    @Override // com.bytedance.android.ec.core.imagex.common.i
    public final void b(AbstractDraweeController r10) {
        Intrinsics.checkNotNullParameter(r10, "controller");
        if ((r10 instanceof PipelineDraweeController) == true) goto L5;
        r10 = null;
    L5:
        this.a = (PipelineDraweeController) r10;
    }

    @Override // com.bytedance.android.ec.core.imagex.common.j
    public final Supplier<DataSource<CloseableReference<CloseableImage>>> c(ImageRequest[] r10, ImageRequest r11) {
        if (f() == false) goto L6;
        ECImageXCompact r0 = ECImageXCompact.c;
        PipelineDraweeController r1 = this.a;
        r0.getClass();
        return ECImageXCompact.c(r1, r10, r11);
    L6:
        NullPointerException r12 = new NullPointerException("BitmapReuseSupplier: is invalid");
        com.bytedance.crash.d.c(r12);
        return DataSources.getFailedDataSourceSupplier(r12);
    }

    public f(Object r1, ImageRequest[] r10, ImageRequest r11) {
        this.b = r1;
        this.c = r10;
        this.d = r11;
    }
}
