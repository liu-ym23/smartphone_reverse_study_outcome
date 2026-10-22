package jr;

import ai.j0;
import android.view.View;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qo.a f18438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f18439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f18440c;
    public int d;
    public String e;

    public l() {
        this.f18439b = new int[10];
        this.f18440c = new float[10];
    }

    public final float a(float r5) {
        return (float) this.f18438a.v(r5);
    }

    public void b(int r5, float r10) {
        int[] r11 = this.f18439b;
        if (r11.length >= (this.d + 1)) goto L5;
        this.f18439b = Arrays.copyOf(r11, r11.length * 2);
        float[] r12 = this.f18440c;
        this.f18440c = Arrays.copyOf(r12, r12.length * 2);
    L5:
        int[] r13 = this.f18439b;
        int r14 = this.d;
        r13[r14] = r5;
        this.f18440c[r14] = r10;
        this.d = r14 + 1;
    }

    public abstract void c(View r5, float r10);

    public void d(int r18) {
        int r5 = this.d;
        if (r5 != 0) goto L5;
        return;
    L5:
        int[] r10 = this.f18439b;
        float[] r11 = this.f18440c;
        int[] r12 = new int[r10.length + 10];
        r12[0] = r5 - 1;
        r12[1] = 0;
        int r13 = 2;
    L6:
        if (r13 <= 0) goto L17;
        int r14 = r13 - 1;
        int r15 = r12[r14];
        int r16 = r13 - 2;
        int r17 = r12[r16];
        if (r15 < r17) goto L9;
        r13 = r16;
        goto L6
    L9:
        int r19 = r10[r17];
        int r110 = r15;
        int r111 = r110;
    L10:
        if (r110 >= r17) goto L15;
        int r112 = r10[r110];
        if (r112 > r19) goto L14;
        int r113 = r10[r111];
        r10[r111] = r112;
        r10[r110] = r113;
        float r114 = r11[r111];
        r11[r111] = r11[r110];
        r11[r110] = r114;
        r111 = r111 + 1;
    L14:
        r110 = r110 + 1;
        goto L10
    L15:
        int r115 = r10[r111];
        r10[r111] = r10[r17];
        r10[r17] = r115;
        float r116 = r11[r111];
        r11[r111] = r11[r17];
        r11[r17] = r116;
        r12[r16] = r111 - 1;
        r12[r14] = r15;
        int r20 = r13 + 1;
        r12[r13] = r17;
        r13 = r13 + 2;
        r12[r20] = r111 + 1;
        goto L6
    L17:
        int r21 = 1;
        int r22 = 1;
    L19:
        if (r21 >= this.d) goto L24;
        int[] r23 = this.f18439b;
        if (r23[r21 - 1] == r23[r21]) goto L23;
        r22 = r22 + 1;
    L23:
        r21 = r21 + 1;
        goto L19
    L24:
        double[] r24 = new double[r22];
        double[][] r25 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r22, 1});
        int r26 = 0;
        int r27 = 0;
    L26:
        if (r26 >= this.d) goto L33;
        if (r26 <= 0) goto L31;
        int[] r28 = this.f18439b;
        if (r28[r26] != r28[r26 - 1]) goto L31;
    L32:
        r26 = r26 + 1;
    L31:
        r24[r27] = ((double) this.f18439b[r26]) * 0.01d;
        r25[r27][0] = this.f18440c[r26];
        r27 = r27 + 1;
        goto L32
    L33:
        this.f18438a = qo.a.u(r18, r24, r25);
    }

    public final String toString() {
        String r5 = this.e;
        DecimalFormat r10 = new DecimalFormat("##.##");
        int r11 = 0;
    L4:
        if (r11 >= this.d) goto L6;
        StringBuilder r12 = j0.w(r5, "[");
        r12.append(this.f18439b[r11]);
        r12.append(" , ");
        r12.append(r10.format(this.f18440c[r11]));
        r12.append("] ");
        r5 = r12.toString();
        r11 = r11 + 1;
        goto L4
    L6:
        return r5;
    }
}
