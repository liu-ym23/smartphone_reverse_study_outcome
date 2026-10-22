package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class ECLiveExplainWaveView extends View {
    public static int[] l;
    public int a;
    public float b;
    public float c;
    public int d;
    public float e;
    public final int f;
    public float g;
    public final RectF h;
    public final Paint i;
    public int[] j;
    public boolean k;

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k = false;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public ECLiveExplainWaveView(Context r10) {
        super(r10);
        this.a = 4;
        this.b = 10.0f;
        this.c = 5.0f;
        this.d = -65536;
        this.e = 0.0f;
        this.f = 20;
        this.g = 0.0f;
        this.h = new RectF();
        this.i = new Paint();
        this.j = null;
        this.k = false;
        a(r10);
    }

    public final void a(Context r10) {
        this.a = 4;
        this.b = UIUtils.dip2Px(r10, 2.0f);
        this.c = UIUtils.dip2Px(r10, 2.0f);
        this.d = -65536;
        this.j = new int[this.a];
        this.i.setAntiAlias(true);
        this.i.setColor(this.d);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        super.onDraw(r11);
        if (this.a > 0) goto L5;
        return;
    L5:
        if (this.b > 0.0f) goto L7;
        return;
    L7:
        if (this.e <= 0.0f) goto L34;
        int r0 = getMeasuredHeight();
        int r10 = 0;
    L10:
        if (r10 >= this.a) goto L24;
        if (r10 <= 0) goto L13;
        float r12 = this.e * r10;
    L14:
        float r13 = (r10 * this.b) + r12;
        int r14 = this.j[r10];
        this.h.set(r13, r0 - Math.abs(r14), this.b + r13, r0);
        RectF r15 = this.h;
        float r16 = this.c;
        r11.drawRoundRect(r15, r16, r16, this.i);
        if (r14 < 0) goto L19;
        int r17 = (int) (r14 + this.g);
        if (r17 < r0) goto L22;
        r17 = r0 * (-1);
    L22:
        this.j[r10] = r17;
        r10 = r10 + 1;
        goto L10
    L19:
        r17 = (int) (r14 + this.g);
        if (r17 < 0) goto L22;
        r17 = 0;
        goto L22
    L13:
        r12 = 0.0f;
        goto L14
    L24:
        if (this.k == false) goto L35;
        invalidate();
        return;
    L35:
        return;
    }

    public void setWaveLineColor(int r10) {
        this.d = r10;
        this.i.setColor(r10);
    }

    public void setWaveLineRadius(float r1) {
        this.c = r1;
    }

    public void setWavePerLineWidth(float r1) {
        this.b = r1;
    }

    public ECLiveExplainWaveView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.a = 4;
        this.b = 10.0f;
        this.c = 5.0f;
        this.d = -65536;
        this.e = 0.0f;
        this.f = 20;
        this.g = 0.0f;
        this.h = new RectF();
        this.i = new Paint();
        this.j = null;
        this.k = false;
        a(r10);
    }

    @Override // android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r12 = getMeasuredWidth();
        int r13 = getMeasuredHeight();
        int r0 = this.a;
        if (r0 <= 0) goto L24;
        float r1 = this.b;
        if (r1 <= 0.0f) goto L25;
        this.e = ((r12 - (r0 * r1)) * 1.0f) / (r0 - 1);
        int[] r14 = l;
        int r15 = 0;
        if (r14 != null) goto L17;
        if (r0 != 4) goto L12;
        float r16 = r13;
        l = new int[]{(int) (0.8f * r16), (int) (0.3f * r16), (int) (0.6f * r16), (int) (r16 * 0.4f)};
    L15:
        r14 = l;
        goto L17
    L12:
        l = new int[r0];
        Random r17 = new Random();
        int r18 = 0;
    L13:
        if (r18 >= r0) goto L15;
        l[r18] = r17.nextInt(r13);
        r18 = r18 + 1;
    L17:
        if (r15 >= r14.length) goto L19;
        this.j[r15] = r14[r15];
        r15 = r15 + 1;
        goto L17
    L19:
        this.g = (r13 * 1.0f) / this.f;
        return;
    L25:
        return;
    }

    public ECLiveExplainWaveView(Context r1, AttributeSet r10, int r11) {
        super(r1, r10, r11);
        this.a = 4;
        this.b = 10.0f;
        this.c = 5.0f;
        this.d = -65536;
        this.e = 0.0f;
        this.f = 20;
        this.g = 0.0f;
        this.h = new RectF();
        this.i = new Paint();
        this.j = null;
        this.k = false;
        a(r1);
    }
}
