package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.LayerIndex;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.StageUpdateType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class m {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[DynamicUpdateType.values().length];
        a = r0;
        r0[DynamicUpdateType.LAYER_ELEMENT.ordinal()] = 1;
        int[] r1 = new int[LayerIndex.values().length];
        b = r1;
        r1[LayerIndex.Background.ordinal()] = 1;
        r1[LayerIndex.Seat.ordinal()] = 2;
        r1[LayerIndex.Biz.ordinal()] = 3;
        int[] r2 = new int[StageUpdateType.values().length];
        c = r2;
        r2[StageUpdateType.INSERT.ordinal()] = 1;
        r2[StageUpdateType.REMOVE.ordinal()] = 2;
        r2[StageUpdateType.UPDATE.ordinal()] = 3;
    }
}
