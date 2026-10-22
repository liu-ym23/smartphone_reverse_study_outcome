package com.ss.android.lark.message.card.parser;

import com.larksuite.framework.utils.y;
import com.ss.android.lark.chat.entity.message.CardAction;
import com.ss.android.lark.chat.entity.message.CardActionPacket;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements y.a<CardAction, com.bytedance.lark.pb.basic.v1.CardAction> {
    public c() {
    }

    public final Object get(Object r6) {
        CardAction r7 = (CardAction) r6;
        com.bytedance.lark.pb.basic.v1.CardAction.RequiredParameters r0 = null;
        if (r7 == null) goto L18;
        com.bytedance.lark.pb.basic.v1.CardAction.Builder r1 = new com.bytedance.lark.pb.basic.v1.CardAction.Builder().url(r7.getUrl()).cmd(Integer.valueOf(r7.getCmd())).method(com.bytedance.lark.pb.basic.v1.CardAction.Method.fromValue(r7.getMethod().getValue()));
        CardAction.OpenUrl r2 = r7.getOpenUrl();
        if (r2 != null) goto L7;
        com.bytedance.lark.pb.basic.v1.CardAction.Url r3 = null;
    L8:
        com.bytedance.lark.pb.basic.v1.CardAction.Builder r4 = r1.open_url(r3);
        CardActionPacket r5 = r7.getPacket();
        if (r5 != null) goto L11;
        com.bytedance.lark.pb.basic.v1.CardActionPacket r8 = null;
    L12:
        com.bytedance.lark.pb.basic.v1.CardAction.Builder r9 = r4.packet(r8);
        CardAction.RequiredParameters r10 = r7.getRequiredParameters();
        if (r10 == null) goto L17;
        r0 = new com.bytedance.lark.pb.basic.v1.CardAction.RequiredParameters.Builder().need_message_id(Boolean.valueOf(r10.isNeedMessageId())).need_message_info(Boolean.valueOf(r10.isNeedMessageInfo())).need_user_id(Boolean.valueOf(r10.isNeedUserId())).need_user_info(Boolean.valueOf(r10.isNeedUserInfo())).build();
    L17:
        return r9.required_parameters(r0).parameters(d.f(r7.getParameters())).build();
    L11:
        r8 = new com.bytedance.lark.pb.basic.v1.CardActionPacket.Builder().cid(r5.getCid()).parameters(d.f(r5.getParameters())).payload(r5.getPayload()).build();
        goto L12
    L7:
        r3 = new com.bytedance.lark.pb.basic.v1.CardAction.Url.Builder().android_url(r2.getAndroidUrl()).ios_url(r2.getIosUrl()).pc_url(r2.getPcUrl()).url(r2.getUrl()).build();
        goto L8
    L18:
        return null;
    }
}
