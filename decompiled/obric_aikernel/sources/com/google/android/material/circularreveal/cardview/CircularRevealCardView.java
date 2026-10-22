package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;

/* JADX INFO: loaded from: classes.dex */
public class CircularRevealCardView extends MaterialCardView implements c {

    @NonNull
    private final b helper;

    public CircularRevealCardView(Context r10) {
        this(r10, null);
    }

    public CircularRevealCardView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.helper = new b(this);
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
        this.helper.a();
    }

    @Override // com.google.android.material.circularreveal.c
    public void destroyCircularRevealCache() {
        this.helper.b();
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        b r11 = this.helper;
        if (r11 == null) goto L5;
        r11.c(r10);
        return;
    L5:
        super.draw(r10);
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.helper.e();
    }

    @Override // com.google.android.material.circularreveal.c
    public int getCircularRevealScrimColor() {
        return this.helper.f();
    }

    @Override // com.google.android.material.circularreveal.c
    @Nullable
    public c.e getRevealInfo() {
        return this.helper.h();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        b r10 = this.helper;
        if (r10 == null) goto L7;
        return r10.j();
    L7:
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealOverlayDrawable(@Nullable Drawable r10) {
        this.helper.k(r10);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealScrimColor(@ColorInt int r10) {
        this.helper.l(r10);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setRevealInfo(@Nullable c.e r10) {
        this.helper.m(r10);
    }
}
