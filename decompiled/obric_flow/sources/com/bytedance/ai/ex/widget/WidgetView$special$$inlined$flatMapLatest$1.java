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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.t;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¨\u0006\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/h;", ST.IMPLICIT_ARG_NAME, "", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1", "<anonymous>"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.bytedance.ai.ex.widget.WidgetView$special$$inlined$flatMapLatest$1", f = "WidgetView.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1\n+ 2 WidgetView.kt\ncom/bytedance/ai/ex/widget/WidgetView\n*L\n1#1,215:1\n100#2,5:216\n*E\n"})
public final class WidgetView$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.h, Boolean, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ WidgetView this$0;

    public WidgetView$special$$inlined$flatMapLatest$1(Continuation r5, WidgetView r10) {
        this.this$0 = r10;
        super(3, r5);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.h r5, Boolean r10, Continuation<? super Unit> r11) {
        return invoke(r5, r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.flow.h r12 = (kotlinx.coroutines.flow.h) this.L$0;
        boolean r13 = ((Boolean) this.L$1).booleanValue();
        kotlinx.coroutines.flow.g r14 = new t(WidgetView.access$getDataFlow$p(this.this$0), 1);
        if (r13 == true) goto L12;
        r14 = WidgetViewKt.m86throttleLatestHG0u8IE(r14, WidgetView.access$getBACKGROUND_THROTTLE$cp());
    L12:
        this.label = 1;
        if (kotlinx.coroutines.flow.i.i(r12, r14, this) != r5) goto L16;
        return r5;
    }

    public final Object invoke(kotlinx.coroutines.flow.h r5, Boolean r10, Continuation<? super Unit> r11) {
        WidgetView$special$$inlined$flatMapLatest$1 r12 = new WidgetView$special$$inlined$flatMapLatest$1(r11, this.this$0);
        r12.L$0 = r5;
        r12.L$1 = r10;
        return r12.invokeSuspend(Unit.INSTANCE);
    }
}
