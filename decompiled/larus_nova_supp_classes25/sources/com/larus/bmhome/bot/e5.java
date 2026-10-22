package com.larus.bmhome.bot;

import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.im.bean.bot.BotModel;
import java.math.BigDecimal;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e5 implements com.larus.common_ui.dialog.y0 {
    public final /* synthetic */ CommonSettingFragment a;

    public e5(CommonSettingFragment r1) {
        this.a = r1;
    }

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, ChatDraftItem.TYPE_TEXT);
        CommonSettingFragment r0 = this.a;
        BigDecimal r1 = CommonSettingFragment.k1;
        BotSettingViewModel r2 = r0.Ja0();
        String r3 = this.a.n;
        String r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r3 = null;
    L5:
        r2.updateConversationName(r3, r5);
        int r6 = wi8.e.a;
        BotModel r7 = this.a.s;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r7 = null;
    L8:
        String r8 = r7.getBotId();
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        String r9 = this.a.n;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
    L15:
        Intrinsics.checkNotNullParameter(r8, "botId");
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        com.larus.platform.service.o.a.b("edit_chat_name", com.larus.utils.f.c(new Pair[]{TuplesKt.to("bot_id", r8), TuplesKt.to("conversation_id", r4), TuplesKt.to("click_from", "self_created_chat_setting")}));
        return;
    L14:
        r4 = r9;
        goto L15
    }
}
