package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z0 extends SettingKey<Integer> {
    public static final z0 a = null;

    static {
        a = new z0();
    }

    public z0() {
        super("live_like_hot_threshold_config", "点赞高热阈值（ACU）", 10, 10);
    }
}
