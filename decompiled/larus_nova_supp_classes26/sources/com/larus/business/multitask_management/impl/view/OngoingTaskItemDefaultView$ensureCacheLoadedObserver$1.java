package com.larus.business.multitask_management.impl.view;

import android.animation.ValueAnimator;
import com.larus.multitask_management.api.data.TaskStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.view.OngoingTaskItemDefaultView$ensureCacheLoadedObserver$1", f = "OngoingTaskItemDefaultView.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
public final class OngoingTaskItemDefaultView$ensureCacheLoadedObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OngoingTaskItemDefaultView this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ OngoingTaskItemDefaultView a;

        public a(OngoingTaskItemDefaultView r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            ((Boolean) r6).booleanValue();
            OngoingTaskItemDefaultView r8 = this.a;
            r8.g = false;
            kl9.u r9 = r8.e;
            if (r9 == null) goto L31;
            TaskStatus r0 = r9.g;
            if (r0 == TaskStatus.SUCCESS) goto L31;
            if (r0 == TaskStatus.FAILED) goto L31;
            kl9.c0 r1 = r9.m;
            if (r1 == null) goto L31;
            int r2 = r1.a;
            if (r2 < 0) goto L31;
            String r3 = r9.a;
            r8.S5(r3);
            c r4 = r8.d;
            Long r5 = null;
            if (r4 == null) goto L24;
            ValueAnimator r10 = r4.f;
            if (r10 == null) goto L20;
            r10.cancel();
        L20:
            r4.f = null;
            ValueAnimator r11 = r4.g;
            if (r11 == null) goto L23;
            r11.cancel();
        L23:
            r4.g = null;
            r4.c = null;
            r4.d = null;
        L24:
            c r12 = r8.d;
            if (r12 == null) goto L31;
            kl9.c0 r13 = r9.m;
            if (r13 == null) goto L29;
            r5 = Long.valueOf(r13.b);
        L29:
            r12.b(r3, r2, r5);
        L31:
            return Unit.INSTANCE;
        }
    }

    public OngoingTaskItemDefaultView$ensureCacheLoadedObserver$1(OngoingTaskItemDefaultView r1, Continuation<? super OngoingTaskItemDefaultView$ensureCacheLoadedObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OngoingTaskItemDefaultView$ensureCacheLoadedObserver$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        final StateFlowImpl r6 = TaskProgressMockCache.e;
        FlowKt__LimitKt$take$.inlined.unsafeFlow.1 r7 = new FlowKt__LimitKt$take$.inlined.unsafeFlow.1(new OngoingTaskItemDefaultView$ensureCacheLoadedObserver$1$invokeSuspend$$inlined$filter$1(r6));
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
