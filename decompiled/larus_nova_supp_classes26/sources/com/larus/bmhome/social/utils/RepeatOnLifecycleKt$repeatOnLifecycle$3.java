package com.larus.bmhome.social.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.j;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.utils.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.social.utils.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.utils.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {171}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        public AnonymousClass1(Lifecycle r1, Lifecycle.State r2, CoroutineScope r3, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super AnonymousClass1> r5) {
            this.$this_repeatOnLifecycle = r1;
            this.$state = r2;
            this.$$this$coroutineScope = r3;
            this.$block = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r17) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L12;
            if (r2 != 1) goto L11;
            Function2 r1 = (Function2) this.L$5;
            CoroutineScope r3 = (CoroutineScope) this.L$4;
            Lifecycle r4 = (Lifecycle) this.L$3;
            Lifecycle.State r5 = (Lifecycle.State) this.L$2;
            Ref.ObjectRef r6 = (Ref.ObjectRef) this.L$1;
            Ref.ObjectRef r7 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L8
        L23:
            Job r8 = (Job) r7.element;
            if (r8 == null) goto L26;
            Job.DefaultImpls.cancel$default(r8, null, 1, null);
        L26:
            LifecycleEventObserver r9 = (LifecycleEventObserver) r6.element;
            if (r9 == null) goto L30;
            this.$this_repeatOnLifecycle.removeObserver(r9);
        L30:
            return Unit.INSTANCE;
        L8:
            th = th;
        L33:
            Job r10 = (Job) r7.element;
            if (r10 == null) goto L36;
            Job.DefaultImpls.cancel$default(r10, null, 1, null);
        L36:
            LifecycleEventObserver r11 = (LifecycleEventObserver) r6.element;
            if (r11 == null) goto L39;
            this.$this_repeatOnLifecycle.removeObserver(r11);
        L39:
            throw th;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r17);
            if (this.$this_repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
            final Ref.ObjectRef r12 = new Ref.ObjectRef();
            Ref.ObjectRef r13 = new Ref.ObjectRef();
            Lifecycle.State r14 = this.$state;     // Catch: Throwable -> L31
            Lifecycle r15 = this.$this_repeatOnLifecycle;     // Catch: Throwable -> L31
            final CoroutineScope r16 = this.$$this$coroutineScope;     // Catch: Throwable -> L31
            final Function2<CoroutineScope, Continuation<? super Unit>, Object> r18 = this.$block;     // Catch: Throwable -> L31
            this.L$0 = r12;     // Catch: Throwable -> L31
            this.L$1 = r13;     // Catch: Throwable -> L31
            this.L$2 = r14;     // Catch: Throwable -> L31
            this.L$3 = r15;     // Catch: Throwable -> L31
            this.L$4 = r16;     // Catch: Throwable -> L31
            this.L$5 = r18;     // Catch: Throwable -> L31
            this.label = 1;     // Catch: Throwable -> L31
            final j r19 = new j(IntrinsicsKt.intercepted(this), 1);     // Catch: Throwable -> L31
            r19.C();     // Catch: Throwable -> L31
            Lifecycle.Event.Companion r20 = Lifecycle.Event.Companion;     // Catch: Throwable -> L31
            final Lifecycle.Event r21 = r20.upTo(r14);     // Catch: Throwable -> L31
            final Lifecycle.Event r22 = r20.downFrom(r14);     // Catch: Throwable -> L31
            final MutexImpl r110 = b.a();     // Catch: Throwable -> L31
            LifecycleEventObserver r111 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(r21, r12, r16, r22, r19, r110, r18);     // Catch: Throwable -> L31
            r13.element = r111;     // Catch: Throwable -> L31
            Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");     // Catch: Throwable -> L31
            r15.addObserver(r111);     // Catch: Throwable -> L31
            Object r23 = r19.B();     // Catch: Throwable -> L31
            if (r23 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
            DebugProbesKt.probeCoroutineSuspended(this);     // Catch: Throwable -> L31
        L20:
            if (r23 != r0) goto L22;
            return r0;
        L22:
            r7 = r12;
            r6 = r13;
        L31:
            th = th;
            r7 = r12;
            r6 = r13;
            goto L33
        L15:
            return Unit.INSTANCE;
        }
    }

    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle r1, Lifecycle.State r2, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> r4) {
        this.$this_repeatOnLifecycle = r1;
        this.$state = r2;
        this.$block = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 r0 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        MainCoroutineDispatcher r11 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r2 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, r6, this.$block, null);
        this.label = 1;
        if (BuildersKt.withContext(r11, r2, this) != r0) goto L12;
        return r0;
    }
}
