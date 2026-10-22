package cj;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1198b;

    public g() {
        HashMap r5 = new HashMap();
        HashMap r10 = new HashMap();
        Intrinsics.checkNotNullParameter(r5, "methodModel");
        Intrinsics.checkNotNullParameter(r10, "stringModel");
        this.f1197a = r5;
        this.f1198b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r5;
        if (Intrinsics.areEqual(this.f1197a, r10.f1197a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1198b, r10.f1198b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f1197a.hashCode() * 31;
        return this.f1198b.hashCode() + r5;
    }

    public final String toString() {
        return "IDLAnnotationModel(methodModel=" + this.f1197a + ", stringModel=" + this.f1198b + ')';
    }
}
