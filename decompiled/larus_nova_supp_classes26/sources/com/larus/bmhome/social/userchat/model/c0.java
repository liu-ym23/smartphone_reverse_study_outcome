package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.chat.component.list.ChatListComponentViewModel;
import com.larus.im.bean.message.Message;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface c0 {
    void E4(Message r1);

    boolean O7(String r1);

    boolean a();

    void b(vr8.b r1, Integer r2);

    void c();

    void clear();

    void d(vr8.b r1);

    void e(ChatListComponentViewModel.ChatListMessageChangeListener r1, ChatMessageReceiverModel.d r2, long r3, CoroutineScope r5);
}
