package z6a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Spannable;
import android.text.style.ReplacementSpan;
import com.lynx.tasm.behavior.shadow.text.BackgroundColorSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends ReplacementSpan {
    public final int a;
    public final float b;

    public d(int r1, float r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        return Math.round(r1.measureText(r2, r3, r4));
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r14, CharSequence r15, int r16, int r17, float r18, int r19, int r20, int r21, Paint r22) {
        Paint.FontMetrics r6 = r22.getFontMetrics();
        if ((r15 instanceof Spannable) == false) goto L11;
        Spannable r7 = (Spannable) r15;
        BackgroundColorSpan[] r8 = (BackgroundColorSpan[]) r7.getSpans(r16, r17, BackgroundColorSpan.class);
        if (r8 == null) goto L11;
        if (r8.length == 0) goto L11;
        Paint r9 = new Paint();
        r9.setStyle(Paint.Style.FILL);
        r9.setColor(r8[0].getBackgroundColor());
        Rect r11 = new Rect(Math.round(r18), r19, Math.round(r18 + r22.measureText(r7, r16, r17)), r21);
        r11.offset(0, Math.round(this.b));
        r14.drawRect(r11, r9);
    L11:
        int r10 = this.a;
        if (r10 != 0) goto L15;
        int r1 = -Math.round(r6.top);
    L27:
        r14.drawText(r15, r16, r17, r18, r1, r22);
        return;
    L15:
        if (r10 != 2) goto L18;
        r1 = r21 - Math.round(r6.leading);
        goto L27
    L18:
        if (r10 != 1) goto L23;
        r1 = (int) ((Math.round(Math.abs(r6.ascent)) + r19) + (((r21 - r19) - (r6.descent - r6.ascent)) / 2.0f));
        if (r6.leading != 0.0f) goto L27;
        float r2 = r1 + ((r6.descent / 2.0f) - r22.getStrokeMiter());
    L25:
        r1 = (int) r2;
        goto L27
    L23:
        if (r10 != 3) goto L26;
        r2 = r20 + this.b;
        goto L25
    L26:
        r1 = r20;
        goto L27
    }
}
