package com.lynx.tasm.ui.image;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.lynx.tasm.base.LLog;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c0 implements h.c {
    public final /* synthetic */ e0 a;

    @Override // com.lynx.tasm.ui.image.h.c
    public final void clear() {
    }

    @Override // com.lynx.tasm.ui.image.h.c
    public final void a() {
        e0 r0 = this.a;
        r0.g(r0.f, r0.g, r0.t, r0.v, r0.u, r0.w);
    }

    @Override // com.lynx.tasm.ui.image.h.c
    public final void d() {
        e0 r0 = this.a;
        if (r0.U == false) goto L5;
        r0.k(r0.f, r0.g, r0.t, r0.v, r0.u, r0.w);
        return;
    L5:
        r0.j(r0.f, r0.g, r0.t, r0.v, r0.u, r0.w);
    }

    @Override // com.lynx.tasm.ui.image.h.c
    public final boolean e() {
        return this.a.B;
    }

    @Override // com.lynx.tasm.ui.image.h.c
    public final void g() {
        CloseableReference<?> r0 = this.a.y;
        if (r0 == null) goto L6;
        r0.close();
        this.a.y = null;
        return;
    }

    @Override // com.lynx.tasm.ui.image.h.c
    public final void markDirty() {
        this.a.i = true;
    }

    public c0(e0 r1) {
        this.a = r1;
    }

    @Override // com.lynx.tasm.ui.image.h.c
    public final void b(List<Postprocessor> r1) {
        this.a.getClass();
    }

    @Override // com.lynx.tasm.ui.image.h.c
    public final ImageRequestBuilder c(Uri r2) {
        return this.a.F.e(r2);
    }

    @Override // com.lynx.tasm.ui.image.h.c
    public final void f(CloseableReference<?> r3) {
        CloseableReference<?> r0 = this.a.y;
        Bitmap r1 = null;
        if (r0 == null) goto L5;
        r0.close();
        this.a.y = null;
    L5:
        e0 r2 = this.a;
        r2.y = r3.clone();
        e0 r4 = this.a;
        if (r4.s == null) goto L20;
        CloseableReference<?> r5 = r4.y;
        if (r5 == null) goto L20;
        Object r6 = r5.get();
        if ((r6 instanceof CloseableBitmap) == false) goto L13;
        r1 = ((CloseableBitmap) r6).getUnderlyingBitmap();
    L15:
        if (r1 != null) goto L17;
    L19:
        LLog.e("LynxImageManager", "onLocalCacheGet error bitmap is null or recycled");
        goto L20
    L17:
        if (r1.isRecycled() == true) goto L19;
        this.a.s.onImageLoadSuccess(r1.getWidth(), r1.getHeight());
        goto L20
    L13:
        if ((r6 instanceof Bitmap) == false) goto L15;
        r1 = (Bitmap) r6;
    L20:
        e0 r7 = this.a;
        r7.q.onCloseableRefReady(r7.y);
    }
}
