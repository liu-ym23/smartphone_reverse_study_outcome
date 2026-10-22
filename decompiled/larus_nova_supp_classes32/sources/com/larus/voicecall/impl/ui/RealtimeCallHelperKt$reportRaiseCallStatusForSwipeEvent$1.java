package com.larus.voicecall.impl.ui;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
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
@DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallHelperKt$reportRaiseCallStatusForSwipeEvent$1", f = "RealtimeCallHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallHelperKt$reportRaiseCallStatusForSwipeEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $failReason;
    final /* synthetic */ String $success;
    int label;

    public RealtimeCallHelperKt$reportRaiseCallStatusForSwipeEvent$1(String r1, String r2, String r3, String r4, Continuation<? super RealtimeCallHelperKt$reportRaiseCallStatusForSwipeEvent$1> r5) {
        this.$botId = r1;
        this.$conversationId = r2;
        this.$failReason = r3;
        this.$success = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new RealtimeCallHelperKt$reportRaiseCallStatusForSwipeEvent$1(this.$botId, this.$conversationId, this.$failReason, this.$success, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r6);
        String r7 = this.$botId;
        String r0 = this.$conversationId;
        String r1 = this.$failReason;
        String r2 = this.$success;
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        if (r7 != null) goto L21;
    L9:
        if (r0 == null) goto L11;
        r3.put("conversation_id", r0);     // Catch: JSONException -> L7
    L11:
        if (r1 == null) goto L13;
        r3.put("fail_reason", r1);     // Catch: JSONException -> L7
    L13:
        if (r2 == null) goto L17;
        r3.put("success", r2);     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        FLogger.a.e("RaiseForSwipeEventHelper", "error in RaiseForSwipeEventHelper raiseCallStatus " + e.getLocalizedMessage());
    L17:
        TrackParams r8 = new TrackParams().merge(r3);
        by7.a r4 = new by7.a("raise_call_status_for_swipe");
        r4.a.merge(r8);
        r4.b();
        return Unit.INSTANCE;
    L21:
        r3.put("bot_id", r7);     // Catch: JSONException -> L7
        goto L9
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
