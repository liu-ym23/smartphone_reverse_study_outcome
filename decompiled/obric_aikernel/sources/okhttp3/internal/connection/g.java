package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.b0;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<b0> f11828a;

    public g() {
        this.f11828a = new LinkedHashSet();
    }

    public final synchronized void a(b0 r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "route");     // Catch: Throwable -> L6
        this.f11828a.remove(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(b0 r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "failedRoute");     // Catch: Throwable -> L6
        this.f11828a.add(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c(b0 r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "route");     // Catch: Throwable -> L6
        boolean r11 = this.f11828a.contains(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }
}
