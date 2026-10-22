package r;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.w;
import com.airbnb.lottie.z;
import l.n;

/* JADX INFO: loaded from: classes.dex */
public final class j extends c {
    public n A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f21624v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final j.a f21625w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float[] f21626x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Path f21627y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final g f21628z;

    public j(w r5, g r10) {
        super(r5, r10);
        this.f21624v = new RectF();
        j.a r11 = new j.a();
        this.f21625w = r11;
        this.f21626x = new float[8];
        this.f21627y = new Path();
        this.f21628z = r10;
        r11.setAlpha(0);
        r11.setStyle(Paint.Style.FILL);
        r11.setColor(r10.f21613l);
    }

    @Override // r.c, o.f
    public final void c(ColorFilter r5, v.c r10) {
        super.c(r5, r10);
        if (r5 != z.f1375y) goto L6;
        this.A = new n(r10, null);
        return;
    }

    @Override // r.c, k.e
    public final void e(RectF r5, Matrix r10, boolean r11) {
        super.e(r5, r10, r11);
        RectF r12 = this.f21624v;
        g r13 = this.f21628z;
        r12.set(0.0f, 0.0f, r13.f21611j, r13.f21612k);
        this.f21587l.mapRect(r12);
        r5.set(r12);
    }

    @Override // r.c
    public final void j(Canvas r11, Matrix r12, int r13) {
        g r5 = this.f21628z;
        int r10 = Color.alpha(r5.f21613l);
        if (r10 != 0) goto L5;
        return;
    L5:
        l.d r14 = this.f21594t.f19505j;
        if (r14 != null) goto L8;
        int r15 = 100;
    L9:
        int r16 = (int) (((((r10 / 255.0f) * r15) / 100.0f) * (r13 / 255.0f)) * 255.0f);
        j.a r17 = this.f21625w;
        r17.setAlpha(r16);
        n r18 = this.A;
        if (r18 == null) goto L12;
        r17.setColorFilter((ColorFilter) r18.f());
    L12:
        if (r16 <= 0) goto L15;
        float[] r19 = this.f21626x;
        r19[0] = 0.0f;
        r19[1] = 0.0f;
        float r20 = r5.f21611j;
        r19[2] = r20;
        r19[3] = 0.0f;
        r19[4] = r20;
        float r21 = r5.f21612k;
        r19[5] = r21;
        r19[6] = 0.0f;
        r19[7] = r21;
        r12.mapPoints(r19);
        Path r110 = this.f21627y;
        r110.reset();
        r110.moveTo(r19[0], r19[1]);
        r110.lineTo(r19[2], r19[3]);
        r110.lineTo(r19[4], r19[5]);
        r110.lineTo(r19[6], r19[7]);
        r110.lineTo(r19[0], r19[1]);
        r110.close();
        r11.drawPath(r110, r17);
        return;
    L15:
        return;
    L8:
        r15 = ((Integer) r14.f()).intValue();
        goto L9
    }
}
