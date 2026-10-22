package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.y;
import he.i;
import nb.a;

/* JADX INFO: loaded from: classes2.dex */
public final class UnReadMsgView extends y {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final GradientDrawable f6531q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6532r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6533s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6534t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6535u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6536v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6537w;

    public UnReadMsgView(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        this.f6531q = new GradientDrawable();
        TypedArray r11 = r8.obtainStyledAttributes(r10, a.f9487a);
        i.e(r11, "context.obtainStyledAttr…trs, R.styleable.MsgView)");
        this.f6532r = r11.getColor(0, 0);
        this.f6533s = r11.getDimensionPixelSize(1, 0);
        this.f6534t = r11.getDimensionPixelSize(5, 0);
        this.f6535u = r11.getColor(4, 0);
        this.f6536v = r11.getBoolean(2, false);
        this.f6537w = r11.getBoolean(3, false);
        r11.recycle();
    }

    private final void setCornerRadius(int r8) {
        this.f6533s = p(r8);
        q();
    }

    private final void setStrokeWidth(int r8) {
        this.f6534t = p(r8);
        q();
    }

    public final int getBackgroundColor() {
        return this.f6532r;
    }

    public final int getCornerRadius() {
        return this.f6533s;
    }

    public final int getStrokeColor() {
        return this.f6535u;
    }

    public final int getStrokeWidth() {
        return this.f6534t;
    }

    @Override // androidx.appcompat.widget.y, android.widget.TextView, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        if (this.f6536v == false) goto L5;
        setCornerRadius(getHeight() / 2);
        return;
    L5:
        q();
    }

    @Override // androidx.appcompat.widget.y, android.widget.TextView, android.view.View
    public final void onMeasure(int r8, int r10) {
        if (this.f6537w == true) goto L5;
    L13:
        super.onMeasure(r8, r10);
        return;
    L5:
        if (getWidth() <= 0) goto L13;
        if (getHeight() <= 0) goto L13;
        int r11 = getWidth();
        int r12 = getHeight();
        if (r11 >= r12) goto L11;
        r11 = r12;
    L11:
        int r13 = View.MeasureSpec.makeMeasureSpec(r11, 1073741824);
        super.onMeasure(r13, r13);
    }

    public final int p(float r8) {
        Context r10 = getContext();
        i.e(r10, "context");
        Resources r11 = r10.getResources();
        i.e(r11, "context.resources");
        return (int) ((r8 * r11.getDisplayMetrics().density) + 0.5f);
    }

    public final void q() {
        StateListDrawable r8 = new StateListDrawable();
        GradientDrawable r10 = this.f6531q;
        int r11 = this.f6532r;
        int r12 = this.f6535u;
        r10.setColor(r11);
        r10.setCornerRadius(this.f6533s);
        r10.setStroke(this.f6534t, r12);
        r8.addState(new int[]{-16842919}, r10);
        setBackground(r8);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r8) {
        this.f6532r = r8;
        q();
    }

    public final void setIsRadiusHalfHeight(boolean r8) {
        this.f6536v = r8;
        q();
    }

    public final void setIsWidthHeightEqual(boolean r8) {
        this.f6537w = r8;
        q();
    }

    public final void setStrokeColor(int r8) {
        this.f6535u = r8;
        q();
    }
}
