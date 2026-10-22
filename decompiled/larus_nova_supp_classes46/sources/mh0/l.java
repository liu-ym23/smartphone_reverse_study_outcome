package mh0;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class l {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[DynamicUpdateType.values().length];
        a = r0;
        r0[DynamicUpdateType.RELOAD_LAYOUT.ordinal()] = 1;
        r0[DynamicUpdateType.ITEM_LOAD_DURATION.ordinal()] = 2;
        r0[DynamicUpdateType.SET_DYNAMIC_UI_FEATURES.ordinal()] = 3;
        int[] r1 = new int[DynamicGetType.values().length];
        b = r1;
        r1[DynamicGetType.LINKMIC.ordinal()] = 1;
        r1[DynamicGetType.SEAT.ordinal()] = 2;
        r1[DynamicGetType.FRAME_INFO.ordinal()] = 3;
    }
}
