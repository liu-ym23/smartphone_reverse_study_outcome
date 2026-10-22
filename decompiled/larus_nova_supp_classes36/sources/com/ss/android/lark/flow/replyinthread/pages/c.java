package com.ss.android.lark.flow.replyinthread.pages;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements com.ss.android.lark.replyinthread.pages.e.a {
    public final /* synthetic */ FlowReplyInThreadFragment a;

    public final void a() {
    }

    public c(FlowReplyInThreadFragment r1) {
        this.a = r1;
    }

    public final Message b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        FlowBaseReplyInThreadViewModel r0 = this.a.r;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        if (Intrinsics.areEqual(r3, r0.getThreadId()) == false) goto L10;
        CoreMessageListComponent r4 = this.a.j;
        if (r4 == null) goto L17;
        MessageInfo r5 = r4.getTopicMessageInfo();
    L18:
        if (r5 != null) goto L20;
        return null;
    L20:
        return r5.getMessage();
    L17:
        r5 = null;
        goto L18
    L10:
        CoreMessageListComponent r1 = this.a.j;
        if (r1 == null) goto L13;
        r5 = r1.y90(r3);
    L15:
        if ((r5 instanceof MessageInfo) == false) goto L17;
    L13:
        r5 = null;
        goto L15
    }
}
