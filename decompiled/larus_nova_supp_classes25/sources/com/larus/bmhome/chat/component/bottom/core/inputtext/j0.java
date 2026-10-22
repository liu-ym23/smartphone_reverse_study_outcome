package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import android.util.TypedValue;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j0 extends ReplacementSpan {
    public static final float g = 0.0f;
    public static final int h = 0;
    public static final Typeface i = null;
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public boolean e;
    public Drawable f;

    public static final class a {
    }

    static {
        g = i5.x0(v19.c.b(2130972275, null, 2131167620));
        float r0 = Float.valueOf(25.5f).floatValue();
        Resources r1 = AppHost.a.getApplication().getResources();
        h = (int) TypedValue.applyDimension(2, r0, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()));
        i = Typeface.create("sans-serif-medium", 0);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r9, CharSequence r10, int r11, int r12, Paint.FontMetricsInt r13) {
        Intrinsics.checkNotNullParameter(r9, "paint");
        Intrinsics.checkNotNullParameter(r10, ChatDraftItem.TYPE_TEXT);
        int r0 = r9.getColor();
        float r1 = r9.getTextSize();
        Typeface r2 = r9.getTypeface();
        float r3 = r9.getLetterSpacing();
        r9.setColor(this.a);
        r9.setTextSize(g);
        r9.setTypeface(i);
        r9.setLetterSpacing(0.0f);
        int r4 = 0;
        if (r13 != null) goto L23;
    L5:
        Drawable r14 = this.f;     // Catch: Throwable -> L16
        if (r14 == null) goto L10;
        r4 = this.b + this.c;     // Catch: Throwable -> L16
    L10:
        if (this.d == false) goto L18;
        if (r14 == null) goto L18;
        if (r11 >= r12) goto L18;
        if (r10.charAt(r11) != '@') goto L18;
        r11 = r11 + 1;     // Catch: Throwable -> L16
    L18:
        int r5 = r4 + ((int) r9.measureText(r10, r11, r12));
        r9.setColor(r0);
        r9.setTextSize(r1);
        r9.setTypeface(r2);
        r9.setLetterSpacing(r3);
        return r5;
    L16:
        th = move-exception;
        r9.setColor(r0);
        r9.setTextSize(r1);
        r9.setTypeface(r2);
        r9.setLetterSpacing(r3);
        throw th;
    L23:
        Paint.FontMetricsInt r6 = r9.getFontMetricsInt();     // Catch: Throwable -> L16
        int r7 = h;     // Catch: Throwable -> L16
        int r8 = r6.descent;     // Catch: Throwable -> L16
        int r15 = r6.ascent;     // Catch: Throwable -> L16
        int r16 = r15 - ((r7 - (r8 - r15)) / 2);     // Catch: Throwable -> L16
        r13.ascent = r16;     // Catch: Throwable -> L16
        int r17 = r7 + r16;     // Catch: Throwable -> L16
        r13.descent = r17;     // Catch: Throwable -> L16
        r13.top = r16;     // Catch: Throwable -> L16
        r13.bottom = r17;     // Catch: Throwable -> L16
        r13.leading = 0;     // Catch: Throwable -> L16
        goto L5
    }

    public j0(Drawable r1, int r2, int r3, int r4, boolean r5, boolean r6) {
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r1;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r17, CharSequence r18, int r19, int r20, float r21, int r22, int r23, int r24, Paint r25) {
        int r2 = r19;
        Intrinsics.checkNotNullParameter(r17, "canvas");
        Intrinsics.checkNotNullParameter(r18, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r25, "paint");
        int r10 = r25.getColor();
        float r11 = r25.getTextSize();
        Typeface r12 = r25.getTypeface();
        float r13 = r25.getLetterSpacing();
        r25.setColor(this.a);
        r25.setTextSize(g);
        r25.setTypeface(i);
        r25.setLetterSpacing(0.0f);
        Drawable r5 = this.f;     // Catch: Throwable -> L28
        int r7 = 0;
        if (r5 == null) goto L12;
        if (this.d == true) goto L8;
    L10:
        float r8 = r23 + (((r25.getFontMetrics().ascent + r25.getFontMetrics().descent) - this.b) / 2.0f);     // Catch: Throwable -> L28
        r17.save();     // Catch: Throwable -> L28
        r17.translate(r21, r8);     // Catch: Throwable -> L28
        int r9 = this.b;     // Catch: Throwable -> L28
        r5.setBounds(0, 0, r9, r9);     // Catch: Throwable -> L28
        r5.draw(r17);     // Catch: Throwable -> L28
        r17.restore();     // Catch: Throwable -> L28
        goto L12
    L8:
        if (this.e == true) goto L10;
        r17.drawText("@", r21, r23, r25);     // Catch: Throwable -> L28
    L12:
        if (this.d == false) goto L21;
        if (this.f == null) goto L21;
        if (r2 >= r20) goto L21;
        if (r18.charAt(r19) != '@') goto L21;
        r2 = r2 + 1;     // Catch: Throwable -> L28
    L21:
        int r14 = r2;
        if (this.f == null) goto L25;
        r7 = this.c + this.b;     // Catch: Throwable -> L28
    L25:
        r17.drawText(r18, r14, r20, r7 + r21, r23, r25);     // Catch: Throwable -> L28
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L28
        r25.setColor(r10);
        r25.setTextSize(r11);
        r25.setTypeface(r12);
        r25.setLetterSpacing(r13);
        return;
    L28:
        th = move-exception;
        r25.setColor(r10);
        r25.setTextSize(r11);
        r25.setTypeface(r12);
        r25.setLetterSpacing(r13);
        throw th;
    }
}
