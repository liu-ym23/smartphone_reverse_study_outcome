package com.ss.android.lark.contact.base.service;

import com.bytedance.lark.pb.im.v1.GetMyGroupChatsResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class w implements SdkSender.IParser<List<Chat>> {
    public final /* synthetic */ y a;

    public w(y r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r2) throws IOException {
        GetMyGroupChatsResponse r3 = (GetMyGroupChatsResponse) GetMyGroupChatsResponse.ADAPTER.decode(r2);
        ArrayList r0 = new ArrayList();
        if (r3 != null) goto L6;
        return r0;
    L6:
        return this.a.a.getChatList(r3.chats);
    }
}
