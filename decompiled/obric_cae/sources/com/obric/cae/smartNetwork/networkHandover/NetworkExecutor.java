package com.obric.cae.smartNetwork.networkHandover;

import android.content.Context;
import android.os.RemoteException;
import com.obric.cae.libs.network.ICaeNetworkHandoverListener;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.mpflow.MpflowInterface;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkExecutor {
    private static final int NETWORK_VALIDATION_RESULT_INVALID = 0;
    private static final int NETWORK_VALIDATION_RESULT_VALID = 1;
    private static final byte SMART_NETWORK_FLOW_NET_TYPE_CELLULAR_1 = 0;
    private static final byte SMART_NETWORK_FLOW_NET_TYPE_CELLULAR_2 = 1;
    private static final String TAG = "NetworkExecutor";
    private final Context mContext;
    private ICaeNetworkHandoverListener mListener;
    private final MpflowInterface mMpflowInterface;
    private final HashMap<Integer, Integer> mNetworks;

    public NetworkExecutor(Context r8) {
        this.mNetworks = new HashMap();
        this.mContext = r8;
        this.mMpflowInterface = new MpflowInterface();
    }

    private void tryCellToWifi(int r8, int r10) {
        CaeLog.i(TAG, "tryCellToWifi: cellNetId: " + r8 + " wifiNetId: " + r10);
        ICaeNetworkHandoverListener r11 = this.mListener;     // Catch: RemoteException -> L7
        if (r11 == null) goto L12;
        r11.notifyNetworkExitingPolicyUpdate(r10, false);     // Catch: RemoteException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        defpackage.b.n("tryCellToWifi: RemoteException: ", e, TAG);
    }

    private void tryWifiToCell(int r8, int r10) {
        CaeLog.i(TAG, "tryWifiToCell: wifiNetId: " + r8 + " cellNetId: " + r10);
        ICaeNetworkHandoverListener r11 = this.mListener;     // Catch: RemoteException -> L7
        if (r11 == null) goto L12;
        r11.notifyNetworkExitingPolicyUpdate(r8, true);     // Catch: RemoteException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        defpackage.b.n("tryWifiToCell: RemoteException: ", e, TAG);
    }

    public void makeDefaultNetwork(int r8, int r10) {
        int r11 = NetworkUtil.getNetworkTypeForNetId(this.mContext, r8);
        int r12 = NetworkUtil.getNetworkTypeForNetId(this.mContext, r10);
        if (r11 != r12) goto L7;
        CaeLog.d(TAG, "network type is same, do not switch");
        return;
    L7:
        if (r11 != 1) goto L10;
        if (r12 != 0) goto L10;
        tryWifiToCell(r8, r10);
        return;
    L10:
        if (r11 != 0) goto L15;
        if (r12 != 1) goto L16;
        tryCellToWifi(r8, r10);
        return;
    L16:
        return;
    }

    public void registerListener(ICaeNetworkHandoverListener r8) {
        this.mListener = r8;
    }

    public void resetNetworkPolicy(int r8) {
    L7:
        e = move-exception;
        defpackage.b.n("resetNetworkPolicy: RemoteException: ", e, TAG);
        return;
    L4:
        if (this.mListener == null) goto L12;
        CaeLog.i(TAG, "resetNetworkPolicy: netId: " + r8);     // Catch: RemoteException -> L7
        this.mListener.notifyNetworkExitingPolicyUpdate(r8, false);     // Catch: RemoteException -> L7
        return;
    }

    public boolean tryCellToWifiForUid(int r8) {
        if (this.mMpflowInterface.switchNetByUid((byte) 0, r8, false) == 0) goto L6;
        android.aimedia.a.p("unbind cell net  failed for app. uid: ", r8, TAG);
        return false;
    L6:
        return true;
    }

    public boolean tryWifiToCellForUid(int r8) {
        if (this.mMpflowInterface.switchNetByUid((byte) 0, r8, true) == 0) goto L6;
        android.aimedia.a.p("bind cell net failed for app. uid: ", r8, TAG);
        return false;
    L6:
        return true;
    }

    public void unregisterListener(ICaeNetworkHandoverListener r8) {
        if (this.mListener != r8) goto L6;
        this.mListener = null;
        return;
    }

    public void updateNetworkProbeResult(int r8, boolean r10, String r11) {
        if (this.mListener != null) goto L15;
        CaeLog.i(TAG, "listener is null, network probe result update failed.");
        return;
    L15:
        CaeLog.i(TAG, "notifyNetworkTestedResult: netId: " + r8 + ", isValid: " + r10 + ", redirectUrl: " + r11);     // Catch: RemoteException -> L12
        ICaeNetworkHandoverListener r12 = this.mListener;     // Catch: RemoteException -> L12
        if (r10 == false) goto L9;
        int r13 = 1;
    L10:
        r12.notifyNetworkTestedResult(r8, r13, r11);     // Catch: RemoteException -> L12
        return;
    L9:
        r13 = 0;
    L12:
        e = move-exception;
        CaeLog.e(TAG, "RemoteException: " + e.getMessage());
    }
}
