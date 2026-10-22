package com.bytedance.common.wschannel.heartbeat.model;

/* JADX INFO: loaded from: classes.dex */
public final enum AppState extends Enum<AppState> {
    private static final /* synthetic */ AppState[] $VALUES = null;
    public static final AppState STATE_BACKGROUND = null;
    public static final AppState STATE_DOZE = null;
    public static final AppState STATE_FOREGROUND = null;
    public static final AppState STATE_LIGHT_DOZE = null;

    static {
        AppState r10 = new AppState("STATE_FOREGROUND", 0);
        STATE_FOREGROUND = r10;
        AppState r11 = new AppState("STATE_BACKGROUND", 1);
        STATE_BACKGROUND = r11;
        AppState r12 = new AppState("STATE_LIGHT_DOZE", 2);
        STATE_LIGHT_DOZE = r12;
        AppState r13 = new AppState("STATE_DOZE", 3);
        STATE_DOZE = r13;
        $VALUES = new AppState[]{r10, r11, r12, r13};
    }

    private AppState(String r10, int r11) {
        super(r10, r11);
    }

    public static AppState valueOf(String r10) {
        return (AppState) Enum.valueOf(AppState.class, r10);
    }

    public static AppState[] values() {
        return (AppState[]) $VALUES.clone();
    }
}
