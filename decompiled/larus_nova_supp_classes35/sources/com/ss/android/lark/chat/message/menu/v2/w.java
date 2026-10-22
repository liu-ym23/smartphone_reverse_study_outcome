package com.ss.android.lark.chat.message.menu.v2;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class w implements com.ss.android.lark.chat.utils.u.b {
    public final /* synthetic */ MessageActionPanelManager<y6b.a<?>> a;

    @Override // com.ss.android.lark.chat.utils.u.b
    public final void a() {
        MessageActionPanel r0 = this.a.h;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.n() == false) goto L11;
        ViewGroup r1 = r0.K;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
        r1 = null;
    L10:
        r1.setVisibility(8);
        return;
    L11:
        MessageActionPanelManager<y6b.a<?>> r2 = this.a;
        if (r2.p == true) goto L20;
        r2.p = true;
        MessageActionPanelManager.g r3 = r2.t;
        int r6 = 0;
        Runnable[] r4 = {r2.s, r2.u};
    L14:
        if (r6 >= 2) goto L16;
        r2.d().c(r4[r6]);
        r6 = r6 + 1;
        goto L14
    L16:
        r2.d().a(r3);
        return;
    }

    public w(MessageActionPanelManager<y6b.a<?>> r1) {
        this.a = r1;
    }
}
