package kotlin.coroutines.intrinsics;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nIntrinsicsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n1#1,269:1\n204#1,4:270\n225#1:274\n204#1,4:275\n225#1:279\n*S KotlinDebug\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n130#1:270,4\n130#1:274\n165#1:275,4\n165#1:279\n*E\n"})
class IntrinsicsKt__IntrinsicsJvmKt {
    public IntrinsicsKt__IntrinsicsJvmKt() {
    }

    @SinceKotlin(version = "1.3")
    private static final <T> Continuation<Unit> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(final Continuation<? super T> r10, final Function1<? super Continuation<? super T>, ? extends Object> r11) {
        final CoroutineContext r12 = r10.getContext();
        if (r12 != EmptyCoroutineContext.INSTANCE) goto L6;
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1(r10, r11);
    L6:
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2(r10, r12, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    public static <T> Continuation<Unit> createCoroutineUnintercepted(final Function1<? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "completion");
        final Continuation<?> r12 = DebugProbesKt.probeCoroutineCreated(r11);
        if ((r10 instanceof BaseContinuationImpl) == true) goto L10;
        final CoroutineContext r13 = r12.getContext();
        if (r13 != EmptyCoroutineContext.INSTANCE) goto L9;
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1(r12, r10);
    L9:
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2(r12, r13, r10);
    L10:
        return ((BaseContinuationImpl) r10).create(r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    public static <R, T> Continuation<Unit> createCoroutineUnintercepted(final Function2<? super R, ? super Continuation<? super T>, ? extends Object> r10, final R r11, Continuation<? super T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "completion");
        final Continuation<?> r13 = DebugProbesKt.probeCoroutineCreated(r12);
        if ((r10 instanceof BaseContinuationImpl) == true) goto L10;
        final CoroutineContext r14 = r13.getContext();
        if (r14 != EmptyCoroutineContext.INSTANCE) goto L9;
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(r13, r10, r11);
    L9:
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(r13, r14, r10, r11);
    L10:
        return ((BaseContinuationImpl) r10).create(r11, r13);
    }

    private static final <T> Continuation<T> createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(final Continuation<? super T> r10) {
        final CoroutineContext r11 = r10.getContext();
        if (r11 != EmptyCoroutineContext.INSTANCE) goto L6;
        return new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1(r10);
    L6:
        return new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    public static <T> Continuation<T> intercepted(Continuation<? super T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof ContinuationImpl) == false) goto L5;
        ContinuationImpl r11 = (ContinuationImpl) r10;
    L6:
        if (r11 == null) goto L12;
        Continuation<T> r12 = (Continuation<T>) r11.intercepted();
        if (r12 != null) goto L11;
        return r10;
    L11:
        return r12;
    L12:
        return r10;
    L5:
        r11 = null;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object startCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "completion");
        if ((r10 instanceof BaseContinuationImpl) == true) goto L6;
        return wrapWithContinuationImpl(r10, r11);
    L6:
        return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 1)).invoke(r11);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object startCoroutineUninterceptedOrReturn(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r10, R r11, Continuation<? super T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "completion");
        if ((r10 instanceof BaseContinuationImpl) == true) goto L6;
        return wrapWithContinuationImpl(r10, r11, r12);
    L6:
        return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 2)).invoke(r11, r12);
    }

    @InlineOnly
    private static final <R, P, T> Object startCoroutineUninterceptedOrReturn(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> r10, R r11, P r12, Continuation<? super T> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "completion");
        if ((r10 instanceof BaseContinuationImpl) == true) goto L6;
        return IntrinsicsKt.wrapWithContinuationImpl(r10, r11, r12, r13);
    L6:
        return ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 3)).invoke(r11, r12, r13);
    }

    @PublishedApi
    public static final <T> Object wrapWithContinuationImpl(Function1<? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "completion");
        Continuation r12 = createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(r11));
        return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 1)).invoke(r12);
    }

    @PublishedApi
    public static final <R, T> Object wrapWithContinuationImpl(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r10, R r11, Continuation<? super T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "completion");
        Continuation r13 = createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(r12));
        return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 2)).invoke(r11, r13);
    }

    @PublishedApi
    public static <R, P, T> Object wrapWithContinuationImpl(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> r10, R r11, P r12, Continuation<? super T> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "completion");
        Continuation r14 = createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(r13));
        return ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 3)).invoke(r11, r12, r14);
    }
}
