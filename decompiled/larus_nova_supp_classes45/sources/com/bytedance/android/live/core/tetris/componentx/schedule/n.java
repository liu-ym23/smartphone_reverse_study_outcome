package com.bytedance.android.live.core.tetris.componentx.schedule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class n {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[ComponentSchedulingManager.SchedueType.values().length];
        a = r0;
        ComponentSchedulingManager.SchedueType r1 = ComponentSchedulingManager.SchedueType.TOGETHER;
        r0[r1.ordinal()] = 1;
        ComponentSchedulingManager.SchedueType r2 = ComponentSchedulingManager.SchedueType.INORDER;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[ComponentSchedulingManager.ScenInfo.values().length];
        b = r3;
        r3[ComponentSchedulingManager.ScenInfo.ANCHOR.ordinal()] = 1;
        r3[ComponentSchedulingManager.ScenInfo.AUDIENCE_PORTRAIT.ordinal()] = 2;
        r3[ComponentSchedulingManager.ScenInfo.AUDIENCE_LANDSCAPE.ordinal()] = 3;
        int[] r4 = new int[ComponentSchedulingManager.SchedueType.values().length];
        c = r4;
        r4[r1.ordinal()] = 1;
        r4[r2.ordinal()] = 2;
    }
}
