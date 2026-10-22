package mf6;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class b extends a {
    public final List<a> d;
    public boolean e;
    public final Function0<Unit> f;
    public final Function0<Unit> g;

    @Override // mf6.a
    public final void e() {
        this.e = true;
    }

    @Override // mf6.a
    public final void c() {
        Function0<Unit> r0 = this.f;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    @Override // mf6.a
    public final boolean b() {
        return this.e;
    }

    public b(long r1, Function0 r3) {
        super(r1);
        this.f = r3;
        this.g = null;
        this.d = new ArrayList();
    }
}
