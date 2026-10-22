package com.obric.assistant.wakeup.bluetooth_headset.impl;

import android.bluetooth.BluetoothProfile;
import android.os.Handler;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricBluetoothDeviceManager$b implements BluetoothProfile.ServiceListener {
    public ObricBluetoothDeviceManager$b() {
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceDisconnected(int r3) {
        FLogger.a.w("Obric-BluetoothDeviceManager", "updateAudioModeAsActive bindBluetoothHeadset onServiceDisconnected");
        Handler r4 = ObricBluetoothDeviceManager.u;
        if (r4 == null) goto L6;
        r4.post(new h());
        return;
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceConnected(int r3, final BluetoothProfile r4) {
        FLogger.a.w("Obric-BluetoothDeviceManager", "updateAudioModeAsActive bindBluetoothHeadset onServiceConnected");
        Handler r5 = ObricBluetoothDeviceManager.u;
        if (r5 == null) goto L6;
        r5.post(new i(r4));
        return;
    }
}
