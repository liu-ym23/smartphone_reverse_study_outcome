package com.obric.cae.smartNetwork;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.INetworkManagementService;
import android.os.ServiceManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.utils.CaeUtil;

/* JADX INFO: loaded from: classes2.dex */
public class LowlatencyInterface {
    private static final String LOW_LATENCY_MODE_TAG = "cae_low_latency";
    public static final int PREEMPTION_PRIORITY_AC_BE = 2;
    public static final int PREEMPTION_PRIORITY_AC_BG = 1;
    public static final int PREEMPTION_PRIORITY_AC_VI = 3;
    public static final int PREEMPTION_PRIORITY_AC_VO = 4;
    public static final int PREEMPTION_PRIORITY_DEFAULT = 0;
    private static final String TAG = "LowlatencyInterface";
    private static LowlatencyInterface mLowlatencyInterface;
    private Context mContext;
    private INetworkManagementService mNetd;
    private WifiManager.WifiLock mWifiLock;
    private WifiManager mWifiManager;

    public LowlatencyInterface(Context r8) {
        this.mContext = r8;
        WifiManager r10 = (WifiManager) r8.getSystemService("wifi");
        this.mWifiManager = r10;
        this.mWifiLock = r10.createWifiLock(4, LOW_LATENCY_MODE_TAG);
        setupNetdInterface();
    }

    public static LowlatencyInterface getInstance(Context r8) {
        if (mLowlatencyInterface != null) goto L6;
        mLowlatencyInterface = new LowlatencyInterface(r8);
    L6:
        return mLowlatencyInterface;
    }

    private void setupNetdInterface() {
        if (this.mNetd == null) goto L5;
        return;
    L5:
        this.mNetd = INetworkManagementService.Stub.asInterface(ServiceManager.getService("network_management"));
    }

    public void clearAccPriority() {
        setupNetdInterface();
        boolean r8 = CaeUtil.isMethodAvailable(this.mNetd, "clearLinkLayerPreemptionPriority", new Class[]{String.class});
        INetworkManagementService r10 = this.mNetd;
        if (r8 == false) goto L5;
        CaeUtil.invokeMethod(r10, "clearLinkLayerPreemptionPriority", new Class[]{String.class}, new Object[]{"wlan0"});
        return;
    L5:
        CaeUtil.invokeMethod(r10, "clearDscpVoiceMarked", null, null);
    }

    public int getAccPriorityValue(int r8) {
        setupNetdInterface();
        INetworkManagementService r10 = this.mNetd;
        Class r11 = Integer.TYPE;
        boolean r12 = CaeUtil.isMethodAvailable(r10, "getLinkLayerPreemptionPriority", new Class[]{String.class, r11});
        INetworkManagementService r13 = this.mNetd;
        if (r12 == false) goto L7;
        Object r14 = CaeUtil.invokeMethod(r13, "getLinkLayerPreemptionPriority", new Class[]{String.class, r11}, new Object[]{"wlan0", Integer.valueOf(r8)});
    L6:
        return ((Integer) r14).intValue();
    L7:
        r14 = CaeUtil.invokeMethod(r13, "isDscpVoiceMarked", new Class[]{r11}, new Object[]{Integer.valueOf(r8)});
        goto L6
    }

    public int getAccPriorityValueForProtocol(int r8, String r10) {
        setupNetdInterface();
        INetworkManagementService r11 = this.mNetd;
        Class r12 = Integer.TYPE;
        boolean r13 = CaeUtil.isMethodAvailable(r11, "getLinkLayerPreemptionPriorityForProtocol", new Class[]{String.class, r12, String.class});
        INetworkManagementService r14 = this.mNetd;
        if (r13 == false) goto L7;
        Object r15 = CaeUtil.invokeMethod(r14, "getLinkLayerPreemptionPriorityForProtocol", new Class[]{String.class, r12, String.class}, new Object[]{"wlan0", Integer.valueOf(r8), r10});
    L6:
        return ((Integer) r15).intValue();
    L7:
        r15 = CaeUtil.invokeMethod(r14, "isDscpVoiceMarked", new Class[]{r12}, new Object[]{Integer.valueOf(r8)});
        goto L6
    }

    public boolean getAlwaysActiveMode() {
        return this.mWifiLock.isHeld();
    }

