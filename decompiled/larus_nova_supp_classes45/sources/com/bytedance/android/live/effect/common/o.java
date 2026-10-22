package com.bytedance.android.live.effect.common;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o {
    public final f a;
    public final RecyclerView.ItemDecoration b;

    public o() {
        this(null, 3);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof o) == false) goto L10;
        o r4 = (o) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        f r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        RecyclerView.ItemDecoration r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveCommonStickerListStyleConfig(itemViewProvider=" + this.a + ", decor=" + this.b + ")";
    }

    public o(j r2, int r3) {
        f r4 = r2;
        if ((r3 & 1) == 0) goto L6;
        r4 = new e();
    L6:
        if ((r3 & 2) == 0) goto L8;
        DefaultLiveCommonStickerListItemDecoration r5 = new DefaultLiveCommonStickerListItemDecoration();
    L9:
        Intrinsics.checkNotNullParameter(r4, "itemViewProvider");
        this.a = r4;
        this.b = r5;
        return;
    L8:
        r5 = null;
        goto L9
    }
}
