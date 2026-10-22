package cj;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KClass f1204c;
    public final KClass d;
    public final boolean e;
    public final boolean f;
    public final h g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Class f1205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f1206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f1207j;

    public i(boolean r5, String r10, KClass r11, KClass r12, boolean r13, boolean r14, h r15, Class r16, List r17, List r18) {
        Intrinsics.checkNotNullParameter(r10, "keyPath");
        Intrinsics.checkNotNullParameter(r11, "nestedClassType");
        Intrinsics.checkNotNullParameter(r12, "primitiveClassType");
        Intrinsics.checkNotNullParameter(r15, "defaultValue");
        Intrinsics.checkNotNullParameter(r16, "returnType");
        Intrinsics.checkNotNullParameter(r17, "stringEnum");
        Intrinsics.checkNotNullParameter(r18, "intEnum");
        this.f1202a = r5;
        this.f1203b = r10;
        this.f1204c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f1205h = r16;
        this.f1206i = r17;
        this.f1207j = r18;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r10 = (i) r5;
        boolean r11 = r10.f1202a;
        if (this.f1202a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1203b, r10.f1203b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f1204c, r10.f1204c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f1205h, r10.f1205h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f1206i, r10.f1206i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f1207j, r10.f1207j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r5 = Boolean.hashCode(this.f1202a) * 31;
        int r10 = kk.a.b(this.f1203b, r5, 31);
        int r11 = (this.f1204c.hashCode() + r10) * 31;
        int r12 = kn.e.a(kn.e.a((this.d.hashCode() + r11) * 31, 31, this.e), 31, this.f);
        int r13 = (this.g.hashCode() + r12) * 31;
        int r14 = (this.f1205h.hashCode() + r13) * 31;
        int r15 = androidx.constraintlayout.motion.widget.a.f(this.f1206i, r14, 31);
        return this.f1207j.hashCode() + r15;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("IDLParamField(required=");
        r5.append(this.f1202a);
        r5.append(", keyPath=");
        r5.append(this.f1203b);
        r5.append(", nestedClassType=");
        r5.append(this.f1204c);
        r5.append(", primitiveClassType=");
        r5.append(this.d);
        r5.append(", isEnum=");
        r5.append(this.e);
        r5.append(", isGetter=");
        r5.append(this.f);
        r5.append(", defaultValue=");
        r5.append(this.g);
        r5.append(", returnType=");
        r5.append(this.f1205h);
        r5.append(", stringEnum=");
        r5.append(this.f1206i);
        r5.append(", intEnum=");
        return androidx.constraintlayout.motion.widget.a.v(r5, this.f1207j, ')');
    }
}
