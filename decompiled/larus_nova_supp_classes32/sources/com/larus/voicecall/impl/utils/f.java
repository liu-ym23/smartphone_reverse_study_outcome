package com.larus.voicecall.impl.utils;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new e());
    }

    public static final lq9.k a() {
        return (lq9.k) a.getValue();
    }

    public static final boolean b(String r7, String r8, BotModel r9) {
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        Intrinsics.checkNotNullParameter(r8, "botId");
        if (a().a() == true) goto L7;
        FLogger.a.w("ContinueTalkHelper_", "useContinueTalk, continueTalkV2 not enable");
        return false;
    L7:
        if (com.larus.voicecall.impl.b.a() == false) goto L11;
        FLogger.a.w("ContinueTalkHelper_", "useContinueTalk, forceFullScreenCall is true");
        return false;
    L11:
        if (StringsKt.isBlank(r7) == false) goto L17;
        if (StringsKt.isBlank(r8) == false) goto L17;
        FLogger.a.w("ContinueTalkHelper_", "useContinueTalk, conversationId and botId are empty");
        return false;
    L17:
        if (a().c() == false) goto L19;
    L22:
        AuthModelDelegate r0 = AuthModelDelegate.b;
        wc9.e r3 = (wc9.e) r0.y().getValue();
        if (r3 == null) goto L25;
        String r4 = r3.a;
    L26:
        e0 r1 = (e0) r0.e().getValue();
        if (r1 == null) goto L32;
        LaunchInfo r2 = r1.a;
        if (r2 == null) goto L32;
        String r5 = r2.W();
        if (r5 == null) goto L32;
    L33:
        FLogger r6 = FLogger.a;
        r6.i("ContinueTalkHelper_", "isMainBotConv, targetConversationId=" + r7 + ", targetBotId=" + r8 + ", mainConvId=" + r4 + ", mainBotId=" + r5);
        if ((!StringsKt.isBlank(r8)) == false) goto L39;
        if (Intrinsics.areEqual(r8, r5) == false) goto L39;
    L42:
        boolean r10 = true;
    L45:
        if (a().c() == true) goto L47;
    L51:
        if (r10 == true) goto L58;
        if (r9 != null) goto L54;
    L55:
        r6.w("ContinueTalkHelper_", "useContinueTalk, enableMainBotEntranceIntercept is false, but bot is immersive background");
        return false;
    L54:
        if (c4a.g.a(r9) == true) goto L55;
    L58:
        if (a().c() == false) goto L60;
    L64:
        return true;
    L60:
        if (a().f() == false) goto L64;
        if (r10 == false) goto L64;
        r6.i("ContinueTalkHelper_", "useContinueTalk, enableUgcBotEntranceIntercept is true, but  is main bot");
        return false;
    L47:
        if (a().f() == true) goto L51;
        if (r10 == true) goto L51;
        r6.w("ContinueTalkHelper_", "useContinueTalk, enableMainBotEntranceIntercept is true, but  is not main bot");
        return false;
    L39:
        if (o0.d(r4) == true) goto L41;
    L43:
        r10 = false;
        goto L45
    L41:
        if (Intrinsics.areEqual(r4, r7) == false) goto L43;
    L32:
        r5 = "7234781073513644036";
        goto L33
    L25:
        r4 = null;
        goto L26
    L19:
        if (a().f() == true) goto L22;
        FLogger.a.i("ContinueTalkHelper_", "useContinueTalk, both enableMainBotEntranceIntercept and enableUgcBotEntranceIntercept are false");
        return false;
    }
}
