package d1;

import com.bytedance.applog.k;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.c f8440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArraySet<k> f8441b;

    public b(com.bytedance.applog.c r10) {
        this.f8441b = new CopyOnWriteArraySet();
        this.f8440a = r10;
    }

    @Override // com.bytedance.applog.k
    public void a(String r10, long r11, boolean r12) {
        Iterator<k> r13 = this.f8441b.iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        r13.next().a(r10, r11, r12);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.f8440a.P().u(Collections.singletonList("LaunchObserverHolder"), "invoke onLaunch callback failed", th, new Object[0]);
        goto L4
    }
}
