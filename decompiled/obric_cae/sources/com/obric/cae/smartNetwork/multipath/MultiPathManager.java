package com.obric.cae.smartNetwork.multipath;

import android.content.Context;
import android.os.ServiceManager;
import com.obric.cae.cldReport.CldInternalReport;
import com.obric.cae.libs.multipath.ICaeMultipathCallback;
import com.obric.cae.libs.multipath.ICaeMultipathManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.NetworkAccelerate.VipAppManager;
import com.obric.cae.smartNetwork.netOpt.NetworkTruthManager;
import com.obric.cae.smartNetwork.qoe.NetworkQoEMonitor;

/* JADX INFO: loaded from: classes2.dex */
public class MultiPathManager {
    private static final String SERVICE_NAME = "cae_multipath";
    private static final String TAG = "MultiPathManager";
    private static boolean sInited = false;
    private static MultiPathManager sInstance;
    private CaeMultipathService mCaeMultipathService;
    private Context mContext;
    private LinkLayerMonitor mLinkLayerMonitor;
    private MPAAdapter mMPAAdapter;
    private MPAConnQualityMonitor mMPAConnQualityMonitor;
    private NetworkPolicyCenter mNetworkPolicyCenter;
    private NetworkQoEMonitor mNetworkQoEMonitor;
    private NetworkTruthManager mNetworkTruthManager;

    public class CaeMultipathService extends ICaeMultipathManager.Stub {
        private boolean mRunning;
        final /* synthetic */ MultiPathManager this$0;

