package hp;

import com.obric.common.oea.foundation.animation.spec.spring.b;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f17355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f17356c;
    public final KClass d;
    public final b e;
    public final Float f;

    public a(b r5, Float r10, Float r11, Float r12, String r13, KClass r14) {
        Intrinsics.checkNotNullParameter(r13, "property");
        Intrinsics.checkNotNullParameter(r10, "initialValue");
        Intrinsics.checkNotNullParameter(r11, "targetValue");
        Intrinsics.checkNotNullParameter(r14, "valueClass");
        Intrinsics.checkNotNullParameter(r5, "spec");
        this.f17354a = r13;
        this.f17355b = r10;
        this.f17356c = r11;
        this.d = r14;
        this.e = r5;
        this.f = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof a) == false) goto L18;
        a r10 = (a) r5;
        String r11 = r10.f17354a;
        if (Intrinsics.areEqual(this.f17354a, r11) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f17355b, r10.f17355b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f17356c, r10.f17356c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f17354a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = (this.f17356c.hashCode() + ((this.f17355b.hashCode() + (r11 * 31)) * 31)) * 31;
        KClass r13 = this.d;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (this.e.hashCode() + ((r12 + r14) * 31)) * 31;
        Float r16 = this.f;
        if (r16 == null) goto L14;
        r5 = r16.hashCode();
    L14:
        return r15 + r5;
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "SpringAnimationCommand(property=" + this.f17354a + ", initialValue=" + this.f17355b + ", targetValue=" + this.f17356c + ", valueClass=" + this.d + ", spec=" + this.e + ", initialVelocity=" + this.f + ")";
    }
}
