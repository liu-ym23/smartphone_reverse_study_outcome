package com.larus.bmhome.chat.auth;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class a {
    public a() {
    }

    public static void f(a r0, String r1, JSONObject r2) {
        r0.getClass();
        by7.a r3 = new by7.a(r1);
        TrackParams r4 = new TrackParams().merge(r2);
        r3.a.merge(r4);
        r3.b();
    }

    public final void d(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "currentPage");
        Intrinsics.checkNotNullParameter(r4, "previousPage");
        Intrinsics.checkNotNullParameter(r6, "botId");
        JSONObject r0 = new JSONObject();
        r0.put("current_page", r3);
        r0.put("previous_page", r4);
        r0.put("enter_from", r4);
        r0.put("bot_id", r6);
        r0.put("conversation_id", r5);
        r0.put("page", r3);
        f(this, "enter_page", r0);
    }

    public final void e(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r3, "currentPage");
        Intrinsics.checkNotNullParameter(r4, "previousPage");
        Intrinsics.checkNotNullParameter(r5, "pluginName");
        Intrinsics.checkNotNullParameter(r6, "pluginId");
        Intrinsics.checkNotNullParameter(r9, "botId");
        Intrinsics.checkNotNullParameter(r10, "authStatus");
        JSONObject r0 = new JSONObject();
        r0.put("current_page", r3);
        r0.put("previous_page", r4);
        r0.put("plugin_name", r5);
        r0.put("plugin_id", r6);
        if (r7 == null) goto L5;
        r0.put("message_id", r7);
    L5:
        if (r8 == null) goto L7;
        r0.put("conversation_id", r8);
    L7:
        r0.put("bot_id", r9);
        r0.put("auth_status", r10);
        f(this, "show_plugin_auth", r0);
    }

    public final void c(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r3, "currentPage");
        Intrinsics.checkNotNullParameter(r4, "previousPage");
        Intrinsics.checkNotNullParameter(r5, "pluginName");
        Intrinsics.checkNotNullParameter(r6, "pluginId");
        Intrinsics.checkNotNullParameter(r9, "botId");
        Intrinsics.checkNotNullParameter(r10, "authStatus");
        Intrinsics.checkNotNullParameter(r11, "clickChoice");
        JSONObject r0 = new JSONObject();
        r0.put("current_page", r3);
        r0.put("previous_page", r4);
        r0.put("plugin_name", r5);
        r0.put("plugin_id", r6);
        if (r7 == null) goto L5;
        r0.put("message_id", r7);
    L5:
        if (r8 == null) goto L7;
        r0.put("conversation_id", r8);
    L7:
        r0.put("bot_id", r9);
        r0.put("auth_status", r10);
        r0.put("click_choice", r11);
        f(this, "click_plugin_auth", r0);
    }
}
