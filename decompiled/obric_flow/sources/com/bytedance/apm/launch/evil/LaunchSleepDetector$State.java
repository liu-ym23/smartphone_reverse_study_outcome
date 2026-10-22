package com.bytedance.apm.launch.evil;

/* JADX INFO: loaded from: classes2.dex */
final enum LaunchSleepDetector$State extends Enum<LaunchSleepDetector$State> {
    public static final LaunchSleepDetector$State DISK_SLEEP = null;
    public static final LaunchSleepDetector$State NONE = null;
    public static final LaunchSleepDetector$State NOT_SLEEP = null;
    public static final LaunchSleepDetector$State SLEEP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LaunchSleepDetector$State[] f3894a = null;

    static {
        LaunchSleepDetector$State r5 = new LaunchSleepDetector$State("NONE", 0);
        NONE = r5;
        LaunchSleepDetector$State r10 = new LaunchSleepDetector$State("SLEEP", 1);
        SLEEP = r10;
        LaunchSleepDetector$State r11 = new LaunchSleepDetector$State("NOT_SLEEP", 2);
        NOT_SLEEP = r11;
        LaunchSleepDetector$State r12 = new LaunchSleepDetector$State("DISK_SLEEP", 3);
        DISK_SLEEP = r12;
        f3894a = new LaunchSleepDetector$State[]{r5, r10, r11, r12};
    }

    public static LaunchSleepDetector$State valueOf(String r5) {
        return (LaunchSleepDetector$State) Enum.valueOf(LaunchSleepDetector$State.class, r5);
    }

    public static LaunchSleepDetector$State[] values() {
        return (LaunchSleepDetector$State[]) f3894a.clone();
    }
}
