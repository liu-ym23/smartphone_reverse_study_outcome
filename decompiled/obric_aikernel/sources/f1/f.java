package f1;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f extends n {
    public f() {
    }

    @Override // f1.b, f1.g
    public void e(String r10) {
        c("You should not set appId on global logger instance", new Object[0]);
    }

    @Override // f1.b
    protected void z(int r10, int r11, List<String> r12, Throwable r13, String r14, Object... r15) {
        if (l.f() == false) goto L5;
        return;
    L5:
        i r16 = i.b().c(r10).d(r11).g(Thread.currentThread().getName()).h(r13).f(y(r12)).e(w(r14, r15)).b();
        l.a(r16);
        Iterator<h> r17 = l.c();
    L7:
        if (r17.hasNext() == false) goto L9;
        r17.next().a(r16);
        goto L7
    }
}
