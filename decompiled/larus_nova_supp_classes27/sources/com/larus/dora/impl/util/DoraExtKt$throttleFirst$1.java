package com.larus.dora.impl.util;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.util.DoraExtKt$throttleFirst$1", f = "DoraExt.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
final class DoraExtKt$throttleFirst$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_throttleFirst;
    final /* synthetic */ long $windowDuration;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Ref.LongRef a;
        public final /* synthetic */ long b;
        public final /* synthetic */ FlowCollector<T> c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Ref.LongRef r1, long r2, FlowCollector<? super T> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final Object emit(T r9, Continuation<? super Unit> r10) {
            long r0 = System.currentTimeMillis();
            Ref.LongRef r2 = this.a;
            if ((r0 - r2.element) < this.b) goto L10;
            r2.element = r0;
            Object r11 = this.c.emit(r9, r10);
            if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
            return r11;
        L8:
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        }
    }

    public DoraExtKt$throttleFirst$1(Flow<Object> r1, long r2, Continuation<? super DoraExtKt$throttleFirst$1> r4) {
        this.$this_throttleFirst = r1;
        this.$windowDuration = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        DoraExtKt$throttleFirst$1 r0 = new DoraExtKt$throttleFirst$1(this.$this_throttleFirst, this.$windowDuration, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<Object> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        FlowCollector r9 = (FlowCollector) this.L$0;
        Ref.LongRef r2 = new Ref.LongRef();
        Flow<Object> r3 = this.$this_throttleFirst;
        a r4 = new a(r2, this.$windowDuration, r9);
        this.label = 1;
        if (r3.collect(r4, this) != r0) goto L12;
        return r0;
    }
}
