package o1;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f20388a;

    public d() {
        HashMap r5 = new HashMap();
        Intrinsics.checkNotNullParameter(r5, "methodModel");
        this.f20388a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f20388a, ((d) r5).f20388a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f20388a.hashCode();
    }

    public final String toString() {
        return "AnnotationModel(methodModel=" + this.f20388a + ')';
    }
}
