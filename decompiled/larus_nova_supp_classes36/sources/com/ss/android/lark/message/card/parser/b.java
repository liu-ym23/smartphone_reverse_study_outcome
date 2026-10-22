package com.ss.android.lark.message.card.parser;

import com.bytedance.lark.pb.basic.v1.CardAction;
import com.bytedance.lark.pb.basic.v1.CardActionPacket;
import com.larksuite.framework.utils.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements y.a<CardAction, com.ss.android.lark.chat.entity.message.CardAction> {
    public b() {
    }

    public final Object get(Object r6) {
        CardAction r7 = (CardAction) r6;
        com.ss.android.lark.chat.entity.message.CardAction.RequiredParameters r0 = null;
        if (r7 == null) goto L19;
        com.ss.android.lark.chat.entity.message.CardAction r1 = new com.ss.android.lark.chat.entity.message.CardAction();
        r1.setUrl(r7.url);
        r1.setCmd(r7.cmd.intValue());
        r1.setMethod(com.ss.android.lark.chat.entity.message.CardAction.Method.fromValue(r7.method.getValue()));
        CardAction.Url r2 = r7.open_url;
        if (r2 != null) goto L8;
        com.ss.android.lark.chat.entity.message.CardAction.OpenUrl r3 = null;
    L9:
        r1.setOpenUrl(r3);
        CardActionPacket r4 = r7.packet;
        if (r4 != null) goto L12;
        com.ss.android.lark.chat.entity.message.CardActionPacket r5 = null;
    L13:
        r1.setPacket(r5);
        CardAction.RequiredParameters r8 = r7.required_parameters;
        if (r8 == null) goto L17;
        r0 = new com.ss.android.lark.chat.entity.message.CardAction.RequiredParameters();
        r0.setNeedMessageId(r8.need_message_id.booleanValue());
        r0.setNeedMessageInfo(r8.need_message_info.booleanValue());
        r0.setNeedUserId(r8.need_user_id.booleanValue());
        r0.setNeedUserInfo(r8.need_user_info.booleanValue());
    L17:
        r1.setRequiredParameters(r0);
        r1.setParameters(d.e(r7.parameters));
        return r1;
    L12:
        r5 = new com.ss.android.lark.chat.entity.message.CardActionPacket();
        r5.setCid(r4.cid);
        r5.setParameters(d.e(r4.parameters));
        r5.setPayload(r4.payload);
        goto L13
    L8:
        r3 = new com.ss.android.lark.chat.entity.message.CardAction.OpenUrl();
        r3.setAndroidUrl(r2.android_url);
        r3.setIosUrl(r2.ios_url);
        r3.setPcUrl(r2.pc_url);
        r3.setUrl(r2.url);
        goto L9
    L19:
        return null;
    }
}
