package i11;

import com.bytedance.android.livesdk.link.model.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final r a;
    public final boolean b;
    public final long c;

    public f() {
        this(null, false, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof f) == false) goto L12;
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r6.b) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final int hashCode() {
        r r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.b;
        ?? r4 = r3;
        if (r3 == false) goto L9;
        r4 = 1;
    L9:
        int r5 = (r2 + r4) * 31;
        long r6 = this.c;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "PreloadLinkListData(data=" + this.a + ", isRequesting=" + this.b + ", timestamp=" + this.c + ")";
    }

    public f(r r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        i97.a r6 = i97.a.a;
        long r0 = System.currentTimeMillis();
    L12:
        this.a = r3;
        this.b = r4;
        this.c = r0;
        return;
    L11:
        r0 = 0;
        goto L12
    }
}
