package com.obric.cae.smartBluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.obric.cae.libs.bluetooth.CaeBluetoothEvent;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes.dex */
public class SmartBluetoothAnalyzer {
    private static final String TAG = "SmartBluetoothAnalyzer";
    private Context mContext;

    public SmartBluetoothAnalyzer(Context r8) {
        this.mContext = r8;
    }

    private boolean isThresholdReached(CaeBluetoothEvent r8) {
        CaeLog.d(TAG, "isThresholdReached");
        return SmartBluetoothManager.getInstance(this.mContext).getDatabase().isThresholdReached(r8);
    }

    private void performPolicyVerification(CaeBluetoothEvent r8) {
        CaeLog.d(TAG, "performPolicyVerification");
        SmartBluetoothPolicy r10 = SmartBluetoothManager.getInstance(this.mContext).getPolicy();
        if (r10 == null) goto L6;
        r10.performPolicyVerification(r8);
        return;
    }

    private void storeCaeEvent(CaeBluetoothEvent r8) {
        CaeLog.d(TAG, "storeCaeEvent");
        SmartBluetoothManager.getInstance(this.mContext).getDatabase().storeCaeEventToDB(r8);
    }

    public void onA2dpConnected(BluetoothDevice r8) {
        SmartBluetoothManager.getInstance(this.mContext).getDatabase().storeProfileConnectedEventToDB(r8, 2);
    }

    public void onEventReported(CaeBluetoothEvent r8) {
        CaeLog.d(TAG, "onEventReported");
        storeCaeEvent(r8);
        if (isThresholdReached(r8) == false) goto L6;
        performPolicyVerification(r8);
        return;
    }

    public void onHfpConnected(BluetoothDevice r8) {
        SmartBluetoothManager.getInstance(this.mContext).getDatabase().storeProfileConnectedEventToDB(r8, 3);
    }
}
