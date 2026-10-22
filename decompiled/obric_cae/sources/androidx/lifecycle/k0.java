package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f2175a;

    public k0() {
        this.f2175a = new LinkedHashMap();
    }

    public final void a() {
        Iterator r8 = this.f2175a.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L30;
        h0 r10 = (h0) r8.next();
        r10.f2165c = true;
        HashMap r11 = r10.f2163a;
        if (r11 == null) goto L17;
        monitor-enter(r11);
        Iterator r12 = r10.f2163a.values().iterator();     // Catch: Throwable -> L14
    L10:
        if (r12.hasNext() == false) goto L12;
        h0.a(r12.next());     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        LinkedHashSet r13 = r10.f2164b;
        if (r13 == null) goto L29;
        monitor-enter(r13);
        Iterator r14 = r10.f2164b.iterator();     // Catch: Throwable -> L26
    L22:
        if (r14.hasNext() == false) goto L24;
        h0.a((Closeable) r14.next());     // Catch: Throwable -> L26
        goto L22
    L24:
        monitor-exit(r13);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L29:
        r10.b();
        goto L4
    L30:
        this.f2175a.clear();
    }

    public final h0 b(String r8) {
        he.i.f(r8, "key");
        return (h0) this.f2175a.get(r8);
    }

    public final HashSet c() {
        return new HashSet(this.f2175a.keySet());
    }
}
