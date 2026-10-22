package com.bytedance.android.ec.core.arch.event;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/arch/event/d;", "I", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.arch.event.EventFunc$collect$1", f = "EventFunc.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
final class EventFunc$collect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $block;
    final /* synthetic */ com.bytedance.android.ec.core.arch.event.a $shareFlowWrapper;
    int label;

    public static final class a implements FlowCollector<Object> {
        public final /* synthetic */ EventFunc$collect$1 a;

        public a(EventFunc$collect$1 r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r10) {
            Function1 r11 = this.a.$block;
            if (r1 == null) goto L7;
            r11.invoke((d) r1);
            return Unit.INSTANCE;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type I");
        }
    }

    public EventFunc$collect$1(com.bytedance.android.ec.core.arch.event.a r1, Function1 r10, Continuation r11) {
        this.$shareFlowWrapper = r1;
        this.$block = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new EventFunc$collect$1(this.$shareFlowWrapper, this.$block, r11);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Object r11 = this.$shareFlowWrapper.c;
        if (r11 == null) goto L11;
        this.$shareFlowWrapper.c = null;
        this.$block.invoke((d) r11);
    L11:
        o r12 = this.$shareFlowWrapper.a;
        a r13 = new a(this);
        this.label = 1;
        if (r12.collect(r13, this) != r0) goto L15;
        return r0;
    }
}
