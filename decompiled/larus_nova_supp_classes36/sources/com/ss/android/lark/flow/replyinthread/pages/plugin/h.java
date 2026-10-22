package com.ss.android.lark.flow.replyinthread.pages.plugin;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h extends xgb.a {
    public final boolean g(MessageInfo r5) {
        String r0 = null;
        if (r5 == null) goto L7;
        Message r1 = r5.getMessage();
        if (r1 == null) goto L7;
        Message.Type r2 = r1.getType();
    L9:
        if (r2 != Message.Type.DOUBAO) goto L18;
        MessageInfo r3 = r5.getParentMessageInfo();
        if (r3 == null) goto L16;
        Message r4 = r3.getMessage();
        if (r4 == null) goto L16;
        r0 = r4.getFromId();
    L16:
        if (Intrinsics.areEqual(r0, ChatCoreModule.a().getPassportDependency().userId()) == false) goto L18;
        return true;
    L18:
        Message r6 = r5.getMessage();
        if (r6.isFromMe() == false) goto L21;
    L25:
        return false;
    L21:
        if (r6.isAtAll() == false) goto L23;
        return true;
    L23:
        if (r6.isOtherAtMe() == false) goto L25;
        return true;
    L7:
        r2 = null;
        goto L9
    }

    public h(i r1, j r2, k r3) {
        super(r1, r2, r3);
    }
}
