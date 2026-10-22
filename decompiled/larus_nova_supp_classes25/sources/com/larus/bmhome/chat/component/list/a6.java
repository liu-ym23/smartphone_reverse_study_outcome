package com.larus.bmhome.chat.component.list;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wi8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a6 implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
    public final /* synthetic */ ChatListComponent a;

    public a6(ChatListComponent r1) {
        this.a = r1;
    }

    public final void c(Object r4) {
        wc9.e r5 = (wc9.e) r4;
        Intrinsics.checkNotNullParameter(r5, "new");
        ChatListComponent r0 = this.a;
        String r1 = r5.a;
        int r2 = ChatListComponent.W3;
        if (r0.V6(r1) == false) goto L5;
    L10:
        com.larus.bmhome.chat.component.cvs.y r6 = this.a.u0();
        if (r6 == null) goto L14;
        r6.lQ(this);
        return;
    L14:
        return;
    L5:
        if (Intrinsics.areEqual(r5.l, r5.m) == true) goto L10;
        ChatListComponent r3 = this.a;
        r3.M3 = d.a().b();
        ChatListComponent r7 = this.a;
        List r8 = r7.getCurrentList();
        if (r8 != null) goto L9;
        r8 = CollectionsKt.emptyList();
    L9:
        r7.V3(r8, r5.a);
        goto L10
    }
}
