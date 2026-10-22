package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ve1 extends SSettingKey<String> {
    public static final ve1 a = null;

    static {
        a = new ve1();
    }

    public ve1() {
        if (tb1.c.a == false) goto L5;
        String r0 = "https://p3.douyinpic.com/aweme-client-static-resource/ranklist_fans_club_guang.webp~tplv-obj.image";
    L6:
        super("rank_list_award_webp_light", "抖火粉丝团人气榜单王奖励动画guang_url", r0, "https://p3.douyinpic.com/aweme-client-static-resource/ranklist_fans_club_guang.webp~tplv-obj.image", false);
        return;
    L5:
        r0 = "";
        goto L6
    }
}
