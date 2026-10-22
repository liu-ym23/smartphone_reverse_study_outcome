package com.obric.memorydata.memory.ui.list;

import com.obric.aiproactive.api.DoubaoGlassesConnectionSnapshot;
import com.obric.aiproactive.api.DoubaoGlassesConnectionState;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.GlassesMemoryTabState$connectionHistoryChanges$1", f = "GlassesMemoryTabState.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
final class GlassesMemoryTabState$connectionHistoryChanges$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.w<? super Boolean>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    GlassesMemoryTabState$connectionHistoryChanges$1(Continuation<? super GlassesMemoryTabState$connectionHistoryChanges$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private static final void invokeSuspend$lambda$0(kotlinx.coroutines.channels.w r2, DoubaoGlassesConnectionSnapshot r3) {
        ((kotlinx.coroutines.channels.w) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin")).mo54trySendJP2dKIU(Boolean.valueOf(r3.getEverConnected()));
    }

    private static final Unit invokeSuspend$lambda$1(com.obric.aiproactive.api.ab r2) {
        com.obric.aiproactive.api.ab r3 = (com.obric.aiproactive.api.ab) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiproactive.api.ab.class, "com.obric.memorydata.plugin");
        DoubaoGlassesConnectionState.INSTANCE.unregisterListener(r3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void lambda$nlJVj_41S1Bdj_L8XeJUNk36pU0(kotlinx.coroutines.channels.w r0, DoubaoGlassesConnectionSnapshot r1) {
        invokeSuspend$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit lambda$v4s8F4oRQVlEdJ8xitPwXCKqsZU(com.obric.aiproactive.api.ab r0) {
        return invokeSuspend$lambda$1(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        GlassesMemoryTabState$connectionHistoryChanges$1 r4 = new GlassesMemoryTabState$connectionHistoryChanges$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.channels.w<? super Boolean> r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.channels.w) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.channels.w<? super Boolean> r3, Continuation<? super Unit> r4) {
        return ((GlassesMemoryTabState$connectionHistoryChanges$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.channels.w) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), GlassesMemoryTabState$connectionHistoryChanges$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
        final kotlinx.coroutines.channels.w r10 = (kotlinx.coroutines.channels.w) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        final com.obric.aiproactive.api.ab r2 = new $$Lambda$GlassesMemoryTabState$connectionHistoryChanges$1$nlJVj_41S1Bdj_L8XeJUNk36pU0(r10);
        DoubaoGlassesConnectionState.registerListener$default(DoubaoGlassesConnectionState.INSTANCE, r2, false, 2, null);
        r10.mo54trySendJP2dKIU(Boxing.boxBoolean(DoubaoGlassesConnectionState.INSTANCE.hasEverConnected()));
        Function0 r4 = new $$Lambda$GlassesMemoryTabState$connectionHistoryChanges$1$v4s8F4oRQVlEdJ8xitPwXCKqsZU(r2);
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (kotlinx.coroutines.channels.u.a(r10, r4, r3) != r0) goto L12;
        return r0;
    }
}
