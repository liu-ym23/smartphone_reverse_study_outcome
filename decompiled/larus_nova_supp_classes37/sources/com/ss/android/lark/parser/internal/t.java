package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageLink;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class t {
    static {
    }

    public static MessageLink a(com.bytedance.lark.pb.basic.v1.MessageLink r13) {
        Chat.Type r0 = null;
        if (r13 != null) goto L5;
        return null;
    L5:
        boolean r2 = false;
        HashMap r1 = new HashMap(0);
        ArrayList r3 = new ArrayList();
        Iterator r4 = r13.entity_ids.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r3.add((Long) r4.next());
        goto L7
    L9:
        com.bytedance.lark.pb.basic.v1.MessageLink.MetaInfo r5 = r13.meta_info;
        if (r5 == null) goto L14;
        Long r6 = r5.from_chat_id;
        if (r6 == null) goto L14;
        String r9 = r6.toString();
    L15:
        if (r9 == null) goto L19;
        Map r7 = r13.chats;
        if (r7 == null) goto L19;
        com.bytedance.lark.pb.basic.v1.Chat r8 = (com.bytedance.lark.pb.basic.v1.Chat) r7.get(r9);
    L20:
        String r12 = r13.token;
        com.bytedance.lark.pb.basic.v1.MessageLink.ChatInfo r14 = r13.chat_info;
        if (r14 != null) goto L33;
        com.bytedance.lark.pb.basic.v1.MessageLink.ChatInfo.Builder r15 = new com.bytedance.lark.pb.basic.v1.MessageLink.ChatInfo.Builder().name("");
        if (r8 == null) goto L26;
        com.bytedance.lark.pb.basic.v1.Chat.Type r10 = r8.type;
        if (r10 == null) goto L26;
    L27:
        com.bytedance.lark.pb.basic.v1.MessageLink.ChatInfo.Builder r16 = r15.type(r10);
        if (r8 == null) goto L32;
        Boolean r11 = r8.is_p2p_official_bot_ai;
        if (r11 == null) goto L32;
        r2 = r11.booleanValue();
    L32:
        r14 = r16.is_p2p_bot(Boolean.valueOf(r2)).is_auth(Boolean.FALSE).build();
    L26:
        r10 = com.bytedance.lark.pb.basic.v1.Chat.DEFAULT_TYPE;
    L33:
        com.bytedance.lark.pb.basic.v1.Chat.Type r17 = r14.type;
        if (r17 == null) goto L37;
        r0 = Chat.Type.valueOf(r17.getValue());
    L37:
        return new MessageLink(r12, r3, r1, new MessageLink.ChatInfo(r14.name, r0, r14.is_p2p_bot.booleanValue(), r9, r14.is_auth.booleanValue()));
    L19:
        r8 = null;
    L14:
        r9 = null;
        goto L15
    }
}
