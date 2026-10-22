package com.bytedance.android.live.broadcastgame.opengame.panel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[PanelType.values().length];
        a = r0;
        PanelType r1 = PanelType.PANEL_TYPE_PORTRAIT;
        r0[r1.ordinal()] = 1;
        PanelType r2 = PanelType.PANEL_TYPE_X_SCREEN;
        r0[r2.ordinal()] = 2;
        PanelType r4 = PanelType.PANEL_TYPE_X_SCREEN_LOW;
        r0[r4.ordinal()] = 3;
        PanelType r6 = PanelType.PANEL_TYPE_LANDSCAPE;
        r0[r6.ordinal()] = 4;
        int[] r3 = new int[PanelType.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
        int[] r5 = new int[PanelType.values().length];
        c = r5;
        r5[r6.ordinal()] = 1;
        r5[r1.ordinal()] = 2;
        r5[r4.ordinal()] = 3;
        r5[r2.ordinal()] = 4;
    }
}
