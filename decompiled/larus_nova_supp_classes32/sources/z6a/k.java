package z6a;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k extends MetricAffectingSpan {
    public int a;
    public float b;
    public int c;
    public c d;
    public float e;

    public k() {
        this.c = 0;
        this.e = 1.0E21f;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r11) {
        Paint.FontMetricsInt r0 = r11.getFontMetricsInt();
        if (this.e == 1.0E21f) goto L13;
        if (r0 == null) goto L13;
        c r1 = this.d;
        if (r1 == null) goto L13;
        float r2 = ((Float) ListProtector.get(r1.a, 1)).floatValue() - ((Float) ListProtector.get(this.d.a, 0)).floatValue();
        int r3 = this.a;
        if (r3 != 4) goto L11;
        this.c = -((int) ((((Math.ceil(this.e) - ((double) r2)) / 2.0d) + ((double) r0.ascent)) - ((double) ((Float) ListProtector.get(this.d.a, 0)).floatValue())));
        goto L13
    L11:
        if (r3 != 7) goto L13;
        this.c = (int) (((Math.ceil(this.e) - ((double) r2)) / 2.0d) + ((double) ((-r0.descent) + ((Float) ListProtector.get(this.d.a, 1)).floatValue())));
    L13:
        r11.baselineShift = this.c;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r7) {
        Paint.FontMetricsInt r0 = r7.getFontMetricsInt();
        if (r0 == null) goto L8;
        c r1 = this.d;
        if (r1 == null) goto L9;
        int r2 = ((int) r1.a(this.a, this.b, r0.ascent, r0.descent)) - r0.ascent;
        this.c = r2;
        r7.baselineShift = r2;
        return;
    L9:
        return;
    }
}
