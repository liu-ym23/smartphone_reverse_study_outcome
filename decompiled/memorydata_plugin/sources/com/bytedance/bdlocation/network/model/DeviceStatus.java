package com.bytedance.bdlocation.network.model;

import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class DeviceStatus {

    @SerializedName("bluetooth_permission")
    public int bluetoothPermission;

    @SerializedName("is_bluetooth_open")
    public boolean bluetoothSwitch;

    @SerializedName(Api.KEY_DEVICE_TYPE)
    public int deviceType;

    @SerializedName("is_strict_restricted_mode")
    public boolean isStrictRestrictedMode;

    @SerializedName(LocationMonitorConst.IS_WIFI_CACHE)
    public String isWifiCache;

    @SerializedName(LocationMonitorConst.IS_WIFI_OPEN)
    public boolean isWifiOpen;

    @SerializedName("system_language")
    public String language;

    @SerializedName("locale")
    public String locale;

    @SerializedName(LocationMonitorConst.LOCATION_MODE)
    public int locationMode;

    @SerializedName("mccmnc")
    public String mccmnc;

    @SerializedName("permission")
    public int permission;

    @SerializedName("system_region")
    public String region;

    @SerializedName("restricted_mode")
    public int restrictedMode;

    public static final class DiffDimension {
        public static final int DIFF_BLUETOOTH_PERMISSION = 1024;
        public static final int DIFF_BLUETOOTH_SWITCH_STATUS = 2;
        public static final int DIFF_IS_STRICT_RESTRICTED_MODE = 512;
        public static final int DIFF_IS_WIFI_OPEN = 4;
        public static final int DIFF_LANGUAGE = 32;
        public static final int DIFF_LOCALE = 64;
        public static final int DIFF_LOCATION_MODE = 256;
        public static final int DIFF_LOCATION_PERMISSION = 1;
        public static final int DIFF_MCC_MNC = 8;
        public static final int DIFF_REGION = 16;
        public static final int DIFF_RESTRICTED_MODE = 128;

        public DiffDimension() {
        }
    }

    public DeviceStatus() {
        this.isWifiCache = "unknown";
    }

    public int diffWith(DeviceStatus r4) {
        if (r4 != null) goto L5;
        return -1;
    L5:
        int r0 = 0;
        if (TextUtils.equals(this.mccmnc, r4.mccmnc) == true) goto L9;
        r0 = 8;
    L9:
        if (TextUtils.equals(this.region, r4.region) == true) goto L12;
        r0 = r0 | 16;
    L12:
        if (TextUtils.equals(this.language, r4.language) == true) goto L15;
        r0 = r0 | 32;
    L15:
        if (TextUtils.equals(this.locale, r4.locale) == true) goto L18;
        r0 = r0 | 64;
    L18:
        if (this.permission == r4.permission) goto L21;
        r0 = r0 | 1;
    L21:
        if (this.restrictedMode == r4.restrictedMode) goto L24;
        r0 = r0 | 128;
    L24:
        if (this.locationMode == r4.locationMode) goto L27;
        r0 = r0 | 256;
    L27:
        if (this.isStrictRestrictedMode == r4.isStrictRestrictedMode) goto L30;
        r0 = r0 | 512;
    L30:
        if (this.bluetoothSwitch == r4.bluetoothSwitch) goto L33;
        r0 = r0 | 2;
    L33:
        if (this.isWifiOpen == r4.isWifiOpen) goto L36;
        r0 = r0 | 4;
    L36:
        if (this.bluetoothPermission != r4.bluetoothPermission) goto L38;
        return r0;
    L38:
        return r0 | 1024;
    }
}
