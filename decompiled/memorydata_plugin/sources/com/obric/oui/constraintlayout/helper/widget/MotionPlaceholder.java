package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.d;
import com.obric.oui.constraintlayout.core.widgets.g;
import com.obric.oui.constraintlayout.core.widgets.j;
import com.obric.oui.constraintlayout.core.widgets.k;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class MotionPlaceholder extends VirtualLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    j f13659a;

    public MotionPlaceholder(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public MotionPlaceholder(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public MotionPlaceholder(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(AttributeSet r3) {
        super.a((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.m = new j();
        d();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(d r1, g r2, SparseArray<ConstraintWidget> r3) {
        g r0 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout
    public void a(k r3, int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r4);
        int r6 = View.MeasureSpec.getSize(r4);
        int r1 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        if (r3 == null) goto L5;
        r3.b(r0, r6, r1, r7);
        setMeasuredDimension(r3.af(), r3.ag());
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onMeasure(int r2, int r3) {
        a(this.f13659a, r2, r3);
    }
}
