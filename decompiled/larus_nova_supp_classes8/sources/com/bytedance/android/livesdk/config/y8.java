package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class y8 {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;

    @SerializedName("auth_icon")
    public String authIcon;

    @SerializedName("auth")
    public String authUrl;

    @SerializedName("boy_bg")
    public String boyWithBg;

    @SerializedName("girl_bg")
    public String girlWithBg;

    public y8() {
    }

    static {
        boolean r0 = tb1.c.a;
        if (r0 == true) goto L5;
        boolean r1 = tb1.c.c;
    L5:
        a = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/avatar_male.png";
        if (r0 == true) goto L8;
        boolean r2 = tb1.c.c;
    L8:
        b = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/avatar_female.png";
        if (r0 == true) goto L11;
        boolean r3 = tb1.c.c;
    L11:
        c = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_icon_ktv_avatar_agreement.png";
    }
}
