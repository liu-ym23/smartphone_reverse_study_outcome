package b4;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import r3.i;

/* JADX INFO: loaded from: classes.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r3.c f3050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet<i> f3051b;

    public b(r3.c r8) {
        this.f3051b = new CopyOnWriteArraySet();
        this.f3050a = r8;
    }

    @Override // r3.i
    public final void a(long r8, String r10, boolean r11) {
        Iterator<i> r12 = this.f3051b.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        r12.next().a(r8, r10, r11);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.f3050a.H.i(Collections.singletonList("LaunchObserverHolder"), "invoke onLaunch callback failed", th, new Object[0]);
        goto L4
    }
}
