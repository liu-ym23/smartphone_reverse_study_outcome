package wia;

import com.obric.capabilitykit.EntityProvider;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ int b;

    public /* synthetic */ g(List r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EntityProvider.c(this.a, this.b);
    }
}
