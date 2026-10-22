package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.AddChatChattersResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j0 implements SdkSender.IParser<Chat> {
    public j0() {
    }

    public final Object parse(byte[] r3) throws IOException {
        AddChatChattersResponse r4 = (AddChatChattersResponse) AddChatChattersResponse.ADAPTER.decode(r3);
        Entity r0 = r4.entity;
        if (r0 == null) goto L6;
        return com.ss.android.lark.parser.internal.h.a((com.bytedance.lark.pb.basic.v1.Chat) r0.chats.get(r4.chat_id), r0.mail_setting);
    L6:
        return new Chat();
    }
}
