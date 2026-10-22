package com.obric.memorydata.memory.ui.settings.contextawareness;

import com.obric.aiproactive.api.DoubaoGlassesConnectionSnapshot;
import com.obric.aiproactive.api.DoubaoGlassesConnectionState;
import com.obric.aiproactive.api.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.u;
import kotlinx.coroutines.channels.w;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.contextawareness.DefaultContextAwarenessSettingsGateway$smartGlassesConnected$1", f = "ContextAwarenessSettingsGateway.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
final class DefaultContextAwarenessSettingsGateway$smartGlassesConnected$1 extends SuspendLambda implements Function2<w<? super Boolean>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    DefaultContextAwarenessSettingsGateway$smartGlassesConnected$1(Continuation<? super DefaultContextAwarenessSettingsGateway$smartGlassesConnected$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private static final void invokeSuspend$lambda$0(w r2, DoubaoGlassesConnectionSnapshot r3) {
        ((w) ZeusTransformUtils.wrapperContextForParams(r2, w.class, "com.obric.memorydata.plugin")).mo54trySendJP2dKIU(Boolean.valueOf(r3.getConnected()));
    }

    private static final Unit invokeSuspend$lambda$1(ab r2) {
        ab r3 = (ab) ZeusTransformUtils.wrapperContextForParams(r2, ab.class, "com.obric.memorydata.plugin");
        DoubaoGlassesConnectionState.INSTANCE.unregisterListener(r3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$7nK6pb9xt-WKL9xxWkhEXBtRHIc, reason: not valid java name */
    public static /* synthetic */ void m986lambda$7nK6pb9xtWKL9xxWkhEXBtRHIc(w r0, DoubaoGlassesConnectionSnapshot r1) {
        invokeSuspend$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Tv9nQAtYa928uC2bdq0iOoT-1Bc, reason: not valid java name */
    public static /* synthetic */ Unit m987lambda$Tv9nQAtYa928uC2bdq0iOoT1Bc(ab r0) {
        return invokeSuspend$lambda$1(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DefaultContextAwarenessSettingsGateway$smartGlassesConnected$1 r4 = new DefaultContextAwarenessSettingsGateway$smartGlassesConnected$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(w<? super Boolean> r3, Continuation<? super Unit> r4) {
        return invoke2((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(w<? super Boolean> r3, Continuation<? super Unit> r4) {
        return ((DefaultContextAwarenessSettingsGateway$smartGlassesConnected$1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DefaultContextAwarenessSettingsGateway$smartGlassesConnected$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        final w r10 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        final ab r2 = new $$Lambda$DefaultContextAwarenessSettingsGateway$smartGlassesConnected$1$7nK6pb9xtWKL9xxWkhEXBtRHIc(r10);
        DoubaoGlassesConnectionState.registerListener$default(DoubaoGlassesConnectionState.INSTANCE, r2, false, 2, null);
        r10.mo54trySendJP2dKIU(Boxing.boxBoolean(DoubaoGlassesConnectionState.INSTANCE.currentSnapshot().getConnected()));
        Function0 r4 = new $$Lambda$DefaultContextAwarenessSettingsGateway$smartGlassesConnected$1$Tv9nQAtYa928uC2bdq0iOoT1Bc(r2);
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (u.a(r10, r4, r3) != r0) goto L12;
        return r0;
    }
}
