package com.larus.bmhome.bot;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements com.larus.bmhome.setting.b {
    public b() {
    }

    public final void d() {
        com.larus.platform.service.o.a.b("click_change_language", com.larus.utils.f.c(new Pair[0]));
    }

    public final void e() {
        com.larus.platform.service.o.a.b("cancel_edit_personality", com.larus.utils.f.c(new Pair[0]));
    }

    public final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "toLanguage");
        com.larus.platform.service.o.a.b("change_language", com.larus.utils.f.c(new Pair[]{TuplesKt.to("to_language", r4)}));
    }

    public final void f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "editMethod");
        com.larus.platform.service.o.a.b("edit_personality", com.larus.utils.f.c(new Pair[]{TuplesKt.to("edit_method", r4)}));
    }

    public final void a(String r24, SpeakerVoice r25, String r26) {
        if (r25 != null) goto L4;
        return;
    L4:
        p2a.d.a.a(p2a.r.b.a3(), r25, r24, true, null, r26, null, null, null, null, null, null, null, null, null, null, "change_language", null, null, null, null, null, 4128712);
    }

    public final void b(int r4, long r5, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "botId");
        Intrinsics.checkNotNullParameter(r8, "errTips");
        com.larus.platform.service.o.a.b("setting_clear_context_result", com.larus.utils.f.c(new Pair[]{TuplesKt.to("success", Integer.valueOf(r4)), TuplesKt.to("err_code", Long.valueOf(r5)), TuplesKt.to("err_tips", r8), TuplesKt.to("bot_id", r7)}));
    }
}
