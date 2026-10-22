package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m0 extends SSettingKey<Boolean> {
    public static final m0 a = null;

    static {
        a = new m0();
    }

    public m0() {
        Boolean r1 = Boolean.FALSE;
        super("live_interaction_msg_click_need_filter_room", "是否屏蔽部分直播间", r1, r1);
    }
}
