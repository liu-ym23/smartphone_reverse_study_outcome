package d11;

import com.bytedance.android.live.revenuelink.connect.params.TimeOutType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r {
    public final String a;
    public final TimeOutType b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r) == false) goto L10;
        r r4 = (r) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        TimeOutType r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TimeOutParams(toUserId=" + this.a + ", timeOutType=" + this.b + ")";
    }

    public r(String r2, TimeOutType r3) {
        Intrinsics.checkNotNullParameter(r3, "timeOutType");
        this.a = r2;
        this.b = r3;
    }
}
