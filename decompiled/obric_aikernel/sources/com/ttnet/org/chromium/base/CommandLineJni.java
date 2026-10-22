package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
@MainDex
class CommandLineJni implements CommandLine.Natives {
    public static final JniStaticTestMocker<CommandLine.Natives> TEST_HOOKS = null;
    private static CommandLine.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    CommandLineJni() {
    }

    static /* synthetic */ CommandLine.Natives access$002(CommandLine.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static CommandLine.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CommandLine.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.CommandLine.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new CommandLineJni();
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void appendSwitch(String r10) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_appendSwitch(r10);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void appendSwitchWithValue(String r10, String r11) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_appendSwitchWithValue(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void appendSwitchesAndArguments(String[] r10) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_appendSwitchesAndArguments(r10);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public String getSwitchValue(String r10) {
        return GEN_JNI.com_ttnet_org_chromium_base_CommandLine_getSwitchValue(r10);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public String[] getSwitchesFlattened() {
        return GEN_JNI.com_ttnet_org_chromium_base_CommandLine_getSwitchesFlattened();
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public boolean hasSwitch(String r10) {
        return GEN_JNI.com_ttnet_org_chromium_base_CommandLine_hasSwitch(r10);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void init(String[] r10) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_init(r10);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void removeSwitch(String r10) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_removeSwitch(r10);
    }
}
