package ya;

import defpackage.c;
import he.d;
import he.i;
import he.p;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f14095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f14097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public T f14098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public T f14099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final fb.a<T> f14100h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Float f14101i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final le.b<T> f14102j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f14103k;

    public a() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r8, Object r10, Object r11, fb.a r12, Float r13, le.b r14) {
        i.f(r8, "property");
        i.f(r10, "initialValue");
        i.f(r11, "targetValue");
        i.f(r12, "spec");
        i.f(r14, "valueClass");
        this.f14097e = r8;
        this.f14098f = r10;
        this.f14099g = r11;
        this.f14100h = r12;
        this.f14101i = r13;
        this.f14102j = r14;
        this.f14103k = 0.0f;
        this.f14093a = -1;
        this.f14094b = -1;
        this.f14095c = -1;
        this.f14096d = true;
    }

    public final boolean a(long r8) {
        d r10 = p.a(Float.TYPE);
        le.b<T> r11 = this.f14102j;
        if (i.a(r11, r10) == false) goto L7;
        ab.a r12 = c.f3203h;
    L5:
        ab.a r13 = r12;
        if (this.f14093a >= 0) goto L17;
        T r14 = this.f14098f;
        T r15 = this.f14099g;
        Float r16 = this.f14101i;
        if (r16 == null) goto L14;
        float r17 = r16.floatValue();
    L15:
        this.f14093a = this.f14100h.a(r17, r14, r15);
        goto L17
    L14:
        r17 = 0.0f;
    L17:
        return r13.d(r8, this.f14093a, this.f14100h);
    L7:
        if (i.a(r11, p.a(Integer.TYPE)) == false) goto L19;
        r12 = l6.a.f9133b;
        goto L5
    L19:
        throw new IllegalArgumentException("Unsupported type " + r11);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L4;
        return true;
    L4:
        if ((r8 instanceof a) == false) goto L20;
        a r10 = (a) r8;
        String r11 = r10.f14097e;
        if (i.a(this.f14097e, r11) == true) goto L8;
        return false;
    L8:
        if (i.a(this.f14098f, r10.f14098f) == true) goto L10;
        return false;
    L10:
        if (i.a(this.f14099g, r10.f14099g) == true) goto L12;
        return false;
    L12:
        if (i.a(this.f14100h, r10.f14100h) == true) goto L14;
        return false;
    L14:
        if (i.a(this.f14101i, r10.f14101i) == true) goto L16;
        return false;
    L16:
        if (i.a(this.f14102j, r10.f14102j) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f14103k, r10.f14103k) == 0) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r8 = 0;
        String r10 = this.f14097e;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = r11 * 31;
        T r13 = this.f14098f;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        T r16 = this.f14099g;
        if (r16 == null) goto L13;
        int r17 = r16.hashCode();
    L14:
        int r18 = (r15 + r17) * 31;
        fb.a<T> r19 = this.f14100h;
        if (r19 == null) goto L17;
        int r20 = r19.hashCode();
    L18:
        int r21 = (r18 + r20) * 31;
        Float r22 = this.f14101i;
        if (r22 == null) goto L21;
        int r23 = r22.hashCode();
    L22:
        int r24 = (r21 + r23) * 31;
        le.b<T> r25 = this.f14102j;
        if (r25 == null) goto L26;
        r8 = r25.hashCode();
    L26:
        return Float.hashCode(this.f14103k) + ((r24 + r8) * 31);
    L21:
        r23 = 0;
        goto L22
    L17:
        r20 = 0;
        goto L18
    L13:
        r17 = 0;
        goto L14
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "AnimationInfo(property=" + this.f14097e + ", initialValue=" + this.f14098f + ", targetValue=" + this.f14099g + ", spec=" + this.f14100h + ", initialVelocity=" + this.f14101i + ", valueClass=" + this.f14102j + ", currentVelocity=" + this.f14103k + ")";
    }
}
