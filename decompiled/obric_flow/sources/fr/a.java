package fr;

import ai.j0;
import com.google.common.reflect.w;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f16976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f16977c;
    public int d;
    public int[] e;
    public int[] f;
    public float[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f16980j;

    public a(b r5, w r10) {
        this.f16975a = 0;
        this.d = 8;
        this.e = new int[8];
        this.f = new int[8];
        this.g = new float[8];
        this.f16978h = -1;
        this.f16979i = -1;
        this.f16980j = false;
        this.f16976b = r5;
        this.f16977c = r10;
    }

    public final void a(e r12, float r13, boolean r14) {
        if (r13 > (-0.001f)) goto L5;
    L7:
        int r5 = this.f16978h;
        b r10 = this.f16976b;
        if (r5 != (-1)) goto L15;
        this.f16978h = 0;
        this.g[0] = r13;
        this.e[0] = r12.f17000b;
        this.f[0] = -1;
        r12.f17006l++;
        r12.a(r10);
        this.f16975a++;
        if (this.f16980j == true) goto L81;
        int r15 = this.f16979i + 1;
        this.f16979i = r15;
        int[] r16 = this.e;
        if (r15 < r16.length) goto L82;
        this.f16980j = true;
        this.f16979i = r16.length - 1;
        return;
    L82:
        return;
    L81:
        return;
    L15:
        int r11 = 0;
        int r17 = -1;
    L16:
        if (r5 == (-1)) goto L42;
        if (r11 >= this.f16975a) goto L42;
        int r18 = this.e[r5];
        int r19 = r12.f17000b;
        if (r18 == r19) goto L21;
        if (r18 >= r19) goto L41;
        r17 = r5;
    L41:
        r5 = this.f[r5];
        r11 = r11 + 1;
        goto L16
    L21:
        float[] r20 = this.g;
        float r21 = r20[r5] + r13;
        if (r21 > (-0.001f)) goto L24;
    L26:
        r20[r5] = r21;
        if (r21 == 0.0f) goto L29;
        return;
    L29:
        if (r5 != this.f16978h) goto L31;
        this.f16978h = this.f[r5];
    L32:
        if (r14 == false) goto L35;
        r12.b(r10);
    L35:
        if (this.f16980j == false) goto L37;
        this.f16979i = r5;
    L37:
        r12.f17006l--;
        this.f16975a--;
        return;
    L31:
        int[] r110 = this.f;
        r110[r17] = r110[r5];
        goto L32
    L24:
        if (r21 >= 0.001f) goto L26;
        r21 = 0.0f;
    L42:
        int r111 = this.f16979i;
        int r22 = r111 + 1;
        if (this.f16980j == false) goto L48;
        int[] r23 = this.e;
        if (r23[r111] == (-1)) goto L49;
        r111 = r23.length;
    L49:
        int[] r24 = this.e;
        if (r111 >= r24.length) goto L52;
    L60:
        int[] r25 = this.e;
        if (r111 < r25.length) goto L63;
        r111 = r25.length;
        int r26 = this.d * 2;
        this.d = r26;
        this.f16980j = false;
        this.f16979i = r111 - 1;
        this.g = Arrays.copyOf(this.g, r26);
        this.e = Arrays.copyOf(this.e, this.d);
        this.f = Arrays.copyOf(this.f, this.d);
    L63:
        this.e[r111] = r12.f17000b;
        this.g[r111] = r13;
        if (r17 == (-1)) goto L66;
        int[] r112 = this.f;
        r112[r111] = r112[r17];
        r112[r17] = r111;
    L67:
        r12.f17006l++;
        r12.a(r10);
        this.f16975a++;
        if (this.f16980j == true) goto L70;
        this.f16979i++;
    L70:
        int r113 = this.f16979i;
        int[] r114 = this.e;
        if (r113 < r114.length) goto L84;
        this.f16980j = true;
        this.f16979i = r114.length - 1;
        return;
    L84:
        return;
    L66:
        this.f[r111] = this.f16978h;
        this.f16978h = r111;
        goto L67
    L52:
        if (this.f16975a >= r24.length) goto L60;
        int r27 = 0;
    L54:
        int[] r28 = this.e;
        if (r27 >= r28.length) goto L60;
        if (r28[r27] == (-1)) goto L58;
        r27 = r27 + 1;
        goto L54
    L58:
        r111 = r27;
        goto L60
    L48:
        r111 = r22;
        goto L49
    L5:
        if (r13 >= 0.001f) goto L7;
    }

    public final void b() {
        int r5 = this.f16978h;
        int r10 = 0;
    L4:
        if (r5 == (-1)) goto L11;
        if (r10 >= this.f16975a) goto L11;
        e r11 = ((e[]) this.f16977c.d)[this.e[r5]];
        if (r11 == null) goto L10;
        r11.b(this.f16976b);
    L10:
        r5 = this.f[r5];
        r10 = r10 + 1;
    L11:
        this.f16978h = -1;
        this.f16979i = -1;
        this.f16980j = false;
        this.f16975a = 0;
    }

    public final float c(e r5) {
        int r10 = this.f16978h;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L12;
        if (r11 >= this.f16975a) goto L17;
        if (this.e[r10] == r5.f17000b) goto L10;
        r10 = this.f[r10];
        r11 = r11 + 1;
        goto L4
    L10:
        return this.g[r10];
    L17:
        return 0.0f;
    L12:
        return 0.0f;
    }

    public final int d() {
        return this.f16975a;
    }

    public final e e(int r5) {
        int r10 = this.f16978h;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L11;
        if (r11 >= this.f16975a) goto L16;
        if (r11 == r5) goto L9;
        r10 = this.f[r10];
        r11 = r11 + 1;
        goto L4
    L9:
        return ((e[]) this.f16977c.d)[this.e[r10]];
    L16:
        return null;
    L11:
        return null;
    }

    public final float f(int r5) {
        int r10 = this.f16978h;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L11;
        if (r11 >= this.f16975a) goto L16;
        if (r11 == r5) goto L9;
        r10 = this.f[r10];
        r11 = r11 + 1;
        goto L4
    L9:
        return this.g[r10];
    L16:
        return 0.0f;
    L11:
        return 0.0f;
    }

    public final void g(e r10, float r11) {
        if (r11 != 0.0f) goto L6;
        h(r10, true);
        return;
    L6:
        int r5 = this.f16978h;
        b r12 = this.f16976b;
        if (r5 != (-1)) goto L14;
        this.f16978h = 0;
        this.g[0] = r11;
        this.e[0] = r10.f17000b;
        this.f[0] = -1;
        r10.f17006l++;
        r10.a(r12);
        this.f16975a++;
        if (this.f16980j == true) goto L67;
        int r13 = this.f16979i + 1;
        this.f16979i = r13;
        int[] r14 = this.e;
        if (r13 < r14.length) goto L68;
        this.f16980j = true;
        this.f16979i = r14.length - 1;
        return;
    L68:
        return;
    L67:
        return;
    L14:
        int r15 = 0;
        int r16 = -1;
    L15:
        if (r5 == (-1)) goto L25;
        if (r15 >= this.f16975a) goto L25;
        int r17 = this.e[r5];
        int r18 = r10.f17000b;
        if (r17 == r18) goto L20;
        if (r17 >= r18) goto L24;
        r16 = r5;
    L24:
        r5 = this.f[r5];
        r15 = r15 + 1;
        goto L15
    L20:
        this.g[r5] = r11;
        return;
    L25:
        int r19 = this.f16979i;
        int r20 = r19 + 1;
        if (this.f16980j == false) goto L31;
        int[] r21 = this.e;
        if (r21[r19] == (-1)) goto L32;
        r19 = r21.length;
    L32:
        int[] r22 = this.e;
        if (r19 >= r22.length) goto L35;
    L43:
        int[] r23 = this.e;
        if (r19 < r23.length) goto L46;
        r19 = r23.length;
        int r24 = this.d * 2;
        this.d = r24;
        this.f16980j = false;
        this.f16979i = r19 - 1;
        this.g = Arrays.copyOf(this.g, r24);
        this.e = Arrays.copyOf(this.e, this.d);
        this.f = Arrays.copyOf(this.f, this.d);
    L46:
        this.e[r19] = r10.f17000b;
        this.g[r19] = r11;
        if (r16 == (-1)) goto L49;
        int[] r110 = this.f;
        r110[r19] = r110[r16];
        r110[r16] = r19;
    L50:
        r10.f17006l++;
        r10.a(r12);
        int r111 = this.f16975a + 1;
        this.f16975a = r111;
        if (this.f16980j == true) goto L53;
        this.f16979i++;
    L53:
        int[] r112 = this.e;
        if (r111 < r112.length) goto L57;
        this.f16980j = true;
    L57:
        if (this.f16979i < r112.length) goto L69;
        this.f16980j = true;
        this.f16979i = r112.length - 1;
        return;
    L69:
        return;
    L49:
        this.f[r19] = this.f16978h;
        this.f16978h = r19;
        goto L50
    L35:
        if (this.f16975a >= r22.length) goto L43;
        int r25 = 0;
    L37:
        int[] r26 = this.e;
        if (r25 >= r26.length) goto L43;
        if (r26[r25] == (-1)) goto L41;
        r25 = r25 + 1;
        goto L37
    L41:
        r19 = r25;
        goto L43
    L31:
        r19 = r20;
        goto L32
    }

    public final float h(e r10, boolean r11) {
        int r5 = this.f16978h;
        if (r5 != (-1)) goto L5;
        return 0.0f;
    L5:
        int r12 = 0;
        int r13 = -1;
    L6:
        if (r5 == (-1)) goto L23;
        if (r12 >= this.f16975a) goto L23;
        if (this.e[r5] == r10.f17000b) goto L12;
        r12 = r12 + 1;
        r13 = r5;
        r5 = this.f[r5];
        goto L6
    L12:
        if (r5 != this.f16978h) goto L14;
        this.f16978h = this.f[r5];
    L15:
        if (r11 == false) goto L17;
        r10.b(this.f16976b);
    L17:
        r10.f17006l--;
        this.f16975a--;
        this.e[r5] = -1;
        if (this.f16980j == false) goto L21;
        this.f16979i = r5;
    L21:
        return this.g[r5];
    L14:
        int[] r14 = this.f;
        r14[r13] = r14[r5];
    L23:
        return 0.0f;
    }

    public final String toString() {
        int r5 = this.f16978h;
        String r10 = "";
        int r11 = 0;
    L4:
        if (r5 == (-1)) goto L8;
        if (r11 >= this.f16975a) goto L8;
        StringBuilder r12 = j0.u(androidx.constraintlayout.motion.widget.a.r(j0.u(j0.j(r10, " -> ")), this.g[r5], " : "));
        r12.append(((e[]) this.f16977c.d)[this.e[r5]]);
        r10 = r12.toString();
        r5 = this.f[r5];
        r11 = r11 + 1;
    L8:
        return r10;
    }
}
