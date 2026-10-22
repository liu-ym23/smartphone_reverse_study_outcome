package w4a;

import com.lynx.animax.service.IAnimaXService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public final Map<Class<? extends IAnimaXService>, IAnimaXService> a;
    public final e b;

    public d(e r2) {
        this.a = new ConcurrentHashMap();
        this.b = r2;
    }

    public final <T extends IAnimaXService> T a(Class<T> r3) {
        IAnimaXService r0 = (IAnimaXService) ((ConcurrentHashMap) this.a).get(r3);
        if (r0 != null) goto L5;
        a r1 = a.b();
        e r2 = this.b;
        Map r4 = (Map) ((ConcurrentHashMap) r1.a).get(r2);
        if (r4 != null) goto L9;
    L11:
        return null;
    L9:
        if (r4.containsKey(r3) == false) goto L11;
        return (T) r4.get(r3);
    L5:
        return r3.cast(r0);
    }
}
