package cj;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f1194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f1195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f1196c;
    public final g d;
    public final HashMap e;

    public f(Class r5, Class r10, g r11, g r12, HashMap r13) {
        Intrinsics.checkNotNullParameter(r5, "paramClass");
        Intrinsics.checkNotNullParameter(r10, "resultClass");
        Intrinsics.checkNotNullParameter(r11, "xBridgeParamModel");
        Intrinsics.checkNotNullParameter(r12, "xBridgeResultModel");
        Intrinsics.checkNotNullParameter(r13, "models");
        this.f1194a = r5;
        this.f1195b = r10;
        this.f1196c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r10 = (f) r5;
        Class r11 = r10.f1194a;
        if (Intrinsics.areEqual(this.f1194a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1195b, r10.f1195b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f1196c, r10.f1196c) == true) goto L18;
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
        int r5 = this.f1194a.hashCode() * 31;
        int r10 = (this.f1195b.hashCode() + r5) * 31;
        int r11 = (this.f1196c.hashCode() + r10) * 31;
        int r12 = (this.d.hashCode() + r11) * 31;
        return this.e.hashCode() + r12;
    }

    public final String toString() {
        return "IDLAnnotationData(paramClass=" + this.f1194a + ", resultClass=" + this.f1195b + ", xBridgeParamModel=" + this.f1196c + ", xBridgeResultModel=" + this.d + ", models=" + this.e + ')';
    }
}
