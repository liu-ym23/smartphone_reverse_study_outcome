package com.bytedance.android.live.liveinteract.revenue.fight.view;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class TeamFightProgressBar extends View {
    public static final int r = 0;
    public static final int s = 0;
    public float a;
    public final Paint b;
    public int c;
    public int d;
    public final RectF e;
    public final RectF f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public ValueAnimator n;
    public a o;
    public boolean p;
    public boolean q;

    public interface a {
        void a(float r1);

        void onProgressChange();
    }

    static {
        r = s1.f(16.0f);
        s = s1.f(20.0f);
    }

    private Path getClipPath() {
        float r0 = getLeftPaddingOffset();
        float r1 = getTopPaddingOffset();
        float r2 = getRightPaddingOffset();
        float r3 = getBottomPaddingOffset();
        float r4 = (getWidth() - r0) - r2;
        float r5 = (getHeight() - r1) - r3;
        Path r6 = new Path();
        r6.moveTo(r0, r1);
        float r7 = r4 + r0;
        r6.lineTo(r7, r1);
        float r8 = r5 + r1;
        r6.lineTo(r7, r8);
        r6.lineTo(r0, r8);
        r6.lineTo(r0, r1);
        r6.close();
        return r6;
    }

    public int getLeftValue() {
        return this.c;
    }

    public float getProgress() {
        return this.a;
    }

    public int getRightValue() {
        return this.d;
    }

    public TeamFightProgressBar(Context r2) {
        this(r2, null);
    }

    private void setProgress(float r4) {
        this.o.onProgressChange();
        float r0 = this.a;
        ValueAnimator r1 = this.n;
        if (r1 != null) goto L5;
    L7:
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{r0, r4});
        this.n = r5;
        r5.setDuration(300);
        this.n.addUpdateListener(new d(this));
        this.n.start();
        return;
    L5:
        if (r1.isRunning() == false) goto L7;
        this.n.cancel();
        goto L7
    }

    public final int a(boolean r1) {
        if (r1 == false) goto L9;
        if (this.q == false) goto L7;
        return s;
    L7:
        return r;
    L9:
        return r;
    }

    public final void b(int r2) {
        if (this.l != r2) goto L5;
        return;
    L5:
        this.l = r2;
        invalidate();
    }

    public final void c(int r2) {
        if (this.m != r2) goto L5;
        return;
    L5:
        this.m = r2;
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r18) {
        super.onDraw(r18);
        float r2 = this.a;
        int r3 = getWidth();
        int r4 = this.k;
        float r5 = (r2 * (r3 - (r4 * 2))) + r4;
        if (r5 <= 0.0f) goto L8;
        int r6 = this.l;
        if (r5 >= r6) goto L8;
        r5 = r6;
    L8:
        if ((getWidth() - r5) > 0.0f) goto L10;
    L12:
        RectF r7 = this.e;
        r7.right = r5;
        r7.bottom = a(true);
        RectF r8 = this.f;
        r8.left = r5;
        r8.top = (a(true) - a(false)) / 2;
        RectF r9 = this.f;
        r9.bottom = r9.top + a(false);
        this.f.right = getWidth();
        r18.clipPath(getClipPath());
        if (this.p == false) goto L15;
        RectF r10 = this.e;
        this.b.setShader(new LinearGradient(r10.left, r10.top, r10.right, a(true), this.g, this.h, Shader.TileMode.MIRROR));
        r18.drawRect(this.e, this.b);
        RectF r11 = this.f;
        this.b.setShader(new LinearGradient(r11.left, r11.top, r11.right, a(false), this.i, this.j, Shader.TileMode.MIRROR));
        r18.drawRect(this.f, this.b);
    L28:
        this.b.setShader(null);
        return;
    L15:
        RectF r12 = this.f;
        this.b.setShader(new LinearGradient(r12.left, r12.top, r12.right, a(false), this.i, this.j, Shader.TileMode.MIRROR));
        r18.drawRect(this.f, this.b);
        RectF r13 = this.e;
        this.b.setShader(new LinearGradient(r13.left, r13.top, r13.right, a(true), this.g, this.h, Shader.TileMode.MIRROR));
        int r14 = li0.a.a;
        float r15 = r5 + s1.f(7.0f);
        float r16 = getHeight();
        Path r17 = new Path();
        float r19 = 0;
        float r20 = 24.0f;
        if (24.0f >= r19) goto L18;
        float r21 = 0.0f;
    L19:
        if (24.0f >= r19) goto L21;
        r20 = 0.0f;
    L21:
        float r22 = r15 - 0.0f;
        float r23 = r16 - 0.0f;
        float r24 = 2;
        float r110 = r22 / r24;
        if (r21 <= r110) goto L24;
        r21 = r110;
    L24:
        float r111 = r23 / r24;
        if (r20 <= r111) goto L27;
        r20 = r111;
    L27:
        float r25 = r22 - (r24 * r21);
        float r26 = r23 - (r24 * r20);
        r17.moveTo(r15, 0.0f + r20);
        float r27 = -r20;
        float r28 = -r21;
        r17.rQuadTo(0.0f, r27, r28, r27);
        r17.rLineTo(-r25, 0.0f);
        r17.rLineTo(r28, 0.0f);
        r17.rLineTo(0.0f, r20);
        r17.rLineTo(0.0f, r26);
        r17.rLineTo(0.0f, r20);
        r17.rLineTo(r21, 0.0f);
        r17.rLineTo(r25, 0.0f);
        r17.rQuadTo(r21, 0.0f, r21, r27);
        r17.rLineTo(0.0f, -r26);
        r17.close();
        r18.drawPath(r17, this.b);
        goto L28
    L18:
        r21 = 24.0f;
        goto L19
    L10:
        if ((getWidth() - r5) >= this.m) goto L12;
        r5 = getWidth() - this.m;
        goto L12
    }

    public void setEnlarge(boolean r1) {
        this.q = r1;
        invalidate();
    }

    public void setLeftValue(int r3) {
        this.p = false;
        this.c = r3;
        int r0 = this.d;
        if ((r0 + r3) != 0) goto L5;
        this.p = true;
        setProgress(0.5f);
        return;
    L5:
        setProgress(r3 / (r3 + r0));
    }

    public void setOnProgressChangeListener(a r1) {
        this.o = r1;
    }

    public void setRightValue(int r3) {
        this.p = false;
        this.d = r3;
        int r0 = this.c;
        if ((r3 + r0) != 0) goto L5;
        this.p = true;
        setProgress(0.5f);
        return;
    L5:
        setProgress(r0 / (r0 + r3));
    }

    public TeamFightProgressBar(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.seekBarStyle);
    }

    public TeamFightProgressBar(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.k = s1.f(30.0f);
        this.l = 0;
        this.m = 0;
        this.p = true;
        this.q = false;
        this.d = 0;
        this.c = 0;
        this.a = 0.5f;
        this.g = ColorProtector.parseColor("#fd2d55");
        this.h = ColorProtector.parseColor("#ff3ce3");
        this.i = ColorProtector.parseColor("#7ddeff");
        this.j = ColorProtector.parseColor("#606bff");
        Paint r6 = new Paint();
        this.b = r6;
        r6.setTypeface(Typeface.DEFAULT_BOLD);
        r6.setStyle(Paint.Style.FILL);
        r6.setDither(true);
        r6.setAntiAlias(true);
        this.e = new RectF(0.0f, 0.0f, this.a * getWidth(), a(true));
        this.f = new RectF(this.a * getWidth(), 0.0f, getWidth(), a(false));
    }
}
