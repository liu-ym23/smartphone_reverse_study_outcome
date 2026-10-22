package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends Drawable {
    public final Drawable a;
    public final String b;
    public final Paint c;
    public final float d;
    public final float e;
    public final GradientDrawable f;
    public final float g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        this.f.setBounds(getBounds());
        this.f.draw(r6);
        Drawable r0 = this.a;
        if (r0 == null) goto L5;
        r0.setBounds(this.h, this.i, this.j, this.k);
        this.a.draw(r6);
    L5:
        r6.drawText(this.b, (this.d / 2) + this.g, getBounds().exactCenterY() + this.e, this.c);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.c.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.c.setColorFilter(r2);
        invalidateSelf();
    }

    public static float a(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
    }

    public g(Context r3, String r4, int r5, int r6, int r7, float r8, int r9) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "text");
        this.a = null;
        this.b = r4;
        Paint r0 = new Paint(1);
        r0.setColor(r6);
        r0.setTextSize(r8);
        r0.setTextAlign(Paint.Align.CENTER);
        this.c = r0;
        float r10 = r0.measureText(r4);
        this.d = r10;
        this.e = (((r0.getFontMetrics().bottom - r0.getFontMetrics().top) / 2) - r0.getFontMetrics().bottom) - a(r3, 0.0f);
        GradientDrawable r11 = new GradientDrawable();
        r11.setColor(r5);
        r11.setCornerRadius(a(r3, 2));
        this.f = r11;
        float r12 = r7;
        this.g = a(r3, 4.0f) + a(r3, r12);
        this.h = (int) a(r3, r12 + 4.0f);
        this.i = (int) a(r3, 0.0f);
        float r13 = 12;
        this.j = (int) a(r3, (4.0f + r13) + r12);
        this.k = (int) a(r3, 0.0f + r13);
        setBounds(new Rect((int) a(r3, r12), 0, ((int) (a(r3, 8.0f) + r10)) + ((int) a(r3, r12)), (int) a(r3, r9)));
    }
}
