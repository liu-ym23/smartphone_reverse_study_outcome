package com.bytedance.crash;

import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m.b f4025a = null;

    static {
        m.b r5 = new m.b(4);
        com.bytedance.crash.ensure.a.a();
        f4025a = r5;
    }

    public static m.b a() {
        return f4025a;
    }

    public static void b(Throwable r10) {
        f4025a.getClass();
        if (n.f4062j.isEnsureEnable() == false) goto L50;
        HashSet r5 = com.bytedance.crash.util.e.f4178a;
    L35:
        th = move-exception;
        th.printStackTrace();
    L38:
        if (m.b.i("NPTH_ANR_MONITOR_ERROR") == true) goto L41;
        return;
    L41:
        if (com.bytedance.crash.upload.n.f() == true) goto L62;
        com.bytedance.crash.upload.b.j(null, r10, null, 0, "NPTH_ANR_MONITOR_ERROR", Thread.currentThread(), "EnsureNotReachHere");     // Catch: Throwable -> L45
        return;
    L63:
        return;
    L62:
        return;
    L6:
        if ((r10 instanceof ConnectTimeoutException) == false) goto L9;
        return;
    L9:
        if ((r10 instanceof SocketTimeoutException) == false) goto L12;
        return;
    L12:
        if ((r10 instanceof BindException) == false) goto L15;
        return;
    L15:
        if ((r10 instanceof ConnectException) == false) goto L18;
        return;
    L18:
        if ((r10 instanceof NoRouteToHostException) == false) goto L21;
        return;
    L21:
        if ((r10 instanceof PortUnreachableException) == false) goto L24;
        return;
    L24:
        if ((r10 instanceof SocketException) == false) goto L27;
        return;
    L27:
        if ((r10 instanceof UnknownHostException) == false) goto L30;
        return;
    L30:
        if ((r10 instanceof ProtocolException) == true) goto L59;
        if ((r10 instanceof SSLException) == false) goto L38;
        return;
    L59:
        return;
    }
}
