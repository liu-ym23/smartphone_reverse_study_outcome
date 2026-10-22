package com.lynx.tasm.ui.image;

import android.content.res.Resources;
import android.net.Uri;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier;
import com.facebook.drawee.drawable.ScalingUtils;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode;

/* JADX INFO: loaded from: classes2.dex */
public class FrescoInlineImageShadowNode extends AbsInlineImageShadowNode {
    public Uri O;
    public ScalingUtils.AbstractScaleType P;
    public final PipelineDraweeControllerBuilder Q;
    public String R;
    public boolean S;
    public boolean T;
    public final o U;
    public CloseableReference V;
    public boolean W;

    public FrescoInlineImageShadowNode() {
        this.R = null;
        this.S = false;
        this.T = false;
        this.V = null;
        this.Q = ((PipelineDraweeControllerBuilderSupplier) Fresco.f7726a.a()).a();
        this.P = (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f7893a;
        this.U = new o(this);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final com.lynx.tasm.behavior.ui.text.a E() {
        Resources r5 = k().getResources();
        ShadowNode r10 = (ShadowNode) this.f10337h.f23310b;
        float r11 = r10.f10334a.g(r10.f10335b);
        ShadowNode r12 = (ShadowNode) this.f10337h.f23310b;
        float r13 = r12.f10334a.a(r12.f10335b);
        ShadowNode r14 = (ShadowNode) this.f10337h.f23310b;
        int[] r15 = r14.f10334a.e(r14.f10335b);
        int r16 = (int) Math.ceil(r11);
        int r17 = (int) Math.ceil(r13);
        Uri r18 = this.O;
        ScalingUtils.AbstractScaleType r19 = this.P;
        k();
        return new p(r5, r16, r17, r15, r18, r19, this.Q, this.U);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public final void h(com.lynx.tasm.b0 r5) {
        super.h(r5);
        this.W = r5.I;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void p() {
        if (this.S == false) goto L14;
        Uri r5 = null;
        if (this.R != null) goto L7;
    L13:
        this.O = r5;
        this.S = false;
        goto L14
    L7:
        if (this.T == true) goto L9;
        this.R = dn.a.J(k(), false, this.R);
    L9:
        Uri r10 = Uri.parse(this.R);
        if (r10.getScheme() != null) goto L12;
        com.lynx.tasm.behavior.ui.utils.e.i(new StringBuilder("Image src should not be relative url : "), this.R, 4, LynxMonitorService.DEFAULT_PID);
        goto L13
    L12:
        r5 = r10;
    L14:
        n();
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void q() {
        if (this.W == false) goto L6;
        com.lynx.tasm.utils.j.f(new h(this, 2));
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "loop-count")
    public void setLoopCount(int r5) {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setMode(String r5) {
        this.P = e0.a(r5);
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "skip-redirection")
    public void setSkipRedirection(boolean r5) {
        this.T = r5;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setSource(String r5) {
        this.R = r5;
        this.S = true;
        n();
    }
}
