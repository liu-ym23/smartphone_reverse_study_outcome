package com.bytedance.android.live.ktv.common.midi;

import com.bytedance.android.livesdkapi.LiveCommonConstants;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;

    static {
        StringBuilder r0 = new StringBuilder("https://");
        LiveCommonConstants r2 = LiveCommonConstants.INSTANCE;
        r0.append(r2.getImageTosPath());
        r0.append("/obj/live-android/ttlive_rt_chorus_join_chorus_btn_anim_v_1.webp");
        a = r0.toString();
        b = "https://" + r2.getImageTosPath() + "/obj/live-android/ttlive_rt_chorus_join_chorus_btn_anim_v_2.webp";
        c = "https://" + r2.getImageTosPath() + "/obj/live-android/ttlive_rt_chorus_join_chorus_btn_anim_v_3.webp";
        r2.getImageTosPath();
    }
}
