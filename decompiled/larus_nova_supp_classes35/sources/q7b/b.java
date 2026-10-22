package q7b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends ReplacementSpan implements com.ss.android.lark.widget.light.viewstub.b {
    public final Drawable a;
    public final int b;
    public final int c;
    public int d;

    public static final class a {
    }

    static {
    }

    public b(Drawable r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.a = r2;
        this.b = r3;
        this.c = 1;
        this.d = -1;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        Intrinsics.checkNotNullParameter(r2, "paint");
        Intrinsics.checkNotNullParameter(r3, "text");
        int r7 = this.d;
        if (r7 != (-1)) goto L5;
        Drawable r8 = this.a;
        r8.setBounds(0, 0, r8.getIntrinsicWidth(), this.a.getIntrinsicHeight());
        this.d = this.a.getBounds().width();
        if (r6 == null) goto L17;
        Paint.FontMetricsInt r9 = r2.getFontMetricsInt();
        int r10 = r9.descent;
        int r11 = this.a.getBounds().height();
        int r12 = this.c;
        if (r12 != 0) goto L12;
        int r13 = r9.bottom - r11;
        r6.ascent = r9.ascent + r13;
        r6.descent = r9.descent + r13;
    L15:
        r6.top = r6.ascent;
        r6.bottom = r6.descent;
        goto L17
    L12:
        if (r12 != 1) goto L14;
        int r14 = -r11;
        int r15 = r9.descent;
        r6.ascent = r14 + r15;
        r6.top = r14 + r15;
        r6.bottom = r15;
        r6.descent = r15;
        goto L15
    L14:
        int r16 = r9.bottom - r11;
        r6.ascent = r9.ascent + r16;
        r6.descent = r9.descent + r16;
    L17:
        return this.d + this.b;
    L5:
        return r7 + this.b;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r9, "paint");
        int r10 = this.c;
        if (r10 != 0) goto L5;
        int r11 = r8 - this.a.getBounds().height();
    L9:
        int r12 = r1.save();
        r1.translate(r5 + this.b, r11);     // Catch: Throwable -> L13
        this.a.draw(r1);     // Catch: Throwable -> L13
        r1.restoreToCount(r12);
        return;
    L13:
        th = move-exception;
        r1.restoreToCount(r12);
        throw th;
    L5:
        if (r10 == 1) goto L7;
        r11 = r6 + (((r8 - r6) - this.a.getBounds().height()) / 2);
        goto L9
    L7:
        r11 = (r7 - this.a.getBounds().height()) + ((int) (((double) r9.getFontMetricsInt().descent) / 1.5d));
        goto L9
    }
}
