package g1c;

import kotlin.jvm.internal.Intrinsics;
import o1c.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a<T> implements b<T> {
    public final T a;
    public boolean b;
    public T c;

    @Override // g1c.b
    public boolean a() {
        return false;
    }

    @Override // g1c.b
    public void e(c<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
    }

    @Override // g1c.b
    public final boolean c() {
        return this.b;
    }

    public a(T r1) {
        this.a = r1;
    }

    @Override // g1c.b
    public final void setValue(T r2) {
        this.b = !Intrinsics.areEqual(this.c, r2);
        this.c = r2;
    }
}
