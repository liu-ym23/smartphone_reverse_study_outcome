package com.obric.cae.libs.nfc;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.cae.libs.utils.LogUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class CaeNfcAdapter {
    public static final Object d = null;
    public static Method e;
    public static CaeNfcAdapter f;
    public volatile ICaeNfcAdapter a;
    public volatile CaeNfcOmapiExecutor b;
    public volatile CaeNfcEventManager c;

    public class a implements IBinder.DeathRecipient {
        public final /* synthetic */ CaeNfcAdapter a;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("NFC:CaeNfcAdapter", "cae_nfc service is dead!");
            this.a.a = null;
            this.a.b = null;
            this.a.c = null;
            this.a.c();
        }

        public a(CaeNfcAdapter r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ void a(CaeNfcAdapter r0) {
        r0.b();
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private /* synthetic */ void b() {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L12;
        this.a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L9
        if (this.a == null) goto L11;
        d();     // Catch: Exception -> L9
        LogUtil.d("NFC:CaeNfcAdapter", "Get service success after retry");     // Catch: Exception -> L9
        return;
    L11:
        r0 = r0 + 1;
        SystemClock.sleep(300);
    L9:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "Retry get service failed: " + e);
        goto L11
    L12:
        LogUtil.e("NFC:CaeNfcAdapter", "Retry get service failed after 10 times");
    }

    static {
        d = new Object();
    }

    public static IBinder a() throws Exception {
        Object r0 = d;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (e != null) goto L7;
        e = INVOKESTATIC_com_obric_cae_libs_nfc_CaeNfcAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class});     // Catch: Throwable -> L15
    L7:
        Method r1 = e;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return (IBinder) r1.invoke(null, new Object[]{CaeNfcConstants.SERVICE_NAME_NFC});
    L12:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "getService denied: " + e);
        return null;
    }

    public final void c() {
        ThreadMethodProxy.start(new PthreadThreadV2(new com.obric.cae.libs.nfc.a(this), "CaeNfcAdapter"));
    }

    public final void d() {
        this.a.asBinder().linkToDeath(new a(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("linkToDeath failed: ", e, "NFC:CaeNfcAdapter");
    }

    public CaeNfcEventManager getEventManager() {
        if (this.c == null) goto L7;
        return this.c;
    L7:
        if (this.a == null) goto L28;
    L27:
        ICaeNfcEventManager r0 = this.a.getEventManager();     // Catch: RemoteException -> L24
        if (r0 != null) goto L22;
        LogUtil.e("NFC:CaeNfcAdapter", "getEventManager: service is null");     // Catch: RemoteException -> L24
        return null;
    L22:
        this.c = new CaeNfcEventManager(r0);     // Catch: RemoteException -> L24
        return this.c;
    L24:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcAdapter");
        return null;
    L28:
        this.a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L12
        if (this.a == null) goto L14;
        d();     // Catch: Exception -> L12
        boolean r1 = true;
    L15:
        if (r1 == true) goto L27;
        LogUtil.e("NFC:CaeNfcAdapter", "getEventManager: mICaeNfcAdapter is null");
        return null;
    L14:
        c();
        r1 = false;
    L12:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "ensureService failed: " + e);
        goto L14
    }

    public CaeNfcOmapiExecutor getOmapiExecutor() {
        if (this.b == null) goto L7;
        return this.b;
    L7:
        if (this.a == null) goto L28;
    L27:
        ICaeNfcOmapiExecutor r0 = this.a.getOmapiExecutor();     // Catch: RemoteException -> L24
        if (r0 != null) goto L22;
        LogUtil.e("NFC:CaeNfcAdapter", "getOmapiExecutor: service is null");     // Catch: RemoteException -> L24
        return null;
    L22:
        this.b = new CaeNfcOmapiExecutor(r0);     // Catch: RemoteException -> L24
        return this.b;
    L24:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcAdapter");
        return null;
    L28:
        this.a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L12
        if (this.a == null) goto L14;
        d();     // Catch: Exception -> L12
        boolean r1 = true;
    L15:
        if (r1 == true) goto L27;
        LogUtil.e("NFC:CaeNfcAdapter", "getOmapiExecutor: mICaeNfcAdapter is null");
        return null;
    L14:
        c();
        r1 = false;
    L12:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "ensureService failed: " + e);
        goto L14
    }

    public CaeNfcAdapter(Context r3) {
        r3.getApplicationContext();
        this.a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L5
    L8:
        if (this.a == null) goto L10;
        d();
        return;
    L10:
        c();
        return;
    L5:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "Get service failed: " + e);
        goto L8
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_cae_libs_nfc_CaeNfcAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static CaeNfcAdapter getDefaultAdapter(Context r2) {
        if (r2 == null) goto L15;
        monitor-enter(CaeNfcAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f != null) goto L8;
        f = new CaeNfcAdapter(r2);     // Catch: Throwable -> L11
    L8:
        monitor-exit(CaeNfcAdapter.class);     // Catch: Throwable -> L11
        return f;
    L15:
        throw new IllegalArgumentException("context cannot be null");
    }
}
