package com.lynx.tasm.group;

import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxColorScheme;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.behavior.f;
import com.lynx.tasm.behavior.l0;
import com.lynx.tasm.group.e;
import com.lynx.tasm.k;
import com.lynx.tasm.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class e<T extends e<T>> {
    static Float defaultDensity;
    protected com.lynx.tasm.behavior.c behaviorRegistry;
    protected LynxColorScheme colorScheme;
    protected boolean debuggable;
    protected Float densityOverride;
    protected int embeddedMode;
    protected boolean enableAirStrictMode;
    protected boolean enableAsyncHydration;
    protected boolean enableAutoConcurrency;
    protected boolean enableAutoExpose;
    protected boolean enableJSRuntime;
    protected boolean enableLayoutSafepoint;
    protected boolean enableLepusModule;
    protected boolean enableMTSModule;
    protected boolean enableMultiAsyncThread;
    protected boolean enablePendingJsTask;
    protected boolean enablePreUpdateData;
    protected boolean enableSyncFlush;
    protected boolean enableUnifiedPipeline;
    protected boolean enableVSyncAlignedMessageLoop;
    protected float fontScale;
    protected boolean forceDarkAllowed;
    protected boolean hasBehaviorRegistrySet;
    protected boolean hasColorSchemeSet;
    protected boolean hasDebuggableSet;
    protected boolean hasDensitySet;
    protected boolean hasEmbeddedModeSet;
    protected boolean hasEnableAirStrictModeSet;
    protected boolean hasEnableAsyncHydrationSet;
    protected boolean hasEnableAutoExposeSet;
    protected boolean hasEnableJSRuntimeSet;
    protected boolean hasEnableLayoutSafepointSet;
    protected boolean hasEnableLepusModuleSet;
    protected boolean hasEnableMTSModuleSet;
    protected boolean hasEnableMultiAsyncThreadSet;
    protected boolean hasEnablePreUpdateDataSet;
    protected boolean hasEnableSyncFlushSet;
    protected boolean hasEnableUnifiedPipelineSet;
    protected boolean hasEnableVSyncAlignedMessageLoopSet;
    protected boolean hasFontScaleSet;
    protected boolean hasForceDarkAllowedSet;
    protected boolean hasPendingJsTaskSet;
    protected boolean hasPresetMeasureSpec;
    protected boolean hasScreenSizeSet;
    protected boolean hasTapSlopSet;
    protected boolean hasUIRendererCreatorSet;
    protected q lynxRuntimeOptions;
    protected HashMap<String, Object> mContextData;
    protected int presetHeightMeasureSpec;
    protected int presetWidthMeasureSpec;
    protected int screenHeight;
    protected int screenWidth;
    protected String tapSlop;
    protected ThreadStrategyForRendering threadStrategy;
    protected k uiRendererCreator;

    public e() {
        this.enableMultiAsyncThread = true;
        this.hasEnableMultiAsyncThreadSet = false;
        this.hasDensitySet = false;
        this.hasBehaviorRegistrySet = false;
        this.hasEnableAutoExposeSet = false;
        this.hasEnableLayoutSafepointSet = false;
        this.hasEnableUnifiedPipelineSet = false;
        this.forceDarkAllowed = false;
        this.hasForceDarkAllowedSet = false;
        this.enableSyncFlush = false;
        this.hasEnableSyncFlushSet = false;
        this.enableAutoConcurrency = false;
        this.enableVSyncAlignedMessageLoop = false;
        this.hasEnableVSyncAlignedMessageLoopSet = false;
        this.enablePendingJsTask = false;
        this.hasPendingJsTaskSet = false;
        this.hasPresetMeasureSpec = false;
        this.enableAsyncHydration = false;
        this.hasEnableAsyncHydrationSet = false;
        this.enableJSRuntime = true;
        this.hasEnableJSRuntimeSet = false;
        this.enableAirStrictMode = false;
        this.hasEnableAirStrictModeSet = false;
        this.debuggable = false;
        this.hasDebuggableSet = false;
        this.fontScale = 1.0f;
        this.hasFontScaleSet = false;
        this.colorScheme = LynxColorScheme.LIGHT;
        this.hasColorSchemeSet = false;
        this.enablePreUpdateData = false;
        this.hasEnablePreUpdateDataSet = false;
        this.threadStrategy = null;
        this.screenWidth = -1;
        this.screenHeight = -1;
        this.hasScreenSizeSet = false;
        this.hasUIRendererCreatorSet = false;
        this.embeddedMode = 0;
        this.hasEmbeddedModeSet = false;
        this.enableMTSModule = false;
        this.hasEnableMTSModuleSet = false;
        this.enableLepusModule = true;
        this.hasEnableLepusModuleSet = false;
        this.tapSlop = "50px";
        this.hasTapSlopSet = false;
        LynxEnv.inst().lazyInitIfNeeded();
        this.lynxRuntimeOptions = new q();
        this.behaviorRegistry = new com.lynx.tasm.behavior.c(LynxEnv.inst().getBehaviorMap());
        this.uiRendererCreator = new l0();
        Float r0 = defaultDensity;
        if (r0 == null) goto L6;
        this.densityOverride = r0;
        return;
    }

    public static void setDefaultDensity(Float r0) {
        defaultDensity = r0;
    }

    public T addBehavior(com.lynx.tasm.behavior.a r2) {
        this.behaviorRegistry.a(r2);
        this.hasBehaviorRegistrySet = true;
        return this;
    }

    public T addBehaviors(List<com.lynx.tasm.behavior.a> r2) {
        this.behaviorRegistry.b(r2);
        this.hasBehaviorRegistrySet = true;
        return this;
    }

    public T enableAutoExpose(boolean r1) {
        this.enableAutoExpose = r1;
        this.hasEnableAutoExposeSet = true;
        return this;
    }

    public void registerModuleAuthValidator(LynxModule.a r2) {
        this.lynxRuntimeOptions.m = r2;
    }

    public T setBehaviors(List<com.lynx.tasm.behavior.a> r2) {
        if (r2 == null) goto L4;
        this.behaviorRegistry.b(r2);
        this.hasBehaviorRegistrySet = true;
    L4:
        return this;
    }

    public T setBytecodeSourceUrl(String r2) {
        this.lynxRuntimeOptions.b = r2;
        return this;
    }

    public T setCodeCacheSourceUrl(String r1) {
        setBytecodeSourceUrl(r1);
        return this;
    }

    public T setColorScheme(LynxColorScheme r1) {
        if (r1 != null) goto L4;
        return this;
    L4:
        this.colorScheme = r1;
        this.hasColorSchemeSet = true;
        return this;
    }

    public void setCustomBehaviorRegistry(com.lynx.tasm.behavior.c r1) {
        this.behaviorRegistry = r1;
        this.hasBehaviorRegistrySet = true;
    }

    public T setDebuggable(boolean r1) {
        this.debuggable = r1;
        this.hasDebuggableSet = true;
        return this;
    }

    public T setDensity(float r1) {
        this.densityOverride = Float.valueOf(r1);
        this.hasDensitySet = true;
        return this;
    }

    public T setEmbeddedMode(int r2) {
        this.embeddedMode = r2;
        this.hasEmbeddedModeSet = true;
        if ((r2 & 1) <= 0) goto L5;
        com.lynx.tasm.behavior.c r3 = this.behaviorRegistry;
        int r0 = f.a;
        r3.b = com.lynx.tasm.behavior.e.a;
    L5:
        return this;
    }

    public T setEnableAirStrictMode(boolean r1) {
        this.enableAirStrictMode = r1;
        this.hasEnableAirStrictModeSet = true;
        return this;
    }

    public T setEnableAsyncHydration(boolean r1) {
        this.enableAsyncHydration = r1;
        this.hasEnableAsyncHydrationSet = true;
        return this;
    }

    public T setEnableAutoConcurrency(boolean r1) {
        this.enableAutoConcurrency = r1;
        return this;
    }

    public void setEnableGenericResourceFetcher(LynxBooleanOption r2) {
        this.lynxRuntimeOptions.k = r2;
    }

    public T setEnableJSRuntime(boolean r1) {
        this.enableJSRuntime = r1;
        this.hasEnableJSRuntimeSet = true;
        return this;
    }

    public T setEnableLayoutSafepoint(boolean r1) {
        this.enableLayoutSafepoint = r1;
        this.hasEnableLayoutSafepointSet = true;
        return this;
    }

    public T setEnableLepusModule(boolean r1) {
        this.enableLepusModule = r1;
        this.hasEnableLepusModuleSet = true;
        return this;
    }

    public T setEnableMTSModule(boolean r1) {
        this.enableMTSModule = r1;
        this.hasEnableMTSModuleSet = true;
        return this;
    }

    public T setEnableMultiAsyncThread(boolean r1) {
        this.enableMultiAsyncThread = r1;
        this.hasEnableMultiAsyncThreadSet = true;
        return this;
    }

    public T setEnablePendingJsTask(boolean r1) {
        this.enablePendingJsTask = r1;
        this.hasPendingJsTaskSet = true;
        return this;
    }

    public T setEnablePreUpdateData(boolean r1) {
        this.enablePreUpdateData = r1;
        this.hasEnablePreUpdateDataSet = true;
        return this;
    }

    public T setEnableSyncFlush(boolean r1) {
        this.enableSyncFlush = r1;
        this.hasEnableSyncFlushSet = true;
        return this;
    }

    public T setEnableUnifiedPipeline(boolean r1) {
        this.enableUnifiedPipeline = r1;
        this.hasEnableUnifiedPipelineSet = true;
        return this;
    }

    public T setEnableUserBytecode(boolean r2) {
        q r0 = this.lynxRuntimeOptions;
        r0.a = Boolean.valueOf(r2);
        return this;
    }

    public T setEnableUserCodeCache(boolean r1) {
        setEnableUserBytecode(r1);
        return this;
    }

    public T setEnableVSyncAlignedMessageLoop(boolean r1) {
        this.enableVSyncAlignedMessageLoop = r1;
        this.hasEnableVSyncAlignedMessageLoopSet = true;
        return this;
    }

    public T setFontScale(float r1) {
        this.fontScale = r1;
        this.hasFontScaleSet = true;
        return this;
    }

    public T setForceDarkAllowed(boolean r1) {
        this.forceDarkAllowed = r1;
        this.hasForceDarkAllowedSet = true;
        return this;
    }

    public void setGenericResourceFetcher(f8a.a r2) {
        this.lynxRuntimeOptions.h = r2;
    }

    public T setLynxGroup(LynxGroup r2) {
        this.lynxRuntimeOptions.c = r2;
        return this;
    }

    public void setMediaResourceFetcher(g8a.a r2) {
        this.lynxRuntimeOptions.i = r2;
    }

    public T setTapSlop(String r1) {
        this.tapSlop = r1;
        this.hasTapSlopSet = true;
        return this;
    }

    public void setTemplateResourceFetcher(h8a.a r2) {
        this.lynxRuntimeOptions.j = r2;
    }

    public T setThreadStrategyForRendering(ThreadStrategyForRendering r1) {
        if (r1 == null) goto L4;
        this.threadStrategy = r1;
    L4:
        return this;
    }

    public T setUIRendererCreator(k r1) {
        this.uiRendererCreator = r1;
        this.hasUIRendererCreatorSet = true;
        return this;
    }

    public T setUIRunningMode(boolean r1) {
        if (r1 == false) goto L4;
        this.threadStrategy = ThreadStrategyForRendering.ALL_ON_UI;
    L5:
        return this;
    L4:
        this.threadStrategy = ThreadStrategyForRendering.PART_ON_LAYOUT;
        goto L5
    }

    public T registerContextData(String r2, Object r3) {
        if (this.mContextData != null) goto L5;
        this.mContextData = new HashMap();
    L5:
        this.mContextData.put(r2, r3);
        return this;
    }

    public void registerModule(String r2, Class<? extends LynxModule> r3) {
        registerModule(r2, r3, null);
    }

    public T setPresetMeasuredSpec(int r1, int r2) {
        this.presetHeightMeasureSpec = r2;
        this.presetWidthMeasureSpec = r1;
        this.hasPresetMeasureSpec = true;
        return this;
    }

    public T setResourceProvider(String r2, d8a.k r3) {
        ((HashMap) this.lynxRuntimeOptions.e).put(r2, r3);
        return this;
    }

    public T setScreenSize(int r1, int r2) {
        this.screenWidth = r1;
        this.screenHeight = r2;
        this.hasScreenSizeSet = true;
        return this;
    }

    public void registerModule(String r3, Class<? extends LynxModule> r4, Object r5) {
        q r0 = this.lynxRuntimeOptions;
        r0.getClass();
        com.lynx.jsbridge.f r1 = new com.lynx.jsbridge.f();
        r1.b = r4;
        r1.c = r5;
        r1.a = r3;
        ((ArrayList) r0.d).add(r1);
    }
}
