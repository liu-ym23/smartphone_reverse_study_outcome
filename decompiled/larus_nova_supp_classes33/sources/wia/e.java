package wia;

import com.obric.capabilitykit.EntityProvider;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ CountDownLatch a;

    public /* synthetic */ e(CountDownLatch r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EntityProvider.h(this.a);
    }
}
