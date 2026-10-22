package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class BaseLightView extends View {
    public boolean a;
    public Matrix b;
    public float c;
    public Shader d;
    public Shader e;
    public ComposeShader f;
    public Matrix g;
    public Paint h;
    public Paint i;
    public Canvas j;
    public RectF k;
    public Bitmap l;
    public float m;
    public float n;

    public BaseLightView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        super.onDraw(r6);
        if (this.a == false) goto L11;
        this.j.drawPaint(this.i);
        float r0 = this.c - 30.0f;
        this.c = r0;
        this.b.setTranslate(r0, 0.0f);
        this.e.setLocalMatrix(this.b);
        ComposeShader r1 = new ComposeShader(this.d, this.e, PorterDuff.Mode.DST_ATOP);
        this.f = r1;
        r1.setLocalMatrix(this.g);
        this.h.setShader(this.f);
        this.j.drawRoundRect(this.k, 10.0f, 10.0f, this.h);
        this.h.setAlpha(128);
        r6.drawBitmap(this.l, 0.0f, 0.0f, this.h);
        float r7 = this.c;
        float r2 = (-this.m) / 2.0f;
        if (r7 > r2) goto L8;
        this.a = false;
    L8:
        if (r7 <= r2) goto L12;
        postInvalidateDelayed(20);
        return;
    L12:
        return;
    }

    public BaseLightView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.m = View.MeasureSpec.getSize(r1);
        this.n = View.MeasureSpec.getSize(r2);
    }

    public BaseLightView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        Paint r5 = new Paint();
        this.h = r5;
        r5.setAntiAlias(true);
        Paint r6 = new Paint();
        this.i = r6;
        r6.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.b = new Matrix();
        Matrix r7 = new Matrix();
        this.g = r7;
        r7.setTranslate(1.0f, 0.0f);
        this.m = getWidth();
        this.n = getHeight();
        this.k = new RectF(0.0f, 0.0f, this.m, this.n);
    }
}
