package etc;

import lsc.h;
import msc.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g extends lsc.a {
    public final gtc.g a;
    public final d b;
    public final String c;

    @Override // lsc.a, lsc.j
    public final void e(s.a r2) {
        this.b.c();
        r2.m = -587202560;
        r2.o = this.b.a();
    }

    @Override // lsc.a, lsc.j
    public final void g(h.a r5) {
        r5.c = new b(this.a, this.b, this.c);
    }

    public g(gtc.g r1, io.noties.markwon.syntax.a r2) {
        this.a = r1;
        this.b = r2;
        this.c = "c";
    }
}
