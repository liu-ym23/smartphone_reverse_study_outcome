package com.bytedance.android.livesdk.floatview.inner;

import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSwitchManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;
    public static final /* synthetic */ int[] e = null;

    static {
        int[] r0 = new int[IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType.values().length];
        a = r0;
        IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType r1 = IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType.KEEP_VOICE;
        r0[r1.ordinal()] = 1;
        IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType r2 = IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType.BG_WINDOW_SWITCH;
        r0[r2.ordinal()] = 2;
        IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType r4 = IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType.PART_SCENE_WINDOW_SWITCH;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        int[] r5 = new int[IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType.values().length];
        c = r5;
        r5[r1.ordinal()] = 1;
        r5[r2.ordinal()] = 2;
        r5[r4.ordinal()] = 3;
        int[] r6 = new int[IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType.values().length];
        d = r6;
        r6[r1.ordinal()] = 1;
        r6[r2.ordinal()] = 2;
        r6[r4.ordinal()] = 3;
        int[] r7 = new int[IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType.values().length];
        e = r7;
        r7[r2.ordinal()] = 1;
        r7[r4.ordinal()] = 2;
    }
}
