package fr;

import java.util.Arrays;
import ym.p;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends b {
    public e[] f;
    public e[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p f16998i;

    @Override // fr.b
    public final e d(boolean[] r10) {
        int r5 = 0;
        int r11 = -1;
    L4:
        if (r5 >= this.f16997h) goto L27;
        e[] r12 = this.f;
        e r13 = r12[r5];
        if (r10[r13.f17000b] == true) goto L26;
        p r14 = this.f16998i;
        r14.f23312b = r13;
        int r15 = 8;
        if (r11 != (-1)) goto L18;
    L10:
        if (r15 < 0) goto L26;
        float r16 = ((e) r14.f23312b).f17002h[r15];
        if (r16 > 0.0f) goto L26;
        if (r16 < 0.0f) goto L25;
        r15 = r15 - 1;
    L25:
        r11 = r5;
        goto L26
    L18:
        e r17 = r12[r11];
    L19:
        if (r15 < 0) goto L26;
        float r18 = r17.f17002h[r15];
        float r19 = ((e) r14.f23312b).f17002h[r15];
        if (r19 != r18) goto L24;
        r15 = r15 - 1;
        goto L19
    L24:
        if (r19 < r18) goto L25;
    L26:
        r5 = r5 + 1;
        goto L4
    L27:
        if (r11 != (-1)) goto L31;
        return null;
    L31:
        return this.f[r11];
    }

    @Override // fr.b
    public final boolean e() {
        if (this.f16997h != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // fr.b
    public final void i(c r19, b r20, boolean r21) {
        e r5 = r20.f16981a;
        if (r5 != null) goto L5;
        return;
    L5:
        a r10 = r20.d;
        int r11 = r10.d();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L30;
        e r13 = r10.e(r12);
        float r14 = r10.f(r12);
        p r15 = this.f16998i;
        r15.f23312b = r13;
        boolean r16 = r13.f16999a;
        float[] r17 = r5.f17002h;
        if (r16 == false) goto L18;
        boolean r18 = true;
        int r110 = 0;
    L10:
        if (r110 >= 9) goto L16;
        float[] r111 = ((e) r15.f23312b).f17002h;
        float r112 = (r17[r110] * r14) + r111[r110];
        r111[r110] = r112;
        if (Math.abs(r112) >= 1.0E-4f) goto L14;
        ((e) r15.f23312b).f17002h[r110] = 0.0f;
    L15:
        r110 = r110 + 1;
        goto L10
    L14:
        r18 = false;
        goto L15
    L16:
        if (r18 == false) goto L29;
        ((d) r15.f23313c).k((e) r15.f23312b);
    L29:
        this.f16982b = (r20.f16982b * r14) + this.f16982b;
        r12 = r12 + 1;
        goto L6
    L18:
        int r113 = 0;
    L19:
        if (r113 >= 9) goto L28;
        float r114 = r17[r113];
        if (r114 == 0.0f) goto L26;
        float r115 = r114 * r14;
        if (Math.abs(r115) >= 1.0E-4f) goto L25;
        r115 = 0.0f;
    L25:
        ((e) r15.f23312b).f17002h[r113] = r115;
    L27:
        r113 = r113 + 1;
        goto L19
    L26:
        ((e) r15.f23312b).f17002h[r113] = 0.0f;
        goto L27
    L28:
        j(r13);
        goto L29
    L30:
        k(r5);
    }

    public final void j(e r10) {
        int r5 = this.f16997h + 1;
        e[] r11 = this.f;
        if (r5 <= r11.length) goto L5;
        e[] r12 = (e[]) Arrays.copyOf(r11, r11.length * 2);
        this.f = r12;
        this.g = (e[]) Arrays.copyOf(r12, r12.length * 2);
    L5:
        e[] r13 = this.f;
        int r14 = this.f16997h;
        r13[r14] = r10;
        int r15 = r14 + 1;
        this.f16997h = r15;
        if (r15 > 1) goto L8;
    L17:
        r10.f16999a = true;
        r10.a(this);
        return;
    L8:
        if (r13[r14].f17000b <= r10.f17000b) goto L17;
        int r16 = 0;
        int r17 = 0;
    L10:
        int r18 = this.f16997h;
        if (r17 >= r18) goto L13;
        this.g[r17] = this.f[r17];
        r17 = r17 + 1;
        goto L10
    L13:
        Arrays.sort(this.g, 0, r18, new ca.d(18));
    L15:
        if (r16 >= this.f16997h) goto L17;
        this.f[r16] = this.g[r16];
        r16 = r16 + 1;
        goto L15
    }

    public final void k(e r10) {
        int r5 = 0;
    L4:
        if (r5 >= this.f16997h) goto L13;
        if (this.f[r5] == r10) goto L7;
        r5 = r5 + 1;
    L7:
        int r11 = this.f16997h;
        if (r5 >= (r11 - 1)) goto L10;
        e[] r12 = this.f;
        int r13 = r5 + 1;
        r12[r5] = r12[r13];
        r5 = r13;
        goto L7
    L10:
        this.f16997h = r11 - 1;
        r10.f16999a = false;
        return;
    }

    @Override // fr.b
    public final String toString() {
        String r5 = androidx.constraintlayout.motion.widget.a.r(new StringBuilder(" goal -> ("), this.f16982b, ") : ");
        int r10 = 0;
    L4:
        if (r10 >= this.f16997h) goto L6;
        e r11 = this.f[r10];
        p r12 = this.f16998i;
        r12.f23312b = r11;
        r5 = r5 + r12 + " ";
        r10 = r10 + 1;
        goto L4
    L6:
        return r5;
    }
}
