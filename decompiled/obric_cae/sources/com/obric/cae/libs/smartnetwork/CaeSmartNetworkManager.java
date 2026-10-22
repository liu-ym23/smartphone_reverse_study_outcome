package com.obric.cae.libs.smartnetwork;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.cae.libs.statusreport.CaeStatusReportManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.wifi.ICaeSmartNetworkManager;
import com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CaeSmartNetworkManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static CaeSmartNetworkManager f5447c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICaeSmartNetworkManager f5448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f5449b;

    public interface CaeWifiLinkThroughputListener {
        void onSecondaryThroughputReported(int r8, int r10);

        void onThroughputReported(int r8, int r10);
    }

    public class CaeWifiLinkThroughputListenerProxy extends ICaeWifiLinkThroughputListener.Stub {
        private final CaeWifiLinkThroughputListener mListener;
        final /* synthetic */ CaeSmartNetworkManager this$0;

        public CaeWifiLinkThroughputListenerProxy(CaeSmartNetworkManager r8, CaeWifiLinkThroughputListener r10) {
            this.this$0 = r8;
            this.mListener = r10;
        }

        public CaeWifiLinkThroughputListener getListener() {
            return this.mListener;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener
        public void onSecondaryThroughputReported(int r8, int r10) {
            CaeWifiLinkThroughputListener r11 = this.mListener;
            if (r11 == null) goto L6;
            r11.onSecondaryThroughputReported(r8, r10);
            return;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener
        public void onThroughputReported(int r8, int r10) {
            CaeWifiLinkThroughputListener r11 = this.mListener;
            if (r11 == null) goto L6;
            r11.onThroughputReported(r8, r10);
            return;
        }
    }

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeSmartNetworkManager f5450a;

        public a(CaeSmartNetworkManager r8) {
            this.f5450a = r8;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int r8 = 0;
        L4:
            if (r8 >= 50) goto L30;
            SystemClock.sleep(100);
            this.f5450a.f5448a = ICaeSmartNetworkManager.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_wifi"}));     // Catch: Exception -> L8
        L10:
            CaeSmartNetworkManager r10 = this.f5450a;
            if (r10.f5448a != null) goto L12;
            r8 = r8 + 1;
            goto L4
        L12:
            r10.a();
            CaeSmartNetworkManager r11 = this.f5450a;
            HashMap r12 = r11.f5449b;
            if (r12 != null) goto L15;
            return;
        L15:
            if (r12.size() <= 0) goto L64;
            Iterator r13 = r11.f5449b.keySet().iterator();
        L18:
            if (r13.hasNext() == false) goto L66;
            CaeWifiLinkThroughputListenerProxy r14 = (CaeWifiLinkThroughputListenerProxy) r11.f5449b.get((Integer) r13.next());
            if (r14 == null) goto L18;
            ICaeSmartNetworkManager r15 = r11.f5448a;
            if (r15 == null) goto L24;
            r15.registerLinkThroughputListener(r14);     // Catch: RemoteException -> L27
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
            CaeSmartNetworkManager r16 = this.f5450a;
            HashMap r17 = r16.f5449b;
            if (r17 != null) goto L33;
            return;
        L33:
            if (r17.size() <= 0) goto L67;
            Iterator r18 = r16.f5449b.keySet().iterator();
        L36:
            if (r18.hasNext() == false) goto L68;
            Integer r19 = (Integer) r18.next();
            CaeWifiLinkThroughputListenerProxy r20 = (CaeWifiLinkThroughputListenerProxy) r16.f5449b.get(r19);
            if (r20 == null) goto L36;
            if (r20.getListener() == null) goto L36;
            r20.getListener().onThroughputReported(0, 0);
            r20.getListener().onSecondaryThroughputReported(0, 0);
            r16.f5449b.remove(r19);
            goto L36
        L68:
            return;
        }
    }

    public class b implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeSmartNetworkManager f5451a;

        public b(CaeSmartNetworkManager r8) {
            this.f5451a = r8;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeSmartNetworkManager", "statusReport service is dead!");
            CaeSmartNetworkManager r8 = this.f5451a;
            r8.f5448a = null;
            r8.retryGetServiceThread();
        }
    }

    public CaeSmartNetworkManager(Context r8) {
        this.f5449b = new HashMap();
        this.f5448a = ICaeSmartNetworkManager.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_wifi"}));     // Catch: Exception -> L5
    L8:
        if (this.f5448a == null) goto L10;
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

    public static CaeSmartNetworkManager getInstance(Context r8) {
        if (r8 == null) goto L15;
        monitor-enter(CaeStatusReportManager.class);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f5447c != null) goto L8;
        f5447c = new CaeSmartNetworkManager(r8);     // Catch: Throwable -> L11
    L8:
        monitor-exit(CaeStatusReportManager.class);     // Catch: Throwable -> L11
        return f5447c;
    L15:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void a() {
        this.f5448a.asBinder().linkToDeath(new b(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("CaeStatusReportManager linkToDeath! :", e, "CaeSmartNetworkManager");
    }

    public int getLinkThroughput() {
        ICaeSmartNetworkManager r8 = this.f5448a;
        if (r8 != null) goto L11;
        LogUtil.e("CaeSmartNetworkManager", "getLinkThroughput, mISmartNetworkMgr is null");
        return 0;
    L11:
        return r8.getLinkThroughput();
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("getLinkThroughput failed: ", e, "CaeSmartNetworkManager");
        return 0;
    }

    public void registerLinkThroughputListener(CaeWifiLinkThroughputListener r8) {
        if (this.f5448a != null) goto L6;
        LogUtil.e("CaeSmartNetworkManager", "registerLinkThroughputListener, mISmartNetworkMgr is null");
        return;
    L6:
        CaeWifiLinkThroughputListenerProxy r10 = new CaeWifiLinkThroughputListenerProxy(this, r8);
        this.f5449b.put(Integer.valueOf(r10.hashCode()), r10);
        this.f5448a.registerLinkThroughputListener(r10);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("registerLinkThroughputListener failed: ", e, "CaeSmartNetworkManager");
    }

    public void retryGetServiceThread() {
        new a(this).start();
    }

    public void unregisterLinkThroughputListener(CaeWifiLinkThroughputListener r8) {
        if (this.f5448a != null) goto L7;
        String r10 = "unregisterLinkThroughputListener, mISmartNetworkMgr is null";
    L5:
        LogUtil.e("CaeSmartNetworkManager", r10);
        return;
    L7:
        CaeWifiLinkThroughputListenerProxy r11 = (CaeWifiLinkThroughputListenerProxy) this.f5449b.get(Integer.valueOf(r8.hashCode()));
        if (r11 != null) goto L15;
        r10 = "unregisterLinkThroughputListener failed: proxy is null";
        goto L5
    L15:
        this.f5448a.unregisterLinkThroughputListener(r11);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("unregisterLinkThroughputListener failed: ", e, "CaeSmartNetworkManager");
    }
}
