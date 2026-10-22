package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class Guideline extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13046a;

    public Guideline(Context r5) {
        super(r5);
        this.f13046a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void draw(Canvas r5) {
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r10) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean r5) {
        this.f13046a = r5;
    }

    public void setGuidelineBegin(int r5) {
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f13046a == true) goto L5;
    L7:
        r10.f13001a = r5;
        setLayoutParams(r10);
        return;
    L5:
        if (r10.f13001a != r5) goto L7;
    }

    public void setGuidelineEnd(int r5) {
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f13046a == true) goto L5;
    L7:
        r10.f13003b = r5;
        setLayoutParams(r10);
        return;
    L5:
        if (r10.f13003b != r5) goto L7;
    }

    public void setGuidelinePercent(float r5) {
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f13046a == true) goto L5;
    L7:
        r10.f13005c = r5;
        setLayoutParams(r10);
        return;
    L5:
        if (r10.f13005c != r5) goto L7;
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
    }

    public Guideline(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f13046a = true;
        super.setVisibility(8);
    }

    public Guideline(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f13046a = true;
        super.setVisibility(8);
    }
}
