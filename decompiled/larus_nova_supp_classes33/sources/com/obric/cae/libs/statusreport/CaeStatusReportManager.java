package com.obric.cae.libs.statusreport;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.libs.utils.LogUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class CaeStatusReportManager {
    public static CaeStatusReportManager d;
    public ICaeStatusReportManager a;
    public final Context b;
    public final HashMap c;

    public interface LinkLayerQualityChangedListener {
        void onAverLinkLayerLevelChanged(LinkLayerQuality r1);

        void onLinkLayerLevelChanged(LinkLayerQuality r1);

        void onLinkLayerQualityChanged(LinkLayerQuality r1);
    }

    public class LinkLayerQualityChangedListenerProxy extends ILinkLayerQualityListener.Stub {
        private final LinkLayerQualityChangedListener mListener;
        final /* synthetic */ CaeStatusReportManager this$0;

        public LinkLayerQualityChangedListener getListener() {
            return this.mListener;
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onAverLinkLayerLevelChanged(LinkLayerQuality r2) {
            this.mListener.onAverLinkLayerLevelChanged(r2);
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerLevelChanged(LinkLayerQuality r2) {
            this.mListener.onLinkLayerLevelChanged(r2);
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerQualityChanged(LinkLayerQuality r2) {
            this.mListener.onLinkLayerQualityChanged(r2);
        }

        public LinkLayerQualityChangedListenerProxy(CaeStatusReportManager r1, LinkLayerQualityChangedListener r2) {
            this.this$0 = r1;
            this.mListener = r2;
        }
    }

    public class a extends Thread {
        public final /* synthetic */ CaeStatusReportManager a;

        public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
            return Class.forName(r0);
        }

        public final void com_obric_cae_libs_statusreport_CaeStatusReportManager$a__run$___twin___() {
            int r1 = 0;
        L4:
            if (r1 >= 50) goto L30;
            SystemClock.sleep(100);
            this.a.a = ICaeStatusReportManager.Stub.asInterface((IBinder) INVOKESTATIC_com_obric_cae_libs_statusreport_CaeStatusReportManager$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_status_report"}));     // Catch: Exception -> L8
        L10:
            CaeStatusReportManager r2 = this.a;
            if (r2.a != null) goto L12;
            r1 = r1 + 1;
            goto L4
        L12:
            r2.a();
            CaeStatusReportManager r0 = this.a;
            HashMap r3 = r0.c;
            if (r3 != null) goto L15;
            return;
        L15:
            if (r3.size() <= 0) goto L64;
            Iterator r4 = r0.c.keySet().iterator();
        L18:
            if (r4.hasNext() == false) goto L66;
            LinkLayerQualityChangedListenerProxy r5 = (LinkLayerQualityChangedListenerProxy) r0.c.get((Integer) r4.next());
            if (r5 == null) goto L18;
            ICaeStatusReportManager r6 = r0.a;
            if (r6 == null) goto L24;
            r6.registerLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(r0.b), r5);     // Catch: RemoteException -> L27
        L27:
            LogUtil.e("CaeStatusReportManager", "RemoteException !!!");
            goto L18
        L24:
            LogUtil.e("CaeStatusReportManager", "autoRegisterListenerOnRetryBindSuccess, mIStatusReportMgr is null");
            return;
        L66:
            return;
        L64:
            return;
        L8:
            e = move-exception;
            LogUtil.e("CaeStatusReportManager", "Get service failed: " + e);
            goto L10
        L30:
            LogUtil.e("CaeStatusReportManager", "get status report service error!!!");
            CaeStatusReportManager r7 = this.a;
            HashMap r8 = r7.c;
            if (r8 != null) goto L33;
            return;
        L33:
            if (r8.size() <= 0) goto L67;
            Iterator r9 = r7.c.keySet().iterator();
        L36:
            if (r9.hasNext() == false) goto L68;
            Integer r10 = (Integer) r9.next();
            LinkLayerQualityChangedListenerProxy r11 = (LinkLayerQualityChangedListenerProxy) r7.c.get(r10);
            if (r11 == null) goto L36;
            if (r11.getListener() == null) goto L36;
            r11.getListener().onLinkLayerQualityChanged(null);
            r11.getListener().onLinkLayerLevelChanged(null);
            r11.getListener().onAverLinkLayerLevelChanged(null);
            r7.c.remove(r10);
            goto L36
        L68:
            return;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            com_obric_cae_libs_statusreport_CaeStatusReportManager$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public a(CaeStatusReportManager r1) {
            this.a = r1;
            super("CaeStatusReportManager$a");
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_obric_cae_libs_statusreport_CaeStatusReportManager$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
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
        public static void com_obric_cae_libs_statusreport_CaeStatusReportManager$a_com_larus_apm_impl_protector_RunnableLancet_run(a r1) {
            r1.com_obric_cae_libs_statusreport_CaeStatusReportManager$a__run$___twin___();     // Catch: Throwable -> L4
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
        public final /* synthetic */ CaeStatusReportManager a;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeStatusReportManager", "statusReport service is dead!");
            CaeStatusReportManager r0 = this.a;
            r0.a = null;
            r0.retryGetServiceThread();
        }

        public b(CaeStatusReportManager r1) {
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
        com.obric.cae.libs.bluetooth.a.a("CaeStatusReportManager linkToDeath! :", e, "CaeStatusReportManager");
    }

    public String getCaeVersion() {
        ICaeStatusReportManager r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("CaeStatusReportManager", "getCaeVersion, mIStatusReportMgr is null");
        return null;
    L11:
        return r0.getCaeVersion();
    L8:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "getCaeVersion fail, e=" + e);
        return null;
    }

    public LinkLayerQuality getLinkLayerQuality() {
        ICaeStatusReportManager r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("CaeStatusReportManager", "getLinkLayerQuality, mIStatusReportMgr is null");
        return null;
    L11:
        return r0.getLinkLayerQuality(CaelibUtils.getCallingPackageName(this.b));
    L8:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "getLinkLayerQuality fail, e=" + e);
        return null;
    }

    public void retryGetServiceThread() {
        ThreadMethodProxy.start(new a(this));
    }

    public CaeStatusReportManager(Context r6) {
        this.c = new HashMap();
        this.b = r6;
        this.a = ICaeStatusReportManager.Stub.asInterface((IBinder) INVOKESTATIC_com_obric_cae_libs_statusreport_CaeStatusReportManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_status_report"}));     // Catch: Exception -> L5
    L8:
        if (this.a == null) goto L10;
        a();
        return;
    L10:
        retryGetServiceThread();
        return;
    L5:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "Get service failed: " + e);
        goto L8
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_cae_libs_statusreport_CaeStatusReportManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
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

    public static CaeStatusReportManager getInstance(Context r2) {
        if (r2 == null) goto L15;
        monitor-enter(CaeStatusReportManager.class);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (d != null) goto L8;
        d = new CaeStatusReportManager(r2);     // Catch: Throwable -> L11
    L8:
        monitor-exit(CaeStatusReportManager.class);     // Catch: Throwable -> L11
        return d;
    L15:
        throw new IllegalArgumentException("context cannot be null");
    }

    public boolean registerLinkLayerQualityChangedListener(LinkLayerQualityChangedListener r6) {
        if (this.a != null) goto L6;
        LogUtil.e("CaeStatusReportManager", "registerLinkLayerQualityChangedListener, mIStatusReportMgr is null");
        return false;
    L6:
        if (r6 == null) goto L18;
        if (this.c.containsKey(Integer.valueOf(r6.hashCode())) == false) goto L19;
        return false;
    L19:
        LinkLayerQualityChangedListenerProxy r0 = new LinkLayerQualityChangedListenerProxy(this, r6);     // Catch: RemoteException -> L15
        if (this.a.registerLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(this.b), r0) == false) goto L21;
        this.c.put(Integer.valueOf(r6.hashCode()), r0);     // Catch: RemoteException -> L15
        return true;
    L21:
        return true;
    L15:
        LogUtil.e("CaeStatusReportManager", "RemoteException !!!");
        return false;
    L18:
        throw new IllegalArgumentException("callback cannot be null");
    }

    public boolean unregisterLinkLayerQualityChangedListener(LinkLayerQualityChangedListener r5) {
        if (r5 != null) goto L5;
    L17:
        LogUtil.e("CaeStatusReportManager", "unregisterLinkLayerQualityChangedListener, listener:" + r5 + ", mStatusReportManager:" + this.a + ", mLinkLayerListenerMap:" + this.c);
        return false;
    L5:
        if (this.a == null) goto L17;
        if (this.c == null) goto L17;
        int r6 = r5.hashCode();     // Catch: RemoteException -> L14
        if (this.c.containsKey(Integer.valueOf(r6)) == true) goto L12;
        return false;
    L12:
        return this.a.unregisterLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(this.b), (LinkLayerQualityChangedListenerProxy) this.c.remove(Integer.valueOf(r6)));
    L14:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "RemoteException, ", e);
        return false;
    }
}
