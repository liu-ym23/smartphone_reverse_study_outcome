package com.obric.cae.smartNfc;

import android.content.Context;
import androidx.core.app.b;
import com.obric.cae.smartNfc.cloud.NfcCloudSubscriber;
import com.obric.cae.smartNfc.cloud.NfcCloudSyncer;

/* JADX INFO: loaded from: classes2.dex */
public class SmartNfcManager {
    private static SmartNfcManager sInstance;
    private CaeNfcAdapterService mAdapterService;
    private NfcCloudSubscriber mCloudConfigSubscriber;
    private NfcCloudSyncer mCloudConfigSyncer;
    private final Context mContext;
    private CaeNfcEventManagerService mEventManagerService;
    private boolean mInited;
    private CaeNfcOmapiExecutorService mOmapiExecutorService;
    private ReverseChargingNfcController mReverseChargingNfcController;
    private RouteSwitchManager mRouteSwitchManager;

    private SmartNfcManager(Context r8) {
        this.mContext = r8.getApplicationContext();
    }

    public static /* synthetic */ void a(SmartNfcManager r8, int r10) {
        r8.dispatchNfcStateChanged(r10);
    }

    private void dispatchNfcStateChanged(int r8) {
        RouteSwitchManager r10 = this.mRouteSwitchManager;
        if (r10 == null) goto L5;
        r10.onNfcStateChanged(r8);
    L5:
        ReverseChargingNfcController r11 = this.mReverseChargingNfcController;
        if (r11 == null) goto L9;
        r11.onNfcStateChanged(r8);
        return;
    }

    public static SmartNfcManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(SmartNfcManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SmartNfcManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SmartNfcManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public synchronized void cleanup() {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (this.mInited == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        CaeNfcEventManagerService r8 = this.mEventManagerService;     // Catch: Throwable -> L28
        if (r8 == null) goto L10;
        r8.setNfcStateListener(null);     // Catch: Throwable -> L28
    L10:
        NfcCloudSubscriber r10 = this.mCloudConfigSubscriber;     // Catch: Throwable -> L28
        if (r10 == null) goto L13;
        r10.close();     // Catch: Throwable -> L28
        this.mCloudConfigSubscriber = null;     // Catch: Throwable -> L28
    L13:
        NfcCloudSyncer r11 = this.mCloudConfigSyncer;     // Catch: Throwable -> L28
        if (r11 == null) goto L16;
        r11.cleanup();     // Catch: Throwable -> L28
        this.mCloudConfigSyncer = null;     // Catch: Throwable -> L28
    L16:
        RouteSwitchManager r12 = this.mRouteSwitchManager;     // Catch: Throwable -> L28
        if (r12 == null) goto L19;
        r12.cleanup();     // Catch: Throwable -> L28
        this.mRouteSwitchManager = null;     // Catch: Throwable -> L28
    L19:
        ReverseChargingNfcController r13 = this.mReverseChargingNfcController;     // Catch: Throwable -> L28
        if (r13 == null) goto L22;
        r13.cleanup();     // Catch: Throwable -> L28
        this.mReverseChargingNfcController = null;     // Catch: Throwable -> L28
    L22:
        CaeNfcEventManagerService r14 = this.mEventManagerService;     // Catch: Throwable -> L28
        if (r14 == null) goto L25;
        r14.cleanup();     // Catch: Throwable -> L28
        this.mEventManagerService = null;     // Catch: Throwable -> L28
    L25:
        this.mOmapiExecutorService = null;     // Catch: Throwable -> L28
        this.mAdapterService = null;     // Catch: Throwable -> L28
        this.mInited = false;     // Catch: Throwable -> L28
        monitor-exit(this);
    }

    public CaeNfcAdapterService getAdapterService() {
        return this.mAdapterService;
    }

    public synchronized void init() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mInited == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        CaeNfcEventManagerService r8 = new CaeNfcEventManagerService(this.mContext);     // Catch: Throwable -> L10
        this.mEventManagerService = r8;     // Catch: Throwable -> L10
        r8.init();     // Catch: Throwable -> L10
        this.mOmapiExecutorService = new CaeNfcOmapiExecutorService(this.mContext);     // Catch: Throwable -> L10
        RouteSwitchManager r10 = new RouteSwitchManager(this.mContext, this.mEventManagerService.getPaymentChangeEvent());     // Catch: Throwable -> L10
        this.mRouteSwitchManager = r10;     // Catch: Throwable -> L10
        r10.init();     // Catch: Throwable -> L10
        ReverseChargingNfcController r11 = new ReverseChargingNfcController(this.mContext);     // Catch: Throwable -> L10
        this.mReverseChargingNfcController = r11;     // Catch: Throwable -> L10
        r11.init();     // Catch: Throwable -> L10
        this.mEventManagerService.setNfcStateListener(new b(this));     // Catch: Throwable -> L10
        this.mAdapterService = new CaeNfcAdapterService(this.mContext, this.mOmapiExecutorService, this.mEventManagerService, this.mRouteSwitchManager);     // Catch: Throwable -> L10
        NfcCloudSyncer r12 = new NfcCloudSyncer(this.mContext, this.mEventManagerService);     // Catch: Throwable -> L10
        this.mCloudConfigSyncer = r12;     // Catch: Throwable -> L10
        this.mCloudConfigSubscriber = new NfcCloudSubscriber(this.mContext, r12);     // Catch: Throwable -> L10
        this.mInited = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }
}
