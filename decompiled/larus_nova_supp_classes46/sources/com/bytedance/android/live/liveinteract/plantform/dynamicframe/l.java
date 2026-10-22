package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class l {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[DynamicUpdateType.values().length];
        a = r0;
        r0[DynamicUpdateType.LOAD.ordinal()] = 1;
        r0[DynamicUpdateType.UNLOAD.ordinal()] = 2;
        r0[DynamicUpdateType.LAYER_ELEMENT.ordinal()] = 3;
        r0[DynamicUpdateType.SEAT_ANIMATE.ordinal()] = 4;
        r0[DynamicUpdateType.AUDIOCHAT_STAGE.ordinal()] = 5;
        r0[DynamicUpdateType.RELOAD_LAYOUT.ordinal()] = 6;
        r0[DynamicUpdateType.SET_DYNAMIC_UI_FEATURES.ordinal()] = 7;
        r0[DynamicUpdateType.ITEM_LOAD_DURATION.ordinal()] = 8;
        r0[DynamicUpdateType.KARAOKE.ordinal()] = 9;
        r0[DynamicUpdateType.INTERACTIVE_ORDER_SONG.ordinal()] = 10;
        r0[DynamicUpdateType.UPDATE_STAGE_LYRIC_FONT_STYLE.ordinal()] = 11;
        int[] r1 = new int[DynamicGetType.values().length];
        b = r1;
        r1[DynamicGetType.LINKMIC.ordinal()] = 1;
        r1[DynamicGetType.SEAT.ordinal()] = 2;
        r1[DynamicGetType.FRAME_INFO.ordinal()] = 3;
        r1[DynamicGetType.ROOM.ordinal()] = 4;
        r1[DynamicGetType.SUBTITLE.ordinal()] = 5;
        r1[DynamicGetType.AVATAR.ordinal()] = 6;
        r1[DynamicGetType.KARAOKE.ordinal()] = 7;
        r1[DynamicGetType.INTERACTIVE_ORDER_SONG.ordinal()] = 8;
    }
}
