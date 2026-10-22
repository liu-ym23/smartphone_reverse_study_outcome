package com.larus.ui.arch.context.internal;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.internal.n;
import t1a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.context.internal.VStateImpl$onEach$1", f = "VStateImpl.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
public final class VStateImpl$onEach$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<T, Unit> $action;
    final /* synthetic */ Function2<T, T, Boolean> $compare;
    final /* synthetic */ boolean $skipInitial;
    int label;
    final /* synthetic */ VStateImpl<T> this$0;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.larus.ui.arch.context.internal.VStateImpl$onEach$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0015\u0010\u0004\u001a\u0011H\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007H\n"}, d2 = {"<anonymous>", "", "T", "Lcom/larus/ui/arch/context/external/VData;", "it", "Lkotlin/ParameterName;", "name", "old"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ui.arch.context.internal.VStateImpl$onEach$1$1", f = "VStateImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1<T> extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<T, Unit> $action;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super T, Unit> r1, Continuation<? super AnonymousClass1> r2) {
            this.$action = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$action, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((c) r1, (Continuation) r2);
        }

        /* JADX WARN: Incorrect types in method signature: (TT;Lkotlin/coroutines/Continuation<-Lkotlin/Unit;>;)Ljava/lang/Object; */
        public final Object invoke(c r1, Continuation r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            c r3 = (c) this.L$0;
            this.$action.invoke(r3);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VStateImpl$onEach$1(VStateImpl<T> r1, boolean r2, Function2<? super T, ? super T, Boolean> r3, Function1<? super T, Unit> r4, Continuation<? super VStateImpl$onEach$1> r5) {
        this.this$0 = r1;
        this.$skipInitial = r2;
        this.$compare = r3;
        this.$action = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new VStateImpl$onEach$1(this.this$0, this.$skipInitial, this.$compare, this.$action, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Flow r7 = e.o(e.p(this.this$0.c, this.$skipInitial ? 1 : 0), this.$compare);
        AnonymousClass1 r2 = new AnonymousClass1(this.$action, null);
        this.label = 1;
        Object r8 = r7.collect(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1.2(n.a, r2), this);
        if (r8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        r8 = Unit.INSTANCE;
    L13:
        if (r8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        r8 = Unit.INSTANCE;
    L16:
        if (r8 != r0) goto L19;
        return r0;
    }
}
