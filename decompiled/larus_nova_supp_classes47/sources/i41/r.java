package i41;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r {
    public static r b;
    public static final a c = null;
    public final List<q> a;

    public static final class a {
        public final synchronized r a() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (r.b != null) goto L6;
            r.b = new r();     // Catch: Throwable -> L9
        L6:
            r r0 = r.b;     // Catch: Throwable -> L9
            Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L9
            monitor-exit(this);
            return r0;
        }

        public a() {
        }
    }

    static {
        c = new a();
    }

    public final void a() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((q) r0.next()).onEnd();
        goto L4
    }

    public r() {
        this.a = new ArrayList();
    }
}
