package com.obric.cae.BWDL.BwdlDrop;

import android.content.Context;
import android.provider.Settings;
import com.obric.cae.log.CaeLog;
import com.sdk.bwdl.ExternalAPI.BWDLAdvertisingData;
import com.sdk.bwdl.ExternalAPI.BWDLManager;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropDiscoveryEngine {
    private static final String TAG = "BwdlDropDiscoveryEngine";
    private BWDLManager mBWDLManager;
    private Context mContext;
    private byte[] mData;
    private final short mFeatureUUID;

    public BwdlDropDiscoveryEngine(Context r8, BWDLManager r10) {
        this.mFeatureUUID = 24576;
        this.mData = new byte[0];
        this.mBWDLManager = r10;
        this.mContext = r8;
    }

    public void advertising(boolean r8) {
        if (this.mBWDLManager == null) goto L9;
        CaeLog.d(TAG, "advertising,isChecked: " + r8);
        BWDLManager r10 = this.mBWDLManager;
        if (r8 == false) goto L7;
        CaeLog.d(TAG, "startAdvertising: " + r10.startAdvertising());
        return;
    L7:
        r10.stopAdvertising();
        return;
    }

    public BWDLAdvertisingData buildAdvertisingData() {
        byte[] r8 = Settings.Global.getString(this.mContext.getContentResolver(), "device_name").getBytes();
        this.mData = r8;
        return new BWDLAdvertisingData(24576, (byte) 0, r8, null);
    }

    public void discovery(boolean r8) {
        if (this.mBWDLManager == null) goto L9;
        CaeLog.d(TAG, "discovery,isChecked: " + r8);
        BWDLManager r10 = this.mBWDLManager;
        if (r8 == false) goto L7;
        CaeLog.d(TAG, "startAdvertising: " + r10.startDiscovery(24576));
        return;
    L7:
        r10.stopDiscovery();
        return;
    }
}
