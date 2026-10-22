package ns9;

import com.larus.reach.api.ReachPageScope;
import com.larus.reach.api.ReachPosition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a extends v {
    public final ReachPosition a;
    public final ReachPageScope b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.a == ((a) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "GlobalReachTarget(position=" + this.a + ')';
    }

    @Override // ns9.v
    public final ReachPageScope a() {
        return this.b;
    }

    @Override // ns9.v
    public final ReachPosition b() {
        return this.a;
    }

    public a(ReachPosition r2) {
        Intrinsics.checkNotNullParameter(r2, "position");
        this.a = r2;
        this.b = ReachPageScope.Global;
    }

    public /* synthetic */ a(int r1) {
        this(ReachPosition.TOP);
    }
}
