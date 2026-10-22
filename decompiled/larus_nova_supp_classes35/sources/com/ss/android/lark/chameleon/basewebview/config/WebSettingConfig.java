package com.ss.android.lark.chameleon.basewebview.config;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import com.ss.android.lark.chameleon.basewebview.BaseWebView;
import com.ss.android.lark.chameleon.idependency.Env;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class WebSettingConfig {
    private static final String TAG = "WebSettingConfig";
    private boolean mIsJSEnable;
    private boolean mIsSupportMultipleWindows;
    private String mSpecificUserAgent;

    public static class Builder extends BaseConfigBuilder {
        private WebSettingConfig mWebSettingConfig;

        @Override // com.ss.android.lark.chameleon.basewebview.config.BaseConfigBuilder
        public void initDefaultConfig(Context r1) {
        }

        public WebSettingConfig build() {
            return this.mWebSettingConfig;
        }

        public Builder(LarkWebViewConfig.Builder r1) {
            super(r1);
            this.mWebSettingConfig = new WebSettingConfig();
        }

        public Builder setJavaScriptEnable(boolean r2) {
            WebSettingConfig.access$002(this.mWebSettingConfig, r2);
            return this;
        }

        public Builder setSpecificUserAgent(String r2) {
            WebSettingConfig.access$102(this.mWebSettingConfig, r2);
            return this;
        }

        public Builder setSupportMultipleWindows(boolean r2) {
            WebSettingConfig.access$202(this.mWebSettingConfig, r2);
            return this;
        }
    }

    public WebSettingConfig() {
        this.mIsJSEnable = true;
        this.mIsSupportMultipleWindows = false;
    }

    public String getSpecificUserAgent() {
        return this.mSpecificUserAgent;
    }

    public boolean isJSEnable() {
        return this.mIsJSEnable;
    }

    public void apply(BaseWebView r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        WebSettings r0 = r4.getSettings();
        r0.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        r0.setLoadWithOverviewMode(true);
        r0.setUseWideViewPort(true);
        r0.setDomStorageEnabled(true);
        r0.setDatabaseEnabled(true);
        r0.setDisplayZoomControls(false);
        r0.setBuiltInZoomControls(true);
        r0.setAllowFileAccess(false);
        r0.setJavaScriptCanOpenWindowsAutomatically(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(r4, true);
        r0.setSupportZoom(true);
        r0.setJavaScriptEnabled(this.mIsJSEnable);
        r0.setSupportMultipleWindows(this.mIsSupportMultipleWindows);
        if (TextUtils.isEmpty(this.mSpecificUserAgent) == false) goto L7;
        r0.getUserAgentString();
        r0.setUserAgentString(Env.getUserAgent());
        return;
    L7:
        r0.setUserAgentString(this.mSpecificUserAgent);
    }

    public static /* synthetic */ boolean access$002(WebSettingConfig r0, boolean r1) {
        r0.mIsJSEnable = r1;
        return r1;
    }

    public static /* synthetic */ String access$102(WebSettingConfig r0, String r1) {
        r0.mSpecificUserAgent = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$202(WebSettingConfig r0, boolean r1) {
        r0.mIsSupportMultipleWindows = r1;
        return r1;
    }
}
