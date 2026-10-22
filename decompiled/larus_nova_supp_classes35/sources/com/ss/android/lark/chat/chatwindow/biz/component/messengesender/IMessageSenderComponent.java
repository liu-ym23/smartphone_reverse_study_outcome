package com.ss.android.lark.chat.chatwindow.biz.component.messengesender;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.scaffold.IComponent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\f\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/messengesender/IMessageSenderComponent;", "Lcom/ss/android/lark/scaffold/IComponent;", "getMessageSender", "Lcom/ss/android/lark/chat/chatwindow/keyboard/KeyboardMessageSender;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/model/IMessageSender;", "updateChat", BuildConfig.FLAVOR, "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "updateP2pChatter", "chatChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "addMessageSendResultCallback", "callback", "Lcom/ss/android/lark/chat/chatwindow/biz/component/messengesender/IMessageSenderComponent$IMessageSendResultCallback;", "removeMessageSendResultCallback", "IMessageSendResultCallback", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMessageSenderComponent extends IComponent {

    public interface a {
        void a();

        void b();

        void c();
    }

    void VK(ChatChatter r1);

    q4b.a getMessageSender();

    void updateChat(Chat r1);
}
