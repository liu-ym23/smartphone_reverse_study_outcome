package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.e;
import com.obric.oui.constraintlayout.core.widgets.h;
import com.obric.oui.constraintlayout.core.widgets.k;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import com.obric.oui.constraintlayout.widget.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Flow extends VirtualLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f13652a;

    public Flow(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public Flow(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public Flow(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(AttributeSet r9) {
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        super.a(r10);
        this.f13652a = new e();
        if (r10 == null) goto L86;
        TypedArray r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout);
        int r0 = r11.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L85;
        int r3 = r11.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_orientation, "styleable", "ConstraintLayout_Layout_android_orientation")) goto L10;
        this.f13652a.a(r11.getInt(r3, 0));
    L84:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_padding, "styleable", "ConstraintLayout_Layout_android_padding")) goto L13;
        this.f13652a.M(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingStart, "styleable", "ConstraintLayout_Layout_android_paddingStart")) goto L16;
        this.f13652a.N(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L16:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingEnd, "styleable", "ConstraintLayout_Layout_android_paddingEnd")) goto L19;
        this.f13652a.O(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L19:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingLeft, "styleable", "ConstraintLayout_Layout_android_paddingLeft")) goto L22;
        this.f13652a.P(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L22:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingTop, "styleable", "ConstraintLayout_Layout_android_paddingTop")) goto L25;
        this.f13652a.Q(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L25:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingRight, "styleable", "ConstraintLayout_Layout_android_paddingRight")) goto L28;
        this.f13652a.R(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L28:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingBottom, "styleable", "ConstraintLayout_Layout_android_paddingBottom")) goto L31;
        this.f13652a.S(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L31:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_wrapMode, "styleable", "ConstraintLayout_Layout_flow_wrapMode")) goto L34;
        this.f13652a.H(r11.getInt(r3, 0));
        goto L84
    L34:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_horizontalStyle, "styleable", "ConstraintLayout_Layout_flow_horizontalStyle")) goto L37;
        this.f13652a.D(r11.getInt(r3, 0));
        goto L84
    L37:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_verticalStyle, "styleable", "ConstraintLayout_Layout_flow_verticalStyle")) goto L40;
        this.f13652a.E(r11.getInt(r3, 0));
        goto L84
    L40:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle, "styleable", "ConstraintLayout_Layout_flow_firstHorizontalStyle")) goto L43;
        this.f13652a.b(r11.getInt(r3, 0));
        goto L84
    L43:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle, "styleable", "ConstraintLayout_Layout_flow_lastHorizontalStyle")) goto L46;
        this.f13652a.B(r11.getInt(r3, 0));
        goto L84
    L46:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle, "styleable", "ConstraintLayout_Layout_flow_firstVerticalStyle")) goto L49;
        this.f13652a.A(r11.getInt(r3, 0));
        goto L84
    L49:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle, "styleable", "ConstraintLayout_Layout_flow_lastVerticalStyle")) goto L52;
        this.f13652a.C(r11.getInt(r3, 0));
        goto L84
    L52:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_horizontalBias, "styleable", "ConstraintLayout_Layout_flow_horizontalBias")) goto L55;
        this.f13652a.e(r11.getFloat(r3, 0.5f));
        goto L84
    L55:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias, "styleable", "ConstraintLayout_Layout_flow_firstHorizontalBias")) goto L58;
        this.f13652a.g(r11.getFloat(r3, 0.5f));
        goto L84
    L58:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias, "styleable", "ConstraintLayout_Layout_flow_lastHorizontalBias")) goto L61;
        this.f13652a.i(r11.getFloat(r3, 0.5f));
        goto L84
    L61:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias, "styleable", "ConstraintLayout_Layout_flow_firstVerticalBias")) goto L64;
        this.f13652a.h(r11.getFloat(r3, 0.5f));
        goto L84
    L64:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias, "styleable", "ConstraintLayout_Layout_flow_lastVerticalBias")) goto L67;
        this.f13652a.j(r11.getFloat(r3, 0.5f));
        goto L84
    L67:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_verticalBias, "styleable", "ConstraintLayout_Layout_flow_verticalBias")) goto L70;
        this.f13652a.f(r11.getFloat(r3, 0.5f));
        goto L84
    L70:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_horizontalAlign, "styleable", "ConstraintLayout_Layout_flow_horizontalAlign")) goto L73;
        this.f13652a.F(r11.getInt(r3, 2));
        goto L84
    L73:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_verticalAlign, "styleable", "ConstraintLayout_Layout_flow_verticalAlign")) goto L76;
        this.f13652a.G(r11.getInt(r3, 2));
        goto L84
    L76:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_horizontalGap, "styleable", "ConstraintLayout_Layout_flow_horizontalGap")) goto L79;
        this.f13652a.I(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L79:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_verticalGap, "styleable", "ConstraintLayout_Layout_flow_verticalGap")) goto L82;
        this.f13652a.J(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L82:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap, "styleable", "ConstraintLayout_Layout_flow_maxElementsWrap")) goto L84;
        this.f13652a.K(r11.getInt(r3, -1));
        goto L84
    L85:
        r11.recycle();
    L86:
        this.m = this.f13652a;
        d();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(ConstraintWidget r1, boolean r2) {
        this.f13652a.a(r2);
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

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(b.a r1, h r2, ConstraintLayout.LayoutParams r3, SparseArray<ConstraintWidget> r4) {
        super.a(r1, r2, r3, r4);
        if (ZeusTransformUtils.instanceOf(r2, e.class) == false) goto L8;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.memorydata.plugin");
        if (r3.Z == (-1)) goto L9;
        r0.a(r3.Z);
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onMeasure(int r2, int r3) {
        a(this.f13652a, r2, r3);
    }

    public void setFirstHorizontalBias(float r2) {
        this.f13652a.g(r2);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int r2) {
        this.f13652a.b(r2);
        requestLayout();
    }

    public void setFirstVerticalBias(float r2) {
        this.f13652a.h(r2);
        requestLayout();
    }

    public void setFirstVerticalStyle(int r2) {
        this.f13652a.A(r2);
        requestLayout();
    }

    public void setHorizontalAlign(int r2) {
        this.f13652a.F(r2);
        requestLayout();
    }

    public void setHorizontalBias(float r2) {
        this.f13652a.e(r2);
        requestLayout();
    }

    public void setHorizontalGap(int r2) {
        this.f13652a.I(r2);
        requestLayout();
    }

    public void setHorizontalStyle(int r2) {
        this.f13652a.D(r2);
        requestLayout();
    }

    public void setLastHorizontalBias(float r2) {
        this.f13652a.i(r2);
        requestLayout();
    }

    public void setLastHorizontalStyle(int r2) {
        this.f13652a.B(r2);
        requestLayout();
    }

    public void setLastVerticalBias(float r2) {
        this.f13652a.j(r2);
        requestLayout();
    }

    public void setLastVerticalStyle(int r2) {
        this.f13652a.C(r2);
        requestLayout();
    }

    public void setMaxElementsWrap(int r2) {
        this.f13652a.K(r2);
        requestLayout();
    }

    public void setOrientation(int r2) {
        this.f13652a.a(r2);
        requestLayout();
    }

    public void setPadding(int r2) {
        this.f13652a.M(r2);
        requestLayout();
    }

    public void setPaddingBottom(int r2) {
        this.f13652a.S(r2);
        requestLayout();
    }

    public void setPaddingLeft(int r2) {
        this.f13652a.P(r2);
        requestLayout();
    }

    public void setPaddingRight(int r2) {
        this.f13652a.R(r2);
        requestLayout();
    }

    public void setPaddingTop(int r2) {
        this.f13652a.Q(r2);
        requestLayout();
    }

    public void setVerticalAlign(int r2) {
        this.f13652a.G(r2);
        requestLayout();
    }

    public void setVerticalBias(float r2) {
        this.f13652a.f(r2);
        requestLayout();
    }

    public void setVerticalGap(int r2) {
        this.f13652a.J(r2);
        requestLayout();
    }

    public void setVerticalStyle(int r2) {
        this.f13652a.E(r2);
        requestLayout();
    }

    public void setWrapMode(int r2) {
        this.f13652a.H(r2);
        requestLayout();
    }
}
