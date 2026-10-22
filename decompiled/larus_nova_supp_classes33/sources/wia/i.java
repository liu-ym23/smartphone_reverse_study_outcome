package wia;

import com.obric.capabilitykit.EntityProvider;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ CountDownLatch b;

    public /* synthetic */ i(List r1, CountDownLatch r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EntityProvider.e(this.a, this.b);
    }
}
