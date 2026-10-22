package g3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f17025a;

    public b(List r5) {
        Intrinsics.checkNotNullParameter(r5, "uiOperations");
        this.f17025a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f17025a, ((b) r5).f17025a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f17025a.hashCode();
    }

    public final String toString() {
        return androidx.constraintlayout.motion.widget.a.v(new StringBuilder("UIOperationsWrapper(uiOperations="), this.f17025a, ')');
    }
}
