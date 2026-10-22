package com.larus.extension.summary_card.impl.cell;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z extends xc8.b {
    public final Message e;

    public final int d() {
        return 0;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof z) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.e, ((z) r4).e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.e.hashCode();
    }

    public final String toString() {
        return "SummaryCardCellState(msg=" + this.e + ')';
    }

    public z(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        super(r2);
        this.e = r2;
    }
}
