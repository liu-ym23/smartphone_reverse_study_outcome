package com.lynx.tasm.ui.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends com.lynx.tasm.behavior.ui.text.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f11089q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PipelineDraweeControllerBuilder f11090r;
    public final DraweeHolder s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final o f11091t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Uri f11092u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ScalingUtils.AbstractScaleType f11093v;

    public p(Resources r5, int r10, int r11, int[] r12, Uri r13, ScalingUtils.AbstractScaleType r14, PipelineDraweeControllerBuilder r15, o r16) {
        super(r10, r11, r12);
        this.s = new DraweeHolder(new GenericDraweeHierarchyBuilder(r5).a());
        this.f11090r = r15;
        if (r13 != null) goto L6;
        r13 = Uri.EMPTY;
    L6:
        this.f11092u = r13;
        this.f11093v = r14;
        this.f11091t = r16;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void c(Drawable.Callback r10) {
        this.f10703o = r10;
        if (r10 != null) goto L5;
    L14:
        Drawable r11 = this.f11089q;
        if (r11 == null) goto L18;
        r11.setCallback(r10);
        return;
    L18:
        return;
    L5:
        if (this.f11089q != null) goto L14;
        Uri r5 = Uri.EMPTY;
        Uri r12 = this.f11092u;
        if (r12 == r5) goto L14;
        ImageRequestBuilder r13 = ImageRequestBuilder.a(r12);
        Method r14 = oo.g.f20803a;
        oo.g.b(r13, Bitmap.Config.ARGB_8888, false);
        no.d r15 = new no.d(r13, null);
        PipelineDraweeControllerBuilder r16 = this.f11090r;
        r16.b();
        r16.f = true;
        DraweeHolder r17 = this.s;
        r16.f7798h = r17.e;
        r16.f7796b = null;
        r16.f7797c = r15;
        r16.e = this.f11091t;
        r17.a(r16.a());
        r16.b();
        Drawable r18 = r17.d();
        this.f11089q = r18;
        if (r18 == null) goto L14;
        r18.setBounds(0, 0, this.g, this.f);
        this.f11089q.setCallback(this.f10703o);
        DraweeHierarchy r19 = r17.d;
        r19.getClass();
        ScalingUtils.AbstractScaleType r20 = this.f11093v;
        r20.getClass();
        ScaleTypeDrawable r21 = ((GenericDraweeHierarchy) r19).b(2);
        if (Objects.a(r21.d, r20) == true) goto L14;
        r21.d = r20;
        r21.e();
        r21.invalidateSelf();
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.text.a, android.text.style.ReplacementSpan
    public final void draw(Canvas r5, CharSequence r10, int r11, int r12, float r13, int r14, int r15, int r16, Paint r17) {
        if (this.f10703o != null) goto L5;
        return;
    L5:
        super.draw(r5, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final Drawable e() {
        return this.f11089q;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void g() {
        this.s.f();
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void h() {
        this.s.g();
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void i() {
        this.s.f();
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void j() {
        this.s.g();
    }
}
