package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ForegroundLinearLayout extends LinearLayoutCompat {

    @Nullable
    private Drawable foreground;
    boolean foregroundBoundsChanged;
    private int foregroundGravity;
    protected boolean mForegroundInPadding;
    private final Rect overlayBounds;
    private final Rect selfBounds;

    public ForegroundLinearLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public ForegroundLinearLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ForegroundLinearLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.selfBounds = new Rect();
        this.overlayBounds = new Rect();
        this.foregroundGravity = 119;
        this.mForegroundInPadding = true;
        this.foregroundBoundsChanged = false;
        TypedArray r13 = k.h(r10, r11, q5.l.ForegroundLinearLayout, r12, 0, new int[0]);
        this.foregroundGravity = r13.getInt(q5.l.ForegroundLinearLayout_android_foregroundGravity, this.foregroundGravity);
        Drawable r14 = r13.getDrawable(q5.l.ForegroundLinearLayout_android_foreground);
        if (r14 == null) goto L5;
        setForeground(r14);
    L5:
        this.mForegroundInPadding = r13.getBoolean(q5.l.ForegroundLinearLayout_foregroundInsidePadding, true);
        r13.recycle();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        Drawable r11 = this.foreground;
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.foregroundBoundsChanged == false) goto L11;
        this.foregroundBoundsChanged = false;
        Rect r12 = this.selfBounds;
        Rect r13 = this.overlayBounds;
        int r14 = getRight() - getLeft();
        int r15 = getBottom() - getTop();
        if (this.mForegroundInPadding == false) goto L9;
        r12.set(0, 0, r14, r15);
    L10:
        Gravity.apply(this.foregroundGravity, r11.getIntrinsicWidth(), r11.getIntrinsicHeight(), r12, r13);
        r11.setBounds(r13);
        goto L11
    L9:
        r12.set(getPaddingLeft(), getPaddingTop(), r14 - getPaddingRight(), r15 - getPaddingBottom());
    L11:
        r11.draw(r10);
    }

    @Override // android.view.View
    @RequiresApi(21)
    @TargetApi(21)
    public void drawableHotspotChanged(float r10, float r11) {
        super.drawableHotspotChanged(r10, r11);
        Drawable r12 = this.foreground;
        if (r12 == null) goto L6;
        r12.setHotspot(r10, r11);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r10 = this.foreground;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isStateful() == false) goto L9;
        this.foreground.setState(getDrawableState());
        return;
    }

    @Override // android.view.View
    @Nullable
    public Drawable getForeground() {
        return this.foreground;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.foregroundGravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r10 = this.foreground;
        if (r10 == null) goto L6;
        r10.jumpToCurrentState();
        return;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        this.foregroundBoundsChanged = r10 | this.foregroundBoundsChanged;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        this.foregroundBoundsChanged = true;
    }

    @Override // android.view.View
    public void setForeground(@Nullable Drawable r10) {
        Drawable r11 = this.foreground;
        if (r11 == r10) goto L17;
        if (r11 == null) goto L6;
        r11.setCallback(null);
        unscheduleDrawable(this.foreground);
    L6:
        this.foreground = r10;
        if (r10 == null) goto L14;
        setWillNotDraw(false);
        r10.setCallback(this);
        if (r10.isStateful() == false) goto L12;
        r10.setState(getDrawableState());
    L12:
        if (this.foregroundGravity != 119) goto L15;
        r10.getPadding(new Rect());
    L15:
        requestLayout();
        invalidate();
        return;
    L14:
        setWillNotDraw(true);
        goto L15
    }

    @Override // android.view.View
    public void setForegroundGravity(int r10) {
        if (this.foregroundGravity != r10) goto L5;
        return;
    L5:
        if ((8388615 & r10) != 0) goto L8;
        r10 = r10 | GravityCompat.START;
    L8:
        if ((r10 & 112) != 0) goto L10;
        r10 = r10 | 48;
    L10:
        this.foregroundGravity = r10;
        if (r10 == 119) goto L13;
    L15:
        requestLayout();
        return;
    L13:
        if (this.foreground == null) goto L15;
        Rect r11 = new Rect();
        this.foreground.getPadding(r11);
        goto L15
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable r10) {
        if (super.verifyDrawable(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (r10 == this.foreground) goto L8;
        return false;
    }
}
