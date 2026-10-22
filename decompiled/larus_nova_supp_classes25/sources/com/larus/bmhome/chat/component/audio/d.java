package com.larus.bmhome.chat.component.audio;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.audio.RealtimeCallService;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.AccountService;
import com.larus.ui.arch.component.internal.attach.a;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import de8.c;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ LandingRealtimeCallComponent a;

    public /* synthetic */ d(LandingRealtimeCallComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r46) {
        LandingRealtimeCallComponent r1 = this.a;
        Pair r2 = (Pair) r46;
        wc9.e r3 = (wc9.e) r2.getFirst();
        if (r3 == null) goto L32;
        BotModel r9 = (BotModel) r2.getSecond();
        if (r9 == null) goto L33;
        r1.getClass();
        RealtimeCallService r4 = RealtimeCallService.b;
        Pair<Boolean, Boolean> r5 = r4.c();
        if (r5 != null) goto L11;
    L13:
        boolean r6 = false;
    L14:
        if (r6 == false) goto L31;
        Pair<Boolean, Boolean> r7 = r4.c();
        if (r7 != null) goto L18;
    L20:
        boolean r43 = false;
    L21:
        Boolean r8 = Boolean.FALSE;
        r4.b(TuplesKt.to(r8, r8));
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Fragment r10 = a.b(r1, r1);
        String r11 = r3.a;
        String r12 = r3.I;
        String r13 = r3.B;
        Long r14 = r3.q;
        RecommendFrom r15 = ((c) r1.i.getValue()).d;
        ChatControlTrace r16 = ChatControlTrace.b;
        Integer r17 = r3.v;
        Integer r18 = r9.getBotType();
        BotCreatorInfo r19 = r9.getBotCreatorInfo();
        if (r19 == null) goto L24;
        String r110 = r19.getId();
    L25:
        b3a.c r44 = new b3a.c(r10, r11, r13, r14, r9, r15, r16.g(r17, r18, Intrinsics.areEqual(r110, AccountService.a.getUserId())), "chat", "slide_screen", null, false, ((c) r1.i.getValue()).e, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ChatControlTrace.L, ChatControlTrace.M, ChatControlTrace.P, null, null, null, null, null, r12, -939526656, 63);
        if (((Boolean) r1.l.getValue()).booleanValue() == false) goto L29;
        if (r43 == false) goto L29;
        r44 = b3a.c.a(r44, null, 0, null, "1", null, null, null, -67108865, 127);
    L29:
        VoiceCallServiceDelegate r20 = VoiceCallServiceDelegate.a;
        r20.t(r44, false);
        goto L31
    L24:
        r110 = null;
        goto L25
    L18:
        if (((Boolean) r7.getSecond()).booleanValue() != true) goto L20;
        r43 = true;
    L31:
        return Unit.INSTANCE;
    L11:
        if (((Boolean) r5.getFirst()).booleanValue() != true) goto L13;
        r6 = true;
        goto L14
    L33:
        return Unit.INSTANCE;
    L32:
        return Unit.INSTANCE;
    }
}
