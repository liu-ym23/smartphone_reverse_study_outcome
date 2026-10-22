package qa;

import android.content.Context;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class r4 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.net.Proxy$Type] */
    public static Proxy a(Context r8) {
        String r10 = "pu";
        URI r11 = new URI("http://restsdk.amap.com");     // Catch: Throwable -> L21
        if (k4.n(r8) != 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L25;
    L23:
        return null;
    L25:
        List<Proxy> r13 = ProxySelector.getDefault().select(r11);     // Catch: Throwable -> L18
        if (r13 == null) goto L23;
        if (r13.isEmpty() == true) goto L23;
        Proxy r14 = r13.get(0);     // Catch: Throwable -> L18
        if (r14 == null) goto L23;
        Proxy.Type r15 = r14.type();     // Catch: Throwable -> L18
        r10 = Proxy.Type.DIRECT;     // Catch: Throwable -> L18
        if (r15 == r10) goto L23;
        return r14;
    L18:
        th = move-exception;
        q.f("pu", "gpsc", th);     // Catch: Throwable -> L21
        goto L23
    L7:
        r12 = false;
    L21:
        th = move-exception;
        q.f(r10, "gp", th);
        goto L23
    }
}
