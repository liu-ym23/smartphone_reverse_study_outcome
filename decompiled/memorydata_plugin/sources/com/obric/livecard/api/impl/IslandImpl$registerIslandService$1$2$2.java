package com.obric.livecard.api.impl;

import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.entity.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$registerIslandService$1$2$2", f = "IslandImpl.kt", i = {0}, l = {359}, m = "invokeSuspend", n = {"$this$withLock$iv"}, s = {"L$0"})
final class IslandImpl$registerIslandService$1$2$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ IslandImpl this$0;

    IslandImpl$registerIslandService$1$2$2(IslandImpl r3, Continuation<? super IslandImpl$registerIslandService$1$2$2> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandImpl$registerIslandService$1$2$2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandImpl$registerIslandService$1$2$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandImpl$registerIslandService$1$2$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        IslandImpl r2 = (IslandImpl) ZeusTransformUtils.preCheckCast(this.L$1, IslandImpl.class, "com.obric.memorydata.plugin");
        a r7 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L24:
        Iterator r9 = ((Map) ZeusTransformUtils.preCheckCast(r2.getMSessionMap(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();     // Catch: Throwable -> L21
    L14:
        if (r9.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        IslandCardCallback r5 = ((IslandSession) ZeusTransformUtils.preCheckCast(r3.getKey(), IslandSession.class, "com.obric.memorydata.plugin")).getCallback();     // Catch: Throwable -> L21
        if (r5 == null) goto L14;
        r5.onSessionDestroy((IslandSession) ZeusTransformUtils.preCheckCast(r3.getKey(), IslandSession.class, "com.obric.memorydata.plugin"), Boxing.boxInt(1));     // Catch: Throwable -> L21
        goto L14
    L18:
        r2.getMSessionMap().clear();     // Catch: Throwable -> L21
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L21
        r7.b(null);
        return Unit.INSTANCE;
    L21:
        th = move-exception;
        r7.b(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        a r11 = IslandImpl.access$getSessionLock$p(this.this$0);
        IslandImpl r4 = this.this$0;
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r11;
        this.L$1 = r4;
        this.label = 1;
        if (r11.a(null, r6) != r0) goto L11;
        return r0;
    L11:
        r7 = r11;
        r2 = r4;
        goto L24
    }
}
