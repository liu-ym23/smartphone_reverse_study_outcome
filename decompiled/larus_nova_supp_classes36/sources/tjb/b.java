package tjb;

import java.lang.ref.WeakReference;
import rjb.g;
import ujb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements f {
    public final /* synthetic */ WeakReference<g> a;

    @Override // ujb.f
    public final void close() {
        WeakReference<g> r0 = this.a;
        if (r0 == null) goto L8;
        g r1 = r0.get();
        if (r1 == null) goto L9;
        r1.close();
        return;
    L9:
        return;
    }

    @Override // ujb.f
    public final boolean d() {
        WeakReference<g> r0 = this.a;
        if (r0 == null) goto L7;
        g r1 = r0.get();
        if (r1 == null) goto L7;
        return r1.isShowing();
    L7:
        return false;
    }

    public b(WeakReference<g> r1) {
        this.a = r1;
    }
}
