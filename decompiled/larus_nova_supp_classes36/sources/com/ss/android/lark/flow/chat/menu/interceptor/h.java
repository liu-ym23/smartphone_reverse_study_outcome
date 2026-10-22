package com.ss.android.lark.flow.chat.menu.interceptor;

import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements yya.c {
    public h() {
    }

    public final String getTAG() {
        return "FlowReplyActionInterceptor";
    }

    public final boolean a(MessageActionType r2, yya.a r3) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        if (r2 == MessageActionType.REPLY) goto L5;
        return false;
    L5:
        if (r3.r() != PageType.REPLY_IN_THREAD) goto L10;
        return true;
    L10:
        return false;
    }
}
