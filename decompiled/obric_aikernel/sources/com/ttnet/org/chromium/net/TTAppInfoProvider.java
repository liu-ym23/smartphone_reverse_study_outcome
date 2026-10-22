package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public abstract class TTAppInfoProvider {

    public static class AppInfo {
        private String mAbSdkVersion;
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
        private String mHostFirst;
        private String mHostSecond;
        private String mHostThird;
        private String mHttpDnsRequestFlags;
        private String mInitRegion;
        private String mIsDomestic;
        private String mIsDropFirstTnc;
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
        public String getAbSdkVersion() {
            return this.mAbSdkVersion;
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
        public String getInitRegion() {
            return this.mInitRegion;
        }

        @CalledByNative
        public String getIsDomestic() {
            return this.mIsDomestic;
        }

        @CalledByNative
        public String getIsDropFirstTnc() {
            return this.mIsDropFirstTnc;
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

        public void setAbSdkVersion(String r10) {
            this.mAbSdkVersion = r10;
        }

        public void setAbi(String r10) {
            this.mAbi = r10;
        }

        public void setAppId(String r10) {
            this.mAppId = r10;
        }

        public void setAppName(String r10) {
            this.mAppName = r10;
        }

        public void setCarrierRegion(String r10) {
            this.mCarrierRegion = r10;
        }

        public void setChannel(String r10) {
            this.mChannel = r10;
        }

        public void setDeviceBrand(String r10) {
            this.mDeviceBrand = r10;
        }

        public void setDeviceId(String r10) {
            this.mDeviceId = r10;
        }

        public void setDeviceModel(String r10) {
            this.mDeviceModel = r10;
        }

        public void setDevicePlatform(String r10) {
            this.mDevicePlatform = r10;
        }

        public void setDeviceType(String r10) {
            this.mDeviceType = r10;
        }

        public void setDomainBoe(String r10) {
            this.mDomainBoe = r10;
        }

        public void setDomainBoeHttps(String r10) {
            this.mDomainBoeHttps = r10;
        }

        public void setDomainHttpDns(String r10) {
            this.mDomainHttpDns = r10;
        }

        public void setHostFirst(String r10) {
            this.mHostFirst = r10;
        }

        public void setHostSecond(String r10) {
            this.mHostSecond = r10;
        }

        public void setHostThird(String r10) {
            this.mHostThird = r10;
        }

        public void setHttpDnsRequestFlags(String r10) {
            this.mHttpDnsRequestFlags = r10;
        }

        public void setInitRegion(String r10) {
            this.mInitRegion = r10;
        }

        public void setIsDomestic(String r10) {
            this.mIsDomestic = r10;
        }

        public void setIsDropFirstTnc(String r10) {
            this.mIsDropFirstTnc = r10;
        }

        public void setManifestVersionCode(String r10) {
            this.mManifestVersionCode = r10;
        }

        public void setNetAccessType(String r10) {
            this.mNetAccessType = r10;
        }

        public void setOSApi(String r10) {
            this.mOSApi = r10;
        }

        public void setOSVersion(String r10) {
            this.mOSVersion = r10;
        }

        public void setRegion(String r10) {
            this.mRegion = r10;
        }

        public void setSdkAppID(String r10) {
            this.mSdkAppID = r10;
        }

        public void setSdkVersion(String r10) {
            this.mSdkVersion = r10;
        }

        public void setStoreIdc(String r10) {
            this.mStoreIdc = r10;
        }

        public void setSysRegion(String r10) {
            this.mSysRegion = r10;
        }

        public void setTNCRequestFlags(String r10) {
            this.mTNCRequestFlags = r10;
        }

        public void setTNCRequestHeader(String r10) {
            this.mTNCRequestHeader = r10;
        }

        public void setTNCRequestQuery(String r10) {
            this.mTNCRequestQuery = r10;
        }

        public void setUpdateVersionCode(String r10) {
            this.mUpdateVersionCode = r10;
        }

        public void setUserId(String r10) {
            this.mUserId = r10;
        }

        public void setVersionCode(String r10) {
            this.mVersionCode = r10;
        }

        public void setVersionName(String r10) {
            this.mVersionName = r10;
        }
    }

    public TTAppInfoProvider() {
    }

    public abstract AppInfo getAppInfo();
}
