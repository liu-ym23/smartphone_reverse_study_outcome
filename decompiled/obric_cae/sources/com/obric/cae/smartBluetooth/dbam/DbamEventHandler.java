package com.obric.cae.smartBluetooth.dbam;

import android.content.Context;
import com.cae.caed.DbamParamParcel;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import com.obric.cae.utils.CaeUtil;

/* JADX INFO: loaded from: classes.dex */
public class DbamEventHandler {
    private static final int DBAM_INDEX = 0;
    private static final String TAG = "DbamEventHandler";
    private final Context mContext;
    private NefidInterface mNefidInterface;

    public DbamEventHandler(Context r8) {
        this.mContext = r8;
        NefidInterface r10 = NefidInterface.getInstance(r8);
        this.mNefidInterface = r10;
        if (r10 == null) goto L6;
        setDbamParams(r8);
        return;
    }

    public boolean GetDbamParams(DbamParamParcel r8) {
        NefidInterface r10 = NefidInterface.getInstance(this.mContext);
        this.mNefidInterface = r10;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.getDbamParams(0, r8);
    }

    public boolean SetDbamParams(DbamParamParcel r8) {
        NefidInterface r10 = NefidInterface.getInstance(this.mContext);
        this.mNefidInterface = r10;
        if (r10 == null) goto L6;
        CaeLog.d(TAG, "SetDbamParams: btc mode: " + r8.f4102a + ", antenna isolation: " + r8.f4103b + ", max tx power for btc: " + r8.f4104m + ", wlan low rssi threshold: " + r8.f4105n + ", bt low rssi threshold: " + r8.f4106o + ", dbam index: 0");
        return this.mNefidInterface.setDbamParams(0, r8);
    L6:
        return false;
    }

    public boolean setDbamParams(Context r8) {
        DbamParamParcel r10 = new DbamParamParcel();
        int r11 = CaeUtil.getDbamConfigPrefs(r8, "dbam_mode");
        if (r11 >= 0) goto L5;
    L7:
        if (r11 != 255) goto L10;
        r11 = 1;
    L9:
        r10.f4102a = r11;
    L10:
        int r12 = CaeUtil.getDbamConfigPrefs(r8, "antenna_isolation");
        if (r12 != 255) goto L14;
        r12 = 35;
    L13:
        r10.f4103b = r12;
    L16:
        int r13 = CaeUtil.getDbamConfigPrefs(r8, "max_tx_power_for_btc");
        if (r13 <= 0) goto L20;
        if (r13 > 100) goto L20;
        r10.f4104m = r13;
    L22:
        int r14 = CaeUtil.getDbamConfigPrefs(r8, "wifi_low_rssi_threshold");
        if (r14 >= 0) goto L25;
        r10.f4105n = r14;
    L27:
        int r15 = CaeUtil.getDbamConfigPrefs(r8, "bt_low_rssi_threshold");
        if (r15 >= 0) goto L30;
        r10.f4106o = r15;
    L33:
        return SetDbamParams(r10);
    L30:
        if (r15 != 255) goto L33;
        r10.f4106o = -65;
        goto L33
    L25:
        if (r14 != 255) goto L27;
        r10.f4105n = -65;
    L20:
        if (r13 != 255) goto L22;
        r10.f4104m = 100;
        goto L22
    L14:
        if (r12 <= 0) goto L16;
    L5:
        if (r11 > 2) goto L7;
        goto L7
    }
}
