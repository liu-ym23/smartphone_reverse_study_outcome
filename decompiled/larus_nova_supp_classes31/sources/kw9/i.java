package kw9;

import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public final FragmentActivity a;
    public final List<jr9.a> b;
    public final com.larus.bmhome.share.panel.b c;
    public final j d;

    public i() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        List<jr9.a> r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        com.larus.bmhome.share.panel.b r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + this.d.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "SlideShareContext(fragmentActivity=" + this.a + ", shareItems=" + this.b + ", shareContent=" + this.c + ", shareParams=" + this.d + ')';
    }

    public i(FragmentActivity r2, com.larus.bmhome.share.panel.b r3, j r4) {
        Intrinsics.checkNotNullParameter(r2, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r4, "shareParams");
        this.a = r2;
        this.b = null;
        this.c = r3;
        this.d = r4;
    }
}
