package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Group extends ConstraintHelper {
    public Group(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public Group(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public Group(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(AttributeSet r3) {
        super.a((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.n = false;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void b(ConstraintLayout r2) {
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r1.av.q(0);
        r1.av.r(0);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void c(ConstraintLayout r1) {
        d(r1);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        e();
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        e();
    }
}
