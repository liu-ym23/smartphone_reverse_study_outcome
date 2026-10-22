package com.larus.bmhome.chat.auth;

import com.larus.bmhome.chat.auth.model.PluginAuthType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends com.larus.bmhome.chat.auth.a implements hc8.a {
    public final String a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PluginAuthType.values().length];
            r0[PluginAuthType.Always.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PluginAuthType.Once.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PluginAuthType.Deny.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PluginAuthType.Ask.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        this.a = r2;
    }

    public static String i(PluginAuthType r1) {
        if (r1 != null) goto L4;
        int r2 = -1;
    L6:
        if (r2 != 1) goto L8;
        return "always_allow";
    L8:
        if (r2 != 2) goto L10;
        return "allow_once";
    L10:
        if (r2 != 3) goto L12;
    L14:
        return "decline";
    L12:
        if (r2 == 4) goto L14;
        return "close";
    L4:
        r2 = a.a[r1.ordinal()];
        goto L6
    }

    public static String j(PluginAuthType r1) {
        if (r1 != null) goto L4;
        int r2 = -1;
    L6:
        if (r2 != 1) goto L8;
        return "always_allow";
    L8:
        if (r2 == 2) goto L10;
        return "null";
    L10:
        return "allow_once";
    L4:
        r2 = a.a[r1.ordinal()];
        goto L6
    }

    public final void h(String r11, String r12, PluginAuthType r13, PluginAuthType r14) {
        Intrinsics.checkNotNullParameter(r11, "pluginName");
        Intrinsics.checkNotNullParameter(r12, "pluginId");
        Intrinsics.checkNotNullParameter("bot_setting", "previousPage");
        c("plugin_management", "bot_setting", r11, r12, null, null, this.a, j(r13), i(r14));
    }

    @Override // hc8.a
    public final void a(String r11, String r12, String r13, String r14, String r15, PluginAuthType r16) {
        Intrinsics.checkNotNullParameter(r11, "messageId");
        Intrinsics.checkNotNullParameter(r12, "conversationId");
        Intrinsics.checkNotNullParameter(r13, "pluginName");
        Intrinsics.checkNotNullParameter(r14, "pluginId");
        Intrinsics.checkNotNullParameter(r15, "previousPage");
        e("chat", r15, r13, r14, r11, r12, this.a, j(r16));
    }

    @Override // hc8.a
    public final void b(String r12, String r13, String r14, String r15, String r16, PluginAuthType r17, PluginAuthType r18) {
        Intrinsics.checkNotNullParameter(r12, "messageId");
        Intrinsics.checkNotNullParameter(r13, "conversationId");
        Intrinsics.checkNotNullParameter(r14, "pluginName");
        Intrinsics.checkNotNullParameter(r15, "pluginId");
        Intrinsics.checkNotNullParameter(r16, "previousPage");
        Intrinsics.checkNotNullParameter(r18, "clickAuthType");
        c("chat", r16, r14, r15, r12, r13, this.a, j(r17), i(r18));
    }

    public final void g(String r12, String r13, String r14, String r15, String r16, PluginAuthType r17, PluginAuthType r18) {
        Intrinsics.checkNotNullParameter(r12, "messageId");
        Intrinsics.checkNotNullParameter(r13, "conversationId");
        Intrinsics.checkNotNullParameter(r14, "pluginName");
        Intrinsics.checkNotNullParameter(r15, "pluginId");
        Intrinsics.checkNotNullParameter(r16, "previousPage");
        c("chat_detail_page", r16, r14, r15, r12, r13, this.a, j(r17), i(r18));
    }
}
