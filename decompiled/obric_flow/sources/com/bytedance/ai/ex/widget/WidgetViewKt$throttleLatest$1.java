package com.bytedance.ai.ex.widget;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/h;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.bytedance.ai.ex.widget.WidgetViewKt$throttleLatest$1", f = "WidgetView.kt", i = {}, l = {440}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetViewKt$throttleLatest$1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.h, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $period;
    final /* synthetic */ kotlinx.coroutines.flow.g $this_throttleLatest;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.WidgetViewKt$throttleLatest$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.h {
        final /* synthetic */ kotlinx.coroutines.flow.h $$this$flow;
        final /* synthetic */ long $period;

        public AnonymousClass1(kotlinx.coroutines.flow.h r5, long r10) {
            this.$$this$flow = r5;
            this.$period = r10;
        }

        @Override // kotlinx.coroutines.flow.h
        public final Object emit(T r10, Continuation<? super Unit> r11) {
            if ((r11 instanceof WidgetViewKt$throttleLatest$1$1$emit$1) == false) goto L7;
            WidgetViewKt$throttleLatest$1$1$emit$1 r5 = (WidgetViewKt$throttleLatest$1$1$emit$1) r11;
            int r12 = r5.label;
            if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
            r5.label = r12 - Integer.MIN_VALUE;
        L8:
            Object r13 = r5.result;
            Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r15 = r5.label;
            if (r15 == 0) goto L16;
            if (r15 == 1) goto L15;
            if (r15 != 2) goto L14;
            ResultKt.throwOnFailure(r13);
        L23:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            AnonymousClass1<T> this = (AnonymousClass1) r5.L$0;
            ResultKt.throwOnFailure(r13);
        L19:
            long r16 = this.$period;
            r5.L$0 = null;
            r5.label = 2;
            if (DelayKt.m1626delayVtjQ1oo(r16, r5) != r14) goto L23;
        L21:
            return r14;
        L16:
            ResultKt.throwOnFailure(r13);
            kotlinx.coroutines.flow.h r17 = this.$$this$flow;
            r5.L$0 = this;
            r5.label = 1;
            if (r17.emit(r10, r5) != r14) goto L19;
        L7:
            r5 = new WidgetViewKt$throttleLatest$1$1$emit$1(this, r11);
            goto L8
        }
    }

    public WidgetViewKt$throttleLatest$1(kotlinx.coroutines.flow.g r5, long r10, Continuation<? super WidgetViewKt$throttleLatest$1> r11) {
        this.$this_throttleLatest = r5;
        this.$period = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        WidgetViewKt$throttleLatest$1 r11 = new WidgetViewKt$throttleLatest$1(this.$this_throttleLatest, this.$period, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(kotlinx.coroutines.flow.h r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.flow.h r12 = (kotlinx.coroutines.flow.h) this.L$0;
        kotlinx.coroutines.flow.g r13 = this.$this_throttleLatest;
        AnonymousClass1 r14 = new AnonymousClass1(r12, this.$period);
        this.label = 1;
        if (r13.collect(r14, this) != r5) goto L12;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.flow.h r5, Continuation<? super Unit> r10) {
        return ((WidgetViewKt$throttleLatest$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
