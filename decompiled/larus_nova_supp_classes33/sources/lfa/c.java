package lfa;

import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.Gson;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestStoreKt;
import com.obric.assistant.os.libs.NetworkStateInfo;
import com.obric.cae.libs.multipath.ICaeMultipathManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static volatile c g;
    public ICaeMultipathManager a;
    public PthreadHandlerThreadV2 b;
    public a c;
    public boolean d;
    public int e;
    public final Gson f;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.os.ServiceManager");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.ServiceManager");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.ServiceManager");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.os.ServiceManager");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.ServiceManager");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.ServiceManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.ServiceManager");
    }

    public static IBinder d() {
        Object r0 = a().getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_multipath"});     // Catch: Exception -> L7
        if ((r0 instanceof IBinder) == false) goto L9;
        return (IBinder) r0;
    L9:
        return null;
    L7:
        e = move-exception;
        ILogDepend.a.e("CaeMultipathClient", "Failed to get service binder using reflection", e);
        goto L9
    }

    public final NetworkStateInfo c() {
        ILogDepend.Companion r0 = ILogDepend.a;
        r0.i("CaeMultipathClient", "getLatestNetworkTruth");
        r0.i("CaeMultipathClient", "getLatestNetworkTruthStr");
        ICaeMultipathManager r2 = this.a;
        if (r2 == null) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == true) goto L24;
        r0.e("CaeMultipathClient", "Service not connected, triggering background reconnect");
        this.c.sendEmptyMessage(1);
    L13:
        String r1 = null;
    L15:
        if (TextUtils.isEmpty(r1) == false) goto L22;
        return null;
    L22:
        return (NetworkStateInfo) this.f.fromJson(r1, NetworkStateInfo.class);
    L19:
        e = move-exception;
        ILogDepend.a.e("CaeMultipathClient", "getLatestNetworkTruth Error", e);
        return null;
    L24:
        r1 = r2.getLatestNetworkTruth();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        ILogDepend.a.e("CaeMultipathClient", "Failed to get latest network truth", e);
        this.a = null;
        this.c.sendEmptyMessage(1);
        goto L13
    L5:
        r4 = false;
        goto L7
    }

    public c() {
        this.d = false;
        this.e = 0;
        this.f = new Gson();
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("CaeMultipathConnectThread");
        this.b = r0;
        ThreadMethodProxy.start(r0);
        a r1 = new a(this, this.b.getLooper());
        this.c = r1;
        r1.sendEmptyMessage(1);
    }

    public static void b(c r8) {
        if (r8.d == false) goto L5;
        ILogDepend.a.d("CaeMultipathClient", "Already connecting, skipping");
        return;
    L5:
        r8.d = true;
        IBinder r5 = d();     // Catch: Throwable -> L9 Exception -> L11
        if (r5 != null) goto L13;
        ILogDepend.a.e("CaeMultipathClient", "Failed to get cae_multipath service binder");     // Catch: Throwable -> L9 Exception -> L11
        r8.c.sendEmptyMessageDelayed(2, ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS);     // Catch: Throwable -> L9 Exception -> L11
    L24:
        r8.d = false;
        return;
    L13:
        ICaeMultipathManager r6 = ICaeMultipathManager.Stub.asInterface(r5);     // Catch: Throwable -> L9 Exception -> L11
        r8.a = r6;     // Catch: Throwable -> L9 Exception -> L11
        if (r6 != null) goto L30;
        ILogDepend.a.e("CaeMultipathClient", "Failed to create service interface");     // Catch: Throwable -> L9 Exception -> L11
        r8.c.sendEmptyMessageDelayed(2, ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS);     // Catch: Throwable -> L9 Exception -> L11
        goto L24
    L30:
        r5.linkToDeath(new b(r8), 0);     // Catch: Throwable -> L9 Exception -> L11 RemoteException -> L19
    L21:
        ILogDepend.a.d("CaeMultipathClient", "Connected to cae_multipath service");     // Catch: Throwable -> L9 Exception -> L11
    L19:
        e = move-exception;
        ILogDepend.a.e("CaeMultipathClient", "Failed to link to death", e);     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = move-exception;
        ILogDepend.a.e("CaeMultipathClient", "Failed to connect to cae_multipath service", e);     // Catch: Throwable -> L9
        r8.c.sendEmptyMessageDelayed(2, ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r8.d = false;
        throw th;
    }
}
