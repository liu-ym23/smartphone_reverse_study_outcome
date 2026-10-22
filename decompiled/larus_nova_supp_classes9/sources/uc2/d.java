package uc2;

import com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.IHeatChangeController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[IHeatChangeController.DanmakuHeat.values().length];
        a = r0;
        IHeatChangeController.DanmakuHeat r1 = IHeatChangeController.DanmakuHeat.LOW;
        r0[r1.ordinal()] = 1;
        IHeatChangeController.DanmakuHeat r2 = IHeatChangeController.DanmakuHeat.MEDIUM;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[IHeatChangeController.DanmakuHeat.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        IHeatChangeController.DanmakuHeat r4 = IHeatChangeController.DanmakuHeat.HIGH;
        r3[r4.ordinal()] = 3;
        IHeatChangeController.DanmakuHeat r6 = IHeatChangeController.DanmakuHeat.HIGH_MAX;
        r3[r6.ordinal()] = 4;
        int[] r5 = new int[IHeatChangeController.DanmakuHeat.values().length];
        c = r5;
        r5[r1.ordinal()] = 1;
        r5[r2.ordinal()] = 2;
        r5[r4.ordinal()] = 3;
        r5[r6.ordinal()] = 4;
    }
}
