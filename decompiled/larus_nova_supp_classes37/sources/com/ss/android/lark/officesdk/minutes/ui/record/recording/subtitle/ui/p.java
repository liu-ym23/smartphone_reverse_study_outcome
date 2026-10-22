package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class p extends Drawable {
    public final float a;
    public final Paint b;
    public final RectF c;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        if (this.c.isEmpty() == true) goto L6;
        RectF r0 = this.c;
        float r1 = this.a;
        r4.drawRoundRect(r0, r1, r1, this.b);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.b.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.b.setColorFilter(r2);
        invalidateSelf();
    }

    public p(int r2, float r3) {
        this.a = r3;
        Paint r4 = new Paint(1);
        r4.setColor(r2);
        r4.setStyle(Paint.Style.FILL);
        this.b = r4;
        this.c = new RectF();
    }
}
