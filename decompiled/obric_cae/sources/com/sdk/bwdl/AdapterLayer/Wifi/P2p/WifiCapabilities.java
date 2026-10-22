package com.sdk.bwdl.AdapterLayer.Wifi.P2p;

import android.aimedia.a;

/* JADX INFO: loaded from: classes2.dex */
public class WifiCapabilities {
    public int frequency;
    public boolean isConnected;
    public boolean isEnabled;
    public boolean isSupportDualBand;
    public boolean isSupported5GHz;
    public boolean isWifiApEnabled;

    public static final class Builder {
        public int mFrequency;
        public boolean mIsConnected;
        public boolean mIsEnabled;
        public boolean mIsSupportDualBand;
        public boolean mIsSupported5GHz;
        public boolean mIsWifiApEnabled;

        public Builder() {
            this.mIsWifiApEnabled = false;
            this.mIsEnabled = false;
            this.mIsConnected = false;
            this.mIsSupportDualBand = false;
            this.mIsSupported5GHz = false;
            this.mFrequency = 0;
        }

        public WifiCapabilities build() {
            WifiCapabilities r8 = new WifiCapabilities();
            r8.isWifiApEnabled = this.mIsWifiApEnabled;
            r8.isEnabled = this.mIsEnabled;
            r8.isConnected = this.mIsConnected;
            r8.isSupportDualBand = this.mIsSupportDualBand;
            r8.isSupported5GHz = this.mIsSupported5GHz;
            r8.frequency = this.mFrequency;
            return r8;
        }

        public Builder setConnected(boolean r8) {
            this.mIsConnected = r8;
            return this;
        }

        public Builder setEnabled(boolean r8) {
            this.mIsEnabled = r8;
            return this;
        }

        public Builder setFrequency(int r8) {
            this.mFrequency = r8;
            return this;
        }

        public Builder setSupportDualBand(boolean r8) {
            this.mIsSupportDualBand = r8;
            return this;
        }

        public Builder setSupported5GHz(boolean r8) {
            this.mIsSupported5GHz = r8;
            return this;
        }

        public Builder setWifiApEnabled(boolean r8) {
            this.mIsWifiApEnabled = r8;
            return this;
        }
    }

    public WifiCapabilities() {
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("WifiCapabilities [isWifiApEnabled=");
        r8.append(this.isWifiApEnabled);
        r8.append(", isEnabled=");
        r8.append(this.isEnabled);
        r8.append(", isConnected=");
        r8.append(this.isConnected);
        r8.append(", isSupportDualBand=");
        r8.append(this.isSupportDualBand);
        r8.append(", isSupported5GHz=");
        r8.append(this.isSupported5GHz);
        r8.append(", frequency=");
        return a.f(r8, this.frequency, ']');
    }
}
