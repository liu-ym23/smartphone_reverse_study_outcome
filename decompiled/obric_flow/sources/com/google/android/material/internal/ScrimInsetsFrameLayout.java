package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ScrimInsetsFrameLayout extends FrameLayout {
    private boolean drawBottomInsetForeground;
    private boolean drawLeftInsetForeground;
    private boolean drawRightInsetForeground;
    private boolean drawTopInsetForeground;

    @Nullable
    Drawable insetForeground;
    Rect insets;
    private Rect tempRect;

    public ScrimInsetsFrameLayout(@NonNull Context r5) {
        this(r5, null);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        int r5 = getWidth();
        int r11 = getHeight();
        if (this.insets != null) goto L5;
        return;
    L5:
        if (this.insetForeground == null) goto L21;
        int r12 = r10.save();
        r10.translate(getScrollX(), getScrollY());
        if (this.drawTopInsetForeground == false) goto L10;
        this.tempRect.set(0, 0, r5, this.insets.top);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r10);
    L10:
        if (this.drawBottomInsetForeground == false) goto L13;
        this.tempRect.set(0, r11 - this.insets.bottom, r5, r11);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r10);
    L13:
        if (this.drawLeftInsetForeground == false) goto L16;
        Rect r13 = this.tempRect;
        Rect r14 = this.insets;
        r13.set(0, r14.top, r14.left, r11 - r14.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r10);
    L16:
        if (this.drawRightInsetForeground == false) goto L18;
        Rect r15 = this.tempRect;
        Rect r16 = this.insets;
        r15.set(r5 - r16.right, r16.top, r5, r11 - r16.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(r10);
    L18:
        r10.restoreToCount(r12);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable r5 = this.insetForeground;
        if (r5 == null) goto L6;
        r5.setCallback(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable r5 = this.insetForeground;
        if (r5 == null) goto L6;
        r5.setCallback(null);
        return;
    }

    public void onInsetsChanged(WindowInsetsCompat r5) {
    }

    public void setDrawBottomInsetForeground(boolean r5) {
        this.drawBottomInsetForeground = r5;
    }

    public void setDrawLeftInsetForeground(boolean r5) {
        this.drawLeftInsetForeground = r5;
    }

    public void setDrawRightInsetForeground(boolean r5) {
        this.drawRightInsetForeground = r5;
    }

    public void setDrawTopInsetForeground(boolean r5) {
        this.drawTopInsetForeground = r5;
    }

    public void setScrimInsetForeground(@Nullable Drawable r5) {
        this.insetForeground = r5;
    }

    public ScrimInsetsFrameLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public ScrimInsetsFrameLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.tempRect = new Rect();
        this.drawTopInsetForeground = true;
        this.drawBottomInsetForeground = true;
        this.drawLeftInsetForeground = true;
        this.drawRightInsetForeground = true;
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.ScrimInsetsFrameLayout, r12, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.insetForeground = r13.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        r13.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
    }
}
