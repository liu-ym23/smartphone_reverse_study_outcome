package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.channels.y;
import kotlinx.coroutines.flow.j;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\r\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/jvm/JvmSuppressWildcards;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
final class CoroutinesRoom$Companion$createFlow$1<R> extends SuspendLambda implements Function2<j<R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ j<R> $$this$flow;
        final /* synthetic */ Callable<R> $callable;
        final /* synthetic */ RoomDatabase $db;
        final /* synthetic */ boolean $inTransaction;
        final /* synthetic */ String[] $tableNames;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", i = {}, l = {127, 129}, m = "invokeSuspend", n = {}, s = {})
        static final class C00451 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ Callable<R> $callable;
            final /* synthetic */ RoomDatabase $db;
            final /* synthetic */ CoroutinesRoom$Companion$createFlow$1$1$observer$1 $observer;
            final /* synthetic */ i<Unit> $observerChannel;
            final /* synthetic */ i<R> $resultChannel;
            Object L$0;
            int label;

            C00451(RoomDatabase r3, CoroutinesRoom$Companion$createFlow$1$1$observer$1 r4, i<Unit> r5, Callable<R> r6, i<R> r7, Continuation<? super C00451> r8) {
                i<Unit> r9 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.memorydata.plugin");
                Callable<R> r10 = (Callable) ZeusTransformUtils.wrapperContextForParams(r6, Callable.class, "com.obric.memorydata.plugin");
                i<R> r11 = (i) ZeusTransformUtils.wrapperContextForParams(r7, i.class, "com.obric.memorydata.plugin");
                Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                this.$db = r3;
                this.$observer = r4;
                this.$observerChannel = r9;
                this.$callable = r10;
                this.$resultChannel = r11;
                super(2, r12);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C00451(this.$db, this.$observer, this.$observerChannel, this.$callable, this.$resultChannel, r7), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C00451) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C00451.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0090 -> B:8:0x001d). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r9) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L11;
                if (r1 != 2) goto L10;
                k<Unit> r2 = (k) ZeusTransformUtils.preCheckCast(this.L$0, k.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L27
            L8:
                k<Unit> r10 = r2;
            L16:
                Continuation<? super Boolean> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
                this.L$0 = r10;     // Catch: Throwable -> L27
                this.label = 1;     // Catch: Throwable -> L27
                Object r4 = r10.a(r3);     // Catch: Throwable -> L27
                if (r4 != r0) goto L19;
                return r0;
            L19:
                r2 = r10;
                r9 = r4;
            L21:
                if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L25;
                r2.a();     // Catch: Throwable -> L27
                R r11 = this.$callable.call();     // Catch: Throwable -> L27
                i<R> r5 = this.$resultChannel;     // Catch: Throwable -> L27
                Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
                this.L$0 = r2;     // Catch: Throwable -> L27
                this.label = 2;     // Catch: Throwable -> L27
                if (r5.send(r11, r6) != r0) goto L8;
                return r0;
            L25:
                this.$db.getInvalidationTracker().removeObserver((InvalidationTracker.Observer) ZeusTransformUtils.preCheckCast(this.$observer, InvalidationTracker.Observer.class, "com.obric.memorydata.plugin"));
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                r2 = (k) ZeusTransformUtils.preCheckCast(this.L$0, k.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L27
                goto L21
            L14:
                ResultKt.throwOnFailure(r9);
                this.$db.getInvalidationTracker().addObserver((InvalidationTracker.Observer) ZeusTransformUtils.preCheckCast(this.$observer, InvalidationTracker.Observer.class, "com.obric.memorydata.plugin"));
                r10 = this.$observerChannel.l();     // Catch: Throwable -> L27
            L27:
                th = move-exception;
                this.$db.getInvalidationTracker().removeObserver((InvalidationTracker.Observer) ZeusTransformUtils.preCheckCast(this.$observer, InvalidationTracker.Observer.class, "com.obric.memorydata.plugin"));
                throw th;
            }
        }

        AnonymousClass1(boolean r3, RoomDatabase r4, j<R> r5, String[] r6, Callable<R> r7, Continuation<? super AnonymousClass1> r8) {
            j<R> r9 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin");
            Callable<R> r10 = (Callable) ZeusTransformUtils.wrapperContextForParams(r7, Callable.class, "com.obric.memorydata.plugin");
            Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.$inTransaction = r3;
            this.$db = r4;
            this.$$this$flow = r9;
            this.$tableNames = r6;
            this.$callable = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r12 = new AnonymousClass1(this.$inTransaction, this.$db, this.$$this$flow, this.$tableNames, this.$callable, r8);
            r12.L$0 = r10;
            return (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r8v0, types: [androidx.room.CoroutinesRoom$Companion$createFlow$1$1$observer$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r15);
        L21:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r15);
            al r4 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            final i r9 = l.a(-1, null, null, 6, null);
            final String[] r16 = this.$tableNames;
            ?? r8 = new CoroutinesRoom$Companion$createFlow$1$1$observer$1(r16, r9);
            r9.mo54trySendJP2dKIU(Unit.INSTANCE);
            TransactionElement r17 = (TransactionElement) ZeusTransformUtils.preCheckCast(r4.getCoroutineContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(TransactionElement.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), TransactionElement.class, "com.obric.memorydata.plugin");
            if (r17 == null) goto L13;
            ContinuationInterceptor r18 = r17.getTransactionDispatcher$room_ktx_release();
            if (r18 == null) goto L13;
        L17:
            i r2 = l.a(0, null, null, 7, null);
            kotlinx.coroutines.i.a(r4, (CoroutineContext) ZeusTransformUtils.preCheckCast(r18, CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C00451(this.$db, r8, r9, this.$callable, r2, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
            j<R> r19 = this.$$this$flow;
            y r3 = (y) ZeusTransformUtils.preCheckCast(r2, y.class, "com.obric.memorydata.plugin");
            Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r19, r3, r5) != r0) goto L21;
            return r0;
        L13:
            if (this.$inTransaction == false) goto L15;
            ah r110 = CoroutinesRoomKt.getTransactionDispatcher(this.$db);
        L16:
            r18 = (ContinuationInterceptor) ZeusTransformUtils.preCheckCast(r110, ContinuationInterceptor.class, "com.obric.memorydata.plugin");
            goto L17
        L15:
            r110 = CoroutinesRoomKt.getQueryDispatcher(this.$db);
            goto L16
        }
    }

    CoroutinesRoom$Companion$createFlow$1(boolean r3, RoomDatabase r4, String[] r5, Callable<R> r6, Continuation<? super CoroutinesRoom$Companion$createFlow$1> r7) {
        Callable<R> r8 = (Callable) ZeusTransformUtils.wrapperContextForParams(r6, Callable.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$inTransaction = r3;
        this.$db = r4;
        this.$tableNames = r5;
        this.$callable = r8;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        CoroutinesRoom$Companion$createFlow$1 r11 = new CoroutinesRoom$Companion$createFlow$1(this.$inTransaction, this.$db, this.$tableNames, this.$callable, r7);
        r11.L$0 = r9;
        return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(j<R> r3, Continuation<? super Unit> r4) {
        return ((CoroutinesRoom$Companion$createFlow$1) ZeusTransformUtils.preCheckCast(create((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), CoroutinesRoom$Companion$createFlow$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        j r7 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
        Function2 r13 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$inTransaction, this.$db, r7, this.$tableNames, this.$callable, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (am.a(r13, r2) != r0) goto L12;
        return r0;
    }
}
