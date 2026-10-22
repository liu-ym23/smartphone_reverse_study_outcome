package com.ss.android.lark.chat.message.menu.v2;

import com.ss.android.lark.movable.MovableView;
import com.ss.android.lark.movable.selection.MovableSelectionManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class x implements o0 {
    public final /* synthetic */ g a;
    public final /* synthetic */ MessageActionPanelManager<y6b.a<?>> b;
    public final /* synthetic */ y6b.a<?> c;
    public final /* synthetic */ yya.n d;

    @Override // com.ss.android.lark.chat.message.menu.v2.o0
    public final void a(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "reactionKey");
        this.a.a();
        Object r0 = this.b.b;
        s2b.c r1 = (s2b.c) r0;
        r1.b(this.c, r3, r4);
        MovableView r5 = com.ss.android.lark.chat.message.menu.a.a(this.d.a());
        if (r5 == null) goto L8;
        MovableSelectionManager r6 = r5.getRootMovableView().n;
        if (r6 == null) goto L9;
        r6.d();
        return;
    L9:
        return;
    }

    public x(u r1, MessageActionPanelManager r2, y6b.a r3, com.ss.android.lark.chat.message.menu.context.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
