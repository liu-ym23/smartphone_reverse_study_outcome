package com.ss.android.lark.chameleon.basewebview.config;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class PerformanceConfig {
    private volatile boolean mPerformanceEnable;

    public static class Builder extends BaseConfigBuilder {
        private PerformanceConfig mPerformanceConfig;

        public PerformanceConfig build() {
            return this.mPerformanceConfig;
        }

        public Builder(LarkWebViewConfig.Builder r1) {
            super(r1);
            this.mPerformanceConfig = new PerformanceConfig();
        }

        @Override // com.ss.android.lark.chameleon.basewebview.config.BaseConfigBuilder
        public void initDefaultConfig(Context r2) {
            PerformanceConfig.access$002(this.mPerformanceConfig, true);
        }

        public void setPerformanceState(boolean r2) {
            PerformanceConfig.access$002(this.mPerformanceConfig, r2);
        }
    }

    public PerformanceConfig() {
        this.mPerformanceEnable = true;
    }

    public boolean isPerformanceEnable() {
        return this.mPerformanceEnable;
    }

    public static /* synthetic */ boolean access$002(PerformanceConfig r0, boolean r1) {
        r0.mPerformanceEnable = r1;
        return r1;
    }
}
