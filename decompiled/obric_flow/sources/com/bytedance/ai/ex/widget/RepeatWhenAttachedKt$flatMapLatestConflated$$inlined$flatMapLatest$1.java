package com.bytedance.ai.ex.widget;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¨\u0006\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/h;", ST.IMPLICIT_ARG_NAME, "", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1", "<anonymous>"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$flatMapLatestConflated$$inlined$flatMapLatest$1", f = "RepeatWhenAttached.kt", i = {}, l = {190, 190}, m = "invokeSuspend", n = {}, s = {})
public final class RepeatWhenAttachedKt$flatMapLatestConflated$$inlined$flatMapLatest$1<T> extends SuspendLambda implements Function3<kotlinx.coroutines.flow.h, T, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public RepeatWhenAttachedKt$flatMapLatestConflated$$inlined$flatMapLatest$1(Function2 r5, Continuation r10) {
        this.$transform = r5;
        super(3, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.h r5, Object r10, Continuation<? super Unit> r11) {
        return invoke2(r5, r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        kotlinx.coroutines.flow.h r12 = (kotlinx.coroutines.flow.h) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        this.L$0 = null;
        this.label = 2;
        if (kotlinx.coroutines.flow.i.i(r12, (kotlinx.coroutines.flow.g) r10, this) != r5) goto L17;
    L15:
        return r5;
    L10:
        ResultKt.throwOnFailure(r10);
        r12 = (kotlinx.coroutines.flow.h) this.L$0;
        Object r13 = this.L$1;
        Function2 r14 = this.$transform;
        this.L$0 = r12;
        this.label = 1;
        r10 = r14.mo2invoke(r13, this);
        if (r10 != r5) goto L13;
        goto L13
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.flow.h r5, T r10, Continuation<? super Unit> r11) {
        RepeatWhenAttachedKt$flatMapLatestConflated$$inlined$flatMapLatest$1 r12 = new RepeatWhenAttachedKt$flatMapLatestConflated$$inlined$flatMapLatest$1(this.$transform, r11);
        r12.L$0 = r5;
        r12.L$1 = r10;
        return r12.invokeSuspend(Unit.INSTANCE);
    }
}
