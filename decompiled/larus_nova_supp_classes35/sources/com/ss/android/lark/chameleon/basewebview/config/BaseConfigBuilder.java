package com.ss.android.lark.chameleon.basewebview.config;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
abstract class BaseConfigBuilder {
    private LarkWebViewConfig.Builder mRootConfigBuilder;

    public abstract void initDefaultConfig(Context r1);

    public final LarkWebViewConfig.Builder switchConfig() {
        return this.mRootConfigBuilder;
    }

    public BaseConfigBuilder(LarkWebViewConfig.Builder r1) {
        this.mRootConfigBuilder = r1;
    }
}
