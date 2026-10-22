package com.obric.assistant.ipc;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.IpcMessenger$traceData$2$1", f = "IpcMessenger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class IpcMessenger$traceData$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $payload;
    final /* synthetic */ String $u;
    final /* synthetic */ Ref.ObjectRef<String> $wakeupStage;
    final /* synthetic */ Ref.BooleanRef $wakeupSuccess;
    int label;

    public IpcMessenger$traceData$2$1(String r1, Ref.ObjectRef<String> r2, Ref.BooleanRef r3, JSONObject r4, Continuation<? super IpcMessenger$traceData$2$1> r5) {
        this.$u = r1;
        this.$wakeupStage = r2;
        this.$wakeupSuccess = r3;
        this.$payload = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new IpcMessenger$traceData$2$1(this.$u, this.$wakeupStage, this.$wakeupSuccess, this.$payload, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        Lazy r5 = com.obric.assistant.common.utils.s.a;
        com.obric.assistant.common.utils.s.e(this.$u, (String) this.$wakeupStage.element, this.$wakeupSuccess.element, this.$payload);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
