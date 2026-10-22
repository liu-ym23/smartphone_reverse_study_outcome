package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class h {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[DynamicUpdateType.values().length];
        a = r0;
        r0[DynamicUpdateType.LOAD.ordinal()] = 1;
        r0[DynamicUpdateType.UNLOAD.ordinal()] = 2;
        r0[DynamicUpdateType.LAYER_ELEMENT.ordinal()] = 3;
        r0[DynamicUpdateType.ANIM.ordinal()] = 4;
        r0[DynamicUpdateType.SET_DATA.ordinal()] = 5;
        r0[DynamicUpdateType.COMMON_SET_DATA.ordinal()] = 6;
        r0[DynamicUpdateType.EFFECT.ordinal()] = 7;
        r0[DynamicUpdateType.PLAYMODE.ordinal()] = 8;
        r0[DynamicUpdateType.LOG.ordinal()] = 9;
        r0[DynamicUpdateType.CHECK_PERMISSION.ordinal()] = 10;
        r0[DynamicUpdateType.UPDATE_TRACKER.ordinal()] = 11;
        int[] r1 = new int[DynamicGetType.values().length];
        b = r1;
        r1[DynamicGetType.PLAYMODE.ordinal()] = 1;
        r1[DynamicGetType.GET_DATA.ordinal()] = 2;
        r1[DynamicGetType.COMMON_GET_DATA.ordinal()] = 3;
        r1[DynamicGetType.DRESS.ordinal()] = 4;
        r1[DynamicGetType.ENTER_INFO.ordinal()] = 5;
        r1[DynamicGetType.ROOM.ordinal()] = 6;
        r1[DynamicGetType.LIVE_STREAM_DELAY_TIME.ordinal()] = 7;
        r1[DynamicGetType.CHANNEL_INFO.ordinal()] = 8;
    }
}
