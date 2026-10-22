package d64;

import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements MemoryTrimmableRegistry {
    public static c c;
    public final Set<MemoryTrimmable> a;
    public final Object b;

    public c() {
        this.a = new HashSet();
        this.b = new Object();
    }

    public final void registerMemoryTrimmable(MemoryTrimmable r3) {
        if (r3 == null) goto L11;
        Object r0 = this.b;
        monitor-enter(r0);
        ((HashSet) this.a).add(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void unregisterMemoryTrimmable(MemoryTrimmable r3) {
        if (r3 == null) goto L11;
        Object r0 = this.b;
        monitor-enter(r0);
        ((HashSet) this.a).remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
