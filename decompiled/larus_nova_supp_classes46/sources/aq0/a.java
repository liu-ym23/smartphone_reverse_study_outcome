package aq0;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final ShelfCardInfo a;
    public final boolean b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        ShelfCardInfo r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.b;
        ?? r4 = r3;
        if (r3 == false) goto L10;
        r4 = 1;
    L10:
        return r2 + r4;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "ShelfManagementCardInfo(shelfCardInfo=" + this.a + ", isSelected=" + this.b + ")";
    }

    public a(ShelfCardInfo r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "shelfCardInfo");
        this.a = r2;
        this.b = r3;
    }

    public static a a(a r1, boolean r2) {
        ShelfCardInfo r0 = r1.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "shelfCardInfo");
        return new a(r0, r2);
    }
}
