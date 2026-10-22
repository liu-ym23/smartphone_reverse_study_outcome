package com.ss.android.lark.flow.chat.menu.interceptor;

import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.message.Message;
import kotlin.jvm.internal.Intrinsics;
import yya.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements p {
    public d() {
    }

    public final String getTAG() {
        return "FlowAudioMessageInterceptor";
    }

    public final Message.Type getMessageType() {
        return Message.Type.AUDIO;
    }

    public final boolean a(MessageActionType r4, yya.a r5) {
        Intrinsics.checkNotNullParameter(r4, "actionType");
        Intrinsics.checkNotNullParameter(r5, "actionContext");
        if (r4 != MessageActionType.FORWARD) goto L6;
        return true;
    L6:
        Intrinsics.checkNotNullParameter(r4, "actionType");
        Intrinsics.checkNotNullParameter(r5, "actionContext");
        Intrinsics.checkNotNullParameter(r4, "actionType");
        Intrinsics.checkNotNullParameter(r5, "actionContext");
        return false;
    }
}
