package ac2;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static volatile e c;
    public final ConcurrentHashMap<Class<?>, Object> a;
    public final Map<Method, r<?>> b;

    public static e b() {
        if (c != null) goto L15;
        monitor-enter(com.bytedance.android.live.network.c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.android.live.network.c.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public e() {
        this.a = new ConcurrentHashMap();
        this.b = new LinkedHashMap();
        lmc.a r0 = c.b;
        com.ss.ugc.live.sdk.msg.utils.a.c(r0.l, "uplink client start");
        r0.i.h(r0);
        lmc.c r1 = new lmc.c(r0);
        ThreadMethodProxy.start(r1);
        Unit r2 = Unit.INSTANCE;
        r0.b = r1;
    }

    public final <T> T a(Class<T> r5) {
        if (this.a.contains(r5) == true) goto L6;
        ConcurrentHashMap<Class<?>, Object> r0 = this.a;
        y.i(r5);
        r0.putIfAbsent(r5, Proxy.newProxyInstance(r5.getClassLoader(), new Class[]{r5}, new d(this)));
    L6:
        return (T) this.a.get(r5);
    }
}
