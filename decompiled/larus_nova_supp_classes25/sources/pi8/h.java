package pi8;

import android.view.View;
import com.larus.bmhome.chat.search.MoreInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h extends k {
    public final MoreInfo a;
    public final int b;
    public final View c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "MoreHolderCallbackData(itemData=" + this.a + ", position=" + this.b + ", itemView=" + this.c + ')';
    }

    public h(MoreInfo r2, int r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
