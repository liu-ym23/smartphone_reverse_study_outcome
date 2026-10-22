package com.larus.drive.sdk.impl.service;

import android.content.Context;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveLocalConversationHelper {
    public static final DriveLocalConversationHelper a = null;

    static {
        a = new DriveLocalConversationHelper();
    }

    public DriveLocalConversationHelper() {
    }

    public static /* synthetic */ Object b(Context r2, Integer r3, Continuation r4) {
        return a.a(r2, r3, null, r4);
    }

    public final Object a(Context r22, Integer r23, String r24, Continuation<? super wc9.e> r25) {
        if ((r25 instanceof DriveLocalConversationHelper$createLocalSubConversation$1) == false) goto L7;
        DriveLocalConversationHelper$createLocalSubConversation$1 r1 = (DriveLocalConversationHelper$createLocalSubConversation$1) r25;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        String r7 = "";
        String r11 = null;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L18;
        if (r4 == 3) goto L17;
        if (r4 != 4) goto L16;
        BotModel r5 = (BotModel) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L71:
        wc9.e r6 = (wc9.e) r0;
        if (r6 == null) goto L74;
        r11 = r6.a;
    L74:
        if (r11 == null) goto L78;
        r7 = r11;
    L78:
        if ((!StringsKt.isBlank(r7)) == false) goto L85;
        BotInfoCache.INSTANCE.put(r7, r5);
        LocalSubConvHelper r8 = LocalSubConvHelper.a;
        BotOnBoarding r9 = r5.getOnBoarding();
        if (r9 == null) goto L83;
        List r10 = r9.getMessageList();
        if (r10 == null) goto L83;
    L84:
        LocalSubConvHelper.j(r7, r10, true);
    L83:
        r10 = CollectionsKt.emptyList();
    L85:
        return r6;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r12 = (String) r1.L$2;
        Integer r13 = (Integer) r1.L$1;
        Context r14 = (Context) r1.L$0;
        ResultKt.throwOnFailure(r0);
        Integer r15 = r13;
    L45:
        BotModel r16 = (BotModel) r0;
        if (r16 != null) goto L48;
        return null;
    L48:
        r1.L$0 = r16;
        r1.L$1 = null;
        r1.L$2 = null;
        r1.label = 4;
        kotlinx.coroutines.j r17 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r1), 1);
        r17.C();
        if (AccountService.a.isEnterpriseAccount() == false) goto L51;
        int r18 = 2131908160;
    L52:
        Pair[] r110 = new Pair[1];
        if (r14 == null) goto L56;
        String r20 = r14.getString(r18);
        if (r20 == null) goto L56;
    L57:
        r110[0] = TuplesKt.to("conv_name", r20);
        Map r21 = MapsKt.mutableMapOf(r110);
        if (r12 != null) goto L60;
    L65:
        com.larus.im.service.r.a.a(com.larus.im.d.d(), r16, 3, r15, r21, null, new n(r17), 16);
        Object r26 = r17.B();
        if (r26 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L68;
        DebugProbesKt.probeCoroutineSuspended(r1);
    L68:
        if (r26 != r3) goto L70;
        return r3;
    L70:
        r5 = r16;
        r0 = r26;
        goto L71
    L60:
        if ((!StringsKt.isBlank(r12)) == true) goto L63;
        r12 = null;
    L63:
        if (r12 == null) goto L65;
        r21.put("attach_local_msg", "true");
        r21.put("custom_suffix", r12);
    L56:
        r20 = "";
        goto L57
    L51:
        r18 = 2131908104;
        goto L52
    L18:
        String r27 = (String) r1.L$2;
        Integer r111 = (Integer) r1.L$1;
        Context r112 = (Context) r1.L$0;
        ResultKt.throwOnFailure(r0);
        String r113 = r27;
        Integer r114 = r111;
    L29:
        String r115 = (String) r0;
        if (r115 != null) goto L32;
    L35:
        boolean r28 = true;
    L36:
        if (r28 == false) goto L39;
        FLogger.a.i("DriveLocalConvHelper", "createLocalSubConversation skipped because botId is empty.");
        return null;
    L39:
        r1.L$0 = r112;
        r1.L$1 = r114;
        r1.L$2 = r113;
        r1.label = 3;
        kotlinx.coroutines.j r30 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r1), 1);
        r30.C();
        com.larus.im.service.o.a.a(com.larus.im.d.a(), r115, false, "sub", new o(r30), 8);
        r0 = r30.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L42;
        DebugProbesKt.probeCoroutineSuspended(r1);
    L42:
        if (r0 != r3) goto L44;
        return r3;
    L44:
        r14 = r112;
        r15 = r114;
        r12 = r113;
        goto L45
    L32:
        if (StringsKt.isBlank(r115) == true) goto L35;
        r28 = false;
        goto L36
    L19:
        ResultKt.throwOnFailure(r0);
    L25:
        return r0;
    L20:
        ResultKt.throwOnFailure(r0);
        if (com.larus.platform.exp.o.a() == false) goto L26;
        LocalSubConvHelper r31 = LocalSubConvHelper.a;
        String r32 = AccountService.a.getSecUserId();
        r1.label = 1;
        r0 = r31.c(r32, null, r1);
        if (r0 != r3) goto L25;
        return r3;
    L26:
        wc9.e r33 = (wc9.e) AuthModelDelegate.b.y().getValue();
        LocalSubConvHelper r34 = LocalSubConvHelper.a;
        r112 = r22;
        r1.L$0 = r112;
        r114 = r23;
        r1.L$1 = r114;
        r113 = r24;
        r1.L$2 = r113;
        r1.label = 2;
        r0 = r34.f(r33, r1);
        if (r0 != r3) goto L29;
        return r3;
    L7:
        r1 = new DriveLocalConversationHelper$createLocalSubConversation$1(this, r25);
        goto L8
    }
}
