package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public final int a;
    public final List<c> b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L10;
        d r4 = (d) r3;
        if (this.a == r4.a) goto L8;
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
        int r0 = this.a * 31;
        List<c> r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "TradeUnitList(type=" + this.a + ", list=" + this.b + ")";
    }

    public final int getType() {
        return this.a;
    }

    public d(int r2, List<c> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        this.a = r2;
        this.b = r3;
    }
}
