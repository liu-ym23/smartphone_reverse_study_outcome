package com.larus.bot.impl.common.util;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.common.util.FlowExtKt$throttleFirst$1", f = "FlowExt.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
final class FlowExtKt$throttleFirst$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $intervalMs;
    final /* synthetic */ Flow<Object> $this_throttleFirst;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bot.impl.common.util.FlowExtKt$throttleFirst$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ Ref.LongRef a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Ref.BooleanRef c;
        public final /* synthetic */ FlowCollector<T> d;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref.LongRef r1, long r2, Ref.BooleanRef r4, FlowCollector<? super T> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final Object emit(T r11, Continuation<? super Unit> r12) {
            if ((r12 instanceof FlowExtKt$throttleFirst$1$1$emit$1) == false) goto L7;
            FlowExtKt$throttleFirst$1$1$emit$1 r0 = (FlowExtKt$throttleFirst$1$1$emit$1) r12;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r13 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            ResultKt.throwOnFailure(r13);
        L22:
            this.c.element = true;
        L24:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r13);
            long r4 = System.currentTimeMillis();
            Ref.LongRef r14 = this.a;
            long r6 = r14.element;
            long r5 = r4 - r6;
            long r8 = this.b;
            if (r5 < r8) goto L18;
            r14.element = r6 + ((r5 / r8) * r8);
            this.c.element = false;
        L18:
            if (this.c.element == true) goto L24;
            FlowCollector<T> r15 = this.d;
            r0.label = 1;
            if (r15.emit(r11, r0) != r2) goto L22;
            return r2;
        L7:
            r0 = new FlowExtKt$throttleFirst$1$1$emit$1(this, r12);
            goto L8
        }
    }

    public FlowExtKt$throttleFirst$1(Flow<Object> r1, long r2, Continuation<? super FlowExtKt$throttleFirst$1> r4) {
        this.$this_throttleFirst = r1;
        this.$intervalMs = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        FlowExtKt$throttleFirst$1 r0 = new FlowExtKt$throttleFirst$1(this.$this_throttleFirst, this.$intervalMs, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<Object> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        FlowCollector r8 = (FlowCollector) this.L$0;
        Ref.LongRef r4 = new Ref.LongRef();
        r4.element = System.currentTimeMillis();
        Ref.BooleanRef r7 = new Ref.BooleanRef();
        Flow<Object> r11 = this.$this_throttleFirst;
        AnonymousClass1 r2 = new AnonymousClass1(r4, this.$intervalMs, r7, r8);
        this.label = 1;
        if (r11.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
