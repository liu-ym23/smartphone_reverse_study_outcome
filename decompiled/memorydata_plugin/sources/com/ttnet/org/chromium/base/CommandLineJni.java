package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
@MainDex
class CommandLineJni implements CommandLine.Natives {
    public static final JniStaticTestMocker<CommandLine.Natives> TEST_HOOKS = null;
    private static CommandLine.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    CommandLineJni() {
    }

    static /* synthetic */ CommandLine.Natives access$002(CommandLine.Natives r2) {
        CommandLine.Natives r3 = (CommandLine.Natives) ZeusTransformUtils.wrapperContextForParams(r2, CommandLine.Natives.class, "com.obric.memorydata.plugin");
        testInstance = r3;
        return r3;
    }

    public static CommandLine.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CommandLine.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.CommandLine.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new CommandLineJni();
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void appendSwitch(String r1) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_appendSwitch(r1);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void appendSwitchWithValue(String r1, String r2) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_appendSwitchWithValue(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void appendSwitchesAndArguments(String[] r1) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_appendSwitchesAndArguments(r1);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public String getSwitchValue(String r1) {
        return GEN_JNI.com_ttnet_org_chromium_base_CommandLine_getSwitchValue(r1);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public String[] getSwitchesFlattened() {
        return GEN_JNI.com_ttnet_org_chromium_base_CommandLine_getSwitchesFlattened();
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public boolean hasSwitch(String r1) {
        return GEN_JNI.com_ttnet_org_chromium_base_CommandLine_hasSwitch(r1);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void init(String[] r1) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_init(r1);
    }

    @Override // com.ttnet.org.chromium.base.CommandLine.Natives
    public void removeSwitch(String r1) {
        GEN_JNI.com_ttnet_org_chromium_base_CommandLine_removeSwitch(r1);
    }
}
