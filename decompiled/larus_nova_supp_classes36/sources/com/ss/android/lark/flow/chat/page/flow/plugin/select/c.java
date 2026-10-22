package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chatbase.BasePageStore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements IMessageListComponent.a {
    public final /* synthetic */ FlowMessageSelectPlugin a;

    public final /* synthetic */ void A9() {
    }

    public final void B9(ChatChatter r2) {
        Intrinsics.checkNotNullParameter(r2, "chatChatter");
    }

    public final void e(BasePageStore r2) {
        Intrinsics.checkNotNullParameter(r2, "store");
    }

    public final void w9(ThreadTopic r2) {
        Intrinsics.checkNotNullParameter(r2, "threadTopic");
    }

    public final /* synthetic */ void x9() {
    }

    public final /* synthetic */ void y9() {
    }

    public c(FlowMessageSelectPlugin r1) {
        this.a = r1;
    }

    public final void z9(Chat r3) {
        Intrinsics.checkNotNullParameter(r3, "chat");
        FlowMessageSelectPlugin r0 = this.a;
        int r1 = FlowMessageSelectPlugin.f0;
        r0.U(r3);
    }
}
