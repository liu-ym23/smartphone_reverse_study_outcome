package com.bytedance.apm6.consumer.slardar.header;

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
        this.os = "Android";
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

    void setAid(int r10) {
        this.aid = r10;
    }

    void setApiVersion(int r10) {
        this.apiVersion = r10;
    }

    void setAppVersion(String r10) {
        this.appVersion = r10;
    }

    void setChannel(String r10) {
        this.channel = r10;
    }

    void setConfigTime(long r10) {
        this.configTime = r10;
    }

    void setCurrentUpdateVersionCode(String r10) {
        this.currentUpdateVersionCode = r10;
    }

    void setDeviceBrand(String r10) {
        this.deviceBrand = r10;
    }

    void setDeviceId(String r10) {
        this.deviceId = r10;
    }

    void setDeviceManufacturer(String r10) {
        this.deviceManufacturer = r10;
    }

    void setDeviceModel(String r10) {
        this.deviceModel = r10;
    }

    void setDevicePlatform(String r10) {
        this.devicePlatform = r10;
    }

    public void setDynamicExtra(JSONObject r10) {
        this.dynamicExtra = r10;
    }

    void setFilters(JSONObject r10) {
        this.filters = r10;
    }

    void setManifestVersionCode(String r10) {
        this.manifestVersionCode = r10;
    }

    void setMonitorVersion(String r10) {
        this.monitorVersion = r10;
    }

    public void setNtpOffset(long r10) {
        this.ntpOffset = r10;
    }

    public void setNtpTime(long r10) {
        this.ntpTime = r10;
    }

    void setOs(String r10) {
        this.os = r10;
    }

    void setOsVersion(String r10) {
        this.osVersion = r10;
    }

    void setPackageName(String r10) {
        this.packageName = r10;
    }

    void setPhoneStartTime(long r10) {
        this.phoneStartTime = r10;
    }

    void setProcessName(String r10) {
        this.processName = r10;
    }

    void setReleaseBuild(String r10) {
        this.releaseBuild = r10;
    }

    void setRomVersion(String r10) {
        this.romVersion = r10;
    }

    void setSid(long r10) {
        this.sid = r10;
    }

    public void setStableExtra(JSONObject r10) {
        this.stableExtra = r10;
    }

    void setUid(long r10) {
        this.uid = r10;
    }

    void setUpdateVersionCode(String r10) {
        this.updateVersionCode = r10;
    }

    void setVerifyInfo(String r10) {
        this.verifyInfo = r10;
    }

    void setVersionCode(String r10) {
        this.versionCode = r10;
    }

    void setVersionName(String r10) {
        this.versionName = r10;
    }

    public String toString() {
        return "HeaderInfo{aid=" + this.aid + ", deviceId='" + this.deviceId + "', channel='" + this.channel + "', updateVersionCode='" + this.updateVersionCode + "', appVersion='" + this.appVersion + "', manifestVersionCode='" + this.manifestVersionCode + "', versionCode='" + this.versionCode + "', versionName='" + this.versionName + "', releaseBuild='" + this.releaseBuild + "', os='" + this.os + "', devicePlatform='" + this.devicePlatform + "', osVersion='" + this.osVersion + "', apiVersion=" + this.apiVersion + ", deviceModel='" + this.deviceModel + "', deviceBrand='" + this.deviceBrand + "', deviceManufacturer='" + this.deviceManufacturer + "', processName='" + this.processName + "', sid=" + this.sid + ", romVersion='" + this.romVersion + "', packageName='" + this.packageName + "', monitorVersion='" + this.monitorVersion + "', uid=" + this.uid + ", phoneStartTime=" + this.phoneStartTime + ", verifyInfo='" + this.verifyInfo + "', dynamicExtra=" + this.dynamicExtra + ", stableExtra=" + this.stableExtra + ", filters=" + this.filters + ", currentUpdateVersionCode='" + this.currentUpdateVersionCode + "'}";
    }
}
