package com.larus.bmhome.bot;

import com.larus.im.bean.bot.BotModel;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a5 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ CommonSettingFragment a;

    public final void confirm() {
        CommonSettingFragment r0 = this.a;
        b r1 = r0.l;
        BotModel r2 = r0.s;
        BotModel r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r2 = null;
    L5:
        String r4 = r2.getBotId();
        String r5 = "";
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "botID");
        com.larus.platform.service.o.a.b("delete_bot", com.larus.utils.f.c(new Pair[]{TuplesKt.to("bot_id", r4)}));
        CommonSettingFragment r6 = this.a;
        if (r6.p == false) goto L19;
        BotSettingViewModel r7 = r6.Ja0();
        BotModel r8 = this.a.s;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L14:
        String r9 = r3.getBotId();
        if (r9 == null) goto L18;
        r5 = r9;
    L18:
        r7.deleteBot(r5, this.a.La0());
        return;
    L13:
        r3 = r8;
        goto L14
    L19:
        BotSettingViewModel r10 = r6.Ja0();
        BotModel r11 = this.a.s;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r11 = null;
    L22:
        String r12 = r11.getBotId();
        if (r12 == null) goto L26;
        r5 = r12;
    L26:
        BotModel r13 = this.a.n;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
    L30:
        r10.deleteBot(r5, r3);
        return;
    L29:
        r3 = r13;
        goto L30
    }

    public a5(CommonSettingFragment r1) {
        this.a = r1;
    }
}
