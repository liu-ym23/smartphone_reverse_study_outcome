package wia;

import com.obric.capabilitykit.EntityProvider;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ CountDownLatch a;
    public final /* synthetic */ Set b;

    public /* synthetic */ h(CountDownLatch r1, Set r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EntityProvider.b(this.a, this.b);
    }
}
