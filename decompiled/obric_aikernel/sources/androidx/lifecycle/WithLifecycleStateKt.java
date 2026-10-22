package androidx.lifecycle;

import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.o;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nWithLifecycleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,206:1\n154#1,8:207\n154#1,8:215\n154#1,8:223\n154#1,8:231\n43#1,5:239\n154#1,8:244\n43#1,5:252\n154#1,8:257\n154#1,8:265\n154#1,8:273\n154#1,8:281\n314#2,11:289\n*S KotlinDebug\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n*L\n47#1:207,8\n58#1:215,8\n71#1:223,8\n84#1:231,8\n98#1:239,5\n98#1:244,8\n98#1:252,5\n98#1:257,8\n111#1:265,8\n124#1:273,8\n137#1:281,8\n177#1:289,11\n*E\n"})
public final class WithLifecycleStateKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    @SourceDebugExtension({"SMAP\nWithLifecycleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt$withStateAtLeastUnchecked$2\n*L\n1#1,206:1\n*E\n"})
    public static final class AnonymousClass2<R> extends Lambda implements Function0<R> {
        final /* synthetic */ Function0<R> $block;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function0<? extends R> r10) {
            this.$block = r10;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final R invoke() {
            return this.$block.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    @PublishedApi
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle r10, final Lifecycle.State r11, boolean r12, final CoroutineDispatcher r13, final Function0<? extends R> r14, Continuation<? super R> r15) {
        final o r16 = new o(IntrinsicsKt.intercepted(r15), 1);
        r16.F();
        final ?? r17 = new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(r11, r10, r16, r14);
        if (r12 == false) goto L5;
        r13.dispatch(EmptyCoroutineContext.INSTANCE, new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1(r10, r17));
    L6:
        r16.h(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(r13, r10, r17));
        Object r18 = r16.B();
        if (r18 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r15);
    L9:
        return r18;
    L5:
        r10.addObserver(r17);
        goto L6
    }

    public static final <R> Object withCreated(Lifecycle r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle.State r13 = Lifecycle.State.CREATED;
        g2 r14 = z0.c().c0();
        boolean r15 = r14.isDispatchNeeded(r12.getContext());
        if (r15 == true) goto L12;
        if (r10.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r10.getCurrentState().compareTo(r13) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r10, r13, r15, r14, new AnonymousClass2(r11), r12);
    }

    public static final <R> Object withCreated(LifecycleOwner r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle r13 = r10.getLifecycle();
        Lifecycle.State r14 = Lifecycle.State.CREATED;
        g2 r15 = z0.c().c0();
        boolean r16 = r15.isDispatchNeeded(r12.getContext());
        if (r16 == true) goto L12;
        if (r13.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r13.getCurrentState().compareTo(r14) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r13, r14, r16, r15, new AnonymousClass2(r11), r12);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle.State r13 = Lifecycle.State.CREATED;
        z0.c().c0();
        InlineMarker.mark(3);
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        r10.getLifecycle();
        Lifecycle.State r13 = Lifecycle.State.CREATED;
        z0.c().c0();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle.State r13 = Lifecycle.State.RESUMED;
        g2 r14 = z0.c().c0();
        boolean r15 = r14.isDispatchNeeded(r12.getContext());
        if (r15 == true) goto L12;
        if (r10.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r10.getCurrentState().compareTo(r13) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r10, r13, r15, r14, new AnonymousClass2(r11), r12);
    }

    public static final <R> Object withResumed(LifecycleOwner r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle r13 = r10.getLifecycle();
        Lifecycle.State r14 = Lifecycle.State.RESUMED;
        g2 r15 = z0.c().c0();
        boolean r16 = r15.isDispatchNeeded(r12.getContext());
        if (r16 == true) goto L12;
        if (r13.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r13.getCurrentState().compareTo(r14) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r13, r14, r16, r15, new AnonymousClass2(r11), r12);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle.State r13 = Lifecycle.State.RESUMED;
        z0.c().c0();
        InlineMarker.mark(3);
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        r10.getLifecycle();
        Lifecycle.State r13 = Lifecycle.State.RESUMED;
        z0.c().c0();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle.State r13 = Lifecycle.State.STARTED;
        g2 r14 = z0.c().c0();
        boolean r15 = r14.isDispatchNeeded(r12.getContext());
        if (r15 == true) goto L12;
        if (r10.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r10.getCurrentState().compareTo(r13) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r10, r13, r15, r14, new AnonymousClass2(r11), r12);
    }

    public static final <R> Object withStarted(LifecycleOwner r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle r13 = r10.getLifecycle();
        Lifecycle.State r14 = Lifecycle.State.STARTED;
        g2 r15 = z0.c().c0();
        boolean r16 = r15.isDispatchNeeded(r12.getContext());
        if (r16 == true) goto L12;
        if (r13.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r13.getCurrentState().compareTo(r14) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r13, r14, r16, r15, new AnonymousClass2(r11), r12);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle.State r13 = Lifecycle.State.STARTED;
        z0.c().c0();
        InlineMarker.mark(3);
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        r10.getLifecycle();
        Lifecycle.State r13 = Lifecycle.State.STARTED;
        z0.c().c0();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withStateAtLeast(Lifecycle r10, Lifecycle.State r11, Function0<? extends R> r12, Continuation<? super R> r13) {
        if (r11.compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L19;
        g2 r15 = z0.c().c0();
        boolean r16 = r15.isDispatchNeeded(r13.getContext());
        if (r16 == true) goto L17;
        if (r10.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        if (r10.getCurrentState().compareTo(r11) < 0) goto L17;
        return r12.invoke();
    L15:
        throw new LifecycleDestroyedException();
    L17:
        return suspendWithStateAtLeastUnchecked(r10, r11, r16, r15, new AnonymousClass2(r12), r13);
    L19:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r11).toString());
    L5:
        r14 = false;
        goto L6
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner r10, Lifecycle.State r11, Function0<? extends R> r12, Continuation<? super R> r13) {
        Lifecycle r14 = r10.getLifecycle();
        if (r11.compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L19;
        g2 r16 = z0.c().c0();
        boolean r17 = r16.isDispatchNeeded(r13.getContext());
        if (r17 == true) goto L17;
        if (r14.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        if (r14.getCurrentState().compareTo(r11) < 0) goto L17;
        return r12.invoke();
    L15:
        throw new LifecycleDestroyedException();
    L17:
        return suspendWithStateAtLeastUnchecked(r14, r11, r17, r16, new AnonymousClass2(r12), r13);
    L19:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r11).toString());
    L5:
        r15 = false;
        goto L6
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle r10, Lifecycle.State r11, Function0<? extends R> r12, Continuation<? super R> r13) {
        if (r11.compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L8;
        z0.c().c0();
        InlineMarker.mark(3);
        throw null;
    L8:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r11).toString());
    L5:
        r14 = false;
        goto L6
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner r10, Lifecycle.State r11, Function0<? extends R> r12, Continuation<? super R> r13) {
        r10.getLifecycle();
        if (r11.compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L8;
        z0.c().c0();
        InlineMarker.mark(3);
        throw null;
    L8:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r11).toString());
    L5:
        r14 = false;
        goto L6
    }

    @PublishedApi
    public static final <R> Object withStateAtLeastUnchecked(Lifecycle r10, Lifecycle.State r11, Function0<? extends R> r12, Continuation<? super R> r13) {
        g2 r14 = z0.c().c0();
        boolean r15 = r14.isDispatchNeeded(r13.getContext());
        if (r15 == true) goto L13;
        if (r10.getCurrentState() == Lifecycle.State.DESTROYED) goto L11;
        if (r10.getCurrentState().compareTo(r11) < 0) goto L13;
        return r12.invoke();
    L11:
        throw new LifecycleDestroyedException();
    L13:
        return suspendWithStateAtLeastUnchecked(r10, r11, r15, r14, new AnonymousClass2(r12), r13);
    }

    @PublishedApi
    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle r10, Lifecycle.State r11, Function0<? extends R> r12, Continuation<? super R> r13) {
        z0.c().c0();
        InlineMarker.mark(3);
        throw null;
    }
}
