package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public abstract class TTAppInfoProvider {

    public static class AppInfo {
        private String mAbi;
        private String mAppId;
        private String mAppName;
        private String mCarrierRegion;
        private String mChannel;
        private String mDeviceBrand;
        private String mDeviceId;
        private String mDeviceModel;
        private String mDevicePlatform;
        private String mDeviceType;
        private String mDomainBoe;
        private String mDomainBoeHttps;
        private String mDomainHttpDns;
        private String mDomainNetlog;
        private String mHostFirst;
        private String mHostSecond;
        private String mHostThird;
        private String mHttpDnsRequestFlags;
        private String mIsMainProcess;
        private String mManifestVersionCode;
        private String mNetAccessType;
        private String mOSApi;
        private String mOSVersion;
        private String mRegion;
        private String mSdkAppID;
        private String mSdkVersion;
        private String mStoreIdc;
        private String mSysRegion;
        private String mTNCRequestFlags;
        private String mTNCRequestHeader;
        private String mTNCRequestQuery;
        private String mUpdateVersionCode;
        private String mUserId;
        private String mVersionCode;
        private String mVersionName;

        public AppInfo() {
        }

        @CalledByNative
        public String getAbi() {
            return this.mAbi;
        }

        @CalledByNative
        public String getAppId() {
            return this.mAppId;
        }

        @CalledByNative
        public String getAppName() {
            return this.mAppName;
        }

        @CalledByNative
        public String getCarrierRegion() {
            return this.mCarrierRegion;
        }

        @CalledByNative
        public String getChannel() {
            return this.mChannel;
        }

        @CalledByNative
        public String getDeviceBrand() {
            return this.mDeviceBrand;
        }

        @CalledByNative
        public String getDeviceId() {
            return this.mDeviceId;
        }

        @CalledByNative
        public String getDeviceModel() {
            return this.mDeviceModel;
        }

        @CalledByNative
        public String getDevicePlatform() {
            return this.mDevicePlatform;
        }

        @CalledByNative
        public String getDeviceType() {
            return this.mDeviceType;
        }

        @CalledByNative
        public String getDomainBoe() {
            return this.mDomainBoe;
        }

        @CalledByNative
        public String getDomainBoeHttps() {
            return this.mDomainBoeHttps;
        }

        @CalledByNative
        public String getDomainHttpDns() {
            return this.mDomainHttpDns;
        }

        @CalledByNative
        public String getDomainNetlog() {
            return this.mDomainNetlog;
        }

        @CalledByNative
        public String getHostFirst() {
            return this.mHostFirst;
        }

        @CalledByNative
        public String getHostSecond() {
            return this.mHostSecond;
        }

        @CalledByNative
        public String getHostThird() {
            return this.mHostThird;
        }

        @CalledByNative
        public String getHttpDnsRequestFlags() {
            return this.mHttpDnsRequestFlags;
        }

        @CalledByNative
        public String getIsMainProcess() {
            return this.mIsMainProcess;
        }

        @CalledByNative
        public String getManifestVersionCode() {
            return this.mManifestVersionCode;
        }

        @CalledByNative
        public String getNetAccessType() {
            return this.mNetAccessType;
        }

        @CalledByNative
        public String getOSApi() {
            return this.mOSApi;
        }

        @CalledByNative
        public String getOSVersion() {
            return this.mOSVersion;
        }

        @CalledByNative
        public String getRegion() {
            return this.mRegion;
        }

        @CalledByNative
        public String getSdkAppID() {
            return this.mSdkAppID;
        }

        @CalledByNative
        public String getSdkVersion() {
            return this.mSdkVersion;
        }

        @CalledByNative
        public String getStoreIdc() {
            return this.mStoreIdc;
        }

        @CalledByNative
        public String getSysRegion() {
            return this.mSysRegion;
        }

        @CalledByNative
        public String getTNCRequestFlags() {
            return this.mTNCRequestFlags;
        }

        @CalledByNative
        public String getTNCRequestHeader() {
            return this.mTNCRequestHeader;
        }

        @CalledByNative
        public String getTNCRequestQuery() {
            return this.mTNCRequestQuery;
        }

        @CalledByNative
        public String getUpdateVersionCode() {
            return this.mUpdateVersionCode;
        }

        @CalledByNative
        public String getUserId() {
            return this.mUserId;
        }

        @CalledByNative
        public String getVersionCode() {
            return this.mVersionCode;
        }

        @CalledByNative
        public String getVersionName() {
            return this.mVersionName;
        }

        public void setAbi(String r8) {
            this.mAbi = r8;
        }

        public void setAppId(String r8) {
            this.mAppId = r8;
        }

        public void setAppName(String r8) {
            this.mAppName = r8;
        }

        public void setCarrierRegion(String r8) {
            this.mCarrierRegion = r8;
        }

        public void setChannel(String r8) {
            this.mChannel = r8;
        }

        public void setDeviceBrand(String r8) {
            this.mDeviceBrand = r8;
        }

        public void setDeviceId(String r8) {
            this.mDeviceId = r8;
        }

        public void setDeviceModel(String r8) {
            this.mDeviceModel = r8;
        }

        public void setDevicePlatform(String r8) {
            this.mDevicePlatform = r8;
        }

        public void setDeviceType(String r8) {
            this.mDeviceType = r8;
        }

        public void setDomainBoe(String r8) {
            this.mDomainBoe = r8;
        }

        public void setDomainBoeHttps(String r8) {
            this.mDomainBoeHttps = r8;
        }

        public void setDomainHttpDns(String r8) {
            this.mDomainHttpDns = r8;
        }

        public void setDomainNetlog(String r8) {
            this.mDomainNetlog = r8;
        }

        public void setHostFirst(String r8) {
            this.mHostFirst = r8;
        }

        public void setHostSecond(String r8) {
            this.mHostSecond = r8;
        }

        public void setHostThird(String r8) {
            this.mHostThird = r8;
        }

        public void setHttpDnsRequestFlags(String r8) {
            this.mHttpDnsRequestFlags = r8;
        }

        public void setIsMainProcess(String r8) {
            this.mIsMainProcess = r8;
        }

        public void setManifestVersionCode(String r8) {
            this.mManifestVersionCode = r8;
        }

        public void setNetAccessType(String r8) {
            this.mNetAccessType = r8;
        }

        public void setOSApi(String r8) {
            this.mOSApi = r8;
        }

        public void setOSVersion(String r8) {
            this.mOSVersion = r8;
        }

        public void setRegion(String r8) {
            this.mRegion = r8;
        }

        public void setSdkAppID(String r8) {
            this.mSdkAppID = r8;
        }

        public void setSdkVersion(String r8) {
            this.mSdkVersion = r8;
        }

        public void setStoreIdc(String r8) {
            this.mStoreIdc = r8;
        }

        public void setSysRegion(String r8) {
            this.mSysRegion = r8;
        }

        public void setTNCRequestFlags(String r8) {
            this.mTNCRequestFlags = r8;
        }

        public void setTNCRequestHeader(String r8) {
            this.mTNCRequestHeader = r8;
        }

        public void setTNCRequestQuery(String r8) {
            this.mTNCRequestQuery = r8;
        }

        public void setUpdateVersionCode(String r8) {
            this.mUpdateVersionCode = r8;
        }

        public void setUserId(String r8) {
            this.mUserId = r8;
        }

        public void setVersionCode(String r8) {
            this.mVersionCode = r8;
        }

        public void setVersionName(String r8) {
            this.mVersionName = r8;
        }
    }

    public TTAppInfoProvider() {
    }

    public abstract AppInfo getAppInfo();
}
