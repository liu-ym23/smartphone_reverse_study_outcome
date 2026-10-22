package com.larus.voicecall.impl.ui;

import android.text.TextUtils;
import com.larus.audio.audiov3.report.AudioDeviceMonitorScenes;
import com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter;
import com.larus.audio.audiov3.report.IAudioEventCommonParams;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.IRepoDispatcherService;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;
import v19.e6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallHelperKt$reportClickCallEvent$1", f = "RealtimeCallHelper.kt", i = {}, l = {879}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallHelperKt$reportClickCallEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionBarItemId;
    final /* synthetic */ String $actionBarKey;
    final /* synthetic */ String $callId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ BotModel $currentBot;
    final /* synthetic */ String $enterFrom;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ boolean $hasRedDot;
    final /* synthetic */ boolean $isContinueSpeak;
    final /* synthetic */ by7.e $trackNode;
    final /* synthetic */ String $trackParams;
    int label;

    public RealtimeCallHelperKt$reportClickCallEvent$1(BotModel r1, by7.e r2, boolean r3, boolean r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, Continuation<? super RealtimeCallHelperKt$reportClickCallEvent$1> r12) {
        this.$currentBot = r1;
        this.$trackNode = r2;
        this.$hasRedDot = r3;
        this.$isContinueSpeak = r4;
        this.$conversationId = r5;
        this.$enterFrom = r6;
        this.$enterMethod = r7;
        this.$actionBarItemId = r8;
        this.$actionBarKey = r9;
        this.$callId = r10;
        this.$trackParams = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        return new RealtimeCallHelperKt$reportClickCallEvent$1(this.$currentBot, this.$trackNode, this.$hasRedDot, this.$isContinueSpeak, this.$conversationId, this.$enterFrom, this.$enterMethod, this.$actionBarItemId, this.$actionBarKey, this.$callId, this.$trackParams, r15);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        Unit r4 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
        Object r3 = r20;
    L21:
        wc9.e r5 = (wc9.e) r3;
    L23:
        BotModel r1 = this.$currentBot;
        if (r1 == null) goto L26;
        String r6 = r1.getBotId();
    L28:
        if (this.$trackNode != null) goto L30;
        String r7 = "chat";
    L31:
        int r8 = c4a.g.a;
        if (c4a.g.a(this.$currentBot) == false) goto L34;
        String r12 = "1";
    L36:
        if (this.$hasRedDot == false) goto L38;
        String r11 = "1";
    L39:
        if (r5 == null) goto L41;
        String r10 = ic8.n.f(r5);
    L43:
        if (this.$isContinueSpeak == false) goto L45;
        String r13 = "1";
    L46:
        e6 r9 = e6.a;
        String r14 = r9.c();
        String r15 = r9.b();
        JSONObject r16 = new JSONObject();
        String r17 = this.$actionBarItemId;
        String r18 = this.$actionBarKey;
        String r19 = this.$callId;
        String r21 = this.$trackParams;
        r16.put("action_bar_item_id", r17);
        r16.put("action_bar_key", r18);
        if (r19 == null) goto L49;
        r16.put("call_id", r19);
    L49:
        if (r21 != null) goto L81;
    L59:
        tx9.c0.e(r6, this.$conversationId, r7, this.$enterFrom, this.$enterMethod, r10, r11, r12, r13, r14, r15, r16, this.$trackNode, 26376);
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L66
        IAudioEventCommonParams r23 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);     // Catch: Throwable -> L66
        if (r23 == null) goto L63;
        r23.b(AppHost.a.getApplication());     // Catch: Throwable -> L66
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L66
    L64:
        Result.constructor-impl(r24);     // Catch: Throwable -> L66
    L79:
        IAudioDeviceMonitorReporter r25 = (IAudioDeviceMonitorReporter) ServiceManager.get().getService(IAudioDeviceMonitorReporter.class);     // Catch: Throwable -> L73
        if (r25 == null) goto L71;
        r25.a(AudioDeviceMonitorScenes.ENTER_CALL);     // Catch: Throwable -> L73
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L73
    L71:
        Result.constructor-impl(r4);     // Catch: Throwable -> L73
    L76:
        return Unit.INSTANCE;
    L73:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L76
    L63:
        r24 = null;
    L66:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L79
    L81:
    L57:
        e = move-exception;
        FLogger.a.e("RealtimeCallHelper", "create call param sessionExtraJsonStr failed : " + e.getMessage());
        goto L59
    L51:
        if (TextUtils.isEmpty(r21) == true) goto L59;
        JSONObject r28 = new JSONObject(r21);     // Catch: JSONException -> L57
        Iterator<String> r29 = r28.keys();     // Catch: JSONException -> L57
    L54:
        if (r29.hasNext() == false) goto L59;
        String r30 = r29.next();     // Catch: JSONException -> L57
        r16.put(r30, r28.opt(r30));     // Catch: JSONException -> L57
        goto L54
    L45:
        r13 = "0";
        goto L46
    L41:
        r10 = null;
        goto L43
    L38:
        r11 = "0";
        goto L39
    L34:
        r12 = "0";
        goto L36
    L30:
        r7 = null;
        goto L31
    L26:
        r6 = null;
        goto L28
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        BotModel r31 = this.$currentBot;
        if (r31 == null) goto L11;
        String r32 = r31.getBotId();
    L12:
        IRepoDispatcherService r33 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
        if (r33 == null) goto L22;
        IConversationRepoService r34 = r33.f();
        if (r34 == null) goto L22;
        if (r32 != null) goto L18;
        r32 = NameKeys.UnloadStrategy_No_Strategy;
    L18:
        this.label = 1;
        r3 = r34.a(r32, this);
        if (r3 != r0) goto L21;
        return r0;
    L22:
        r5 = null;
        goto L23
    L11:
        r32 = null;
        goto L12
    }
}
