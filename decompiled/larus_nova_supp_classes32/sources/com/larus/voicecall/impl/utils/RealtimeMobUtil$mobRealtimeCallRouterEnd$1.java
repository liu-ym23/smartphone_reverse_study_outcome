package com.larus.voicecall.impl.utils;

import android.text.TextUtils;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.utils.RealtimeMobUtil$mobRealtimeCallRouterEnd$1", f = "RealtimeMobUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeMobUtil$mobRealtimeCallRouterEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ String $reason;
    final /* synthetic */ String $trackParams;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;

    public RealtimeMobUtil$mobRealtimeCallRouterEnd$1(String r1, String r2, String r3, String r4, boolean r5, String r6, Continuation<? super RealtimeMobUtil$mobRealtimeCallRouterEnd$1> r7) {
        this.$url = r1;
        this.$enterMethod = r2;
        this.$botId = r3;
        this.$trackParams = r4;
        this.$isSuccess = r5;
        this.$reason = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        RealtimeMobUtil$mobRealtimeCallRouterEnd$1 r8 = new RealtimeMobUtil$mobRealtimeCallRouterEnd$1(this.$url, this.$enterMethod, this.$botId, this.$trackParams, this.$isSuccess, this.$reason, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        String r10 = this.$url;
        String r0 = this.$enterMethod;
        String r1 = this.$botId;
        String r2 = this.$trackParams;
        boolean r3 = this.$isSuccess;
        String r4 = this.$reason;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L15
        r6.put("scheme", r10);     // Catch: Throwable -> L15
        r6.put("enter_method", r0);     // Catch: Throwable -> L15
        r6.put("bot_id", r1);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r2) == true) goto L8;
        String r7 = "True";
    L9:
        r6.put("valid_track_params", r7);     // Catch: Throwable -> L15
        if (r3 == false) goto L12;
        String r11 = "Success";
    L13:
        r6.put("result", r11);     // Catch: Throwable -> L15
        r6.put("reason", r4);     // Catch: Throwable -> L15
        Object r12 = Result.constructor-impl(r6);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r12) == false) goto L20;
        r12 = null;
    L20:
        JSONObject r13 = (JSONObject) r12;
        FLogger r14 = FLogger.a;
        int r15 = RealtimeMobUtil.a;
        r14.i("RealtimeMobUtil", "mobRealtimeCallRouterEnd, params = " + r13);
        com.larus.platform.service.g.a.monitorEventForSlardar("voice_call_scheme_router_end", r13, null, null);
        return Unit.INSTANCE;
    L12:
        r11 = "Fail";
        goto L13
    L8:
        r7 = "False";
    L15:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
