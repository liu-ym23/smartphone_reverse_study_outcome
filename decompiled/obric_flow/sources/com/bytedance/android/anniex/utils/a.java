package com.bytedance.android.anniex.utils;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f3499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f3500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3501c;
    public String d;

    public a() {
        this.f3499a = Integer.valueOf(Color.parseColor("#a63182f2"));
        TextPaint r5 = new TextPaint();
        r5.setTextSize((int) ((Resources.getSystem().getDisplayMetrics().density * 10.0f) + 0.5f));
        r5.setColor(-1);
        r5.setTextAlign(Paint.Align.LEFT);
        this.f3500b = r5;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        String r5 = this.d;
        if (r5 != null) goto L5;
        return;
    L5:
        SpannableString r11 = new SpannableString(r5);
        Integer r12 = this.f3499a;
        if (r12 == null) goto L8;
        r11.setSpan(new BackgroundColorSpan(r12.intValue()), 0, r5.length(), 33);
    L8:
        StaticLayout r13 = new StaticLayout(r11, this.f3500b, getBounds().width(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        if (r13.getLineCount() <= 0) goto L11;
        this.f3501c = r13.getHeight();
    L11:
        r10.save();
        r10.translate(0.0f, getBounds().height() - this.f3501c);
        r13.draw(r10);
        r10.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
    }
}
