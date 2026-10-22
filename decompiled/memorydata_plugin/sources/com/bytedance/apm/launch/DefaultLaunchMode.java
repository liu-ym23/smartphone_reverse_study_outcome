package com.bytedance.apm.launch;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum DefaultLaunchMode extends Enum<DefaultLaunchMode> {
    private static final /* synthetic */ DefaultLaunchMode[] $VALUES = null;
    public static final DefaultLaunchMode CLOD_LAUNCH = null;
    public static final DefaultLaunchMode HOT_LAUNCH = null;
    public static final DefaultLaunchMode UNKNOWN_LAUNCH = null;
    public static final DefaultLaunchMode WARM_LAUNCH = null;

    static {
        DefaultLaunchMode r0 = new DefaultLaunchMode("UNKNOWN_LAUNCH", 0);
        UNKNOWN_LAUNCH = r0;
        DefaultLaunchMode r1 = new DefaultLaunchMode("CLOD_LAUNCH", 1);
        CLOD_LAUNCH = r1;
        DefaultLaunchMode r3 = new DefaultLaunchMode("WARM_LAUNCH", 2);
        WARM_LAUNCH = r3;
        DefaultLaunchMode r5 = new DefaultLaunchMode("HOT_LAUNCH", 3);
        HOT_LAUNCH = r5;
        $VALUES = new DefaultLaunchMode[]{r0, r1, r3, r5};
    }

    private DefaultLaunchMode(String r1, int r2) {
        super(r1, r2);
    }

    public static DefaultLaunchMode valueOf(String r2) {
        return (DefaultLaunchMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(DefaultLaunchMode.class, r2), DefaultLaunchMode.class, "com.obric.memorydata.plugin");
    }

    public static DefaultLaunchMode[] values() {
        return (DefaultLaunchMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DefaultLaunchMode[].class, "com.obric.memorydata.plugin");
    }
}
