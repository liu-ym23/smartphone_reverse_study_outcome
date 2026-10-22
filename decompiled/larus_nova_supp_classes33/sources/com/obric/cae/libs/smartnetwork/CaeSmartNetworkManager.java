package com.obric.cae.libs.smartnetwork;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.cae.libs.statusreport.CaeStatusReportManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.wifi.ICaeSmartNetworkManager;
import com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class CaeSmartNetworkManager {
    public static CaeSmartNetworkManager c;
    public ICaeSmartNetworkManager a;
    public final HashMap b;

    public interface CaeWifiLinkThroughputListener {
        void onSecondaryThroughputReported(int r1, int r2);

        void onThroughputReported(int r1, int r2);
    }

    public class CaeWifiLinkThroughputListenerProxy extends ICaeWifiLinkThroughputListener.Stub {
        private final CaeWifiLinkThroughputListener mListener;
        final /* synthetic */ CaeSmartNetworkManager this$0;

        public CaeWifiLinkThroughputListener getListener() {
            return this.mListener;
        }

        public CaeWifiLinkThroughputListenerProxy(CaeSmartNetworkManager r1, CaeWifiLinkThroughputListener r2) {
            this.this$0 = r1;
            this.mListener = r2;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener
        public void onSecondaryThroughputReported(int r2, int r3) {
            CaeWifiLinkThroughputListener r0 = this.mListener;
            if (r0 == null) goto L6;
            r0.onSecondaryThroughputReported(r2, r3);
            return;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener
        public void onThroughputReported(int r2, int r3) {
            CaeWifiLinkThroughputListener r0 = this.mListener;
            if (r0 == null) goto L6;
            r0.onThroughputReported(r2, r3);
            return;
        }
    }

    public class a extends Thread {
        public final /* synthetic */ CaeSmartNetworkManager a;

        public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
            return Class.forName(r0);
        }

        public final void com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager$a__run$___twin___() {
            int r1 = 0;
        L4:
            if (r1 >= 50) goto L30;
            SystemClock.sleep(100);
            this.a.a = ICaeSmartNetworkManager.Stub.asInterface((IBinder) INVOKESTATIC_com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_wifi"}));     // Catch: Exception -> L8
        L10:
            CaeSmartNetworkManager r2 = this.a;
            if (r2.a != null) goto L12;
            r1 = r1 + 1;
            goto L4
        L12:
            r2.a();
            CaeSmartNetworkManager r0 = this.a;
            HashMap r3 = r0.b;
            if (r3 != null) goto L15;
            return;
        L15:
            if (r3.size() <= 0) goto L64;
            Iterator r4 = r0.b.keySet().iterator();
        L18:
            if (r4.hasNext() == false) goto L66;
            CaeWifiLinkThroughputListenerProxy r5 = (CaeWifiLinkThroughputListenerProxy) r0.b.get((Integer) r4.next());
            if (r5 == null) goto L18;
            ICaeSmartNetworkManager r6 = r0.a;
            if (r6 == null) goto L24;
            r6.registerLinkThroughputListener(r5);     // Catch: RemoteException -> L27
        L27:
            LogUtil.e("CaeSmartNetworkManager", "RemoteException !!!");
            goto L18
        L24:
            LogUtil.e("CaeSmartNetworkManager", "autoRegisterListenerOnRetryBindSuccess, mISmartNetworkMgr is null");
            return;
        L66:
            return;
        L64:
            return;
        L8:
            e = move-exception;
            LogUtil.e("CaeSmartNetworkManager", "Get service failed: " + e);
            goto L10
        L30:
            LogUtil.e("CaeSmartNetworkManager", "get smart network service error!!!");
            CaeSmartNetworkManager r7 = this.a;
            HashMap r8 = r7.b;
            if (r8 != null) goto L33;
            return;
        L33:
            if (r8.size() <= 0) goto L67;
            Iterator r9 = r7.b.keySet().iterator();
        L36:
            if (r9.hasNext() == false) goto L68;
            Integer r10 = (Integer) r9.next();
            CaeWifiLinkThroughputListenerProxy r11 = (CaeWifiLinkThroughputListenerProxy) r7.b.get(r10);
            if (r11 == null) goto L36;
            if (r11.getListener() == null) goto L36;
            r11.getListener().onThroughputReported(0, 0);
            r11.getListener().onSecondaryThroughputReported(0, 0);
            r7.b.remove(r10);
            goto L36
        L68:
            return;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public a(CaeSmartNetworkManager r1) {
            this.a = r1;
            super("CaeSmartNetworkManager$a");
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
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

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager$a_com_larus_apm_impl_protector_RunnableLancet_run(a r1) {
            r1.com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class b implements IBinder.DeathRecipient {
        public final /* synthetic */ CaeSmartNetworkManager a;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeSmartNetworkManager", "statusReport service is dead!");
            CaeSmartNetworkManager r0 = this.a;
            r0.a = null;
            r0.retryGetServiceThread();
        }

        public b(CaeSmartNetworkManager r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public final void a() {
        this.a.asBinder().linkToDeath(new b(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("CaeStatusReportManager linkToDeath! :", e, "CaeSmartNetworkManager");
    }

    public int getLinkThroughput() {
        ICaeSmartNetworkManager r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("CaeSmartNetworkManager", "getLinkThroughput, mISmartNetworkMgr is null");
        return 0;
    L11:
        return r0.getLinkThroughput();
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("getLinkThroughput failed: ", e, "CaeSmartNetworkManager");
        return 0;
    }

    public void retryGetServiceThread() {
        ThreadMethodProxy.start(new a(this));
    }

    public CaeSmartNetworkManager(Context r6) {
        this.b = new HashMap();
        this.a = ICaeSmartNetworkManager.Stub.asInterface((IBinder) INVOKESTATIC_com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_wifi"}));     // Catch: Exception -> L5
    L8:
        if (this.a == null) goto L10;
        a();
        return;
    L10:
        retryGetServiceThread();
        return;
    L5:
        e = move-exception;
        LogUtil.e("CaeSmartNetworkManager", "Get service failed: " + e);
        goto L8
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_cae_libs_smartnetwork_CaeSmartNetworkManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
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

    public static CaeSmartNetworkManager getInstance(Context r2) {
        if (r2 == null) goto L15;
        monitor-enter(CaeStatusReportManager.class);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (c != null) goto L8;
        c = new CaeSmartNetworkManager(r2);     // Catch: Throwable -> L11
    L8:
        monitor-exit(CaeStatusReportManager.class);     // Catch: Throwable -> L11
        return c;
    L15:
        throw new IllegalArgumentException("context cannot be null");
    }

    public void registerLinkThroughputListener(CaeWifiLinkThroughputListener r4) {
        if (this.a != null) goto L6;
        LogUtil.e("CaeSmartNetworkManager", "registerLinkThroughputListener, mISmartNetworkMgr is null");
        return;
    L6:
        CaeWifiLinkThroughputListenerProxy r0 = new CaeWifiLinkThroughputListenerProxy(this, r4);
        this.b.put(Integer.valueOf(r0.hashCode()), r0);
        this.a.registerLinkThroughputListener(r0);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("registerLinkThroughputListener failed: ", e, "CaeSmartNetworkManager");
    }

    public void unregisterLinkThroughputListener(CaeWifiLinkThroughputListener r3) {
        if (this.a != null) goto L6;
        LogUtil.e("CaeSmartNetworkManager", "unregisterLinkThroughputListener, mISmartNetworkMgr is null");
        return;
    L6:
        CaeWifiLinkThroughputListenerProxy r4 = (CaeWifiLinkThroughputListenerProxy) this.b.get(Integer.valueOf(r3.hashCode()));
        if (r4 != null) goto L15;
        LogUtil.e("CaeSmartNetworkManager", "unregisterLinkThroughputListener failed: proxy is null");
        return;
    L15:
        this.a.unregisterLinkThroughputListener(r4);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("unregisterLinkThroughputListener failed: ", e, "CaeSmartNetworkManager");
    }
}
