package n4a;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d5 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.net.Proxy$Type] */
    public static Proxy a(Context r3) {
        String r0 = "pu";
        URI r1 = new URI("http://restsdk.amap.com");     // Catch: Throwable -> L21
        if (x4.r(r3) != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L25;
    L23:
        return null;
    L25:
        List<Proxy> r5 = ProxySelector.getDefault().select(r1);     // Catch: Throwable -> L18
        if (r5 == null) goto L23;
        if (r5.isEmpty() == true) goto L23;
        Proxy r6 = (Proxy) ListProtector.get(r5, 0);     // Catch: Throwable -> L18
        if (r6 == null) goto L23;
        Proxy.Type r2 = r6.type();     // Catch: Throwable -> L18
        r0 = Proxy.Type.DIRECT;     // Catch: Throwable -> L18
        if (r2 == r0) goto L23;
        return r6;
    L18:
        th = move-exception;
        r.f(th, "pu", "gpsc");     // Catch: Throwable -> L21
        goto L23
    L7:
        r4 = false;
    L21:
        th = move-exception;
        r.f(th, r0, "gp");
        goto L23
    }
}
