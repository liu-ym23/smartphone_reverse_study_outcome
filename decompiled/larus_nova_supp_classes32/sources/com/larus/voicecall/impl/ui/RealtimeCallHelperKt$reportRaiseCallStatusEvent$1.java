package com.larus.voicecall.impl.ui;

import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallHelperKt$reportRaiseCallStatusEvent$1", f = "RealtimeCallHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallHelperKt$reportRaiseCallStatusEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $callId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ JSONObject $extraParams;
    final /* synthetic */ String $failReason;
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ String $speakerId;
    final /* synthetic */ String $success;
    int label;

    public RealtimeCallHelperKt$reportRaiseCallStatusEvent$1(String r1, String r2, String r3, String r4, String r5, String r6, String r7, JSONObject r8, RealtimeCallParam r9, Continuation<? super RealtimeCallHelperKt$reportRaiseCallStatusEvent$1> r10) {
        this.$botId = r1;
        this.$callId = r2;
        this.$conversationId = r3;
        this.$failReason = r4;
        this.$success = r5;
        this.$enterMethod = r6;
        this.$speakerId = r7;
        this.$extraParams = r8;
        this.$params = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new RealtimeCallHelperKt$reportRaiseCallStatusEvent$1(this.$botId, this.$callId, this.$conversationId, this.$failReason, this.$success, this.$enterMethod, this.$speakerId, this.$extraParams, this.$params, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L41;
        ResultKt.throwOnFailure(r13);
        String r14 = this.$botId;
        String r0 = this.$callId;
        String r1 = this.$conversationId;
        String r2 = this.$failReason;
        String r3 = this.$success;
        String r4 = this.$enterMethod;
        String r5 = this.$speakerId;
        JSONObject r6 = this.$extraParams;
        if (r6 != null) goto L7;
        r6 = new JSONObject();
    L7:
        RealtimeCallParam r7 = this.$params;
        if (r7 == null) goto L12;
        ouc.d0 r8 = r7.r;
        if (r8 == null) goto L12;
        JSONObject r9 = com.larus.voicecall.impl.util.d.d(r8);
    L13:
        if (r9 == null) goto L19;
        Iterator<String> r10 = r9.keys();
        if (r10 == null) goto L19;
    L17:
        if (r10.hasNext() == false) goto L19;
        String r11 = r10.next();
        r6.put(r11, r9.opt(r11));
    L19:
        Unit r12 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.PARAMS_KEY);
        if (r14 != null) goto L42;
    L24:
        if (r0 == null) goto L26;
        r6.put("call_id", r0);     // Catch: JSONException -> L22
    L26:
        if (r1 == null) goto L28;
        r6.put("conversation_id", r1);     // Catch: JSONException -> L22
    L28:
        if (r2 == null) goto L30;
        r6.put("fail_reason", r2);     // Catch: JSONException -> L22
    L30:
        if (r3 == null) goto L32;
        r6.put("success", r3);     // Catch: JSONException -> L22
    L32:
        if (r5 == null) goto L34;
        r6.put("speaker_id", r5);     // Catch: JSONException -> L22
    L34:
        if (r4 == null) goto L38;
        r6.put("enter_method", r4);     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        FLogger.a.e("RaiseEventHelper", "error in RaiseEventHelper raiseCallStatus " + e.getLocalizedMessage());
    L38:
        TrackParams r15 = new TrackParams().merge(r6);
        by7.a r16 = new by7.a("raise_call_status");
        r16.a.merge(r15);
        r16.b();
        com.larus.platform.service.g.a.monitorEventForSlardar("raise_call_status", r16.c(), null, null);
        return Unit.INSTANCE;
    L42:
        r6.put("bot_id", r14);     // Catch: JSONException -> L22
    L12:
        r9 = null;
        goto L13
    L41:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
