package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "stageName");
        com.larus.ugc.perf.impl.c.a.getClass();
        if (com.larus.ugc.perf.impl.c.b("bot_edit_preview_page") != null) goto L5;
        return;
    L5:
        com.larus.ugc.perf.impl.g r1 = com.larus.ugc.perf.impl.c.b("bot_edit_preview_page".concat(r6));
        if (r1 == null) goto L16;
        com.larus.ugc.perf.impl.c.e("bot_edit_preview_page".concat(r6));
        long r2 = r1.a();
        if (0 <= r2) goto L10;
    L12:
        boolean r0 = false;
    L13:
        if (r0 == false) goto L17;
        com.larus.ugc.perf.impl.c.f(r1.a + '_' + r6, r1.c());
        return;
    L17:
        return;
    L10:
        if (r2 >= 120001) goto L12;
        r0 = true;
        goto L13
    }

    @JvmStatic
    public static final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "stageName");
        com.larus.ugc.perf.impl.c.a.getClass();
        if (com.larus.ugc.perf.impl.c.b("bot_edit_preview_page") != null) goto L5;
        return;
    L5:
        com.larus.ugc.perf.impl.g r1 = new com.larus.ugc.perf.impl.g("perf_bot_edit_preview_page_launch");
        com.larus.ugc.perf.impl.c.d("bot_edit_preview_page".concat(r3), r1);
    }

    @JvmStatic
    public static final void b(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "stageName");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        com.larus.ugc.perf.impl.c.a.getClass();
        if (com.larus.ugc.perf.impl.c.b("bot_edit_preview_page") != null) goto L5;
        return;
    L5:
        com.larus.ugc.perf.impl.g r5 = com.larus.ugc.perf.impl.c.b("bot_edit_preview_page".concat(r2));
        if (r5 == null) goto L9;
        r5.d(r3, r4);
        return;
    }
}
