package jr;

import android.util.SparseArray;
import android.view.View;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends q {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f18442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SparseArray f18443l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SparseArray f18444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f18445n;

    @Override // jr.q
    public final void c(int r5, float r10, float r11, int r12, float r13) {
        throw new RuntimeException("Wrong call for custom attribute");
    }

    @Override // jr.q
    public final boolean d(float r11, long r12, View r14, gr.e r15) {
        this.f18447a.x(r11, this.f18445n);
        float[] r13 = this.f18445n;
        float r5 = r13[r13.length - 2];
        float r16 = r13[r13.length - 1];
        long r10 = r12 - this.f18451i;
        if (Float.isNaN(this.f18452j) == false) goto L7;
        float r17 = r15.c(r14, this.f18442k);
        this.f18452j = r17;
        if (Float.isNaN(r17) == false) goto L7;
        this.f18452j = 0.0f;
    L7:
        float r18 = (float) ((((r10 * 1.0E-9d) * ((double) r5)) + ((double) this.f18452j)) % 1.0d);
        this.f18452j = r18;
        this.f18451i = r12;
        float r19 = a(r18);
        this.f18450h = false;
        int r110 = 0;
    L8:
        float[] r20 = this.g;
        if (r110 >= r20.length) goto L15;
        boolean r21 = this.f18450h;
        float r22 = this.f18445n[r110];
        if (r22 == 0.0d) goto L13;
        boolean r23 = true;
    L14:
        this.f18450h = r21 | r23;
        r20[r110] = (r22 * r19) + r16;
        r110 = r110 + 1;
        goto L8
    L13:
        r23 = false;
        goto L14
    L15:
        f4.a.n((lr.b) this.f18443l.valueAt(0), r14, this.g);
        if (r5 == 0.0f) goto L19;
        this.f18450h = true;
    L19:
        return this.f18450h;
    }

    @Override // jr.q
    public final void e(int r17) {
        SparseArray r5 = this.f18443l;
        int r10 = r5.size();
        int r11 = ((lr.b) r5.valueAt(0)).c();
        double[] r12 = new double[r10];
        int r13 = r11 + 2;
        this.f18445n = new float[r13];
        this.g = new float[r11];
        double[][] r14 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r10, r13});
        int r15 = 0;
    L3:
        if (r15 >= r10) goto L9;
        int r16 = r5.keyAt(r15);
        lr.b r18 = (lr.b) r5.valueAt(r15);
        float[] r19 = (float[]) this.f18444m.valueAt(r15);
        r12[r15] = ((double) r16) * 0.01d;
        r18.b(this.f18445n);
        int r20 = 0;
    L5:
        float[] r110 = this.f18445n;
        if (r20 >= r110.length) goto L8;
        r14[r15][r20] = r110[r20];
        r20 = r20 + 1;
        goto L5
    L8:
        double[] r21 = r14[r15];
        r21[r11] = r19[0];
        r21[r11 + 1] = r19[1];
        r15 = r15 + 1;
        goto L3
    L9:
        this.f18447a = qo.a.u(r17, r12, r14);
    }
}
