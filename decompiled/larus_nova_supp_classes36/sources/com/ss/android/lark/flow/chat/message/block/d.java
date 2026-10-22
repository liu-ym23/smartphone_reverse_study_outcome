package com.ss.android.lark.flow.chat.message.block;

import com.ss.android.lark.biz.officesdk.im.message.reaction.DoubaoMessageFeedbackSource;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import h7b.m;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements ReactionFlowLayout.f {
    public final /* synthetic */ FlowReactionBlock a;
    public final /* synthetic */ y6b.c<?> b;
    public final /* synthetic */ Ref.ObjectRef<String> c;

    public d(FlowReactionBlock r1, y6b.c<?> r2, Ref.ObjectRef<String> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        v4b.c r0 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.a).f;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L11:
        if ((!r1) == false) goto L26;
        boolean r2 = m.a(this.b.u, r5, (String) this.c.element);
        FlowReactionBlock r3 = this.a;
        y6b.c<?> r4 = this.b;
        if (r2 == false) goto L15;
        String r6 = "remove";
    L16:
        FlowReactionBlock.h(r3, r4, r5, r6);
        List r7 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.a).c.j5().c(mya.d.class);
        if ((true ^ r7.isEmpty()) == false) goto L22;
        Iterator r8 = r7.iterator();
    L20:
        if (r8.hasNext() == false) goto L23;
        ((mya.d) r8.next()).d(this.b.c, r5, 5);
    L23:
        int r9 = hgb.a.a;
        hgb.a.a(this.b, r5, DoubaoMessageFeedbackSource.CELL);
        return;
    L22:
        this.a.i.a(this.b.c, r5, 5);
        goto L23
    L15:
        r6 = "add";
        goto L16
    L26:
        return;
    L7:
        if (r0.h != true) goto L9;
        r1 = true;
        goto L11
    }
}
