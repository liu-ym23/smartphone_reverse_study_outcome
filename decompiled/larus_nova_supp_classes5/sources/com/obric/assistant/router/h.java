package com.obric.assistant.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
import kotlin.jvm.internal.Intrinsics;
import q97.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h implements a {
    static {
    }

    public h() {
    }

    public final boolean b(com.bytedance.router.c r5) {
        if (r5 == null) goto L6;
        Uri r6 = r5.d;
        if (r6 == null) goto L6;
        String r7 = r6.toString();
    L7:
        String r0 = k0.a(r7);
        FLogger.a.i("ObricSecurityRouterInterceptor", "matchInterceptRules, customPath: " + r0 + ", uriStr: " + r7);
        if (Intrinsics.areEqual(r0, "//flow/debug_activity") == false) goto L10;
    L21:
        return true;
    L10:
        if (Intrinsics.areEqual(r0, "//flow/chat_debug") == true) goto L21;
        if (Intrinsics.areEqual(r0, "//flow/audio_tool_debug") == true) goto L21;
        if (Intrinsics.areEqual(r0, "//flow/ota_update") == true) goto L21;
        if (Intrinsics.areEqual(r0, "//debug/markdown_input") == true) goto L21;
        if (Intrinsics.areEqual(r0, "//debug/markdown_preview") == true) goto L21;
        return false;
    L6:
        r7 = null;
        goto L7
    }

    public final boolean a(Context r7, com.bytedance.router.c r8) {
        AppHost.Companion r9 = AppHost.a;
        if (r9.isDebug() == false) goto L5;
    L10:
        boolean r10 = true;
    L11:
        if (r8 == null) goto L15;
        Uri r0 = r8.d;
        if (r0 == null) goto L15;
        String r1 = UriProtector.getQueryParameter(r0, "is_from_push");
    L16:
        FLogger r3 = FLogger.a;
        r3.i("ObricSecurityRouterInterceptor", "onInterceptRoute, isDebugOrTestEnv: " + r10 + ", enterMethod: " + r1 + ", routeIntent: " + r8);
        if (r10 == true) goto L24;
        t1 r11 = t1.a;
        if (r11.I0().getEnableOSecurity() == false) goto L24;
        if (r11.I0().getEnableOBlockDebugRouter() == false) goto L24;
        r3.w("ObricSecurityRouterInterceptor", "onInterceptRoute, debug access denied by online channel");
        return true;
    L24:
        return false;
    L15:
        r1 = null;
        goto L16
    L5:
        if (r9.isTestChannel() == true) goto L10;
        if (Intrinsics.areEqual(r9.getBuildChannel(), "auto_test") == true) goto L10;
        r10 = false;
        goto L11
    }
}
