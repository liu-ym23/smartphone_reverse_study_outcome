package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Barrier extends ConstraintHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13740b;
    private com.obric.oui.constraintlayout.core.widgets.a c;

    public Barrier(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        super.setVisibility(8);
    }

    public Barrier(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        super.setVisibility(8);
    }

    public Barrier(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        super.setVisibility(8);
    }

    private void a(ConstraintWidget r4, int r5, boolean r6) {
        this.f13740b = r5;
        if (r6 == false) goto L9;
        int r7 = this.f13739a;
        if (r7 != 5) goto L7;
    L6:
        this.f13740b = 1;
    L15:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.constraintlayout.core.widgets.a.class) == false) goto L18;
        ((com.obric.oui.constraintlayout.core.widgets.a) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.constraintlayout.core.widgets.a.class, "com.obric.memorydata.plugin")).a(this.f13740b);
        return;
    L18:
        return;
    L7:
        if (r7 != 6) goto L15;
    L11:
        this.f13740b = 0;
        goto L15
    L9:
        int r8 = this.f13739a;
        if (r8 == 5) goto L11;
        if (r8 != 6) goto L15;
        goto L6
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(AttributeSet r8) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        super.a(r9);
        this.c = new com.obric.oui.constraintlayout.core.widgets.a();
        if (r9 == null) goto L17;
        TypedArray r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r9, R.styleable.ConstraintLayout_Layout);
        int r0 = r10.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L16;
        int r3 = r10.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_barrierDirection, "styleable", "ConstraintLayout_Layout_barrierDirection")) goto L10;
        setType(r10.getInt(r3, 0));
    L15:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets, "styleable", "ConstraintLayout_Layout_barrierAllowsGoneWidgets")) goto L13;
        this.c.a(r10.getBoolean(r3, true));
        goto L15
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_barrierMargin, "styleable", "ConstraintLayout_Layout_barrierMargin")) goto L15;
        this.c.b(r10.getDimensionPixelSize(r3, 0));
        goto L15
    L16:
        r10.recycle();
    L17:
        this.m = this.c;
        d();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(ConstraintWidget r2, boolean r3) {
        a(r2, this.f13739a, r3);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(b.a r2, h r3, ConstraintLayout.LayoutParams r4, SparseArray<ConstraintWidget> r5) {
        super.a(r2, r3, r4, r5);
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.constraintlayout.core.widgets.a.class) == false) goto L6;
        com.obric.oui.constraintlayout.core.widgets.a r6 = (com.obric.oui.constraintlayout.core.widgets.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.constraintlayout.core.widgets.a.class, "com.obric.memorydata.plugin");
        boolean r7 = ((com.obric.oui.constraintlayout.core.widgets.d) ZeusTransformUtils.preCheckCast(r3.A(), com.obric.oui.constraintlayout.core.widgets.d.class, "com.obric.memorydata.plugin")).ag();
        a(r6, r2.e.ah, r7);
        r6.a(r2.e.ap);
        r6.b(r2.e.ai);
        return;
    }

    public boolean getAllowsGoneWidget() {
        return this.c.c();
    }

    public int getMargin() {
        return this.c.g();
    }

    public int getType() {
        return this.f13739a;
    }

    public void setAllowsGoneWidget(boolean r1) {
        this.c.a(r1);
    }

    public void setDpMargin(int r2) {
        this.c.b((int) ((r2 * ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int r1) {
        this.c.b(r1);
    }

    public void setType(int r1) {
        this.f13739a = r1;
    }
}
