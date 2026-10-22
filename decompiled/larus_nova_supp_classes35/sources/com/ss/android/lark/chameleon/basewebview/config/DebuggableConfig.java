package com.ss.android.lark.chameleon.basewebview.config;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DebuggableConfig {
    private boolean mIsVConsoleEnable;
    private boolean mIsWebViewInspectEnable;

    public static class Builder extends BaseConfigBuilder {
        private DebuggableConfig mDebuggableConfig;

        public DebuggableConfig build() {
            return this.mDebuggableConfig;
        }

        public Builder(LarkWebViewConfig.Builder r1) {
            super(r1);
            this.mDebuggableConfig = new DebuggableConfig();
        }

        @Override // com.ss.android.lark.chameleon.basewebview.config.BaseConfigBuilder
        public void initDefaultConfig(Context r2) {
            DebuggableConfig.access$102(this.mDebuggableConfig, false);
        }

        public Builder setVConsoleEnable(boolean r2) {
            DebuggableConfig.access$002(this.mDebuggableConfig, r2);
            return this;
        }
    }

    public DebuggableConfig() {
    }

    public boolean isVConsoleEnable() {
        return this.mIsVConsoleEnable;
    }

    public boolean isWebViewInspectEnable() {
        return this.mIsWebViewInspectEnable;
    }

    public static /* synthetic */ boolean access$002(DebuggableConfig r0, boolean r1) {
        r0.mIsVConsoleEnable = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$102(DebuggableConfig r0, boolean r1) {
        r0.mIsWebViewInspectEnable = r1;
        return r1;
    }
}
