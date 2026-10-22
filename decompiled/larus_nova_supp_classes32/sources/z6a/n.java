package z6a;

import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n extends a {
    public int f;
    public int g;
    public int h;
    public int i;

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
    }

    public n() {
        if (this.e == false) goto L5;
        this.a = 1;
    L6:
        this.b = 0.0f;
        return;
    L5:
        this.a = 0;
        goto L6
    }

    @Override // z6a.a
    public final int a() {
        return this.f;
    }

    public final int b(int r2, int r3, int r4, int r5) {
        if (this.e == false) goto L5;
        int r6 = this.a;
        if (r6 != 4) goto L9;
        return r2;
    L9:
        if (r6 == 7) goto L15;
        if (r6 == 11) goto L18;
        return (r2 - r4) + this.c;
    L18:
        return ((r3 + r2) - this.f) / 2;
    L15:
        return r3 - this.f;
    L5:
        return (r3 - r5) - this.f;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r3, CharSequence r4, int r5, int r6, Paint.FontMetricsInt r7) {
        if (r7 == null) goto L40;
        if (r7.descent != r7.ascent) goto L7;
        r7.ascent = r3.getFontMetricsInt().ascent;
        r7.descent = r3.getFontMetricsInt().descent;
    L7:
        if (this.e == false) goto L17;
        int r8 = this.a;
        if (r8 != 1) goto L13;
        int r9 = this.h;
        if (r9 == 0) goto L13;
        this.c = -r9;
    L27:
        int r10 = r7.ascent;
        int r11 = this.c;
        if (r10 <= r11) goto L30;
        r7.ascent = r11;
    L30:
        int r12 = r7.descent;
        int r13 = r11 + this.f;
        if (r12 >= r13) goto L33;
        r7.descent = r13;
    L33:
        int r14 = r7.top;
        int r15 = r7.ascent;
        if (r14 <= r15) goto L36;
        r7.top = r15;
    L36:
        int r16 = r7.bottom;
        int r17 = r7.descent;
        if (r16 >= r17) goto L40;
        r7.bottom = r17;
    L13:
        float r18 = -this.f;
        c r19 = this.d;
        if (r19 == null) goto L16;
        r18 = r19.a(r8, this.b, r18, 0.0f);
    L16:
        this.c = (int) r18;
        goto L27
    L17:
        int r20 = r7.descent;
        int r21 = r7.ascent;
        int r22 = r20 - r21;
        int r23 = this.f;
        switch(this.a) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L26;
            case 5: goto L26;
            case 6: goto L19;
            case 7: goto L21;
            case 8: goto L21;
            case 9: goto L20;
            default: goto L19;
        };
    L19:
        r21 = r21 + ((r22 - r23) / 2);
        goto L26
    L20:
        int r24 = -r23;
        float r25 = this.b;
    L24:
        r21 = r24 - ((int) r25);
        goto L26
    L21:
        r21 = r20 - r23;
        goto L26
    L22:
        r21 = r21 + ((int) (r22 * 0.1f));
        goto L26
    L23:
        r24 = r20 - r23;
        r25 = r22 * 0.1f;
        goto L24
    L25:
        r21 = -r23;
    L26:
        this.c = r21;
    L40:
        return this.g;
    }
}
