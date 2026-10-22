package com.obric.memorydata.memory.ui.list;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/list/PersonalListItem;", "before", "after"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1$pagingFlow$6$2", f = "PersonalChildFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PersonalChildFragment$loadGroupedData$1$pagingFlow$6$2 extends SuspendLambda implements Function3<bc, bc, Continuation<? super bc>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ PersonalChildFragment this$0;

    PersonalChildFragment$loadGroupedData$1$pagingFlow$6$2(PersonalChildFragment r3, Continuation<? super PersonalChildFragment$loadGroupedData$1$pagingFlow$6$2> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(3, r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(bc r3, bc r4, Continuation<? super bc> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        PersonalChildFragment$loadGroupedData$1$pagingFlow$6$2 r0 = new PersonalChildFragment$loadGroupedData$1$pagingFlow$6$2(this.this$0, r6);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(bc r3, bc r4, Continuation<? super bc> r5) {
        return invoke2((bc) ZeusTransformUtils.preCheckCast(r3, bc.class, "com.obric.memorydata.plugin"), (bc) ZeusTransformUtils.preCheckCast(r4, bc.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r8);
        bc r9 = (bc) ZeusTransformUtils.preCheckCast(this.L$0, bc.class, "com.obric.memorydata.plugin");
        bc r0 = (bc) ZeusTransformUtils.preCheckCast(this.L$1, bc.class, "com.obric.memorydata.plugin");
        bc.b r3 = null;
        if (ZeusTransformUtils.instanceOf(r9, bc.a.class) == false) goto L7;
        bc.a r2 = (bc.a) ZeusTransformUtils.preCheckCast(r9, bc.a.class, "com.obric.memorydata.plugin");
    L8:
        if (r2 == null) goto L12;
        MemoryEntity r4 = r2.c();
        if (r4 == null) goto L12;
        String r5 = PersonalChildFragment.access$extractTagPath(this.this$0, r4);
    L14:
        if (ZeusTransformUtils.instanceOf(r0, bc.a.class) == false) goto L16;
        bc.a r1 = (bc.a) ZeusTransformUtils.preCheckCast(r0, bc.a.class, "com.obric.memorydata.plugin");
    L17:
        if (r1 == null) goto L21;
        MemoryEntity r6 = r1.c();
        if (r6 == null) goto L21;
        String r7 = PersonalChildFragment.access$extractTagPath(this.this$0, r6);
    L23:
        if (r9 != null) goto L29;
        if (r0 == null) goto L29;
        if (r7 != null) goto L28;
        r7 = this.this$0.getString(ZeusTransformUtils.mapRes(R.string.tag_path_other, TypedValues.Custom.S_STRING, "tag_path_other"));
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
    L28:
        r3 = new bc.b(r7);
    L37:
        return r3;
    L29:
        if (r9 == null) goto L37;
        if (r0 == null) goto L37;
        if (Intrinsics.areEqual(r5, r7) == true) goto L37;
        if (r7 != null) goto L36;
        r7 = this.this$0.getString(ZeusTransformUtils.mapRes(R.string.tag_path_other, TypedValues.Custom.S_STRING, "tag_path_other"));
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
    L36:
        r3 = new bc.b(r7);
    L21:
        r7 = null;
        goto L23
    L16:
        r1 = null;
    L12:
        r5 = null;
        goto L14
    L7:
        r2 = null;
        goto L8
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
