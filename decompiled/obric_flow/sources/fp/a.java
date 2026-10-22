package fp;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f16964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f16965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16966c;
    public boolean d;
    public final String e;
    public Float f;
    public Float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.obric.common.oea.foundation.animation.spec.spring.b f16967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Float f16968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final KClass f16969j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f16970k;

    public a(com.obric.common.oea.foundation.animation.spec.spring.b r5, Float r10, Float r11, Float r12, String r13, KClass r14) {
        Intrinsics.checkNotNullParameter(r13, "property");
        Intrinsics.checkNotNullParameter(r10, "initialValue");
        Intrinsics.checkNotNullParameter(r11, "targetValue");
        Intrinsics.checkNotNullParameter(r5, "spec");
        Intrinsics.checkNotNullParameter(r14, "valueClass");
        this.e = r13;
        this.f = r10;
        this.g = r11;
        this.f16967h = r5;
        this.f16968i = r12;
        this.f16969j = r14;
        this.f16970k = 0.0f;
        this.f16964a = -1;
        this.f16965b = -1;
        this.f16966c = -1;
        this.d = true;
    }

    public final boolean a(long r10) {
        KClass r5 = Reflection.getOrCreateKotlinClass(Float.TYPE);
        KClass r11 = this.f16969j;
        if (Intrinsics.areEqual(r11, r5) == false) goto L7;
        gp.b r12 = gp.b.f17118b;
    L5:
        gp.b r13 = r12;
        long r14 = this.f16964a;
        com.obric.common.oea.foundation.animation.spec.spring.b r15 = this.f16967h;
        if (r14 >= 0) goto L17;
        Float r16 = this.f;
        Float r17 = this.g;
        Float r18 = this.f16968i;
        if (r18 == null) goto L14;
        float r19 = r18.floatValue();
    L15:
        this.f16964a = r15.a(r16.floatValue(), r17.floatValue(), r19);
        goto L17
    L14:
        r19 = 0.0f;
    L17:
        return r13.a(r10, this.f16964a, r15);
    L7:
        if (Intrinsics.areEqual(r11, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L19;
        r12 = gp.b.f17119c;
        goto L5
    L19:
        throw new IllegalArgumentException("Unsupported type " + r11);
    }

    public final void b(boolean r5, boolean r10, boolean r11) {
        this.d = r5;
        if (r11 == false) goto L5;
        float r12 = 0.0f;
    L6:
        this.f16970k = r12;
        this.f16965b = -1;
        this.f16966c = -1;
        if (r10 == false) goto L10;
        Float r13 = this.f;
        this.f = this.g;
        this.g = r13;
        return;
    L10:
        return;
    L5:
        r12 = this.f16970k;
        goto L6
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof a) == false) goto L20;
        a r10 = (a) r5;
        String r11 = r10.e;
        if (Intrinsics.areEqual(this.e, r11) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16967h, r10.f16967h) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f16968i, r10.f16968i) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f16969j, r10.f16969j) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f16970k, r10.f16970k) == 0) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.e;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = (this.f16967h.hashCode() + ((this.g.hashCode() + ((this.f.hashCode() + (r11 * 31)) * 31)) * 31)) * 31;
        Float r13 = this.f16968i;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        KClass r16 = this.f16969j;
        if (r16 == null) goto L14;
        r5 = r16.hashCode();
    L14:
        return Float.hashCode(this.f16970k) + ((r15 + r5) * 31);
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("AnimationInfo(property=");
        r5.append(this.e);
        r5.append(", initialValue=");
        r5.append(this.f);
        r5.append(", targetValue=");
        r5.append(this.g);
        r5.append(", spec=");
        r5.append(this.f16967h);
        r5.append(", initialVelocity=");
        r5.append(this.f16968i);
        r5.append(", valueClass=");
        r5.append(this.f16969j);
        r5.append(", currentVelocity=");
        return androidx.constraintlayout.motion.widget.a.r(r5, this.f16970k, ")");
    }
}
