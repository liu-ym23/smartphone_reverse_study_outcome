package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f3 extends SettingKey<Integer> {
    public static final f3 a = null;

    static {
        a = new f3();
    }

    public f3() {
        super("live_strategy_info_sample", "策略配置采样率", 100, 100);
    }
}
