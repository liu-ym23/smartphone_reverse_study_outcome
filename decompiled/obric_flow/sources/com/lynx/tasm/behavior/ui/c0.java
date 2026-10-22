package com.lynx.tasm.behavior.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.lynx.base.log.LynxLog;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final double[] f10427v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f10428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f10429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f10430c;
    public final Paint d;
    public final Paint e;
    public final Paint f;
    public final RectF g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f10431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f10432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f10433j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public r f10434k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Path f10435l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Path f10436m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Path f10437n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Path f10438o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Path f10439p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Path f10440q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Path f10441r;
    public final Path s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Path f10442t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Path f10443u;

    static {
        f10427v = new double[]{1.0d, 0.8027415617602307d, 0.6443940149772542d, 0.5172818579717866d, 0.41524364653850576d, 0.3333333333333333d, 0.2075805205867436d, 0.1147980049924181d, 0.0424272859905955d, 0.0d};
    }

    public c0() {
        this.f10435l = new Path();
        this.f10436m = new Path();
        this.f10437n = new Path();
        this.f10438o = new Path();
        this.f10439p = new Path();
        this.f10440q = new Path();
        this.f10441r = new Path();
        this.s = new Path();
        this.f10442t = new Path();
        this.f10443u = new Path();
        this.f10428a = new Paint(5);
        Paint r5 = new Paint(5);
        this.f10429b = r5;
        r5.setStyle(Paint.Style.FILL);
        r5.setDither(true);
        this.f10430c = new Paint(r5);
        this.d = new Paint(r5);
        this.e = new Paint(r5);
        this.g = new RectF();
        this.f10431h = new RectF();
        this.f = new Paint(r5);
        this.f10432i = new float[8];
        this.f10433j = new float[8];
    }

    public final void a(Canvas r10) {
        if (this.f10434k != null) goto L5;
        return;
    L5:
        int r5 = r10.save();
        RectF r11 = this.g;
        r10.translate(r11.left, r11.top);
        r10.drawPath(this.f10437n, this.f10429b);
        Path r12 = this.f10441r;
        Paint r13 = this.f;
        r10.drawPath(r12, r13);
        r10.restoreToCount(r5);
        int r14 = r10.save();
        r10.translate(r11.right, r11.bottom);
        r10.rotate(180.0f);
        r10.drawPath(this.f10438o, this.e);
        r10.drawPath(this.s, r13);
        r10.restoreToCount(r14);
        int r15 = r10.save();
        r10.translate(r11.left, r11.bottom);
        r10.rotate(270.0f);
        r10.drawPath(this.f10439p, this.d);
        r10.drawPath(this.f10442t, r13);
        r10.restoreToCount(r15);
        int r16 = r10.save();
        r10.translate(r11.right, r11.top);
        r10.rotate(90.0f);
        r10.drawPath(this.f10440q, this.f10430c);
        r10.drawPath(this.f10443u, r13);
        r10.restoreToCount(r16);
    }

    public final void b(Paint r22, int[] r23, float r24, float r25) {
        r r5 = this.f10434k;
        float r10 = r5.f;
        float r11 = (r24 + r25) / 2.0f;
        boolean r12 = r5.b();
        double[] r13 = f10427v;
        int r14 = 9;
        if (r12 == true) goto L5;
        float r15 = r10 + r11;
        if (r15 > 1.0E-6d) goto L17;
        r22.setShader(null);
        return;
    L17:
        float r16 = r11 / r15;
        float[] r17 = new float[11];
        int[] r18 = new int[11];
        r17[0] = 0.0f;
        r17[1] = r16;
        int r19 = this.f10434k.f10591a;
        r18[0] = r19;
        r18[1] = r19;
        int r20 = 2;
        int r21 = 10;
    L18:
        if (r20 > r21) goto L20;
        int r110 = r20 - 1;
        r17[r20] = (((1.0f - r16) * r110) / r14) + r16;
        r18[r20] = Color.argb((int) (((double) r23[0]) * r13[r110]), r23[1], r23[2], r23[3]);
        r20 = r20 + 1;
        r21 = 10;
        r14 = 9;
        goto L18
    L20:
        r22.setShader(new RadialGradient(r24, r25, r15, r18, r17, Shader.TileMode.CLAMP));
        return;
    L5:
        if (r11 > 1.0E-6d) goto L8;
        r22.setShader(null);
        return;
    L8:
        float r26 = r10 / r11;
        float[] r27 = new float[11];
        int[] r28 = new int[11];
        int r29 = 10;
        r27[10] = 1.0f;
        r28[10] = this.f10434k.f10591a;
        int r30 = 1;
    L9:
        if (r30 >= r29) goto L11;
        int r31 = 10 - r30;
        r27[r31] = Math.max(1.0f - ((r30 * r26) / 9), 0.0f);
        r28[r31] = Color.argb((int) (((double) r23[0]) * r13[r30]), r23[1], r23[2], r23[3]);
        r30 = r30 + 1;
        r29 = 10;
        goto L9
    L11:
        r27[0] = 0.0f;
        r28[0] = Color.argb(0, r23[1], r23[2], r23[3]);
        r22.setShader(new RadialGradient(r24, r25, r11, r28, r27, Shader.TileMode.CLAMP));
    }

    public final void c(Path r10, float r11, float r12) {
        r10.reset();
        boolean r5 = this.f10434k.b();
        float r13 = this.f10434k.f;
        if (r5 == true) goto L6;
        r13 = -r13;
    L6:
        RectF r14 = new RectF(0.0f, 0.0f, r11 * 2.0f, r12 * 2.0f);
        RectF r15 = new RectF(r14);
        if (r13 <= 0.0f) goto L12;
        float r16 = Math.min(r15.width(), r15.height()) / 2.0f;
        if (r13 <= r16) goto L12;
        r13 = r16;
    L12:
        if (r13 > (-0.1f)) goto L14;
    L16:
        r15.inset(r13, r13);
        r10.setFillType(Path.FillType.EVEN_ODD);
        r10.moveTo(0.0f, r12);
        r10.rLineTo(r13, 0.0f);
        r10.arcTo(r15, 180.0f, 90.0f, false);
        r10.arcTo(r14, 270.0f, -90.0f, false);
        r10.close();
        return;
    L14:
        if (r13 >= 0.1f) goto L16;
    }

    public final void d(Canvas r5) {
        if (this.f10434k != null) goto L5;
        return;
    L5:
        int r10 = r5.save();
        r5.drawPath(this.f10435l, this.f10428a);
        a(r5);     // Catch: Exception -> L8
    L10:
        r5.restoreToCount(r10);
        return;
    L8:
        e = move-exception;
        LynxLog.b(4, "UIShadowProxy", "Exception occurred while drawing shadow: " + e.getStackTrace().toString());
        goto L10
    }
}
