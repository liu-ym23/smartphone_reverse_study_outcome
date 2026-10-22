package com.larus.ui.arch.vm.internal;

import com.tencent.open.log.TraceLevel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "", "it"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentVMFlowExtKt$collectLatest$flow$1", f = "ComponentVMFlowExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ComponentVMFlowExtKt$collectLatest$flow$1 extends SuspendLambda implements Function2<Object, Continuation<? super Boolean>, Object> {
    final /* synthetic */ w1a.d $deliveryMode;
    final /* synthetic */ ConcurrentHashMap<String, Object> $lastDeliveredStates;
    /* synthetic */ Object L$0;
    int label;

    public ComponentVMFlowExtKt$collectLatest$flow$1(ConcurrentHashMap<String, Object> r1, w1a.d r2, Continuation<? super ComponentVMFlowExtKt$collectLatest$flow$1> r3) {
        this.$lastDeliveredStates = r1;
        this.$deliveryMode = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ComponentVMFlowExtKt$collectLatest$flow$1 r0 = new ComponentVMFlowExtKt$collectLatest$flow$1(this.$lastDeliveredStates, this.$deliveryMode, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(r1, (Continuation) r2);
    }

    public final Object invoke(Object r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r3);
        Object r4 = this.L$0;
        if (this.$lastDeliveredStates.containsKey(((w1a.h) this.$deliveryMode).a) == true) goto L7;
    L9:
        boolean r5 = false;
    L11:
        return Boxing.boxBoolean(r5);
    L7:
        if (Intrinsics.areEqual(r4, this.$lastDeliveredStates.get(((w1a.h) this.$deliveryMode).a)) == false) goto L9;
        r5 = true;
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
