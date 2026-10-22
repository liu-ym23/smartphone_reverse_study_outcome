package g92;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public final com.bytedance.android.live.profit.privilege.model.danmu.b a;
    public final int b;
    public final String c;

    public c() {
        this(null, null, 7);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L12;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.live.profit.privilege.model.danmu.b r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        String r4 = this.c;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DanmakuTabMemory(tab=" + this.a + ", position=" + this.b + ", date=" + this.c + ")";
    }

    public c(com.bytedance.android.live.profit.privilege.model.danmu.b r2, String r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        int r0 = -1;
    L10:
        if ((r4 & 4) == 0) goto L12;
        r3 = BuildConfig.FLAVOR;
    L12:
        Intrinsics.checkNotNullParameter(r3, "date");
        this.a = r2;
        this.b = r0;
        this.c = r3;
        return;
    L8:
        r0 = 0;
        goto L10
    }
}
