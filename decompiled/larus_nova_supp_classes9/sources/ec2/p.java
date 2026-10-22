package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p extends SettingKey<Integer> {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
        super("ttlive_comment_fold_opt_enabled_scroll_speed", "折叠优化开了之后的滚动速度配置", 550, 550);
    }
}
