package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g0 implements ReactionFlowLayout.f {
    public final /* synthetic */ ReactionBlock a;
    public final /* synthetic */ y6b.c<?> b;
    public final /* synthetic */ String c;

    public g0(ReactionBlock r1, y6b.c<?> r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        v4b.c r0 = this.a.f;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L11:
        if ((!r1) == false) goto L25;
        boolean r2 = h7b.m.a(this.b.u, r5, this.c);
        ReactionBlock r3 = this.a;
        y6b.c<?> r4 = this.b;
        if (r2 == false) goto L15;
        String r6 = "remove";
    L16:
        ReactionBlock.h(r3, r4, r5, r6);
        List r7 = this.a.c.j5().c(mya.d.class);
        if ((true ^ r7.isEmpty()) == false) goto L22;
        Iterator r8 = r7.iterator();
    L20:
        if (r8.hasNext() == false) goto L26;
        ((mya.d) r8.next()).d(this.b.c, r5, 5);
        goto L20
    L26:
        return;
    L22:
        this.a.i.a(this.b.c, r5, 5);
        return;
    L15:
        r6 = "add";
        goto L16
    L25:
        return;
    L7:
        if (r0.h != true) goto L9;
        r1 = true;
        goto L11
    }
}
