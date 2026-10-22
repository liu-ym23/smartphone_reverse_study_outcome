package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q extends Drawable {
    public final Paint a;
    public final RectF b;
    public int c;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    public q() {
        Paint r0 = new Paint(1);
        r0.setColor(-16777216);
        r0.setStyle(Paint.Style.FILL);
        Unit r1 = Unit.INSTANCE;
        this.a = r0;
        this.b = new RectF();
        this.c = -1;
    }

    public final void a(int r1) {
        this.c = r1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        this.b.set(getBounds());
        int r0 = this.c;
        if (r0 < 0) goto L5;
        RectF r1 = this.b;
        r1.right = r1.left + r0;
    L5:
        RectF r2 = this.b;
        float r3 = 2;
        r5.drawRoundRect(r2, r2.height() / r3, this.b.height() / r3, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.a.setAlpha(r2);
        invalidateSelf();
    }
}