        public CaeMultipathService(MultiPathManager r8) {
            this.this$0 = r8;
            this.mRunning = false;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public String getLatestNetworkTruth() {
            return MultiPathManager.access$500(this.this$0).getNetworkTruth();
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportAssistantFailure() {
            CldInternalReport.reportErrorEvent(2, 2, 1, 0, null);
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportAssistantOperateApps(int[] r8) {
            if (r8 != null) goto L4;
        L12:
            CaeLog.w(MultiPathManager.access$000(), "reportAssistantOperateApps: apps array is empty or null");
            return;
        L4:
            if (r8.length == 0) goto L12;
            CaeLog.i(MultiPathManager.access$000(), "reportAssistantOperateApps: received " + r8.length + " apps");
            VipAppManager r10 = VipAppManager.getInstance(MultiPathManager.access$600(this.this$0));
            if (r10 == null) goto L11;
            int r11 = r8.length;
            int r12 = 0;
        L9:
            if (r12 >= r11) goto L15;
            int r13 = r8[r12];
            r10.addVipUid(r13);
            CaeLog.i(MultiPathManager.access$000(), "reportAssistantOperateApps: add uid " + r13 + " to VIP list");
            r12 = r12 + 1;
            goto L9
        L15:
            return;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportMPAConnectionQuality(String r8, int r10, int r11, int r12, int r13, int r14) {
            CaeLog.d(MultiPathManager.access$000(), "reportMPAConnectionQuality");
            MPAConnQuality r15 = new MPAConnQuality();
            r15.setAccelAddr(r8);
            r15.setConnType(r10);
            r15.setClientRttTime(r11);
            r15.setClientRxLoss(r12);
            r15.setServerRttTime(r13);
            r15.setServerRxLoss(r14);
            MultiPathManager.access$300(this.this$0).reportMPAConnectionQuality(r15);
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportPathCtlModeChanged(String r8, int r10) {
            CaeLog.d(MultiPathManager.access$000(), "sdk reportPathCtlModeChanged, acceleratedAddress: " + r8 + ", pathCtlMode: " + r10);
            MultiPathManager.access$300(this.this$0).reportPathCtlModeChanged(r8, r10);
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void setICaeMultipathCallback(ICaeMultipathCallback r8) {
            CaeLog.i(MultiPathManager.access$000(), "sdk set callback");
            MultiPathManager.access$400(this.this$0).setMultipathCallback(r8);
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public synchronized void startMultipath() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mRunning == true) goto L6;
            CaeLog.i(MultiPathManager.access$000(), "startMultipath");     // Catch: Throwable -> L8
            MultiPathManager.access$100(this.this$0).start();     // Catch: Throwable -> L8
            MultiPathManager.access$200(this.this$0).start();     // Catch: Throwable -> L8
            this.mRunning = true;     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public synchronized void stopMultipath() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mRunning != true) goto L6;
            CaeLog.i(MultiPathManager.access$000(), "stopMultipath");     // Catch: Throwable -> L8
            MultiPathManager.access$200(this.this$0).stop();     // Catch: Throwable -> L8
            MultiPathManager.access$100(this.this$0).stop();     // Catch: Throwable -> L8
            this.mRunning = false;     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void unsetICaeMultipathCallback() {
            CaeLog.i(MultiPathManager.access$000(), "sdk unset callback");
            MultiPathManager.access$400(this.this$0).unsetMultipathCallback();
        }
    }

    private MultiPathManager() {
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ NetworkPolicyCenter access$100(MultiPathManager r8) {
        return r8.mNetworkPolicyCenter;
    }

    public static /* synthetic */ LinkLayerMonitor access$200(MultiPathManager r8) {
        return r8.mLinkLayerMonitor;
    }

    public static /* synthetic */ MPAConnQualityMonitor access$300(MultiPathManager r8) {
        return r8.mMPAConnQualityMonitor;
    }

    public static /* synthetic */ MPAAdapter access$400(MultiPathManager r8) {
        return r8.mMPAAdapter;
    }

    public static /* synthetic */ NetworkTruthManager access$500(MultiPathManager r8) {
        return r8.mNetworkTruthManager;
    }

    public static /* synthetic */ Context access$600(MultiPathManager r8) {
        return r8.mContext;
    }

    public static synchronized MultiPathManager getInstance() {
        monitor-enter(MultiPathManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new MultiPathManager();     // Catch: Throwable -> L10
    L7:
        MultiPathManager r8 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(MultiPathManager.class);
        return r8;
    }

    public synchronized void init(Context r8, NetworkQoEMonitor r10) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (sInited == false) goto L8;
        CaeLog.e(TAG, "MultiPathManager has been inited");     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L8:
        if (r10 != null) goto L13;
        CaeLog.e(TAG, "networkQoEMonitor is null");     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L13:
        sInited = true;     // Catch: Throwable -> L16
        this.mContext = r8;     // Catch: Throwable -> L16
        this.mMPAAdapter = new MPAAdapter();     // Catch: Throwable -> L16
        this.mMPAConnQualityMonitor = new MPAConnQualityMonitor();     // Catch: Throwable -> L16
        this.mNetworkQoEMonitor = r10;     // Catch: Throwable -> L16
        this.mCaeMultipathService = new CaeMultipathService(this);     // Catch: Throwable -> L16
        LinkLayerMonitor r11 = new LinkLayerMonitor(this.mContext);     // Catch: Throwable -> L16
        this.mLinkLayerMonitor = r11;     // Catch: Throwable -> L16
        this.mNetworkPolicyCenter = new NetworkPolicyCenter(this.mContext, r11, this.mMPAConnQualityMonitor, this.mNetworkQoEMonitor);     // Catch: Throwable -> L16
        NetworkTruthManager r12 = NetworkTruthManager.getInstance(this.mContext, this.mNetworkQoEMonitor);     // Catch: Throwable -> L16
        this.mNetworkTruthManager = r12;     // Catch: Throwable -> L16
        r12.start();     // Catch: Throwable -> L16
        ServiceManager.addService(SERVICE_NAME, this.mCaeMultipathService);     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public boolean isCellularNetworkAvailable() {
        return this.mLinkLayerMonitor.isCellAvailable();
    }

    public boolean isWiFiNetworkAvailable() {
        return this.mLinkLayerMonitor.isWifiAvailable();
    }

    public boolean setBothWifiAndCellular() {
        return this.mMPAAdapter.setBothWifiAndCellular(null);
    }

    public boolean setOnlyCellular() {
        return this.mMPAAdapter.setOnlyCellular(null);
    }

    public boolean setOnlyWifi() {
        return this.mMPAAdapter.setOnlyWifi(null);
    }
}
