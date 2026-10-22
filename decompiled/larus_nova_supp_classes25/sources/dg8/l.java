package dg8;

import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l extends xc8.b {
    public final Message e;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof l) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.e, ((l) r4).e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.e.hashCode();
    }

    public final String toString() {
        return "TextCellState(textMessage=" + this.e + ')';
    }

    @Override // xc8.b
    public final int d() {
        if (com.larus.bmhome.chat.bean.d.z0(this.a) == false) goto L7;
        return 0;
    L7:
        return com.larus.bmhome.chat.bean.d.H0(this.a) ? 1 : 0;
    }

    @Override // xc8.b
    public final ComponentCellStateType f() {
        return ComponentCellStateType.NEW_TEXT_CELL;
    }

    public l(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "textMessage");
        super(r2);
        this.e = r2;
    }
}
