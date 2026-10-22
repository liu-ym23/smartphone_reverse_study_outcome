package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class h<Q> implements g<Q> {
    public final Object a;
    public final Function3<Object, l<?>, Object, Unit> b;
    public final Function3<Object, Object, Object, Object> c;
    public final Function3<l<?>, Object, Object, Function1<Throwable, Unit>> d;

    @Override // kotlinx.coroutines.selects.k
    public final Function3<l<?>, Object, Object, Function1<Throwable, Unit>> a() {
        return this.d;
    }

    @Override // kotlinx.coroutines.selects.k
    public final Function3<Object, l<?>, Object, Unit> b() {
        return this.b;
    }

    @Override // kotlinx.coroutines.selects.k
    public final Object c() {
        return this.a;
    }

    @Override // kotlinx.coroutines.selects.k
    public final Function3<Object, Object, Object, Object> d() {
        return this.c;
    }

    public h(Object r1, Function3<Object, ? super l<?>, Object, Unit> r2, Function3<Object, Object, Object, ? extends Object> r3, Function3<? super l<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
