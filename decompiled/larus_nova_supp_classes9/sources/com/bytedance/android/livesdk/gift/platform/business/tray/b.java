package com.bytedance.android.livesdk.gift.platform.business.tray;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends Drawable {
    public int a;
    public final GradientDrawable b;
    public final Paint c;

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

    public b() {
        this.b = new GradientDrawable();
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        Unit r1 = Unit.INSTANCE;
        this.c = r0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Rect r0 = getBounds();
        int r1 = Math.max(0, r0.height() - this.a);
        r10.drawRect(0.0f, 0.0f, r0.width(), r1, this.c);
        this.b.setBounds(0, r1, r0.width(), r0.height());
        this.b.draw(r10);
    }
}
