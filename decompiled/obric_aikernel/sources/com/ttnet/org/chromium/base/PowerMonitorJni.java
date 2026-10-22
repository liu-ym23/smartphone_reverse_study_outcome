package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class PowerMonitorJni implements PowerMonitor.Natives {
    public static final JniStaticTestMocker<PowerMonitor.Natives> TEST_HOOKS = null;
    private static PowerMonitor.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    PowerMonitorJni() {
    }

    static /* synthetic */ PowerMonitor.Natives access$002(PowerMonitor.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static PowerMonitor.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        PowerMonitor.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.PowerMonitor.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new PowerMonitorJni();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.Natives
    public void onBatteryChargingChanged() {
        GEN_JNI.com_ttnet_org_chromium_base_PowerMonitor_onBatteryChargingChanged();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.Natives
    public void onInstantResume() {
        GEN_JNI.com_ttnet_org_chromium_base_PowerMonitor_onInstantResume();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.Natives
    public void onInstantSuspend() {
        GEN_JNI.com_ttnet_org_chromium_base_PowerMonitor_onInstantSuspend();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.Natives
    public void onResume() {
        GEN_JNI.com_ttnet_org_chromium_base_PowerMonitor_onResume();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.Natives
    public void onSuspend() {
        GEN_JNI.com_ttnet_org_chromium_base_PowerMonitor_onSuspend();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.Natives
    public void onThermalStatusChanged(int r10) {
        GEN_JNI.com_ttnet_org_chromium_base_PowerMonitor_onThermalStatusChanged(r10);
    }
}
