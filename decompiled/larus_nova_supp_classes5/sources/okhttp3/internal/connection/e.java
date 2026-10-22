package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e {
    public final Set<Route> a;

    public e() {
        this.a = new LinkedHashSet();
    }

    public final synchronized void a(Route r2) {
        monitor-enter(this);
        this.a.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
