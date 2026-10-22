package ac2;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public final vlc.d a;
    public final ConcurrentHashMap<Class<?>, Object> b;
    public final Map<Method, r<?>> c;

    public i(vlc.d r2) {
        this.b = new ConcurrentHashMap();
        this.c = new LinkedHashMap();
        this.a = r2;
    }

    public final <T> T a(Class<T> r5) {
        vlc.e r0 = this.a;
        if ((r0 instanceof vlc.e) == false) goto L5;
        vlc.e r1 = r0;
        if (k.c() == true) goto L11;
        return (T) com.bytedance.android.live.network.c.b().e(r5);
    L11:
        if (((Boolean) com.bytedance.android.livesdk.interactivity.service.settings.k.a.getValue()).booleanValue() == false) goto L15;
        return (T) e.b().a(r5);
    L15:
        if (r1.isRunning() == false) goto L22;
        if (this.b.contains(r5) == true) goto L20;
        ConcurrentHashMap<Class<?>, Object> r2 = this.b;
        y.i(r5);
        r2.putIfAbsent(r5, Proxy.newProxyInstance(r5.getClassLoader(), new Class[]{r5}, new h(this)));
    L20:
        return (T) this.b.get(r5);
    L22:
        return (T) com.bytedance.android.live.network.c.b().e(r5);
    L5:
        return (T) com.bytedance.android.live.network.c.b().e(r5);
    }
}
