package wia;

import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.entity.ResultCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ResultCallback b;

    public /* synthetic */ l(int r1, ResultCallback r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EntityProvider.g(this.a, this.b);
    }
}
