package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[XplayFloatWindowView.ViewState.values().length];
        a = r0;
        XplayFloatWindowView.ViewState r1 = XplayFloatWindowView.ViewState.InteractiveExpanded;
        r0[r1.ordinal()] = 1;
        XplayFloatWindowView.ViewState r2 = XplayFloatWindowView.ViewState.InteractiveCollapsed;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[XplayFloatWindowView.ViewState.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[XplayFloatWindowView.ViewState.NonInteractive.ordinal()] = 3;
    }
}
