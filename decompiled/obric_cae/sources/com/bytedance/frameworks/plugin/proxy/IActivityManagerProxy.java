package com.bytedance.frameworks.plugin.proxy;

import android.app.IServiceConnection;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class IActivityManagerProxy extends com.bytedance.frameworks.plugin.proxy.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<Object, WeakReference<Object>> f3942d = null;

    public static class IServiceConnectionDelegate extends IServiceConnection.Stub {
        @Override // android.app.IServiceConnection
        public final void z2(IBinder r8) {
            HashMap<Object, WeakReference<Object>> r10 = IActivityManagerProxy.f3942d;
            monitor-enter(r10);
        L23:
            th = move-exception;
            throw th;
        L5:
            if (r10.get(this) == null) goto L7;
            Object r11 = r10.get(this).get();     // Catch: Throwable -> L23
        L8:
            monitor-exit(r10);     // Catch: Throwable -> L23
            if (r11 == null) goto L32;
            if (r8 != null) goto L30;
            monitor-enter(r10);
            r10.remove(this);     // Catch: Throwable -> L15
            monitor-exit(r10);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        L30:
            o7.a.a(r11, new Object[]{null, r8});     // Catch: Exception -> L20
            return;
        L20:
            e = move-exception;
            e.printStackTrace();
            return;
        L32:
            return;
        L7:
            r11 = null;
            goto L8
        }
    }

    public static class a extends android.support.v4.media.a {
    }

    public static class b extends android.support.v4.media.a {
    }

    public static class c extends android.support.v4.media.a {
    }

    public static class d extends android.support.v4.media.a {
        public d() {
            new ConcurrentHashMap();
        }
    }

    public static final class e extends android.support.v4.media.a {
    }

    public static class f extends android.support.v4.media.a {
    }

    public static class g extends android.support.v4.media.a {
    }

    public static class h extends android.support.v4.media.a {
    }

    public static class i extends android.support.v4.media.a {
    }

    public static class j extends android.support.v4.media.a {
    }

    public static class k extends android.support.v4.media.a {
    }

    public static class l extends android.support.v4.media.a {
    }

    public static class m extends android.support.v4.media.a {
    }

    public static class n extends android.support.v4.media.a {
    }

    public static class o extends android.support.v4.media.a {
    }

    public static class p extends android.support.v4.media.a {
    }

    static {
        f3942d = new HashMap();
        HashMap<String, android.support.v4.media.a> r8 = com.bytedance.frameworks.plugin.proxy.a.f3943c;
        r8.put("startActivity", new k());
        r8.put("startService", new l());
        r8.put("stopService", new m());
        r8.put("stopServiceToken", new n());
        r8.put("bindService", new a());
        r8.put("unbindService", new p());
        r8.put("setServiceForeground", new j());
        r8.put("serviceDoneExecuting", new i());
        r8.put("publishService", new g());
        r8.put("unbindFinished", new o());
        r8.put("broadcastIntent", new b());
        r8.put("finishReceiver", new c());
        r8.put("registerReceiver", new h());
        r8.put("overridePendingTransition", new f());
        r8.put("getContentProvider", new d());
        r8.put("getIntentSender", new e());
    }
}
