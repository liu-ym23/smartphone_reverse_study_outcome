package o1;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f20385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f20386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f20387c;
    public final d d;
    public final LinkedHashMap e;

    public c(Class r5, Class r10, d r11, d r12, LinkedHashMap r13) {
        Intrinsics.checkNotNullParameter(r5, "paramClass");
        Intrinsics.checkNotNullParameter(r10, "resultClass");
        Intrinsics.checkNotNullParameter(r11, "paramModel");
        Intrinsics.checkNotNullParameter(r12, "resultModel");
        Intrinsics.checkNotNullParameter(r13, "models");
        this.f20385a = r5;
        this.f20386b = r10;
        this.f20387c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        Class r11 = r10.f20385a;
        if (Intrinsics.areEqual(this.f20385a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20386b, r10.f20386b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20387c, r10.f20387c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f20385a.hashCode() * 31;
        int r10 = (this.f20386b.hashCode() + r5) * 31;
        int r11 = (this.f20387c.f20388a.hashCode() + r10) * 31;
        int r12 = (this.d.f20388a.hashCode() + r11) * 31;
        return this.e.hashCode() + r12;
    }

    public final String toString() {
        return "AnnotationData(paramClass=" + this.f20385a + ", resultClass=" + this.f20386b + ", paramModel=" + this.f20387c + ", resultModel=" + this.d + ", models=" + this.e + ')';
    }
}
