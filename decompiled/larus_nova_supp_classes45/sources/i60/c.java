package i60;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface c {
    public static final SettingKey<Boolean> a = null;

    static {
        Boolean r2 = Boolean.FALSE;
        a = new SettingKey("live_cold_start_widget_load_opt", "冷启widget加载优化", r2, r2).setPreloadCache(true);
    }
}
