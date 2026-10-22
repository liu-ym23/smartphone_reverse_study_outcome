package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h$a implements h {
    public final Function1<Throwable, Unit> a;

    public final String toString() {
        return "CancelHandler.UserSupplied[" + this.a.getClass().getSimpleName() + '@' + b0.a(this) + ']';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h$a(Function1<? super Throwable, Unit> r1) {
        this.a = r1;
    }

    public final void a(Throwable r2) {
        this.a.invoke(r2);
    }
}
