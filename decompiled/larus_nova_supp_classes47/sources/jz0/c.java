package jz0;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<V> implements Callable {
    public final /* synthetic */ b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public c(b r1) {
        this.a = r1;
        this.b = "__version__";
        this.c = "";
    }

    @Override // java.util.concurrent.Callable
    public final String call() {
        return this.a.d(this.b, this.c);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
