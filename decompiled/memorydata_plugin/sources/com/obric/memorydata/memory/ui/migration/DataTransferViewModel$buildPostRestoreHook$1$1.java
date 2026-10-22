package com.obric.memorydata.memory.ui.migration;

import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.migration.DataTransferViewModel$buildPostRestoreHook$1$1", f = "DataTransferViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DataTransferViewModel$buildPostRestoreHook$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    DataTransferViewModel$buildPostRestoreHook$1$1(Continuation<? super DataTransferViewModel$buildPostRestoreHook$1$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private static final void invokeSuspend$cleanupShortMemory(al r5, int r6, Set<Integer> r7) {
        al r8 = (al) ZeusTransformUtils.wrapperContextForParams(r5, al.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        int r10 = 0;
    L20:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.m1421constructorimpl(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryWithLimitAndOffset(r6, r10));     // Catch: Throwable -> L5
    L7:
        List r2 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r1) == false) goto L10;
        r1 = r2;
    L10:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == true) goto L19;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r4.hasNext() == false) goto L18;
        EpisodicMemoryEntity r11 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r4.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        if (r9.contains(Integer.valueOf(r11.getProductType())) == false) goto L14;
        r11.delete();
        goto L14
    L18:
        r10 = r10 + r3.size();
        goto L20
    L19:
        return;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final void invokeSuspend$cleanupUnionSemanticMemory(al r5, int r6, Set<Integer> r7) {
        al r8 = (al) ZeusTransformUtils.wrapperContextForParams(r5, al.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        int r10 = 0;
    L20:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.m1421constructorimpl(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryWithLimitAndOffset(r6, r10));     // Catch: Throwable -> L5
    L7:
        List r2 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r1) == false) goto L10;
        r1 = r2;
    L10:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == true) goto L19;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r4.hasNext() == false) goto L18;
        ip r11 = (ip) ZeusTransformUtils.preCheckCast(r4.next(), ip.class, "com.obric.memorydata.plugin");
        if (r9.contains(Integer.valueOf(r11.i())) == false) goto L14;
        r11.delete();
        goto L14
    L18:
        r10 = r10 + r3.size();
        goto L20
    L19:
        return;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DataTransferViewModel$buildPostRestoreHook$1$1 r4 = new DataTransferViewModel$buildPostRestoreHook$1$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((DataTransferViewModel$buildPostRestoreHook$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DataTransferViewModel$buildPostRestoreHook$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r4);
        al r3 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        boolean r5 = DataTransferViewModel.b.a(DataTransferViewModel.Companion);
        boolean r1 = DataTransferViewModel.b.b(DataTransferViewModel.Companion);
        Set r2 = SetsKt.createSetBuilder();
        if (r5 == true) goto L7;
        r2.add(Boxing.boxInt(1001));
        r2.add(Boxing.boxInt(0));
    L7:
        if (r1 == true) goto L9;
        r2.add(Boxing.boxInt(1004));
    L9:
        Set r6 = SetsKt.build(r2);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L12;
        invokeSuspend$cleanupShortMemory(r3, 200, r6);
        invokeSuspend$cleanupUnionSemanticMemory(r3, 200, r6);
    L12:
        if (r1 == true) goto L15;
        EntityManager.INSTANCE.deleteAllByEntityType(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED);
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
