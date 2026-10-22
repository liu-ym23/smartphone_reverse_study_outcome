package com.lynx.tasm.ui.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxError;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends BaseControllerListener {
    public final /* synthetic */ FrescoInlineImageShadowNode d;

    public o(FrescoInlineImageShadowNode r5) {
        this.d = r5;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void a(String r5, ImageInfo r10, Animatable r11) {
        if ((r10 instanceof CloseableStaticBitmap) == false) goto L27;
        CloseableReference r12 = ((CloseableStaticBitmap) r10).e();
        if (r12 != null) goto L8;
        this.d.D("reference null");
        this.d.k().f(this.d.R, "image", new LynxError(30102, "Failed to load image，the reason is get null bitmap reference from response", "", "error"));
        return;
    L8:
        monitor-enter(r12);
        Object r13 = r12.f7671b.d();     // Catch: Throwable -> L23
        monitor-exit(r12);     // Catch: Throwable -> L23
        Bitmap r14 = (Bitmap) r13;
        if (r14 != null) goto L15;
        this.d.D("bitmap null");
        this.d.k().f(this.d.R, "image", new LynxError(30102, "Failed to load image，the reason is get null bitmap from response", "", "error"));
        return;
    L15:
        FrescoInlineImageShadowNode r15 = this.d;
        if (r15.W == true) goto L18;
    L21:
        this.d.B(r14.getWidth(), r14.getHeight());
        return;
    L18:
        if (r15.V == null) goto L20;
        LynxLog.b(2, "FrescoInlineImageShadowNode", "close reference mRef = " + r15.V.hashCode());
        r15.V.close();
        r15.V = null;
    L20:
        this.d.V = r12;
        LynxLog.b(2, "FrescoInlineImageShadowNode", "clone reference mRef = " + this.d.V.hashCode());
    L23:
        th = move-exception;
        throw th;
    L27:
        if ((r11 instanceof AnimatedDrawable2) == false) goto L32;
        AnimatedDrawable2 r16 = (AnimatedDrawable2) r11;
        int r17 = r16.getIntrinsicWidth();
        int r18 = r16.getIntrinsicHeight();
        r16.setAnimationBackend(new no.b(r16.getAnimationBackend()));
        this.d.B(r17, r18);
        oo.g.a(r16);
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void b(String r5, Throwable r10) {
        if (r10 != null) goto L4;
        String r11 = "unknown";
    L5:
        FrescoInlineImageShadowNode r12 = this.d;
        r12.D(r11);
        LynxError r13 = new LynxError(mh.e.a(mh.e.b(r10)), "Failed to load image", "", "error");
        r13.g = null;
        r13.f10000o = r11;
        r12.k().f(r12.R, "image", r13);
        return;
    L4:
        r11 = r10.getMessage();
        goto L5
    }
}
