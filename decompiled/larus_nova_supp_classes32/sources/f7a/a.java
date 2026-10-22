package f7a;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public int a;
    public final C0091a b;
    public final C0091a c;
    public final Interpolator d;

    /* JADX INFO: renamed from: f7a.a$a, reason: collision with other inner class name */
    public static class C0091a {
        public static final float q = 0.0f;
        public static final float[] r = null;
        public static final float[] s = null;
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public float f;
        public float g;
        public long h;
        public int i;
        public int j;
        public int k;
        public boolean l;
        public int m;
        public final float n;
        public int o;
        public final float p;

        public final boolean b() {
            int r0 = this.o;
            if (r0 == 0) goto L10;
            if (r0 != 1) goto L6;
            return false;
        L6:
            if (r0 != 2) goto L17;
            this.h += (long) this.i;
            e(this.d, this.a);
        L17:
            update();
            return true;
        L10:
            int r1 = this.i;
            if (r1 >= this.j) goto L19;
            this.c = this.b;
            int r2 = this.d;
            this.a = r2;
            this.b = r2;
            int r3 = (int) this.f;
            this.e = r3;
            if (r3 <= 0) goto L15;
            float r4 = -2000.0f;
        L16:
            this.g = r4;
            this.h += (long) r1;
            d();
            goto L17
        L15:
            r4 = 2000.0f;
            goto L16
        L19:
            return false;
        }

        public final void d() {
            int r0 = this.e;
            float r1 = r0 * r0;
            float r2 = r1 / (Math.abs(this.g) * 2.0f);
            float r3 = Math.signum(this.e);
            int r4 = this.m;
            if (r2 <= r4) goto L5;
            this.g = ((-r3) * r1) / (r4 * 2.0f);
            r2 = r4;
        L5:
            this.m = (int) r2;
            this.o = 2;
            int r5 = this.a;
            int r6 = this.e;
            if (r6 > 0) goto L9;
            r2 = -r2;
        L9:
            this.d = r5 + ((int) r2);
            this.i = -((int) ((r6 * 1000.0f) / this.g));
        }

        public boolean update() {
            long r0 = AnimationUtils.currentAnimationTimeMillis() - this.h;
            if (r0 == 0) goto L5;
            int r2 = this.i;
            if (r0 <= r2) goto L11;
            return false;
        L11:
            int r3 = this.o;
            if (r3 != 0) goto L14;
            int r1 = this.j;
            float r4 = r0 / r1;
            int r5 = (int) (r4 * 100.0f);
            if (r5 >= 0) goto L25;
        L23:
            double r6 = 0.0d;
        L29:
            this.c = this.b;
            this.b = this.a + ((int) Math.round(r6));
            return true;
        L25:
            if (r5 >= 100) goto L27;
            float r7 = r5 / 100.0f;
            int r8 = r5 + 1;
            float[] r9 = r;
            float r10 = r9[r5];
            float r11 = (r9[r8] - r10) / ((r8 / 100.0f) - r7);
            float r12 = r10 + ((r4 - r7) * r11);
        L28:
            int r13 = this.k;
            double r14 = r12 * r13;
            this.f = ((r11 * r13) / r1) * 1000.0f;
        L20:
            r6 = r14;
            goto L29
        L27:
            r12 = 1.0f;
            r11 = 0.0f;
            goto L28
        L14:
            if (r3 != 1) goto L16;
            float r15 = r0 / r2;
            float r16 = r15 * r15;
            float r17 = Math.signum(this.e);
            int r18 = this.m;
            r14 = (r18 * r17) * ((3.0f * r16) - ((2.0f * r15) * r16));
            this.f = ((r17 * r18) * 6.0f) * ((-r15) + r16);
            goto L20
        L16:
            if (r3 != 2) goto L23;
            float r19 = r0 / 1000.0f;
            int r20 = this.e;
            float r21 = this.g;
            this.f = r20 + (r21 * r19);
            r6 = (r20 * r19) + (((r21 * r19) * r19) / 2.0f);
            goto L29
        L5:
            if (this.i <= 0) goto L31;
            return true;
        L31:
            return false;
        }

        static {
            q = (float) (Math.log(0.78d) / Math.log(0.9d));
            r = new float[101];
            s = new float[101];
            float r0 = 0.0f;
            float r1 = 0.0f;
            int r2 = 0;
        L4:
            if (r2 >= 100) goto L21;
            float r5 = r2 / 100.0f;
            float r3 = 1.0f;
        L6:
            float r7 = 2.0f;
            float r6 = ((r3 - r0) / 2.0f) + r0;
            float r8 = 3.0f;
            float r10 = 1.0f - r6;
            float r9 = (r6 * 3.0f) * r10;
            float r14 = (r6 * r6) * r6;
            float r12 = (((r10 * 0.175f) + (r6 * 0.35000002f)) * r9) + r14;
            if (Math.abs(r12 - r5) < 1.0E-5d) goto L8;
            if (r12 > r5) goto L19;
            r0 = r6;
            goto L6
        L19:
            r3 = r6;
            goto L6
        L8:
            r[r2] = (r9 * ((r10 * 0.5f) + r6)) + r14;
            float r4 = 1.0f;
        L9:
            float r11 = ((r4 - r1) / r7) + r1;
            float r13 = 1.0f - r11;
            float r15 = (r11 * r8) * r13;
            float r16 = (r11 * r11) * r11;
            float r17 = (((r13 * 0.5f) + r11) * r15) + r16;
            if (Math.abs(r17 - r5) < 1.0E-5d) goto L11;
            if (r17 <= r5) goto L15;
            r4 = r11;
        L16:
            r7 = 2.0f;
            r8 = 3.0f;
            goto L9
        L15:
            r1 = r11;
            goto L16
        L11:
            s[r2] = (r15 * ((r13 * 0.175f) + (r11 * 0.35000002f))) + r16;
            r2 = r2 + 1;
            goto L4
        L21:
            float[] r18 = r;
            s[100] = 1.0f;
            r18[100] = 1.0f;
        }

        public C0091a(Context r2) {
            this.n = ViewConfiguration.getScrollFriction();
            this.o = 0;
            this.l = true;
            Resources r3 = r2.getResources();
            this.p = ((WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density * 160.0f) * 386.0878f) * 0.84f;
        }

        public final void e(int r3, int r4) {
            this.l = false;
            this.o = 1;
            this.c = this.b;
            this.a = r3;
            this.b = r3;
            this.d = r4;
            int r5 = r3 - r4;
            if (r5 <= 0) goto L5;
            float r6 = -2000.0f;
        L6:
            this.g = r6;
            this.e = -r5;
            this.m = Math.abs(r5);
            this.i = (int) (Math.sqrt((((double) r5) * (-2.0d)) / ((double) this.g)) * 1000.0d);
            return;
        L5:
            r6 = 2000.0f;
            goto L6
        }

        public final void a(int r4, int r5, int r6) {
            float r7 = Math.abs((r6 - r4) / (r5 - r4));
            int r8 = (int) (r7 * 100.0f);
            if (r8 >= 100) goto L6;
            float r0 = r8 / 100.0f;
            int r1 = r8 + 1;
            float[] r9 = s;
            float r10 = r9[r8];
            this.i = (int) (this.i * (r10 + (((r7 - r0) / ((r1 / 100.0f) - r0)) * (r9[r1] - r10))));
            return;
        }

        public final void c(int r19, int r20, int r21, int r22, int r23, int r24) {
            this.m = r23;
            boolean r4 = false;
            this.l = false;
            this.e = r20;
            float r6 = r20;
            this.f = r6;
            this.j = 0;
            this.i = 0;
            this.h = AnimationUtils.currentAnimationTimeMillis();
            this.a = r19;
            this.c = r19;
            this.b = r19;
            if (r19 > r22) goto L23;
            if (r19 < r21) goto L23;
            this.o = 0;
            if (r20 == 0) goto L9;
            double r8 = Math.log((Math.abs(r20) * 0.35f) / (this.n * this.p));
            float r5 = q;
            int r9 = (int) (Math.exp(r8 / (((double) r5) - 1.0d)) * 1000.0d);
            this.j = r9;
            this.i = r9;
            double r13 = r5;
            double r11 = ((double) (this.n * this.p)) * Math.exp((r13 / (r13 - 1.0d)) * Math.log((Math.abs(r20) * 0.35f) / (this.n * this.p)));
        L10:
            if (r20 != 0) goto L12;
        L14:
            this.k = (int) (r11 * ((double) Math.signum(r6)));
        L15:
            int r1 = r19 + this.k;
            this.d = r1;
            if (r1 >= r21) goto L18;
            a(this.a, r1, r21);
            this.d = r21;
        L18:
            int r0 = this.d;
            if (r0 <= r22) goto L54;
            a(this.a, r0, r22);
            this.d = r22;
            return;
        L54:
            return;
        L12:
            if (r24 >= r11) goto L14;
            float r2 = r24;
            double r7 = q;
            double r14 = r7 - 1.0d;
            int r10 = (int) (((double) (((float) (Math.exp((Math.log(r2 / (this.n * this.p)) / (r7 / r14)) / r14) * 1000.0d)) + ((float) (((((double) this.i) * 1.0d) * ((double) r2)) / ((double) ((float) r11)))))) / 2.0d);
            this.j = r10;
            this.i = r10;
            this.k = (int) (r2 * Math.signum(r6));
            goto L15
        L9:
            r11 = 0.0d;
        L23:
            if (r19 <= r21) goto L26;
            if (r19 >= r22) goto L26;
            this.l = true;
            return;
        L26:
            if (r19 <= r22) goto L28;
            boolean r12 = true;
        L29:
            if (r12 == false) goto L31;
            int r15 = r22;
        L32:
            int r16 = r19 - r15;
            if ((r16 * r20) < 0) goto L35;
            r4 = true;
        L35:
            if (r4 == false) goto L43;
            if (r20 == 0) goto L39;
            r16 = r20;
        L39:
            if (r16 <= 0) goto L41;
            float r3 = -2000.0f;
        L42:
            this.g = r3;
            float r17 = (-r20) / r3;
            float r18 = (float) Math.sqrt((((double) ((((r6 * r6) / 2.0f) / Math.abs(r3)) + Math.abs(r15 - r19))) * 2.0d) / ((double) Math.abs(this.g)));
            this.h -= (long) ((int) ((r18 - r17) * 1000.0f));
            this.c = this.b;
            this.a = r15;
            this.b = r15;
            this.e = (int) ((-this.g) * r18);
            d();
            return;
        L41:
            r3 = 2000.0f;
            goto L42
        L43:
            double r25 = Math.log((Math.abs(r20) * 0.35f) / (this.n * this.p));
            double r110 = q;
            if ((((double) (this.n * this.p)) * Math.exp((r110 / (r110 - 1.0d)) * r25)) <= Math.abs(r16)) goto L52;
            if (r12 == false) goto L47;
            int r26 = r21;
        L48:
            if (r12 == false) goto L50;
            int r27 = r19;
        L51:
            c(r19, r20, r26, r27, this.m, Integer.MAX_VALUE);
            return;
        L50:
            r27 = r22;
            goto L51
        L47:
            r26 = r19;
            goto L48
        L52:
            e(r19, r15);
            return;
        L31:
            r15 = r21;
            goto L32
        L28:
            r12 = false;
            goto L29
        }
    }

    public final void a() {
        C0091a r0 = this.b;
        r0.b = r0.d;
        r0.l = true;
        C0091a r1 = this.c;
        r1.b = r1.d;
        r1.l = true;
    }

    public final boolean d() {
        if (this.b.l == true) goto L5;
    L7:
        return false;
    L5:
        if (this.c.l == false) goto L7;
        return true;
    }

    public final boolean b() {
        if (d() == false) goto L6;
        return false;
    L6:
        int r0 = this.a;
        if (r0 == 0) goto L24;
        if (r0 != 1) goto L28;
        C0091a r1 = this.b;
        if (r1.l == false) goto L13;
    L17:
        C0091a r2 = this.c;
        if (r2.l == true) goto L28;
        if (r2.update() == true) goto L28;
        if (this.c.b() == true) goto L28;
        C0091a r3 = this.c;
        r3.b = r3.d;
        r3.l = true;
        goto L28
    L13:
        if (r1.update() == true) goto L17;
        if (this.b.b() == true) goto L17;
        C0091a r4 = this.b;
        r4.b = r4.d;
        r4.l = true;
    L28:
        return true;
    L24:
        long r5 = AnimationUtils.currentAnimationTimeMillis();
        C0091a r6 = this.b;
        long r7 = r5 - r6.h;
        int r8 = r6.i;
        if (r7 >= r8) goto L27;
        float r9 = this.d.getInterpolation(r7 / r8);
        C0091a r10 = this.b;
        r10.c = r10.b;
        int r11 = r10.a;
        r10.b = r11 + Math.round((r10.d - r11) * r9);
        C0091a r12 = this.c;
        r12.c = r12.b;
        int r13 = r12.a;
        r12.b = r13 + Math.round(r9 * (r12.d - r13));
        goto L28
    L27:
        a();
        goto L28
    }

    public a(Context r1, Interpolator r2) {
        this.d = r2;
        this.b = new C0091a(r1);
        this.c = new C0091a(r1);
    }

    public final void c(int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24) {
        if (d() == true) goto L9;
        float r1 = this.b.f;
        float r2 = this.c.f;
        int r3 = r17;
        float r4 = r3;
        if (Math.signum(r4) != Math.signum(r1)) goto L10;
        int r5 = r18;
        float r7 = r5;
        if (Math.signum(r7) != Math.signum(r2)) goto L11;
        r3 = (int) (r4 + r1);
        int r9 = (int) (r7 + r2);
    L12:
        this.a = 1;
        C0091a r6 = this.b;
        if (r3 < 0.0f) goto L15;
        int r8 = r23;
    L16:
        r6.c(r15, r3, r19, r20, 0, r8);
        C0091a r10 = this.c;
        if (r9 < 0.0f) goto L19;
        int r13 = r23;
    L20:
        r10.c(r16, r9, r21, r22, 0, r13);
        return;
    L19:
        r13 = r24;
        goto L20
    L15:
        r8 = r24;
    L11:
        r9 = r5;
    L10:
        r5 = r18;
        goto L11
    L9:
        r3 = r17;
        goto L10
    }
}
