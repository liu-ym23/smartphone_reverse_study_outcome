package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryWidgetProvider$Companion$loadFreshData$2", f = "MemoryWidgetProvider.kt", i = {0}, l = {252, 252}, m = "invokeSuspend", n = {"latestDeferred"}, s = {"L$0"})
final class MemoryWidgetProvider$Companion$loadFreshData$2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Pair<? extends List<? extends RawMemoryEntity>, ? extends List<? extends RawMemoryEntity>>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    MemoryWidgetProvider$Companion$loadFreshData$2(Continuation<? super MemoryWidgetProvider$Companion$loadFreshData$2> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        MemoryWidgetProvider$Companion$loadFreshData$2 r4 = new MemoryWidgetProvider$Companion$loadFreshData$2((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Pair<? extends List<? extends RawMemoryEntity>, ? extends List<? extends RawMemoryEntity>>> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Pair<? extends List<RawMemoryEntity>, ? extends List<RawMemoryEntity>>> r4) {
        return ((MemoryWidgetProvider$Companion$loadFreshData$2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryWidgetProvider$Companion$loadFreshData$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L10;
        Object r13 = this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L25
    L23:
        return new Pair(r13, r14);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        kotlinx.coroutines.ar r2 = (kotlinx.coroutines.ar) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.ar.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L25
    L19:
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L25
        this.L$0 = r14;     // Catch: Exception -> L25
        this.label = 2;     // Catch: Exception -> L25
        Object r15 = r2.a(r3);     // Catch: Exception -> L25
        if (r15 != r0) goto L22;
        return r0;
    L22:
        Object r12 = r14;
        r14 = r15;
        r13 = r12;
        goto L23
    L14:
        ResultKt.throwOnFailure(r14);
        kotlinx.coroutines.al r16 = (kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.ar r4 = kotlinx.coroutines.i.b(r16, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryWidgetProvider$Companion$loadFreshData$2$timeSensitiveDeferred$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.ar r17 = kotlinx.coroutines.i.b(r16, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryWidgetProvider$Companion$loadFreshData$2$latestDeferred$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L25
        this.L$0 = r17;     // Catch: Exception -> L25
        this.label = 1;     // Catch: Exception -> L25
        Object r6 = r4.a(r5);     // Catch: Exception -> L25
        if (r6 != r0) goto L18;
        return r0;
    L18:
        r2 = r17;
        r14 = r6;
    L25:
        e = move-exception;
        RunLog.INSTANCE.error("MemoryWidgetProvider", "database query failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
