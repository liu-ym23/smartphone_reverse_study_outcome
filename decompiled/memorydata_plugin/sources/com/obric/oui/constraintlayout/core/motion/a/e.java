package com.obric.oui.constraintlayout.core.motion.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<b> f13569b;
    private com.obric.oui.constraintlayout.core.motion.a.b c;
    private a d;
    private String e;
    private int f;
    private String g;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        h f13571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float[] f13572b;
        double[] c;
        float[] d;
        float[] e;
        float[] f;
        float[] g;
        int h;
        com.obric.oui.constraintlayout.core.motion.a.b i;
        double[] j;
        double[] k;
        float l;
        private final int m;
        private final int n;
        private final int o;
        private final int p;

        a(int r3, String r4, int r5, int r6) {
            h r0 = new h();
            this.f13571a = r0;
            this.n = 0;
            this.o = 1;
            this.p = 2;
            this.h = r3;
            this.m = r5;
            r0.a(r3, r4);
            this.f13572b = new float[r6];
            this.c = new double[r6];
            this.d = new float[r6];
            this.e = new float[r6];
            this.f = new float[r6];
            this.g = new float[r6];
        }

        public double a(float r10) {
            com.obric.oui.constraintlayout.core.motion.a.b r0 = this.i;
            if (r0 == null) goto L5;
            r0.a(r10, this.j);
        L6:
            double[] r1 = this.j;
            double r3 = r1[0];
            Objects.requireNonNull(this);
            return r3 + (this.f13571a.a(r10, r1[1]) * this.j[2]);
        L5:
            double[] r2 = this.j;
            r2[0] = this.e[0];
            r2[1] = this.f[0];
            r2[2] = this.f13572b[0];
            goto L6
        }

        public void a(int r6, int r7, float r8, float r9, float r10, float r11) {
            this.c[r6] = ((double) r7) / 100.0d;
            this.d[r6] = r8;
            this.e[r6] = r9;
            this.f[r6] = r10;
            this.f13572b[r6] = r11;
        }

        public double b(float r14) {
            com.obric.oui.constraintlayout.core.motion.a.b r0 = this.i;
            if (r0 == null) goto L5;
            double r4 = r14;
            r0.b(r4, this.k);
            this.i.a(r4, this.j);
        L6:
            double r5 = r14;
            double r11 = this.f13571a.a(r5, this.j[1]);
            double r3 = this.f13571a.a(r5, this.j[1], this.k[1]);
            double[] r15 = this.k;
            return (r15[0] + (r11 * r15[2])) + (r3 * this.j[2]);
        L5:
            double[] r1 = this.k;
            r1[0] = 0.0d;
            r1[1] = 0.0d;
            r1[2] = 0.0d;
            goto L6
        }

        public void c(float r10) {
            this.l = r10;
            double[][] r11 = (double[][]) Array.newInstance(double.class, new int[]{this.c.length, 3});
            float[] r1 = this.f13572b;
            this.j = new double[r1.length + 2];
            this.k = new double[r1.length + 2];
            if (this.c[0] <= 0.0d) goto L5;
            this.f13571a.a(0.0d, this.d[0]);
        L5:
            double[] r2 = this.c;
            int r4 = r2.length - 1;
            if (r2[r4] >= 1.0d) goto L8;
            this.f13571a.a(1.0d, this.d[r4]);
        L8:
            int r3 = 0;
        L10:
            if (r3 >= r11.length) goto L12;
            r11[r3][0] = this.e[r3];
            r11[r3][1] = this.f[r3];
            r11[r3][2] = this.f13572b[r3];
            this.f13571a.a(this.c[r3], this.d[r3]);
            r3 = r3 + 1;
            goto L10
        L12:
            this.f13571a.a();
            double[] r0 = this.c;
            if (r0.length <= 1) goto L15;
            com.obric.oui.constraintlayout.core.motion.a.b r12 = com.obric.oui.constraintlayout.core.motion.a.b.a(0, r0, r11);
        L16:
            this.i = r12;
            return;
        L15:
            r12 = null;
            goto L16
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f13574b;
        float c;
        float d;
        float e;

        b(int r1, float r2, float r3, float r4, float r5) {
            this.f13573a = r1;
            this.f13574b = r5;
            this.c = r3;
            this.d = r2;
            this.e = r4;
        }
    }

    public e() {
        this.f = 0;
        this.g = null;
        this.f13568a = 0;
        this.f13569b = new ArrayList();
    }

    public float a(float r1) {
        return (float) this.d.a(r1);
    }

    public void a(int r11, int r12, String r13, int r14, float r15, float r16, float r17, float r18) {
        this.f13569b.add(new b(r11, r15, r16, r17, r18));
        if (r14 == (-1)) goto L5;
        this.f13568a = r14;
    L5:
        this.f = r12;
        this.g = r13;
    }

    public void a(int r11, int r12, String r13, int r14, float r15, float r16, float r17, float r18, Object r19) {
        this.f13569b.add(new b(r11, r15, r16, r17, r18));
        if (r14 == (-1)) goto L5;
        this.f13568a = r14;
    L5:
        this.f = r12;
        a(r19);
        this.g = r13;
    }

    public void a(Object r1) {
    }

    public void a(String r1) {
        this.e = r1;
    }

    public boolean a() {
        if (this.f13568a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public float b(float r1) {
        return (float) this.d.b(r1);
    }

    public void c(float r15) {
        int r0 = this.f13569b.size();
        if (r0 != 0) goto L5;
        return;
    L5:
        Collections.sort(this.f13569b, new AnonymousClass1(this));
        double[] r1 = new double[r0];
        double[][] r4 = (double[][]) Array.newInstance(double.class, new int[]{r0, 3});
        this.d = new a(this.f, this.g, this.f13568a, r0);
        Iterator<b> r2 = this.f13569b.iterator();
        int r13 = 0;
    L7:
        if (r2.hasNext() == false) goto L9;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.memorydata.plugin");
        r1[r13] = ((double) r6.d) * 0.01d;
        r4[r13][0] = r6.f13574b;
        r4[r13][1] = r6.c;
        r4[r13][2] = r6.e;
        this.d.a(r13, r6.f13573a, r6.d, r6.c, r6.e, r6.f13574b);
        r13 = r13 + 1;
        goto L7
    L9:
        this.d.c(r15);
        this.c = com.obric.oui.constraintlayout.core.motion.a.b.a(0, r1, r4);
    }

    public String toString() {
        String r0 = this.e;
        DecimalFormat r1 = new DecimalFormat("##.##");
        Iterator<b> r5 = this.f13569b.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.memorydata.plugin");
        r0 = r0 + "[" + r2.f13573a + " , " + r1.format(r2.f13574b) + "] ";
        goto L4
    L6:
        return r0;
    }
}
