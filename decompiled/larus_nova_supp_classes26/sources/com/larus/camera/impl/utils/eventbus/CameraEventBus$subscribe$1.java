package com.larus.camera.impl.utils.eventbus;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "Lcom/larus/camera/impl/utils/eventbus/Event;", "it"}, k = 3, mv = {2, 1, 0}, xi = 176)
@DebugMetadata(c = "com.larus.camera.impl.utils.eventbus.CameraEventBus$subscribe$1", f = "CameraEventBus.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CameraEventBus$subscribe$1 extends SuspendLambda implements Function2<g, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<g, Unit> $onEachBlock;
    /* synthetic */ Object L$0;
    int label;

    public CameraEventBus$subscribe$1(Function1<g, Unit> r1, Continuation<? super CameraEventBus$subscribe$1> r2) {
        this.$onEachBlock = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.needClassReification();
        CameraEventBus$subscribe$1 r0 = new CameraEventBus$subscribe$1(this.$onEachBlock, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(g r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((g) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        g r3 = (g) this.L$0;
        this.$onEachBlock.invoke(r3);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invokeSuspend$$forInline(Object r2) {
        g r3 = (g) this.L$0;
        InlineMarker.mark(10);
        this.$onEachBlock.invoke(r3);
        return Unit.INSTANCE;
    }
}
