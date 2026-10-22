package com.bytedance.bdlocation.network.model;

import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class DeviceStatus {

    @b("bluetooth_permission")
    public int bluetoothPermission;

    @b("is_bluetooth_open")
    public boolean bluetoothSwitch;

    @b("device_type")
    public int deviceType;

    @b("is_strict_restricted_mode")
    public boolean isStrictRestrictedMode;

    @b(LocationMonitorConst.IS_WIFI_CACHE)
    public String isWifiCache;

    @b(LocationMonitorConst.IS_WIFI_OPEN)
    public boolean isWifiOpen;

    @b("system_language")
    public String language;

    @b("locale")
    public String locale;

    @b(LocationMonitorConst.LOCATION_MODE)
    public int locationMode;

    @b("mccmnc")
    public String mccmnc;

    @b("permission")
    public int permission;

    @b("system_region")
    public String region;

    @b("restricted_mode")
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

    public int diffWith(DeviceStatus r8) {
        if (r8 != null) goto L6;
        return -1;
    L6:
        if (TextUtils.equals(this.mccmnc, r8.mccmnc) == true) goto L8;
        int r10 = 8;
    L10:
        if (TextUtils.equals(this.region, r8.region) == true) goto L13;
        r10 = r10 | 16;
    L13:
        if (TextUtils.equals(this.language, r8.language) == true) goto L16;
        r10 = r10 | 32;
    L16:
        if (TextUtils.equals(this.locale, r8.locale) == true) goto L19;
        r10 = r10 | 64;
    L19:
        if (this.permission == r8.permission) goto L22;
        r10 = r10 | 1;
    L22:
        if (this.restrictedMode == r8.restrictedMode) goto L25;
        r10 = r10 | 128;
    L25:
        if (this.locationMode == r8.locationMode) goto L28;
        r10 = r10 | 256;
    L28:
        if (this.isStrictRestrictedMode == r8.isStrictRestrictedMode) goto L31;
        r10 = r10 | 512;
    L31:
        if (this.bluetoothSwitch == r8.bluetoothSwitch) goto L34;
        r10 = r10 | 2;
    L34:
        if (this.isWifiOpen == r8.isWifiOpen) goto L37;
        r10 = r10 | 4;
    L37:
        if (this.bluetoothPermission != r8.bluetoothPermission) goto L39;
        return r10;
    L39:
        return r10 | 1024;
    L8:
        r10 = 0;
        goto L10
    }
}
