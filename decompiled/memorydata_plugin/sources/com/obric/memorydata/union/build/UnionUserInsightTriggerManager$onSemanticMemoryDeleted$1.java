package com.obric.memorydata.union.build;

import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.union.build.UnionUserInsightTriggerManager$onSemanticMemoryDeleted$1", f = "UnionUserInsightTriggerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UnionUserInsightTriggerManager$onSemanticMemoryDeleted$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ip> $deletedItems;
    int label;

    UnionUserInsightTriggerManager$onSemanticMemoryDeleted$1(List<ip> r3, Continuation<? super UnionUserInsightTriggerManager$onSemanticMemoryDeleted$1> r4) {
        List<ip> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$deletedItems = r5;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new UnionUserInsightTriggerManager$onSemanticMemoryDeleted$1(this.$deletedItems, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((UnionUserInsightTriggerManager$onSemanticMemoryDeleted$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), UnionUserInsightTriggerManager$onSemanticMemoryDeleted$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r6);
        Ref.BooleanRef r7 = new Ref.BooleanRef();     // Catch: Exception -> L17
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.$deletedItems, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L17
    L7:
        if (r5.hasNext() == false) goto L14;
        ip r1 = (ip) ZeusTransformUtils.preCheckCast(r5.next(), ip.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        String r2 = r1.a();     // Catch: Exception -> L17
        String r3 = r1.b();     // Catch: Exception -> L17
        if (Intrinsics.areEqual(r2, "userinfo") == false) goto L12;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionUserInsightDao().deleteAll();     // Catch: Exception -> L17
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionUserPersonaDao().deleteAll();     // Catch: Exception -> L17
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().resetUseForInsightBySemanticType(r2);     // Catch: Exception -> L17
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().resetUseForPersonaBySemanticType(r2);     // Catch: Exception -> L17
    L11:
        r7.element = true;     // Catch: Exception -> L17
        goto L7
    L12:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionSemanticTypeSummaryDao().deleteByTypeAndTreePath(r2, r3);     // Catch: Exception -> L17
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().resetUseForInsightBySemanticTypeAndTagPath(r2, r3);     // Catch: Exception -> L17
        goto L11
    L14:
        if (r7.element == false) goto L20;
        s.f13110a.a();     // Catch: Exception -> L17
    L20:
        return Unit.INSTANCE;
    L17:
        e = move-exception;
        RunLog.INSTANCE.error("UnionUserInsightTriggerManager", "onSemanticMemoryDeleted error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L20
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
