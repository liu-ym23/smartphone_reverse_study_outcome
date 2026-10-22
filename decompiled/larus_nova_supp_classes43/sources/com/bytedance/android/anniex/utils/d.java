package com.bytedance.android.anniex.utils;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends Drawable {
    public final Integer a;
    public final TextPaint b;
    public int c;
    public String d;

    public d() {
        this(0);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "PixelFormat.OPAQUE", imports = {"android.graphics.PixelFormat"}))
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    public d(int r10) {
        this.a = Integer.valueOf(ColorProtector.parseColor("#a63182f2"));
        TextPaint r11 = new TextPaint();
        Resources r0 = Resources.getSystem();
        r11.setTextSize((int) ((WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * 10.0f) + 0.5f));
        r11.setColor(-1);
        r11.setTextAlign(Paint.Align.LEFT);
        this.b = r11;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        String r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        SpannableString r11 = new SpannableString(r0);
        Integer r1 = this.a;
        if (r1 == null) goto L8;
        r1.intValue();
        r11.setSpan(new BackgroundColorSpan(this.a.intValue()), 0, r0.length(), 33);
    L8:
        StaticLayout r12 = new StaticLayout(r11, this.b, getBounds().width(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        if (r12.getLineCount() <= 0) goto L11;
        this.c = r12.getHeight();
    L11:
        r10.save();
        r10.translate(0.0f, getBounds().height() - this.c);
        r12.draw(r10);
        r10.restore();
    }
}
