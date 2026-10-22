package k5;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import x4.x;

/* JADX INFO: loaded from: classes.dex */
public final class b implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<x> f8931a;

    public b() {
        this.f8931a = new CopyOnWriteArraySet();
    }

    @Override // x4.x
    public final void onIdLoaded(String r8, String r10, String r11) {
        Iterator<x> r12 = this.f8931a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().onIdLoaded(r8, r10, r11);
        goto L4
    }

    @Override // x4.x
    public final void onRemoteIdGet(boolean r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        Iterator<x> r8 = this.f8931a.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().onRemoteIdGet(r11, r12, r13, r14, r15, r16, r17);
        goto L4
    }
}
