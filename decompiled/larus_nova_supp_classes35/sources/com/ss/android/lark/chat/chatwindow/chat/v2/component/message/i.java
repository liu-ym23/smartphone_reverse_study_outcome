package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.messengesender.IMessageSenderComponent;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chatbase.BasePageStore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements IMessageListComponent.a {
    public final /* synthetic */ IMessageSenderComponent a;
    public final /* synthetic */ ChatWindowOpenViewModel b;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
    public final void A9() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
    public final void e(BasePageStore r2) {
        Intrinsics.checkNotNullParameter(r2, "store");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
    public final void w9(ThreadTopic r2) {
        Intrinsics.checkNotNullParameter(r2, "threadTopic");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
    public final /* synthetic */ void x9() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
    public final /* synthetic */ void y9() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
    public final void B9(ChatChatter r2) {
        Intrinsics.checkNotNullParameter(r2, "chatChatter");
        IMessageSenderComponent r0 = this.a;
        if (r0 == null) goto L5;
        r0.VK(r2);
    L5:
        ChatParamUtils.l(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
    public final void z9(Chat r3) {
        Intrinsics.checkNotNullParameter(r3, "chat");
        IMessageSenderComponent r1 = this.a;
        if (r1 == null) goto L5;
        r1.updateChat(r3);
    L5:
        ChatWindowOpenViewModel r2 = this.b;
        if (r2 == null) goto L10;
        MutableLiveData r4 = r2.getChat();
        if (r4 == null) goto L10;
        r4.postValue(r3);
    L10:
        String r5 = ChatParamUtils.a;
        Intrinsics.checkNotNullParameter(r3, "chat");
        if (Intrinsics.areEqual(ChatParamUtils.a, r3.getId()) == false) goto L15;
        ChatParamUtils.b = r3;
        return;
    }

    public i(IMessageSenderComponent r1, ChatWindowOpenViewModel r2) {
        this.a = r1;
        this.b = r2;
    }
}
