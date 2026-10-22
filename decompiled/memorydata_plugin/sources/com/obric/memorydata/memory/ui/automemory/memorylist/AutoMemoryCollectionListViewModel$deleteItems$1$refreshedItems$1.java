package com.obric.memorydata.memory.ui.automemory.memorylist;

import com.obric.memorydata.database.entity.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/memorydata/database/entity/AutoMemoryProListItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$deleteItems$1$refreshedItems$1", f = "AutoMemoryCollectionListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AutoMemoryCollectionListViewModel$deleteItems$1$refreshedItems$1 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends y>>, Object> {
    final /* synthetic */ long $currentRuleId;
    final /* synthetic */ Set<Long> $idSet;
    final /* synthetic */ boolean $isDeleteAll;
    int label;
    final /* synthetic */ AutoMemoryCollectionListViewModel this$0;

    AutoMemoryCollectionListViewModel$deleteItems$1$refreshedItems$1(AutoMemoryCollectionListViewModel r3, long r4, Set<Long> r6, boolean r7, Continuation<? super AutoMemoryCollectionListViewModel$deleteItems$1$refreshedItems$1> r8) {
        Set<Long> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$currentRuleId = r4;
        this.$idSet = r9;
        this.$isDeleteAll = r7;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionListViewModel$deleteItems$1$refreshedItems$1(this.this$0, this.$currentRuleId, this.$idSet, this.$isDeleteAll, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends y>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super List<y>> r4) {
        return ((AutoMemoryCollectionListViewModel$deleteItems$1$refreshedItems$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AutoMemoryCollectionListViewModel$deleteItems$1$refreshedItems$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        return AutoMemoryCollectionListViewModel.access$deleteItemsFromDb(this.this$0, this.$currentRuleId, this.$idSet, this.$isDeleteAll);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
