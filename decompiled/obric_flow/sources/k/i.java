package k;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.w;
import com.airbnb.lottie.z;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i extends b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f18525o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f18526p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LongSparseArray f18527q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LongSparseArray f18528r;
    public final RectF s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final GradientType f18529t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f18530u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l.g f18531v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final l.g f18532w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l.g f18533x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public l.n f18534y;

    public i(w r12, r.c r13, q.e r14) {
        Paint.Cap r5 = r14.f21403h.toPaintCap();
        Paint.Join r10 = r14.f21404i.toPaintJoin();
        ArrayList r11 = r14.f21406k;
        p.b r15 = r14.f21407l;
        super(r12, r13, r5, r10, r14.f21405j, r14.d, r14.g, r11, r15);
        this.f18527q = new LongSparseArray();
        this.f18528r = new LongSparseArray();
        this.s = new RectF();
        this.f18525o = r14.f21400a;
        this.f18529t = r14.f21401b;
        this.f18526p = r14.f21408m;
        this.f18530u = (int) (r12.f1340b.b() / 32.0f);
        l.d r16 = r14.f21402c.d();
        this.f18531v = (l.g) r16;
        r16.a(this);
        r13.f(r16);
        l.d r17 = r14.e.d();
        this.f18532w = (l.g) r17;
        r17.a(this);
        r13.f(r17);
        l.d r18 = r14.f.d();
        this.f18533x = (l.g) r18;
        r18.a(this);
        r13.f(r18);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k.b, o.f
    public final void c(ColorFilter r5, v.c r10) {
        super.c(r5, r10);
        if (r5 != z.f1376z) goto L6;
        l.n r11 = new l.n(r10, null);
        this.f18534y = r11;
        r11.a(this);
        l.n r12 = this.f18534y;
        this.f.f(r12);
        return;
    }

    public final int[] f(int[] r5) {
        l.n r10 = this.f18534y;
        if (r10 == null) goto L13;
        Integer[] r11 = (Integer[]) r10.f();
        int r12 = 0;
        if (r5.length == r11.length) goto L7;
        r5 = new int[r11.length];
    L11:
        if (r12 >= r11.length) goto L13;
        r5[r12] = r11[r12].intValue();
        r12 = r12 + 1;
    L7:
        if (r12 >= r5.length) goto L13;
        r5[r12] = r11[r12].intValue();
        r12 = r12 + 1;
    L13:
        return r5;
    }

    @Override // k.b, k.e
    public final void g(Canvas r18, Matrix r19, int r20) {
        if (this.f18526p == false) goto L5;
        return;
    L5:
        e(this.s, r19, false);
        GradientType r5 = GradientType.LINEAR;
        GradientType r10 = this.f18529t;
        l.g r11 = this.f18531v;
        l.g r12 = this.f18533x;
        l.g r13 = this.f18532w;
        if (r10 != r5) goto L11;
        long r14 = h();
        LongSparseArray r15 = this.f18527q;
        Shader r16 = (LinearGradient) r15.get(r14);
        if (r16 != null) goto L15;
        PointF r17 = (PointF) r13.f();
        PointF r21 = (PointF) r12.f();
        q.c r22 = (q.c) r11.f();
        int[] r110 = f(r22.f21395b);
        r16 = new LinearGradient(r17.x, r17.y, r21.x, r21.y, r110, r22.f21394a, Shader.TileMode.CLAMP);
        r15.put(r14, r16);
    L15:
        r16.setLocalMatrix(r19);
        this.f18488i.setShader(r16);
        super.g(r18, r19, r20);
        return;
    L11:
        long r23 = h();
        LongSparseArray r24 = this.f18528r;
        r16 = (RadialGradient) r24.get(r23);
        if (r16 != null) goto L15;
        PointF r25 = (PointF) r13.f();
        PointF r26 = (PointF) r12.f();
        q.c r27 = (q.c) r11.f();
        int[] r111 = f(r27.f21395b);
        float r112 = r25.x;
        float r113 = r25.y;
        RadialGradient r28 = new RadialGradient(r112, r113, (float) Math.hypot(r26.x - r112, r26.y - r113), r111, r27.f21394a, Shader.TileMode.CLAMP);
        r24.put(r23, r28);
        r16 = r28;
        goto L15
    }

    @Override // k.c
    public final String getName() {
        return this.f18525o;
    }

    public final int h() {
        float r5 = this.f18532w.d;
        float r10 = this.f18530u;
        int r11 = Math.round(r5 * r10);
        int r12 = Math.round(this.f18533x.d * r10);
        int r13 = Math.round(this.f18531v.d * r10);
        if (r11 == 0) goto L5;
        int r14 = 527 * r11;
    L6:
        if (r12 == 0) goto L8;
        r14 = (r14 * 31) * r12;
    L8:
        if (r13 != 0) goto L10;
        return r14;
    L10:
        return (r14 * 31) * r13;
    L5:
        r14 = 17;
        goto L6
    }
}
