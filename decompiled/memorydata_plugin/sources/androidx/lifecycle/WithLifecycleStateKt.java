package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.ci;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aA\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\u0010\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a3\u0010\u0012\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a3\u0010\u0012\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a3\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0081Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"suspendWithStateAtLeastUnchecked", "R", "Landroidx/lifecycle/Lifecycle;", "state", "Landroidx/lifecycle/Lifecycle$State;", "dispatchNeeded", "", "lifecycleDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "block", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withCreated", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withResumed", "withStarted", "withStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStateAtLeastUnchecked", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WithLifecycleStateKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "R", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass2<R> extends Lambda implements Function0<R> {
        final /* synthetic */ Function0<R> $block;

        public AnonymousClass2(Function0<? extends R> r3) {
            this.$block = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final R invoke() {
            return this.$block.invoke();
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1, java.lang.Object] */
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle r4, final Lifecycle.State r5, boolean r6, final ah r7, Function0<? extends R> r8, Continuation<? super R> r9) {
        final Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        o r0 = new o(IntrinsicsKt.intercepted(r11), 1);
        r0.e();
        final n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
        final ?? r3 = new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(r5, r4, r2, r10);
        if (r6 == false) goto L5;
        r7.dispatch((CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin"), (Runnable) ZeusTransformUtils.preCheckCast(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1(r4, r3), Runnable.class, "com.obric.memorydata.plugin"));
    L6:
        r2.a((Function1) ZeusTransformUtils.preCheckCast(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(r7, r4, r3), Function1.class, "com.obric.memorydata.plugin"));
        Object r12 = r0.h();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L9:
        return r12;
    L5:
        r4.addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(r3, LifecycleObserver.class, "com.obric.memorydata.plugin"));
        goto L6
    }

    public static final <R> Object withCreated(Lifecycle r8, Function0<? extends R> r9, Continuation<? super R> r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle.State r3 = Lifecycle.State.CREATED;
        ci r12 = ba.b().a();
        boolean r4 = r12.isDispatchNeeded(r7.getContext());
        if (r4 == true) goto L12;
        if (r8.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r8.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r8, r3, r4, (ah) ZeusTransformUtils.preCheckCast(r12, ah.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r11), Function0.class, "com.obric.memorydata.plugin"), r7);
    }

    public static final <R> Object withCreated(LifecycleOwner r8, Function0<? extends R> r9, Continuation<? super R> r10) {
        LifecycleOwner r11 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r8, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle r2 = r11.getLifecycle();
        Lifecycle.State r3 = Lifecycle.State.CREATED;
        ci r13 = ba.b().a();
        boolean r4 = r13.isDispatchNeeded(r7.getContext());
        if (r4 == true) goto L12;
        if (r2.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r2.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L12;
        return r12.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r2, r3, r4, (ah) ZeusTransformUtils.preCheckCast(r13, ah.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12), Function0.class, "com.obric.memorydata.plugin"), r7);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle r8, Function0<? extends R> r9, Continuation<? super R> r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle.State r3 = Lifecycle.State.CREATED;
        ci r12 = ba.b().a();
        InlineMarker.mark(3);
        Continuation r0 = null;
        boolean r4 = r12.isDispatchNeeded(r0.getContext());
        if (r4 == false) goto L5;
    L11:
        ah r5 = (ah) ZeusTransformUtils.preCheckCast(r12, ah.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r11), Function0.class, "com.obric.memorydata.plugin");
        InlineMarker.mark(0);
        Object r13 = suspendWithStateAtLeastUnchecked(r8, r3, r4, r5, r6, r7);
        InlineMarker.mark(1);
        return r13;
    L5:
        if (r8.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r8.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L11;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner r8, Function0<? extends R> r9, Continuation<? super R> r10) {
        LifecycleOwner r11 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r8, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle r2 = r11.getLifecycle();
        Lifecycle.State r3 = Lifecycle.State.CREATED;
        ci r13 = ba.b().a();
        InlineMarker.mark(3);
        Continuation r14 = null;
        boolean r4 = r13.isDispatchNeeded(r14.getContext());
        if (r4 == false) goto L5;
    L11:
        ah r5 = (ah) ZeusTransformUtils.preCheckCast(r13, ah.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12), Function0.class, "com.obric.memorydata.plugin");
        InlineMarker.mark(0);
        Object r15 = suspendWithStateAtLeastUnchecked(r2, r3, r4, r5, r6, r7);
        InlineMarker.mark(1);
        return r15;
    L5:
        if (r2.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r2.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L11;
        return r12.invoke();
    L10:
        throw new LifecycleDestroyedException();
    }

    public static final <R> Object withResumed(Lifecycle r8, Function0<? extends R> r9, Continuation<? super R> r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle.State r3 = Lifecycle.State.RESUMED;
        ci r12 = ba.b().a();
        boolean r4 = r12.isDispatchNeeded(r7.getContext());
        if (r4 == true) goto L12;
        if (r8.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r8.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r8, r3, r4, (ah) ZeusTransformUtils.preCheckCast(r12, ah.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r11), Function0.class, "com.obric.memorydata.plugin"), r7);
    }

    public static final <R> Object withResumed(LifecycleOwner r8, Function0<? extends R> r9, Continuation<? super R> r10) {
        LifecycleOwner r11 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r8, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle r2 = r11.getLifecycle();
        Lifecycle.State r3 = Lifecycle.State.RESUMED;
        ci r13 = ba.b().a();
        boolean r4 = r13.isDispatchNeeded(r7.getContext());
        if (r4 == true) goto L12;
        if (r2.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r2.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L12;
        return r12.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r2, r3, r4, (ah) ZeusTransformUtils.preCheckCast(r13, ah.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12), Function0.class, "com.obric.memorydata.plugin"), r7);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle r8, Function0<? extends R> r9, Continuation<? super R> r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle.State r3 = Lifecycle.State.RESUMED;
        ci r12 = ba.b().a();
        InlineMarker.mark(3);
        Continuation r0 = null;
        boolean r4 = r12.isDispatchNeeded(r0.getContext());
        if (r4 == false) goto L5;
    L11:
        ah r5 = (ah) ZeusTransformUtils.preCheckCast(r12, ah.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r11), Function0.class, "com.obric.memorydata.plugin");
        InlineMarker.mark(0);
        Object r13 = suspendWithStateAtLeastUnchecked(r8, r3, r4, r5, r6, r7);
        InlineMarker.mark(1);
        return r13;
    L5:
        if (r8.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r8.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L11;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner r8, Function0<? extends R> r9, Continuation<? super R> r10) {
        LifecycleOwner r11 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r8, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle r2 = r11.getLifecycle();
        Lifecycle.State r3 = Lifecycle.State.RESUMED;
        ci r13 = ba.b().a();
        InlineMarker.mark(3);
        Continuation r14 = null;
        boolean r4 = r13.isDispatchNeeded(r14.getContext());
        if (r4 == false) goto L5;
    L11:
        ah r5 = (ah) ZeusTransformUtils.preCheckCast(r13, ah.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12), Function0.class, "com.obric.memorydata.plugin");
        InlineMarker.mark(0);
        Object r15 = suspendWithStateAtLeastUnchecked(r2, r3, r4, r5, r6, r7);
        InlineMarker.mark(1);
        return r15;
    L5:
        if (r2.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r2.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L11;
        return r12.invoke();
    L10:
        throw new LifecycleDestroyedException();
    }

    public static final <R> Object withStarted(Lifecycle r8, Function0<? extends R> r9, Continuation<? super R> r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle.State r3 = Lifecycle.State.STARTED;
        ci r12 = ba.b().a();
        boolean r4 = r12.isDispatchNeeded(r7.getContext());
        if (r4 == true) goto L12;
        if (r8.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r8.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L12;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r8, r3, r4, (ah) ZeusTransformUtils.preCheckCast(r12, ah.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r11), Function0.class, "com.obric.memorydata.plugin"), r7);
    }

    public static final <R> Object withStarted(LifecycleOwner r8, Function0<? extends R> r9, Continuation<? super R> r10) {
        LifecycleOwner r11 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r8, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle r2 = r11.getLifecycle();
        Lifecycle.State r3 = Lifecycle.State.STARTED;
        ci r13 = ba.b().a();
        boolean r4 = r13.isDispatchNeeded(r7.getContext());
        if (r4 == true) goto L12;
        if (r2.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r2.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L12;
        return r12.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r2, r3, r4, (ah) ZeusTransformUtils.preCheckCast(r13, ah.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12), Function0.class, "com.obric.memorydata.plugin"), r7);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle r8, Function0<? extends R> r9, Continuation<? super R> r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle.State r3 = Lifecycle.State.STARTED;
        ci r12 = ba.b().a();
        InlineMarker.mark(3);
        Continuation r0 = null;
        boolean r4 = r12.isDispatchNeeded(r0.getContext());
        if (r4 == false) goto L5;
    L11:
        ah r5 = (ah) ZeusTransformUtils.preCheckCast(r12, ah.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r11), Function0.class, "com.obric.memorydata.plugin");
        InlineMarker.mark(0);
        Object r13 = suspendWithStateAtLeastUnchecked(r8, r3, r4, r5, r6, r7);
        InlineMarker.mark(1);
        return r13;
    L5:
        if (r8.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r8.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L11;
        return r11.invoke();
    L10:
        throw new LifecycleDestroyedException();
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner r8, Function0<? extends R> r9, Continuation<? super R> r10) {
        LifecycleOwner r11 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r8, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle r2 = r11.getLifecycle();
        Lifecycle.State r3 = Lifecycle.State.STARTED;
        ci r13 = ba.b().a();
        InlineMarker.mark(3);
        Continuation r14 = null;
        boolean r4 = r13.isDispatchNeeded(r14.getContext());
        if (r4 == false) goto L5;
    L11:
        ah r5 = (ah) ZeusTransformUtils.preCheckCast(r13, ah.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12), Function0.class, "com.obric.memorydata.plugin");
        InlineMarker.mark(0);
        Object r15 = suspendWithStateAtLeastUnchecked(r2, r3, r4, r5, r6, r7);
        InlineMarker.mark(1);
        return r15;
    L5:
        if (r2.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r2.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L11;
        return r12.invoke();
    L10:
        throw new LifecycleDestroyedException();
    }

    public static final <R> Object withStateAtLeast(Lifecycle r8, Lifecycle.State r9, Function0<? extends R> r10, Continuation<? super R> r11) {
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (r9.compareTo((Enum) ZeusTransformUtils.preCheckCast(Lifecycle.State.CREATED, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L19;
        ci r14 = ba.b().a();
        boolean r4 = r14.isDispatchNeeded(r7.getContext());
        if (r4 == true) goto L17;
        if (r8.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        if (r8.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r9, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L17;
        return r12.invoke();
    L15:
        throw new LifecycleDestroyedException();
    L17:
        return suspendWithStateAtLeastUnchecked(r8, r9, r4, (ah) ZeusTransformUtils.preCheckCast(r14, ah.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12), Function0.class, "com.obric.memorydata.plugin"), r7);
    L19:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r9).toString());
    L5:
        r13 = false;
        goto L6
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner r8, Lifecycle.State r9, Function0<? extends R> r10, Continuation<? super R> r11) {
        LifecycleOwner r12 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r8, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle r2 = r12.getLifecycle();
        if (r9.compareTo((Enum) ZeusTransformUtils.preCheckCast(Lifecycle.State.CREATED, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L19;
        ci r15 = ba.b().a();
        boolean r4 = r15.isDispatchNeeded(r7.getContext());
        if (r4 == true) goto L17;
        if (r2.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        if (r2.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r9, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L17;
        return r13.invoke();
    L15:
        throw new LifecycleDestroyedException();
    L17:
        return suspendWithStateAtLeastUnchecked(r2, r9, r4, (ah) ZeusTransformUtils.preCheckCast(r15, ah.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r13), Function0.class, "com.obric.memorydata.plugin"), r7);
    L19:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r9).toString());
    L5:
        r14 = false;
        goto L6
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle r8, Lifecycle.State r9, Function0<? extends R> r10, Continuation<? super R> r11) {
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (r9.compareTo((Enum) ZeusTransformUtils.preCheckCast(Lifecycle.State.CREATED, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L19;
        ci r14 = ba.b().a();
        InlineMarker.mark(3);
        Continuation r3 = null;
        boolean r4 = r14.isDispatchNeeded(r3.getContext());
        if (r4 == false) goto L10;
    L16:
        ah r5 = (ah) ZeusTransformUtils.preCheckCast(r14, ah.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12), Function0.class, "com.obric.memorydata.plugin");
        InlineMarker.mark(0);
        Object r15 = suspendWithStateAtLeastUnchecked(r8, r9, r4, r5, r6, r7);
        InlineMarker.mark(1);
        return r15;
    L10:
        if (r8.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        if (r8.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r9, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L16;
        return r12.invoke();
    L15:
        throw new LifecycleDestroyedException();
    L19:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r9).toString());
    L5:
        r13 = false;
        goto L6
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner r8, Lifecycle.State r9, Function0<? extends R> r10, Continuation<? super R> r11) {
        LifecycleOwner r12 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r8, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        Lifecycle r2 = r12.getLifecycle();
        if (r9.compareTo((Enum) ZeusTransformUtils.preCheckCast(Lifecycle.State.CREATED, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L19;
        ci r15 = ba.b().a();
        InlineMarker.mark(3);
        Continuation r3 = null;
        boolean r4 = r15.isDispatchNeeded(r3.getContext());
        if (r4 == false) goto L10;
    L16:
        ah r5 = (ah) ZeusTransformUtils.preCheckCast(r15, ah.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r13), Function0.class, "com.obric.memorydata.plugin");
        InlineMarker.mark(0);
        Object r16 = suspendWithStateAtLeastUnchecked(r2, r9, r4, r5, r6, r7);
        InlineMarker.mark(1);
        return r16;
    L10:
        if (r2.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        if (r2.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r9, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L16;
        return r13.invoke();
    L15:
        throw new LifecycleDestroyedException();
    L19:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r9).toString());
    L5:
        r14 = false;
        goto L6
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle r8, Lifecycle.State r9, Function0<? extends R> r10, Continuation<? super R> r11) {
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        ci r13 = ba.b().a();
        boolean r4 = r13.isDispatchNeeded(r7.getContext());
        if (r4 == true) goto L13;
        if (r8.getCurrentState() == Lifecycle.State.DESTROYED) goto L11;
        if (r8.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r9, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L13;
        return r12.invoke();
    L11:
        throw new LifecycleDestroyedException();
    L13:
        return suspendWithStateAtLeastUnchecked(r8, r9, r4, (ah) ZeusTransformUtils.preCheckCast(r13, ah.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12), Function0.class, "com.obric.memorydata.plugin"), r7);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle r8, Lifecycle.State r9, Function0<? extends R> r10, Continuation<? super R> r11) {
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        ci r13 = ba.b().a();
        InlineMarker.mark(3);
        Continuation r0 = null;
        boolean r4 = r13.isDispatchNeeded(r0.getContext());
        if (r4 == false) goto L5;
    L12:
        ah r5 = (ah) ZeusTransformUtils.preCheckCast(r13, ah.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12), Function0.class, "com.obric.memorydata.plugin");
        InlineMarker.mark(0);
        Object r14 = suspendWithStateAtLeastUnchecked(r8, r9, r4, r5, r6, r7);
        InlineMarker.mark(1);
        return r14;
    L5:
        if (r8.getCurrentState() == Lifecycle.State.DESTROYED) goto L11;
        if (r8.getCurrentState().compareTo((Enum) ZeusTransformUtils.preCheckCast(r9, Enum.class, "com.obric.memorydata.plugin")) < 0) goto L12;
        return r12.invoke();
    L11:
        throw new LifecycleDestroyedException();
    }
}
