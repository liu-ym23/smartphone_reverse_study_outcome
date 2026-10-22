package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
final class DistinctFlowImpl<T> implements c<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c<T> f10392c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public final Function1<T, Object> f10393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public final Function2<Object, Object, Boolean> f10394h;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(c<? extends T> r10, Function1<? super T, ? extends Object> r11, Function2<Object, Object, Boolean> r12) {
        this.f10392c = r10;
        this.f10393g = r11;
        this.f10394h = r12;
    }

    @Override // kotlinx.coroutines.flow.c
    public Object a(d<? super T> r10, Continuation<? super Unit> r11) {
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = (T) kotlinx.coroutines.flow.internal.n.f10495a;
        Object r13 = this.f10392c.a(new DistinctFlowImpl$collect$2(this, r12, r10), r11);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }
}
