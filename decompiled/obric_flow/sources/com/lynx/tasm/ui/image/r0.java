package com.lynx.tasm.ui.image;

import android.graphics.drawable.Animatable;
import android.os.Handler;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 extends BaseControllerListener {
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public /* synthetic */ r0(Object r5, int r10) {
        this.d = r10;
        this.e = r5;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void a(String r11, ImageInfo r12, Animatable r13) {
        switch(this.d) {
            case 0: goto L16;
            default: goto L5;
        };
    L16:
        v0 r5 = (v0) this.e;
        Handler r10 = v0.f11111j0;
        r5.l();
        if (((v0) this.e).f11138y == false) goto L19;
        v0.f11111j0.post(new v(2, this, r11));
    L19:
        v0 r14 = (v0) this.e;
        r14.W = r13;
        r14.f11115b0 = false;
        if ((r12 instanceof CloseableStaticBitmap) == false) goto L28;
        CloseableStaticBitmap r15 = (CloseableStaticBitmap) r12;
        r14.f11113a0 = r15.g;
        if (((v0) this.e).f11138y == true) goto L26;
        v0 r16 = (v0) this.e;
        CloseableReference r17 = r16.X;
        if (r17 == null) goto L27;
        r17.close();
        r16.X = null;
    L27:
        v0 r18 = (v0) this.e;
        r18.X = r15.e();
        goto L28
    L26:
        v0 r19 = (v0) this.e;
        r19.Y = r19.X;
    L28:
        v0 r110 = (v0) this.e;
        CloseableReference r20 = r110.N;
        if (r20 == null) goto L31;
        r20.close();
        r110.N = null;
    L31:
        v0 r111 = (v0) this.e;
        r111.E.h(r111.e, r111.f, r12, r13, r111.G, true, r111.g0, r111.f11132r);
        return;
    L5:
        if ((r12 instanceof CloseableStaticBitmap) == false) goto L12;
        v0 r21 = ((s0) this.e).f11104c;
        DraweeHierarchy r22 = r21.f11125k.d;
        if (r22 == null) goto L12;
        int r23 = r21.T;
        FadeDrawable r24 = ((GenericDraweeHierarchy) r22).f;
        r24.f7840k = r23;
        if (r24.f7839j != 1) goto L12;
        r24.f7839j = 0;
    L12:
        if (((s0) this.e).f11104c.f11138y == false) goto L14;
        v0.f11111j0.post(new v(3, this, r11));
    L14:
        v0 r112 = ((s0) this.e).f11104c;
        r112.E.h(r112.e, r112.f, r12, r13, r112.G, true, r112.g0, r112.f11132r);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void b(String r5, Throwable r10) {
        switch(this.d) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        v0.e(((s0) this.e).f11104c, r10);
        return;
    L6:
        v0 r11 = (v0) this.e;
        r11.f11115b0 = false;
        r11.l();
        v0.e(r11, r10);
    }
}
