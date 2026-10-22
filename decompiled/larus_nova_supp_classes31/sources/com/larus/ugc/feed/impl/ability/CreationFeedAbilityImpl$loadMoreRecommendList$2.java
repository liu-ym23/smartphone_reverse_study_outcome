package com.larus.ugc.feed.impl.ability;

import com.larus.im.internal.delegate.c0;
import com.larus.ugc.feed.api.model.CommonCreationFeedDataKmp;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl$loadMoreRecommendList$2", f = "CreationFeedAbilityImpl.kt", i = {0, 1, 2}, l = {705, 729, 741, 747}, m = "invokeSuspend", n = {"requestIndex", "result", "e"}, s = {"I$0", "L$0", "L$0"})
final class CreationFeedAbilityImpl$loadMoreRecommendList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ CreationFeedAbilityImpl this$0;

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl$loadMoreRecommendList$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl$loadMoreRecommendList$2$2", f = "CreationFeedAbilityImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;
        final /* synthetic */ CreationFeedAbilityImpl this$0;

        public AnonymousClass2(CreationFeedAbilityImpl r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            CreationFeedAbilityImpl r3 = this.this$0;
            return r3.l.remove(Boxing.boxInt(r3.g));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl$loadMoreRecommendList$2$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl$loadMoreRecommendList$2$4", f = "CreationFeedAbilityImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;
        final /* synthetic */ CreationFeedAbilityImpl this$0;

        public AnonymousClass4(CreationFeedAbilityImpl r1, Continuation<? super AnonymousClass4> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass4(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            CreationFeedAbilityImpl r3 = this.this$0;
            return r3.l.remove(Boxing.boxInt(r3.g));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl$loadMoreRecommendList$2$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl$loadMoreRecommendList$2$5", f = "CreationFeedAbilityImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;
        final /* synthetic */ CreationFeedAbilityImpl this$0;

        public AnonymousClass5(CreationFeedAbilityImpl r1, Continuation<? super AnonymousClass5> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass5(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            CreationFeedAbilityImpl r3 = this.this$0;
            return r3.l.remove(Boxing.boxInt(r3.g));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CreationFeedAbilityImpl$loadMoreRecommendList$2(CreationFeedAbilityImpl r1, Continuation<? super CreationFeedAbilityImpl$loadMoreRecommendList$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationFeedAbilityImpl$loadMoreRecommendList$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r14 = 0;
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        ResultKt.throwOnFailure(r17);
    L68:
        this.this$0.b.update(new r());
    L70:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        CancellationException r0 = (CancellationException) this.L$0;
        ResultKt.throwOnFailure(r17);
        throw r0;
    L12:
        Pair r2 = (Pair) this.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L63 CancellationException -> L71
        Continuation r12 = null;
    L48:
        if (r2 == null) goto L50;
        Continuation r6 = (m0a.j) r2.getSecond();     // Catch: Throwable -> L27 CancellationException -> L29
    L52:
        if ((r6 instanceof m0a.j.a) == false) goto L54;
        Continuation r7 = (m0a.j.a) r6;     // Catch: Throwable -> L27 CancellationException -> L29
    L55:
        if (r7 != null) goto L57;
    L59:
        if (r14 == 0) goto L61;
        CreationFeedAbilityImpl.b(this.this$0, "coroutine CancellationException");     // Catch: Throwable -> L27 CancellationException -> L29
        goto L70
    L61:
        this.this$0.b.update(new q());     // Catch: Throwable -> L27 CancellationException -> L29
        goto L70
    L57:
        if (r7.a != (-1001)) goto L59;
        r14 = 1;
        goto L59
    L54:
        r7 = r12;
        goto L55
    L50:
        r6 = r12;
        goto L52
    L15:
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L63 CancellationException -> L71
        int r11 = r3;
        r12 = null;
        Object r4 = r17;
    L26:
        Pair r8 = (Pair) r4;     // Catch: Throwable -> L27 CancellationException -> L29
        int r5 = r11;
    L32:
        CreationFeedAbilityImpl.b(this.this$0, "end loadMoreRecommendList:" + r8);     // Catch: Throwable -> L27 CancellationException -> L29
        if (r8 == null) goto L35;
        Continuation r10 = (CommonCreationFeedDataKmp) r8.getFirst();     // Catch: Throwable -> L27 CancellationException -> L29
    L36:
        if (r10 == null) goto L44;
        CreationFeedAbilityImpl r13 = this.this$0;     // Catch: Throwable -> L27 CancellationException -> L29
        r13.g++;     // Catch: Throwable -> L27 CancellationException -> L29
        r13.h = r10.getNextCursor();     // Catch: Throwable -> L27 CancellationException -> L29
        this.this$0.u(r5, r10, true, false);     // Catch: Throwable -> L27 CancellationException -> L29
        final CreationFeedAbilityImpl r15 = this.this$0;     // Catch: Throwable -> L27 CancellationException -> L29
        r15.b.update(new p(r15));     // Catch: Throwable -> L27 CancellationException -> L29
        CreationFeedAbilityImpl r16 = this.this$0;     // Catch: Throwable -> L27 CancellationException -> L29
        StringBuilder r18 = new StringBuilder("loadMoreRecommendList templateList size:");     // Catch: Throwable -> L27 CancellationException -> L29
        List r19 = r10.getCreationList();     // Catch: Throwable -> L27 CancellationException -> L29
        if (r19 != null) goto L42;
        r19 = r10.getCreationGroupList();     // Catch: Throwable -> L27 CancellationException -> L29
        if (r19 != null) goto L42;
    L43:
        r18.append(r14);     // Catch: Throwable -> L27 CancellationException -> L29
        CreationFeedAbilityImpl.b(r16, r18.toString());     // Catch: Throwable -> L27 CancellationException -> L29
    L42:
        r14 = r19.size();     // Catch: Throwable -> L27 CancellationException -> L29
        goto L43
    L44:
        MainCoroutineDispatcher r20 = Dispatchers.getMain();     // Catch: Throwable -> L27 CancellationException -> L29
        AnonymousClass2 r21 = new AnonymousClass2(this.this$0, r12);     // Catch: Throwable -> L27 CancellationException -> L29
        this.L$0 = r8;     // Catch: Throwable -> L27 CancellationException -> L29
        this.label = 2;     // Catch: Throwable -> L27 CancellationException -> L29
        if (BuildersKt.withContext(r20, r21, this) != r9) goto L47;
        return r9;
    L47:
        r2 = r8;
        goto L48
    L35:
        r10 = r12;
        goto L36
    L18:
        ResultKt.throwOnFailure(r17);
        CreationFeedAbilityImpl r22 = this.this$0;
        int r23 = r22.g;
        r22.p("start loadMoreRecommendList," + this.this$0.g);
        m0a.l r24 = this.this$0.n();     // Catch: Throwable -> L63 CancellationException -> L71
        if (r24 == null) goto L31;
        CreationFeedAbilityImpl r25 = this.this$0;     // Catch: Throwable -> L63 CancellationException -> L71
        int r26 = r25.g;     // Catch: Throwable -> L63 CancellationException -> L71
        String r27 = r25.h;     // Catch: Throwable -> L63 CancellationException -> L71
        Long r110 = Boxing.boxLong(r25.f);     // Catch: Throwable -> L63 CancellationException -> L71
        this.I$0 = r23;     // Catch: Throwable -> L63 CancellationException -> L71
        this.label = 1;     // Catch: Throwable -> L63 CancellationException -> L71
        r11 = r23;
        r12 = null;
        r4 = r24.a(r26, r27, r110, "load_more", this);     // Catch: Throwable -> L27 CancellationException -> L29
        if (r4 != r9) goto L26;
        return r9;
    L29:
        e = e;
    L73:
        CreationFeedAbilityImpl.b(this.this$0, "coroutine CancellationException");
        MainCoroutineDispatcher r28 = Dispatchers.getMain();
        AnonymousClass4 r29 = new AnonymousClass4(this.this$0, r12);
        this.L$0 = e;
        this.label = 3;
        if (BuildersKt.withContext(r28, r29, this) != r9) goto L79;
        return r9;
    L79:
        throw e;
    L27:
        th = th;
    L65:
        CreationFeedAbilityImpl r30 = this.this$0;
        int r31 = CreationFeedAbilityImpl.o;
        r30.getClass();
        c0.b.e("CreationFeedAbilityImpl", "loadMoreRecommendList timeout, " + th);
        MainCoroutineDispatcher r32 = Dispatchers.getMain();
        AnonymousClass5 r33 = new AnonymousClass5(this.this$0, r12);
        this.L$0 = r12;
        this.label = 4;
        if (BuildersKt.withContext(r32, r33, this) != r9) goto L68;
        return r9;
    L31:
        r12 = null;
        r5 = r23;
        r8 = null;
    L71:
        e = e;
        r12 = null;
    L63:
        th = th;
        r12 = null;
        goto L65
    }
}
