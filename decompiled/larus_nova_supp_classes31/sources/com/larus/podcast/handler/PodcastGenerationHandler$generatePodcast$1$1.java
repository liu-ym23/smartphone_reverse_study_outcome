package com.larus.podcast.handler;

import com.larus.network.http.f;
import com.larus.network.http.y;
import com.larus.podcast.api.PodcastClickSource;
import com.larus.podcast.api.PodcastGenerateApiKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import t19.s;
import vr9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.podcast.handler.PodcastGenerationHandler$generatePodcast$1$1", f = "PodcastGenerationHandler.kt", i = {}, l = {TraceLevel.ABOVE_DEBUG, 66, 85}, m = "invokeSuspend", n = {}, s = {})
public final class PodcastGenerationHandler$generatePodcast$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onFail;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ a $podcastGenerateContext;
    final /* synthetic */ a $this_run;
    int label;

    /* JADX INFO: renamed from: com.larus.podcast.handler.PodcastGenerationHandler$generatePodcast$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.podcast.handler.PodcastGenerationHandler$generatePodcast$1$1$1", f = "PodcastGenerationHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onFail;
        int label;

        public AnonymousClass1(Function0<Unit> r1, Continuation<? super AnonymousClass1> r2) {
            this.$onFail = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$onFail, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            Function0<Unit> r3 = this.$onFail;
            if (r3 == null) goto L8;
            r3.invoke();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.podcast.handler.PodcastGenerationHandler$generatePodcast$1$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.podcast.handler.PodcastGenerationHandler$generatePodcast$1$1$2", f = "PodcastGenerationHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.BooleanRef $bizRequestSuccess;
        final /* synthetic */ Function0<Unit> $onFail;
        final /* synthetic */ Function0<Unit> $onSuccess;
        int label;

        public AnonymousClass2(Ref.BooleanRef r1, Function0<Unit> r2, Function0<Unit> r3, Continuation<? super AnonymousClass2> r4) {
            this.$bizRequestSuccess = r1;
            this.$onSuccess = r2;
            this.$onFail = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$bizRequestSuccess, this.$onSuccess, this.$onFail, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r2);
            if (this.$bizRequestSuccess.element == false) goto L9;
            Function0<Unit> r3 = this.$onSuccess;
            if (r3 == null) goto L13;
            r3.invoke();
        L13:
            return Unit.INSTANCE;
        L9:
            Function0<Unit> r4 = this.$onFail;
            if (r4 == null) goto L13;
            r4.invoke();
            goto L13
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public PodcastGenerationHandler$generatePodcast$1$1(a r1, a r2, Function0<Unit> r3, Function0<Unit> r4, Continuation<? super PodcastGenerationHandler$generatePodcast$1$1> r5) {
        this.$podcastGenerateContext = r1;
        this.$this_run = r2;
        this.$onFail = r3;
        this.$onSuccess = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new PodcastGenerationHandler$generatePodcast$1$1(this.$podcastGenerateContext, this.$this_run, this.$onFail, this.$onSuccess, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r5 = true;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r12);
    L61:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r12);
    L35:
        f r13 = (com.larus.network.http.a) r12;
        if ((r13 instanceof f) == false) goto L41;
        FLogger.a.e("PodcastMenuHandler", "handleAction: generatePodcast failed, " + r13.d);
        s.a.g(this.$this_run.getContext(), 2131899651, false);
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$onFail, null);
        this.label = 2;
        if (BuildersKt.withContext(r14, r2, this) != r0) goto L61;
        return r0;
    L41:
        if ((r13 instanceof y) == false) goto L61;
        Ref.BooleanRef r3 = new Ref.BooleanRef();
        r3.element = true;
        com.larus.podcast.api.a r15 = (com.larus.podcast.api.a) ((com.larus.network.http.a) ((y) r13)).b;
        if (r15 != null) goto L45;
    L47:
        boolean r4 = false;
    L48:
        if (r4 == false) goto L50;
        s.a.g(this.$this_run.getContext(), 2131908399, false);
        r3.element = false;
    L50:
        if (r15 != null) goto L52;
    L54:
        r5 = false;
    L55:
        if (r5 == false) goto L57;
        s.a.g(this.$this_run.getContext(), 2131899651, false);
        r3.element = false;
    L57:
        FLogger.a.i("PodcastMenuHandler", "handleAction: generatePodcast success, bizRequestSuccess=" + r3.element);
        MainCoroutineDispatcher r16 = Dispatchers.getMain();
        AnonymousClass2 r6 = new AnonymousClass2(r3, this.$onSuccess, this.$onFail, null);
        this.label = 3;
        if (BuildersKt.withContext(r16, r6, this) != r0) goto L61;
        return r0;
    L52:
        if (r15.c() != true) goto L54;
    L45:
        if (r15.a() != 1) goto L47;
        r4 = true;
        goto L48
    L12:
        ResultKt.throwOnFailure(r12);
        String r17 = this.$podcastGenerateContext.c;
        if (r17 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == false) goto L22;
        FLogger.a.i("PodcastMenuHandler", "handleAction: messageId is empty");
        return Unit.INSTANCE;
    L22:
        String r8 = this.$podcastGenerateContext.d;
        if (r8 != null) goto L25;
    L28:
        boolean r9 = true;
    L29:
        if (r9 == false) goto L32;
        FLogger.a.i("PodcastMenuHandler", "handleAction: conversationId is empty");
        return Unit.INSTANCE;
    L32:
        a r10 = this.$this_run;
        boolean r11 = r10.e;
        PodcastClickSource r18 = r10.f;
        this.label = 1;
        r12 = PodcastGenerateApiKt.a(r17, r11, r18, r8, this);
        if (r12 != r0) goto L35;
        return r0;
    L25:
        if (r8.length() == 0) goto L28;
        r9 = false;
        goto L29
    L15:
        if (r17.length() == 0) goto L18;
        r7 = false;
        goto L19
    }
}
