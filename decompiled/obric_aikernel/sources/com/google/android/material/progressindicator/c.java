package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
final class c extends e<CircularProgressIndicatorSpec> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f3528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f3529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f3530f;

    public c(@NonNull CircularProgressIndicatorSpec r10) {
        super(r10);
        this.f3527c = 1;
    }

    private void h(Canvas r10, Paint r11, float r12, float r13, float r14) {
        r10.save();
        r10.rotate(r14);
        float r15 = this.f3530f;
        float r16 = r12 / 2.0f;
        r10.drawRoundRect(new RectF(r15 - r16, r13, r15 + r16, -r13), r13, r13, r11);
        r10.restore();
    }

    private int i() {
        S r10 = this.f3546a;
        return ((CircularProgressIndicatorSpec) r10).f3511g + (((CircularProgressIndicatorSpec) r10).f3512h * 2);
    }

    @Override // com.google.android.material.progressindicator.e
    public void a(@NonNull Canvas r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
        S r12 = this.f3546a;
        float r13 = (((CircularProgressIndicatorSpec) r12).f3511g / 2.0f) + ((CircularProgressIndicatorSpec) r12).f3512h;
        r10.translate(r13, r13);
        r10.rotate(-90.0f);
        float r14 = -r13;
        r10.clipRect(r14, r14, r13, r13);
        S r15 = this.f3546a;
        if (((CircularProgressIndicatorSpec) r15).f3513i != 0) goto L5;
        int r16 = 1;
    L6:
        this.f3527c = r16;
        this.f3528d = ((CircularProgressIndicatorSpec) r15).f3521a * r11;
        this.f3529e = ((CircularProgressIndicatorSpec) r15).f3522b * r11;
        this.f3530f = (((CircularProgressIndicatorSpec) r15).f3511g - ((CircularProgressIndicatorSpec) r15).f3521a) / 2.0f;
        if (this.f3547b.isShowing() == false) goto L11;
        if (((CircularProgressIndicatorSpec) this.f3546a).f3525e != 2) goto L11;
    L14:
        float r17 = this.f3530f + (((1.0f - r11) * ((CircularProgressIndicatorSpec) this.f3546a).f3521a) / 2.0f);
    L15:
        this.f3530f = r17;
        return;
    L11:
        if (this.f3547b.isHiding() == false) goto L17;
        if (((CircularProgressIndicatorSpec) this.f3546a).f3526f == 1) goto L14;
    L17:
        if (this.f3547b.isShowing() == false) goto L21;
        if (((CircularProgressIndicatorSpec) this.f3546a).f3525e != 1) goto L21;
    L24:
        r17 = this.f3530f - (((1.0f - r11) * ((CircularProgressIndicatorSpec) this.f3546a).f3521a) / 2.0f);
    L21:
        if (this.f3547b.isHiding() == true) goto L23;
        return;
    L23:
        if (((CircularProgressIndicatorSpec) this.f3546a).f3526f == 2) goto L24;
        return;
    L5:
        r16 = -1;
        goto L6
    }

    @Override // com.google.android.material.progressindicator.e
    void b(@NonNull Canvas r12, @NonNull Paint r13, @FloatRange(from = 0.0d, to = 1.0d) float r14, @FloatRange(from = 0.0d, to = 1.0d) float r15, @ColorInt int r16) {
        if (r14 != r15) goto L5;
        return;
    L5:
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeCap(Paint.Cap.BUTT);
        r13.setAntiAlias(true);
        r13.setColor(r16);
        r13.setStrokeWidth(this.f3528d);
        int r10 = this.f3527c;
        float r11 = (r14 * 360.0f) * r10;
        if (r15 < r14) goto L8;
        float r17 = r15 - r14;
    L9:
        float r18 = (r17 * 360.0f) * r10;
        float r19 = this.f3530f;
        r12.drawArc(new RectF(-r19, -r19, r19, r19), r11, r18, false, r13);
        if (this.f3529e > 0.0f) goto L12;
        return;
    L12:
        if (Math.abs(r18) >= 360.0f) goto L16;
        r13.setStyle(Paint.Style.FILL);
        h(r12, r13, this.f3528d, this.f3529e, r11);
        h(r12, r13, this.f3528d, this.f3529e, r11 + r18);
        return;
    L16:
        return;
    L8:
        r17 = (1.0f + r15) - r14;
        goto L9
    }

    @Override // com.google.android.material.progressindicator.e
    void c(@NonNull Canvas r10, @NonNull Paint r11) {
        int r12 = t5.a.a(((CircularProgressIndicatorSpec) this.f3546a).f3524d, this.f3547b.getAlpha());
        r11.setStyle(Paint.Style.STROKE);
        r11.setStrokeCap(Paint.Cap.BUTT);
        r11.setAntiAlias(true);
        r11.setColor(r12);
        r11.setStrokeWidth(this.f3528d);
        float r13 = this.f3530f;
        r10.drawArc(new RectF(-r13, -r13, r13, r13), 0.0f, 360.0f, false, r11);
    }

    @Override // com.google.android.material.progressindicator.e
    public int d() {
        return i();
    }

    @Override // com.google.android.material.progressindicator.e
    public int e() {
        return i();
    }
}
