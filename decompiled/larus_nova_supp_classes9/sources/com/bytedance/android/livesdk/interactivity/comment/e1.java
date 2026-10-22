package com.bytedance.android.livesdk.interactivity.comment;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e1 extends Drawable {
    public final Paint a;
    public final RectF b;
    public final float c;
    public final int d;
    public final int e;

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

    public e1() {
        this.a = new Paint(1);
        this.b = new RectF();
        this.c = 1.0f;
        this.d = ColorProtector.parseColor("#4D000000");
        this.e = ColorProtector.parseColor("#4DFFFFFF");
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        this.b.set(getBounds());
        this.b.right -= this.c;
        this.a.setColor(this.d);
        this.a.setStyle(Paint.Style.FILL);
        RectF r0 = this.b;
        float r2 = 2;
        r6.drawRoundRect(r0, r0.height() / r2, this.b.height() / r2, this.a);
        this.a.setColor(this.e);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.c);
        RectF r1 = this.b;
        float r3 = this.c;
        r1.inset(r3 / r2, r3 / r2);
        RectF r4 = this.b;
        r6.drawRoundRect(r4, r4.height() / r2, this.b.height() / r2, this.a);
    }
}
