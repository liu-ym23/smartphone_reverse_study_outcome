package com.bytedance.monitor.collector.a;

import android.app.Service;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f2835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f2836b;
    private static Map<IBinder, Service> c;
    private Handler.Callback d;

    static {
        f2835a = new d();
        f2836b = null;
    }

    private d() {
    }

    public static d a() {
        return f2835a;
    }

    public static c c() {
        return f2836b;
    }

    public static void d() {
        f2836b = null;
    }

    public synchronized String a(IBinder r4) {
        monitor-enter(this);
        IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (c == null) goto L20;
    L6:
        Map<IBinder, Service> r0 = c;     // Catch: Throwable -> L14
        String r1 = null;
        if (r0 != null) goto L9;
    L12:
        monitor-exit(this);
        return r1;
    L9:
        if (r0.get(r5) == null) goto L12;
        r1 = ((Service) ZeusTransformUtils.preCheckCast(c.get(r5), Service.class, "com.obric.memorydata.plugin")).getClass().getName();     // Catch: Throwable -> L14
        goto L12
    L20:
        Object r2 = com.bytedance.monitor.util.a.e();     // Catch: Throwable -> L17
        c = (Map) ZeusTransformUtils.preCheckCast(a.b(r2.getClass(), "mServices").get(r2), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
    L14:
        th = move-exception;
        throw th;
    }

    public void b() {
        Handler r1 = (Handler) ZeusTransformUtils.preCheckCast(com.bytedance.monitor.util.a.d(), Handler.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Field r2 = a.b(Handler.class, "mCallback");     // Catch: Throwable -> L5
        this.d = (Handler.Callback) ZeusTransformUtils.preCheckCast(r2.get(r1), Handler.Callback.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        r2.set(r1, this);     // Catch: Throwable -> L5
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        if (b.a(r2) == false) goto L5;
        f2836b = c.a(r2);     // Catch: Throwable -> L11
    L5:
        Handler.Callback r1 = this.d;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.handleMessage(r2);
    }
}
