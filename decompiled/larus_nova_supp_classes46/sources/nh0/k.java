package nh0;

import com.bytedance.android.live.base.model.user.User;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k {
    public final int a;
    public final int b;
    public final String c;
    public final User d;
    public final boolean e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k) == false) goto L16;
        k r4 = (k) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        User r5 = this.d;
        if (r5 == null) goto L9;
        r2 = r5.hashCode();
    L9:
        int r6 = (r4 + r2) * 31;
        boolean r7 = this.e;
        ?? r8 = r7;
        if (r7 == false) goto L13;
        r8 = 1;
    L13:
        return r6 + r8;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "SeatClickExtraObject:{seatIndex=" + this.a + ", clickType=" + this.b + '}';
    }

    public k(int r2, int r3, String r4, User r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "thxToUserId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
