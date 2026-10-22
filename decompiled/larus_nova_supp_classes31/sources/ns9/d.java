package ns9;

import com.larus.reach.api.ReachButtonStyle;
import com.larus.reach.api.ReachButtonType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final ReachButtonType a;
    public final ReachButtonStyle b;
    public final String c;
    public final List<b> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        ReachButtonStyle r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + this.d.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReachButton(type=" + this.a + ", style=" + this.b + ", title=" + this.c + ", actions=" + this.d + ')';
    }

    public final ReachButtonType getType() {
        return this.a;
    }

    public d(ReachButtonType r2, ReachButtonStyle r3, String r4, List<b> r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r5, "actions");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
