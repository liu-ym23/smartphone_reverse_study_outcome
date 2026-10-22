package ia2;

import com.bytedance.android.livesdkapi.depend.model.live.Ability;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final Ability a;
    public boolean b;
    public boolean c;
    public boolean d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L14;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        Ability r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.b;
        ?? r4 = 1;
        ?? r5 = r3;
        if (r3 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r2 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = r7;
        if (r7 == false) goto L12;
        r8 = 1;
    L12:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.d;
        if (r10 == true) goto L17;
        r4 = r10;
    L17:
        return r9 + r4;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "ItemData(ability=" + this.a + ", isLoading=" + this.b + ", shouldReportShowLog=" + this.c + ", isLocateBottom=" + this.d + ")";
    }

    public b(Ability r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
        this.b = false;
        this.c = true;
        this.d = r3;
    }
}
