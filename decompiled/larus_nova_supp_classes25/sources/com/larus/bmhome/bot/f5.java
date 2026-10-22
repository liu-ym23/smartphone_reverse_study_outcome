package com.larus.bmhome.bot;

import com.larus.im.bean.bot.BotModel;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f5 implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ CommonSettingFragment a;

    public final void cancel() {
        int r0 = wi8.e.a;
        BotModel r1 = this.a.s;
        String r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r1 = null;
    L5:
        String r3 = r1.getBotId();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        String r4 = this.a.n;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
    L12:
        Intrinsics.checkNotNullParameter(r3, "botId");
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        com.larus.platform.service.o.a.b("cancel_edit_chat_name", com.larus.utils.f.c(new Pair[]{TuplesKt.to("bot_id", r3), TuplesKt.to("conversation_id", r2), TuplesKt.to("click_from", "self_created_chat_setting")}));
        return;
    L11:
        r2 = r4;
        goto L12
    }

    public f5(CommonSettingFragment r1) {
        this.a = r1;
    }
}
