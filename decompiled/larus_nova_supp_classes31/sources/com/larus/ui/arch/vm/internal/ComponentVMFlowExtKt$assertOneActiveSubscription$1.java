package com.larus.ui.arch.vm.internal;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentVMFlowExtKt$assertOneActiveSubscription$1", f = "ComponentVMFlowExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ComponentVMFlowExtKt$assertOneActiveSubscription$1 extends SuspendLambda implements Function3<FlowCollector<Object>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set<String> $activeSubscriptions;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ ComponentVMFlowExtKt$assertOneActiveSubscription$observer$1 $observer;
    final /* synthetic */ String $subscriptionId;
    int label;

    public ComponentVMFlowExtKt$assertOneActiveSubscription$1(Set<String> r1, String r2, LifecycleOwner r3, ComponentVMFlowExtKt$assertOneActiveSubscription$observer$1 r4, Continuation<? super ComponentVMFlowExtKt$assertOneActiveSubscription$1> r5) {
        this.$activeSubscriptions = r1;
        this.$subscriptionId = r2;
        this.$lifecycleOwner = r3;
        this.$observer = r4;
        super(3, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((FlowCollector) r1, (Throwable) r2, (Continuation) r3);
    }

    public final Object invoke(FlowCollector<Object> r7, Throwable r8, Continuation<? super Unit> r9) {
        return new ComponentVMFlowExtKt$assertOneActiveSubscription$1(this.$activeSubscriptions, this.$subscriptionId, this.$lifecycleOwner, this.$observer, r9).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        this.$activeSubscriptions.remove(this.$subscriptionId);
        this.$lifecycleOwner.getLifecycle().removeObserver(this.$observer);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
