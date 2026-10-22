package w2;

import com.bytedance.common.utility.Logger;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f13304a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f13305b = "2001:4860:4860::8888";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f13306c;

    static {
        f13306c = new AtomicBoolean(false);
    }

    public static void a() {
        if (Logger.debug() == false) goto L5;
        Logger.d(f13304a, "detectIpv6Reachable");
    L5:
        f13306c.set(c());
    }

    public static AtomicBoolean b() {
        return f13306c;
    }

    private static boolean c() {
        boolean r10 = false;
        DatagramSocket r11 = null;
        DatagramSocket r12 = new DatagramSocket();     // Catch: Throwable -> L14 IOException -> L21
        r12.connect(new InetSocketAddress(f13305b, 53));     // Catch: Throwable -> L11 IOException -> L13
        InetAddress r13 = r12.getLocalAddress();     // Catch: Throwable -> L11 IOException -> L13
        if ((r13 instanceof Inet6Address) == false) goto L10;
        boolean r14 = !r13.isLinkLocalAddress();     // Catch: Throwable -> L11 IOException -> L13
        if (r13.getHostAddress().startsWith("2001:0000") == true) goto L10;
        r10 = r14;
        goto L10
    L10:
        r12.close();
    L20:
        return r10;
    L13:
        r11 = r12;
    L11:
        th = th;
        r11 = r12;
    L15:
        if (r11 == null) goto L17;
        r11.close();
    L17:
        throw th;
    L14:
        th = th;
    L18:
        if (r11 == null) goto L20;
        r11.close();
        goto L20
    }
}
