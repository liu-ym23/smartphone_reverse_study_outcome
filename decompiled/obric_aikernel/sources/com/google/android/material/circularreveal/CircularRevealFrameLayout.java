package com.google.android.material.circularreveal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class CircularRevealFrameLayout extends FrameLayout implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final b f3138c;

    public CircularRevealFrameLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public CircularRevealFrameLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.f3138c = new b(this);
    }

    @Override // com.google.android.material.circularreveal.b.a
    public void actualDraw(Canvas r10) {
        super.draw(r10);
    }

    @Override // com.google.android.material.circularreveal.b.a
    public boolean actualIsOpaque() {
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.c
    public void buildCircularRevealCache() {
        this.f3138c.a();
    }

    @Override // com.google.android.material.circularreveal.c
    public void destroyCircularRevealCache() {
        this.f3138c.b();
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(@NonNull Canvas r10) {
        b r11 = this.f3138c;
        if (r11 == null) goto L5;
        r11.c(r10);
        return;
    L5:
        super.draw(r10);
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f3138c.e();
    }

    @Override // com.google.android.material.circularreveal.c
    public int getCircularRevealScrimColor() {
        return this.f3138c.f();
    }

    @Override // com.google.android.material.circularreveal.c
    @Nullable
    public c.e getRevealInfo() {
        return this.f3138c.h();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        b r10 = this.f3138c;
        if (r10 == null) goto L7;
        return r10.j();
    L7:
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealOverlayDrawable(@Nullable Drawable r10) {
        this.f3138c.k(r10);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealScrimColor(@ColorInt int r10) {
        this.f3138c.l(r10);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setRevealInfo(@Nullable c.e r10) {
        this.f3138c.m(r10);
    }
}
