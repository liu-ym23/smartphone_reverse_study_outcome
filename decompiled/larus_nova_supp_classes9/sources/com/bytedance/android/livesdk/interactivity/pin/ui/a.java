package com.bytedance.android.livesdk.interactivity.pin.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends Drawable {
    public final Paint a;
    public final RectF b;
    public float c;
    public final float d;

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

    public a(int r3) {
        this.d = UtilityKotlinExtentionsKt.h(8);
        Paint r0 = new Paint(1);
        r0.setColor(r3);
        r0.setStyle(Paint.Style.FILL);
        Unit r4 = Unit.INSTANCE;
        this.a = r0;
        this.b = new RectF();
        this.c = UtilityKotlinExtentionsKt.h(72);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        this.b.set(getBounds());
        float r0 = this.c;
        if (r0 <= 0.0f) goto L5;
        RectF r1 = this.b;
        r1.bottom = r1.top + r0;
    L5:
        RectF r2 = this.b;
        float r3 = this.d;
        r4.drawRoundRect(r2, r3, r3, this.a);
    }
}
