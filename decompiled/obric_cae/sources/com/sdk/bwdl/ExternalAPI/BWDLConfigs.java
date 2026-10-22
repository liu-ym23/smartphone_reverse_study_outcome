package com.sdk.bwdl.ExternalAPI;

import android.content.Context;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.sdk.bwdl.Utils.BWDLLog;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLConfigs {
    private static BWDLAdvertisingData mBWDLAdvertisingData;
    private BWDLConstant.ADV_INTERVAL_LEVEL mAdvertisingInterval;
    private int mAdvertisingOptional;
    private BWDLConstant.ADV_TX_POWER_LEVEL mAdvertisingTxPower;
    private BWDLCallback mBWDLCallback;
    private BWDLConstant.BROADCAST_TYPE mBroadcastType;
    private BWDLConstant.DISCOVERY_MODE_LEVEL mDiscoveryInterval;
    private String mFeatureName;
    private int mP2pBand;

    /* JADX INFO: renamed from: com.sdk.bwdl.ExternalAPI.BWDLConfigs$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private BWDLAdvertisingData advertisingData;
        private BWDLConstant.ADV_INTERVAL_LEVEL advertisingInterval;
        private int advertisingOptional;
        private BWDLCallback callback;
        private BWDLConstant.DISCOVERY_MODE_LEVEL discoveryInterval;
        private Context mContext;
        private String mFeatureName;
        private int p2pBand;

        public Builder(Context r8) {
            this.advertisingOptional = 0;
            this.p2pBand = 0;
            if (r8 == null) goto L7;
            this.mContext = r8;
            return;
        L7:
            throw new RuntimeException(BDLocationExceptionMessage.CONTEXT_ERROR_NULL);
        }

        public BWDLConfigs build() {
            BWDLConfigs r8 = new BWDLConfigs(null);
            BWDLConfigs.access$100(r8, this.callback);
            BWDLConfigs.access$200(r8, this.mFeatureName);
            r8.setAdvertisingData(this.advertisingData);
            r8.setAdvertisingInterval(this.advertisingInterval);
            r8.setDiscoveryInterval(this.discoveryInterval);
            r8.setAdvertisingOptional(this.advertisingOptional);
            BWDLConfigs.access$300(r8, this.p2pBand);
            return r8;
        }

        public Builder setAdvertisingData(BWDLAdvertisingData r8) {
            this.advertisingData = r8;
            return this;
        }

        public Builder setAdvertisingInterval(BWDLConstant.ADV_INTERVAL_LEVEL r8) {
            this.advertisingInterval = r8;
            return this;
        }

        public void setAdvertisingOptional(int r8) {
            this.advertisingOptional = r8;
        }

        public Builder setCallback(BWDLCallback r8) {
            this.callback = r8;
            return this;
        }

        public Builder setDiscoveryInterval(BWDLConstant.DISCOVERY_MODE_LEVEL r8) {
            this.discoveryInterval = r8;
            return this;
        }

        public Builder setFeatureName(String r8) {
            this.mFeatureName = r8;
            return this;
        }

        public Builder setP2pBand(int r8) {
            this.p2pBand = r8;
            return this;
        }
    }

    private BWDLConfigs() {
        this.mBroadcastType = BWDLConstant.BROADCAST_TYPE.BROADCAST_LEGACY;
        this.mAdvertisingTxPower = BWDLConstant.ADV_TX_POWER_LEVEL.ADV_TX_POWER_HIGH;
        this.mAdvertisingInterval = BWDLConstant.ADV_INTERVAL_LEVEL.ADV_INTERVAL_HIGH;
        this.mDiscoveryInterval = BWDLConstant.DISCOVERY_MODE_LEVEL.DISCOVERY_MODE_LOW_POWER;
        this.mAdvertisingOptional = 0;
    }

    public static /* synthetic */ void access$100(BWDLConfigs r8, BWDLCallback r10) {
        r8.setCallback(r10);
    }

    public static /* synthetic */ void access$200(BWDLConfigs r8, String r10) {
        r8.setFeatureName(r10);
    }

    public static /* synthetic */ void access$300(BWDLConfigs r8, int r10) {
        r8.setP2pBand(r10);
    }

    private void setCallback(BWDLCallback r8) {
        this.mBWDLCallback = r8;
    }

    private void setFeatureName(String r8) {
        this.mFeatureName = r8;
    }

    private void setP2pBand(int r8) {
        this.mP2pBand = r8;
    }

    public BWDLConstant.ADV_INTERVAL_LEVEL getAdvertisingIntervale() {
        return this.mAdvertisingInterval;
    }

    public int getAdvertisingOptional() {
        return this.mAdvertisingOptional;
    }

    public BWDLConstant.ADV_TX_POWER_LEVEL getAdvertisingTxPower() {
        return this.mAdvertisingTxPower;
    }

    public BWDLAdvertisingData getBWDLAdvertisingData() {
        return mBWDLAdvertisingData;
    }

    public BWDLConstant.BROADCAST_TYPE getBroadcastType() {
        return this.mBroadcastType;
    }

    public BWDLCallback getCallback() {
        return this.mBWDLCallback;
    }

    public BWDLConstant.DISCOVERY_MODE_LEVEL getDiscoveryInterval() {
        return this.mDiscoveryInterval;
    }

    public String getFeatureName() {
        return this.mFeatureName;
    }

    public int getP2pBand() {
        return this.mP2pBand;
    }

    public void setAdvertisingData(BWDLAdvertisingData r8) {
        mBWDLAdvertisingData = r8;
    }

    public void setAdvertisingInterval(BWDLConstant.ADV_INTERVAL_LEVEL r8) {
        this.mAdvertisingInterval = r8;
    }

    public void setAdvertisingOptional(int r8) {
        this.mAdvertisingOptional = r8;
    }

    public void setAdvertisingTxPower(BWDLConstant.ADV_TX_POWER_LEVEL r8) {
        this.mAdvertisingTxPower = r8;
    }

    public void setBroadcastType(BWDLConstant.BROADCAST_TYPE r8) {
        this.mBroadcastType = r8;
    }

    public void setDiscoveryInterval(BWDLConstant.DISCOVERY_MODE_LEVEL r8) {
        this.mDiscoveryInterval = r8;
    }

    public void setLogLevel(BWDLConstant.LogLevel r8) {
        BWDLLog.setBWDLLogLevel(r8);
    }

    public /* synthetic */ BWDLConfigs(AnonymousClass1 r8) {
        this();
    }
}
