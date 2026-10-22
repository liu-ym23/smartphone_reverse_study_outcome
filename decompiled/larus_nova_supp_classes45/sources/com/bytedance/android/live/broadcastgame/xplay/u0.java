package com.bytedance.android.live.broadcastgame.xplay;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class u0 {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[IXplayCoreService.State.values().length];
        a = r0;
        IXplayCoreService.State r1 = IXplayCoreService.State.Running;
        r0[r1.ordinal()] = 1;
        IXplayCoreService.State r2 = IXplayCoreService.State.Loaded;
        r0[r2.ordinal()] = 2;
        IXplayCoreService.State r4 = IXplayCoreService.State.SwitchToGuide;
        r0[r4.ordinal()] = 3;
        IXplayCoreService.State r6 = IXplayCoreService.State.SwitchToHost;
        r0[r6.ordinal()] = 4;
        IXplayCoreService.State r8 = IXplayCoreService.State.Loading;
        r0[r8.ordinal()] = 5;
        IXplayCoreService.State r11 = IXplayCoreService.State.Stopped;
        r0[r11.ordinal()] = 6;
        int[] r3 = new int[IXplayCoreService.State.values().length];
        b = r3;
        r3[r2.ordinal()] = 1;
        r3[r1.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
        int[] r5 = new int[IXplayCoreService.State.values().length];
        c = r5;
        r5[r1.ordinal()] = 1;
        r5[r4.ordinal()] = 2;
        r5[r6.ordinal()] = 3;
        r5[r8.ordinal()] = 4;
        r5[r2.ordinal()] = 5;
        r5[r11.ordinal()] = 6;
    }
}
