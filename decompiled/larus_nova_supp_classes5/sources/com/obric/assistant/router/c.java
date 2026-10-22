package com.obric.assistant.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import q97.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c implements a {
    static {
    }

    public c() {
    }

    public final boolean b(com.bytedance.router.c r2) {
        int r0 = k0.a;
        if (r2 == null) goto L7;
        Uri r3 = r2.d;
        if (r3 == null) goto L7;
        String r4 = r3.toString();
    L8:
        String r5 = k0.a(r4);
        if (Intrinsics.areEqual(r5, "//flow/chat_multi_tab") == false) goto L11;
    L14:
        return true;
    L11:
        if (Intrinsics.areEqual(r5, "//flow/chat_page_double_tab") == true) goto L14;
        return false;
    L7:
        r4 = null;
        goto L8
    }

    public final boolean a(Context r10, com.bytedance.router.c r11) {
        Bundle r0 = null;
        if (r11 == null) goto L7;
        Intent r1 = r11.b;
        if (r1 == null) goto L7;
        Bundle r2 = r1.getExtras();
    L8:
        String r3 = "";
        if (r2 == null) goto L15;
        String r4 = r2.getString("argConversationId", "");
        if (r4 == null) goto L15;
        r3 = r4;
    L15:
        if (r2 == null) goto L17;
        Integer r5 = Integer.valueOf(r2.getInt("argBotConversationType", -1));
    L19:
        if (r5 != null) goto L22;
    L28:
        if (r5 == null) goto L33;
        if (r5.intValue() != 1) goto L33;
    L36:
        boolean r6 = true;
    L37:
        FLogger.a.i("ObricMultiTabChatPageRouterInterceptor", "onInterceptRoute isMainBot = " + r6 + ", conversationId = " + r3 + ", conversationType = " + r5);
        if (r6 == false) goto L46;
        i r12 = SmartRouter.buildRoute(r10, "//flow/chat_page");
        if (r11 == null) goto L44;
        Intent r13 = r11.b;
        if (r13 == null) goto L44;
        r0 = r13.getExtras();
    L44:
        r12.c.putExtras(r0);
        r12.d();
        return true;
    L46:
        return false;
    L33:
        if (com.larus.bmhome.utils.i.g(r3) == true) goto L36;
        r6 = false;
        goto L37
    L22:
        if (r5.intValue() != (-1)) goto L28;
        if (r3.length() != 0) goto L26;
        boolean r7 = true;
    L27:
        if (r7 == true) goto L36;
    L26:
        r7 = false;
        goto L27
    L17:
        r5 = null;
    L7:
        r2 = null;
        goto L8
    }
}
