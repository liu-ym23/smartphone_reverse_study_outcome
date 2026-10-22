package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f1783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f1784b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f1785m;

    public k(i r8) {
        this.f1783a = new Paint.FontMetricsInt();
        this.f1785m = 1.0f;
        t2.b.n(r8, "metadata cannot be null");
        this.f1784b = r8;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r8, @SuppressLint({"UnknownNullness"}) CharSequence r10, int r11, int r12, Paint.FontMetricsInt r13) {
        Paint.FontMetricsInt r14 = this.f1783a;
        r8.getFontMetricsInt(r14);
        float r15 = Math.abs(r14.descent - r14.ascent) * 1.0f;
        i r16 = this.f1784b;
        p0.a r17 = r16.c();
        int r18 = r17.a(14);
        short r19 = 0;
        if (r18 == 0) goto L5;
        short r20 = r17.f9913b.getShort(r18 + r17.f9912a);
    L6:
        this.f1785m = r15 / r20;
        p0.a r21 = r16.c();
        int r22 = r21.a(14);
        if (r22 == 0) goto L9;
        r21.f9913b.getShort(r22 + r21.f9912a);
    L9:
        p0.a r23 = r16.c();
        int r24 = r23.a(12);
        if (r24 == 0) goto L12;
        r19 = r23.f9913b.getShort(r24 + r23.f9912a);
    L12:
        short r25 = (short) (r19 * this.f1785m);
        if (r13 == null) goto L15;
        r13.ascent = r14.ascent;
        r13.descent = r14.descent;
        r13.top = r14.top;
        r13.bottom = r14.bottom;
    L15:
        return r25;
    L5:
        r20 = 0;
        goto L6
    }
}
