package com.lynx.tasm;

import android.content.Context;
import android.net.Uri;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.ILynxTrailServiceExtension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxViewBuilder extends com.lynx.tasm.group.e<LynxViewBuilder> implements com.lynx.tasm.group.b {
    boolean enableLayoutOnly;
    k7a.a fetcher;
    w7a.a.b fontLoader;
    boolean hasInheritedGroupRuntimeOptions;
    v7a.h imageFetcher;
    LynxBackgroundRuntime lynxBackgroundRuntime;
    Object lynxModuleExtraData;
    Map<String, String> lynxViewConfig;
    com.lynx.tasm.group.c lynxViewGroup;
    Map<String, String> mImageCustomParam;
    u7a.h mLynxImageConfig;
    d8a.j resourceFetcher;
    d8a.b templateProvider;
    Uri uri;

    public u7a.h getLynxImageConfig() {
        return null;
    }

    public boolean isEnableAutoConcurrency() {
        return false;
    }

    public LynxViewBuilder setEnableCreateViewAsync(boolean r1) {
        return this;
    }

    public LynxViewBuilder setEnableLayoutOnly(boolean r1) {
        return this;
    }

    public LynxViewBuilder setEnableRadonCompatible(boolean r1) {
        return this;
    }

    public LynxViewBuilder setImageFetcher(v7a.h r1) {
        return this;
    }

    public LynxViewBuilder setLynxImageConfig(u7a.h r1) {
        return this;
    }

    public LynxViewBuilder setResourceFetcher(d8a.j r1) {
        return this;
    }

    private void inheritLynxViewGroupRuntimeOptions() {
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.hasInheritedGroupRuntimeOptions == true) goto L66;
        q r1 = r0.getLynxRuntimeOptions();
        q r2 = this.lynxRuntimeOptions;
        r2.getClass();
        if (r1 == null) goto L58;
        if (r1 == r2) goto L58;
        List<com.lynx.jsbridge.f> r3 = r2.d;
        ArrayList r4 = (ArrayList) r3;
        r4.addAll(0, r1.d);
        Iterator r5 = ((HashMap) r1.e).entrySet().iterator();
    L13:
        if (r5.hasNext() == false) goto L18;
        Map.Entry r6 = (Map.Entry) r5.next();
        Map<String, d8a.k> r7 = r2.e;
        HashMap r8 = (HashMap) r7;
        if (r8.containsKey(r6.getKey()) == true) goto L13;
        Map<String, d8a.k> r9 = r2.e;
        HashMap r10 = (HashMap) r9;
        r10.put(r6.getKey(), r6.getValue());
        goto L13
    L18:
        if (r2.c != null) goto L21;
        r2.c = r1.c;
    L21:
        if (r2.a != null) goto L26;
        Boolean r11 = r1.a;
        if (r11 == null) goto L26;
        r2.a = r11;
    L26:
        if (r2.b != null) goto L29;
        r2.b = r1.b;
    L29:
        if (r2.l != null) goto L34;
        Boolean r12 = r1.l;
        if (r12 == null) goto L34;
        r2.l = r12;
    L34:
        if (r2.f != null) goto L37;
        r2.f = r1.f;
    L37:
        if (r2.g != null) goto L40;
        r2.g = r1.g;
    L40:
        if (r2.m != null) goto L43;
        r2.m = r1.m;
    L43:
        if (r2.k != LynxBooleanOption.UNSET) goto L45;
        r2.k = r1.k;
    L45:
        f8a.a r13 = r2.h;
        if (r13 != null) goto L49;
        r13 = r1.h;
    L49:
        r2.h = r13;
        g8a.a r14 = r2.i;
        if (r14 != null) goto L53;
        r14 = r1.i;
    L53:
        r2.i = r14;
        h8a.a r15 = r2.j;
        if (r15 != null) goto L57;
        r15 = r1.j;
    L57:
        r2.j = r15;
    L58:
        this.hasInheritedGroupRuntimeOptions = true;
        return;
    }

    @Override // com.lynx.tasm.group.b
    public com.lynx.tasm.behavior.c getBehaviorRegistry() {
        if (this.hasBehaviorRegistrySet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.getBehaviorRegistry();
    L8:
        return this.behaviorRegistry;
    }

    @Override // com.lynx.tasm.group.b
    public LynxColorScheme getColorScheme() {
        if (this.hasColorSchemeSet == true) goto L5;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L11;
        return r0.getColorScheme();
    L11:
        return LynxColorScheme.LIGHT;
    L5:
        return this.colorScheme;
    }

    @Override // com.lynx.tasm.group.b
    public HashMap getContextData() {
        HashMap<String, Object> r0 = this.mContextData;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.lynx.tasm.group.c r1 = this.lynxViewGroup;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getContextData();
    }

    @Override // com.lynx.tasm.group.b
    public Float getDensity() {
        if (this.hasDensitySet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.getDensity();
    L8:
        return this.densityOverride;
    }

    @Override // com.lynx.tasm.group.b
    public int getEmbeddedMode() {
        if (this.hasEmbeddedModeSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.getEmbeddedMode();
    L8:
        return this.embeddedMode;
    }

    @Override // com.lynx.tasm.group.b
    public float getFontScale() {
        if (this.hasFontScaleSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.getFontScale();
    L8:
        return this.fontScale;
    }

    @Override // com.lynx.tasm.group.b
    public boolean getForceDarkAllowed() {
        if (this.hasForceDarkAllowedSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.getForceDarkAllowed();
    L8:
        return this.forceDarkAllowed;
    }

    @Override // com.lynx.tasm.group.b
    public j getLogicExecutor() {
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L5;
        r0.getLogicExecutor();
    L5:
        return null;
    }

    @Override // com.lynx.tasm.group.b
    public f8a.a getLynxGenericResourceFetcher() {
        f8a.a r0 = this.lynxRuntimeOptions.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.lynx.tasm.group.c r1 = this.lynxViewGroup;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getLynxGenericResourceFetcher();
    }

    @Override // com.lynx.tasm.group.b
    public LynxGroup getLynxGroup() {
        LynxGroup r0 = this.lynxRuntimeOptions.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.lynx.tasm.group.c r1 = this.lynxViewGroup;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getLynxGroup();
    }

    @Override // com.lynx.tasm.group.b
    public g8a.a getLynxMediaResourceFetcher() {
        g8a.a r0 = this.lynxRuntimeOptions.i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.lynx.tasm.group.c r1 = this.lynxViewGroup;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getLynxMediaResourceFetcher();
    }

    @Override // com.lynx.tasm.group.b
    public h8a.a getLynxTemplateResourceFetcher() {
        h8a.a r0 = this.lynxRuntimeOptions.j;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.lynx.tasm.group.c r1 = this.lynxViewGroup;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getLynxTemplateResourceFetcher();
    }

    @Override // com.lynx.tasm.group.b
    public int getPresetHeightMeasureSpec() {
        if (this.hasPresetMeasureSpec == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.getPresetHeightMeasureSpec();
    L8:
        return this.presetHeightMeasureSpec;
    }

    @Override // com.lynx.tasm.group.b
    public int getPresetWidthMeasureSpec() {
        if (this.hasPresetMeasureSpec == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.getPresetWidthMeasureSpec();
    L8:
        return this.presetWidthMeasureSpec;
    }

    @Override // com.lynx.tasm.group.b
    public int getScreenHeight() {
        if (this.hasScreenSizeSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.getScreenHeight();
    L8:
        return this.screenHeight;
    }

    @Override // com.lynx.tasm.group.b
    public int getScreenWidth() {
        if (this.hasScreenSizeSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.getScreenWidth();
    L8:
        return this.screenWidth;
    }

    @Override // com.lynx.tasm.group.b
    public String getTapSlop() {
        if (this.hasTapSlopSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.getTapSlop();
    L8:
        return this.tapSlop;
    }

    @Override // com.lynx.tasm.group.b
    public ThreadStrategyForRendering getThreadStrategy() {
        ThreadStrategyForRendering r0 = this.threadStrategy;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.lynx.tasm.group.c r1 = this.lynxViewGroup;
        if (r1 == null) goto L10;
        return r1.getThreadStrategy();
    L10:
        return ThreadStrategyForRendering.ALL_ON_UI;
    }

    @Override // com.lynx.tasm.group.b
    public k getUIRendererCreator() {
        if (this.hasUIRendererCreatorSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.getUIRendererCreator();
    L8:
        return this.uiRendererCreator;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isDebuggable() {
        if (this.hasDebuggableSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.isDebuggable();
    L8:
        return this.debuggable;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableAirStrictMode() {
        if (this.hasEnableAirStrictModeSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.isEnableAirStrictMode();
    L8:
        return this.enableAirStrictMode;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableAsyncHydration() {
        if (this.hasEnableAsyncHydrationSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.isEnableAsyncHydration();
    L8:
        return this.enableAsyncHydration;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableAutoExpose() {
        if (this.hasEnableAutoExposeSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.isEnableAutoExpose();
    L8:
        return this.enableAutoExpose;
    }

    @Override // com.lynx.tasm.group.b
    public LynxBooleanOption isEnableGenericResourceFetcher() {
        LynxBooleanOption r0 = this.lynxRuntimeOptions.k;
        if (r0 == LynxBooleanOption.UNSET) goto L5;
        return r0;
    L5:
        com.lynx.tasm.group.c r1 = this.lynxViewGroup;
        if (r1 != null) goto L8;
        return r0;
    L8:
        return r1.isEnableGenericResourceFetcher();
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableLayoutSafepoint() {
        if (this.hasEnableLayoutSafepointSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.isEnableLayoutSafepoint();
    L8:
        return this.enableLayoutSafepoint;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableLepusModule() {
        if (this.hasEnableLepusModuleSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.isEnableLepusModule();
    L8:
        return this.enableLepusModule;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableMTSModule() {
        if (this.hasEnableMTSModuleSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.isEnableMTSModule();
    L8:
        return this.enableMTSModule;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableMultiAsyncThread() {
        if (this.hasEnableMultiAsyncThreadSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.isEnableMultiAsyncThread();
    L8:
        return this.enableMultiAsyncThread;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnablePendingJsTask() {
        if (this.hasPendingJsTaskSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.isEnablePendingJsTask();
    L8:
        return this.enablePendingJsTask;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnablePreUpdateData() {
        if (this.hasEnablePreUpdateDataSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.isEnablePreUpdateData();
    L8:
        return this.enablePreUpdateData;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableSyncFlush() {
        if (this.hasEnableSyncFlushSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.isEnableSyncFlush();
    L8:
        return this.enableSyncFlush;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableUnifiedPipeline() {
        if (this.hasEnableUnifiedPipelineSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.isEnableUnifiedPipeline();
    L8:
        return this.enableUnifiedPipeline;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableVSyncAlignedMessageLoop() {
        if (this.hasEnableVSyncAlignedMessageLoopSet == true) goto L8;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L8;
        return r0.isEnableVSyncAlignedMessageLoop();
    L8:
        return this.enableVSyncAlignedMessageLoop;
    }

    public LynxViewBuilder() {
        this.enableLayoutOnly = LynxEnv.inst().isLayoutOnlyEnabled();
        this.uri = null;
        this.hasInheritedGroupRuntimeOptions = false;
        LynxEnv.inst().lazyInitIfNeeded();
        this.templateProvider = LynxEnv.inst().getTemplateProvider();
    }

    public ILynxUIRenderer createLynxUIRenderer() {
        ((com.lynx.tasm.behavior.l0) getUIRendererCreator()).getClass();
        LynxUIRenderer r0 = new LynxUIRenderer();
        setThreadStrategyForRendering(getThreadStrategy());
        return r0;
    }

    @Override // com.lynx.tasm.group.b
    public q getLynxRuntimeOptions() {
        inheritLynxViewGroupRuntimeOptions();
        return this.lynxRuntimeOptions;
    }

    @Override // com.lynx.tasm.group.b
    public boolean isEnableJSRuntime() {
        if (isEnableAirStrictMode() == false) goto L7;
        return false;
    L7:
        if (this.hasEnableJSRuntimeSet == true) goto L12;
        com.lynx.tasm.group.c r0 = this.lynxViewGroup;
        if (r0 == null) goto L12;
        return r0.isEnableJSRuntime();
    L12:
        return this.enableJSRuntime;
    }

    public Map<String, String> getLynxViewConfig() {
        return this.lynxViewConfig;
    }

    public Uri getUri() {
        return this.uri;
    }

    @Override // com.lynx.tasm.group.b
    public boolean hasPresetMeasureSpec() {
        return this.hasPresetMeasureSpec;
    }

    public LynxViewBuilder(Context r1) {
        this();
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder addBehavior(com.lynx.tasm.behavior.a r1) {
        return (LynxViewBuilder) super.addBehavior(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder addBehaviors(List<com.lynx.tasm.behavior.a> r1) {
        return (LynxViewBuilder) super.addBehaviors(r1);
    }

    public LynxView build(Context r5) {
        TraceEvent.beginSection("CreateLynxView");
        ILynxTrailService r1 = (ILynxTrailService) i8a.n.c().a(ILynxTrailService.class);
        if ((r1 instanceof ILynxTrailServiceExtension) == false) goto L5;
        ((ILynxTrailServiceExtension) r1).parseLynxViewBuilder(this);
    L5:
        LynxView r2 = new LynxView(r5, this);
        if (TraceEvent.enableTrace() == false) goto L11;
        HashMap r6 = new HashMap();
        if (r2.getLynxContext() == null) goto L10;
        r6.put("instance_id", String.valueOf(r2.getLynxContext().getInstanceId()));
    L10:
        TraceEvent.endSection(0, "CreateLynxView", r6);
    L11:
        return r2;
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder enableAutoExpose(boolean r1) {
        return (LynxViewBuilder) super.enableAutoExpose(r1);
    }

    public LynxViewBuilder mergeLynxRuntimeOptions(q r2) {
        q r0 = getLynxRuntimeOptions();
        if (r0 == null) goto L5;
        r0.b(r2);
    L5:
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public void registerModuleAuthValidator(LynxModule.a r1) {
        super.registerModuleAuthValidator(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setBytecodeSourceUrl(String r1) {
        return (LynxViewBuilder) super.setBytecodeSourceUrl(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setCodeCacheSourceUrl(String r1) {
        return (LynxViewBuilder) super.setCodeCacheSourceUrl(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setColorScheme(LynxColorScheme r1) {
        return (LynxViewBuilder) super.setColorScheme(r1);
    }

    @Override // com.lynx.tasm.group.e
    public void setCustomBehaviorRegistry(com.lynx.tasm.behavior.c r1) {
        super.setCustomBehaviorRegistry(r1);
    }

    public LynxViewBuilder setDynamicComponentFetcher(k7a.a r1) {
        this.fetcher = r1;
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableAirStrictMode(boolean r1) {
        return (LynxViewBuilder) super.setEnableAirStrictMode(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableAutoConcurrency(boolean r1) {
        return (LynxViewBuilder) super.setEnableAutoConcurrency(r1);
    }

    @Override // com.lynx.tasm.group.e
    public void setEnableGenericResourceFetcher(LynxBooleanOption r1) {
        super.setEnableGenericResourceFetcher(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableJSRuntime(boolean r1) {
        return (LynxViewBuilder) super.setEnableJSRuntime(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableLayoutSafepoint(boolean r1) {
        return (LynxViewBuilder) super.setEnableLayoutSafepoint(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableMultiAsyncThread(boolean r1) {
        return (LynxViewBuilder) super.setEnableMultiAsyncThread(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnablePendingJsTask(boolean r1) {
        return (LynxViewBuilder) super.setEnablePendingJsTask(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnablePreUpdateData(boolean r1) {
        return (LynxViewBuilder) super.setEnablePreUpdateData(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableSyncFlush(boolean r1) {
        return (LynxViewBuilder) super.setEnableSyncFlush(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableUserBytecode(boolean r1) {
        return (LynxViewBuilder) super.setEnableUserBytecode(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableUserCodeCache(boolean r1) {
        return (LynxViewBuilder) super.setEnableUserCodeCache(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setEnableVSyncAlignedMessageLoop(boolean r1) {
        return (LynxViewBuilder) super.setEnableVSyncAlignedMessageLoop(r1);
    }

    public LynxViewBuilder setFontLoader(w7a.a.b r1) {
        this.fontLoader = r1;
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setFontScale(float r1) {
        return (LynxViewBuilder) super.setFontScale(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setForceDarkAllowed(boolean r1) {
        return (LynxViewBuilder) super.setForceDarkAllowed(r1);
    }

    @Override // com.lynx.tasm.group.e
    public void setGenericResourceFetcher(f8a.a r1) {
        super.setGenericResourceFetcher(r1);
    }

    public LynxViewBuilder setImageCustomParam(Map<String, String> r1) {
        this.mImageCustomParam = r1;
        return this;
    }

    public LynxViewBuilder setLynxBackgroundRuntime(LynxBackgroundRuntime r1) {
        this.lynxBackgroundRuntime = r1;
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setLynxGroup(LynxGroup r1) {
        return (LynxViewBuilder) super.setLynxGroup(r1);
    }

    public LynxViewBuilder setLynxModuleExtraData(Object r1) {
        this.lynxModuleExtraData = r1;
        return this;
    }

    public LynxViewBuilder setLynxViewConfig(Map<String, String> r1) {
        this.lynxViewConfig = r1;
        return this;
    }

    public LynxViewBuilder setLynxViewGroup(com.lynx.tasm.group.c r1) {
        this.lynxViewGroup = r1;
        this.hasInheritedGroupRuntimeOptions = false;
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public void setMediaResourceFetcher(g8a.a r1) {
        super.setMediaResourceFetcher(r1);
    }

    public LynxViewBuilder setTemplateProvider(d8a.b r1) {
        this.templateProvider = r1;
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public void setTemplateResourceFetcher(h8a.a r1) {
        super.setTemplateResourceFetcher(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setThreadStrategyForRendering(ThreadStrategyForRendering r1) {
        return (LynxViewBuilder) super.setThreadStrategyForRendering(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setUIRunningMode(boolean r1) {
        return setUIRunningMode(r1);
    }

    public LynxViewBuilder setUri(Uri r1) {
        this.uri = r1;
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e addBehavior(com.lynx.tasm.behavior.a r1) {
        return addBehavior(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e addBehaviors(List r1) {
        return addBehaviors(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e enableAutoExpose(boolean r1) {
        return enableAutoExpose(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setBytecodeSourceUrl(String r1) {
        return setBytecodeSourceUrl(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setCodeCacheSourceUrl(String r1) {
        return setCodeCacheSourceUrl(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setColorScheme(LynxColorScheme r1) {
        return setColorScheme(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableAirStrictMode(boolean r1) {
        return setEnableAirStrictMode(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableAutoConcurrency(boolean r1) {
        return setEnableAutoConcurrency(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableJSRuntime(boolean r1) {
        return setEnableJSRuntime(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableLayoutSafepoint(boolean r1) {
        return setEnableLayoutSafepoint(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableMultiAsyncThread(boolean r1) {
        return setEnableMultiAsyncThread(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnablePendingJsTask(boolean r1) {
        return setEnablePendingJsTask(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnablePreUpdateData(boolean r1) {
        return setEnablePreUpdateData(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableSyncFlush(boolean r1) {
        return setEnableSyncFlush(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableUserBytecode(boolean r1) {
        return setEnableUserBytecode(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableUserCodeCache(boolean r1) {
        return setEnableUserCodeCache(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setEnableVSyncAlignedMessageLoop(boolean r1) {
        return setEnableVSyncAlignedMessageLoop(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setFontScale(float r1) {
        return setFontScale(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setForceDarkAllowed(boolean r1) {
        return setForceDarkAllowed(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setLynxGroup(LynxGroup r1) {
        return setLynxGroup(r1);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setThreadStrategyForRendering(ThreadStrategyForRendering r1) {
        return setThreadStrategyForRendering(r1);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setUIRunningMode(boolean r1) {
        super.setUIRunningMode(r1);
        return this;
    }

    public LynxViewBuilder insertLynxViewConfig(String r2, String r3) {
        if (this.lynxViewConfig != null) goto L6;
        this.lynxViewConfig = new HashMap();
    L6:
        if (this.lynxViewConfig.get(r2) != null) goto L8;
        this.lynxViewConfig.put(r2, r3);
    L8:
        return this;
    }

    @Override // com.lynx.tasm.group.e
    public void registerModule(String r1, Class<? extends LynxModule> r2) {
        super.registerModule(r1, r2);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setPresetMeasuredSpec(int r1, int r2) {
        return (LynxViewBuilder) super.setPresetMeasuredSpec(r1, r2);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setResourceProvider(String r1, d8a.k r2) {
        return (LynxViewBuilder) super.setResourceProvider(r1, r2);
    }

    @Override // com.lynx.tasm.group.e
    public LynxViewBuilder setScreenSize(int r1, int r2) {
        return (LynxViewBuilder) super.setScreenSize(r1, r2);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setPresetMeasuredSpec(int r1, int r2) {
        return setPresetMeasuredSpec(r1, r2);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setResourceProvider(String r1, d8a.k r2) {
        return setResourceProvider(r1, r2);
    }

    @Override // com.lynx.tasm.group.e
    public /* bridge */ /* synthetic */ com.lynx.tasm.group.e setScreenSize(int r1, int r2) {
        return setScreenSize(r1, r2);
    }

    @Override // com.lynx.tasm.group.e
    public void registerModule(String r1, Class<? extends LynxModule> r2, Object r3) {
        super.registerModule(r1, r2, r3);
    }
}
