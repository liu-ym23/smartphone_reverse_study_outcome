package com.obric.memorydata.memory.ui.list;

import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/list/PersonalListItem;", "before", "after"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1$pagingFlow$6$1", f = "PersonalChildFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PersonalChildFragment$loadGroupedData$1$pagingFlow$6$1 extends SuspendLambda implements Function3<bc, bc, Continuation<? super bc>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ PersonalChildFragment this$0;

    PersonalChildFragment$loadGroupedData$1$pagingFlow$6$1(PersonalChildFragment r3, Continuation<? super PersonalChildFragment$loadGroupedData$1$pagingFlow$6$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(3, r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(bc r3, bc r4, Continuation<? super bc> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        PersonalChildFragment$loadGroupedData$1$pagingFlow$6$1 r0 = new PersonalChildFragment$loadGroupedData$1$pagingFlow$6$1(this.this$0, r6);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(bc r3, bc r4, Continuation<? super bc> r5) {
        return invoke2((bc) ZeusTransformUtils.preCheckCast(r3, bc.class, "com.obric.memorydata.plugin"), (bc) ZeusTransformUtils.preCheckCast(r4, bc.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r7);
        bc r8 = (bc) ZeusTransformUtils.preCheckCast(this.L$0, bc.class, "com.obric.memorydata.plugin");
        bc r0 = (bc) ZeusTransformUtils.preCheckCast(this.L$1, bc.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, bc.a.class) == false) goto L7;
        bc.a r1 = (bc.a) ZeusTransformUtils.preCheckCast(r0, bc.a.class, "com.obric.memorydata.plugin");
    L8:
        if (r1 == null) goto L12;
        MemoryEntity r2 = r1.c();
        if (r2 == null) goto L12;
        Long r3 = Boxing.boxLong(r2.getLastModifiedTime());
    L14:
        if (ZeusTransformUtils.instanceOf(r8, bc.a.class) == false) goto L16;
        bc.a r9 = (bc.a) ZeusTransformUtils.preCheckCast(r8, bc.a.class, "com.obric.memorydata.plugin");
    L17:
        if (r9 == null) goto L21;
        MemoryEntity r10 = r9.c();
        if (r10 == null) goto L21;
        Long r11 = Boxing.boxLong(r10.getLastModifiedTime());
    L22:
        if (r3 == null) goto L30;
        if (r11 == null) goto L27;
        if (Intrinsics.areEqual(PersonalChildFragment.access$memoryDay(this.this$0, r3.longValue()), PersonalChildFragment.access$memoryDay(this.this$0, r11.longValue())) == false) goto L27;
        return null;
    L27:
        return new bc.b(com.obric.memorydata.memory.utils.f.f11537a.a(PersonalChildFragment.access$memoryDay(this.this$0, r3.longValue()), true));
    L30:
        return null;
    L21:
        r11 = null;
        goto L22
    L16:
        r9 = null;
    L12:
        r3 = null;
        goto L14
    L7:
        r1 = null;
        goto L8
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
