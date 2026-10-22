package qja;

import kotlin.jvm.internal.Intrinsics;
import oja.d;
import oja.e;
import oja.f;
import oja.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class a implements c {
    public c.a a;
    public c.d b;
    public c.b c;
    public c.InterfaceC0068c d;

    public a() {
    }

    @Override // qja.c
    public final void e(e r2) {
        Intrinsics.checkNotNullParameter(r2, "completionListener");
        this.a = r2;
    }

    @Override // qja.c
    public final void f(g r2) {
        Intrinsics.checkNotNullParameter(r2, "preparedListener");
        this.b = r2;
    }

    @Override // qja.c
    public final void g(d r2) {
        Intrinsics.checkNotNullParameter(r2, "firstFrameListener");
        this.d = r2;
    }

    @Override // qja.c
    public final void h(f r2) {
        Intrinsics.checkNotNullParameter(r2, "errorListener");
        this.c = r2;
    }
}
