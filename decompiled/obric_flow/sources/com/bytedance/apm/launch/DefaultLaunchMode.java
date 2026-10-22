package com.bytedance.apm.launch;

/* JADX INFO: loaded from: classes2.dex */
public final enum DefaultLaunchMode extends Enum<DefaultLaunchMode> {
    public static final DefaultLaunchMode CLOD_LAUNCH = null;
    public static final DefaultLaunchMode HOT_LAUNCH = null;
    public static final DefaultLaunchMode UNKNOWN_LAUNCH = null;
    public static final DefaultLaunchMode WARM_LAUNCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DefaultLaunchMode[] f3893a = null;

    static {
        DefaultLaunchMode r5 = new DefaultLaunchMode("UNKNOWN_LAUNCH", 0);
        UNKNOWN_LAUNCH = r5;
        DefaultLaunchMode r10 = new DefaultLaunchMode("CLOD_LAUNCH", 1);
        CLOD_LAUNCH = r10;
        DefaultLaunchMode r11 = new DefaultLaunchMode("WARM_LAUNCH", 2);
        WARM_LAUNCH = r11;
        DefaultLaunchMode r12 = new DefaultLaunchMode("HOT_LAUNCH", 3);
        HOT_LAUNCH = r12;
        f3893a = new DefaultLaunchMode[]{r5, r10, r11, r12};
    }

    public static DefaultLaunchMode valueOf(String r5) {
        return (DefaultLaunchMode) Enum.valueOf(DefaultLaunchMode.class, r5);
    }

    public static DefaultLaunchMode[] values() {
        return (DefaultLaunchMode[]) f3893a.clone();
    }
}
