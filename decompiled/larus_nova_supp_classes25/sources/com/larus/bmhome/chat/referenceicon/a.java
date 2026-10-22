package com.larus.bmhome.chat.referenceicon;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends Drawable {
    public final int a;
    public final int b;
    public final BitmapShader c;
    public final Matrix d;
    public final Paint e;
    public final RectF f;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.referenceicon.a$a, reason: collision with other inner class name */
    public static final class C0070a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        return -3;
    }

    public a(Bitmap r4) {
        Intrinsics.checkNotNullParameter(r4, "bitmap");
        this.a = RangesKt.coerceAtLeast(r4.getWidth(), 1);
        this.b = RangesKt.coerceAtLeast(r4.getHeight(), 1);
        Shader.TileMode r2 = Shader.TileMode.CLAMP;
        BitmapShader r0 = new BitmapShader(r4, r2, r2);
        this.c = r0;
        this.d = new Matrix();
        Paint r5 = new Paint(1);
        r5.setShader(r0);
        this.e = r5;
        this.f = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        float r0 = Math.min(this.f.width(), this.f.height()) * 0.2f;
        r4.drawRoundRect(this.f, r0, r0, this.e);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r6) {
        Intrinsics.checkNotNullParameter(r6, "bounds");
        super.onBoundsChange(r6);
        this.f.set(r6);
        float r0 = Math.max(r6.width() / this.a, r6.height() / this.b);
        float r1 = r6.left + ((r6.width() - (this.a * r0)) / 2.0f);
        float r2 = r6.top + ((r6.height() - (this.b * r0)) / 2.0f);
        this.d.setScale(r0, r0);
        this.d.postTranslate(r1, r2);
        this.c.setLocalMatrix(this.d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.e.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.e.setColorFilter(r2);
        invalidateSelf();
    }
}
