package wia;

import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.entity.ResultCallback;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ ResultCallback b;

    public /* synthetic */ f(List r1, ResultCallback r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EntityProvider.d(this.a, this.b);
    }
}
