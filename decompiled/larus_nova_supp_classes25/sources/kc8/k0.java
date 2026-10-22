package kc8;

import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k0 {
    public final ExpandCardViewMode a;
    public final z b;
    public final z c;
    public final j0 d;

    public k0() {
        this(null, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r6 = (k0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        z r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        z r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        j0 r8 = this.d;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PureVideoConfig(msgExpandMode=" + this.a + ", viewLongClickHandler=" + this.b + ", videoCoverLongClickHandler=" + this.c + ", columnGridDecorationConfig=" + this.d + ')';
    }

    public /* synthetic */ k0(ExpandCardViewMode r1, int r2) {
        if ((r2 & 1) == 0) goto L5;
        r1 = ExpandCardViewMode.NORMAL;
    L5:
        this(r1, null, null, null);
    }

    public k0(ExpandCardViewMode r2, z r3, z r4, j0 r5) {
        Intrinsics.checkNotNullParameter(r2, "msgExpandMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
