package com.larus.audio.call.util;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.audio.call.dora.CommandStatus;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.util.FlowExtKt$withPrevious$1", f = "FlowExt.kt", i = {}, l = {CommandStatus.DORA_PICTURE_OCCLUSION}, m = "invokeSuspend", n = {}, s = {})
final class FlowExtKt$withPrevious$1 extends SuspendLambda implements Function2<FlowCollector<? super Pair<Object, Object>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_withPrevious;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.audio.call.util.FlowExtKt$withPrevious$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ FlowCollector<Pair<? extends T, ? extends T>> a;
        public final /* synthetic */ Ref.ObjectRef<T> b;

        public AnonymousClass1(FlowCollector<? super Pair<? extends T, ? extends T>> r1, Ref.ObjectRef<T> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(T r5, Continuation<? super Unit> r6) {
            if ((r6 instanceof FlowExtKt$withPrevious$1$1$emit$1) == false) goto L7;
            FlowExtKt$withPrevious$1$1$emit$1 r0 = (FlowExtKt$withPrevious$1$1$emit$1) r6;
            int r1 = r0.label;
            if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
            r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
        L8:
            Object r7 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r5 = (T) r0.L$0;
            ResultKt.throwOnFailure(r7);
        L17:
            this.b.element = r5;
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r7);
            FlowCollector<Pair<? extends T, ? extends T>> r8 = this.a;
            Pair r4 = TuplesKt.to(this.b.element, r5);
            r0.L$0 = r5;
            r0.label = 1;
            if (r8.emit(r4, r0) != r2) goto L17;
            return r2;
        L7:
            r0 = new FlowExtKt$withPrevious$1$1$emit$1(this, r6);
            goto L8
        }
    }

    public FlowExtKt$withPrevious$1(Flow<Object> r1, Continuation<? super FlowExtKt$withPrevious$1> r2) {
        this.$this_withPrevious = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FlowExtKt$withPrevious$1 r0 = new FlowExtKt$withPrevious$1(this.$this_withPrevious, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super Pair<Object, Object>> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FlowCollector r7 = (FlowCollector) this.L$0;
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        Flow<Object> r3 = this.$this_withPrevious;
        AnonymousClass1 r4 = new AnonymousClass1(r7, r2);
        this.label = 1;
        if (r3.collect(r4, this) != r0) goto L12;
        return r0;
    }
}
