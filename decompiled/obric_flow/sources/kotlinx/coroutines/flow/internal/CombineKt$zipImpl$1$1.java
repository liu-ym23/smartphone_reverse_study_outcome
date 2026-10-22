package kotlinx.coroutines.flow.internal;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.l1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0, 0}, l = {123}, m = "invokeSuspend", n = {"second", "collectJob"}, s = {"L$0", "L$1"})
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.g $flow;
    final /* synthetic */ kotlinx.coroutines.flow.g $flow2;
    final /* synthetic */ kotlinx.coroutines.flow.h $this_unsafeFlow;
    final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $cnt;
        final /* synthetic */ kotlinx.coroutines.t $collectJob;
        final /* synthetic */ kotlinx.coroutines.flow.g $flow;
        final /* synthetic */ CoroutineContext $scopeContext;
        final /* synthetic */ kotlinx.coroutines.channels.w $second;
        final /* synthetic */ kotlinx.coroutines.flow.h $this_unsafeFlow;
        final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(kotlinx.coroutines.flow.g r5, CoroutineContext r10, Object r11, kotlinx.coroutines.channels.w r12, kotlinx.coroutines.flow.h r13, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r14, kotlinx.coroutines.t r15, Continuation<? super AnonymousClass2> r16) {
            this.$flow = r5;
            this.$scopeContext = r10;
            this.$cnt = r11;
            this.$second = r12;
            this.$this_unsafeFlow = r13;
            this.$transform = r14;
            this.$collectJob = r15;
            super(2, r16);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, this.$collectJob, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(Unit r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L8;
            if (r10 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            kotlinx.coroutines.flow.g r12 = this.$flow;
            m r13 = new m(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, this.$collectJob);
            this.label = 1;
            if (r12.collect(r13, this) != r5) goto L12;
            return r5;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Unit r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1(kotlinx.coroutines.flow.g r5, kotlinx.coroutines.flow.g r10, kotlinx.coroutines.flow.h r11, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r12, Continuation<? super CombineKt$zipImpl$1$1> r13) {
        this.$flow2 = r5;
        this.$flow = r10;
        this.$this_unsafeFlow = r11;
        this.$transform = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CombineKt$zipImpl$1$1 r12 = new CombineKt$zipImpl$1$1(this.$flow2, this.$flow, this.$this_unsafeFlow, this.$transform, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L14;
        if (r10 != 1) goto L13;
        kotlinx.coroutines.t r11 = (kotlinx.coroutines.t) this.L$1;
        kotlinx.coroutines.channels.w r12 = (kotlinx.coroutines.channels.w) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L8 AbortFlowException -> L10
        CancellationException r13 = null;
    L19:
        r12.cancel(r13);
        return Unit.INSTANCE;
    L10:
        e = e;
    L37:
    L33:
        th = th;
    L21:
        CancellationException r14 = null;
    L35:
        r12.cancel(r14);
        throw th;
    L28:
        if (e.owner != r11) goto L32;
    L29:
        r13 = null;
        goto L19
    L32:
        throw e;     // Catch: Throwable -> L33
    L8:
        th = th;
        r14 = null;
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        kotlinx.coroutines.channels.t r16 = kotlinx.coroutines.channels.s.b(r15, 0, new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3);
        l1 r17 = new l1(null);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
        r16.f(new l(r17));
        CoroutineContext r19 = r15.getCoroutineContext();     // Catch: Throwable -> L23 AbortFlowException -> L25
        Object r110 = kotlinx.coroutines.internal.v.b(r19);     // Catch: Throwable -> L23 AbortFlowException -> L25
        CoroutineContext r20 = r15.getCoroutineContext().plus(r17);     // Catch: Throwable -> L23 AbortFlowException -> L25
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L23 AbortFlowException -> L25
        AnonymousClass2 r111 = new AnonymousClass2(this.$flow, r19, r110, r16, this.$this_unsafeFlow, this.$transform, r17, null);     // Catch: Throwable -> L23 AbortFlowException -> L25
        this.L$0 = r16;     // Catch: Throwable -> L23 AbortFlowException -> L25
        this.L$1 = r17;     // Catch: Throwable -> L23 AbortFlowException -> L25
        this.label = 1;     // Catch: Throwable -> L23 AbortFlowException -> L25
        if (b.b(r20, r21, kotlinx.coroutines.internal.v.b(r20), r111, this) != r5) goto L18;
        return r5;
    L18:
        r12 = r16;
        goto L29
    L25:
        e = e;
        r12 = r16;
        r11 = r17;
    L23:
        th = th;
        r12 = r16;
        goto L21
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((CombineKt$zipImpl$1$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
