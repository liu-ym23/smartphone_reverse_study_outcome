package k0;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import q0.i;

/* JADX INFO: loaded from: classes.dex */
public final class h implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f18578a;

    public h() {
        this.f18578a = Collections.newSetFromMap(new WeakHashMap());
    }

    @Override // k0.d
    public final void i() {
        Iterator r5 = i.d(this.f18578a).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((n0.d) r5.next()).i();
        goto L4
    }

    @Override // k0.d
    public final void onDestroy() {
        Iterator r5 = i.d(this.f18578a).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((n0.d) r5.next()).onDestroy();
        goto L4
    }

    @Override // k0.d
    public final void onStart() {
        Iterator r5 = i.d(this.f18578a).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((n0.d) r5.next()).onStart();
        goto L4
    }
}
