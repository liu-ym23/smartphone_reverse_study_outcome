package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
final class g extends e<LinearProgressIndicatorSpec> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f3551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f3552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f3553e;

    public g(@NonNull LinearProgressIndicatorSpec r10) {
        super(r10);
        this.f3551c = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.e
    public void a(@NonNull Canvas r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
        Rect r12 = r10.getClipBounds();
        this.f3551c = r12.width();
        float r13 = ((LinearProgressIndicatorSpec) this.f3546a).f3521a;
        r10.translate(r12.left + (r12.width() / 2.0f), (r12.top + (r12.height() / 2.0f)) + Math.max(0.0f, (r12.height() - ((LinearProgressIndicatorSpec) this.f3546a).f3521a) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.f3546a).f3519i == false) goto L6;
        r10.scale(-1.0f, 1.0f);
    L6:
        if (this.f3547b.isShowing() == false) goto L10;
        if (((LinearProgressIndicatorSpec) this.f3546a).f3525e != 1) goto L10;
    L13:
        r10.scale(1.0f, -1.0f);
    L15:
        if (this.f3547b.isShowing() == false) goto L17;
    L18:
        r10.translate(0.0f, (((LinearProgressIndicatorSpec) this.f3546a).f3521a * (r11 - 1.0f)) / 2.0f);
    L19:
        float r14 = this.f3551c;
        r10.clipRect((-r14) / 2.0f, (-r13) / 2.0f, r14 / 2.0f, r13 / 2.0f);
        S r15 = this.f3546a;
        this.f3552d = ((LinearProgressIndicatorSpec) r15).f3521a * r11;
        this.f3553e = ((LinearProgressIndicatorSpec) r15).f3522b * r11;
        return;
    L17:
        if (this.f3547b.isHiding() == false) goto L19;
    L10:
        if (this.f3547b.isHiding() == false) goto L15;
        if (((LinearProgressIndicatorSpec) this.f3546a).f3526f != 2) goto L15;
        goto L13
    }

    @Override // com.google.android.material.progressindicator.e
    public void b(@NonNull Canvas r10, @NonNull Paint r11, @FloatRange(from = 0.0d, to = 1.0d) float r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @ColorInt int r14) {
        if (r12 != r13) goto L5;
        return;
    L5:
        float r15 = this.f3551c;
        float r16 = this.f3553e;
        float r17 = ((-r15) / 2.0f) + (r12 * (r15 - (r16 * 2.0f)));
        float r18 = (((-r15) / 2.0f) + (r13 * (r15 - (r16 * 2.0f)))) + (r16 * 2.0f);
        r11.setStyle(Paint.Style.FILL);
        r11.setAntiAlias(true);
        r11.setColor(r14);
        float r19 = this.f3552d;
        RectF r20 = new RectF(r17, (-r19) / 2.0f, r18, r19 / 2.0f);
        float r21 = this.f3553e;
        r10.drawRoundRect(r20, r21, r21, r11);
    }

    @Override // com.google.android.material.progressindicator.e
    void c(@NonNull Canvas r10, @NonNull Paint r11) {
        int r12 = t5.a.a(((LinearProgressIndicatorSpec) this.f3546a).f3524d, this.f3547b.getAlpha());
        r11.setStyle(Paint.Style.FILL);
        r11.setAntiAlias(true);
        r11.setColor(r12);
        float r13 = this.f3551c;
        float r14 = this.f3552d;
        RectF r15 = new RectF((-r13) / 2.0f, (-r14) / 2.0f, r13 / 2.0f, r14 / 2.0f);
        float r16 = this.f3553e;
        r10.drawRoundRect(r15, r16, r16, r11);
    }

    @Override // com.google.android.material.progressindicator.e
    public int d() {
        return ((LinearProgressIndicatorSpec) this.f3546a).f3521a;
    }

    @Override // com.google.android.material.progressindicator.e
    public int e() {
        return -1;
    }
}
