package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class FlowKt__DistinctKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function1<Object, Object> f10404a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function2<Object, Object, Boolean> f10405b = null;

    static {
        f10404a = FlowKt__DistinctKt$defaultKeySelector$1.INSTANCE;
        f10405b = FlowKt__DistinctKt$defaultAreEquivalent$1.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> c<T> a(c<? extends T> r10) {
        if ((r10 instanceof p1) == false) goto L6;
        return r10;
    L6:
        return b(r10, f10404a, f10405b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> c<T> b(c<? extends T> r10, Function1<? super T, ? extends Object> r11, Function2<Object, Object, Boolean> r12) {
        if ((r10 instanceof DistinctFlowImpl) == false) goto L10;
        DistinctFlowImpl r13 = (DistinctFlowImpl) r10;
        if (r13.f10393g != r11) goto L10;
        if (r13.f10394h != r12) goto L10;
        return r10;
    L10:
        return new DistinctFlowImpl(r10, r11, r12);
    }
}
