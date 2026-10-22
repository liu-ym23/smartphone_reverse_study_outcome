package com.ss.android.lark.passport.signinsdk_api.debug;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum MockModeUserEnvRefine extends Enum<MockModeUserEnvRefine> {
    public static final /* synthetic */ MockModeUserEnvRefine[] a = null;
    public static final MockModeUserEnvRefine failForApplogDomain = null;
    public static final MockModeUserEnvRefine failForFetchDidByUnit = null;
    public static final MockModeUserEnvRefine failForRustOffline = null;
    public static final MockModeUserEnvRefine failForRustOnline = null;
    public static final MockModeUserEnvRefine failForRustSetDeviceInfo = null;
    public static final MockModeUserEnvRefine failForRustSetEnv = null;
    public static final MockModeUserEnvRefine failForSwitchIdentify = null;

    static {
        MockModeUserEnvRefine r0 = new MockModeUserEnvRefine("failForApplogDomain", 0);
        failForApplogDomain = r0;
        MockModeUserEnvRefine r1 = new MockModeUserEnvRefine("failForFetchDidByUnit", 1);
        failForFetchDidByUnit = r1;
        MockModeUserEnvRefine r3 = new MockModeUserEnvRefine("failForSwitchIdentify", 2);
        failForSwitchIdentify = r3;
        MockModeUserEnvRefine r5 = new MockModeUserEnvRefine("failForRustOffline", 3);
        failForRustOffline = r5;
        MockModeUserEnvRefine r7 = new MockModeUserEnvRefine("failForRustSetEnv", 4);
        failForRustSetEnv = r7;
        MockModeUserEnvRefine r9 = new MockModeUserEnvRefine("failForRustSetDeviceInfo", 5);
        failForRustSetDeviceInfo = r9;
        MockModeUserEnvRefine r11 = new MockModeUserEnvRefine("failForRustOnline", 6);
        failForRustOnline = r11;
        a = new MockModeUserEnvRefine[]{r0, r1, r3, r5, r7, r9, r11};
    }

    public static MockModeUserEnvRefine[] values() {
        return (MockModeUserEnvRefine[]) a.clone();
    }

    public static MockModeUserEnvRefine valueOf(String r1) {
        return (MockModeUserEnvRefine) a.a(MockModeUserEnvRefine.class, r1);
    }

    public MockModeUserEnvRefine(String r1, int r2) {
        super(r1, r2);
    }
}
