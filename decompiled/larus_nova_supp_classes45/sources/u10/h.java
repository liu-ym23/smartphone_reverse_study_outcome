package u10;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ e a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ long c;

    public h(e r1, Function1 r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        Function1 r0 = this.b;
        r0.invoke((Throwable) r3);
        this.a.c.remove(Long.valueOf(this.c));
    }
}
