package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$3$1", f = "PersonalTabFragment.kt", i = {}, l = {392}, m = "invokeSuspend", n = {}, s = {})
final class PersonalTabFragment$observeState$3$1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $tag;
    int label;
    final /* synthetic */ PersonalTabFragment this$0;

    PersonalTabFragment$observeState$3$1(PersonalTabFragment r3, String r4, Continuation<? super PersonalTabFragment$observeState$3$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$tag = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PersonalTabFragment$observeState$3$1(this.this$0, this.$tag, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return ((PersonalTabFragment$observeState$3$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PersonalTabFragment$observeState$3$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        if (Intrinsics.areEqual(this.this$0.getShareViewModel().getSelectBottomTab().c(), MemoryContainerTab.PERSONAL_MEMORY.getText()) == false) goto L18;
        if (Intrinsics.areEqual(this.$tag, PersonalTag.f11118a.a()) == false) goto L13;
        kotlinx.coroutines.flow.i<Integer> r7 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().getInfoAllTypeMemoryCount();
    L14:
        final String r3 = this.$tag;
        final PersonalTabFragment r4 = this.this$0;
        kotlinx.coroutines.flow.j<? super Integer> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r7.collect(r2, r5) != r0) goto L18;
        return r0;
    L13:
        r7 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().getInfoSingleTagMemoryCount(this.$tag);
        goto L14
    }
}
