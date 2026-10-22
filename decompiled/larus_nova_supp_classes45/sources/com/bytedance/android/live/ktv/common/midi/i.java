package com.bytedance.android.live.ktv.common.midi;

import com.bytedance.android.livesdkapi.LiveCommonConstants;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public static final String a = null;
    public static final String b = null;

    static {
        StringBuilder r0 = new StringBuilder("https://");
        LiveCommonConstants r2 = LiveCommonConstants.INSTANCE;
        r0.append(r2.getImageTosPath());
        r0.append("/obj/live-android/ttlive_real_time_chorus_operate_bg_circle_light.png");
        a = r0.toString();
        b = "https://" + r2.getImageTosPath() + "/obj/live-android/ttlive_real_time_chorus_operate_bg_circle_dark.png";
    }
}
