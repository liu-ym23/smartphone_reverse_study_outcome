package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Guideline extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13753a;

    public Guideline(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.f13753a = true;
        super.setVisibility(8);
    }

    public Guideline(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.f13753a = true;
        super.setVisibility(8);
    }

    public Guideline(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        this.f13753a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas r1) {
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean r1) {
        this.f13753a = r1;
    }

    public void setGuidelineBegin(int r4) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (this.f13753a == true) goto L5;
    L7:
        r0.f13747a = r4;
        setLayoutParams(r0);
        return;
    L5:
        if (r0.f13747a != r4) goto L7;
    }

    public void setGuidelineEnd(int r4) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (this.f13753a == true) goto L5;
    L7:
        r0.f13748b = r4;
        setLayoutParams(r0);
        return;
    L5:
        if (r0.f13748b != r4) goto L7;
    }

    public void setGuidelinePercent(float r4) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (this.f13753a == true) goto L5;
    L7:
        r0.c = r4;
        setLayoutParams(r0);
        return;
    L5:
        if (r0.c != r4) goto L7;
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
    }
}
