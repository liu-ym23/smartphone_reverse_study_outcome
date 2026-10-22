package com.ss.android.lark.flow.replyinthread.pages.private_description;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements IMessageListComponent.a {
    public final /* synthetic */ a a;

    public final /* synthetic */ void A9() {
    }

    public final void B9(ChatChatter r2) {
        Intrinsics.checkNotNullParameter(r2, "chatChatter");
    }

    public final void w9(ThreadTopic r2) {
        Intrinsics.checkNotNullParameter(r2, "threadTopic");
    }

    public final /* synthetic */ void x9() {
    }

    public final /* synthetic */ void y9() {
    }

    public final void z9(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "chat");
    }

    public b(a r1) {
        this.a = r1;
    }

    public final void e(BasePageStore<MessageInfo, ? extends x4b.a<MessageInfo>> r3) {
        Intrinsics.checkNotNullParameter(r3, "store");
        a r0 = this.a;
        r0.d = r3;
        if (r0.g == true) goto L6;
        r0.c.la(r0.f);
        r0.g = true;
        return;
    }
}
