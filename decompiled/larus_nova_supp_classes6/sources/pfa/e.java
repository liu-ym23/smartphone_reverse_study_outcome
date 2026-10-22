package pfa;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.PackageUtils;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e {
    public static final e a = null;
    public static IBinder b;
    public static boolean c;
    public static long d;
    public static long e;
    public static String f;
    public static final pfa.a g = null;
    public static final a h = null;
    public static final b i = null;
    public static final c j = null;

    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r5) {
            FLogger.a.w("MemoryProcessControler", "onServiceDisconnected: " + r5 + ", will reconnect after " + e.d + "ms");
            e r6 = e.a;
            IBinder r7 = e.b;
            if (r7 != null) goto L9;
        L7:
            e.b = null;
            e.c();
            return;
        L9:
            r7.unlinkToDeath(e.g, 0);     // Catch: Exception -> L6
        L6:
            Unit r8 = Unit.INSTANCE;
            goto L7
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r4, final IBinder r5) {
            FLogger r0 = FLogger.a;
            r0.i("MemoryProcessControler", "onServiceConnected: " + r4);
            if (r5 != null) goto L6;
            r0.e("MemoryProcessControler", "onServiceConnected: service binder is null, will reconnect");
            e r6 = e.a;
            e.c();
            return;
        L6:
            e.b = r5;
            e r7 = e.a;
            ((Handler) s.c.getValue()).post(new d(r5));
        }
    }

    public e() {
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [pfa.a] */
    /* JADX WARN: Type inference failed for: r0v6, types: [pfa.b] */
    /* JADX WARN: Type inference failed for: r0v7, types: [pfa.c] */
    static {
        a = new e();
        d = 5000;
        e = 1000;
        f = "MidLevel";
        g = new pfa.a();
        h = new a();
        i = new b();
        j = new c();
    }

    public static void a() {
        FLogger.a.i("MemoryProcessControler", "reconnectRunnable: rebinding service");
        a.bindService();
    }

    public static void b() {
        FLogger r0 = FLogger.a;
        r0.i("MemoryProcessControler", "initBindRunnable: start bind after delay=" + e + "ms");
        e r1 = a;
        if (c == false) goto L5;
        r0.d("MemoryProcessControler", "startBind: already bound, skip");
        return;
    L5:
        r1.bindService();
    }

    private final void bindService() {
        Application r0 = AppHost.a.getApplication();
        if (r0 != null) goto L5;
        return;
    L5:
        FLogger r1 = FLogger.a;
        r1.i("MemoryProcessControler", "bindService: context = " + r0);
        Intent r2 = new Intent("com.obric.memorydata.awareness.CONTEXT_AWARENESS_SERVICE");
        r2.setPackage(PackageUtils.NOVA_PKG_NAME);
        boolean r4 = Intrinsics.areEqual(f, "HighLevel");     // Catch: Exception -> L17
        a r5 = h;
        if (r4 == true) goto L10;
        boolean r3 = r0.bindService(r2, r5, 33);     // Catch: Exception -> L17
    L12:
        c = r3;     // Catch: Exception -> L17
        if (r3 == true) goto L15;
        r1.e("MemoryProcessControler", "bindService returned false, will retry");     // Catch: Exception -> L17
        c();     // Catch: Exception -> L17
        return;
    L15:
        r1.i("MemoryProcessControler", "bindService: request sent");     // Catch: Exception -> L17
        return;
    L10:
        r3 = r0.bindService(r2, r5, 65);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        FLogger.a.e("MemoryProcessControler", "bindService failed", e);
        c = false;
        c();
    }

    public static void c() {
        Lazy r0 = s.c;
        Handler r1 = (Handler) r0.getValue();
        b r2 = i;
        r1.removeCallbacks(r2);
        ((Handler) r0.getValue()).postDelayed(r2, d);
    }
}
