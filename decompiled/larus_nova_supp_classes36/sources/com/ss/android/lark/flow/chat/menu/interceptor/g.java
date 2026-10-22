package com.ss.android.lark.flow.chat.menu.interceptor;

import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g extends a {
    public final String getTAG() {
        return "FlowRedPacketMessageActionInterceptor";
    }

    public g() {
    }

    public final Message.Type getMessageType() {
        return Message.Type.RED_PACKET;
    }
}
