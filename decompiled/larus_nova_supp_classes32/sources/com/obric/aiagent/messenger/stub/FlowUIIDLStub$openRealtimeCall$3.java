package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IOpenRealTimeCallCallbackIDL;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.audio.CallType;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.FlowUIIDLStub$openRealtimeCall$3", f = "FlowUIIDLStub.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
public final class FlowUIIDLStub$openRealtimeCall$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CallType $callTypeEnum;
    final /* synthetic */ IOpenRealTimeCallCallbackIDL $callback;
    int label;
    final /* synthetic */ FlowUIIDLStub this$0;

    public FlowUIIDLStub$openRealtimeCall$3(FlowUIIDLStub r1, CallType r2, IOpenRealTimeCallCallbackIDL r3, Continuation<? super FlowUIIDLStub$openRealtimeCall$3> r4) {
        this.this$0 = r1;
        this.$callTypeEnum = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowUIIDLStub$openRealtimeCall$3(this.this$0, this.$callTypeEnum, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L13:
        com.obric.assistant.spi.audio.a r14 = (com.obric.assistant.spi.audio.a) r13;
    L15:
        FLogger r2 = FLogger.a;
        StringBuilder r4 = new StringBuilder("launchRealtimeCall result: ");
        if (r14 == null) goto L18;
        Integer r5 = Boxing.boxInt(r14.a);
    L19:
        r4.append(r5);
        r4.append(", ");
        if (r14 == null) goto L22;
        String r6 = r14.b;
    L23:
        r4.append(r6);
        r2.i("FlowUIIDLStub", r4.toString());
        IOpenRealTimeCallCallbackIDL r7 = this.$callback;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L36
        if (r7 == null) goto L34;
        if (r14 == null) goto L28;
        int r9 = r14.a;     // Catch: Throwable -> L36
    L29:
        if (r14 == null) goto L31;
        r3 = r14.b;     // Catch: Throwable -> L36
    L31:
        if (r3 != null) goto L33;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L33:
        r7.onResultWithMsg(r9, r3);     // Catch: Throwable -> L36
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L36
        goto L34
    L28:
        r9 = 4;
    L34:
        Object r15 = Result.constructor-impl(r3);     // Catch: Throwable -> L36
    L38:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L42;
        FLogger.a.e("FlowUIIDLStub", "openRealtimeCall: ipc failed", r16);
    L42:
        return Unit.INSTANCE;
    L36:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L22:
        r6 = null;
        goto L23
    L18:
        r5 = null;
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        IObricRealtimeCallExtService r11 = FlowUIIDLStub.access$getObricRealtimeCallService(this.this$0);
        if (r11 == null) goto L14;
        CallType r12 = this.$callTypeEnum;
        this.label = 1;
        r13 = IObricRealtimeCallExtService.a.a(r11, r12, "obric_intent", 1000, null, this, 8);
        if (r13 != r0) goto L13;
        return r0;
    L14:
        r14 = null;
        goto L15
    }
}
