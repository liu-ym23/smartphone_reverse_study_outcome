package com.ss.android.lark.flow.chat.menu.interceptor;

import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import kotlin.jvm.internal.Intrinsics;
import yya.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a implements p {
    public a() {
    }

    public final boolean a(MessageActionType r2, yya.a r3) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        if (r2 != MessageActionType.ADD_REACTION) goto L5;
        return false;
    L5:
        if (r2 != MessageActionType.DING) goto L7;
        return false;
    L7:
        if (r2 != MessageActionType.REPLY) goto L9;
        return false;
    L9:
        if (r2 != MessageActionType.ZONE_REPLY) goto L11;
        return false;
    L11:
        if (r2 != MessageActionType.MULTI_SELECT) goto L13;
        return false;
    L13:
        if (r2 != MessageActionType.DELETE) goto L15;
        return false;
    L15:
        if (r2 != MessageActionType.ADD_TASK) goto L17;
        return false;
    L17:
        if (r2 != MessageActionType.PIN_TO_TOP) goto L19;
        return false;
    L19:
        if (r2 != MessageActionType.REPLY_IN_THREAD) goto L21;
        return false;
    L21:
        if (r2 != MessageActionType.MESSAGE_RESTRICT) goto L23;
        return false;
    L23:
        if (r2 != MessageActionType.COPY_MESSAGE_LINK) goto L25;
        return false;
    L25:
        if (r2 != MessageActionType.FORWARD_REPLY_IN_THREAD) goto L27;
        return false;
    L27:
        if (r2 != MessageActionType.SAVE_TO) goto L29;
        return false;
    L29:
        if (r2 != MessageActionType.CHAT_PIN) goto L31;
        return false;
    L31:
        if (r2 == MessageActionType.FLOW_MORE) goto L50;
        return true;
    L50:
        return false;
    }
}
