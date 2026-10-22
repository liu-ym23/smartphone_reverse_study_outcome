package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[DynamicUpdateType.values().length];
        a = r0;
        r0[DynamicUpdateType.SUBTITLE.ordinal()] = 1;
        r0[DynamicUpdateType.AUDIO_ASR.ordinal()] = 2;
        r0[DynamicUpdateType.COMMON_SET_DATA.ordinal()] = 3;
        int[] r1 = new int[DynamicGetType.values().length];
        b = r1;
        r1[DynamicGetType.COMMON_GET_DATA.ordinal()] = 1;
    }
}
