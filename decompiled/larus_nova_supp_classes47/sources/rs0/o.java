package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o extends SettingKey<Boolean> {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_profile_show_float_window_anchor", "资料卡主播跳转团购页是否展示直播小窗", r1, r1);
    }
}
