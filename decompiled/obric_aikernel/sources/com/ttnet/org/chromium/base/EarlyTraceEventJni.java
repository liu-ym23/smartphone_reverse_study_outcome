package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
@MainDex
class EarlyTraceEventJni implements EarlyTraceEvent.Natives {
    public static final JniStaticTestMocker<EarlyTraceEvent.Natives> TEST_HOOKS = null;
    private static EarlyTraceEvent.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    EarlyTraceEventJni() {
    }

    static /* synthetic */ EarlyTraceEvent.Natives access$002(EarlyTraceEvent.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static EarlyTraceEvent.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        EarlyTraceEvent.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.EarlyTraceEvent.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new EarlyTraceEventJni();
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyAsyncBeginEvent(String r10, long r11, long r12) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncBeginEvent(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyAsyncEndEvent(String r10, long r11, long r12) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncEndEvent(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyBeginEvent(String r10, long r11, int r12, long r13) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyBeginEvent(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyEndEvent(String r10, long r11, int r12, long r13) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyEndEvent(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyToplevelBeginEvent(String r10, long r11, int r12, long r13) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelBeginEvent(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyToplevelEndEvent(String r10, long r11, int r12, long r13) {
        GEN_JNI.com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelEndEvent(r10, r11, r12, r13);
    }
}
