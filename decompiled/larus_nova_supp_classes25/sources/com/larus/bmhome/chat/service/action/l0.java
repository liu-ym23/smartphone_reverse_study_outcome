package com.larus.bmhome.chat.service.action;

import com.larus.audio.AudioServiceDelegate;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.api.ConversationFeedActionType;
import com.larus.bmhome.chat.model.ConversationListModel;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l0 implements b {
    public final a a;

    public l0(a r2) {
        Intrinsics.checkNotNullParameter(r2, "executeContext");
        this.a = r2;
    }

    @Override // com.larus.bmhome.chat.service.action.b
    public final void a(wh8.a r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        com.larus.bmhome.chat.api.i r1 = this.a.a;
        ConversationListModel r2 = ConversationListModel.a;
        DowngradeSource r3 = DowngradeSource.CLICK_ACTION;
        r2.getClass();
        ConversationListModel.B(r10, r3);
        int r4 = c.a;
        Intrinsics.checkNotNullParameter(r10, "data");
        if (AudioServiceDelegate.a.getAudioConfig().n(r10.b) == false) goto L5;
        String r0 = "1";
    L6:
        String r6 = r0;
        BotModel r5 = r10.b;
        String r7 = null;
        if (r5 == null) goto L9;
        String r8 = r5.getBotId();
    L10:
        ChatControlTrace r9 = ChatControlTrace.b;
        wc9.e r11 = r10.a;
        if (r11 == null) goto L13;
        Integer r12 = r11.v;
    L14:
        String r13 = r9.g(r12, c.b(r10), c.a(r10));
        String r14 = r1.d;
        String r15 = r1.c;
        Function1<wh8.a, String> r16 = r1.h;
        if (r16 == null) goto L17;
        r7 = (String) r16.invoke(r10);
    L17:
        tx9.z.a(r8, r13, r14, r15, r6, r7, r10.e);
        Function2<ConversationFeedActionType, wh8.a, Unit> r17 = r1.j;
        if (r17 == null) goto L20;
        r17.invoke(ConversationFeedActionType.REFRESH_RECOMMEND_BOT, r10);
    L20:
        Function0<Unit> r18 = r1.i;
        if (r18 == null) goto L24;
        r18.invoke();
        return;
    L24:
        return;
    L13:
        r12 = null;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r0 = "0";
        goto L6
    }
}
