package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface z {
    void a(Chat r1, Map<String, ChatChatter> r2);

    void onPushChatRemoveMe(Chat r1);
}
