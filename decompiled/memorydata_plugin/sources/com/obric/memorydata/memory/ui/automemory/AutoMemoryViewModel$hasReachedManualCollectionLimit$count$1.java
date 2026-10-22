package com.obric.memorydata.memory.ui.automemory;

import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$hasReachedManualCollectionLimit$count$1", f = "AutoMemoryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AutoMemoryViewModel$hasReachedManualCollectionLimit$count$1 extends SuspendLambda implements Function2<al, Continuation<? super Integer>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AutoMemoryViewModel this$0;

    AutoMemoryViewModel$hasReachedManualCollectionLimit$count$1(AutoMemoryViewModel r3, Continuation<? super AutoMemoryViewModel$hasReachedManualCollectionLimit$count$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        AutoMemoryViewModel$hasReachedManualCollectionLimit$count$1 r0 = new AutoMemoryViewModel$hasReachedManualCollectionLimit$count$1(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Integer> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Integer> r4) {
        return ((AutoMemoryViewModel$hasReachedManualCollectionLimit$count$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AutoMemoryViewModel$hasReachedManualCollectionLimit$count$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L44;
        ResultKt.throwOnFailure(r8);
        al r9 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        AutoMemoryViewModel r10 = this.this$0;
        int r1 = 0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L20
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().queryMyCollections(AutoMemoryViewModel.access$getMyCollectionExcludeSource(r10)), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L8;
    L10:
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L20
        int r4 = 0;
    L12:
        if (r12.hasNext() == false) goto L18;
        if ((!Intrinsics.areEqual(((MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r12.next(), MemoryRuleEntity.class, "com.obric.memorydata.plugin")).getSource(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE)) == false) goto L12;
        r4 = r4 + 1;     // Catch: Throwable -> L20
        if (r4 >= 0) goto L12;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L20
    L18:
        Object r13 = Result.m1421constructorimpl(Boxing.boxInt(r4));     // Catch: Throwable -> L20
    L22:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r13);
        if (r5 == null) goto L25;
        RunLog.INSTANCE.warn("AutoMemoryViewModel", "query manual collection count failed", r5);
    L25:
        AutoMemoryViewModel r7 = this.this$0;
        if (Result.m1424exceptionOrNullimpl(r13) == null) goto L61;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(((u) ZeusTransformUtils.preCheckCast(AutoMemoryViewModel.access$get_state$p(r7).c(), u.class, "com.obric.memorydata.plugin")).c(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L31;
    L33:
        Iterator r15 = r14.iterator();
    L35:
        if (r15.hasNext() == false) goto L42;
        if ((!Intrinsics.areEqual(((d) ZeusTransformUtils.preCheckCast(r15.next(), d.class, "com.obric.memorydata.plugin")).a().getSource(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE)) == false) goto L35;
        r1 = r1 + 1;
        if (r1 >= 0) goto L35;
        CollectionsKt.throwCountOverflow();
    L42:
        return Boxing.boxInt(r1);
    L31:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L33;
    L61:
        return r13;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
        r4 = 0;
    L20:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    L44:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
