package jr;

import ai.j0;
import android.view.View;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qo.a f18447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f18449c;
    public float[][] d;
    public int e;
    public String f;
    public float[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f18450h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f18451i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f18452j;

    public q() {
        this.f18448b = 0;
        this.f18449c = new int[10];
        this.d = (float[][]) Array.newInstance(Float.TYPE, new int[]{10, 3});
        this.g = new float[3];
        this.f18450h = false;
        this.f18452j = Float.NaN;
    }

    public final float a(float r5) {
        switch(this.f18448b) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        float r10 = 1.0f - Math.abs(((r5 * 4.0f) % 4.0f) - 2.0f);
        return 1.0f - (r10 * r10);
    L5:
        return (float) Math.sin(r5 * 6.2831855f);
    L9:
        return (float) Math.cos(r5 * 6.2831855f);
    L11:
        return 1.0f - (((r5 * 2.0f) + 1.0f) % 2.0f);
    L13:
        return (((r5 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
    L15:
        return 1.0f - Math.abs(r5);
    L17:
        return Math.signum(r5 * 6.2831855f);
    }

    public final float b(float r19, long r20, View r22, gr.e r23) {
        this.f18447a.x(r19, this.g);
        float[] r5 = this.g;
        boolean r10 = true;
        float r11 = r5[1];
        if (r11 != 0.0f) goto L7;
        this.f18450h = false;
        return r5[2];
    L7:
        if (Float.isNaN(this.f18452j) == false) goto L11;
        float r12 = r23.c(r22, this.f);
        this.f18452j = r12;
        if (Float.isNaN(r12) == false) goto L11;
        this.f18452j = 0.0f;
    L11:
        float r13 = (float) (((((r20 - this.f18451i) * 1.0E-9d) * ((double) r11)) + ((double) this.f18452j)) % 1.0d);
        this.f18452j = r13;
        String r14 = this.f;
        HashMap r15 = (HashMap) r23.f17145b;
        if (r15.containsKey(r22) == true) goto L14;
        HashMap r16 = new HashMap();
        r16.put(r14, new float[]{r13});
        r15.put(r22, r16);
    L27:
        this.f18451i = r20;
        float r17 = this.g[0];
        float r18 = (a(this.f18452j) * r17) + this.g[2];
        if (r17 != 0.0f) goto L32;
        if (r11 != 0.0f) goto L32;
        r10 = false;
    L32:
        this.f18450h = r10;
        return r18;
    L14:
        HashMap r21 = (HashMap) r15.get(r22);
        if (r21 != null) goto L18;
        r21 = new HashMap();
    L18:
        if (r21.containsKey(r14) == true) goto L20;
        r21.put(r14, new float[]{r13});
        r15.put(r22, r21);
        goto L27
    L20:
        float[] r24 = (float[]) r21.get(r14);
        if (r24 != null) goto L24;
        r24 = new float[0];
    L24:
        if (r24.length > 0) goto L26;
        r24 = Arrays.copyOf(r24, 1);
    L26:
        r24[0] = r13;
        r21.put(r14, r24);
        goto L27
    }

    public void c(int r5, float r10, float r11, int r12, float r13) {
        int r14 = this.e;
        this.f18449c[r14] = r5;
        float[] r15 = this.d[r14];
        r15[0] = r10;
        r15[1] = r11;
        r15[2] = r13;
        this.f18448b = Math.max(this.f18448b, r12);
        this.e++;
    }

    public abstract boolean d(float r5, long r10, View r11, gr.e r12);

    public void e(int r18) {
        int r5 = this.e;
        if (r5 != 0) goto L6;
        System.err.println("Error no points added to " + this.f);
        return;
    L6:
        int[] r10 = this.f18449c;
        int[] r11 = new int[r10.length + 10];
        r11[0] = r5 - 1;
        r11[1] = 0;
        int r12 = 2;
    L7:
        float[][] r13 = this.d;
        if (r12 <= 0) goto L19;
        int r14 = r12 - 1;
        int r15 = r11[r14];
        int r16 = r12 - 2;
        int r17 = r11[r16];
        if (r15 < r17) goto L11;
        r12 = r16;
        goto L7
    L11:
        int r19 = r10[r17];
        int r110 = r15;
        int r111 = r110;
    L12:
        if (r110 >= r17) goto L17;
        int r112 = r10[r110];
        if (r112 > r19) goto L16;
        int r113 = r10[r111];
        r10[r111] = r112;
        r10[r110] = r113;
        float[] r114 = r13[r111];
        r13[r111] = r13[r110];
        r13[r110] = r114;
        r111 = r111 + 1;
    L16:
        r110 = r110 + 1;
        goto L12
    L17:
        int r115 = r10[r111];
        r10[r111] = r10[r17];
        r10[r17] = r115;
        float[] r116 = r13[r111];
        r13[r111] = r13[r17];
        r13[r17] = r116;
        r11[r16] = r111 - 1;
        r11[r14] = r15;
        int r20 = r12 + 1;
        r11[r12] = r17;
        r12 = r12 + 2;
        r11[r20] = r111 + 1;
        goto L7
    L19:
        int r21 = 1;
        int r22 = 0;
    L21:
        if (r21 >= r10.length) goto L26;
        if (r10[r21] == r10[r21 - 1]) goto L25;
        r22 = r22 + 1;
    L25:
        r21 = r21 + 1;
        goto L21
    L26:
        if (r22 != 0) goto L28;
        r22 = 1;
    L28:
        double[] r23 = new double[r22];
        double[][] r24 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r22, 3});
        int r25 = 0;
        int r26 = 0;
    L30:
        if (r25 >= this.e) goto L37;
        if (r25 > 0) goto L33;
    L35:
        r23[r26] = ((double) r10[r25]) * 0.01d;
        double[] r117 = r24[r26];
        float[] r118 = r13[r25];
        r117[0] = r118[0];
        r117[1] = r118[1];
        r117[2] = r118[2];
        r26 = r26 + 1;
    L36:
        r25 = r25 + 1;
        goto L30
    L33:
        if (r10[r25] != r10[r25 - 1]) goto L35;
    L37:
        this.f18447a = qo.a.u(r18, r23, r24);
    }

    public final String toString() {
        String r5 = this.f;
        DecimalFormat r10 = new DecimalFormat("##.##");
        int r11 = 0;
    L4:
        if (r11 >= this.e) goto L6;
        StringBuilder r12 = j0.w(r5, "[");
        r12.append(this.f18449c[r11]);
        r12.append(" , ");
        r12.append(r10.format(this.d[r11]));
        r12.append("] ");
        r5 = r12.toString();
        r11 = r11 + 1;
        goto L4
    L6:
        return r5;
    }
}
