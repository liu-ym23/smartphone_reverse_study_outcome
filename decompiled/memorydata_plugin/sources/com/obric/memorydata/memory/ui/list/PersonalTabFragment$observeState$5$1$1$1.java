package com.obric.memorydata.memory.ui.list;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$5$1$1$1", f = "PersonalTabFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PersonalTabFragment$observeState$5$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppEntity $entity;
    int label;
    final /* synthetic */ PersonalTabFragment this$0;

    PersonalTabFragment$observeState$5$1$1$1(PersonalTabFragment r3, AppEntity r4, Continuation<? super PersonalTabFragment$observeState$5$1$1$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$entity = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PersonalTabFragment$observeState$5$1$1$1(this.this$0, this.$entity, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return ((PersonalTabFragment$observeState$5$1$1$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PersonalTabFragment$observeState$5$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r4);
        String r5 = this.this$0.getShareViewModel().getTargetPersonalTag();
        if (r5 == null) goto L7;
    L10:
        this.this$0.getShareViewModel().setTargetPersonalTag(null);
        if (r5 != null) goto L13;
    L15:
        r5 = (String) ZeusTransformUtils.preCheckCast(PersonalTabFragment.Companion.a().get(0), String.class, "com.obric.memorydata.plugin");
    L16:
        this.this$0.initViews(r5);
        return Unit.INSTANCE;
    L13:
        if (PersonalTabFragment.Companion.a().contains(r5) == false) goto L15;
    L7:
        if (ZeusTransformUtils.instanceOf(this.$entity, InfoCommonMemoryEntity.class) == false) goto L9;
        r5 = ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(this.$entity, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoKey();
        goto L10
    L9:
        r5 = null;
        goto L10
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
