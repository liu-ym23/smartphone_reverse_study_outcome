package com.obric.aikernel.phx.core.conn;

import com.obric.aikernel.core.log.AIKLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.j;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.core.conn.BinderMonitor$monitorTransact$job$1", f = "BinderMonitor.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class BinderMonitor$monitorTransact$job$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $ctx;
    final /* synthetic */ Ref.ObjectRef<BinderMonitor.BinderInfo> $info;
    final /* synthetic */ Function0<Unit> $onDied;
    private /* synthetic */ Object L$0;
    int label;

    BinderMonitor$monitorTransact$job$1(Ref.ObjectRef<BinderMonitor.BinderInfo> r3, CoroutineContext r4, Function0<Unit> r5, Continuation<? super BinderMonitor$monitorTransact$job$1> r6) {
        CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$info = r3;
        this.$ctx = r7;
        this.$onDied = r8;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        BinderMonitor$monitorTransact$job$1 r0 = new BinderMonitor$monitorTransact$job$1(this.$info, this.$ctx, this.$onDied, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((BinderMonitor$monitorTransact$job$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), BinderMonitor$monitorTransact$job$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r9);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        final al r10 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        BinderMonitor.BinderInfo r2 = (BinderMonitor.BinderInfo) ZeusTransformUtils.preCheckCast(this.$info.element, BinderMonitor.BinderInfo.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L18;
        ae<Boolean> r3 = r2.getStateFlow();
        if (r3 == null) goto L18;
        AIKLog.INSTANCE.d("BinderMonitor", "monitorTransact: register onDied stateFlow: " + this.$ctx);
        final CoroutineContext r5 = this.$ctx;
        final Function0<Unit> r6 = this.$onDied;
        j<? super Boolean> r11 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r10, r5, r6), j.class, "com.obric.memorydata.plugin");
        Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r3.collect(r11, r4) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
