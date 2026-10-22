package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class f implements e {
    public final Object a;
    public final Function3<Object, l<?>, Object, Unit> b;
    public final Function3<l<?>, Object, Object, Function1<Throwable, Unit>> c;
    public final Function3<Object, Object, Object, Object> d;

    @Override // kotlinx.coroutines.selects.k
    public final Function3<l<?>, Object, Object, Function1<Throwable, Unit>> a() {
        return this.c;
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
        return this.d;
    }

    public f(Object r1, Function3 r2) {
        this.a = r1;
        this.b = r2;
        this.c = null;
        this.d = SelectKt.a;
    }
}
