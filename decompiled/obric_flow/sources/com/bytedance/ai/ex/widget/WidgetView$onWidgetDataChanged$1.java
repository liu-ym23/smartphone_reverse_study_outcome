package com.bytedance.ai.ex.widget;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/h;", "", "", "<anonymous>", "(Lkotlinx/coroutines/flow/h;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.bytedance.ai.ex.widget.WidgetView$onWidgetDataChanged$1", f = "WidgetView.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetView$onWidgetDataChanged$1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.h, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public WidgetView$onWidgetDataChanged$1(Continuation<? super WidgetView$onWidgetDataChanged$1> r5) {
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        WidgetView$onWidgetDataChanged$1 r11 = new WidgetView$onWidgetDataChanged$1(r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(kotlinx.coroutines.flow.h r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.flow.h r12 = (kotlinx.coroutines.flow.h) this.L$0;
        Boolean r13 = Boxing.boxBoolean(false);
        this.label = 1;
        if (r12.emit(r13, this) != r10) goto L12;
        return r10;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.flow.h r5, Continuation<? super Unit> r10) {
        return ((WidgetView$onWidgetDataChanged$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
