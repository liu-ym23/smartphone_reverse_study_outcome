package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[DanmakuType.values().length];
        a = r0;
        r0[DanmakuType.Chat.ordinal()] = 1;
        r0[DanmakuType.Gift.ordinal()] = 2;
        int[] r1 = new int[BarrageSettingFont.values().length];
        b = r1;
        BarrageSettingFont r2 = BarrageSettingFont.BIG;
        r1[r2.ordinal()] = 1;
        BarrageSettingFont r4 = BarrageSettingFont.MID;
        r1[r4.ordinal()] = 2;
        BarrageSettingFont r5 = BarrageSettingFont.SMALL;
        r1[r5.ordinal()] = 3;
        int[] r3 = new int[BarrageSettingFont.values().length];
        c = r3;
        r3[r2.ordinal()] = 1;
        r3[r4.ordinal()] = 2;
        r3[r5.ordinal()] = 3;
    }
}
