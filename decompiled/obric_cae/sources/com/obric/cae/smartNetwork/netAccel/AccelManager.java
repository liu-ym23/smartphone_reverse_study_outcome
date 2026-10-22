package com.obric.cae.smartNetwork.netAccel;

import android.content.Context;
import android.os.ServiceManager;
import android.text.TextUtils;
import com.obric.cae.libs.accel.ICaeAccel;
import com.obric.cae.smartNetwork.SmartNetworkService;
import com.obric.cae.smartNetwork.netAccel.cellularAccel.AppStoreCellularAccel;
import com.obric.cae.smartNetwork.netAccel.cellularAccel.CellularConnector;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AccelManager {
    private static final String SERVICE_NAME = "cae_accel";
    private static final String TAG = null;
    private static volatile AccelManager sInstance;
    private final AccelConfigChangeCallback mAccelConfigChangeCallback;
    private final AccelConfigManager mAccelConfigManager;
    private final AccelControl mAccelControl;
    private final AccelService mAccelService;
    private final AppStoreCellularAccel mAppStoreCellularAccel;
    private final AppTrafficCollect mAppTrafficCollect;
    private final CellularConnector mCellularConnector;
    private final Context mContext;
    private final DualWlanConnector mDualWlanConnector;
    private final MultiNetworkManager mMultiNetworkManager;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.netAccel.AccelManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class AccelConfigChangeCallback implements AccelConfigManager.ConfigChangeCallback {
        final /* synthetic */ AccelManager this$0;

        private AccelConfigChangeCallback(AccelManager r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelConfigManager.ConfigChangeCallback
        public void onAllPackagesRulesChanged() {
            AccelManager.access$200(this.this$0).updateAllPackageEnable();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelConfigManager.ConfigChangeCallback
        public void onAppTrafficCollectEnableChanged(boolean r8) {
            AppTrafficCollect r10 = AccelManager.access$500(this.this$0);
            if (r8 == false) goto L5;
            r10.start();
            return;
        L5:
            r10.stop();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelConfigManager.ConfigChangeCallback
        public void onAppTrafficCollectPackagesChanged(List<String> r8) {
            AccelManager.access$500(this.this$0).setAppWhitelist(r8);
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelConfigManager.ConfigChangeCallback
        public void onDualWlanAccelEnableChanged(boolean r8) {
            AccelManager.access$400(this.this$0).sendCmdEnable(r8);
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelConfigManager.ConfigChangeCallback
        public void onGlobalAccelEnableChanged(boolean r8) {
            MultiNetworkManager r10 = AccelManager.access$200(this.this$0);
            if (r8 != true) goto L5;
            r10.start();
            return;
        L5:
            r10.stop();
        }

        public /* synthetic */ AccelConfigChangeCallback(AccelManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class AccelService extends ICaeAccel.Stub {
        final /* synthetic */ AccelManager this$0;

        private AccelService(AccelManager r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageAccelEnable(String r8, boolean r10) {
            if (TextUtils.isEmpty(r8) == false) goto L6;
            return -1;
        L6:
            AccelManager.access$200(this.this$0).setPackageEnable(r8, r10);
            return 0;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageAutoDualWlanMode(String r8, int r10) {
            if (TextUtils.isEmpty(r8) == false) goto L6;
            return -1;
        L6:
            AccelManager.access$300(this.this$0).setPackageAutoDualWlanMode(r8, r10);
            return 0;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageFlowSched(String r8, boolean r10) {
            if (TextUtils.isEmpty(r8) == false) goto L6;
            return -1;
        L6:
            AccelManager.access$200(this.this$0).setPackageFlowSched(r8, r10);
            return 0;
        }

        public /* synthetic */ AccelService(AccelManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    static {
        TAG = "MultiNetwork-AccelManager";
    }

    private AccelManager(Context r8, SmartNetworkService r10) {
        AnonymousClass1 r11 = null;
        AccelConfigChangeCallback r12 = new AccelConfigChangeCallback(this, r11);
        this.mAccelConfigChangeCallback = r12;
        this.mContext = r8;
        AccelControl r13 = AccelControl.makeAccelControl(r8);
        this.mAccelControl = r13;
        AccelService r14 = new AccelService(this, r11);
        this.mAccelService = r14;
        AccelConfigManager r15 = AccelConfigManager.getInstance(r8);
        this.mAccelConfigManager = r15;
        r15.registerConfigChangeCallback(r12);
        CellularConnector r16 = CellularConnector.makeCellularConnector(r8);
        this.mCellularConnector = r16;
        this.mAppStoreCellularAccel = new AppStoreCellularAccel(r8, r16, r13);
        MultiNetworkManager r17 = new MultiNetworkManager(r8, r13, r16);
        this.mMultiNetworkManager = r17;
        if (r15.isGlobalAccelEnabled() == false) goto L5;
        r17.start();
    L5:
        DualWlanConnector r18 = DualWlanConnector.makeDualWlanConnector(r8);
        this.mDualWlanConnector = r18;
        if (r15.isAutoDualWlanEnabled() == false) goto L8;
        r18.sendCmdEnable(true);
    L8:
        AppTrafficCollect r19 = new AppTrafficCollect(r8, r10);
        this.mAppTrafficCollect = r19;
        r19.setAppWhitelist(r15.getAppTrafficCollectPackages());
        if (r15.isAppTrafficCollectEnabled() == false) goto L11;
        r19.start();
    L11:
        ServiceManager.addService(SERVICE_NAME, r14);
    }

    public static /* synthetic */ MultiNetworkManager access$200(AccelManager r8) {
        return r8.mMultiNetworkManager;
    }

    public static /* synthetic */ AccelConfigManager access$300(AccelManager r8) {
        return r8.mAccelConfigManager;
    }

    public static /* synthetic */ DualWlanConnector access$400(AccelManager r8) {
        return r8.mDualWlanConnector;
    }

    public static /* synthetic */ AppTrafficCollect access$500(AccelManager r8) {
        return r8.mAppTrafficCollect;
    }

    public static AccelManager getInstance(Context r8, SmartNetworkService r10) {
        if (sInstance != null) goto L15;
        monitor-enter(AccelManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AccelManager(r8, r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(AccelManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }
}
