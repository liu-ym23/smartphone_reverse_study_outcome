package com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure;

import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class BwdlBleScanRuleConfig {
    private boolean mAutoConnect;
    private String mDeviceMac;
    private String[] mDeviceNames;
    private boolean mFuzzy;
    private UUID[] mServiceUuids;

    public static class Builder {
        private boolean mAutoConnect;
        private String mDeviceMac;
        private String[] mDeviceNames;
        private boolean mFuzzy;
        private UUID[] mServiceUuids;

        public Builder() {
            this.mServiceUuids = null;
            this.mDeviceNames = null;
            this.mDeviceMac = null;
            this.mAutoConnect = false;
            this.mFuzzy = false;
        }

        public void applyConfig(BwdlBleScanRuleConfig r8) {
            BwdlBleScanRuleConfig.access$002(r8, this.mServiceUuids);
            BwdlBleScanRuleConfig.access$102(r8, this.mDeviceNames);
            BwdlBleScanRuleConfig.access$202(r8, this.mDeviceMac);
            BwdlBleScanRuleConfig.access$302(r8, this.mAutoConnect);
            BwdlBleScanRuleConfig.access$402(r8, this.mFuzzy);
        }

        public BwdlBleScanRuleConfig build() {
            BwdlBleScanRuleConfig r8 = new BwdlBleScanRuleConfig();
            applyConfig(r8);
            return r8;
        }

        public Builder setAutoConnect(boolean r8) {
            this.mAutoConnect = r8;
            return this;
        }

        public Builder setDeviceMac(String r8) {
            this.mDeviceMac = r8;
            return this;
        }

        public Builder setDeviceName(boolean r8, String... r10) {
            this.mFuzzy = r8;
            this.mDeviceNames = r10;
            return this;
        }

        public Builder setServiceUuids(UUID[] r8) {
            this.mServiceUuids = r8;
            return this;
        }
    }

    public BwdlBleScanRuleConfig() {
        this.mServiceUuids = null;
        this.mDeviceNames = null;
        this.mDeviceMac = null;
        this.mAutoConnect = false;
        this.mFuzzy = false;
    }

    public static /* synthetic */ UUID[] access$002(BwdlBleScanRuleConfig r8, UUID[] r10) {
        r8.mServiceUuids = r10;
        return r10;
    }

    public static /* synthetic */ String[] access$102(BwdlBleScanRuleConfig r8, String[] r10) {
        r8.mDeviceNames = r10;
        return r10;
    }

    public static /* synthetic */ String access$202(BwdlBleScanRuleConfig r8, String r10) {
        r8.mDeviceMac = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$302(BwdlBleScanRuleConfig r8, boolean r10) {
        r8.mAutoConnect = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$402(BwdlBleScanRuleConfig r8, boolean r10) {
        r8.mFuzzy = r10;
        return r10;
    }

    public String getDeviceMac() {
        return this.mDeviceMac;
    }

    public String[] getDeviceNames() {
        return this.mDeviceNames;
    }

    public UUID[] getServiceUuids() {
        return this.mServiceUuids;
    }

    public boolean isAutoConnect() {
        return this.mAutoConnect;
    }

    public boolean isFuzzy() {
        return this.mFuzzy;
    }
}
