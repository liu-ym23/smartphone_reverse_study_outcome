package o;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, b> f11367a;

    public a() {
        this.f11367a = new HashMap();
    }

    public void a(String r10, b r11) {
        this.f11367a.put(r10, r11);
    }

    public void b() {
        if (this.f11367a.size() != 0) goto L5;
        return;
    L5:
        Class<?> r10 = Class.forName("android.app.SystemServiceRegistry");
        Field r11 = r10.getDeclaredField("SYSTEM_SERVICE_FETCHERS");
        r11.setAccessible(true);
        Map r12 = (Map) r11.get(null);
        Iterator<Map.Entry<String, b>> r13 = this.f11367a.entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry<String, b> r14 = r13.next();
        String r15 = r14.getKey();
        b r16 = r14.getValue();
        Object r17 = r12.get(r15);
        r12.put(r15, Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{Class.forName("android.app.SystemServiceRegistry$ServiceFetcher")}, new c(r17, r16)));
        goto L7
    }
}
