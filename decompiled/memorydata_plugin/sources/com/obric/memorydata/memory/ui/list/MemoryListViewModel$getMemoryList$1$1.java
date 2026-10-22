package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.bo;
import com.obric.memorydata.database.entity.ig;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.iq;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$ListEntity;", "rawEntity", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListViewModel$getMemoryList$1$1", f = "MemoryListViewModel.kt", i = {}, l = {179, 183, 187, 193}, m = "invokeSuspend", n = {}, s = {})
final class MemoryListViewModel$getMemoryList$1$1 extends SuspendLambda implements Function2<com.obric.memorydata.database.entity.d, Continuation<? super Iterable<? extends com.obric.memorydata.memory.ui.data.a.h>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    MemoryListViewModel$getMemoryList$1$1(Continuation<? super MemoryListViewModel$getMemoryList$1$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        MemoryListViewModel$getMemoryList$1$1 r4 = new MemoryListViewModel$getMemoryList$1$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(com.obric.memorydata.database.entity.d r3, Continuation<? super Iterable<com.obric.memorydata.memory.ui.data.a.h>> r4) {
        return ((MemoryListViewModel$getMemoryList$1$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryListViewModel$getMemoryList$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(com.obric.memorydata.database.entity.d r3, Continuation<? super Iterable<? extends com.obric.memorydata.memory.ui.data.a.h>> r4) {
        return invoke2((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 == 4) goto L13;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r15);
    L37:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L47;
        return r14;
    L47:
        return CollectionsKt.emptyList();
    L12:
        ResultKt.throwOnFailure(r15);
    L27:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L47;
        return r16;
    L13:
        ResultKt.throwOnFailure(r15);
    L45:
        return (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
    L14:
        ResultKt.throwOnFailure(r15);
        com.obric.memorydata.database.entity.d r17 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, RawMemoryEntity.class) == false) goto L21;
        MemoryListViewModel.a r7 = MemoryListViewModel.Companion;
        RawMemoryEntity r8 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r17, RawMemoryEntity.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r15 = MemoryListViewModel.a.a(r7, r8, 0, r11, 1, null);
        if (r15 != r0) goto L45;
        return r0;
    L21:
        if (ZeusTransformUtils.instanceOf(r17, bo.class) == false) goto L31;
        RawMemoryEntity r9 = ((bo) ZeusTransformUtils.preCheckCast(r17, bo.class, "com.obric.memorydata.plugin")).a();
        if (r9 == null) goto L47;
        MemoryListViewModel.a r10 = MemoryListViewModel.Companion;
        Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        r15 = MemoryListViewModel.a.a(r10, r9, 0, r12, 1, null);
        if (r15 != r0) goto L27;
        return r0;
    L31:
        if (ZeusTransformUtils.instanceOf(r17, ig.class) == false) goto L41;
        RawMemoryEntity r13 = ((ig) ZeusTransformUtils.preCheckCast(r17, ig.class, "com.obric.memorydata.plugin")).c();
        if (r13 == null) goto L47;
        MemoryListViewModel.a r18 = MemoryListViewModel.Companion;
        Continuation r19 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 3;
        r15 = MemoryListViewModel.a.a(r18, r13, 0, r19, 1, null);
        if (r15 != r0) goto L37;
        return r0;
    L41:
        if (ZeusTransformUtils.instanceOf(r17, ip.class) == false) goto L47;
        MemoryListViewModel.a r20 = MemoryListViewModel.Companion;
        RawMemoryEntity r21 = iq.a((ip) ZeusTransformUtils.preCheckCast(r17, ip.class, "com.obric.memorydata.plugin"), 0);
        Continuation r110 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 4;
        r15 = MemoryListViewModel.a.a(r20, r21, 0, r110, 1, null);
        if (r15 != r0) goto L45;
        return r0;
    }
}
