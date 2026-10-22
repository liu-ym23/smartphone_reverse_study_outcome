package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(yya.a r2, Message.Type r3) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        Intrinsics.checkNotNullParameter(r3, "messageType");
        Chat r0 = r2.getChat();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isSecret() != true) goto L7;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        w4b.a r4 = ChatCoreModule.a().getAuditDependency();
        Chat r5 = r2.getChat();
        if (r5 == null) goto L13;
        String r6 = r5.getId();
    L15:
        if (r3 != Message.Type.TEXT) goto L18;
        String r7 = "text";
    L21:
        r4.c(r6, r7);
        return;
    L18:
        if (r3 != Message.Type.POST) goto L20;
        r7 = "post";
        goto L21
    L20:
        r7 = BuildConfig.FLAVOR;
        goto L21
    L13:
        r6 = null;
    L7:
        r1 = false;
        goto L8
    }
}
