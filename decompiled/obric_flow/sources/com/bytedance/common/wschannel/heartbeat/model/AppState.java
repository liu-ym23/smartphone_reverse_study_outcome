package com.bytedance.common.wschannel.heartbeat.model;

/* JADX INFO: loaded from: classes2.dex */
public final enum AppState extends Enum<AppState> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppState f3985a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AppState f3986b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AppState[] f3987c = null;

    static {
        AppState r5 = new AppState("STATE_FOREGROUND", 0);
        f3985a = r5;
        AppState r10 = new AppState("STATE_BACKGROUND", 1);
        f3986b = r10;
        f3987c = new AppState[]{r5, r10, new AppState("STATE_LIGHT_DOZE", 2), new AppState("STATE_DOZE", 3)};
    }

    public AppState(String r5, int r10) {
        super(r5, r10);
    }

    public static AppState valueOf(String r5) {
        return (AppState) Enum.valueOf(AppState.class, r5);
    }

    public static AppState[] values() {
        return (AppState[]) f3987c.clone();
    }
}