    public void removeAccPriority(int r8) {
        setupNetdInterface();
        INetworkManagementService r10 = this.mNetd;
        Class r11 = Integer.TYPE;
        if (CaeUtil.isMethodAvailable(r10, "removeLinkLayerPreemptionPriority", new Class[]{String.class, r11}) == false) goto L5;
        defpackage.a.i("removeLinkLayerPreemptionPriority, netif: wlan0, uid: ", r8, TAG);
        CaeUtil.invokeMethod(this.mNetd, "removeLinkLayerPreemptionPriority", new Class[]{String.class, r11}, new Object[]{"wlan0", Integer.valueOf(r8)});
        return;
    L5:
        CaeLog.e(TAG, "removeLinkLayerPreemptionPriority not available");
    }

    public void setAccPriorityEnabled(int r8, int r10) {
        setupNetdInterface();
        INetworkManagementService r11 = this.mNetd;
        Class r12 = Integer.TYPE;
        if (CaeUtil.isMethodAvailable(r11, "setLinkLayerPreemptionPriority", new Class[]{String.class, r12, r12}) == false) goto L6;
        CaeLog.i(TAG, "setLinkLayerPreemptionPriority, netif: wlan0");
        CaeUtil.invokeMethod(this.mNetd, "setLinkLayerPreemptionPriority", new Class[]{String.class, r12, r12}, new Object[]{"wlan0", Integer.valueOf(r8), Integer.valueOf(r10)});
        return;
    L6:
        if (r10 != 4) goto L10;
        CaeUtil.invokeMethod(this.mNetd, "setDscpVoiceMarked", new Class[]{r12, Boolean.TYPE}, new Object[]{Integer.valueOf(r8), Boolean.TRUE});
        return;
    }

    public void setAccPriorityEnabledForProtocol(int r8, int r10, String r11) {
        setupNetdInterface();
        INetworkManagementService r12 = this.mNetd;
        Class r13 = Integer.TYPE;
        if (CaeUtil.isMethodAvailable(r12, "setLinkLayerPreemptionPriorityForProtocol", new Class[]{String.class, r13, r13, String.class}) == false) goto L6;
        CaeUtil.invokeMethod(this.mNetd, "setLinkLayerPreemptionPriorityForProtocol", new Class[]{String.class, r13, r13, String.class}, new Object[]{"wlan0", Integer.valueOf(r8), Integer.valueOf(r10), r11});
        return;
    L6:
        if (r10 != 4) goto L10;
        CaeUtil.invokeMethod(this.mNetd, "setDscpVoiceMarked", new Class[]{r13, Boolean.TYPE}, new Object[]{Integer.valueOf(r8), Boolean.TRUE});
        return;
    }

    public void setAlwaysActiveMode(boolean r8) {
        if (r8 == true) goto L4;
    L6:
        if (r8 == false) goto L8;
        return;
    L8:
        if (this.mWifiLock.isHeld() == false) goto L13;
        this.mWifiLock.release();
        return;
    L13:
        return;
    L4:
        if (this.mWifiLock.isHeld() == true) goto L6;
        this.mWifiLock.acquire();
    }

    public void setCellularAccPriorityEnabled(int r8, int r10) {
        setupNetdInterface();
        INetworkManagementService r11 = this.mNetd;
        Class r12 = Integer.TYPE;
        if (CaeUtil.isMethodAvailable(r11, "setLinkLayerPreemptionPriority", new Class[]{String.class, r12, r12}) == false) goto L10;
        String r13 = CaeUtil.getCellularIfName();
        if (r13 != null) goto L8;
        CaeLog.e(TAG, "cellularIfName is null");
        return;
    L8:
        CaeLog.i(TAG, "setLinkLayerPreemptionPriority, cellularIfName: ".concat(r13));
        CaeUtil.invokeMethod(this.mNetd, "setLinkLayerPreemptionPriority", new Class[]{String.class, r12, r12}, new Object[]{r13, Integer.valueOf(r8), Integer.valueOf(r10)});
        return;
    L10:
        if (r10 != 4) goto L14;
        CaeUtil.invokeMethod(this.mNetd, "setDscpVoiceMarked", new Class[]{r12, Boolean.TYPE}, new Object[]{Integer.valueOf(r8), Boolean.TRUE});
        return;
    }
}
