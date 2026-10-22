package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,414:1\n15#2:415\n1#3:416\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n*L\n304#1:415\n*E\n"})
final class BroadcastChannelImpl$registerSelectForSend$2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ kotlinx.coroutines.selects.k<?> $select;
    int label;
    final /* synthetic */ BroadcastChannelImpl<E> this$0;

    BroadcastChannelImpl$registerSelectForSend$2(BroadcastChannelImpl<E> r10, Object r11, kotlinx.coroutines.selects.k<?> r12, Continuation<? super BroadcastChannelImpl$registerSelectForSend$2> r13) {
        this.this$0 = r10;
        this.$element = r11;
        this.$select = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new BroadcastChannelImpl$registerSelectForSend$2(this.this$0, this.$element, this.$select, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((BroadcastChannelImpl$registerSelectForSend$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2 for r5v5 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r5.label;
        boolean r2 = false;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L9;
        kotlin.ResultKt.throwOnFailure(r6);     // Catch: java.lang.Throwable -> L7
    L15:
        boolean r6 = true;
    L23:
        kotlinx.coroutines.channels.BroadcastChannelImpl<E> r0 = r5.this$0;
        java.util.concurrent.locks.ReentrantLock r0 = kotlinx.coroutines.channels.BroadcastChannelImpl.h1(r0);
        kotlinx.coroutines.channels.BroadcastChannelImpl<E> r1 = r5.this$0;
        kotlinx.coroutines.selects.k<?> r5 = r5.$select;
        r0.lock();
        boolean r4 = kotlinx.coroutines.n0.a();     // Catch: java.lang.Throwable -> L42
        if (r4 == false) goto L33;
        java.util.HashMap r4 = kotlinx.coroutines.channels.BroadcastChannelImpl.i1(r1);     // Catch: java.lang.Throwable -> L42
        java.lang.Object r4 = r4.get(r5);     // Catch: java.lang.Throwable -> L42
        if (r4 != null) goto L29;
        r2 = true;
    L29:
        if (r2 == false) goto L31;
        goto L68;
        goto L33
    L31:
        java.lang.AssertionError r5 = new java.lang.AssertionError();     // Catch: java.lang.Throwable -> L42
        throw r5;     // Catch: java.lang.Throwable -> L42
    L33:
        java.util.HashMap r2 = kotlinx.coroutines.channels.BroadcastChannelImpl.i1(r1);     // Catch: java.lang.Throwable -> L42
        if (r6 == false) goto L36;
        java.lang.Object r6 = kotlin.Unit.INSTANCE;     // Catch: java.lang.Throwable -> L42
        goto L75;
    L37:
        r2.put(r5, r6);     // Catch: java.lang.Throwable -> L42
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");     // Catch: java.lang.Throwable -> L42
        kotlinx.coroutines.selects.SelectImplementation r6 = (kotlinx.coroutines.selects.SelectImplementation) r5;     // Catch: java.lang.Throwable -> L42
        kotlinx.coroutines.selects.SelectImplementation r6 = (kotlinx.coroutines.selects.SelectImplementation) r5;     // Catch: java.lang.Throwable -> L42
        kotlin.Unit r2 = kotlin.Unit.INSTANCE;     // Catch: java.lang.Throwable -> L42
        kotlinx.coroutines.selects.TrySelectDetailedResult r6 = r6.C(r1, r2);     // Catch: java.lang.Throwable -> L42
        kotlinx.coroutines.selects.TrySelectDetailedResult r3 = kotlinx.coroutines.selects.TrySelectDetailedResult.REREGISTER;     // Catch: java.lang.Throwable -> L42
        if (r6 == r3) goto L40;
        java.util.HashMap r6 = kotlinx.coroutines.channels.BroadcastChannelImpl.i1(r1);     // Catch: java.lang.Throwable -> L42
        r6.remove(r5);     // Catch: java.lang.Throwable -> L42
    L40:
        r0.unlock();
        return r2;
    L36:
        r6 = kotlinx.coroutines.channels.BufferedChannelKt.z();     // Catch: java.lang.Throwable -> L42
    L42:
        r5 = move-exception;
        r0.unlock();
        throw r5;
    L9:
        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r5;
    L11:
        kotlin.ResultKt.throwOnFailure(r6);
        kotlinx.coroutines.channels.BroadcastChannelImpl<E> r6 = r5.this$0;     // Catch: java.lang.Throwable -> L7
        java.lang.Object r1 = r5.$element;     // Catch: java.lang.Throwable -> L7
        r5.label = 1;     // Catch: java.lang.Throwable -> L7
        E r1 = (E) r1;
        kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5;
        java.lang.Object r6 = r6.H(r1, r5);     // Catch: java.lang.Throwable -> L7
        if (r6 != r0) goto L15;
        return r0;
    L7:
        r6 = move-exception;
        kotlinx.coroutines.channels.BroadcastChannelImpl<E> r0 = r5.this$0;
        boolean r0 = r0.L();
        if (r0 == false) goto L45;
        boolean r0 = r6 instanceof kotlinx.coroutines.channels.ClosedSendChannelException;
        if (r0 == true) goto L22;
        kotlinx.coroutines.channels.BroadcastChannelImpl<E> r0 = r5.this$0;
        java.lang.Throwable r0 = r0.Z();
        if (r0 != r6) goto L45;
    L22:
        r6 = false;
    L45:
        throw r6;
    }
}
