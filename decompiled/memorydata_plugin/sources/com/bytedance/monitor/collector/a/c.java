package com.bytedance.monitor.collector.a;

import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static Field f;
    private static Field g;
    private static Field h;
    private static Field i;
    private static Field j;
    private static Field k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2834b;
    public long c;
    public String d;
    public String e;

    public c() {
    }

    public c(String r1, int r2, long r3, String r5) {
        this.f2833a = r1;
        this.f2834b = r2;
        this.c = r3;
        this.d = r5;
        this.e = Thread.currentThread().getName();
    }

    public static c a(Message r14) {
        switch(r14.what) {
            case 114: goto L37;
            case 115: goto L30;
            case 116: goto L28;
            case 117: goto L48;
            case 118: goto L48;
            case 119: goto L48;
            case 120: goto L48;
            case 121: goto L21;
            case 122: goto L14;
            case 123: goto L7;
            default: goto L48;
        };
    L48:
        throw new IllegalArgumentException("message.what = " + r14.what + " is not excepted!");     // Catch: Throwable -> L51
    L7:
        if (k != null) goto L9;
        k = a.b(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L9:
        IBinder r0 = (IBinder) ZeusTransformUtils.preCheckCast(k.get(r14.obj), IBinder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        if (r0 == null) goto L50;
        return new c(d.a().a(r0), r14.what, System.currentTimeMillis(), r0.toString());
    L14:
        if (j != null) goto L16;
        j = a.b(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L16:
        IBinder r1 = (IBinder) ZeusTransformUtils.preCheckCast(j.get(r14.obj), IBinder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        if (r1 == null) goto L50;
        return new c(d.a().a(r1), r14.what, System.currentTimeMillis(), r1.toString());
    L21:
        if (i != null) goto L23;
        i = a.b(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L23:
        IBinder r2 = (IBinder) ZeusTransformUtils.preCheckCast(i.get(r14.obj), IBinder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        if (r2 == null) goto L50;
        return new c(d.a().a(r2), r14.what, System.currentTimeMillis(), r2.toString());
    L28:
        return new c(d.a().a((IBinder) ZeusTransformUtils.preCheckCast(r14.obj, IBinder.class, "com.obric.memorydata.plugin")), r14.what, System.currentTimeMillis(), r14.obj.toString());
    L30:
        if (h != null) goto L32;
        h = a.b(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L32:
        IBinder r3 = (IBinder) ZeusTransformUtils.preCheckCast(h.get(r14.obj), IBinder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        if (r3 == null) goto L50;
        return new c(d.a().a(r3), r14.what, System.currentTimeMillis(), r3.toString());
    L37:
        if (f != null) goto L40;
        f = a.b(r14.obj.getClass(), "info");     // Catch: Throwable -> L51
    L40:
        if (g != null) goto L42;
        g = a.b(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L42:
        ServiceInfo r4 = (ServiceInfo) ZeusTransformUtils.preCheckCast(f.get(r14.obj), ServiceInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        String r5 = null;
        if (r4 == null) goto L46;
        r5 = r4.name;     // Catch: Throwable -> L51
    L46:
        return new c(r5, r14.what, System.currentTimeMillis(), g.get(r14.obj).toString());
    L50:
        return new c("unknow", r14.what, System.currentTimeMillis(), "unknow");
    }

    public String toString() {
        return "ServiceFollowBean{mServiceName='" + this.f2833a + "', mWhat=" + this.f2834b + ", mTimeStamp=" + this.c + ", mToken='" + this.d + "', mThreadName='" + this.e + "'}";
    }
}
