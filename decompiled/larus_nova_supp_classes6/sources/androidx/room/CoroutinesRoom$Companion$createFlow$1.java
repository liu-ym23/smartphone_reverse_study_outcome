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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u00020\u0001H\u008a@"}, d2 = {"R", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/jvm/JvmSuppressWildcards;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutinesRoom$Companion$createFlow$1<R> extends SuspendLambda implements Function2<FlowCollector<R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"R", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<R> $$this$flow;
        final /* synthetic */ Callable<R> $callable;
        final /* synthetic */ RoomDatabase $db;
        final /* synthetic */ boolean $inTransaction;
        final /* synthetic */ String[] $tableNames;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"R", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", i = {}, l = {124, 126}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Callable<R> $callable;
            final /* synthetic */ RoomDatabase $db;
            final /* synthetic */ CoroutinesRoom$Companion$createFlow$1$1$observer$1 $observer;
            final /* synthetic */ Channel<Unit> $observerChannel;
            final /* synthetic */ Channel<R> $resultChannel;
            Object L$0;
            int label;

            public C00001(RoomDatabase r1, CoroutinesRoom$Companion$createFlow$1$1$observer$1 r2, Channel<Unit> r3, Callable<R> r4, Channel<R> r5, Continuation<? super C00001> r6) {
                this.$db = r1;
                this.$observer = r2;
                this.$observerChannel = r3;
                this.$callable = r4;
                this.$resultChannel = r5;
                super(2, r6);
            }

            public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
                return new C00001(this.$db, this.$observer, this.$observerChannel, this.$callable, this.$resultChannel, r9);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006a -> B:35:0x003e). Please report as a decompilation issue!!! */
            public final Object invokeSuspend(Object r8) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L11;
                if (r1 != 2) goto L10;
                ChannelIterator r2 = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L31
                ChannelIterator r9 = r2;
            L16:
                C00001 r3 = this;
            L35:
                r3.L$0 = r9;     // Catch: Throwable -> L29
                r3.label = 1;     // Catch: Throwable -> L29
                Object r4 = r9.hasNext(r3);     // Catch: Throwable -> L29
                if (r4 != r0) goto L20;
                return r0;
            L20:
                ChannelIterator r5 = r9;
                r8 = r4;
            L22:
                if (((Boolean) r8).booleanValue() == false) goto L27;
                r5.next();     // Catch: Throwable -> L29
                R r10 = r3.$callable.call();     // Catch: Throwable -> L29
                Channel<R> r6 = r3.$resultChannel;     // Catch: Throwable -> L29
                r3.L$0 = r5;     // Catch: Throwable -> L29
                r3.label = 2;     // Catch: Throwable -> L29
                if (r6.send(r10, r3) != r0) goto L26;
                return r0;
            L26:
                r9 = r5;
                goto L35
            L27:
                r3.$db.getInvalidationTracker().removeObserver(r3.$observer);
                return Unit.INSTANCE;
            L29:
                th = th;
            L33:
                r3.$db.getInvalidationTracker().removeObserver(r3.$observer);
                throw th;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                ChannelIterator r7 = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L31
                r5 = r7;
                r3 = this;
                goto L22
            L14:
                ResultKt.throwOnFailure(r8);
                this.$db.getInvalidationTracker().addObserver(this.$observer);
                r9 = this.$observerChannel.iterator();     // Catch: Throwable -> L31
            L31:
                th = th;
                r3 = this;
                goto L33
            }
        }

        public AnonymousClass1(boolean r1, RoomDatabase r2, FlowCollector<R> r3, String[] r4, Callable<R> r5, Continuation<? super AnonymousClass1> r6) {
            this.$inTransaction = r1;
            this.$db = r2;
            this.$$this$flow = r3;
            this.$tableNames = r4;
            this.$callable = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            AnonymousClass1 r7 = new AnonymousClass1(this.$inTransaction, this.$db, this.$$this$flow, this.$tableNames, this.$callable, r10);
            r7.L$0 = r9;
            return r7;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r7v0, types: [androidx.room.CoroutinesRoom$Companion$createFlow$1$1$observer$1] */
        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r15);
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r15);
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            final Channel r8 = ChannelKt.Channel$default(-1, null, null, 6, null);
            final String[] r16 = this.$tableNames;
            ?? r7 = new CoroutinesRoom$Companion$createFlow$1$1$observer$1(r16, r8);
            r8.offer(Unit.INSTANCE);
            TransactionElement r17 = (TransactionElement) r3.getCoroutineContext().get(TransactionElement.Key);
            if (r17 == null) goto L13;
            ContinuationInterceptor r18 = r17.getTransactionDispatcher$room_ktx_release();
            if (r18 == null) goto L13;
        L16:
            Channel r2 = ChannelKt.Channel$default(0, null, null, 7, null);
            ContinuationInterceptor r4 = r18;
            BuildersKt.launch$default(r3, r4, null, new C00001(this.$db, r7, r8, this.$callable, r2, null), 2, null);
            FlowCollector<R> r19 = this.$$this$flow;
            this.label = 1;
            if (kotlinx.coroutines.flow.e.q(r19, r2, this) != r0) goto L20;
            return r0;
        L13:
            if (this.$inTransaction == false) goto L15;
            r18 = CoroutinesRoomKt.getTransactionDispatcher(this.$db);
            goto L16
        L15:
            r18 = CoroutinesRoomKt.getQueryDispatcher(this.$db);
            goto L16
        }
    }

    public CoroutinesRoom$Companion$createFlow$1(boolean r1, RoomDatabase r2, String[] r3, Callable<R> r4, Continuation<? super CoroutinesRoom$Companion$createFlow$1> r5) {
        this.$inTransaction = r1;
        this.$db = r2;
        this.$tableNames = r3;
        this.$callable = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        CoroutinesRoom$Companion$createFlow$1 r6 = new CoroutinesRoom$Companion$createFlow$1(this.$inTransaction, this.$db, this.$tableNames, this.$callable, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<R> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        FlowCollector r6 = (FlowCollector) this.L$0;
        AnonymousClass1 r12 = new AnonymousClass1(this.$inTransaction, this.$db, r6, this.$tableNames, this.$callable, null);
        this.label = 1;
        if (CoroutineScopeKt.coroutineScope(r12, this) != r0) goto L12;
        return r0;
    }
}
