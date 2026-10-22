package com.ttnet.org.chromium.net.impl;

import java.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CronetLogger {

    public static class CronetEngineBuilderInfo {
        private final boolean mBrotiEnabled;
        private final String mExperimentalOptions;
        private final boolean mHttp2Enabled;
        private final int mHttpCacheMode;
        private final boolean mNetworkQualityEstimatorEnabled;
        private final boolean mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
        private final boolean mQuicEnabled;
        private final String mStoragePath;
        private final int mThreadPriority;
        private final String mUserAgent;

        public CronetEngineBuilderInfo(CronetEngineBuilderImpl r10) {
            this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled = r10.publicKeyPinningBypassForLocalTrustAnchorsEnabled();
            this.mUserAgent = r10.getUserAgent();
            this.mStoragePath = r10.storagePath();
            this.mQuicEnabled = r10.quicEnabled();
            this.mHttp2Enabled = r10.http2Enabled();
            this.mBrotiEnabled = r10.brotliEnabled();
            this.mHttpCacheMode = r10.publicBuilderHttpCacheMode();
            this.mExperimentalOptions = r10.experimentalOptions();
            this.mNetworkQualityEstimatorEnabled = r10.networkQualityEstimatorEnabled();
            this.mThreadPriority = r10.threadPriority(10);
        }

        public String getExperimentalOptions() {
            return this.mExperimentalOptions;
        }

        public int getHttpCacheMode() {
            return this.mHttpCacheMode;
        }

        public String getStoragePath() {
            return this.mStoragePath;
        }

        public int getThreadPriority() {
            return this.mThreadPriority;
        }

        public String getUserAgent() {
            return this.mUserAgent;
        }

        public boolean isBrotliEnabled() {
            return this.mBrotiEnabled;
        }

        public boolean isHttp2Enabled() {
            return this.mHttp2Enabled;
        }

        public boolean isNetworkQualityEstimatorEnabled() {
            return this.mNetworkQualityEstimatorEnabled;
        }

        public boolean isPublicKeyPinningBypassForLocalTrustAnchorsEnabled() {
            return this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
        }

        public boolean isQuicEnabled() {
            return this.mQuicEnabled;
        }
    }

    public static final enum CronetSource extends Enum<CronetSource> {
        private static final /* synthetic */ CronetSource[] $VALUES = null;
        public static final CronetSource CRONET_SOURCE_FALLBACK = null;
        public static final CronetSource CRONET_SOURCE_PLAY_SERVICES = null;
        public static final CronetSource CRONET_SOURCE_STATICALLY_LINKED = null;
        public static final CronetSource CRONET_SOURCE_UNSPECIFIED = null;

        static {
            CronetSource r10 = new CronetSource("CRONET_SOURCE_UNSPECIFIED", 0);
            CRONET_SOURCE_UNSPECIFIED = r10;
            CronetSource r11 = new CronetSource("CRONET_SOURCE_STATICALLY_LINKED", 1);
            CRONET_SOURCE_STATICALLY_LINKED = r11;
            CronetSource r12 = new CronetSource("CRONET_SOURCE_PLAY_SERVICES", 2);
            CRONET_SOURCE_PLAY_SERVICES = r12;
            CronetSource r13 = new CronetSource("CRONET_SOURCE_FALLBACK", 3);
            CRONET_SOURCE_FALLBACK = r13;
            $VALUES = new CronetSource[]{r10, r11, r12, r13};
        }

        private CronetSource(String r10, int r11) {
            super(r10, r11);
        }

        public static CronetSource valueOf(String r10) {
            return (CronetSource) Enum.valueOf(CronetSource.class, r10);
        }

        public static CronetSource[] values() {
            return (CronetSource[]) $VALUES.clone();
        }
    }

    public static class CronetTrafficInfo {
        private final boolean mDidConnectionMigrationSucceed;
        private final Duration mHeadersLatency;
        private final String mNegotiatedProtocol;
        private final long mRequestBodySizeInBytes;
        private final long mRequestHeaderSizeInBytes;
        private final long mResponseBodySizeInBytes;
        private final long mResponseHeaderSizeInBytes;
        private final int mResponseStatusCode;
        private final Duration mTotalLatency;
        private final boolean mWasConnectionMigrationAttempted;

        public CronetTrafficInfo(long r10, long r11, long r12, long r13, int r14, Duration r15, Duration r16, String r17, boolean r18, boolean r19) {
            this.mRequestHeaderSizeInBytes = r10;
            this.mRequestBodySizeInBytes = r11;
            this.mResponseHeaderSizeInBytes = r12;
            this.mResponseBodySizeInBytes = r13;
            this.mResponseStatusCode = r14;
            this.mHeadersLatency = r15;
            this.mTotalLatency = r16;
            this.mNegotiatedProtocol = r17;
            this.mWasConnectionMigrationAttempted = r18;
            this.mDidConnectionMigrationSucceed = r19;
        }

        public boolean didConnectionMigrationSucceed() {
            return this.mDidConnectionMigrationSucceed;
        }

        public Duration getHeadersLatency() {
            return this.mHeadersLatency;
        }

        public String getNegotiatedProtocol() {
            return this.mNegotiatedProtocol;
        }

        public long getRequestBodySizeInBytes() {
            return this.mRequestBodySizeInBytes;
        }

        public long getRequestHeaderSizeInBytes() {
            return this.mRequestHeaderSizeInBytes;
        }

        public long getResponseBodySizeInBytes() {
            return this.mResponseBodySizeInBytes;
        }

        public long getResponseHeaderSizeInBytes() {
            return this.mResponseHeaderSizeInBytes;
        }

        public int getResponseStatusCode() {
            return this.mResponseStatusCode;
        }

        public Duration getTotalLatency() {
            return this.mTotalLatency;
        }

        public boolean wasConnectionMigrationAttempted() {
            return this.mWasConnectionMigrationAttempted;
        }
    }

    public static class CronetVersion {
        private final int mBuildVersion;
        private final int mMajorVersion;
        private final int mMinorVersion;
        private final int mPatchVersion;

        public CronetVersion(String r10) {
            String[] r11 = r10.split("\\.");
            this.mMajorVersion = Integer.parseInt(r11[0]);
            this.mMinorVersion = Integer.parseInt(r11[1]);
            this.mBuildVersion = Integer.parseInt(r11[2]);
            this.mPatchVersion = Integer.parseInt(r11[3]);
        }

        public int getBuildVersion() {
            return this.mBuildVersion;
        }

        public int getMajorVersion() {
            return this.mMajorVersion;
        }

        public int getMinorVersion() {
            return this.mMinorVersion;
        }

        public int getPatchVersion() {
            return this.mPatchVersion;
        }

        public String toString() {
            return "" + this.mMajorVersion + "." + this.mMinorVersion + "." + this.mBuildVersion + "." + this.mPatchVersion;
        }
    }

    public CronetLogger() {
    }

    public abstract void logCronetEngineCreation(int r10, CronetEngineBuilderInfo r11, CronetVersion r12, CronetSource r13);

    public abstract void logCronetTrafficInfo(int r10, CronetTrafficInfo r11);
}
