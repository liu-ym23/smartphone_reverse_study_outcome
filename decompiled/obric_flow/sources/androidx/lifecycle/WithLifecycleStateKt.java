package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.l;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\n\u0010\t\u001a-\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\t\u001a5\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\r\u001a-\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\b\u0010\u000e\u001a-\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000e\u001a-\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u000e\u001a5\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0081Hø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0007\u001aC\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0081@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"R", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$State;", "state", "Lkotlin/Function0;", "block", "withStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withCreated", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStarted", "withResumed", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStateAtLeastUnchecked", "", "dispatchNeeded", "Lkotlinx/coroutines/z;", "lifecycleDispatcher", "suspendWithStateAtLeastUnchecked", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLkotlinx/coroutines/z;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWithLifecycleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,206:1\n154#1,8:207\n154#1,8:215\n154#1,8:223\n154#1,8:231\n43#1,5:239\n154#1,8:244\n43#1,5:252\n154#1,8:257\n154#1,8:265\n154#1,8:273\n154#1,8:281\n314#2,11:289\n*S KotlinDebug\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n*L\n47#1:207,8\n58#1:215,8\n71#1:223,8\n84#1:231,8\n98#1:239,5\n98#1:244,8\n98#1:252,5\n98#1:257,8\n111#1:265,8\n124#1:273,8\n137#1:281,8\n177#1:289,11\n*E\n"})
public final class WithLifecycleStateKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "R", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 176)
    @SourceDebugExtension({"SMAP\nWithLifecycleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt$withStateAtLeastUnchecked$2\n*L\n1#1,206:1\n*E\n"})
    public static final class AnonymousClass2<R> extends Lambda implements Function0<R> {
        final /* synthetic */ Function0<R> $block;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function0<? extends R> r5) {
            this.$block = r5;
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
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle r5, final Lifecycle.State r10, boolean r11, final z r12, final Function0<? extends R> r13, Continuation<? super R> r14) {
        final l r15 = new l(1, IntrinsicsKt.intercepted(r14));
        r15.w();
        final ?? r16 = new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(r10, r5, r15, r13);
        if (r11 == false) goto L5;
        r12.dispatch(EmptyCoroutineContext.INSTANCE, new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1(r5, r16));
    L6:
        r15.y(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(r12, r5, r16));
        Object r17 = r15.v();
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r14);
    L9:
        return r17;
    L5:
        r5.addObserver(r16);
        goto L6
    }

    public static final <R> Object withCreated(Lifecycle r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle.State r5 = Lifecycle.State.CREATED;
        MainCoroutineDispatcher r13 = Dispatchers.getMain().getImmediate();
        boolean r14 = r13.isDispatchNeeded(r12.getContext());
        if (r14 == true) goto L12;
        if (r10.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r10.getCurrentState().compareTo(r5) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r10, r5, r14, r13, new AnonymousClass2(r11), r12);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle r5, Function0<? extends R> r10, Continuation<? super R> r11) {
        Lifecycle.State r12 = Lifecycle.State.DESTROYED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle.State r5 = Lifecycle.State.RESUMED;
        MainCoroutineDispatcher r13 = Dispatchers.getMain().getImmediate();
        boolean r14 = r13.isDispatchNeeded(r12.getContext());
        if (r14 == true) goto L12;
        if (r10.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r10.getCurrentState().compareTo(r5) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r10, r5, r14, r13, new AnonymousClass2(r11), r12);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle r5, Function0<? extends R> r10, Continuation<? super R> r11) {
        Lifecycle.State r12 = Lifecycle.State.DESTROYED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle.State r5 = Lifecycle.State.STARTED;
        MainCoroutineDispatcher r13 = Dispatchers.getMain().getImmediate();
        boolean r14 = r13.isDispatchNeeded(r12.getContext());
        if (r14 == true) goto L12;
        if (r10.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r10.getCurrentState().compareTo(r5) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r10, r5, r14, r13, new AnonymousClass2(r11), r12);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle r5, Function0<? extends R> r10, Continuation<? super R> r11) {
        Lifecycle.State r12 = Lifecycle.State.DESTROYED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withStateAtLeast(Lifecycle r10, Lifecycle.State r11, Function0<? extends R> r12, Continuation<? super R> r13) {
        if (r11.compareTo(Lifecycle.State.CREATED) < 0) goto L16;
        MainCoroutineDispatcher r5 = Dispatchers.getMain().getImmediate();
        boolean r14 = r5.isDispatchNeeded(r13.getContext());
        if (r14 == true) goto L14;
        if (r10.getCurrentState() == Lifecycle.State.DESTROYED) goto L12;
        if (r10.getCurrentState().compareTo(r11) < 0) goto L14;
        return r12.invoke();
    L12:
        throw new LifecycleDestroyedException();
    L14:
        return suspendWithStateAtLeastUnchecked(r10, r11, r14, r5, new AnonymousClass2(r12), r13);
    L16:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r11).toString());
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle r5, Lifecycle.State r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        if (r10.compareTo(Lifecycle.State.CREATED) < 0) goto L7;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    L7:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r10).toString());
    }

    @PublishedApi
    public static final <R> Object withStateAtLeastUnchecked(Lifecycle r10, Lifecycle.State r11, Function0<? extends R> r12, Continuation<? super R> r13) {
        MainCoroutineDispatcher r5 = Dispatchers.getMain().getImmediate();
        boolean r14 = r5.isDispatchNeeded(r13.getContext());
        if (r14 == true) goto L13;
        if (r10.getCurrentState() == Lifecycle.State.DESTROYED) goto L11;
        if (r10.getCurrentState().compareTo(r11) < 0) goto L13;
        return r12.invoke();
    L11:
        throw new LifecycleDestroyedException();
    L13:
        return suspendWithStateAtLeastUnchecked(r10, r11, r14, r5, new AnonymousClass2(r12), r13);
    }

    @PublishedApi
    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle r5, Lifecycle.State r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner r5, Function0<? extends R> r10, Continuation<? super R> r11) {
        r5.getLifecycle();
        Lifecycle.State r12 = Lifecycle.State.DESTROYED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner r5, Function0<? extends R> r10, Continuation<? super R> r11) {
        r5.getLifecycle();
        Lifecycle.State r12 = Lifecycle.State.DESTROYED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner r5, Function0<? extends R> r10, Continuation<? super R> r11) {
        r5.getLifecycle();
        Lifecycle.State r12 = Lifecycle.State.DESTROYED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner r5, Lifecycle.State r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        r5.getLifecycle();
        if (r10.compareTo(Lifecycle.State.CREATED) < 0) goto L7;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    L7:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r10).toString());
    }

    public static final <R> Object withCreated(LifecycleOwner r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle r5 = r10.getLifecycle();
        Lifecycle.State r13 = Lifecycle.State.CREATED;
        MainCoroutineDispatcher r14 = Dispatchers.getMain().getImmediate();
        boolean r15 = r14.isDispatchNeeded(r12.getContext());
        if (r15 == true) goto L12;
        if (r5.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r5.getCurrentState().compareTo(r13) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r5, r13, r15, r14, new AnonymousClass2(r11), r12);
    }

    public static final <R> Object withResumed(LifecycleOwner r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle r5 = r10.getLifecycle();
        Lifecycle.State r13 = Lifecycle.State.RESUMED;
        MainCoroutineDispatcher r14 = Dispatchers.getMain().getImmediate();
        boolean r15 = r14.isDispatchNeeded(r12.getContext());
        if (r15 == true) goto L12;
        if (r5.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r5.getCurrentState().compareTo(r13) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r5, r13, r15, r14, new AnonymousClass2(r11), r12);
    }

    public static final <R> Object withStarted(LifecycleOwner r10, Function0<? extends R> r11, Continuation<? super R> r12) {
        Lifecycle r5 = r10.getLifecycle();
        Lifecycle.State r13 = Lifecycle.State.STARTED;
        MainCoroutineDispatcher r14 = Dispatchers.getMain().getImmediate();
        boolean r15 = r14.isDispatchNeeded(r12.getContext());
        if (r15 == true) goto L12;
        if (r5.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r5.getCurrentState().compareTo(r13) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r5, r13, r15, r14, new AnonymousClass2(r11), r12);
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner r10, Lifecycle.State r11, Function0<? extends R> r12, Continuation<? super R> r13) {
        Lifecycle r5 = r10.getLifecycle();
        if (r11.compareTo(Lifecycle.State.CREATED) < 0) goto L16;
        MainCoroutineDispatcher r14 = Dispatchers.getMain().getImmediate();
        boolean r15 = r14.isDispatchNeeded(r13.getContext());
        if (r15 == true) goto L14;
        if (r5.getCurrentState() == Lifecycle.State.DESTROYED) goto L12;
        if (r5.getCurrentState().compareTo(r11) < 0) goto L14;
        return r12.invoke();
    L12:
        throw new LifecycleDestroyedException();
    L14:
        return suspendWithStateAtLeastUnchecked(r5, r11, r15, r14, new AnonymousClass2(r12), r13);
    L16:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r11).toString());
    }
}
