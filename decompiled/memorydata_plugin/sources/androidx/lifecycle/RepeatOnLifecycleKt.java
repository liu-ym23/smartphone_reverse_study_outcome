package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.c;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"repeatOnLifecycle", "", "Landroidx/lifecycle/Lifecycle;", "state", "Landroidx/lifecycle/Lifecycle$State;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RepeatOnLifecycleKt {

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<al, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ al $$this$coroutineScope;
            final /* synthetic */ Function2<al, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ Lifecycle.State $state;
            final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            AnonymousClass1(Lifecycle r3, Lifecycle.State r4, al r5, Function2<? super al, ? super Continuation<? super Unit>, ? extends Object> r6, Continuation<? super AnonymousClass1> r7) {
                al r8 = (al) ZeusTransformUtils.wrapperContextForParams(r5, al.class, "com.obric.memorydata.plugin");
                Function2<al, Continuation<? super Unit>, Object> r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                this.$this_repeatOnLifecycle = r3;
                this.$state = r4;
                this.$$this$coroutineScope = r8;
                this.$block = r9;
                super(2, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, r6), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference failed for: r8v1, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r19) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r2 = this.label;
                if (r2 == 0) goto L12;
                if (r2 != 1) goto L11;
                Function2 r1 = (Function2) ZeusTransformUtils.preCheckCast(this.L$5, Function2.class, "com.obric.memorydata.plugin");
                al r3 = (al) ZeusTransformUtils.preCheckCast(this.L$4, al.class, "com.obric.memorydata.plugin");
                Lifecycle r4 = (Lifecycle) ZeusTransformUtils.preCheckCast(this.L$3, Lifecycle.class, "com.obric.memorydata.plugin");
                Lifecycle.State r5 = (Lifecycle.State) ZeusTransformUtils.preCheckCast(this.L$2, Lifecycle.State.class, "com.obric.memorydata.plugin");
                Ref.ObjectRef r6 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
                Ref.ObjectRef r7 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L8
            L23:
                bx r8 = (bx) ZeusTransformUtils.preCheckCast(r7.element, bx.class, "com.obric.memorydata.plugin");
                if (r8 == null) goto L26;
                bx.a.a(r8, null, 1, null);
            L26:
                LifecycleEventObserver r9 = (LifecycleEventObserver) ZeusTransformUtils.preCheckCast(r6.element, LifecycleEventObserver.class, "com.obric.memorydata.plugin");
                if (r9 == null) goto L30;
                this.$this_repeatOnLifecycle.removeObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(r9, LifecycleObserver.class, "com.obric.memorydata.plugin"));
            L30:
                return Unit.INSTANCE;
            L8:
                th = th;
            L33:
                bx r10 = (bx) ZeusTransformUtils.preCheckCast(r7.element, bx.class, "com.obric.memorydata.plugin");
                if (r10 == null) goto L36;
                bx.a.a(r10, null, 1, null);
            L36:
                LifecycleEventObserver r11 = (LifecycleEventObserver) ZeusTransformUtils.preCheckCast(r6.element, LifecycleEventObserver.class, "com.obric.memorydata.plugin");
                if (r11 == null) goto L39;
                this.$this_repeatOnLifecycle.removeObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(r11, LifecycleObserver.class, "com.obric.memorydata.plugin"));
            L39:
                throw th;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                ResultKt.throwOnFailure(r19);
                if (this.$this_repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
                final Ref.ObjectRef r12 = new Ref.ObjectRef();
                Ref.ObjectRef r14 = new Ref.ObjectRef();
                Lifecycle.State r13 = this.$state;     // Catch: Throwable -> L31
                Lifecycle r15 = this.$this_repeatOnLifecycle;     // Catch: Throwable -> L31
                final al r16 = this.$$this$coroutineScope;     // Catch: Throwable -> L31
                final Function2<al, Continuation<? super Unit>, Object> r17 = this.$block;     // Catch: Throwable -> L31
                this.L$0 = r12;     // Catch: Throwable -> L31
                this.L$1 = r14;     // Catch: Throwable -> L31
                this.L$2 = r13;     // Catch: Throwable -> L31
                this.L$3 = r15;     // Catch: Throwable -> L31
                this.L$4 = r16;     // Catch: Throwable -> L31
                this.L$5 = r17;     // Catch: Throwable -> L31
                this.label = 1;     // Catch: Throwable -> L31
                o r18 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin")), 1);     // Catch: Throwable -> L31
                r18.e();     // Catch: Throwable -> L31
                final n r110 = (n) ZeusTransformUtils.preCheckCast(r18, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
                final Lifecycle.Event r20 = Lifecycle.Event.Companion.upTo(r13);     // Catch: Throwable -> L31
                final Lifecycle.Event r111 = Lifecycle.Event.Companion.downFrom(r13);     // Catch: Throwable -> L31
                final a r112 = c.a(false, 1, null);     // Catch: Throwable -> L31
                r14.element = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(r20, r12, r16, r111, r110, r112, r17);     // Catch: Throwable -> L31
                T r21 = r14.element;     // Catch: Throwable -> L31
                Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");     // Catch: Throwable -> L31
                r15.addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast((LifecycleEventObserver) ZeusTransformUtils.preCheckCast(r21, LifecycleEventObserver.class, "com.obric.memorydata.plugin"), LifecycleObserver.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L31
                Object r22 = r18.h();     // Catch: Throwable -> L31
                if (r22 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
                DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L31
            L20:
                if (r22 != r0) goto L22;
                return r0;
            L22:
                r7 = r12;
                r6 = r14;
            L31:
                th = th;
                r7 = r12;
                r6 = r14;
                goto L33
            L15:
                return Unit.INSTANCE;
            }
        }

        AnonymousClass3(Lifecycle r3, Lifecycle.State r4, Function2<? super al, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super AnonymousClass3> r6) {
            Function2<al, Continuation<? super Unit>, Object> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$this_repeatOnLifecycle = r3;
            this.$state = r4;
            this.$block = r7;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass3 r0 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, r7);
            r0.L$0 = r5;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            al r7 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            CoroutineContext r12 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b().a(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, r7, this.$block, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (i.a(r12, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    public static final Object repeatOnLifecycle(Lifecycle r3, Lifecycle.State r4, Function2<? super al, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Unit> r6) {
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (r4 == Lifecycle.State.INITIALIZED) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        if (r3.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        Object r9 = am.a((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r3, r4, r7, null), Function2.class, "com.obric.memorydata.plugin"), r8);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r9;
    L15:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L17:
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final Object repeatOnLifecycle(LifecycleOwner r2, Lifecycle.State r3, Function2<? super al, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super Unit> r5) {
        LifecycleOwner r6 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r2, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r9 = repeatOnLifecycle(r6.getLifecycle(), r3, r7, r8);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }
}
