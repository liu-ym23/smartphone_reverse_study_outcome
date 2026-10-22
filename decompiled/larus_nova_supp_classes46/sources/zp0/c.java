package zp0;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final ShelfCardInfo a;
    public final int b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L10;
        c r4 = (c) r3;
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

    public final int hashCode() {
        ShelfCardInfo r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.b;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "EditSellingPointEvent(shelfCardInfo=" + this.a + ", position=" + this.b + ")";
    }

    public c(ShelfCardInfo r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
