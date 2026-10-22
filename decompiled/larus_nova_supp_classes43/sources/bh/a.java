package bh;

import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a<V> implements Callable {
    public final /* synthetic */ b a;
    public final /* synthetic */ Function1 b;

    public a(b r1, Function1 r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        Integer r0 = this.a.b();
        this.b.invoke(r0);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
