package com.obric.memorydata.memory.ui.automemory;

import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryCollectionsFragment$onCreateView$5$1", f = "AutoMemoryCollectionsFragment.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
final class AutoMemoryCollectionsFragment$onCreateView$5$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ MemoryRuleEntity $card;
    int label;
    final /* synthetic */ AutoMemoryCollectionsFragment this$0;

    AutoMemoryCollectionsFragment$onCreateView$5$1(AutoMemoryCollectionsFragment r3, MemoryRuleEntity r4, Continuation<? super AutoMemoryCollectionsFragment$onCreateView$5$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$card = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionsFragment$onCreateView$5$1(this.this$0, this.$card, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AutoMemoryCollectionsFragment$onCreateView$5$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AutoMemoryCollectionsFragment$onCreateView$5$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L14;
        AutoMemoryCollectionsFragment.access$showAddLimitToast(this.this$0);
    L16:
        return Unit.INSTANCE;
    L14:
        AutoMemoryCollectionsFragment.access$startPresetRuleSettings(this.this$0, this.$card);
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        AutoMemoryViewModel r6 = AutoMemoryCollectionsFragment.access$getViewModel(this.this$0);
        Continuation<? super Boolean> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r5 = r6.hasReachedManualCollectionLimit(r2);
        if (r5 != r0) goto L12;
        return r0;
    }
}
