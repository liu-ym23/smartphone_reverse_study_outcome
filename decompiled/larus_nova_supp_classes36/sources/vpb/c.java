package vpb;

import io.reactivex.functions.Consumer;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ long b;

    public c(a r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        DecimalFormat r0 = f.a;
        a r1 = this.a;
        f.a("full", r1.k, r1.a, false, System.nanoTime() - this.b, ((Throwable) r9).getMessage());
    }
}
