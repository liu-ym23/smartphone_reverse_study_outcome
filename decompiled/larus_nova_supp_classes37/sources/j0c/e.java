package j0c;

import com.ss.android.lark.passportc.api.Scene;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final g a;
    public final Scene b;
    public final lzb.a c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Scene r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        lzb.a r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserContext(userPayload=" + this.a + ", scene=" + this.b + ", actionContext=" + this.c + ')';
    }

    public e(g r2, Scene r3, lzb.a r4) {
        Intrinsics.checkNotNullParameter(r2, "userPayload");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
