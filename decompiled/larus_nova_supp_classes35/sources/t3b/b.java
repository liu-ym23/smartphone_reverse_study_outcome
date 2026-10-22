package t3b;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements e<u3b.c> {
    public final AtomicInteger a;

    public b() {
        this.a = new AtomicInteger(0);
    }

    @Override // t3b.e
    public final String a(u3b.a r2) {
        return ((u3b.c) r2).a() + "_" + this.a.get();
    }

    @Override // t3b.e
    public final String b(u3b.a r2) {
        return ((u3b.c) r2).a() + "_" + this.a.incrementAndGet();
    }
}
