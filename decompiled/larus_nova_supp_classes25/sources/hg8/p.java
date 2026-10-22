package hg8;

import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p extends com.larus.bmhome.chat.list.cell.text.cells.base.a {
    public final boolean f;
    public final int g;
    public final boolean h;
    public final boolean i;
    public Message j;
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (this.f == r6.f) goto L12;
        return false;
    L12:
        if (this.g == r6.g) goto L15;
        return false;
    L15:
        if (this.h == r6.h) goto L18;
        return false;
    L18:
        if (this.i == r6.i) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.f == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.g) * 31;
        if (this.h == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.i == true) goto L15;
        r1 = 1237;
    L15:
        return ((((r4 + r1) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepThinkHeaderTitleCellState(serverLoading=" + this.f + ", referenceSize=" + this.g + ", hideTopSearchReference=" + this.h + ", isDeepThinkingTyping=" + this.i + ", message=" + this.j + ", componentInfo=" + this.k + ')';
    }

    @Override // xc8.b
    public final int d() {
        com.larus.bmhome.chat.bean.d.z0(this.j);
        return 0;
    }

    @Override // xc8.b
    public final ComponentCellStateType f() {
        return ComponentCellStateType.DEEP_THINK_HEADER_TITLE_CELL;
    }

    @Override // xc8.b
    public final Message getMessage() {
        return this.j;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.cells.base.a
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c i() {
        return this.k;
    }

    @Override // xc8.b
    public final boolean b(wq8.a r5) {
        Intrinsics.checkNotNullParameter(r5, "newState");
        if ((r5 instanceof p) == true) goto L5;
        return false;
    L5:
        p r6 = (p) r5;
    L15:
        e = move-exception;
        FLogger.a.e("DeepThinkContentCellState", "messageSame e=" + e.getMessage());
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        return false;
    L7:
        if (this.i == r6.i) goto L9;
        return false;
    L9:
        if (this.f == r6.f) goto L11;
        return false;
    L11:
        if (this.h != r6.h) goto L22;
        if (this.g != r6.g) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    }

    @Override // xc8.b
    public final void h(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.j = r2;
    }

    public p(boolean r2, int r3, boolean r4, boolean r5, Message r6, com.larus.bmhome.chat.list.cell.text.cells.base.c r7) {
        Intrinsics.checkNotNullParameter(r6, "message");
        Intrinsics.checkNotNullParameter(r7, "componentInfo");
        super(r6);
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.k = r7;
    }
}
