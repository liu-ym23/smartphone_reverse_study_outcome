package com.bytedance.android.live.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveCircleView extends View {
    public Paint a;
    public float b;
    public int c;
    public int d;
    public float e;
    public float f;
    public int g;
    public Paint h;

    public LiveCircleView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        super.onDraw(r5);
        r5.drawCircle(this.c, this.d, this.e, this.a);
        r5.drawCircle(this.c, this.d, this.f, this.h);
    }

    public void setFraction(float r4) {
        this.f = this.e + (this.g * r4);
        this.h.setStrokeWidth(this.b * (1.0f - r4));
        postInvalidate();
    }

    public void setStrokeWidth(int r1) {
        this.b = r1;
    }

    public LiveCircleView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.c = getMeasuredWidth() / 2;
        this.d = getMeasuredHeight() / 2;
        float r3 = (getMeasuredHeight() / 2) - getPaddingBottom();
        this.e = r3;
        this.f = r3;
        this.g = getPaddingBottom();
    }

    public LiveCircleView(Context r9, AttributeSet r11, int r12) {
        super(r9, r11, r12);
        this.b = (int) UIUtils.dip2Px(r9, 1.0f);
        this.a = new Paint();
        this.a.setShader(new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, ColorProtector.parseColor("#FF1764"), ColorProtector.parseColor("#ED3495"), Shader.TileMode.MIRROR));
        this.a.setAntiAlias(true);
        this.a.setDither(true);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(UIUtils.dip2Px(r9, 1.0f));
        this.h = new Paint(this.a);
    }
}
