package com.lynx.tasm.ui.image;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends com.lynx.tasm.behavior.ui.text.a {
    public Drawable q;
    public final AbstractDraweeControllerBuilder r;
    public final DraweeHolder<GenericDraweeHierarchy> s;
    public final Object t;
    public final BaseControllerListener u;
    public final Uri v;
    public final ScalingUtils.ScaleType w;

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void e() {
        this.s.onAttach();
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void f() {
        this.s.onDetach();
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void g() {
        this.s.onAttach();
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void h() {
        this.s.onDetach();
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final Drawable c() {
        return this.q;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void j(Drawable.Callback r5) {
        this.o = r5;
        if (r5 != null) goto L5;
    L11:
        Drawable r0 = this.q;
        if (r0 == null) goto L15;
        r0.setCallback(r5);
        return;
    L15:
        return;
    L5:
        if (this.q != null) goto L11;
        Uri r1 = this.v;
        if (r1 == Uri.EMPTY) goto L11;
        ImageRequestBuilder r2 = ImageRequestBuilder.newBuilderWithSource(r1);
        m8a.e.a(r2);
        l8a.d r3 = new l8a.d(r2, null);
        AbstractDraweeController r4 = this.r.reset().setAutoPlayAnimations(true).setOldController(this.s.getController()).setCallerContext(this.t).setImageRequest(r3).setControllerListener(this.u).build();
        this.s.setController(r4);
        this.r.reset();
        Drawable r6 = this.s.getTopLevelDrawable();
        this.q = r6;
        if (r6 == null) goto L11;
        r6.setBounds(0, 0, this.g, this.f);
        this.q.setCallback(this.o);
        this.s.getHierarchy().setActualImageScaleType(this.w);
        goto L11
    }

    public d(Resources r1, int r2, int r3, int[] r4, Uri r5, ScalingUtils.ScaleType r6, PipelineDraweeControllerBuilder r7, Object r8, FrescoInlineImageShadowNode.a r9) {
        super(r2, r3, r4);
        this.s = new DraweeHolder(GenericDraweeHierarchyBuilder.newInstance(r1).build());
        this.r = r7;
        this.t = r8;
        if (r5 != null) goto L6;
        r5 = Uri.EMPTY;
    L6:
        this.v = r5;
        this.w = r6;
        this.u = r9;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a, android.text.style.ReplacementSpan
    public final void draw(Canvas r2, CharSequence r3, int r4, int r5, float r6, int r7, int r8, int r9, Paint r10) {
        if (this.o != null) goto L5;
        return;
    L5:
        super.draw(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }
}
