package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends SSettingKey<Boolean> {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
        Boolean r1 = Boolean.TRUE;
        super("ec_live_report_comment_slide_down", "上报评论区下滑埋点", r1, r1);
    }
}
