package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.AnimUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.LayerIndex;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.PlayModeUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.StageUpdateType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;
    public static final /* synthetic */ int[] e = null;
    public static final /* synthetic */ int[] f = null;

    static {
        int[] r0 = new int[DynamicUpdateType.values().length];
        a = r0;
        r0[DynamicUpdateType.LAYER_ELEMENT.ordinal()] = 1;
        r0[DynamicUpdateType.ANIM.ordinal()] = 2;
        int[] r1 = new int[DynamicGetType.values().length];
        b = r1;
        r1[DynamicGetType.PLAYMODE.ordinal()] = 1;
        int[] r2 = new int[LayerIndex.values().length];
        c = r2;
        r2[LayerIndex.Background.ordinal()] = 1;
        r2[LayerIndex.Seat.ordinal()] = 2;
        r2[LayerIndex.Biz.ordinal()] = 3;
        int[] r3 = new int[StageUpdateType.values().length];
        d = r3;
        r3[StageUpdateType.INSERT.ordinal()] = 1;
        r3[StageUpdateType.UPDATE.ordinal()] = 2;
        r3[StageUpdateType.REMOVE.ordinal()] = 3;
        int[] r4 = new int[AnimUpdateType.values().length];
        e = r4;
        r4[AnimUpdateType.START_WEBP_ANIM.ordinal()] = 1;
        r4[AnimUpdateType.SEAT.ordinal()] = 2;
        int[] r5 = new int[PlayModeUpdateType.values().length];
        f = r5;
        r5[PlayModeUpdateType.ADD_PLAYMODE.ordinal()] = 1;
        r5[PlayModeUpdateType.REMOVE_PLAYMODE.ordinal()] = 2;
    }
}
