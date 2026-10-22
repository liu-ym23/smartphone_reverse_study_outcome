package com.larus.dora.impl.guide.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import t39.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$launchNextGuide$1", f = "DoraGuideServiceImpl.kt", i = {}, l = {399}, m = "invokeSuspend", n = {}, s = {})
final class GuideSession$launchNextGuide$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuideSession this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.guide.service.GuideSession$launchNextGuide$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$launchNextGuide$1$1", f = "DoraGuideServiceImpl.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ l $next;
        int label;
        final /* synthetic */ GuideSession this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.guide.service.GuideSession$launchNextGuide$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$launchNextGuide$1$1$1", f = "DoraGuideServiceImpl.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00821 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ l $next;
            int label;

            public C00821(l r1, Continuation<? super C00821> r2) {
                this.$next = r1;
                super(1, r2);
            }

            public final Continuation<Unit> create(Continuation<?> r3) {
                return new C00821(this.$next, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                return invoke((Continuation) r1);
            }

            public final Object invoke(Continuation<? super Unit> r2) {
                return create(r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                l r5 = this.$next;
                this.label = 1;
                if (r5.a() != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(GuideSession r1, l r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$next = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$next, r4);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            GuideSession r7 = this.this$0;
            C00821 r2 = new C00821(this.$next, null);
            this.label = 1;
            int r3 = GuideSession.m;
            r7.getClass();
            if (GuideSession.f(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public GuideSession$launchNextGuide$1(GuideSession r1, Continuation<? super GuideSession$launchNextGuide$1> r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new GuideSession$launchNextGuide$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.larus.dora.impl.guide.service.GuideSession$setStateListener$1] */
    public final Object invokeSuspend(Object r12) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L18
    L16:
        l r13 = (l) r12;     // Catch: Exception -> L18
    L29:
        this.this$0.h(GuideSession.GuideSessionState.STARTED);     // Catch: Exception -> L25
        if (r13 == 0) goto L23;
        g49.d.d(this.this$0.c(), "launchNextGuide selected guide=" + r13);     // Catch: Exception -> L25
        GuideSession r0 = this.this$0;     // Catch: Exception -> L25
        r0.i = r13;     // Catch: Exception -> L25
        r0.j.remove(r13);     // Catch: Exception -> L25
        final GuideSession r3 = this.this$0;     // Catch: Exception -> L25
        r3.getClass();     // Catch: Exception -> L25
        r13.b(new GuideSession$setStateListener$1(r3));     // Catch: Exception -> L25
        GuideSession r4 = this.this$0;     // Catch: Exception -> L25
        BuildersKt.launch$default(r4.g, null, null, new AnonymousClass1(r4, r13, null), 3, null);     // Catch: Exception -> L25
    L28:
        return Unit.INSTANCE;
    L23:
        this.this$0.h(GuideSession.GuideSessionState.PAUSED);     // Catch: Exception -> L25
        g49.d.d(this.this$0.c(), "launchNextGuide no guide meets condition");     // Catch: Exception -> L25
    L25:
        e = move-exception;
        this.this$0.h(GuideSession.GuideSessionState.FINISHED);
        g49.d.c(this.this$0.c(), "launchNextGuide failed: " + e.getMessage(), e);
        goto L28
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
        GuideSession r14 = this.this$0;
        if (r14.c != GuideSession.GuideSessionState.FINISHED) goto L13;
        g49.d.e(r14.c(), "launchNextGuide ignored: session already finished id=" + this.this$0.a);
        return Unit.INSTANCE;
    L13:
        this.label = 1;     // Catch: Exception -> L18
        r12 = BuildersKt.withContext(Dispatchers.getIO(), new GuideSession$selectNextGuide$2(r14, null), this);     // Catch: Exception -> L18
        if (r12 != r1) goto L16;
        return r1;
    L18:
        e = move-exception;
        g49.d.c(this.this$0.c(), "launchNextGuide selectNextGuide failed: " + e.getMessage(), e);
        r13 = 0;
        goto L29
    }
}
