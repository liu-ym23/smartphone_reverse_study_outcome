package hg8;

import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g extends com.larus.bmhome.chat.list.cell.text.cells.base.a {
    public Message f;
    public final com.larus.bmhome.chat.list.cell.text.cells.base.c g;

    public static final class a {
    }

    static {
    }

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
        return "DeepThinkContentCellState(message=" + this.f + ", componentInfo=" + this.g + ')';
    }

    @Override // xc8.b
    public final int d() {
        com.larus.bmhome.chat.bean.d.z0(this.f);
        return 0;
    }

    @Override // xc8.b
    public final ComponentCellStateType f() {
        return ComponentCellStateType.DEEP_THINK_CONTENT_CELL;
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
    public final boolean b(wq8.a r9) {
        Intrinsics.checkNotNullParameter(r9, "newItem");
        if ((r9 instanceof g) == false) goto L56;
        Object r0 = this.g.f.get("pipe_line_node");
        List r4 = null;
        if ((r0 instanceof uvc.b) == false) goto L8;
        uvc.b r1 = (uvc.b) r0;
    L9:
        g r10 = (g) r9;
        Object r2 = r10.g.f.get("pipe_line_node");
        if ((r2 instanceof uvc.b) == false) goto L12;
        uvc.b r3 = (uvc.b) r2;
    L14:
        if (com.larus.bmhome.chat.bean.d.f0(r10.f) == false) goto L28;
        List r5 = com.larus.im.bean.message.a.S(this.f);
        if (r5 == null) goto L20;
        com.larus.im.bean.message.c r6 = (com.larus.im.bean.message.c) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L20;
        List r7 = r6.c();
    L21:
        List r11 = com.larus.im.bean.message.a.S(r10.f);
        if (r11 == null) goto L53;
        com.larus.im.bean.message.c r12 = (com.larus.im.bean.message.c) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L53;
        r4 = r12.c();
    L53:
        return Intrinsics.areEqual(r7, r4);
    L20:
        r7 = null;
        goto L21
    L28:
        if (com.larus.business.markdown.impl.widget.f.b(r1, r3) == false) goto L54;
        Message r8 = this.f;
        Message r13 = r10.f;
    L45:
        e = move-exception;
        FLogger.a.e("DeepThinkContentCellState", "messageSame e=" + e.getMessage());
        com.larus.platform.service.g.a.ensureNotReachHere(e);
    L47:
        boolean r14 = false;
    L48:
        if (r14 == false) goto L55;
        return true;
    L55:
        return false;
    L31:
        if (r8.getContentType() != r13.getContentType()) goto L47;
        if (r8.getMessageStatus() != r13.getMessageStatus()) goto L47;
        if (r8.getMessageStatusLocal() != r13.getMessageStatusLocal()) goto L47;
        if (r8.getLocalIndex() != r13.getLocalIndex()) goto L47;
        if (r8.getServerIndex() != r13.getServerIndex()) goto L47;
        if (Intrinsics.areEqual(r8.getSectionId(), r13.getSectionId()) == false) goto L47;
        if (Intrinsics.areEqual(r8.getSectionName(), r13.getSectionName()) == false) goto L47;
        r14 = true;
        goto L48
    L54:
        return false;
    L12:
        r3 = null;
        goto L14
    L8:
        r1 = null;
        goto L9
    L56:
        return false;
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
