package com.ss.android.lark.contact.base.service;

import com.bytedance.lark.pb.im.v1.GetMyGroupChatsResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class x implements SdkSender.IParser<com.ss.android.lark.contact.base.dto.a> {
    public final /* synthetic */ y a;

    public x(y r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r4) throws IOException {
        GetMyGroupChatsResponse r5 = (GetMyGroupChatsResponse) GetMyGroupChatsResponse.ADAPTER.decode(r4);
        com.ss.android.lark.contact.base.dto.a r0 = new com.ss.android.lark.contact.base.dto.a();
        r0.a = this.a.a.getChatList(r5.chats);
        r0.b = r5.has_more.booleanValue();
        r0.c = r5.min_time.longValue();
        return r0;
    }
}
