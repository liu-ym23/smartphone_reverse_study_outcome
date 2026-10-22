package vpb;

import io.reactivex.functions.Action;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Action {
    public final /* synthetic */ a a;
    public final /* synthetic */ long b;

    public b(a r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        DecimalFormat r0 = f.a;
        a r1 = this.a;
        f.a("full", r1.k, r1.a, true, System.nanoTime() - this.b, null);
    }
}
