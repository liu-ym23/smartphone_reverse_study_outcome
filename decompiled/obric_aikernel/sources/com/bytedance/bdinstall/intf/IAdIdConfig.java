package com.bytedance.bdinstall.intf;

import com.bytedance.bdinstall.util.RomUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IAdIdConfig {

    public static class AdIdConfig implements IAdIdConfig {
        public AdIdConfig() {
        }

        @Override // com.bytedance.bdinstall.intf.IAdIdConfig
        public boolean enablePrefetchAdId() {
            return !RomUtils.isMeizu();
        }

        @Override // com.bytedance.bdinstall.intf.IAdIdConfig
        public long getAdIdWaitTime() {
            return 100;
        }
    }

    boolean enablePrefetchAdId();

    long getAdIdWaitTime();
}
