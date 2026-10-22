package com.obric.assistant.dora;

import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.common.ErrorCode;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.dora.DoraMainProcessBridgeService$binder$1$checkBindAndConnectIfNecessaryAsync$1", f = "DoraMainProcessBridgeService.kt", i = {0}, l = {ErrorCode.APP_VERSION_TOO_LOW}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class DoraMainProcessBridgeService$binder$1$checkBindAndConnectIfNecessaryAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IDoraMainProcessConnectCallback $callback;
    final /* synthetic */ String $requestId;
    final /* synthetic */ DoraDeviceInfo $safeDeviceInfo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoraMainProcessBridgeService this$0;

    public DoraMainProcessBridgeService$binder$1$checkBindAndConnectIfNecessaryAsync$1(DoraMainProcessBridgeService r1, DoraDeviceInfo r2, String r3, IDoraMainProcessConnectCallback r4, Continuation<? super DoraMainProcessBridgeService$binder$1$checkBindAndConnectIfNecessaryAsync$1> r5) {
        this.this$0 = r1;
        this.$safeDeviceInfo = r2;
        this.$requestId = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        DoraMainProcessBridgeService$binder$1$checkBindAndConnectIfNecessaryAsync$1 r6 = new DoraMainProcessBridgeService$binder$1$checkBindAndConnectIfNecessaryAsync$1(this.this$0, this.$safeDeviceInfo, this.$requestId, this.$callback, r9);
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
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r6);
    L11:
        DoraMainProcessConnectResult r7 = (DoraMainProcessConnectResult) r6;
        IDoraMainProcessConnectCallback r3 = this.$callback;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        if (r3 == null) goto L15;
        r3.onConnectResult(r7);     // Catch: Throwable -> L18
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L18
    L20:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L24;
        FLogger.a.e("DoraMainProcessBridge", "checkBindAndConnectIfNecessaryAsync callback failed: " + r10.getMessage());
    L24:
        return Unit.INSTANCE;
    L15:
        r8 = null;
    L18:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        DoraMainProcessBridgeService r12 = this.this$0;
        DoraDeviceInfo r13 = this.$safeDeviceInfo;
        String r14 = this.$requestId;
        this.L$0 = r11;
        this.label = 1;
        r6 = DoraMainProcessBridgeService.a(r12, r13, r14, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
