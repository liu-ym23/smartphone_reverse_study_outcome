package com.obric.aiagent.assistant.utils;

/* JADX INFO: loaded from: classes2.dex */
public final enum AppEnableStatus extends Enum<AppEnableStatus> {
    private static final /* synthetic */ AppEnableStatus[] $VALUES = null;
    public static final AppEnableStatus AppDisabled = null;
    public static final AppEnableStatus Enabled = null;
    public static final AppEnableStatus NoInstalled = null;

    private static final /* synthetic */ AppEnableStatus[] $values() {
        return new AppEnableStatus[]{NoInstalled, AppDisabled, Enabled};
    }

    static {
        NoInstalled = new AppEnableStatus("NoInstalled", 0);
        AppDisabled = new AppEnableStatus("AppDisabled", 1);
        Enabled = new AppEnableStatus("Enabled", 2);
        $VALUES = $values();
    }

    private AppEnableStatus(String r10, int r11) {
        super(r10, r11);
    }

    public static AppEnableStatus valueOf(String r10) {
        return (AppEnableStatus) Enum.valueOf(AppEnableStatus.class, r10);
    }

    public static AppEnableStatus[] values() {
        return (AppEnableStatus[]) $VALUES.clone();
    }
}
