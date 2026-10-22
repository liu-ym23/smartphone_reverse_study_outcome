package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
@MainDex
class TraceEventJni implements TraceEvent.Natives {
    public static final JniStaticTestMocker<TraceEvent.Natives> TEST_HOOKS = null;
    private static TraceEvent.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    TraceEventJni() {
    }

    static /* synthetic */ TraceEvent.Natives access$002(TraceEvent.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static TraceEvent.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        TraceEvent.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.TraceEvent.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new TraceEventJni();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void addViewDump(int r10, int r11, boolean r12, boolean r13, String r14, String r15, long r16) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_addViewDump(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void begin(String r10, String r11) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_begin(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void beginToplevel(String r10) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_beginToplevel(r10);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void end(String r10, String r11) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_end(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void endToplevel(String r10) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_endToplevel(r10);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void finishAsync(String r10, long r11) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_finishAsync(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void initViewHierarchyDump() {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_initViewHierarchyDump();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void instant(String r10, String r11) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_instant(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void instantAndroidIPC(String r10, long r11) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_instantAndroidIPC(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void registerEnabledObserver() {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_registerEnabledObserver();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void setupATraceStartupTrace(String r10) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_setupATraceStartupTrace(r10);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void startATrace(String r10) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_startATrace(r10);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public long startActivityDump(String r10, long r11) {
        return GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_startActivityDump(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void startAsync(String r10, long r11) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_startAsync(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void stopATrace() {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_stopATrace();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public boolean viewHierarchyDumpEnabled() {
        return GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_viewHierarchyDumpEnabled();
    }
}
