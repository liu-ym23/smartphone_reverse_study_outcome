package com.ss.android.lark.chat.api.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.GetChatQRCodeInfoResponse;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ChatQRCodeInfoResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g0 implements SdkSender.IParser<ChatQRCodeInfoResponse> {
    public g0() {
    }

    public final Object parse(byte[] r10) throws IOException {
        GetChatQRCodeInfoResponse r11 = (GetChatQRCodeInfoResponse) GetChatQRCodeInfoResponse.ADAPTER.decode(r10);
        Entity r0 = r11.entity;
        Chat r1 = null;
        if (r0 != null) goto L5;
        Map r2 = new HashMap();
    L7:
        if (CollectionUtils.isEmpty(r2) == false) goto L9;
    L11:
        Chat r4 = r1;
        return new ChatQRCodeInfoResponse(r11.already_in_chat.booleanValue(), r4, r11.inviter_id, r11.is_inviter_can_add_member.booleanValue(), r11.show_msg, r11.inviter_url);
    L9:
        if (TextUtils.isEmpty(r11.chat_id) == true) goto L11;
        r1 = (Chat) r2.get(r11.chat_id);
        goto L11
    L5:
        r2 = com.ss.android.lark.parser.internal.h.d(r0.chats, null, null);
        goto L7
    }
}
