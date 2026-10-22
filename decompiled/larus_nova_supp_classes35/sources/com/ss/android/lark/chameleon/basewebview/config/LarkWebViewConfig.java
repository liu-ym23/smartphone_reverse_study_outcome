package com.ss.android.lark.chameleon.basewebview.config;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LarkWebViewConfig {
    private static final String TAG = "LarkWebViewConfig";
    private DebuggableConfig mDebuggableConfig;
    private PerformanceConfig mPerformanceConfig;
    private WebSettingConfig mWebSettingConfig;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.basewebview.config.LarkWebViewConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        DebuggableConfig.Builder mDebuggableConfigBuilder;
        PerformanceConfig.Builder mPerformanceBuilder;
        WebSettingConfig.Builder mWebSettingConfigBuilder;

        public LarkWebViewConfig build() {
            LarkWebViewConfig r0 = new LarkWebViewConfig(null);
            LarkWebViewConfig.access$102(r0, this.mDebuggableConfigBuilder.build());
            LarkWebViewConfig.access$202(r0, this.mWebSettingConfigBuilder.build());
            LarkWebViewConfig.access$302(r0, this.mPerformanceBuilder.build());
            return r0;
        }

        public DebuggableConfig.Builder debuggableBuilder() {
            return this.mDebuggableConfigBuilder;
        }

        public PerformanceConfig.Builder performanceBuilder() {
            return this.mPerformanceBuilder;
        }

        public WebSettingConfig.Builder webSettingBuilder() {
            return this.mWebSettingConfigBuilder;
        }

        public Builder(Context r2) {
            this.mDebuggableConfigBuilder = new DebuggableConfig.Builder(this);
            this.mWebSettingConfigBuilder = new WebSettingConfig.Builder(this);
            this.mPerformanceBuilder = new PerformanceConfig.Builder(this);
            this.mDebuggableConfigBuilder.initDefaultConfig(r2);
            this.mWebSettingConfigBuilder.initDefaultConfig(r2);
            this.mPerformanceBuilder.initDefaultConfig(r2);
        }

        public LarkWebViewConfig apply(LarkWebViewConfig r3) {
            LarkWebViewConfig r0 = new LarkWebViewConfig(null);
            if (LarkWebViewConfig.access$100(r3) == null) goto L5;
            DebuggableConfig r1 = LarkWebViewConfig.access$100(r3);
        L6:
            LarkWebViewConfig.access$102(r0, r1);
            if (LarkWebViewConfig.access$200(r3) == null) goto L9;
            WebSettingConfig r2 = LarkWebViewConfig.access$200(r3);
        L10:
            LarkWebViewConfig.access$202(r0, r2);
            if (LarkWebViewConfig.access$300(r3) == null) goto L13;
            PerformanceConfig r4 = LarkWebViewConfig.access$300(r3);
        L14:
            LarkWebViewConfig.access$302(r0, r4);
            return r0;
        L13:
            r4 = this.mPerformanceBuilder.build();
            goto L14
        L9:
            r2 = this.mWebSettingConfigBuilder.build();
            goto L10
        L5:
            r1 = this.mDebuggableConfigBuilder.build();
            goto L6
        }
    }

    private LarkWebViewConfig() {
    }

    public DebuggableConfig getDebuggableConfig() {
        return this.mDebuggableConfig;
    }

    public PerformanceConfig getPerformanceConfig() {
        return this.mPerformanceConfig;
    }

    public WebSettingConfig getWebSettingConfig() {
        return this.mWebSettingConfig;
    }

    public /* synthetic */ LarkWebViewConfig(AnonymousClass1 r1) {
        this();
    }

    public static /* synthetic */ DebuggableConfig access$100(LarkWebViewConfig r0) {
        return r0.mDebuggableConfig;
    }

    public static /* synthetic */ WebSettingConfig access$200(LarkWebViewConfig r0) {
        return r0.mWebSettingConfig;
    }

    public static /* synthetic */ PerformanceConfig access$300(LarkWebViewConfig r0) {
        return r0.mPerformanceConfig;
    }

    public static LarkWebViewConfig createDefault(Context r1) {
        return new Builder(r1).build();
    }

    public void setDebuggableConfig(DebuggableConfig r1) {
        this.mDebuggableConfig = r1;
    }

    public void setPerformanceConfig(PerformanceConfig r1) {
        this.mPerformanceConfig = r1;
    }

    public void setWebSettingConfig(WebSettingConfig r1) {
        this.mWebSettingConfig = r1;
    }

    public static /* synthetic */ DebuggableConfig access$102(LarkWebViewConfig r0, DebuggableConfig r1) {
        r0.mDebuggableConfig = r1;
        return r1;
    }

    public static /* synthetic */ WebSettingConfig access$202(LarkWebViewConfig r0, WebSettingConfig r1) {
        r0.mWebSettingConfig = r1;
        return r1;
    }

    public static /* synthetic */ PerformanceConfig access$302(LarkWebViewConfig r0, PerformanceConfig r1) {
        r0.mPerformanceConfig = r1;
        return r1;
    }
}
