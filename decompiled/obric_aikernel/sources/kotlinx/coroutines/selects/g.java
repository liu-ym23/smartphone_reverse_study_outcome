package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class g<Q> implements f<Q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f10683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function3<Object, k<?>, Object, Unit> f10684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function3<Object, Object, Object, Object> f10685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function3<k<?>, Object, Object, Function1<Throwable, Unit>> f10686d;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Object r10, Function3<Object, ? super k<?>, Object, Unit> r11, Function3<Object, Object, Object, ? extends Object> r12, Function3<? super k<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> r13) {
        this.f10683a = r10;
        this.f10684b = r11;
        this.f10685c = r12;
        this.f10686d = r13;
    }

    @Override // kotlinx.coroutines.selects.j
    public Function3<Object, k<?>, Object, Unit> a() {
        return this.f10684b;
    }

    @Override // kotlinx.coroutines.selects.j
    public Object b() {
        return this.f10683a;
    }

    @Override // kotlinx.coroutines.selects.j
    public Function3<k<?>, Object, Object, Function1<Throwable, Unit>> c() {
        return this.f10686d;
    }

    @Override // kotlinx.coroutines.selects.j
    public Function3<Object, Object, Object, Object> d() {
        return this.f10685c;
    }
}
