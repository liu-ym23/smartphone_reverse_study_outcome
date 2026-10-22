package com.larus.bmhome.chat.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a1 implements com.larus.im.service.d0<wc9.e> {
    public a1() {
    }

    public final void c(Object r2) {
        Intrinsics.checkNotNullParameter((wc9.e) r2, "conversation");
    }

    public final void a(wc9.e r2, wc9.e r3) {
        Intrinsics.checkNotNullParameter(r3, "new");
        ConversationListModel r4 = ConversationListModel.a;
        if (r2 == null) goto L5;
        String r5 = r2.a;
    L6:
        r4.getClass();
        ConversationListModel.o(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
