package is;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f18212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f18213b;

    public b(float r5) {
        this.f18213b = -1.0f;
        this.f18212a = r5;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r10, CharSequence r11, int r12, int r13, float r14, int r15, int r16, int r17, Paint r18) {
        if (this.f18213b >= 0.0f) goto L6;
        this.f18213b = r18.measureText(r11, r12, r13);
    L6:
        float r5 = this.f18213b;
        float r19 = this.f18212a * r5;
        int r20 = a.f18211a[Layout.Alignment.ALIGN_CENTER.ordinal()];
        if (r20 != 1) goto L9;
        float r21 = (r5 - r19) / 2.0f;
    L13:
        float r22 = r14 - r21;
    L15:
        r10.drawText(r11, r12, r13, r22, r16, r18);
        return;
    L9:
        if (r20 == 2) goto L12;
        r22 = r14;
        goto L15
    L12:
        r21 = r5 - r19;
        goto L13
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r5, CharSequence r10, int r11, int r12, Paint.FontMetricsInt r13) {
        if (this.f18213b >= 0.0f) goto L6;
        this.f18213b = r5.measureText(r10, r11, r12);
    L6:
        return (int) (this.f18213b * this.f18212a);
    }
}
