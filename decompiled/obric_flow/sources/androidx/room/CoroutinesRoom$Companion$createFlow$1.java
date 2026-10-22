package androidx.room;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.channels.p;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "Lkotlinx/coroutines/flow/h;", "Lkotlin/jvm/JvmSuppressWildcards;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/h;)V"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutinesRoom$Companion$createFlow$1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.h, Continuation<? super Unit>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.h $$this$flow;
        final /* synthetic */ Callable<R> $callable;
        final /* synthetic */ RoomDatabase $db;
        final /* synthetic */ boolean $inTransaction;
        final /* synthetic */ String[] $tableNames;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", i = {}, l = {127, 129}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Callable<R> $callable;
            final /* synthetic */ RoomDatabase $db;
            final /* synthetic */ CoroutinesRoom$Companion$createFlow$1$1$observer$1 $observer;
            final /* synthetic */ kotlinx.coroutines.channels.i $observerChannel;
            final /* synthetic */ kotlinx.coroutines.channels.i $resultChannel;
            Object L$0;
            int label;

            public C00081(RoomDatabase r5, CoroutinesRoom$Companion$createFlow$1$1$observer$1 r10, kotlinx.coroutines.channels.i r11, Callable<R> r12, kotlinx.coroutines.channels.i r13, Continuation<? super C00081> r14) {
                this.$db = r5;
                this.$observer = r10;
                this.$observerChannel = r11;
                this.$callable = r12;
                this.$resultChannel = r13;
                super(2, r14);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                return new C00081(this.$db, this.$observer, this.$observerChannel, this.$callable, this.$resultChannel, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
                return invoke2(r5, r10);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0068 -> B:8:0x0015). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r10) {
                Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r11 = this.label;
                if (r11 == 0) goto L16;
                if (r11 == 1) goto L13;
                if (r11 != 2) goto L12;
                k r12 = (k) this.L$0;
                ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L9
                k r13 = r12;
            L8:
                k r14 = r13;
            L18:
                this.L$0 = r14;     // Catch: Throwable -> L9
                this.label = 1;     // Catch: Throwable -> L9
                kotlinx.coroutines.channels.e r15 = (kotlinx.coroutines.channels.e) r14;     // Catch: Throwable -> L9
                r10 = r15.c(this);     // Catch: Throwable -> L9
                k r16 = r15;
                if (r10 != r5) goto L22;
                return r5;
            L22:
                if (((Boolean) r10).booleanValue() == false) goto L26;
                kotlinx.coroutines.channels.e r17 = (kotlinx.coroutines.channels.e) r16;     // Catch: Throwable -> L9
                r17.d();     // Catch: Throwable -> L9
                Object r18 = this.$callable.call();     // Catch: Throwable -> L9
                kotlinx.coroutines.channels.i r19 = this.$resultChannel;     // Catch: Throwable -> L9
                this.L$0 = r17;     // Catch: Throwable -> L9
                this.label = 2;     // Catch: Throwable -> L9
                r13 = r17;
                if (r19.r(r18, this) != r5) goto L8;
                return r5;
            L26:
                this.$db.getInvalidationTracker().removeObserver(this.$observer);
                return Unit.INSTANCE;
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L13:
                k r20 = (k) this.L$0;
                ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L9
                r16 = r20;
                goto L22
            L16:
                ResultKt.throwOnFailure(r10);
                this.$db.getInvalidationTracker().addObserver(this.$observer);
                r14 = this.$observerChannel.iterator();     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                this.$db.getInvalidationTracker().removeObserver(this.$observer);
                throw th;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
                return ((C00081) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
            }
        }

        public AnonymousClass1(boolean r5, RoomDatabase r10, kotlinx.coroutines.flow.h r11, String[] r12, Callable<R> r13, Continuation<? super AnonymousClass1> r14) {
            this.$inTransaction = r5;
            this.$db = r10;
            this.$$this$flow = r11;
            this.$tableNames = r12;
            this.$callable = r13;
            super(2, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$inTransaction, this.$db, this.$$this$flow, this.$tableNames, this.$callable, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Type inference failed for: r7v0, types: [androidx.room.CoroutinesRoom$Companion$createFlow$1$1$observer$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L8;
            if (r10 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            CoroutineScope r11 = (CoroutineScope) this.L$0;
            final kotlinx.coroutines.channels.f r12 = p.a(-1, 6, null);
            final String[] r15 = this.$tableNames;
            ?? r13 = new CoroutinesRoom$Companion$createFlow$1$1$observer$1(r15, r12);
            Object r16 = Unit.INSTANCE;
            r12.g(r16);
            TransactionElement r17 = (TransactionElement) r11.getCoroutineContext().get(TransactionElement.Key);
            if (r17 == null) goto L13;
            ContinuationInterceptor r18 = r17.getTransactionDispatcher$room_ktx_release();
            if (r18 == null) goto L13;
        L16:
            kotlinx.coroutines.channels.f r19 = p.a(0, 7, null);
            BuildersKt.launch$default(r11, r18, null, new C00081(this.$db, r13, r12, this.$callable, r19, null), 2, null);
            kotlinx.coroutines.flow.h r20 = this.$$this$flow;
            this.label = 1;
            Object r110 = kotlinx.coroutines.flow.i.j(r20, r19, true, this);
            if (r110 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
            r16 = r110;
        L19:
            if (r16 != r5) goto L22;
            return r5;
        L13:
            if (this.$inTransaction == false) goto L15;
            r18 = CoroutinesRoomKt.getTransactionDispatcher(this.$db);
            goto L16
        L15:
            r18 = CoroutinesRoomKt.getQueryDispatcher(this.$db);
            goto L16
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public CoroutinesRoom$Companion$createFlow$1(boolean r5, RoomDatabase r10, String[] r11, Callable<R> r12, Continuation<? super CoroutinesRoom$Companion$createFlow$1> r13) {
        this.$inTransaction = r5;
        this.$db = r10;
        this.$tableNames = r11;
        this.$callable = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CoroutinesRoom$Companion$createFlow$1 r12 = new CoroutinesRoom$Companion$createFlow$1(this.$inTransaction, this.$db, this.$tableNames, this.$callable, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(kotlinx.coroutines.flow.h r5, Continuation<? super Unit> r10) {
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
        kotlinx.coroutines.flow.h r12 = (kotlinx.coroutines.flow.h) this.L$0;
        AnonymousClass1 r13 = new AnonymousClass1(this.$inTransaction, this.$db, r12, this.$tableNames, this.$callable, null);
        this.label = 1;
        if (h0.d(r13, this) != r5) goto L12;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.flow.h r5, Continuation<? super Unit> r10) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
