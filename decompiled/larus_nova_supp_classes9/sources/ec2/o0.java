package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o0 extends SSettingKey<Boolean> {
    public static final o0 a = null;

    static {
        a = new o0();
    }

    public o0() {
        Boolean r1 = Boolean.TRUE;
        super("live_interaction_msg_show_mob_enable", "公屏关注分享加入粉丝团是否上报独立show埋点", r1, r1);
    }
}
