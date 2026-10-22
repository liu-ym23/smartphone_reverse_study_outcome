package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2479a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2480b = "2001:4860:4860::8888";
    private static AtomicBoolean c;

    static {
        c = new AtomicBoolean(false);
    }

    public d() {
    }

    public static void a() {
        if (Logger.debug() == false) goto L5;
        Logger.d(f2479a, "detectIpv6Reachable");
    L5:
        c.set(c());
    }

    public static AtomicBoolean b() {
        return c;
    }

    private static boolean c() {
        boolean r0 = false;
        DatagramSocket r1 = null;
        DatagramSocket r2 = new DatagramSocket();     // Catch: Throwable -> L14 IOException -> L21
        r2.connect(new InetSocketAddress(f2480b, 53));     // Catch: Throwable -> L11 IOException -> L13
        InetAddress r3 = r2.getLocalAddress();     // Catch: Throwable -> L11 IOException -> L13
        if (ZeusTransformUtils.instanceOf(r3, Inet6Address.class) == false) goto L10;
        boolean r4 = !r3.isLinkLocalAddress();     // Catch: Throwable -> L11 IOException -> L13
        if (r3.getHostAddress().startsWith("2001:0000") == true) goto L10;
        r0 = r4;
        goto L10
    L10:
        r2.close();
    L20:
        return r0;
    L13:
        r1 = r2;
    L11:
        th = th;
        r1 = r2;
    L15:
        if (r1 == null) goto L17;
        r1.close();
    L17:
        throw th;
    L14:
        th = th;
    L18:
        if (r1 == null) goto L20;
        r1.close();
        goto L20
    }
}
