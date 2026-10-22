package com.ss.android.lark.flow.chat.menu.interceptor;

import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends a {
    public final String getTAG() {
        return "FlowCommercializedRedPacketMessageActionInterceptor";
    }

    public e() {
    }

    public final Message.Type getMessageType() {
        return Message.Type.COMMERCIALIZED_HONGBAO;
    }
}
