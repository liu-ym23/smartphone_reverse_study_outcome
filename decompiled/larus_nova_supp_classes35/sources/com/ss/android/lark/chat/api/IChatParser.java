package com.ss.android.lark.chat.api;

import com.bytedance.lark.pb.basic.v1.ChatMailSetting;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IChatParser {
    Chat getChat(com.bytedance.lark.pb.basic.v1.Chat r1);

    Chat getChat(com.bytedance.lark.pb.basic.v1.Chat r1, Map<String, ChatMailSetting> r2);

    List<Chat> getChatList(List<com.bytedance.lark.pb.basic.v1.Chat> r1);

    Map<String, Chat> getChatMap(Map<String, com.bytedance.lark.pb.basic.v1.Chat> r1);

    Chatter getChatter(com.bytedance.lark.pb.basic.v1.Chatter r1);

    Map<String, Chatter> parseChatterMapFromEntity(Entity r1);
}
