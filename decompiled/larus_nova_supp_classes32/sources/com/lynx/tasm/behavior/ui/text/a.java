package com.lynx.tasm.behavior.ui.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.e;
import z6a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class a extends z6a.a {
    public static final /* synthetic */ int p = 0;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public int l;
    public float m;
    public e n;
    public Drawable.Callback o;

    public abstract Drawable c();

    public void d() {
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    @Override // z6a.a
    public final int a() {
        return this.f + this.k;
    }

    public final int b(Paint.FontMetricsInt r6) {
        int r0 = r6.descent;
        int r7 = r6.ascent;
        int r1 = r0 - r7;
        int r2 = this.f + this.k;
        switch(this.a) {
            case 1: goto L12;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L14;
            case 7: goto L16;
            case 8: goto L16;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L14;
        };
    L5:
        int r8 = -r2;
        float r3 = (this.b * r1) / 100.0f;
    L15:
        return r8 - ((int) r3);
    L6:
        r8 = -r2;
        r3 = this.b;
        goto L15
    L13:
        return r7;
    L14:
        return r7 + ((r1 - r2) / 2);
    L16:
        return r0 - r2;
    L17:
        return r7 + ((int) (r1 * 0.1f));
    L18:
        return (r0 - r2) - ((int) (r1 * 0.1f));
    L12:
        return -r2;
    }

    public void j(Drawable.Callback r1) {
        this.o = r1;
    }

    public static void i(Spanned r3, Drawable.Callback r4) {
        int r2 = 0;
        a[] r5 = (a[]) r3.getSpans(0, r3.length(), a.class);
        int r0 = r5.length;
    L3:
        if (r2 >= r0) goto L5;
        a r1 = r5[r2];
        r1.e();
        r1.j(r4);
        r2 = r2 + 1;
        goto L3
    }

    public a(int r4, int r5, int[] r6) {
        this.l = 0;
        this.m = 0.0f;
        this.g = r4;
        this.f = r5;
        int r7 = r6[0];
        this.h = r7;
        int r8 = r6[1];
        this.i = r8;
        this.j = r7 + r6[2];
        this.k = r8 + r6[3];
        this.a = 0;
        this.b = 0.0f;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        if ((r3 instanceof SpannableStringBuilder) == false) goto L6;
    L8:
        boolean r7 = false;
    L9:
        if (r7 == false) goto L11;
        return 0;
    L11:
        if (r6 == null) goto L35;
        if (r6.descent != r6.ascent) goto L16;
        r6.ascent = r2.getFontMetricsInt().ascent;
        r6.descent = r2.getFontMetricsInt().descent;
    L16:
        if (this.e == false) goto L21;
        float r8 = -(this.f + this.k);
        c r9 = this.d;
        if (r9 == null) goto L20;
        r8 = r9.a(this.a, this.b, r8, 0.0f);
    L20:
        this.c = (int) r8;
    L22:
        int r10 = r6.ascent;
        int r11 = this.c;
        if (r10 <= r11) goto L25;
        r6.ascent = r11;
    L25:
        int r12 = r6.descent;
        int r13 = (r11 + this.f) + this.k;
        if (r12 >= r13) goto L28;
        r6.descent = r13;
    L28:
        int r14 = r6.top;
        int r15 = r6.ascent;
        if (r14 <= r15) goto L31;
        r6.top = r15;
    L31:
        int r16 = r6.bottom;
        int r17 = r6.descent;
        if (r16 >= r17) goto L35;
        r6.bottom = r17;
        goto L35
    L21:
        this.c = b(r6);
    L35:
        return this.g + this.j;
    L6:
        if (r3.charAt(r4) == "I".charAt(0)) goto L8;
        r7 = true;
        goto L9
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r2, CharSequence r3, int r4, int r5, float r6, int r7, int r8, int r9, Paint r10) {
        boolean r0 = false;
        if ((r3 instanceof SpannableStringBuilder) == false) goto L6;
    L8:
        if (r0 == false) goto L11;
        return;
    L11:
        if (c() != null) goto L13;
        return;
    L13:
        Drawable r11 = c();
        r2.save();
        Paint.FontMetricsInt r12 = r10.getFontMetricsInt();
        int r13 = this.a;
        if (r13 != 4) goto L16;
        int r14 = r7;
    L31:
        if (this.l == 0) goto L33;
        Rect r15 = new Rect(Math.round(r6), Math.round(r7 + this.m), Math.round(r11.getBounds().width() + r6), Math.round(r9 + this.m));
        Paint r16 = new Paint();
        r16.setStyle(Paint.Style.FILL);
        r16.setColor(this.l);
        r2.drawRect(r15, r16);
    L33:
        r2.translate(r6 + this.h, (r14 + this.i) + this.m);
        e r17 = this.n;
        if (r17 == null) goto L40;
        BackgroundDrawable r18 = (BackgroundDrawable) r17.b;
        if (r18 == null) goto L40;
        r18.draw(r2);
        if (((BackgroundDrawable) this.n.b).l() == null) goto L40;
        r2.clipPath(((BackgroundDrawable) this.n.b).l());
    L40:
        r11.draw(r2);
        r2.restore();
        return;
    L16:
        if (r13 != 7) goto L18;
        r14 = (r9 - this.f) - this.k;
        goto L31
    L18:
        if (r13 != 11) goto L20;
        r14 = (((r9 + r7) - this.f) - this.k) / 2;
        goto L31
    L20:
        if (this.e == false) goto L23;
        int r19 = this.c;
    L26:
        r14 = r19 + r8;
        goto L31
    L23:
        if (r13 != 6) goto L25;
        r14 = (((r9 + r7) - this.f) - this.k) / 2;
        goto L31
    L25:
        r19 = b(r12);
        goto L26
    L6:
        if (r3.charAt(r4) == "I".charAt(0)) goto L8;
        r0 = true;
        goto L8
    }
}
