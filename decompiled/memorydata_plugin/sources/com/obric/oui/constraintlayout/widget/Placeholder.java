package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Placeholder extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13755b;
    private int c;

    public Placeholder(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.f13754a = -1;
        this.f13755b = null;
        this.c = 4;
        a(null);
    }

    public Placeholder(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        this.f13754a = -1;
        this.f13755b = null;
        this.c = 4;
        a(r6);
    }

    public Placeholder(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.f13754a = -1;
        this.f13755b = null;
        this.c = 4;
        a(r7);
    }

    private void a(AttributeSet r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        super.setVisibility(this.c);
        this.f13754a = -1;
        if (r8 == null) goto L19;
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r8, R.styleable.ConstraintLayout_placeholder);
        int r0 = r9.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        int r2 = r9.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_placeholder_content, "styleable", "ConstraintLayout_placeholder_content")) goto L10;
        this.f13754a = r9.getResourceId(r2, this.f13754a);
    L12:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility, "styleable", "ConstraintLayout_placeholder_placeholder_emptyVisibility")) goto L12;
        this.c = r9.getInt(r2, this.c);
        goto L12
    L13:
        r9.recycle();
        return;
    }

    public void a(ConstraintLayout r3) {
        if (this.f13754a == (-1)) goto L5;
    L7:
        View r4 = r3.findViewById(this.f13754a);
        this.f13755b = r4;
        if (r4 == null) goto L11;
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).aj = true;
        this.f13755b.setVisibility(0);
        setVisibility(0);
        return;
    L11:
        return;
    L5:
        if (isInEditMode() == true) goto L7;
        setVisibility(this.c);
        goto L7
    }

    public void b(ConstraintLayout r3) {
        if (this.f13755b != null) goto L5;
        return;
    L5:
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(this.f13755b.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r2.av.l(0);
        if (r4.av.aa() == ConstraintWidget.DimensionBehaviour.FIXED) goto L9;
        r4.av.q(r2.av.F());
    L9:
        if (r4.av.ab() == ConstraintWidget.DimensionBehaviour.FIXED) goto L11;
        r4.av.r(r2.av.G());
    L11:
        r2.av.l(8);
    }

    public View getContent() {
        return this.f13755b;
    }

    public int getEmptyVisibility() {
        return this.c;
    }

    @Override // android.view.View
    public void onDraw(Canvas r7) {
        if (isInEditMode() == false) goto L6;
        r7.drawRGB(223, 223, 223);
        Paint r6 = new Paint();
        r6.setARGB(255, 210, 210, 210);
        r6.setTextAlign(Paint.Align.CENTER);
        r6.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        Rect r0 = new Rect();
        r7.getClipBounds(r0);
        r6.setTextSize(r0.height());
        int r2 = r0.height();
        int r3 = r0.width();
        r6.setTextAlign(Paint.Align.LEFT);
        r6.getTextBounds("?", 0, 1, r0);
        r7.drawText("?", ((r3 / 2.0f) - (r0.width() / 2.0f)) - r0.left, ((r2 / 2.0f) + (r0.height() / 2.0f)) - r0.bottom, r6);
        return;
    }

    public void setContentId(int r5) {
        if (this.f13754a != r5) goto L5;
        return;
    L5:
        View r0 = this.f13755b;
        if (r0 == null) goto L8;
        r0.setVisibility(0);
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(this.f13755b.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).aj = false;
        this.f13755b = null;
    L8:
        this.f13754a = r5;
        if (r5 == (-1)) goto L14;
        View r4 = ((View) ZeusTransformUtils.preCheckCast(getParent(), View.class, "com.obric.memorydata.plugin")).findViewById(r5);
        if (r4 == null) goto L15;
        r4.setVisibility(8);
        return;
    L15:
        return;
    }

    public void setEmptyVisibility(int r1) {
        this.c = r1;
    }
}
