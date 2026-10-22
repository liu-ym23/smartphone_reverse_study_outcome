package ytb;

import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class t {
    public static final Object a(Class r4) {
        s r0 = s.a;
        return Proxy.newProxyInstance(r4.getClassLoader(), new Class[]{r4}, r0);
    }
}
