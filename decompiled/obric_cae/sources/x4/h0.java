package x4;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class h0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0.d f13431a;

    public h0(d0.d r8) {
        this.f13431a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r8 = new ArrayList(this.f13431a.f13406a).iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        d0.d.a r10 = (d0.d.a) ((WeakReference) r8.next()).get();
        if (r10 == null) goto L4;
        r10.a();
        goto L4
    }
}
