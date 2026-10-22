package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o extends SettingKey<Integer> {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
        super("ttlive_comment_fold_time_ms", "公屏折叠的阈值控制ms", 500, 500);
    }
}
