package eg8;

import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g extends com.larus.bmhome.chat.list.cell.text.cells.base.a {
    public Message f;
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
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
        return "BottomTextCellState(message=" + this.f + ", componentInfo=" + this.g + ')';
    }

    @Override // xc8.b
    public final int d() {
        com.larus.bmhome.chat.bean.d.z0(this.f);
        return 0;
    }

    @Override // xc8.b
    public final ComponentCellStateType f() {
        return ComponentCellStateType.BOTTOM_TEXT_CELL;
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
        if (com.larus.im.bean.message.a.f0(r5.getMessage()) == false) goto L22;
        boolean r1 = false;
        if ((r5 instanceof g) == false) goto L24;
        g r0 = (g) r5;
        if (com.larus.bmhome.chat.bean.d.f0(r0.f) == false) goto L10;
    L19:
        return true;
    L10:
        if (com.larus.bmhome.chat.bean.d.Q0(r0.f) == true) goto L19;
        String r2 = com.larus.im.bean.message.a.K(r0.f);
        if (r2 != null) goto L14;
    L15:
        r1 = true;
    L16:
        if (r1 == true) goto L19;
        return super.b(r5);
    L14:
        if (r2.length() != 0) goto L16;
    L24:
        return false;
    L22:
        return super.b(r5);
    }

    @Override // com.larus.bmhome.chat.list.cell.text.cells.base.a, xc8.b
    public final boolean c(wq8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "newItem");
        return super.c(r2);
    }

    @Override // xc8.b
    public final void h(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public g(Message r2, com.larus.bmhome.chat.list.cell.text.cells.base.c r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "componentInfo");
        super(r2);
        this.f = r2;
        this.g = r3;
    }
}
