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

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    Drawable f3345c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Rect f3346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Rect f3347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3349j;

    public ScrimInsetsFrameLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public ScrimInsetsFrameLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ScrimInsetsFrameLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f3347h = new Rect();
        this.f3348i = true;
        this.f3349j = true;
        TypedArray r13 = k.h(r10, r11, q5.l.ScrimInsetsFrameLayout, r12, q5.k.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f3345c = r13.getDrawable(q5.l.ScrimInsetsFrameLayout_insetForeground);
        r13.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
    }

    protected void a(WindowInsetsCompat r10) {
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        int r11 = getWidth();
        int r12 = getHeight();
        if (this.f3346g != null) goto L5;
        return;
    L5:
        if (this.f3345c == null) goto L15;
        int r13 = r10.save();
        r10.translate(getScrollX(), getScrollY());
        if (this.f3348i == false) goto L10;
        this.f3347h.set(0, 0, r11, this.f3346g.top);
        this.f3345c.setBounds(this.f3347h);
        this.f3345c.draw(r10);
    L10:
        if (this.f3349j == false) goto L12;
        this.f3347h.set(0, r12 - this.f3346g.bottom, r11, r12);
        this.f3345c.setBounds(this.f3347h);
        this.f3345c.draw(r10);
    L12:
        Rect r14 = this.f3347h;
        Rect r15 = this.f3346g;
        r14.set(0, r15.top, r15.left, r12 - r15.bottom);
        this.f3345c.setBounds(this.f3347h);
        this.f3345c.draw(r10);
        Rect r16 = this.f3347h;
        Rect r17 = this.f3346g;
        r16.set(r11 - r17.right, r17.top, r11, r12 - r17.bottom);
        this.f3345c.setBounds(this.f3347h);
        this.f3345c.draw(r10);
        r10.restoreToCount(r13);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable r10 = this.f3345c;
        if (r10 == null) goto L6;
        r10.setCallback(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable r10 = this.f3345c;
        if (r10 == null) goto L6;
        r10.setCallback(null);
        return;
    }

    public void setDrawBottomInsetForeground(boolean r10) {
        this.f3349j = r10;
    }

    public void setDrawTopInsetForeground(boolean r10) {
        this.f3348i = r10;
    }

    public void setScrimInsetForeground(@Nullable Drawable r10) {
        this.f3345c = r10;
    }
}
