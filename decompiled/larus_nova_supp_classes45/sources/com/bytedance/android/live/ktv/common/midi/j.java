package com.bytedance.android.live.ktv.common.midi;

import com.bytedance.android.livesdkapi.LiveCommonConstants;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;

    static {
        StringBuilder r0 = new StringBuilder("https://");
        LiveCommonConstants r2 = LiveCommonConstants.INSTANCE;
        r0.append(r2.getImageTosPath());
        r0.append("/obj/live-android/ttlive_chorus_hit_advanced_perfect_background.png");
        a = r0.toString();
        b = "https://" + r2.getImageTosPath() + "/obj/live-android/ttlive_chorus_hit_advanced_perfect.png";
        c = "https://" + r2.getImageTosPath() + "/obj/live-android/ttlive_chorus_hit_bg.png";
        d = "https://" + r2.getImageTosPath() + "/obj/live-android/ttlive_chorus_midi_right_bg.png";
        e = "https://" + r2.getImageTosPath() + "/obj/live-android/ttlive_chorus_hit_good.png";
        f = "https://" + r2.getImageTosPath() + "/obj/live-android/ttlive_chorus_hit_great.png";
        r2.getImageTosPath();
    }
}
