package z6a;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.LineHeightSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements LineHeightSpan.WithDensity {
    public final int a;
    public final boolean b;
    public final int c;
    public final boolean d;

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r1, int r2, int r3, int r4, int r5, Paint.FontMetricsInt r6) {
    }

    public final int hashCode() {
        return this.a + 31;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof f) == true) goto L5;
        return false;
    L5:
        if (this.a != ((f) r3).a) goto L9;
        return true;
    L9:
        return false;
    }

    public f(float r3, boolean r4, int r5, boolean r6) {
        if (r3 != 1.0E21f) goto L5;
        this.a = 0;
    L6:
        this.b = r4;
        this.c = r5;
        this.d = r6;
        return;
    L5:
        this.a = (int) Math.ceil(r3);
        goto L6
    }

    @Override // android.text.style.LineHeightSpan.WithDensity
    public final void chooseHeight(CharSequence r3, int r4, int r5, int r6, int r7, Paint.FontMetricsInt r8, TextPaint r9) {
        int r10 = 0;
        if (this.b == true) goto L5;
        int r11 = this.a;
        if (r11 == 0) goto L69;
        int r12 = r8.descent;
        if (r12 <= r11) goto L50;
        int r13 = Math.min(r11, r12);
        r8.descent = r13;
        r8.bottom = r13;
        r8.ascent = 0;
        r8.top = 0;
        return;
    L50:
        int r14 = r8.ascent;
        if (((-r14) + r12) <= r11) goto L53;
        r8.bottom = r12;
        int r15 = (-r11) + r12;
        r8.ascent = r15;
        r8.top = r15;
        return;
    L53:
        int r16 = r8.bottom;
        if (((-r14) + r16) <= r11) goto L56;
        r8.top = r14;
        r8.bottom = r14 + r11;
        return;
    L56:
        int r17 = r8.top;
        if (((-r17) + r16) <= r11) goto L59;
        r8.top = r16 - r11;
        return;
    L59:
        int r18 = Math.round((r11 - ((-r17) + r16)) / 2.0f);
        int r19 = Math.round((this.a - (r8.descent - r8.ascent)) / 2.0f);
        r8.top -= r18;
        r8.bottom += r18;
        r8.ascent -= r19;
        r8.descent += r19;
        return;
    L69:
        return;
    L5:
        if (this.c != 0) goto L7;
    L14:
        Rect r20 = null;
    L15:
        int r21 = this.a;
        if (r21 == 0) goto L33;
        if (r20 != null) goto L33;
        com.lynx.tasm.behavior.shadow.text.b.a(r21, r8, false);
        a[] r22 = (a[]) ((SpannableStringBuilder) r3).getSpans(r4, r5, a.class);
        int r23 = r22.length;
    L19:
        if (r10 >= r23) goto L74;
        a r24 = r22[r10];
        r24.getClass();
        int r25 = r8.ascent;
        int r26 = r24.c;
        if (r25 <= r26) goto L24;
        r8.ascent = r26;
    L24:
        if (r8.top <= r26) goto L26;
        r8.top = r26;
    L26:
        int r27 = r26 + r24.a();
        if (r8.descent >= r27) goto L30;
        r8.descent = r27;
    L30:
        if (r8.bottom >= r27) goto L32;
        r8.bottom = r27;
    L32:
        r10 = r10 + 1;
        goto L19
    L74:
        return;
    L33:
        if (r20 == null) goto L64;
        if (r21 != 0) goto L36;
        r21 = r8.bottom - r8.top;
    L36:
        int r28 = this.c;
        if (r28 != 4) goto L40;
        int r29 = r20.top;
        r8.ascent = r29;
        r8.top = r29;
        int r30 = r21 + r29;
        r8.descent = r30;
        r8.bottom = r30;
        return;
    L40:
        if (r28 != 7) goto L43;
        int r31 = r20.bottom;
        r8.descent = r31;
        r8.bottom = r31;
        int r32 = r31 - r21;
        r8.ascent = r32;
        r8.top = r32;
        return;
    L43:
        if (r28 != 11) goto L67;
        int r33 = r20.top - ((r21 - r20.height()) / 2);
        r8.top = r33;
        r8.ascent = r33;
        int r34 = r33 + r21;
        r8.bottom = r34;
        r8.descent = r34;
        return;
    L67:
        return;
    L64:
        return;
    L7:
        if (r3.length() != (r5 - r4)) goto L9;
    L10:
        r20 = new Rect();
        if (Build.VERSION.SDK_INT < 29) goto L13;
        r9.getTextBounds(r3, 0, r3.toString().length(), r20);
        goto L15
    L13:
        r9.getTextBounds(r3.toString(), 0, r3.toString().length(), r20);
        goto L15
    L9:
        if (this.d == false) goto L14;
        goto L10
    }
}
