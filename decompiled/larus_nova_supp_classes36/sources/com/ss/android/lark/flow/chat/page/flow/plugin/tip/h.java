package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements IMessageListComponent.g {
    public final /* synthetic */ FlowMessageTipsPlugin a;

    public h(FlowMessageTipsPlugin r1) {
        this.a = r1;
    }

    public final void a(ListMode r3) {
        Intrinsics.checkNotNullParameter(r3, "mode");
        if (r3 != ListMode.MULTI_SELECT) goto L7;
        wgb.b<y6b.c<?>> r4 = this.a.j;
        if (r4 == null) goto L11;
        r4.f(true);
        return;
    L11:
        return;
    L7:
        wgb.b<y6b.c<?>> r5 = this.a.j;
        if (r5 == null) goto L13;
        r5.n(true);
        return;
    }
}
