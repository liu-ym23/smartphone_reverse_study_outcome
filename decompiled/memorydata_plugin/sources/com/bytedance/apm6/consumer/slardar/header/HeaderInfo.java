package com.bytedance.apm6.consumer.slardar.header;

import com.bytedance.bdlocation.client.LocationInfoConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HeaderInfo {
    private int aid;
    private int apiVersion;
    private String appVersion;
    private String channel;
    private long configTime;
    private String currentUpdateVersionCode;
    private String deviceBrand;
    private String deviceId;
    private String deviceManufacturer;
    private String deviceModel;
    private String devicePlatform;
    private JSONObject dynamicExtra;
    private JSONObject filters;
    private String manifestVersionCode;
    private String monitorVersion;
    private long ntpOffset;
    private long ntpTime;
    private String os;
    private String osVersion;
    private String packageName;
    private long phoneStartTime;
    private String processName;
    private String releaseBuild;
    private String romVersion;
    private long sid;
    private JSONObject stableExtra;
    private long uid;
    private String updateVersionCode;
    private String verifyInfo;
    private String versionCode;
    private String versionName;

    public HeaderInfo() {
        this.os = LocationInfoConst.SYSTEM;
        this.devicePlatform = "android";
        this.configTime = -1;
    }

    int getAid() {
        return this.aid;
    }

    int getApiVersion() {
        return this.apiVersion;
    }

    String getAppVersion() {
        return this.appVersion;
    }

    String getChannel() {
        return this.channel;
    }

    long getConfigTime() {
        return this.configTime;
    }

    String getCurrentUpdateVersionCode() {
        return this.currentUpdateVersionCode;
    }

    String getDeviceBrand() {
        return this.deviceBrand;
    }

    String getDeviceId() {
        return this.deviceId;
    }

    String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    String getDeviceModel() {
        return this.deviceModel;
    }

    String getDevicePlatform() {
        return this.devicePlatform;
    }

    public JSONObject getDynamicExtra() {
        return this.dynamicExtra;
    }

    JSONObject getFilters() {
        return this.filters;
    }

    String getManifestVersionCode() {
        return this.manifestVersionCode;
    }

    String getMonitorVersion() {
        return this.monitorVersion;
    }

    public long getNtpOffset() {
        return this.ntpOffset;
    }

    public long getNtpTime() {
        return this.ntpTime;
    }

    String getOs() {
        return this.os;
    }

    String getOsVersion() {
        return this.osVersion;
    }

    String getPackageName() {
        return this.packageName;
    }

    long getPhoneStartTime() {
        return this.phoneStartTime;
    }

    String getProcessName() {
        return this.processName;
    }

    String getReleaseBuild() {
        return this.releaseBuild;
    }

    String getRomVersion() {
        return this.romVersion;
    }

    long getSid() {
        return this.sid;
    }

    public JSONObject getStableExtra() {
        return this.stableExtra;
    }

    long getUid() {
        return this.uid;
    }

    String getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    String getVerifyInfo() {
        return this.verifyInfo;
    }

    String getVersionCode() {
        return this.versionCode;
    }

    String getVersionName() {
        return this.versionName;
    }

    void setAid(int r1) {
        this.aid = r1;
    }

    void setApiVersion(int r1) {
        this.apiVersion = r1;
    }

    void setAppVersion(String r1) {
        this.appVersion = r1;
    }

    void setChannel(String r1) {
        this.channel = r1;
    }

    void setConfigTime(long r1) {
        this.configTime = r1;
    }

    void setCurrentUpdateVersionCode(String r1) {
        this.currentUpdateVersionCode = r1;
    }

    void setDeviceBrand(String r1) {
        this.deviceBrand = r1;
    }

    void setDeviceId(String r1) {
        this.deviceId = r1;
    }

    void setDeviceManufacturer(String r1) {
        this.deviceManufacturer = r1;
    }

    void setDeviceModel(String r1) {
        this.deviceModel = r1;
    }

    void setDevicePlatform(String r1) {
        this.devicePlatform = r1;
    }

    public void setDynamicExtra(JSONObject r1) {
        this.dynamicExtra = r1;
    }

    void setFilters(JSONObject r1) {
        this.filters = r1;
    }

    void setManifestVersionCode(String r1) {
        this.manifestVersionCode = r1;
    }

    void setMonitorVersion(String r1) {
        this.monitorVersion = r1;
    }

    public void setNtpOffset(long r1) {
        this.ntpOffset = r1;
    }

    public void setNtpTime(long r1) {
        this.ntpTime = r1;
    }

    void setOs(String r1) {
        this.os = r1;
    }

    void setOsVersion(String r1) {
        this.osVersion = r1;
    }

    void setPackageName(String r1) {
        this.packageName = r1;
    }

    void setPhoneStartTime(long r1) {
        this.phoneStartTime = r1;
    }

    void setProcessName(String r1) {
        this.processName = r1;
    }

    void setReleaseBuild(String r1) {
        this.releaseBuild = r1;
    }

    void setRomVersion(String r1) {
        this.romVersion = r1;
    }

    void setSid(long r1) {
        this.sid = r1;
    }

    public void setStableExtra(JSONObject r1) {
        this.stableExtra = r1;
    }

    void setUid(long r1) {
        this.uid = r1;
    }

    void setUpdateVersionCode(String r1) {
        this.updateVersionCode = r1;
    }

    void setVerifyInfo(String r1) {
        this.verifyInfo = r1;
    }

    void setVersionCode(String r1) {
        this.versionCode = r1;
    }

    void setVersionName(String r1) {
        this.versionName = r1;
    }

    public String toString() {
        return "HeaderInfo{aid=" + this.aid + ", deviceId='" + this.deviceId + "', channel='" + this.channel + "', updateVersionCode='" + this.updateVersionCode + "', appVersion='" + this.appVersion + "', manifestVersionCode='" + this.manifestVersionCode + "', versionCode='" + this.versionCode + "', versionName='" + this.versionName + "', releaseBuild='" + this.releaseBuild + "', os='" + this.os + "', devicePlatform='" + this.devicePlatform + "', osVersion='" + this.osVersion + "', apiVersion=" + this.apiVersion + ", deviceModel='" + this.deviceModel + "', deviceBrand='" + this.deviceBrand + "', deviceManufacturer='" + this.deviceManufacturer + "', processName='" + this.processName + "', sid=" + this.sid + ", romVersion='" + this.romVersion + "', packageName='" + this.packageName + "', monitorVersion='" + this.monitorVersion + "', uid=" + this.uid + ", phoneStartTime=" + this.phoneStartTime + ", verifyInfo='" + this.verifyInfo + "', dynamicExtra=" + this.dynamicExtra + ", stableExtra=" + this.stableExtra + ", filters=" + this.filters + ", currentUpdateVersionCode='" + this.currentUpdateVersionCode + "'}";
    }
}
