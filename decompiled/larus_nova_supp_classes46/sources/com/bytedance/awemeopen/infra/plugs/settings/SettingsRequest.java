package com.bytedance.awemeopen.infra.plugs.settings;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class SettingsRequest {
    private String aoVersionCode;
    private String aoVersionString;
    private String appId;
    private String appName;
    private String callerName;
    private String channel;
    private String deviceBrand;
    private String deviceId;
    private String devicePlatform;
    private String deviceType;
    private String installId;
    private int osApi;
    private String osVersion;
    private String pluginVersion;
    private Map<String, String> queryParams;
    private String settingsUrl;
    private String updateVersionCode;
    private String versionCode;
    private String versionName;

    public static class Builder {
        public static final String DEFAULT_SETTINGS_URL = "https://content-open.douyin.com/aweme/open/export_sdk/setting/";
        private String aoVersionCode;
        private String aoVersionString;
        private String appId;
        private String appName;
        private int bdpVersionCode;
        private String callerName;
        private String channel;
        private String deviceBrand;
        private String deviceId;
        private String devicePlatform;
        private String deviceType;
        private String installId;
        private int osApi;
        private String osVersion;
        private String pluginVersion;
        private Map<String, String> queryParams;
        private String settingsUrl;
        private String updateVersionCode;
        private String versionCode;
        private String versionName;

        public SettingsRequest build() {
            SettingsRequest r0 = new SettingsRequest(null);
            SettingsRequest.access$102(r0, this.settingsUrl);
            SettingsRequest.access$202(r0, this.callerName);
            SettingsRequest.access$302(r0, this.pluginVersion);
            SettingsRequest.access$402(r0, this.appId);
            SettingsRequest.access$502(r0, this.appName);
            SettingsRequest.access$602(r0, this.versionCode);
            SettingsRequest.access$702(r0, this.devicePlatform);
            SettingsRequest.access$802(r0, this.deviceType);
            SettingsRequest.access$902(r0, this.deviceBrand);
            SettingsRequest.access$1002(r0, this.deviceId);
            SettingsRequest.access$1102(r0, this.osVersion);
            SettingsRequest.access$1202(r0, this.osApi);
            SettingsRequest.access$1302(r0, this.channel);
            SettingsRequest.access$1402(r0, this.queryParams);
            SettingsRequest.access$1502(r0, this.updateVersionCode);
            SettingsRequest.access$1602(r0, this.versionName);
            SettingsRequest.access$1702(r0, this.installId);
            SettingsRequest.access$1802(r0, this.aoVersionCode);
            SettingsRequest.access$1902(r0, this.aoVersionString);
            return r0;
        }

        public Builder() {
            this.settingsUrl = DEFAULT_SETTINGS_URL;
            this.callerName = "aweme_open";
            this.deviceType = Build.MODEL;
            this.deviceBrand = Build.BRAND;
            this.appId = AoEnv.d();
            this.appName = AoEnv.a().getHostAppName();
            this.versionCode = String.valueOf(AoEnv.a().getHostVersionCode());
            this.devicePlatform = "android";
            this.deviceId = AoEnv.c();
        }

        public String getAoVersionCode() {
            return this.aoVersionCode;
        }

        public String getAoVersionString() {
            return this.aoVersionString;
        }

        public String getAppId() {
            return this.appId;
        }

        public String getAppName() {
            return this.appName;
        }

        public String getCallerName() {
            return this.callerName;
        }

        public String getDeviceBrand() {
            return this.deviceBrand;
        }

        public String getDeviceId() {
            return this.deviceId;
        }

        public String getDevicePlatform() {
            return this.devicePlatform;
        }

        public String getDeviceType() {
            return this.deviceType;
        }

        public String getPluginVersion() {
            return this.pluginVersion;
        }

        public Map<String, String> getQueryParams() {
            return this.queryParams;
        }

        public String getSettingsUrl() {
            return this.settingsUrl;
        }

        public String getVersionCode() {
            return this.versionCode;
        }

        public Builder setAoVersionCode(String r1) {
            this.aoVersionCode = r1;
            return this;
        }

        public Builder setAoVersionString(String r1) {
            this.aoVersionString = r1;
            return this;
        }

        public Builder setAppId(String r1) {
            this.appId = r1;
            return this;
        }

        public Builder setAppName(String r1) {
            this.appName = r1;
            return this;
        }

        public Builder setCallerName(String r1) {
            this.callerName = r1;
            return this;
        }

        public Builder setChannel(String r1) {
            this.channel = r1;
            return this;
        }

        public Builder setDeviceBrand(String r1) {
            this.deviceBrand = r1;
            return this;
        }

        public Builder setDeviceId(String r1) {
            this.deviceId = r1;
            return this;
        }

        public Builder setDevicePlatform(String r1) {
            this.devicePlatform = r1;
            return this;
        }

        public Builder setDeviceType(String r1) {
            this.deviceType = r1;
            return this;
        }

        public Builder setInstallId(String r1) {
            this.installId = r1;
            return this;
        }

        public Builder setOsApi(int r1) {
            this.osApi = r1;
            return this;
        }

        public Builder setOsVersion(String r1) {
            this.osVersion = r1;
            return this;
        }

        public Builder setQueryParams(Map<String, String> r1) {
            this.queryParams = r1;
            return this;
        }

        public Builder setSettingsUrl(String r1) {
            this.settingsUrl = r1;
            return this;
        }

        public Builder setUpdateVersionCode(String r1) {
            this.updateVersionCode = r1;
            return this;
        }

        public Builder setVersionCode(String r1) {
            this.versionCode = r1;
            return this;
        }

        public Builder setVersionName(String r1) {
            this.versionName = r1;
            return this;
        }
    }

    public static /* synthetic */ class a {
    }

    public String buildUrl() {
        StringBuilder r6 = new StringBuilder(this.settingsUrl);
        HashMap r7 = new HashMap();
        Map<String, String> r0 = this.queryParams;
        if (r0 == null) goto L5;
        r7.putAll(r0);
    L5:
        appendParamsIfNotEmpty(r6, "caller_name", this.callerName, r7, true);
        appendParamsIfNotEmpty(r6, "app_id", this.appId, r7, false);
        appendParamsIfNotEmpty(r6, "app_name", this.appName, r7, false);
        appendParamsIfNotEmpty(r6, "version_code", this.versionCode, r7, false);
        appendParamsIfNotEmpty(r6, "device_platform", this.devicePlatform, r7, false);
        appendParamsIfNotEmpty(r6, "device_type", this.deviceType, r7, false);
        appendParamsIfNotEmpty(r6, "device_brand", this.deviceBrand, r7, false);
        appendParamsIfNotEmpty(r6, "device_id", this.deviceId, r7, false);
        appendParamsIfNotEmpty(r6, "plugin_version", this.pluginVersion, r7, false);
        appendParamsIfNotEmpty(r6, "os_version", this.osVersion, r7, false);
        appendParamsIfNotEmpty(r6, "os_api", "" + this.osApi, r7, false);
        appendParamsIfNotEmpty(r6, "channel", this.channel, r7, false);
        appendParamsIfNotEmpty(r6, "update_version_code", this.updateVersionCode, r7, false);
        appendParamsIfNotEmpty(r6, "version_name", this.versionName, r7, false);
        appendParamsIfNotEmpty(r6, "iid", this.installId, r7, false);
        appendParamsIfNotEmpty(r6, "ao_version_code", this.aoVersionCode, r7, false);
        appendParamsIfNotEmpty(r6, "ao_version_code_string", this.aoVersionString, r7, false);
        Iterator r8 = r7.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r8.next();
        appendParamsIfNotEmpty(r6, (String) r1.getKey(), (String) r1.getValue(), null, false);
        goto L7
    L10:
        return r6.toString();
    }

    public String toString() {
        return buildUrl();
    }

    private SettingsRequest() {
    }

    public /* synthetic */ SettingsRequest(a r1) {
        this();
    }

    public static /* synthetic */ String access$1002(SettingsRequest r0, String r1) {
        r0.deviceId = r1;
        return r1;
    }

    public static /* synthetic */ String access$102(SettingsRequest r0, String r1) {
        r0.settingsUrl = r1;
        return r1;
    }

    public static /* synthetic */ String access$1102(SettingsRequest r0, String r1) {
        r0.osVersion = r1;
        return r1;
    }

    public static /* synthetic */ int access$1202(SettingsRequest r0, int r1) {
        r0.osApi = r1;
        return r1;
    }

    public static /* synthetic */ String access$1302(SettingsRequest r0, String r1) {
        r0.channel = r1;
        return r1;
    }

    public static /* synthetic */ Map access$1402(SettingsRequest r0, Map r1) {
        r0.queryParams = r1;
        return r1;
    }

    public static /* synthetic */ String access$1502(SettingsRequest r0, String r1) {
        r0.updateVersionCode = r1;
        return r1;
    }

    public static /* synthetic */ String access$1602(SettingsRequest r0, String r1) {
        r0.versionName = r1;
        return r1;
    }

    public static /* synthetic */ String access$1702(SettingsRequest r0, String r1) {
        r0.installId = r1;
        return r1;
    }

    public static /* synthetic */ String access$1802(SettingsRequest r0, String r1) {
        r0.aoVersionCode = r1;
        return r1;
    }

    public static /* synthetic */ String access$1902(SettingsRequest r0, String r1) {
        r0.aoVersionString = r1;
        return r1;
    }

    public static /* synthetic */ String access$202(SettingsRequest r0, String r1) {
        r0.callerName = r1;
        return r1;
    }

    public static /* synthetic */ String access$302(SettingsRequest r0, String r1) {
        r0.pluginVersion = r1;
        return r1;
    }

    public static /* synthetic */ String access$402(SettingsRequest r0, String r1) {
        r0.appId = r1;
        return r1;
    }

    public static /* synthetic */ String access$502(SettingsRequest r0, String r1) {
        r0.appName = r1;
        return r1;
    }

    public static /* synthetic */ String access$602(SettingsRequest r0, String r1) {
        r0.versionCode = r1;
        return r1;
    }

    public static /* synthetic */ String access$702(SettingsRequest r0, String r1) {
        r0.devicePlatform = r1;
        return r1;
    }

    public static /* synthetic */ String access$802(SettingsRequest r0, String r1) {
        r0.deviceType = r1;
        return r1;
    }

    public static /* synthetic */ String access$902(SettingsRequest r0, String r1) {
        r0.deviceBrand = r1;
        return r1;
    }

    private void appendParamsIfNotEmpty(StringBuilder r2, String r3, String r4, Map<String, String> r5, boolean r6) {
        if (TextUtils.isEmpty(r4) == false) goto L8;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.containsKey(r3) == true) goto L8;
        return;
    L8:
        if (r5 == null) goto L13;
        if (r5.containsKey(r3) == false) goto L13;
        r4 = r5.get(r3);
        r5.remove(r3);
    L13:
        if (r6 == false) goto L15;
        r2.append("?");
        r2.append(r3);
        r2.append("=");
        r2.append(r4);
        return;
    L15:
        r2.append("&");
        r2.append(r3);
        r2.append("=");
        r2.append(r4);
    }
}
