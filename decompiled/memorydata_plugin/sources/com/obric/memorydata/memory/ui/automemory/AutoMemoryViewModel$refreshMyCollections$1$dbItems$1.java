package com.obric.memorydata.memory.ui.automemory;

import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionCardItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$refreshMyCollections$1$dbItems$1", f = "AutoMemoryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AutoMemoryViewModel$refreshMyCollections$1$dbItems$1 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends d>>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AutoMemoryViewModel this$0;

    AutoMemoryViewModel$refreshMyCollections$1$dbItems$1(AutoMemoryViewModel r3, Continuation<? super AutoMemoryViewModel$refreshMyCollections$1$dbItems$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        AutoMemoryViewModel$refreshMyCollections$1$dbItems$1 r0 = new AutoMemoryViewModel$refreshMyCollections$1$dbItems$1(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends d>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super List<d>> r4) {
        return ((AutoMemoryViewModel$refreshMyCollections$1$dbItems$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AutoMemoryViewModel$refreshMyCollections$1$dbItems$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r38) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r38);
        al r1 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        AutoMemoryViewModel r0 = this.this$0;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().queryMyCollections(AutoMemoryViewModel.access$getMyCollectionExcludeSource(r0)), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L11
    L7:
        if (r5.hasNext() == false) goto L9;
        MemoryRuleEntity r6 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r5.next(), MemoryRuleEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        long r15 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryByRuleId(r6.getId());     // Catch: Throwable -> L11
        long r13 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryNewCountByRuleId(r6.getId(), r6.getLastExposedAutoMemoryId());     // Catch: Throwable -> L11
        r4.add(new d(MemoryRuleEntity.copy$default(r6, 0, null, null, null, null, null, null, null, false, r15, null, null, null, null, false, false, false, false, 0, 0, 0, null, null, null, 0, 33553919, null), r13));     // Catch: Throwable -> L11
        goto L7
    L9:
        Object r7 = Result.m1421constructorimpl((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
    L13:
        List r8 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r7) == true) goto L16;
        return r7;
    L16:
        return r8;
    L11:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
