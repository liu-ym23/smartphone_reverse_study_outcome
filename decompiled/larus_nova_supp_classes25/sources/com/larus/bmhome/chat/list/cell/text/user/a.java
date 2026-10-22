package com.larus.bmhome.chat.list.cell.text.user;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends ReplacementSpan {
    public static final float f = 0.0f;
    public static final int g = 0;
    public static final Typeface h = null;
    public final int a;
    public final int b;
    public final boolean c;
    public boolean d;
    public Drawable e;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.list.cell.text.user.a$a, reason: collision with other inner class name */
    public static final class C0066a {
    }

    static {
        Integer r0 = 17;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        float r1 = r0.floatValue();
        Resources r2 = Resources.getSystem();
        f = r1 * WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).scaledDensity;
        g = c7.e(Float.valueOf(25.5f));
        h = Typeface.create("sans-serif-medium", 0);
    }

    public final void a(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "icon");
        this.e = r2;
        this.d = true;
    }

    public /* synthetic */ a(Drawable r7, int r8, int r9) {
        this(r7, r8, r9, false, false);
    }

    public a(Drawable r2, int r3, int r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "icon");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r2;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r7, CharSequence r8, int r9, int r10, Paint.FontMetricsInt r11) {
        Intrinsics.checkNotNullParameter(r7, "paint");
        Intrinsics.checkNotNullParameter(r8, ChatDraftItem.TYPE_TEXT);
        float r0 = r7.getTextSize();
        Typeface r1 = r7.getTypeface();
        float r2 = r7.getLetterSpacing();
        r7.setTextSize(f);
        r7.setTypeface(h);
        r7.setLetterSpacing(0.0f);
        if (r11 != null) goto L18;
    L5:
        int r12 = this.a + this.b;     // Catch: Throwable -> L11
        if (this.c == false) goto L13;
        if (r9 >= r10) goto L13;
        if (r8.charAt(r9) != '@') goto L13;
        r9 = r9 + 1;     // Catch: Throwable -> L11
    L13:
        int r13 = r12 + ((int) r7.measureText(r8, r9, r10));
        r7.setTextSize(r0);
        r7.setTypeface(r1);
        r7.setLetterSpacing(r2);
        return r13;
    L11:
        th = move-exception;
        r7.setTextSize(r0);
        r7.setTypeface(r1);
        r7.setLetterSpacing(r2);
        throw th;
    L18:
        Paint.FontMetricsInt r3 = r7.getFontMetricsInt();     // Catch: Throwable -> L11
        int r4 = g;     // Catch: Throwable -> L11
        int r5 = r3.descent;     // Catch: Throwable -> L11
        int r6 = r3.ascent;     // Catch: Throwable -> L11
        int r14 = r6 - ((r4 - (r5 - r6)) / 2);     // Catch: Throwable -> L11
        r11.ascent = r14;     // Catch: Throwable -> L11
        int r15 = r4 + r14;     // Catch: Throwable -> L11
        r11.descent = r15;     // Catch: Throwable -> L11
        r11.top = r14;     // Catch: Throwable -> L11
        r11.bottom = r15;     // Catch: Throwable -> L11
        r11.leading = 0;     // Catch: Throwable -> L11
        goto L5
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r15, CharSequence r16, int r17, int r18, float r19, int r20, int r21, int r22, Paint r23) {
        int r2 = r17;
        Intrinsics.checkNotNullParameter(r15, "canvas");
        Intrinsics.checkNotNullParameter(r16, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r23, "paint");
        float r10 = r23.getTextSize();
        Typeface r11 = r23.getTypeface();
        float r12 = r23.getLetterSpacing();
        r23.setTextSize(f);
        r23.setTypeface(h);
        r23.setLetterSpacing(0.0f);
    L20:
        th = move-exception;
        r23.setTextSize(r10);
        r23.setTypeface(r11);
        r23.setLetterSpacing(r12);
        throw th;
    L4:
        if (this.c == true) goto L6;
    L8:
        float r5 = r21 + (((r23.getFontMetrics().ascent + r23.getFontMetrics().descent) - this.a) / 2.0f);     // Catch: Throwable -> L20
        r15.save();     // Catch: Throwable -> L20
        r15.translate(r19, r5);     // Catch: Throwable -> L20
        Drawable r6 = this.e;     // Catch: Throwable -> L20
        int r7 = this.a;     // Catch: Throwable -> L20
        r6.setBounds(0, 0, r7, r7);     // Catch: Throwable -> L20
        this.e.draw(r15);     // Catch: Throwable -> L20
        r15.restore();     // Catch: Throwable -> L20
    L10:
        if (this.c == false) goto L17;
        if (r2 >= r18) goto L17;
        if (r16.charAt(r17) != '@') goto L17;
        r2 = r2 + 1;     // Catch: Throwable -> L20
    L17:
        r15.drawText(r16, r2, r18, this.b + (this.a + r19), r21, r23);     // Catch: Throwable -> L20
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r23.setTextSize(r10);
        r23.setTypeface(r11);
        r23.setLetterSpacing(r12);
        return;
    L6:
        if (this.d == true) goto L8;
        r15.drawText("@", r19, r21, r23);     // Catch: Throwable -> L20
        goto L10
    }
}
