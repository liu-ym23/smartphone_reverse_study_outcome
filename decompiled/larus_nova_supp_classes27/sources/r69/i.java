package r69;

import com.larus.utils.t0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i {
    public static final i a = null;
    public static final AtomicReference<u19.f> b = null;

    public i() {
    }

    static {
        a = new i();
        b = new AtomicReference(null);
    }

    public final synchronized void a(final a r2) {
        monitor-enter(this);
        t0.e(new h(r2));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
