package com.larus.voice_setting.voice.utils;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.im.bean.bot.FirstMet;
import com.larus.utils.logger.FLogger;
import com.miui.easygo.sdk.constant.EasyGoCode;
import com.obric.aivoice.core.data.NameKeys;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class OpenBotHelper {
    public static final OpenBotHelper a = null;

    static {
        a = new OpenBotHelper();
    }

    public OpenBotHelper() {
    }

    public static boolean c(String r1) {
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L7;
        LaunchInfo r2 = r0.a;
        if (r2 == null) goto L7;
        String r3 = r2.W();
    L9:
        return Intrinsics.areEqual(r3, r1);
    L7:
        r3 = null;
        goto L9
    }

    public static final void a(OpenBotHelper r0, Context r1, String r2) {
        r0.getClass();
        if (r2 == null) goto L5;
        SmartRouter.buildRoute(r1, "sslocal://flow/chat?bot_id=".concat(r2)).d();
        return;
    L5:
        FLogger.a.i("Voice-Setting-OpenBotHelper", "[handleBackToChatPage] botId is NULL");
    }

    public final Object b(BotModel r86, boolean r87, Continuation<? super String> r88) {
        if ((r88 instanceof OpenBotHelper$findConversationIdByBot$1) == false) goto L7;
        OpenBotHelper$findConversationIdByBot$1 r1 = (OpenBotHelper$findConversationIdByBot$1) r88;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        OpenBotHelper$findConversationIdByBot$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        ResultKt.throwOnFailure(r0);
    L56:
        String r5 = (String) r0;
        if (r5 != null) goto L75;
        return NameKeys.UnloadStrategy_No_Strategy;
    L75:
        return r5;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
    L63:
        wc9.e r6 = (wc9.e) r0;
        if (r6 == null) goto L71;
        Map r7 = r6.x;
        if (r7 == null) goto L69;
        Map r8 = MapsKt.toMutableMap(r7);
        if (r8 == null) goto L69;
    L70:
        r8.put("is_from_local_discovery", "1");
        RepoDispatcherDelegate.b.f().c(r6, r8);
    L72:
        if (r6 == null) goto L76;
        r5 = r6.a;
        if (r5 != null) goto L75;
        return NameKeys.UnloadStrategy_No_Strategy;
    L76:
        return NameKeys.UnloadStrategy_No_Strategy;
    L69:
        r8 = new HashMap();
        goto L70
    L71:
        FLogger.a.i("Voice-Setting-OpenBotHelper", "[handleBackToChatPage]: createBotConversation failed return NULL");
        goto L72
    L17:
        boolean r9 = r13.Z$0;
        String r10 = (String) r13.L$1;
        BotModel r11 = (BotModel) r13.L$0;
        ResultKt.throwOnFailure(r0);
        BotModel r17 = r11;
    L25:
        wc9.e r12 = (wc9.e) r0;
        if (r12 == null) goto L33;
        Integer r14 = r12.t;
        if (r14 == null) goto L33;
        if (r14.intValue() != 1) goto L33;
        r5 = r12.a;
    L34:
        if (r5 != null) goto L36;
    L38:
        if (r9 == true) goto L60;
        String r15 = r17.getBotId();
        if (r15 != null) goto L43;
        r15 = NameKeys.UnloadStrategy_No_Strategy;
    L43:
        if (c(r15) == true) goto L60;
        FLogger.a.i("Voice-Setting-OpenBotHelper", "[handleBackToChatPage]: create a local conversation");
        FirstMet r16 = r17.getFirstMet();
        if (r16 == null) goto L48;
        String r27 = r16.getPrologue();
    L49:
        FirstMet r18 = r17.getFirstMet();
        if (r18 == null) goto L52;
        List r28 = r18.getSuggests();
    L53:
        BotModel r19 = BotModel.copy$default(r17, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, new BotOnBoarding(r27, r28, null, 2, null, 20, null), null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 2147483583, null);
        IConversationRepoService r20 = RepoDispatcherDelegate.b.f();
        r13.L$0 = null;
        r13.L$1 = null;
        r13.label = 3;
        r0 = IConversationRepoService.a.b(r20, r19, null, r13, 6);
        if (r0 != r3) goto L56;
        return r3;
    L52:
        r28 = null;
        goto L53
    L48:
        r27 = null;
    L60:
        FLogger.a.i("Voice-Setting-OpenBotHelper", "[handleBackToChatPage]: create a remote conversation");
        IConversationRepoService r21 = RepoDispatcherDelegate.b.f();
        r13.L$0 = null;
        r13.L$1 = null;
        r13.label = 2;
        r0 = IConversationRepoService.a.a(r21, r10, 2, null, null, false, null, null, null, null, r13, EasyGoCode.InitializedErrCode.PERMISSION_DENIED);
        if (r0 != r3) goto L63;
        return r3;
    L36:
        if (StringsKt.contains$default(r5, "local", false, 2, null) == true) goto L38;
        FLogger.a.i("Voice-Setting-OpenBotHelper", "[handleBackToChatPage]: use exist conversation(" + r5 + ')');
    L33:
        r5 = null;
        goto L34
    L18:
        ResultKt.throwOnFailure(r0);
        String r22 = r86.getBotId();
        if (r22 != null) goto L21;
        r22 = NameKeys.UnloadStrategy_No_Strategy;
    L21:
        IConversationRepoService r23 = RepoDispatcherDelegate.b.f();
        r13.L$0 = r86;
        r13.L$1 = r22;
        r13.Z$0 = r87;
        r13.label = 1;
        Object r24 = r23.a(r22, r13);
        if (r24 != r3) goto L24;
        return r3;
    L24:
        r17 = r86;
        r10 = r22;
        r0 = r24;
        r9 = r87;
    L7:
        r1 = new OpenBotHelper$findConversationIdByBot$1(this, r88);
        goto L8
    }

    public static void d(Context r11, String r12, BotModel r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "botId");
        Intrinsics.checkNotNullParameter("bot_voice_change", "currentPageName");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new OpenBotHelper$openChatPage$1(r14, r13, r11, "bot_voice_change", r12, null), 3, null);
    }
}
