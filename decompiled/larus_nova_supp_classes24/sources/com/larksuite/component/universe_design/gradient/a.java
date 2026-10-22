package com.larksuite.component.universe_design.gradient;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Xfermode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends c {
    public final int[] a;
    public final Paint b;
    public Shader c;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    public final Shader a() {
        float r0 = Math.min(getBounds().width(), getBounds().height());
        float r1 = (getBounds().left + r0) / 2.0f;
        float r3 = (getBounds().top + r0) / 2.0f;
        Matrix r2 = new Matrix();
        r2.preRotate(-45.0f, r1, r3);
        SweepGradient r4 = new SweepGradient(r1, r3, this.a, null);
        r4.setLocalMatrix(r2);
        return r4;
    }

    public a(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "colors");
        this.a = r2;
        Paint r3 = new Paint();
        r3.setAntiAlias(true);
        this.b = r3;
        this.c = a();
    }

    public final void b(Xfermode r2) {
        this.b.setXfermode(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        float r0 = Math.min(getBounds().width(), getBounds().height());
        this.b.setShader(this.c);
        int r1 = r10.save();
        if (getBounds().width() <= getBounds().height()) goto L5;
        r10.scale(getBounds().width() / getBounds().height(), 1.0f);
    L6:
        r10.drawRect(getBounds().left, getBounds().top, getBounds().left + r0, getBounds().top + r0, this.b);
        r10.restoreToCount(r1);
        return;
    L5:
        r10.scale(1.0f, getBounds().height() / getBounds().width());
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "bounds");
        super.onBoundsChange(r2);
        this.c = a();
    }
}
