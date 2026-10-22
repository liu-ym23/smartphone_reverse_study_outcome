package androidx.lifecycle;

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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.l;
import kotlinx.coroutines.sync.d;
import kotlinx.coroutines.sync.e;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"repeatOnLifecycle", "", "Landroidx/lifecycle/Lifecycle;", "state", "Landroidx/lifecycle/Lifecycle$State;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RepeatOnLifecycleKt {

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
        @SourceDebugExtension({"SMAP\nRepeatOnLifecycle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,165:1\n314#2,11:166\n*S KotlinDebug\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n*L\n97#1:166,11\n*E\n"})
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

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Lifecycle r5, Lifecycle.State r10, CoroutineScope r11, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r12, Continuation<? super AnonymousClass1> r13) {
                this.$this_repeatOnLifecycle = r5;
                this.$state = r10;
                this.$$this$coroutineScope = r11;
                this.$block = r12;
                super(2, r13);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
                return invoke2(r5, r10);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r15v0, types: [T, androidx.lifecycle.LifecycleObserver, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, java.lang.Object] */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r17) {
                Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r10 = this.label;
                if (r10 == 0) goto L12;
                if (r10 != 1) goto L11;
                Function2 r11 = (Function2) this.L$5;
                CoroutineScope r12 = (CoroutineScope) this.L$4;
                Lifecycle r13 = (Lifecycle) this.L$3;
                Lifecycle.State r14 = (Lifecycle.State) this.L$2;
                Ref.ObjectRef r15 = (Ref.ObjectRef) this.L$1;
                Ref.ObjectRef r16 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L8
            L26:
                Job r18 = (Job) r16.element;
                if (r18 == null) goto L29;
                r18.cancel(null);
            L29:
                LifecycleEventObserver r19 = (LifecycleEventObserver) r15.element;
                if (r19 == null) goto L33;
                this.$this_repeatOnLifecycle.removeObserver(r19);
            L33:
                return Unit.INSTANCE;
            L8:
                th = th;
            L34:
                Job r20 = (Job) r16.element;
                if (r20 == null) goto L37;
                r20.cancel(null);
            L37:
                LifecycleEventObserver r21 = (LifecycleEventObserver) r15.element;
                if (r21 == null) goto L40;
                this.$this_repeatOnLifecycle.removeObserver(r21);
            L40:
                throw th;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                ResultKt.throwOnFailure(r17);
                if (this.$this_repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
                final Ref.ObjectRef r22 = new Ref.ObjectRef();
                Ref.ObjectRef r110 = new Ref.ObjectRef();
                Lifecycle.State r23 = this.$state;     // Catch: Throwable -> L21
                Lifecycle r111 = this.$this_repeatOnLifecycle;     // Catch: Throwable -> L21
                final CoroutineScope r24 = this.$$this$coroutineScope;     // Catch: Throwable -> L21
                final Function2<CoroutineScope, Continuation<? super Unit>, Object> r112 = this.$block;     // Catch: Throwable -> L21
                this.L$0 = r22;     // Catch: Throwable -> L21
                this.L$1 = r110;     // Catch: Throwable -> L21
                this.L$2 = r23;     // Catch: Throwable -> L21
                this.L$3 = r111;     // Catch: Throwable -> L21
                this.L$4 = r24;     // Catch: Throwable -> L21
                this.L$5 = r112;     // Catch: Throwable -> L21
                this.label = 1;     // Catch: Throwable -> L21
                final l r113 = new l(1, IntrinsicsKt.intercepted(this));     // Catch: Throwable -> L21
                r113.w();     // Catch: Throwable -> L21
                Lifecycle.Event.Companion r25 = Lifecycle.Event.Companion;     // Catch: Throwable -> L21
                final Lifecycle.Event r26 = r25.upTo(r23);     // Catch: Throwable -> L21
                final Lifecycle.Event r27 = r25.downFrom(r23);     // Catch: Throwable -> L21
                final d r114 = e.a();     // Catch: Throwable -> L21
                ?? r115 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(r26, r22, r24, r27, r113, r114, r112);     // Catch: Throwable -> L21
                r110.element = r115;     // Catch: Throwable -> L21
                Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");     // Catch: Throwable -> L21
                r111.addObserver(r115);     // Catch: Throwable -> L21
                Object r28 = r113.v();     // Catch: Throwable -> L21
                if (r28 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
                DebugProbesKt.probeCoroutineSuspended(this);     // Catch: Throwable -> L21
            L23:
                if (r28 != r5) goto L25;
                return r5;
            L25:
                r16 = r22;
                r15 = r110;
            L21:
                th = th;
                r16 = r22;
                r15 = r110;
                goto L34
            L15:
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
                return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Lifecycle r5, Lifecycle.State r10, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super AnonymousClass3> r12) {
            this.$this_repeatOnLifecycle = r5;
            this.$state = r10;
            this.$block = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass3 r11 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            MainCoroutineDispatcher r13 = Dispatchers.getMain().getImmediate();
            AnonymousClass1 r14 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, r12, this.$block, null);
            this.label = 1;
            if (BuildersKt.withContext(r13, r14, this) != r5) goto L12;
            return r5;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass3) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public static final Object repeatOnLifecycle(Lifecycle r5, Lifecycle.State r10, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super Unit> r12) {
        if (r10 == Lifecycle.State.INITIALIZED) goto L14;
        if (r5.getCurrentState() == Lifecycle.State.DESTROYED) goto L7;
        Object r13 = h0.d(new AnonymousClass3(r5, r10, r11, null), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r13;
    L12:
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L14:
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
    }

    public static final Object repeatOnLifecycle(LifecycleOwner r5, Lifecycle.State r10, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super Unit> r12) {
        Object r13 = repeatOnLifecycle(r5.getLifecycle(), r10, r11, r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }
}
