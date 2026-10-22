package com.larus.utils;

import android.R;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x extends Drawable {
    public final float a;
    public final int[] b;
    public final float c;
    public final float d;
    public final int e;
    public final Integer f;
    public final Path g;
    public final RectF h;
    public final Paint i;
    public final Paint j;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        if (this.f == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        if (this.j.getColor() == 0) goto L5;
        r3.drawPath(this.g, this.j);
    L5:
        r3.drawPath(this.g, this.i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r11) {
        Intrinsics.checkNotNullParameter(r11, "bounds");
        super.onBoundsChange(r11);
        this.i.setShader(new LinearGradient(0.0f, 0.0f, r11.width(), 0.0f, this.b, null, Shader.TileMode.CLAMP));
        this.i.setAlpha((int) (255 * this.d));
        this.g.reset();
        this.h.set(r11);
        RectF r12 = this.h;
        float r0 = this.a;
        float r1 = 2;
        r12.inset(r0 / r1, r0 / r1);
        Path r13 = this.g;
        RectF r2 = this.h;
        float r3 = this.c;
        r13.addRoundRect(r2, r3, r3, Path.Direction.CW);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if (this.f != null) goto L6;
        return false;
    L6:
        if (ArraysKt.contains(r3, R.attr.state_pressed) == false) goto L8;
        int r4 = this.f.intValue();
    L10:
        if (this.j.getColor() == r4) goto L13;
        this.j.setColor(r4);
        invalidateSelf();
        return true;
    L13:
        return false;
    L8:
        r4 = this.e;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.i.setAlpha(r2);
        this.j.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.i.setColorFilter(r2);
        this.j.setColorFilter(r2);
        invalidateSelf();
    }

    public x(float r2, int[] r3, float r4, float r5, int r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r3, "colors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = new Path();
        this.h = new RectF();
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.STROKE);
        r8.setStrokeWidth(r2);
        this.i = r8;
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.FILL);
        r9.setColor(r6);
        this.j = r9;
    }
}
