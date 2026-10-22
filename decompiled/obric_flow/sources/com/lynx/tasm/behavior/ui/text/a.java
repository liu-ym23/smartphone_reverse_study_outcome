package com.lynx.tasm.behavior.ui.text;

import ai.j0;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends zm.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f10695p = 0;
    public final int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f10696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f10697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f10698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f10699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10700l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f10701m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g f10702n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable.Callback f10703o;

    public a(int r5, int r10, int[] r11) {
        this.f10700l = 0;
        this.f10701m = 0.0f;
        this.g = r5;
        this.f = r10;
        int r12 = r11[0];
        this.f10696h = r12;
        int r13 = r11[1];
        this.f10697i = r13;
        this.f10698j = r12 + r11[2];
        this.f10699k = r13 + r11[3];
        this.f23456a = 0;
        this.f23457b = 0.0f;
    }

    public static void d(Spanned r5, Drawable.Callback r10) {
        int r11 = 0;
        a[] r12 = (a[]) r5.getSpans(0, r5.length(), a.class);
        int r13 = r12.length;
    L3:
        if (r11 >= r13) goto L5;
        a r14 = r12[r11];
        r14.g();
        r14.c(r10);
        r11 = r11 + 1;
        goto L3
    }

    @Override // zm.a
    public final int a() {
        return this.f + this.f10699k;
    }

    public final int b(Paint.FontMetricsInt r10) {
        int r5 = r10.descent;
        int r11 = r10.ascent;
        int r12 = r5 - r11;
        int r13 = this.f + this.f10699k;
        switch(this.f23456a) {
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L5;
            case 7: goto L11;
            case 8: goto L11;
            case 9: goto L9;
            case 10: goto L7;
            default: goto L5;
        };
    L12:
        return r11;
    L5:
        return j0.c(r12, r13, 2, r11);
    L7:
        return (-r13) - ((int) ((this.f23457b * r12) / 100.0f));
    L9:
        return (-r13) - ((int) this.f23457b);
    L11:
        return r5 - r13;
    L14:
        return r11 + ((int) (r12 * 0.1f));
    L16:
        return (r5 - r13) - ((int) (r12 * 0.1f));
    L18:
        return -r13;
    }

    public abstract void c(Drawable.Callback r5);

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r5, CharSequence r10, int r11, int r12, float r13, int r14, int r15, int r16, Paint r17) {
        if ((r10 instanceof SpannableStringBuilder) == true) goto L9;
        if (r10.charAt(r11) == "I".charAt(0)) goto L9;
        return;
    L9:
        if (e() != null) goto L11;
        return;
    L11:
        Drawable r18 = e();
        r5.save();
        Paint.FontMetricsInt r19 = r17.getFontMetricsInt();
        int r20 = this.f23456a;
        if (r20 == 4) goto L26;
        int r21 = this.f10699k;
        int r22 = this.f;
        if (r20 != 7) goto L16;
        int r23 = (r16 - r22) - r21;
    L28:
        if (this.f10700l == 0) goto L30;
        Rect r24 = new Rect(Math.round(r13), Math.round(r14 + this.f10701m), Math.round(r18.getBounds().width() + r13), Math.round(r16 + this.f10701m));
        Paint r25 = new Paint();
        r25.setStyle(Paint.Style.FILL);
        r25.setColor(this.f10700l);
        r5.drawRect(r24, r25);
    L30:
        r5.translate(r13 + this.f10696h, (r23 + this.f10697i) + this.f10701m);
        g r26 = this.f10702n;
        if (r26 == null) goto L37;
        BackgroundDrawable r27 = (BackgroundDrawable) r26.f10750b;
        if (r27 == null) goto L37;
        r27.draw(r5);
        if (((BackgroundDrawable) this.f10702n.f10750b).p() == null) goto L37;
        r5.clipPath(((BackgroundDrawable) this.f10702n.f10750b).p());
    L37:
        r18.draw(r5);
        r5.restore();
        return;
    L16:
        if (r20 != 11) goto L18;
        r23 = (((r16 + r14) - r22) - r21) / 2;
        goto L28
    L18:
        if (this.e == false) goto L21;
        r23 = r15 + this.f23458c;
        goto L28
    L21:
        if (r20 != 6) goto L23;
        r23 = (((r16 + r14) - r22) - r21) / 2;
        goto L28
    L23:
        r23 = r15 + b(r19);
        goto L28
    L26:
        r23 = r14;
        goto L28
    }

    public abstract Drawable e();

    public void f() {
    }

    public abstract void g();

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r5, CharSequence r10, int r11, int r12, Paint.FontMetricsInt r13) {
        if ((r10 instanceof SpannableStringBuilder) == false) goto L6;
    L8:
        if (r13 == null) goto L32;
        if (r13.descent != r13.ascent) goto L12;
        r13.ascent = r5.getFontMetricsInt().ascent;
        r13.descent = r5.getFontMetricsInt().descent;
    L12:
        boolean r14 = this.e;
        int r15 = this.f10699k;
        int r16 = this.f;
        if (r14 == false) goto L18;
        float r17 = -(r16 + r15);
        zm.c r18 = this.d;
        if (r18 == null) goto L17;
        r17 = r18.c(this.f23456a, this.f23457b, r17, 0.0f);
    L17:
        this.f23458c = (int) r17;
    L19:
        int r19 = r13.ascent;
        int r20 = this.f23458c;
        if (r19 <= r20) goto L22;
        r13.ascent = r20;
    L22:
        int r21 = (r20 + r16) + r15;
        if (r13.descent >= r21) goto L25;
        r13.descent = r21;
    L25:
        int r22 = r13.top;
        int r23 = r13.ascent;
        if (r22 <= r23) goto L28;
        r13.top = r23;
    L28:
        int r24 = r13.bottom;
        int r25 = r13.descent;
        if (r24 >= r25) goto L32;
        r13.bottom = r25;
        goto L32
    L18:
        this.f23458c = b(r13);
    L32:
        return this.g + this.f10698j;
    L6:
        if (r10.charAt(r11) == "I".charAt(0)) goto L8;
        return 0;
    }

    public abstract void h();

    public abstract void i();

    public abstract void j();
}
