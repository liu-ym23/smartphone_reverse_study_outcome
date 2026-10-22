package com.lynx.smartrefresh.layout.footer;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.graphics.ColorUtils;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import m6a.e;
import m6a.i;
import p6a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BallPulseFooter extends b implements e {
    public boolean d;
    public boolean e;
    public final Paint f;
    public int g;
    public int h;
    public final float i;
    public long j;
    public boolean k;
    public final TimeInterpolator l;

    public BallPulseFooter(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r19) {
        int r2 = getWidth();
        int r3 = getHeight();
        float r4 = Math.min(r2, r3);
        float r5 = this.i;
        float r6 = (r4 - (r5 * 2.0f)) / 6.0f;
        float r7 = r6 * 2.0f;
        float r8 = (r2 / 2.0f) - (r5 + r7);
        float r9 = r3 / 2.0f;
        long r10 = System.currentTimeMillis();
        int r11 = 0;
    L4:
        if (r11 >= 3) goto L14;
        int r12 = r11 + 1;
        long r13 = (r10 - this.j) - ((long) (r12 * 120));
        if (r13 <= 0) goto L8;
        float r14 = (r13 % 750) / 750.0f;
    L9:
        float r15 = ((AccelerateDecelerateInterpolator) this.l).getInterpolation(r14);
        r19.save();
        float r16 = r11;
        r19.translate(((r7 * r16) + r8) + (this.i * r16), r9);
        if (r15 >= 0.5d) goto L12;
        float r17 = 1.0f - ((r15 * 2.0f) * 0.7f);
        r19.scale(r17, r17);
    L13:
        r19.drawCircle(0.0f, 0.0f, r6, this.f);
        r19.restore();
        r11 = r12;
        goto L4
    L12:
        float r18 = ((r15 * 2.0f) * 0.7f) - 0.4f;
        r19.scale(r18, r18);
        goto L13
    L8:
        r14 = 0.0f;
        goto L9
    L14:
        super.dispatchDraw(r19);
        if (this.k == false) goto L21;
        invalidate();
        return;
    }

    @Override // p6a.b, m6a.g
    public void setPrimaryColors(int... r5) {
        if (this.e == true) goto L11;
        if (r5.length <= 1) goto L11;
        int r0 = r5[0];
        this.h = r0;
        this.e = true;
        if (this.k == false) goto L9;
        this.f.setColor(r0);
    L9:
        this.e = false;
    L11:
        if (this.d == false) goto L13;
        return;
    L13:
        if (r5.length <= 1) goto L18;
        int r6 = r5[1];
        this.g = r6;
        this.d = true;
        if (this.k == true) goto L22;
        this.f.setColor(r6);
    L22:
        this.d = false;
        return;
    L18:
        if (r5.length <= 0) goto L22;
        int r7 = ColorUtils.compositeColors(-1711276033, r5[0]);
        this.g = r7;
        this.d = true;
        if (this.k == true) goto L22;
        this.f.setColor(r7);
        goto L22
    }

    public BallPulseFooter(Context r5, AttributeSet r6) {
        super(r5, r6, 0);
        this.g = -1118482;
        this.h = -1615546;
        this.j = 0;
        this.k = false;
        this.l = new AccelerateDecelerateInterpolator();
        setMinimumHeight(r6a.b.c(60.0f));
        TypedArray r7 = r5.obtainStyledAttributes(r6, new int[]{2130974147, 2130974148, 2130974195});
        Paint r8 = new Paint();
        this.f = r8;
        r8.setColor(-1);
        r8.setStyle(Paint.Style.FILL);
        r8.setAntiAlias(true);
        this.b = n6a.b.d;
        this.b = n6a.b.h[r7.getInt(1, 0)];
        if (r7.hasValue(2) == false) goto L8;
        int r2 = r7.getColor(2, 0);
        this.g = r2;
        this.d = true;
        if (this.k == true) goto L8;
        r8.setColor(r2);
    L8:
        if (r7.hasValue(0) == false) goto L12;
        int r0 = r7.getColor(0, 0);
        this.h = r0;
        this.e = true;
        if (this.k == false) goto L12;
        r8.setColor(r0);
    L12:
        r7.recycle();
        this.i = r6a.b.c(4.0f);
    }

    @Override // p6a.b, m6a.g
    public final int e(SmartRefreshLayout r3, boolean r4) {
        this.k = false;
        this.j = 0;
        this.f.setColor(this.g);
        return 0;
    }

    @Override // p6a.b, m6a.g
    public final void n(i r1, int r2, int r3) {
        if (this.k == false) goto L5;
        return;
    L5:
        invalidate();
        this.k = true;
        this.j = System.currentTimeMillis();
        this.f.setColor(this.h);
    }
}
