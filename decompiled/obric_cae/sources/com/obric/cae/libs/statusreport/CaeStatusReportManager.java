package com.obric.cae.libs.statusreport;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.libs.utils.LogUtil;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CaeStatusReportManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static CaeStatusReportManager f5503d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICaeStatusReportManager f5504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f5505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f5506c;

    public interface LinkLayerQualityChangedListener {
        void onAverLinkLayerLevelChanged(LinkLayerQuality r8);

        void onLinkLayerLevelChanged(LinkLayerQuality r8);

        void onLinkLayerQualityChanged(LinkLayerQuality r8);
    }

    public class LinkLayerQualityChangedListenerProxy extends ILinkLayerQualityListener.Stub {
        private final LinkLayerQualityChangedListener mListener;
        final /* synthetic */ CaeStatusReportManager this$0;

        public LinkLayerQualityChangedListenerProxy(CaeStatusReportManager r8, LinkLayerQualityChangedListener r10) {
            this.this$0 = r8;
            this.mListener = r10;
        }

        public LinkLayerQualityChangedListener getListener() {
            return this.mListener;
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onAverLinkLayerLevelChanged(LinkLayerQuality r8) {
            this.mListener.onAverLinkLayerLevelChanged(r8);
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerLevelChanged(LinkLayerQuality r8) {
            this.mListener.onLinkLayerLevelChanged(r8);
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerQualityChanged(LinkLayerQuality r8) {
            this.mListener.onLinkLayerQualityChanged(r8);
        }
    }

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeStatusReportManager f5507a;

        public a(CaeStatusReportManager r8) {
            this.f5507a = r8;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int r8 = 0;
        L4:
            if (r8 >= 50) goto L30;
            SystemClock.sleep(100);
            this.f5507a.f5504a = ICaeStatusReportManager.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_status_report"}));     // Catch: Exception -> L8
        L10:
            CaeStatusReportManager r10 = this.f5507a;
            if (r10.f5504a != null) goto L12;
            r8 = r8 + 1;
            goto L4
        L12:
            r10.a();
            CaeStatusReportManager r11 = this.f5507a;
            HashMap r12 = r11.f5506c;
            if (r12 != null) goto L15;
            return;
        L15:
            if (r12.size() <= 0) goto L64;
            Iterator r13 = r11.f5506c.keySet().iterator();
        L18:
            if (r13.hasNext() == false) goto L66;
            LinkLayerQualityChangedListenerProxy r14 = (LinkLayerQualityChangedListenerProxy) r11.f5506c.get((Integer) r13.next());
            if (r14 == null) goto L18;
            ICaeStatusReportManager r15 = r11.f5504a;
            if (r15 == null) goto L24;
            r15.registerLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(r11.f5505b), r14);     // Catch: RemoteException -> L27
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
            CaeStatusReportManager r16 = this.f5507a;
            HashMap r17 = r16.f5506c;
            if (r17 != null) goto L33;
            return;
        L33:
            if (r17.size() <= 0) goto L67;
            Iterator r18 = r16.f5506c.keySet().iterator();
        L36:
            if (r18.hasNext() == false) goto L68;
            Integer r19 = (Integer) r18.next();
            LinkLayerQualityChangedListenerProxy r20 = (LinkLayerQualityChangedListenerProxy) r16.f5506c.get(r19);
            if (r20 == null) goto L36;
            if (r20.getListener() == null) goto L36;
            r20.getListener().onLinkLayerQualityChanged(null);
            r20.getListener().onLinkLayerLevelChanged(null);
            r20.getListener().onAverLinkLayerLevelChanged(null);
            r16.f5506c.remove(r19);
            goto L36
        L68:
            return;
        }
    }

    public class b implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeStatusReportManager f5508a;

        public b(CaeStatusReportManager r8) {
            this.f5508a = r8;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeStatusReportManager", "statusReport service is dead!");
            CaeStatusReportManager r8 = this.f5508a;
            r8.f5504a = null;
            r8.retryGetServiceThread();
        }
    }

    public CaeStatusReportManager(Context r8) {
        this.f5506c = new HashMap();
        this.f5505b = r8;
        this.f5504a = ICaeStatusReportManager.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_status_report"}));     // Catch: Exception -> L5
    L8:
        if (this.f5504a == null) goto L10;
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

    public static CaeStatusReportManager getInstance(Context r8) {
        if (r8 == null) goto L15;
        monitor-enter(CaeStatusReportManager.class);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f5503d != null) goto L8;
        f5503d = new CaeStatusReportManager(r8);     // Catch: Throwable -> L11
    L8:
        monitor-exit(CaeStatusReportManager.class);     // Catch: Throwable -> L11
        return f5503d;
    L15:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void a() {
        this.f5504a.asBinder().linkToDeath(new b(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("CaeStatusReportManager linkToDeath! :", e, "CaeStatusReportManager");
    }

    public String getCaeVersion() {
        ICaeStatusReportManager r8 = this.f5504a;
        if (r8 != null) goto L11;
        String r10 = "getCaeVersion, mIStatusReportMgr is null";
    L5:
        LogUtil.e("CaeStatusReportManager", r10);
        return null;
    L11:
        return r8.getCaeVersion();
    L9:
        e = move-exception;
        r10 = "getCaeVersion fail, e=" + e;
        goto L5
    }

    public LinkLayerQuality getLinkLayerQuality() {
        ICaeStatusReportManager r8 = this.f5504a;
        if (r8 != null) goto L11;
        String r10 = "getLinkLayerQuality, mIStatusReportMgr is null";
    L5:
        LogUtil.e("CaeStatusReportManager", r10);
        return null;
    L11:
        return r8.getLinkLayerQuality(CaelibUtils.getCallingPackageName(this.f5505b));
    L9:
        e = move-exception;
        r10 = "getLinkLayerQuality fail, e=" + e;
        goto L5
    }

    public boolean registerLinkLayerQualityChangedListener(LinkLayerQualityChangedListener r8) {
        if (this.f5504a != null) goto L7;
        String r10 = "registerLinkLayerQualityChangedListener, mIStatusReportMgr is null";
    L5:
        LogUtil.e("CaeStatusReportManager", r10);
        return false;
    L7:
        if (r8 == null) goto L18;
        if (this.f5506c.containsKey(Integer.valueOf(r8.hashCode())) == false) goto L19;
        return false;
    L19:
        LinkLayerQualityChangedListenerProxy r11 = new LinkLayerQualityChangedListenerProxy(this, r8);     // Catch: RemoteException -> L16
        if (this.f5504a.registerLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(this.f5505b), r11) == false) goto L21;
        this.f5506c.put(Integer.valueOf(r8.hashCode()), r11);     // Catch: RemoteException -> L16
        return true;
    L21:
        return true;
    L16:
        r10 = "RemoteException !!!";
        goto L5
    L18:
        throw new IllegalArgumentException("callback cannot be null");
    }

    public void retryGetServiceThread() {
        new a(this).start();
    }

    public boolean unregisterLinkLayerQualityChangedListener(LinkLayerQualityChangedListener r8) {
        if (r8 != null) goto L5;
    L17:
        LogUtil.e("CaeStatusReportManager", "unregisterLinkLayerQualityChangedListener, listener:" + r8 + ", mStatusReportManager:" + this.f5504a + ", mLinkLayerListenerMap:" + this.f5506c);
        return false;
    L5:
        if (this.f5504a == null) goto L17;
        if (this.f5506c == null) goto L17;
        int r10 = r8.hashCode();     // Catch: RemoteException -> L14
        if (this.f5506c.containsKey(Integer.valueOf(r10)) == true) goto L12;
        return false;
    L12:
        return this.f5504a.unregisterLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(this.f5505b), (LinkLayerQualityChangedListenerProxy) this.f5506c.remove(Integer.valueOf(r10)));
    L14:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "RemoteException, ", e);
        return false;
    }
}
