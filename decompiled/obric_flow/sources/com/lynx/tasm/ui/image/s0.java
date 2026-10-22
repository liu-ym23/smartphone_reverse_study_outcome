package com.lynx.tasm.ui.image;

import android.graphics.PorterDuffColorFilter;
import android.os.Looper;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.lynx.tasm.base.TraceEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ no.d f11102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ no.d f11103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v0 f11104c;

    public s0(v0 r5, no.d r10, no.d r11) {
        this.f11104c = r5;
        this.f11102a = r10;
        this.f11103b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TraceEvent.c("LynxImageManager.ImageRequestJobScheduler");
        v0 r5 = this.f11104c;
        PorterDuffColorFilter r10 = r5.I;
        if (r10 == null) goto L5;
        r5.D.g.setColorFilter(r10);
    L5:
        v0 r11 = this.f11104c;
        if (r11.f11125k != null) goto L8;
    L9:
        v0 r12 = this.f11104c;
        DraweeHolder r13 = r12.f11125k;
        if (r13 == null) goto L18;
        if (r12.B == false) goto L16;
        DraweeController r14 = r13.e;
        if ((r14 instanceof AbstractDraweeController) == false) goto L18;
        r12.f11127m.put(((AbstractDraweeController) r14).f7778h, r13);
        goto L18
    L16:
        r12.f11126l = r13;
    L18:
        if (this.f11104c.f11138y == false) goto L22;
        v0 r15 = this.f11104c;
        b1 r16 = r15.f11128n;
        if (r16 == null) goto L22;
        r15.f11129o = r16;
        r15.f11128n = null;
    L22:
        v0 r17 = this.f11104c;
        r17.f11125k = new DraweeHolder(r17.D);
    L23:
        this.f11104c.f11116c.b();
        no.d r18 = this.f11102a;
        v0 r19 = this.f11104c;
        r0 r20 = new r0(this, 1);
        r19.d = r20;
        PipelineDraweeControllerBuilder r21 = r19.f11116c;
        r21.f = r19.H;
        r21.f7796b = null;
        r21.e = r20;
        if (r18 == null) goto L26;
        boolean r22 = true;
    L27:
        r21.g = r22;
        r21.f7797c = this.f11103b;
        r21.f7798h = r19.f11125k.e;
        r21.d = r18;
        r19.f11120f0 = new u0(r19);
        v0 r23 = this.f11104c;
        PipelineDraweeControllerBuilder r24 = r23.f11116c;
        if (r24 == null) goto L30;
        r24.f7737n = r23.f11120f0;
    L30:
        r23.f11125k.a(r24.a());
        this.f11104c.f11116c.b();
        v0 r25 = this.f11104c;
        if (r25.A == false) goto L33;
    L38:
        v0 r26 = this.f11104c;
        if (r26.f11136w == false) goto L46;
        DraweeHierarchy r27 = r26.f11125k.d;
        if (r27 == null) goto L46;
        ScalingUtils.ScaleType r28 = ScalingUtils.ScaleType.f7893a;
        ScaleTypeDrawable r29 = ((GenericDraweeHierarchy) r27).b(2);
        if (Objects.a(r29.d, r28) == true) goto L46;
        r29.d = r28;
        r29.e();
        r29.invalidateSelf();
    L46:
        h r30 = new h(this, 5);
        if (this.f11104c.f11139z == true) goto L49;
    L51:
        v0.f11111j0.post(r30);
    L52:
        TraceEvent.a(0, "LynxImageManager.ImageRequestJobScheduler");
        return;
    L49:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L51;
        r30.run();
        goto L52
    L33:
        if (r25.f11125k.d == null) goto L38;
        r25.D.a(r25.C);
        DraweeHierarchy r31 = this.f11104c.f11125k.d;
        r31.getClass();
        ScalingUtils.ScaleType r32 = e0.b(this.f11104c.g);
        r32.getClass();
        ScaleTypeDrawable r33 = ((GenericDraweeHierarchy) r31).b(2);
        if (Objects.a(r33.d, r32) == true) goto L38;
        r33.d = r32;
        r33.e();
        r33.invalidateSelf();
        goto L38
    L26:
        r22 = false;
        goto L27
    L8:
        if (r11.f11138y == false) goto L23;
        goto L9
    }
}
