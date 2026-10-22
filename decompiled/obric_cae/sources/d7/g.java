package d7;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import java.io.IOException;
import java.net.InetSocketAddress;
import we.a0;
import we.d0;
import we.y;

/* JADX INFO: loaded from: classes.dex */
public final class g implements we.s {
    @Override // we.s
    public final a0 a(af.f r8) {
        y r10 = r8.f364f;
        InetSocketAddress r11 = null;
        ze.d r12 = r8.f362d;     // Catch: Throwable -> L26
        if (r12 == null) goto L6;
        d0 r13 = r12.f14374c;     // Catch: Throwable -> L26
    L7:
        if (r13 == null) goto L10;
        r11 = r13.f13160c;     // Catch: Throwable -> L26
    L10:
        if (Logger.debug() == false) goto L32;
        Logger.d("OkHttp3Builder", "-call- get res -  req: " + r10.hashCode() + " conn: " + r12 + " route: " + r13 + " addr: " + r11);     // Catch: Throwable -> L26
        goto L32
    L6:
        r13 = null;
    L32:
        a0 r14 = r8.e(r10);     // Catch: IOException -> L16
        if (r11 == null) goto L36;
        r14.getClass();     // Catch: Throwable -> L27
        a0.a r15 = new a0.a(r14);     // Catch: Throwable -> L27
        r15.f13131f.a("x-net-info.remoteaddr", r11.getAddress().getHostAddress());     // Catch: Throwable -> L27
        return r15.b();
    L37:
        return r14;
    L36:
        return r14;
    L16:
        e = move-exception;
        if (r11 != null) goto L34;
    L25:
        throw e;
    L34:
        String r16 = e.getMessage();     // Catch: Throwable -> L23
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L23
        r17.append(r11.getAddress().getHostAddress());     // Catch: Throwable -> L23
        r17.append("|");     // Catch: Throwable -> L23
        if (r16 != null) goto L21;
        r16 = "null";
    L21:
        r17.append(r16);     // Catch: Throwable -> L23
        Reflect.on(e).set("detailMessage", r17.toString());     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
        goto L25
    }
}
