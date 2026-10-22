package com.bytedance.android.annie.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import y9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class DoubleColorBallAnimationView extends View {
    public int a;
    public int b;
    public Paint c;
    public final PorterDuffXfermode d;
    public float e;
    public boolean f;
    public boolean g;
    public int h;
    public boolean i;
    public long j;
    public int k;
    public float l;
    public float m;
    public float n;
    public float o;

    public final void a() {
        this.j = -1;
        if (this.k > 0) goto L5;
        setProgressBarInfo(getContext().getResources().getDimensionPixelSize(2131165301));
    L5:
        int r0 = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.k <= r0) goto L10;
        if (r0 <= 0) goto L10;
        setProgressBarInfo(r0);
    L10:
        if (this.c != null) goto L12;
        Paint r1 = new Paint();
        r1.setAntiAlias(true);
        r1.setDither(true);
        r1.setStyle(Paint.Style.FILL);
        this.c = r1;
    L12:
        this.g = true;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
        this.g = false;
        this.e = 0.0f;
    }

    public DoubleColorBallAnimationView(Context r10) {
        this(r10, null);
        b(r10);
    }

    public final void b(Context r10) {
        this.a = ContextCompat.getColor(r10, 2131100218);
        this.b = ContextCompat.getColor(r10, 2131100219);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r15) {
        super.onDraw(r15);
        if (this.i == true) goto L7;
        if (this.f == false) goto L7;
        return;
    L7:
        if (this.g == false) goto L39;
        boolean r10 = false;
        if (this.f == false) goto L18;
        long r11 = System.nanoTime() / 1000000;
        if (this.j >= 0) goto L14;
        this.j = r11;
    L14:
        float r0 = (r11 - this.j) / 400.0f;
        this.e = r0;
        int r12 = (int) r0;
        if (((this.h + r12) & 1) != 1) goto L17;
        r10 = true;
    L17:
        this.e = r0 - r12;
    L18:
        float r1 = this.e;
        if (r1 >= 0.5f) goto L21;
        float r13 = (r1 * 2.0f) * r1;
    L22:
        int r14 = this.k;
        int r16 = r15.saveLayer(0.0f, 0.0f, r14, r14, this.c, 31);
        float r17 = (this.o * r13) + this.n;
        if (r13 >= 0.5f) goto L25;
        float r18 = r13 * 2.0f;
    L26:
        float r19 = this.m;
        float r20 = ((0.25f * r18) * r19) + r19;
        Paint r21 = this.c;
        if (r10 == false) goto L29;
        int r22 = this.b;
    L30:
        r21.setColor(r22);
        r15.drawCircle(r17, this.l, r20, this.c);
        float r23 = this.k - r17;
        float r24 = this.m;
        float r25 = r24 - ((r18 * 0.375f) * r24);
        Paint r26 = this.c;
        if (r10 == false) goto L33;
        int r27 = this.a;
    L34:
        r26.setColor(r27);
        this.c.setXfermode(this.d);
        r15.drawCircle(r23, this.l, r25, this.c);
        this.c.setXfermode(null);
        r15.restoreToCount(r16);
        i<Long> r110 = AnnieConfigSettingKeys.ANNIE_DOUBLE_COLOR_BALL_DELAY;
        if (r110.a().longValue() <= 0) goto L37;
        postInvalidateDelayed(r110.a().longValue());
        return;
    L37:
        postInvalidateDelayed(17);
        return;
    L33:
        r27 = this.b;
        goto L34
    L29:
        r22 = this.a;
        goto L30
    L25:
        r18 = 2.0f - (r13 * 2.0f);
        goto L26
    L21:
        r13 = ((r1 * 2.0f) * (2.0f - r1)) - 1.0f;
        goto L22
    }

    public void setCycleBias(int r1) {
        this.h = r1;
    }

    public void setProgress(float r10) {
        if (this.g == true) goto L5;
        a();
    L5:
        this.e = r10;
        this.i = false;
        this.f = false;
        postInvalidate();
    }

    public void setProgressBarInfo(int r10) {
        if (r10 <= 0) goto L5;
        this.k = r10;
        this.l = r10 / 2.0f;
        float r0 = (r10 >> 1) * 0.32f;
        this.m = r0;
        float r11 = (r10 * 0.16f) + r0;
        this.n = r11;
        this.o = r10 - (r11 * 2.0f);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        if (r1 != 0) goto L5;
        a();
        this.i = true;
        this.f = true;
        postInvalidate();
        return;
    L5:
        this.i = false;
        this.g = false;
        this.e = 0.0f;
    }

    public DoubleColorBallAnimationView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
        b(r10);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r10) {
        super.onMeasure(r1, r10);
        int r11 = Math.min(View.MeasureSpec.getSize(r1), View.MeasureSpec.getSize(r10));
        if (this.k <= r11) goto L7;
        if (r11 <= 0) goto L8;
        setProgressBarInfo(r11);
        return;
    L8:
        return;
    }

    public DoubleColorBallAnimationView(Context r1, AttributeSet r10, int r11) {
        super(r1, r10, r11);
        this.d = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.f = false;
        this.g = false;
        this.h = 0;
        this.i = false;
        this.j = -1;
        this.k = -1;
        b(r1);
    }
}
