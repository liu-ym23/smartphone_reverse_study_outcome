package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends SSettingKey<Boolean> {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
        Boolean r1 = Boolean.TRUE;
        super("ec_live_report_comment_slide_append_component_type", "评论区滑动埋点补充挂载组件类型", r1, r1);
    }
}
