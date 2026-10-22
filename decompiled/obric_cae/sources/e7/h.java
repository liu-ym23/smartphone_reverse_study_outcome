package e7;

import com.bytedance.common.utility.Logger;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Callable<Void> {
    @Override // java.util.concurrent.Callable
    public final Void call() {
        AtomicBoolean r8 = f7.c.f7341a;
        Logger.d("c", "detectIpv6Reachable");
        AtomicBoolean r10 = f7.c.f7341a;
        DatagramSocket r11 = null;
        boolean r12 = false;
        DatagramSocket r13 = new DatagramSocket();     // Catch: Throwable -> L12 IOException -> L16
    L24:
        r13.connect(new InetSocketAddress("2001:4860:4860::8888", 53));     // Catch: Throwable -> L10 IOException -> L21
        InetAddress r14 = r13.getLocalAddress();     // Catch: Throwable -> L10 IOException -> L21
        if ((r14 instanceof Inet6Address) == false) goto L18;
        boolean r15 = !r14.isLinkLocalAddress();     // Catch: Throwable -> L10 IOException -> L21
        if (r14.getHostAddress().startsWith("2001:0000") == true) goto L18;
        r12 = r15;
        goto L18
    L18:
        r13.close();
    L19:
        r10.set(r12);
        return null;
    L10:
        th = th;
        r11 = r13;
    L13:
        if (r11 == null) goto L15;
        r11.close();
    L15:
        throw th;
    L17:
        if (r13 == null) goto L19;
    L16:
        r13 = null;
    L12:
        th = th;
        goto L13
    }
}
