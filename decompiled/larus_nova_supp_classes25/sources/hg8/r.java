package hg8;

import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r extends com.larus.bmhome.chat.list.cell.text.cells.base.a {
    public final List<Reference> f;
    public Message g;
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c h;

    public r() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<Reference> r0 = this.f;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "DeepThinkReferenceCellState(searchReference=" + this.f + ", message=" + this.g + ", componentInfo=" + this.h + ')';
    }

    @Override // xc8.b
    public final int d() {
        com.larus.bmhome.chat.bean.d.z0(this.g);
        return 0;
    }

    @Override // xc8.b
    public final ComponentCellStateType f() {
        return ComponentCellStateType.DEEP_THINK_REFERENCE_CELL;
    }

    @Override // xc8.b
    public final Message getMessage() {
        return this.g;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.cells.base.a
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c i() {
        return this.h;
    }

    @Override // xc8.b
    public final boolean b(wq8.a r4) {
        Intrinsics.checkNotNullParameter(r4, "newItem");
        Integer r1 = null;
        if ((r4 instanceof r) == false) goto L5;
        r r5 = (r) r4;
    L6:
        if (r5 != null) goto L9;
    L20:
        return false;
    L9:
        if (Intrinsics.areEqual(this.g.getMessageId(), r5.g.getMessageId()) == false) goto L20;
        List<Reference> r0 = this.f;
        if (r0 == null) goto L13;
        Integer r2 = Integer.valueOf(r0.size());
    L14:
        List<Reference> r6 = r5.f;
        if (r6 == null) goto L18;
        r1 = Integer.valueOf(r6.size());
    L18:
        if (Intrinsics.areEqual(r2, r1) == false) goto L20;
        return true;
    L13:
        r2 = null;
        goto L14
    L5:
        r5 = null;
        goto L6
    }

    @Override // xc8.b
    public final void h(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public r(Message r2, com.larus.bmhome.chat.list.cell.text.cells.base.c r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "componentInfo");
        super(r2);
        this.f = null;
        this.g = r2;
        this.h = r3;
    }
}
