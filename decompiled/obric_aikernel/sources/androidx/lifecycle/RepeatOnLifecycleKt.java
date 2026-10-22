package androidx.lifecycle;

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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes.dex */
public final class RepeatOnLifecycleKt {

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<l0, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
        @SourceDebugExtension({"SMAP\nRepeatOnLifecycle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,165:1\n314#2,11:166\n*S KotlinDebug\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n*L\n97#1:166,11\n*E\n"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
            final /* synthetic */ l0 $$this$coroutineScope;
            final /* synthetic */ Function2<l0, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ Lifecycle.State $state;
            final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Lifecycle r10, Lifecycle.State r11, l0 r12, Function2<? super l0, ? super Continuation<? super Unit>, ? extends Object> r13, Continuation<? super AnonymousClass1> r14) {
                this.$this_repeatOnLifecycle = r10;
                this.$state = r11;
                this.$$this$coroutineScope = r12;
                this.$block = r13;
                super(2, r14);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
                return invoke2(r10, r11);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
                return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference failed for: r10v0, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, java.lang.Object] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r17) {
                Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r11 = this.label;
                if (r11 == 0) goto L12;
                if (r11 != 1) goto L11;
                Function2 r12 = (Function2) this.L$5;
                l0 r13 = (l0) this.L$4;
                Lifecycle r14 = (Lifecycle) this.L$3;
                Lifecycle.State r15 = (Lifecycle.State) this.L$2;
                Ref.ObjectRef r16 = (Ref.ObjectRef) this.L$1;
                Ref.ObjectRef r18 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L8
            L23:
                v1 r19 = (v1) r18.element;
                if (r19 == null) goto L26;
                v1.a.a(r19, null, 1, null);
            L26:
                LifecycleEventObserver r20 = (LifecycleEventObserver) r16.element;
                if (r20 == null) goto L30;
                this.$this_repeatOnLifecycle.removeObserver(r20);
            L30:
                return Unit.INSTANCE;
            L8:
                th = th;
            L33:
                v1 r21 = (v1) r18.element;
                if (r21 == null) goto L36;
                v1.a.a(r21, null, 1, null);
            L36:
                LifecycleEventObserver r22 = (LifecycleEventObserver) r16.element;
                if (r22 == null) goto L39;
                this.$this_repeatOnLifecycle.removeObserver(r22);
            L39:
                throw th;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                ResultKt.throwOnFailure(r17);
                if (this.$this_repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
                final Ref.ObjectRef r23 = new Ref.ObjectRef();
                Ref.ObjectRef r110 = new Ref.ObjectRef();
                Lifecycle.State r24 = this.$state;     // Catch: Throwable -> L31
                Lifecycle r111 = this.$this_repeatOnLifecycle;     // Catch: Throwable -> L31
                final l0 r25 = this.$$this$coroutineScope;     // Catch: Throwable -> L31
                final Function2<l0, Continuation<? super Unit>, Object> r112 = this.$block;     // Catch: Throwable -> L31
                this.L$0 = r23;     // Catch: Throwable -> L31
                this.L$1 = r110;     // Catch: Throwable -> L31
                this.L$2 = r24;     // Catch: Throwable -> L31
                this.L$3 = r111;     // Catch: Throwable -> L31
                this.L$4 = r25;     // Catch: Throwable -> L31
                this.L$5 = r112;     // Catch: Throwable -> L31
                this.label = 1;     // Catch: Throwable -> L31
                final o r113 = new o(IntrinsicsKt.intercepted(this), 1);     // Catch: Throwable -> L31
                r113.F();     // Catch: Throwable -> L31
                Lifecycle.Event.Companion r26 = Lifecycle.Event.Companion;     // Catch: Throwable -> L31
                final Lifecycle.Event r27 = r26.upTo(r24);     // Catch: Throwable -> L31
                final Lifecycle.Event r28 = r26.downFrom(r24);     // Catch: Throwable -> L31
                final kotlinx.coroutines.sync.a r114 = MutexKt.b(false, 1, null);     // Catch: Throwable -> L31
                ?? r115 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(r27, r23, r25, r28, r113, r114, r112);     // Catch: Throwable -> L31
                r110.element = r115;     // Catch: Throwable -> L31
                Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");     // Catch: Throwable -> L31
                r111.addObserver((LifecycleEventObserver) r115);     // Catch: Throwable -> L31
                Object r29 = r113.B();     // Catch: Throwable -> L31
                if (r29 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
                DebugProbesKt.probeCoroutineSuspended(this);     // Catch: Throwable -> L31
            L20:
                if (r29 != r10) goto L22;
                return r10;
            L22:
                r18 = r23;
                r16 = r110;
            L31:
                th = th;
                r18 = r23;
                r16 = r110;
                goto L33
            L15:
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Lifecycle r10, Lifecycle.State r11, Function2<? super l0, ? super Continuation<? super Unit>, ? extends Object> r12, Continuation<? super AnonymousClass3> r13) {
            this.$this_repeatOnLifecycle = r10;
            this.$state = r11;
            this.$block = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass3 r12 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass3) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            l0 r13 = (l0) this.L$0;
            g2 r14 = z0.c().c0();
            AnonymousClass1 r15 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, r13, this.$block, null);
            this.label = 1;
            if (h.g(r14, r15, this) != r11) goto L12;
            return r11;
        }
    }

    public static final Object repeatOnLifecycle(Lifecycle r10, Lifecycle.State r11, Function2<? super l0, ? super Continuation<? super Unit>, ? extends Object> r12, Continuation<? super Unit> r13) {
        if (r11 == Lifecycle.State.INITIALIZED) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L17;
        if (r10.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        Object r15 = m0.d(new AnonymousClass3(r10, r11, r12, null), r13);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r15;
    L15:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L17:
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    L5:
        r14 = false;
        goto L6
    }

    public static final Object repeatOnLifecycle(LifecycleOwner r10, Lifecycle.State r11, Function2<? super l0, ? super Continuation<? super Unit>, ? extends Object> r12, Continuation<? super Unit> r13) {
        Object r14 = repeatOnLifecycle(r10.getLifecycle(), r11, r12, r13);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r14;
    L6:
        return Unit.INSTANCE;
    }
}
