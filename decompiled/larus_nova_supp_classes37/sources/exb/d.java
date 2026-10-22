package exb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import otb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final exb.a a;
    public final ConcurrentHashMap<String, otb.c> b;
    public final Map<String, i> c;
    public final ConcurrentHashMap<String, e> d;
    public final List<otb.b> e;

    public static final class a {
    }

    static {
    }

    public d(exb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "logger");
        this.a = r2;
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ArrayList();
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "viewId");
        this.a.d("PlatformViewRegistry", r4, "destroyPlugin");
        this.b.remove(r4);
        e r0 = b(r4);
        if (r0 == null) goto L6;
        r0.h(false);
        e r5 = this.d.remove(r4);
        return;
    }

    public final synchronized e b(String r3) {
        monitor-enter(this);
        if (r3 != null) goto L15;
        monitor-exit(this);
        return null;
    L15:
        e r0 = this.d.get(r3);     // Catch: Throwable -> L12
        if (r0 != null) goto L10;
        r0 = new e(r3);     // Catch: Throwable -> L12
        this.d.put(r3, r0);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }
}
