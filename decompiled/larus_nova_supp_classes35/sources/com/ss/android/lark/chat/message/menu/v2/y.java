package com.ss.android.lark.chat.message.menu.v2;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class y implements d {
    public final /* synthetic */ MessageActionPanelManager<y6b.a<?>> a;
    public final /* synthetic */ yya.n b;

    @Override // com.ss.android.lark.chat.message.menu.v2.d
    public final void b(j0 r2) {
        Intrinsics.checkNotNullParameter(r2, "panelControl");
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.d
    public final View a() {
        MessageActionPanelManager<y6b.a<?>> r0 = this.a;
        RecyclerView r1 = r0.c;
        if (r1 != null) goto L7;
        Object r2 = r0.b;
        yya.n r3 = this.b;
        ((s2b.c) r2).getClass();
        return r3.o0();
    L7:
        return r1;
    }

    public y(MessageActionPanelManager r1, com.ss.android.lark.chat.message.menu.context.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
