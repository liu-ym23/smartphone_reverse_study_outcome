package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.contact.v1.MGetChattersResponse;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p0 implements SdkSender.IParser<Map<String, Chatter>> {
    public p0() {
    }

    public final Object parse(byte[] r2) throws IOException {
        return new HashMap(com.ss.android.lark.parser.internal.j.b(((MGetChattersResponse) MGetChattersResponse.ADAPTER.decode(r2)).entity, null).a);
    }
}
