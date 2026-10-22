package yv0;

import com.bytedance.android.live.recharge.model.d;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final d a;
    public final long b;
    public final List<Long> c;
    public final boolean d;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L14;
        b r7 = (b) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        d r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        List<Long> r5 = this.c;
        if (r5 == null) goto L9;
        r1 = r5.hashCode();
    L9:
        int r6 = (r4 + r1) * 31;
        boolean r7 = this.d;
        ?? r8 = r7;
        if (r7 == false) goto L13;
        r8 = 1;
    L13:
        return r6 + r8;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RechargePreOrderData(entranceParams=" + this.a + ", balance=" + this.b + ", diamondList=" + this.c + ", isCachedDiamondList=" + this.d + ")";
    }

    public b(d r2, long r3, List<Long> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "entranceParams");
        Intrinsics.checkNotNullParameter(r5, "diamondList");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
    }
}
