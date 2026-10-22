package fg8;

import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f extends com.larus.bmhome.chat.list.cell.text.cells.base.a {
    public Message f;
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f.hashCode() * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "MiddleTextCellState(message=" + this.f + ", componentInfo=" + this.g + ')';
    }

    @Override // xc8.b
    public final int d() {
        com.larus.bmhome.chat.bean.d.z0(this.f);
        return 0;
    }

    @Override // xc8.b
    public final ComponentCellStateType f() {
        return ComponentCellStateType.MIDDLE_TEXT_CELL;
    }

    @Override // xc8.b
    public final Message getMessage() {
        return this.f;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.cells.base.a
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c i() {
        return this.g;
    }

    @Override // xc8.b
    public final boolean b(wq8.a r5) {
        Intrinsics.checkNotNullParameter(r5, "newItem");
        if (com.larus.im.bean.message.a.f0(r5.getMessage()) == false) goto L20;
        boolean r1 = false;
        if ((r5 instanceof f) == false) goto L22;
        f r0 = (f) r5;
        if (com.larus.bmhome.chat.bean.d.f0(r0.f) == true) goto L17;
        String r2 = com.larus.im.bean.message.a.K(r0.f);
        if (r2 != null) goto L12;
    L13:
        r1 = true;
    L14:
        if (r1 == true) goto L17;
        return super.b(r5);
    L12:
        if (r2.length() != 0) goto L14;
    L17:
        return true;
    L22:
        return false;
    L20:
        return super.b(r5);
    }

    @Override // xc8.b
    public final void h(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public f(Message r2, com.larus.bmhome.chat.list.cell.text.cells.base.c r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "componentInfo");
        super(r2);
        this.f = r2;
        this.g = r3;
    }
}
