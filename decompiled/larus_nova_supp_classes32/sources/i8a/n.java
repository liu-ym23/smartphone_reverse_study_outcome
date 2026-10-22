package i8a;

import android.app.Application;
import com.lynx.tasm.service.IServiceProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n {
    public static volatile n c;
    public Application a;
    public final Map<Class<?>, a> b;

    public static final class a {
        public final IServiceProvider a;
        public boolean b;

        public a(IServiceProvider r1) {
            this.a = r1;
            this.b = false;
        }
    }

    public static n c() {
        if (c != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new n();     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public n() {
        this.b = new ConcurrentHashMap();
    }

    public final <T extends IServiceProvider> T a(Class<T> r4) {
        a r0 = (a) ((ConcurrentHashMap) this.b).get(r4);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.b == true) goto L10;
        Objects.toString(r4);
        return null;
    L10:
        return (T) r0.a;
    }

    public final void b(Application r5) {
        this.a = r5;
        monitor-enter(a.class);
        Iterator r1 = ((ConcurrentHashMap) this.b).entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L10;
        a r2 = (a) ((Map.Entry) r1.next()).getValue();     // Catch: Throwable -> L12
        if (r2.b == true) goto L6;
        r2.b = true;     // Catch: Throwable -> L12
        r2.a.onInitialize(r5);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(a.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final <T extends IServiceProvider> void d(T r5) {
        Class<? extends IServiceProvider> r0 = r5.getServiceClass();
        if (r0.isInstance(r5) == false) goto L10;
        a r1 = new a(r5);
        Application r2 = this.a;
        if (r2 == null) goto L8;
        r1.b = true;
        r5.onInitialize(r2);
    L8:
        ((ConcurrentHashMap) this.b).put(r0, r1);
        return;
    }
}
