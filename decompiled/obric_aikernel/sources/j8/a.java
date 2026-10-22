package j8;

import java.util.Objects;
import k8.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private T f9782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private T f9783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final o8.a<T> f9784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Float f9785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final KClass<T> f9786j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f9787k;

    public a(String r10, T r11, T r12, o8.a<T> r13, Float r14, KClass<T> r15, float r16) {
        Intrinsics.checkNotNullParameter(r10, "property");
        Intrinsics.checkNotNullParameter(r11, "initialValue");
        Intrinsics.checkNotNullParameter(r12, "targetValue");
        Intrinsics.checkNotNullParameter(r13, "spec");
        Intrinsics.checkNotNullParameter(r15, "valueClass");
        this.f9781e = r10;
        this.f9782f = r11;
        this.f9783g = r12;
        this.f9784h = r13;
        this.f9785i = r14;
        this.f9786j = r15;
        this.f9787k = r16;
        this.f9777a = -1;
        this.f9778b = -1;
        this.f9779c = -1;
        this.f9780d = true;
    }

    public /* synthetic */ a(String r10, Object r11, Object r12, o8.a r13, Float r14, KClass r15, float r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 64) == 0) goto L5;
        float r19 = 0.0f;
    L6:
        this(r10, r11, r12, r13, r14, r15, r19);
        return;
    L5:
        r19 = r16;
        goto L6
    }

    public final String a() {
        return "AnimationInfo(property: " + this.f9781e + ", initialValue: " + this.f9782f + ", targetValue: " + this.f9783g + ", spec: " + this.f9784h.b() + ", initialVelocity: " + this.f9785i + ", valueClass: " + this.f9786j + ", currentVelocity: " + this.f9787k + ", durationNanos: " + this.f9777a + ", firstFrameTimeNanos: " + this.f9778b + ", lastFrameTimeNanos: " + this.f9779c + ", isRunning: " + this.f9780d + ')';
    }

    public final float b() {
        return this.f9787k;
    }

    public final long c() {
        return this.f9778b;
    }

    public final T d() {
        return this.f9782f;
    }

    public final Float e() {
        return this.f9785i;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == false) goto L20;
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.f9781e, r11.f9781e) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f9782f, r11.f9782f) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f9783g, r11.f9783g) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9784h, r11.f9784h) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f9785i, r11.f9785i) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f9786j, r11.f9786j) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f9787k, r11.f9787k) == 0) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final String f() {
        return this.f9781e;
    }

    public final long g() {
        if (this.f9777a >= 0) goto L10;
        o8.a<T> r10 = this.f9784h;
        T r11 = this.f9782f;
        T r12 = this.f9783g;
        Float r13 = this.f9785i;
        if (r13 == null) goto L7;
        float r14 = r13.floatValue();
    L8:
        this.f9777a = r10.d(r11, r12, r14);
        goto L10
    L7:
        r14 = 0.0f;
    L10:
        return this.f9777a;
    }

    public final T h() {
        return this.f9783g;
    }

    public int hashCode() {
        String r10 = this.f9781e;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        int r13 = r12 * 31;
        T r14 = this.f9782f;
        if (r14 == null) goto L9;
        int r15 = r14.hashCode();
    L10:
        int r16 = (r13 + r15) * 31;
        T r17 = this.f9783g;
        if (r17 == null) goto L13;
        int r18 = r17.hashCode();
    L14:
        int r19 = (r16 + r18) * 31;
        o8.a<T> r20 = this.f9784h;
        if (r20 == null) goto L17;
        int r21 = r20.hashCode();
    L18:
        int r22 = (r19 + r21) * 31;
        Float r23 = this.f9785i;
        if (r23 == null) goto L21;
        int r24 = r23.hashCode();
    L22:
        int r25 = (r22 + r24) * 31;
        KClass<T> r26 = this.f9786j;
        if (r26 == null) goto L26;
        r11 = r26.hashCode();
    L26:
        return ((r25 + r11) * 31) + Float.hashCode(this.f9787k);
    L21:
        r24 = 0;
        goto L22
    L17:
        r21 = 0;
        goto L18
    L13:
        r18 = 0;
        goto L14
    L9:
        r15 = 0;
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    public final T i(long r11) {
        KClass<T> r10 = this.f9786j;
        if (Intrinsics.areEqual(r10, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L7;
        k8.a r12 = k8.b.f10132a;
    L5:
        Objects.requireNonNull(r12, "null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
        k8.a r13 = r12;
        T r14 = this.f9782f;
        T r15 = this.f9783g;
        Float r16 = this.f9785i;
        if (r16 == null) goto L12;
        float r17 = r16.floatValue();
    L14:
        return (T) r13.a(r11, r14, r15, r17, this.f9784h);
    L12:
        r17 = 0.0f;
        goto L14
    L7:
        if (Intrinsics.areEqual(r10, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L16;
        r12 = c.f10133a;
        goto L5
    L16:
        throw new IllegalArgumentException("Unsupported type " + this.f9786j);
    }

    public final float j(long r11) {
        KClass<T> r10 = this.f9786j;
        if (Intrinsics.areEqual(r10, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L7;
        k8.a r12 = k8.b.f10132a;
    L5:
        Objects.requireNonNull(r12, "null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
        k8.a r13 = r12;
        T r14 = this.f9782f;
        T r15 = this.f9783g;
        Float r16 = this.f9785i;
        if (r16 == null) goto L12;
        float r17 = r16.floatValue();
    L13:
        float r18 = r13.b(r11, r14, r15, r17, this.f9784h);
        this.f9787k = r18;
        return r18;
    L12:
        r17 = 0.0f;
        goto L13
    L7:
        if (Intrinsics.areEqual(r10, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L16;
        r12 = c.f10133a;
        goto L5
    L16:
        throw new IllegalArgumentException("Unsupported type " + this.f9786j);
    }

    public final boolean k(long r10) {
        KClass<T> r11 = this.f9786j;
        if (Intrinsics.areEqual(r11, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L7;
        k8.a r12 = k8.b.f10132a;
    L5:
        Objects.requireNonNull(r12, "null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
        return r12.c(r10, g(), this.f9784h);
    L7:
        if (Intrinsics.areEqual(r11, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L12;
        r12 = c.f10133a;
        goto L5
    L12:
        throw new IllegalArgumentException("Unsupported type " + this.f9786j);
    }

    public final boolean l() {
        return this.f9780d;
    }

    public final void m(boolean r10, boolean r11, boolean r12) {
        this.f9780d = r10;
        if (r12 == false) goto L5;
        float r13 = 0.0f;
    L6:
        this.f9787k = r13;
        this.f9778b = -1;
        this.f9779c = -1;
        if (r11 == false) goto L10;
        T r14 = this.f9782f;
        this.f9782f = this.f9783g;
        this.f9783g = r14;
        return;
    L10:
        return;
    L5:
        r13 = this.f9787k;
        goto L6
    }

    public final void n(long r10) {
        this.f9778b = r10;
    }

    public final void o(Float r10) {
        this.f9785i = r10;
    }

    public final void p(long r10) {
        this.f9779c = r10;
    }

    public final void q(boolean r10) {
        this.f9780d = r10;
    }

    public String toString() {
        return "AnimationInfo(property=" + this.f9781e + ", initialValue=" + this.f9782f + ", targetValue=" + this.f9783g + ", spec=" + this.f9784h + ", initialVelocity=" + this.f9785i + ", valueClass=" + this.f9786j + ", currentVelocity=" + this.f9787k + ")";
    }
}
