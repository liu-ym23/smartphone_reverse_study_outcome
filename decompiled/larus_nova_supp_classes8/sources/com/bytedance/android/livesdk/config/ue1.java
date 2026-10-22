package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ue1 extends SSettingKey<String> {
    public static final ue1 a = null;

    static {
        a = new ue1();
    }

    public ue1() {
        if (tb1.c.a == false) goto L5;
        String r0 = "https://p3.douyinpic.com/aweme-client-static-resource/ranklist_fans_club_di.webp~tplv-obj.image";
    L6:
        super("rank_list_award_webp_di", "抖火粉丝团人气榜单王奖励动画di_url", r0, "https://p3.douyinpic.com/aweme-client-static-resource/ranklist_fans_club_di.webp~tplv-obj.image", false);
        return;
    L5:
        r0 = "";
        goto L6
    }
}
