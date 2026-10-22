package lc;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19597a;

    public a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "containerID");
        Intrinsics.checkNotNullParameter("1.0", "protocolVersion");
        this.f19597a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f19597a, ((a) r5).f19597a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual("1.0", "1.0") == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f19597a.hashCode() * 31) + 48563;
    }

    public final String toString() {
        return j0.q(new StringBuilder("LynxCommonData(containerID="), this.f19597a, ", protocolVersion=1.0)");
    }
}
