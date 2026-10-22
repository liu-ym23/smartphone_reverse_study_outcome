package dq8;

import cq8.z;
import cq8.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final String a;
    public final com.larus.bmhome.actionbar.model.a b;
    public final String c;
    public final z0 d;
    public final z e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ButtonRouterClickHostEvent(widgetId=" + this.a + ", template=" + this.b + ", selectedId=" + this.c + ", trackingContext=" + this.d + ", actionChannel=" + this.e + ')';
    }

    public a(String r2, com.larus.bmhome.actionbar.model.a r3, String r4, z0 r5, com.larus.bmhome.instruction.core.impl.base.b.C0015b r6) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        Intrinsics.checkNotNullParameter(r3, "template");
        Intrinsics.checkNotNullParameter(r5, "trackingContext");
        Intrinsics.checkNotNullParameter(r6, "actionChannel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
