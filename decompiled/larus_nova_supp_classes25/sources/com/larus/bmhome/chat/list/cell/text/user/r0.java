package com.larus.bmhome.chat.list.cell.text.user;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r0 extends xc8.b {
    public final Message e;

    @Override // xc8.b
    public final int d() {
        return 1;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof r0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.e, ((r0) r4).e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.e.hashCode();
    }

    public final String toString() {
        return "UserTextCellState(textMessage=" + this.e + ')';
    }

    public r0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "textMessage");
        super(r2);
        this.e = r2;
    }
}
