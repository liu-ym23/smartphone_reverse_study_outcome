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
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ForegroundLinearLayout extends LinearLayoutCompat {

    @Nullable
    private Drawable foreground;
    boolean foregroundBoundsChanged;
    private int foregroundGravity;
    protected boolean mForegroundInPadding;
    private final Rect overlayBounds;
    private final Rect selfBounds;

    public ForegroundLinearLayout(@NonNull Context r5) {
        this(r5, null);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        Drawable r5 = this.foreground;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.foregroundBoundsChanged == false) goto L11;
        this.foregroundBoundsChanged = false;
        Rect r11 = this.selfBounds;
        Rect r12 = this.overlayBounds;
        int r13 = getRight() - getLeft();
        int r14 = getBottom() - getTop();
        if (this.mForegroundInPadding == false) goto L9;
        r11.set(0, 0, r13, r14);
    L10:
        Gravity.apply(this.foregroundGravity, r5.getIntrinsicWidth(), r5.getIntrinsicHeight(), r11, r12);
        r5.setBounds(r12);
        goto L11
    L9:
        r11.set(getPaddingLeft(), getPaddingTop(), r13 - getPaddingRight(), r14 - getPaddingBottom());
    L11:
        r5.draw(r10);
    }

    @Override // android.view.View
    @RequiresApi(21)
    @TargetApi(21)
    public void drawableHotspotChanged(float r5, float r10) {
        super.drawableHotspotChanged(r5, r10);
        Drawable r11 = this.foreground;
        if (r11 == null) goto L6;
        r11.setHotspot(r5, r10);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r5 = this.foreground;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isStateful() == false) goto L9;
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
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r5 = this.foreground;
        if (r5 == null) goto L6;
        r5.jumpToCurrentState();
        return;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        this.foregroundBoundsChanged = r5 | this.foregroundBoundsChanged;
    }

    @Override // android.view.View
    public void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        this.foregroundBoundsChanged = true;
    }

    @Override // android.view.View
    public void setForeground(@Nullable Drawable r5) {
        Drawable r10 = this.foreground;
        if (r10 == r5) goto L17;
        if (r10 == null) goto L6;
        r10.setCallback(null);
        unscheduleDrawable(this.foreground);
    L6:
        this.foreground = r5;
        this.foregroundBoundsChanged = true;
        if (r5 == null) goto L14;
        setWillNotDraw(false);
        r5.setCallback(this);
        if (r5.isStateful() == false) goto L12;
        r5.setState(getDrawableState());
    L12:
        if (this.foregroundGravity != 119) goto L15;
        r5.getPadding(new Rect());
    L15:
        requestLayout();
        invalidate();
        return;
    L14:
        setWillNotDraw(true);
        goto L15
    }

    @Override // android.view.View
    public void setForegroundGravity(int r5) {
        if (this.foregroundGravity != r5) goto L5;
        return;
    L5:
        if ((8388615 & r5) != 0) goto L8;
        r5 = r5 | GravityCompat.START;
    L8:
        if ((r5 & 112) != 0) goto L10;
        r5 = r5 | 48;
    L10:
        this.foregroundGravity = r5;
        if (r5 == 119) goto L13;
    L15:
        requestLayout();
        return;
    L13:
        if (this.foreground == null) goto L15;
        Rect r10 = new Rect();
        this.foreground.getPadding(r10);
        goto L15
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r5) {
        if (super.verifyDrawable(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (r5 == this.foreground) goto L8;
        return false;
    }

    public ForegroundLinearLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public ForegroundLinearLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.selfBounds = new Rect();
        this.overlayBounds = new Rect();
        this.foregroundGravity = 119;
        this.mForegroundInPadding = true;
        this.foregroundBoundsChanged = false;
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.ForegroundLinearLayout, r12, 0, new int[0]);
        this.foregroundGravity = r13.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.foregroundGravity);
        Drawable r14 = r13.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
        if (r14 == null) goto L5;
        setForeground(r14);
    L5:
        this.mForegroundInPadding = r13.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        r13.recycle();
    }
}
