package u42;

import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public final long a;
    public final View b;
    public final DataCenter c;
    public final g52.e d;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L14;
        e r7 = (e) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        View r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        DataCenter r6 = this.c;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        g52.e r9 = this.d;
        if (r9 == null) goto L14;
        r3 = r9.hashCode();
    L14:
        return r8 + r3;
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "PinContext(duration=" + this.a + ", view=" + this.b + ", dataCenter=" + this.c + ", textConfig=" + this.d + ")";
    }

    public e(long r2, View r4, DataCenter r5, g52.e r6) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
