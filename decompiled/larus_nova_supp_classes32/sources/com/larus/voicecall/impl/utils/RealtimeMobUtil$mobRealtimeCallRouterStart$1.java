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
@DebugMetadata(c = "com.larus.voicecall.impl.utils.RealtimeMobUtil$mobRealtimeCallRouterStart$1", f = "RealtimeMobUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeMobUtil$mobRealtimeCallRouterStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ String $trackParams;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;

    public RealtimeMobUtil$mobRealtimeCallRouterStart$1(String r1, String r2, String r3, String r4, Continuation<? super RealtimeMobUtil$mobRealtimeCallRouterStart$1> r5) {
        this.$url = r1;
        this.$enterMethod = r2;
        this.$botId = r3;
        this.$trackParams = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        RealtimeMobUtil$mobRealtimeCallRouterStart$1 r6 = new RealtimeMobUtil$mobRealtimeCallRouterStart$1(this.$url, this.$enterMethod, this.$botId, this.$trackParams, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        String r8 = this.$url;
        String r0 = this.$enterMethod;
        String r1 = this.$botId;
        String r2 = this.$trackParams;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L11
        r4.put("scheme", r8);     // Catch: Throwable -> L11
        r4.put("enter_method", r0);     // Catch: Throwable -> L11
        r4.put("bot_id", r1);     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r2) == true) goto L8;
        String r5 = "True";
    L9:
        r4.put("valid_track_params", r5);     // Catch: Throwable -> L11
        Object r9 = Result.constructor-impl(r4);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r9) == false) goto L16;
        r9 = null;
    L16:
        JSONObject r10 = (JSONObject) r9;
        FLogger r11 = FLogger.a;
        int r12 = RealtimeMobUtil.a;
        r11.i("RealtimeMobUtil", "mobRealtimeCallRouterStart, params = " + r10);
        com.larus.platform.service.g.a.monitorEventForSlardar("voice_call_scheme_router_start", r10, null, null);
        return Unit.INSTANCE;
    L8:
        r5 = "False";
    L11:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
