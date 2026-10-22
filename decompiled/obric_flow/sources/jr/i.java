package jr;

import android.util.SparseArray;
import android.view.View;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends l {
    public SparseArray f;
    public float[] g;

    @Override // jr.l
    public final void b(int r5, float r10) {
        throw new RuntimeException("call of custom attribute setPoint");
    }

    @Override // jr.l
    public final void c(View r5, float r10) {
        this.f18438a.x(r10, this.g);
        f4.a.n((lr.b) this.f.valueAt(0), r5, this.g);
    }

    @Override // jr.l
    public final void d(int r13) {
        SparseArray r5 = this.f;
        int r10 = r5.size();
        int r11 = ((lr.b) r5.valueAt(0)).c();
        double[] r12 = new double[r10];
        this.g = new float[r11];
        double[][] r14 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r10, r11});
        int r15 = 0;
    L3:
        if (r15 >= r10) goto L9;
        int r16 = r5.keyAt(r15);
        lr.b r17 = (lr.b) r5.valueAt(r15);
        r12[r15] = ((double) r16) * 0.01d;
        r17.b(this.g);
        int r18 = 0;
    L5:
        float[] r19 = this.g;
        if (r18 >= r19.length) goto L8;
        r14[r15][r18] = r19[r18];
        r18 = r18 + 1;
        goto L5
    L8:
        r15 = r15 + 1;
        goto L3
    L9:
        this.f18438a = qo.a.u(r13, r12, r14);
    }
}
