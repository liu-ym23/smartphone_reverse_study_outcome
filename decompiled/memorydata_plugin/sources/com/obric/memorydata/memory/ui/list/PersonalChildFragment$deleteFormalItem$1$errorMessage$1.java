package com.obric.memorydata.memory.ui.list;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$deleteFormalItem$1$errorMessage$1", f = "PersonalChildFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PersonalChildFragment$deleteFormalItem$1$errorMessage$1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Integer>, Object> {
    final /* synthetic */ bc.a $item;
    int label;

    PersonalChildFragment$deleteFormalItem$1$errorMessage$1(bc.a r3, Continuation<? super PersonalChildFragment$deleteFormalItem$1$errorMessage$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$item = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PersonalChildFragment$deleteFormalItem$1$errorMessage$1(this.$item, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Integer> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Integer> r4) {
        return ((PersonalChildFragment$deleteFormalItem$1$errorMessage$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PersonalChildFragment$deleteFormalItem$1$errorMessage$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r6);
        if (com.obric.memorydata.memory.memoryentity.d.f10317a.delete(this.$item.c(), MemoryEventTracker.DeleteMethod.GUI_DELETE.getValue(), Boxing.boxLong(this.$item.d())) == true) goto L16;
        return Boxing.boxInt(ZeusTransformUtils.mapRes(R.string.memory_pending_changed_retry, TypedValues.Custom.S_STRING, "memory_pending_changed_retry"));
    L16:
        return null;
    L11:
        return Boxing.boxInt(ZeusTransformUtils.mapRes(R.string.memory_pending_operation_failed, TypedValues.Custom.S_STRING, "memory_pending_operation_failed"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
