package com.bytedance.android.ec.core.imagex;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.android.ec.core.imagex.opt.ECImageMultiSizeReuseOpt;
import com.bytedance.android.ec.model.ECImageLoadConfig;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a0 extends com.bytedance.android.ec.core.imagex.opt.t0 {
    public final /* synthetic */ r e;
    public final /* synthetic */ ResizeOptions f;
    public final /* synthetic */ Bitmap.Config g;
    public final /* synthetic */ Postprocessor h;
    public final /* synthetic */ List i;
    public final /* synthetic */ List j;
    public final /* synthetic */ ECImageLoadConfig k;
    public final /* synthetic */ Priority l;
    public final /* synthetic */ String m;
    public final /* synthetic */ ImageRequest n;

    @Override // com.bytedance.android.ec.core.imagex.opt.t0
    public final void e() {
    }

    @Override // com.bytedance.android.ec.core.imagex.opt.t0
    public final ImageRequest g(ImageRequest r1) {
        return r1;
    }

    @Override // com.bytedance.android.ec.core.imagex.opt.t0
    public final List<Uri> c() {
        List<Uri> r0 = this.i;
        if (r0 != null) goto L11;
        List r1 = n0.a(ImageExtensionsKt.l(), this.j, this.f, this.e, this.k, false, 32);
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r11 = r1.iterator();
    L6:
        if (r11.hasNext() == false) goto L9;
        r10.add(ImageExtensionsKt.c((String) r11.next()));
        goto L6
    L9:
        return r10;
    L11:
        return r0;
    }

    @Override // com.bytedance.android.ec.core.imagex.opt.t0
    public final void b(ImageRequestBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        ImageExtensionsKt.F(r10, this.e, this.l, this.m, null, null);
    }

    @Override // com.bytedance.android.ec.core.imagex.opt.t0
    public final void d(com.bytedance.android.ec.core.imagex.opt.t0.c r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        r r0 = this.e;
        ImageRequest[] r1 = r10.a;
        if (r1 != null) goto L5;
        r1 = new ImageRequest[0];
    L5:
        Pair<ImageRequest[], ImageRequest> r11 = ImageExtensionsKt.J(r0, r1, r10.b);
        ImageRequest[] r12 = (ImageRequest[]) r11.component1();
        ImageRequest r13 = (ImageRequest) r11.component2();
        r10.a = r12;
        if (this.n == null) goto L8;
        return;
    L8:
        if (r10.b != null) goto L12;
        r10.b = r13;
        return;
    }

    @Override // com.bytedance.android.ec.core.imagex.opt.t0
    public final void f(ImageRequestBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        ImageExtensionsKt.E(r10, this.e, this.f, this.g, this.h);
    }

    @Override // com.bytedance.android.ec.core.imagex.opt.t0
    public final CloseableStaticBitmap h(CacheKey r10) {
        if (ECImageMultiSizeReuseOpt.e.j() == false) goto L7;
        ECImageMultiSizeReuseOpt.b r11 = ECImageMultiSizeReuseOpt.c(r10);
        if (r11 == null) goto L7;
        return r11.a;
    L7:
        return null;
    }

    public a0(u r1, ResizeOptions r10, Bitmap.Config r11, Postprocessor r12, List r13, List r14, ECImageLoadConfig r15, Priority r16, String r17, ImageRequest r18, List r19) {
        this.e = r1;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r16;
        this.m = r17;
        this.n = r18;
        super(r19);
    }
}
