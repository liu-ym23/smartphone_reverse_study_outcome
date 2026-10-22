package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.MGetChatsResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n0 implements SdkSender.IParser<com.ss.android.lark.chat.entity.chat.a> {
    public final /* synthetic */ String a;

    public n0(String r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r3) throws IOException {
        return ChatService.j(this.a, (MGetChatsResponse) MGetChatsResponse.ADAPTER.decode(r3));
    }
}
