package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z extends SettingKey<Boolean> {
    public static final z a = null;

    static {
        a = new z();
    }

    public z() {
        Boolean r1 = Boolean.FALSE;
        super("live_fix_comment_report_scope", "修复评论举报的范围开关", r1, r1);
    }
}
