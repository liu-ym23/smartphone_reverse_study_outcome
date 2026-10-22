package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.common.utils.FunctionsKt;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.FlowUIIDLStub$shouldDowngradeAuthForDora$2", f = "FlowUIIDLStub.kt", i = {}, l = {657}, m = "invokeSuspend", n = {}, s = {})
public final class FlowUIIDLStub$shouldDowngradeAuthForDora$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IDowngradeAuthForDoraCallbackIDL $callback;
    final /* synthetic */ AtomicBoolean $isCallbackInvoked;
    int label;

    public FlowUIIDLStub$shouldDowngradeAuthForDora$2(AtomicBoolean r1, IDowngradeAuthForDoraCallbackIDL r2, Continuation<? super FlowUIIDLStub$shouldDowngradeAuthForDora$2> r3) {
        this.$isCallbackInvoked = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowUIIDLStub$shouldDowngradeAuthForDora$2(this.$isCallbackInvoked, this.$callback, r4);
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
        ResultKt.throwOnFailure(r6);
    L12:
        if (this.$isCallbackInvoked.compareAndSet(false, true) == false) goto L15;
        FLogger.a.i("FlowUIIDLStub", "shouldDowngradeAuthForDora timeout, invoke onNotDowngrade");
        final IDowngradeAuthForDoraCallbackIDL r7 = this.$callback;
        FunctionsKt.a(new g0(r7));
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L12;
        return r0;
    }
}
