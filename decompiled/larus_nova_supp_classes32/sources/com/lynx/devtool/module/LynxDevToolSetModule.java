package com.lynx.devtool.module;

import com.lynx.devtoolwrapper.DevToolSettings;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.jsbridge.LynxContextModule;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxDevToolSetModule extends LynxContextModule {
    public static final String NAME = "LynxDevToolSetModule";

    @LynxMethod
    public int getV8Enabled() {
        return DevToolSettings.inst().getV8Enabled();
    }

    @LynxMethod
    public boolean isDebugModeEnabled() {
        return LynxEnv.inst().isDebugModeEnabled();
    }

    @LynxMethod
    public boolean isDevToolEnabled() {
        return LynxEnv.inst().isDevtoolEnabled();
    }

    @LynxMethod
    public boolean isDomTreeEnabled() {
        return DevToolSettings.inst().isDOMTreeEnabled();
    }

    @LynxMethod
    public boolean isFspScreenshotEnabled() {
        return LynxEnv.inst().isFspScreenshotEnabled();
    }

    @LynxMethod
    public boolean isHighlightTouchEnabled() {
        return LynxEnv.inst().isHighlightTouchEnabled();
    }

    @LynxMethod
    public boolean isIgnorePropErrorsEnabled() {
        return DevToolSettings.inst().isCSSErrorIgnored();
    }

    @LynxMethod
    public boolean isLaunchRecord() {
        return LynxEnv.inst().isLaunchRecordEnabled();
    }

    @LynxMethod
    public boolean isLogBoxEnabled() {
        return LynxEnv.inst().isLogBoxEnabled();
    }

    @LynxMethod
    public boolean isLongPressMenuEnabled() {
        return DevToolSettings.inst().isLongPressMenuEnabled();
    }

    @LynxMethod
    public boolean isLynxDebugEnabled() {
        return LynxEnv.inst().isLynxDebugEnabled();
    }

    @LynxMethod
    public boolean isPixelCopyEnabled() {
        return LynxEnv.inst().isPixelCopyEnabled();
    }

    @LynxMethod
    public boolean isQuickjsCacheEnabled() {
        return DevToolSettings.inst().isQuickJSCacheEnabled();
    }

    @LynxMethod
    public boolean isQuickjsDebugEnabled() {
        return DevToolSettings.inst().isQuickJSDebugEnabled();
    }

    public LynxDevToolSetModule(LynxContext r1) {
        super(r1);
    }

    public static /* synthetic */ LynxContext access$000(LynxDevToolSetModule r0) {
        return r0.mLynxContext;
    }

    public static /* synthetic */ LynxContext access$100(LynxDevToolSetModule r0) {
        return r0.mLynxContext;
    }

    @LynxMethod
    public void enableDomTree(Boolean r2) {
        DevToolSettings.inst().setDOMTreeEnabled(r2.booleanValue());
    }

    @LynxMethod
    public void switchDebugModeEnable(Boolean r2) {
        LynxEnv.inst().enableDebugMode(r2.booleanValue());
    }

    @LynxMethod
    public void switchDevTool(Boolean r2) {
        LynxEnv.inst().enableDevtool(r2.booleanValue());
    }

    @LynxMethod
    public void switchFspScreenshot(Boolean r2) {
        LynxEnv.inst().enableFspScreenshot(r2.booleanValue());
    }

    @LynxMethod
    public void switchHighlightTouch(Boolean r2) {
        LynxEnv.inst().enableHighlightTouch(r2.booleanValue());
    }

    @LynxMethod
    public void switchIgnorePropErrors(Boolean r2) {
        DevToolSettings.inst().setCSSErrorIgnored(r2.booleanValue());
    }

    @LynxMethod
    public void switchLaunchRecord(Boolean r2) {
        LynxEnv.inst().enableLaunchRecord(r2.booleanValue());
    }

    @LynxMethod
    public void switchLogBox(Boolean r2) {
        LynxEnv.inst().enableLogBox(r2.booleanValue());
    }

    @LynxMethod
    public void switchLongPressMenu(Boolean r2) {
        DevToolSettings.inst().setLongPressMenuEnabled(r2.booleanValue());
    }

    @LynxMethod
    public void switchLynxDebug(Boolean r2) {
        LynxEnv.inst().enableLynxDebug(r2.booleanValue());
    }

    @LynxMethod
    public void switchPixelCopy(Boolean r2) {
        LynxEnv.inst().enablePixelCopy(r2.booleanValue());
    }

    @LynxMethod
    public void switchQuickjsCache(Boolean r2) {
        DevToolSettings.inst().setQuickJSCacheEnabled(r2.booleanValue());
    }

    @LynxMethod
    public void switchQuickjsDebug(Boolean r2) {
        DevToolSettings.inst().setQuickJSDebugEnabled(r2.booleanValue());
    }

    @LynxMethod
    public void switchV8(int r2) {
        DevToolSettings.inst().setV8Enabled(r2);
    }

    @LynxMethod
    public void invokeCdp(String r3, final Callback r4) {
        LynxBaseInspectorOwner r0 = this.mLynxContext.getBaseInspectorOwner();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.invokeCDPFromSDK(r3, new AnonymousClass1(this, r4));
    }
}
