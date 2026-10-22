package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends SSettingKey<Boolean> {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
        Boolean r1 = Boolean.TRUE;
        super("ec_live_report_click_comment_message_hint", "上报评论区x 条新消息埋点", r1, r1);
    }
}
