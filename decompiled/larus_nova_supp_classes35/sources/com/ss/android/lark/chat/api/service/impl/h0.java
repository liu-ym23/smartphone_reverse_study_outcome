package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.GetChatLinkInfoResponse;
import com.ss.android.lark.dto.chat.ChatLinkInfoResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h0 implements SdkSender.IParser<ChatLinkInfoResponse> {
    public h0() {
    }

    public final Object parse(byte[] r3) throws IOException {
        return new ChatLinkInfoResponse((GetChatLinkInfoResponse) GetChatLinkInfoResponse.ADAPTER.decode(r3));
    }
}
