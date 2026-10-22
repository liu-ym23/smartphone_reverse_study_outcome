package p;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f9852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f9853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f9855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f9856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f9857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9859i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9860j;

    public a(b r8, c r10) {
        this.f9851a = 0;
        this.f9854d = 8;
        this.f9855e = new int[8];
        this.f9856f = new int[8];
        this.f9857g = new float[8];
        this.f9858h = -1;
        this.f9859i = -1;
        this.f9860j = false;
        this.f9852b = r8;
        this.f9853c = r10;
    }

    @Override // p.b.a
    public final h a(int r8) {
        int r10 = this.f9858h;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L11;
        if (r11 >= this.f9851a) goto L16;
        if (r11 == r8) goto L9;
        r10 = this.f9856f[r10];
        r11 = r11 + 1;
        goto L4
    L9:
        return ((h[]) this.f9853c.f9869d)[this.f9855e[r10]];
    L16:
        return null;
    L11:
        return null;
    }

    @Override // p.b.a
    public final void b() {
        int r8 = this.f9858h;
        int r10 = 0;
    L4:
        if (r8 == (-1)) goto L8;
        if (r10 >= this.f9851a) goto L11;
        float[] r11 = this.f9857g;
        r11[r8] = r11[r8] * (-1.0f);
        r8 = this.f9856f[r8];
        r10 = r10 + 1;
        goto L4
    L11:
        return;
    }

    @Override // p.b.a
    public final float c(b r8, boolean r10) {
        float r11 = j(r8.f9861a);
        d(r8.f9861a, r10);
        b.a r12 = r8.f9864d;
        int r13 = r12.g();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        h r15 = r12.a(r14);
        f(r15, r12.j(r15) * r11, r10);
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // p.b.a
    public final void clear() {
        int r8 = this.f9858h;
        int r10 = 0;
    L4:
        if (r8 == (-1)) goto L11;
        if (r10 >= this.f9851a) goto L11;
        h r11 = ((h[]) this.f9853c.f9869d)[this.f9855e[r8]];
        if (r11 == null) goto L10;
        r11.b(this.f9852b);
    L10:
        r8 = this.f9856f[r8];
        r10 = r10 + 1;
    L11:
        this.f9858h = -1;
        this.f9859i = -1;
        this.f9860j = false;
        this.f9851a = 0;
    }

    @Override // p.b.a
    public final float d(h r10, boolean r11) {
        int r8 = this.f9858h;
        if (r8 != (-1)) goto L5;
        return 0.0f;
    L5:
        int r12 = 0;
        int r13 = -1;
    L6:
        if (r8 == (-1)) goto L23;
        if (r12 >= this.f9851a) goto L23;
        if (this.f9855e[r8] == r10.f9896b) goto L12;
        r12 = r12 + 1;
        r13 = r8;
        r8 = this.f9856f[r8];
        goto L6
    L12:
        if (r8 != this.f9858h) goto L14;
        this.f9858h = this.f9856f[r8];
    L15:
        if (r11 == false) goto L17;
        r10.b(this.f9852b);
    L17:
        r10.f9906v--;
        this.f9851a--;
        this.f9855e[r8] = -1;
        if (this.f9860j == false) goto L21;
        this.f9859i = r8;
    L21:
        return this.f9857g[r8];
    L14:
        int[] r14 = this.f9856f;
        r14[r13] = r14[r8];
    L23:
        return 0.0f;
    }

    @Override // p.b.a
    public final void e(h r10, float r11) {
        if (r11 != 0.0f) goto L6;
        d(r10, true);
        return;
    L6:
        int r8 = this.f9858h;
        b r12 = this.f9852b;
        if (r8 != (-1)) goto L14;
        this.f9858h = 0;
        this.f9857g[0] = r11;
        this.f9855e[0] = r10.f9896b;
        this.f9856f[0] = -1;
        r10.f9906v++;
        r10.a(r12);
        this.f9851a++;
        if (this.f9860j == true) goto L67;
        int r13 = this.f9859i + 1;
        this.f9859i = r13;
        int[] r14 = this.f9855e;
        if (r13 < r14.length) goto L68;
        this.f9860j = true;
        this.f9859i = r14.length - 1;
        return;
    L68:
        return;
    L67:
        return;
    L14:
        int r15 = -1;
        int r16 = 0;
    L15:
        if (r8 == (-1)) goto L25;
        if (r16 >= this.f9851a) goto L25;
        int r17 = this.f9855e[r8];
        int r18 = r10.f9896b;
        if (r17 == r18) goto L20;
        if (r17 >= r18) goto L24;
        r15 = r8;
    L24:
        r8 = this.f9856f[r8];
        r16 = r16 + 1;
        goto L15
    L20:
        this.f9857g[r8] = r11;
        return;
    L25:
        int r19 = this.f9859i;
        int r20 = r19 + 1;
        if (this.f9860j == false) goto L31;
        int[] r21 = this.f9855e;
        if (r21[r19] == (-1)) goto L32;
        r19 = r21.length;
    L32:
        int[] r22 = this.f9855e;
        if (r19 >= r22.length) goto L35;
    L43:
        int[] r23 = this.f9855e;
        if (r19 < r23.length) goto L46;
        r19 = r23.length;
        int r24 = this.f9854d * 2;
        this.f9854d = r24;
        this.f9860j = false;
        this.f9859i = r19 - 1;
        this.f9857g = Arrays.copyOf(this.f9857g, r24);
        this.f9855e = Arrays.copyOf(this.f9855e, this.f9854d);
        this.f9856f = Arrays.copyOf(this.f9856f, this.f9854d);
    L46:
        this.f9855e[r19] = r10.f9896b;
        this.f9857g[r19] = r11;
        int[] r110 = this.f9856f;
        if (r15 == (-1)) goto L49;
        r110[r19] = r110[r15];
        r110[r15] = r19;
    L50:
        r10.f9906v++;
        r10.a(r12);
        int r111 = this.f9851a + 1;
        this.f9851a = r111;
        if (this.f9860j == true) goto L53;
        this.f9859i++;
    L53:
        int[] r112 = this.f9855e;
        if (r111 < r112.length) goto L57;
        this.f9860j = true;
    L57:
        if (this.f9859i < r112.length) goto L69;
        this.f9860j = true;
        this.f9859i = r112.length - 1;
        return;
    L69:
        return;
    L49:
        r110[r19] = this.f9858h;
        this.f9858h = r19;
        goto L50
    L35:
        if (this.f9851a >= r22.length) goto L43;
        int r25 = 0;
    L37:
        int[] r26 = this.f9855e;
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

    @Override // p.b.a
    public final void f(h r12, float r13, boolean r14) {
        if (r13 > (-0.001f)) goto L5;
    L7:
        int r8 = this.f9858h;
        b r10 = this.f9852b;
        if (r8 != (-1)) goto L15;
        this.f9858h = 0;
        this.f9857g[0] = r13;
        this.f9855e[0] = r12.f9896b;
        this.f9856f[0] = -1;
        r12.f9906v++;
        r12.a(r10);
        this.f9851a++;
        if (this.f9860j == true) goto L81;
        int r15 = this.f9859i + 1;
        this.f9859i = r15;
        int[] r16 = this.f9855e;
        if (r15 < r16.length) goto L82;
        this.f9860j = true;
        this.f9859i = r16.length - 1;
        return;
    L82:
        return;
    L81:
        return;
    L15:
        int r11 = 0;
        int r17 = -1;
    L16:
        if (r8 == (-1)) goto L42;
        if (r11 >= this.f9851a) goto L42;
        int r18 = this.f9855e[r8];
        int r19 = r12.f9896b;
        if (r18 == r19) goto L21;
        if (r18 >= r19) goto L41;
        r17 = r8;
    L41:
        r8 = this.f9856f[r8];
        r11 = r11 + 1;
        goto L16
    L21:
        float[] r20 = this.f9857g;
        float r21 = r20[r8] + r13;
        if (r21 > (-0.001f)) goto L24;
    L26:
        r20[r8] = r21;
        if (r21 == 0.0f) goto L29;
        return;
    L29:
        if (r8 != this.f9858h) goto L31;
        this.f9858h = this.f9856f[r8];
    L32:
        if (r14 == false) goto L35;
        r12.b(r10);
    L35:
        if (this.f9860j == false) goto L37;
        this.f9859i = r8;
    L37:
        r12.f9906v--;
        this.f9851a--;
        return;
    L31:
        int[] r110 = this.f9856f;
        r110[r17] = r110[r8];
        goto L32
    L24:
        if (r21 >= 0.001f) goto L26;
        r21 = 0.0f;
    L42:
        int r111 = this.f9859i;
        int r22 = r111 + 1;
        if (this.f9860j == false) goto L48;
        int[] r23 = this.f9855e;
        if (r23[r111] == (-1)) goto L49;
        r111 = r23.length;
    L49:
        int[] r24 = this.f9855e;
        if (r111 >= r24.length) goto L52;
    L60:
        int[] r25 = this.f9855e;
        if (r111 < r25.length) goto L63;
        r111 = r25.length;
        int r26 = this.f9854d * 2;
        this.f9854d = r26;
        this.f9860j = false;
        this.f9859i = r111 - 1;
        this.f9857g = Arrays.copyOf(this.f9857g, r26);
        this.f9855e = Arrays.copyOf(this.f9855e, this.f9854d);
        this.f9856f = Arrays.copyOf(this.f9856f, this.f9854d);
    L63:
        this.f9855e[r111] = r12.f9896b;
        this.f9857g[r111] = r13;
        int[] r112 = this.f9856f;
        if (r17 == (-1)) goto L66;
        r112[r111] = r112[r17];
        r112[r17] = r111;
    L67:
        r12.f9906v++;
        r12.a(r10);
        this.f9851a++;
        if (this.f9860j == true) goto L70;
        this.f9859i++;
    L70:
        int r113 = this.f9859i;
        int[] r114 = this.f9855e;
        if (r113 < r114.length) goto L84;
        this.f9860j = true;
        this.f9859i = r114.length - 1;
        return;
    L84:
        return;
    L66:
        r112[r111] = this.f9858h;
        this.f9858h = r111;
        goto L67
    L52:
        if (this.f9851a >= r24.length) goto L60;
        int r27 = 0;
    L54:
        int[] r28 = this.f9855e;
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

    @Override // p.b.a
    public final int g() {
        return this.f9851a;
    }

    @Override // p.b.a
    public final float h(int r8) {
        int r10 = this.f9858h;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L11;
        if (r11 >= this.f9851a) goto L16;
        if (r11 == r8) goto L9;
        r10 = this.f9856f[r10];
        r11 = r11 + 1;
        goto L4
    L9:
        return this.f9857g[r10];
    L16:
        return 0.0f;
    L11:
        return 0.0f;
    }

    @Override // p.b.a
    public final boolean i(h r8) {
        int r10 = this.f9858h;
        if (r10 != (-1)) goto L5;
        return false;
    L5:
        int r11 = 0;
    L6:
        if (r10 == (-1)) goto L14;
        if (r11 >= this.f9851a) goto L14;
        if (this.f9855e[r10] == r8.f9896b) goto L11;
        r10 = this.f9856f[r10];
        r11 = r11 + 1;
        goto L6
    L11:
        return true;
    L14:
        return false;
    }

    @Override // p.b.a
    public final float j(h r8) {
        int r10 = this.f9858h;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L12;
        if (r11 >= this.f9851a) goto L17;
        if (this.f9855e[r10] == r8.f9896b) goto L10;
        r10 = this.f9856f[r10];
        r11 = r11 + 1;
        goto L4
    L10:
        return this.f9857g[r10];
    L17:
        return 0.0f;
    L12:
        return 0.0f;
    }

    @Override // p.b.a
    public final void k(float r8) {
        int r10 = this.f9858h;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L8;
        if (r11 >= this.f9851a) goto L11;
        float[] r12 = this.f9857g;
        r12[r10] = r12[r10] / r8;
        r10 = this.f9856f[r10];
        r11 = r11 + 1;
        goto L4
    L11:
        return;
    }

    public final String toString() {
        int r8 = this.f9858h;
        String r10 = "";
        int r11 = 0;
    L4:
        if (r8 == (-1)) goto L8;
        if (r11 >= this.f9851a) goto L8;
        StringBuilder r12 = android.aimedia.a.j(defpackage.a.e(r10, " -> "));
        r12.append(this.f9857g[r8]);
        r12.append(" : ");
        StringBuilder r13 = android.aimedia.a.j(r12.toString());
        r13.append(((h[]) this.f9853c.f9869d)[this.f9855e[r8]]);
        r10 = r13.toString();
        r8 = this.f9856f[r8];
        r11 = r11 + 1;
    L8:
        return r10;
    }
}
