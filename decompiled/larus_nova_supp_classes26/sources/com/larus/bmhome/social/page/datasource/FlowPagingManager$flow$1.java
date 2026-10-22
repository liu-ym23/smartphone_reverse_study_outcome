package com.larus.bmhome.social.page.datasource;

import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.social.page.datasource.diff.CoroutineExtKt;
import com.larus.bmhome.social.page.datasource.event.ConflatedFlow;
import com.larus.bmhome.social.page.datasource.event.ConflatedFlow$special$$inlined$mapNotNull$1;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Add missing generic type declarations: [Event] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Event", "Lcom/larus/bmhome/social/page/datasource/event/IActionEvent;", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1", f = "FlowPagingManager.kt", i = {0, 1}, l = {97, 111, 126, 134}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
public final class FlowPagingManager$flow$1<Event> extends SuspendLambda implements Function2<FlowCollector<? super Event>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FlowPagingManager<T, Key, Event> this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$1", f = "FlowPagingManager.kt", i = {}, l = {GuidePriority.DEEP_RESEARCH_PRIORITY}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<Event> $$this$flow;
        int label;
        final /* synthetic */ FlowPagingManager<T, Key, Event> this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$1$1", f = "FlowPagingManager.kt", i = {0, 1, 2}, l = {298, 104, 104}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$0"})
        public static final class C00321 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
            final /* synthetic */ FlowCollector<Event> $$this$flow;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ FlowPagingManager<T, Key, Event> this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public C00321(FlowPagingManager<T, Key, Event> r1, FlowCollector<? super Event> r2, Continuation<? super C00321> r3) {
                this.this$0 = r1;
                this.$$this$flow = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00321(this.this$0, this.$$this$flow, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((Unit) r1, (Continuation) r2);
            }

            public final Object invoke(Unit r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r11) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L16;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L12;
                if (r1 != 3) goto L11;
                FlowCollector<Event> r2 = (FlowCollector) this.L$2;
                FlowPagingManager r6 = (FlowPagingManager) this.L$1;
                kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) this.L$0;
                ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L39
            L19:
                C00321 r12 = this;
            L21:
                if ((!r6.c.isEmpty()) == false) goto L36;
                com.larus.bmhome.social.page.datasource.event.e r8 = r6.c.poll();     // Catch: Throwable -> L39
                if (r8 == null) goto L21;
                r12.L$0 = r7;     // Catch: Throwable -> L39
                r12.L$1 = r6;     // Catch: Throwable -> L39
                r12.L$2 = r2;     // Catch: Throwable -> L39
                r12.label = 2;     // Catch: Throwable -> L39
                Object r9 = FlowPagingManager.a(r6, r8, r12);     // Catch: Throwable -> L39
                if (r9 != r0) goto L27;
                return r0;
            L27:
                Object r10 = r0;
                C00321 r3 = r12;
                r11 = r9;
                kotlinx.coroutines.sync.a r13 = r7;
                FlowPagingManager r14 = r6;
                FlowCollector<Event> r15 = r2;
                Object r4 = r10;
            L45:
                com.larus.bmhome.social.page.datasource.event.a r16 = (com.larus.bmhome.social.page.datasource.event.a) r11;     // Catch: Throwable -> L34
                if (r16 == null) goto L33;
                r3.L$0 = r13;     // Catch: Throwable -> L34
                r3.L$1 = r14;     // Catch: Throwable -> L34
                r3.L$2 = r15;     // Catch: Throwable -> L34
                r3.label = 3;     // Catch: Throwable -> L34
                if (r15.emit(r16, r3) != r4) goto L33;
                return r4;
            L33:
                r12 = r3;
                r0 = r4;
                r2 = r15;
                r6 = r14;
                r7 = r13;
                goto L21
            L47:
                r12 = r3;
                r0 = r4;
                r2 = r15;
                r6 = r14;
                r7 = r13;
            L34:
                th = th;
            L41:
                r13.unlock(null);
                throw th;
            L36:
                Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L39
                r7.unlock(null);
                return Unit.INSTANCE;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                FlowCollector<Event> r5 = (FlowCollector) this.L$2;
                FlowPagingManager r18 = (FlowPagingManager) this.L$1;
                kotlinx.coroutines.sync.a r19 = (kotlinx.coroutines.sync.a) this.L$0;
                ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L39
                r13 = r19;
                r14 = r18;
                r15 = r5;
                r4 = r0;
                r3 = this;
                goto L45
            L15:
                r2 = (FlowCollector) this.L$2;
                r6 = (FlowPagingManager) this.L$1;
                r7 = (kotlinx.coroutines.sync.a) this.L$0;
                ResultKt.throwOnFailure(r11);
                goto L19
            L16:
                ResultKt.throwOnFailure(r11);
                r6 = this.this$0;
                r7 = r6.g;
                r2 = this.$$this$flow;
                this.L$0 = r7;
                this.L$1 = r6;
                this.L$2 = r2;
                this.label = 1;
                if (r7.a(null, this) != r0) goto L19;
                return r0;
            L39:
                th = th;
                r13 = r7;
                goto L41
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(FlowPagingManager<T, Key, Event> r1, FlowCollector<? super Event> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$$this$flow = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$$this$flow, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            FlowPagingManager<T, Key, Event> r8 = this.this$0;
            ConflatedFlow$special$$inlined$mapNotNull$1 r2 = r8.e.c;
            C00321 r3 = new C00321(r8, this.$$this$flow, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.e.i(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$2", f = "FlowPagingManager.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowPagingManager<T, Key, Event> this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements FlowCollector {
            public final /* synthetic */ FlowPagingManager<T, Key, Event> a;

            public AnonymousClass1(FlowPagingManager<T, Key, Event> r1) {
                this.a = r1;
            }

            public final Object a(boolean r6, Continuation<? super Unit> r7) {
                if ((r7 instanceof FlowPagingManager$flow$1$2$1$emit$1) == false) goto L7;
                FlowPagingManager$flow$1$2$1$emit$1 r0 = (FlowPagingManager$flow$1$2$1$emit$1) r7;
                int r1 = r0.label;
                if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
                r0.label = r1 - Integer.MIN_VALUE;
            L8:
                Object r8 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                boolean r4 = true;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                r6 = r0.Z$0;
                FlowPagingManager r5 = (FlowPagingManager) r0.L$1;
                kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) r0.L$0;
                ResultKt.throwOnFailure(r8);
            L31:
                r5.c.clear();     // Catch: Throwable -> L28
                ConcurrentLinkedQueue<com.larus.bmhome.social.page.datasource.event.e> r10 = r5.c;     // Catch: Throwable -> L28
                if (r6 == false) goto L22;
                r4 = false;
            L22:
                r10.add(new com.larus.bmhome.social.page.datasource.event.e.b(r4));     // Catch: Throwable -> L28
                if (r6 == false) goto L25;
                r5.c.add(com.larus.bmhome.social.page.datasource.event.e.a.C0035a.a);     // Catch: Throwable -> L28
                r5.c.add(com.larus.bmhome.social.page.datasource.event.e.a.b.a);     // Catch: Throwable -> L28
            L25:
                Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L28
                r9.unlock(null);
                ConflatedFlow<Unit> r12 = this.a.e;
                Unit r13 = Unit.INSTANCE;
                r12.b(r13);
                return r13;
            L28:
                th = move-exception;
                r9.unlock(null);
                throw th;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r8);
                FlowPagingManager r14 = this.a;
                kotlinx.coroutines.sync.a r15 = r14.g;
                r0.L$0 = r15;
                r0.L$1 = r14;
                r0.Z$0 = r6;
                r0.label = 1;
                if (r15.a(null, r0) != r2) goto L17;
                return r2;
            L17:
                r5 = r14;
                r9 = r15;
            L7:
                r0 = new FlowPagingManager$flow$1$2$1$emit$1(this, r7);
                goto L8
            }

            public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
                return a(((Boolean) r1).booleanValue(), r2);
            }
        }

        public AnonymousClass2(FlowPagingManager<T, Key, Event> r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            FlowPagingManager<T, Key, Event> r6 = this.this$0;
            ConflatedFlow$special$$inlined$mapNotNull$1 r2 = r6.d.c;
            AnonymousClass1 r3 = new AnonymousClass1(r6);
            this.label = 1;
            if (r2.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$3", f = "FlowPagingManager.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<Event> $$this$flow;
        int label;
        final /* synthetic */ FlowPagingManager<T, Key, Event> this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.FlowPagingManager$flow$1$3$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ FlowCollector<Event> a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(FlowCollector<? super Event> r1) {
                this.a = r1;
            }

            public final Object emit(Object r2, Continuation r3) {
                FlowCollector<Event> r0 = this.a;
                Object r4 = r0.emit((com.larus.bmhome.social.page.datasource.event.a) r2, r3);
                if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r4;
            L6:
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(FlowPagingManager<T, Key, Event> r1, FlowCollector<? super Event> r2, Continuation<? super AnonymousClass3> r3) {
            this.this$0 = r1;
            this.$$this$flow = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass3(this.this$0, this.$$this$flow, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MutableSharedFlow<Event> r6 = this.this$0.h;
            a r2 = new a(this.$$this$flow);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public FlowPagingManager$flow$1(FlowPagingManager<T, Key, Event> r1, Continuation<? super FlowPagingManager$flow$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FlowPagingManager$flow$1 r0 = new FlowPagingManager$flow$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super Event> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        if (r1 != 3) goto L8;
        ResultKt.throwOnFailure(r8);
    L25:
        ((a) this.this$0.a.getValue()).getClass();
    L26:
        ((a) this.this$0.a.getValue()).getClass();
        return Unit.INSTANCE;
    L8:
        if (r1 != 4) goto L11;
        ResultKt.throwOnFailure(r8);
        goto L26
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        FlowCollector r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r8);
    L22:
        AnonymousClass3 r9 = new AnonymousClass3(this.this$0, r2, null);
        this.L$0 = null;
        this.label = 3;
        if (CoroutineExtKt.a(EmptyCoroutineContext.INSTANCE, r9, this) != r0) goto L25;
        return r0;
    L14:
        r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r8);
    L19:
        AnonymousClass2 r10 = new AnonymousClass2(this.this$0, null);
        this.L$0 = r2;
        this.label = 2;
        if (CoroutineExtKt.a(EmptyCoroutineContext.INSTANCE, r10, this) != r0) goto L22;
        return r0;
    L15:
        ResultKt.throwOnFailure(r8);
        FlowCollector r11 = (FlowCollector) this.L$0;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, r11, null);
        this.L$0 = r11;
        this.label = 1;
        if (CoroutineExtKt.a(EmptyCoroutineContext.INSTANCE, r3, this) != r0) goto L18;
        return r0;
    L18:
        r2 = r11;
        goto L19
    }
}
