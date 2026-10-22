package com.ss.android.lark.flow.chat.message;

import android.content.Context;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.flow.chat.FlowChatModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "chatId");
        int r1 = FlowChatModule.d;
        String r2 = FlowChatModule.a.a().a().getBrowserDependency().getAppLinkDomain();
        if (r2.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        return;
    L8:
        FlowChatModule.a.a().a().getBrowserDependency().openUrl(r4, UriProtector.parse("https://" + r2 + "/client/chat/open").buildUpon().appendQueryParameter("chatId", r5).appendQueryParameter("position", String.valueOf(r6)).build().toString());
        return;
    L5:
        r3 = false;
        goto L6
    }
}
