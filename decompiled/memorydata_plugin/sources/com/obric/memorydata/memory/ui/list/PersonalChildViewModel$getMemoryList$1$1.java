package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.ig;
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
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildViewModel$getMemoryList$1$1", f = "PersonalChildViewModel.kt", i = {}, l = {157, 161}, m = "invokeSuspend", n = {}, s = {})
final class PersonalChildViewModel$getMemoryList$1$1 extends SuspendLambda implements Function2<com.obric.memorydata.database.entity.d, Continuation<? super Iterable<? extends com.obric.memorydata.memory.ui.data.a.h>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    PersonalChildViewModel$getMemoryList$1$1(Continuation<? super PersonalChildViewModel$getMemoryList$1$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        PersonalChildViewModel$getMemoryList$1$1 r4 = new PersonalChildViewModel$getMemoryList$1$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(com.obric.memorydata.database.entity.d r3, Continuation<? super Iterable<com.obric.memorydata.memory.ui.data.a.h>> r4) {
        return ((PersonalChildViewModel$getMemoryList$1$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PersonalChildViewModel$getMemoryList$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(com.obric.memorydata.database.entity.d r3, Continuation<? super Iterable<? extends com.obric.memorydata.memory.ui.data.a.h>> r4) {
        return invoke2((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L23:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L26;
        return r12;
    L26:
        return CollectionsKt.emptyList();
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
    L27:
        return (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
    L10:
        ResultKt.throwOnFailure(r13);
        com.obric.memorydata.database.entity.d r14 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, RawMemoryEntity.class) == false) goto L17;
        PersonalChildViewModel.a r5 = PersonalChildViewModel.Companion;
        RawMemoryEntity r6 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r14, RawMemoryEntity.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r13 = PersonalChildViewModel.a.a(r5, r6, 0, r9, 1, null);
        if (r13 != r0) goto L27;
        return r0;
    L17:
        if (ZeusTransformUtils.instanceOf(r14, ig.class) == false) goto L26;
        RawMemoryEntity r7 = ((ig) ZeusTransformUtils.preCheckCast(r14, ig.class, "com.obric.memorydata.plugin")).c();
        if (r7 == null) goto L26;
        PersonalChildViewModel.a r8 = PersonalChildViewModel.Companion;
        Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        r13 = PersonalChildViewModel.a.a(r8, r7, 0, r10, 1, null);
        if (r13 != r0) goto L23;
        return r0;
    }
}
