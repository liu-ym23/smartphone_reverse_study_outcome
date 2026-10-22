package bja;

import cja.c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a<T> {
    public long a;
    public long b;
    public long c;
    public boolean d;
    public final String e;
    public T f;
    public T g;
    public final gja.a<T> h;
    public Float i;
    public final KClass<T> j;
    public float k;

    public a() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L20;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.k, r4.k) == 0) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r0 = this.e;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        T r4 = this.f;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        T r7 = this.g;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        gja.a<T> r10 = this.h;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Float r13 = this.i;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        KClass<T> r16 = this.j;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return ((r15 + r1) * 31) + Float.floatToIntBits(this.k);
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnimationInfo(property=" + this.e + ", initialValue=" + this.f + ", targetValue=" + this.g + ", spec=" + this.h + ", initialVelocity=" + this.i + ", valueClass=" + this.j + ", currentVelocity=" + this.k + ")";
    }

    public final boolean a(long r8) {
        KClass<T> r0 = this.j;
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L7;
        cja.a r1 = cja.b.a;
    L5:
        cja.a r2 = r1;
        if (this.a >= 0) goto L17;
        gja.a<T> r3 = this.h;
        T r4 = this.f;
        T r5 = this.g;
        Float r6 = this.i;
        if (r6 == null) goto L14;
        float r7 = r6.floatValue();
    L15:
        this.a = r3.b(r4, r5, r7);
        goto L17
    L14:
        r7 = 0.0f;
    L17:
        return r2.a(r8, this.a, this.h);
    L7:
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L19;
        r1 = c.a;
        goto L5
    L19:
        throw new IllegalArgumentException("Unsupported type " + this.j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r2, Object r3, Object r4, gja.a r5, Float r6, KClass r7) {
        Intrinsics.checkNotNullParameter(r2, "property");
        Intrinsics.checkNotNullParameter(r3, "initialValue");
        Intrinsics.checkNotNullParameter(r4, "targetValue");
        Intrinsics.checkNotNullParameter(r5, "spec");
        Intrinsics.checkNotNullParameter(r7, "valueClass");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.k = 0.0f;
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = true;
    }
}
