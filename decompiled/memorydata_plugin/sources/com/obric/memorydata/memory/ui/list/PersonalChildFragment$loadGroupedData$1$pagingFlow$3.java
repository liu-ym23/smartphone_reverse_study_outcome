package com.obric.memorydata.memory.ui.list;

import androidx.paging.PagingData;
import com.obric.memorydata.database.entity.ih;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/database/entity/SemanticMemoryWithRelevantPojo;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1$pagingFlow$3", f = "PersonalChildFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PersonalChildFragment$loadGroupedData$1$pagingFlow$3 extends SuspendLambda implements Function2<PagingData<ih>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $generationId;
    int label;
    final /* synthetic */ PersonalChildFragment this$0;

    PersonalChildFragment$loadGroupedData$1$pagingFlow$3(PersonalChildFragment r3, long r4, Continuation<? super PersonalChildFragment$loadGroupedData$1$pagingFlow$3> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$generationId = r4;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PersonalChildFragment$loadGroupedData$1$pagingFlow$3(this.this$0, this.$generationId, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(PagingData<ih> r3, Continuation<? super Unit> r4) {
        return ((PersonalChildFragment$loadGroupedData$1$pagingFlow$3) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PersonalChildFragment$loadGroupedData$1$pagingFlow$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(PagingData<ih> r3, Continuation<? super Unit> r4) {
        return invoke2((PagingData) ZeusTransformUtils.preCheckCast(r3, PagingData.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r9);
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder().append("[MEM] ").append(PersonalChildFragment.access$getTagType(this.this$0)).append(" PAGER_EMIT gen=").append(this.$generationId).append(" source=");
        WeakReference r8 = PersonalChildFragment.access$getCurrentPagingSourceRef$p(this.this$0);
        if (r8 == null) goto L9;
        SemanticMemoryPagingSource r11 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r8.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L9;
        Long r12 = Boxing.boxLong(r11.debugId());
    L10:
        IRunLog.a.a(r2, "PersonalChildFragment", r10.append(r12).toString(), false, 4, null);
        return Unit.INSTANCE;
    L9:
        r12 = null;
        goto L10
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
