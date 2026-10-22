package com.bytedance.android.ec.core.imagex.opt;

import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements com.bytedance.android.ec.core.imagex.common.j {
    public final CloseableStaticBitmap a;
    public final /* synthetic */ com.bytedance.android.ec.core.imagex.common.j b;

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

    public l(CloseableStaticBitmap r10, com.bytedance.android.ec.core.imagex.common.f r11) {
        Intrinsics.checkNotNullParameter(r10, "image");
        Intrinsics.checkNotNullParameter(r11, "supplierContext");
        this.b = r11;
        this.a = r10;
    }
}
