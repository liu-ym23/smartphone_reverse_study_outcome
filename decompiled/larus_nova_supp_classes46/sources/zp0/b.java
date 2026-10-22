package zp0;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final int a;
    public final ShelfCardInfo b;
    public final int c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        ShelfCardInfo r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((r0 + r2) * 31) + this.c;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "EditCardEvent(type=" + this.a + ", shelfCardInfo=" + this.b + ", position=" + this.c + ")";
    }

    public final int getType() {
        return this.a;
    }

    public b(int r1, ShelfCardInfo r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
