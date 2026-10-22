package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l extends SettingKey<Boolean> {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_profile_fans_click_schema", "资料卡上的粉丝团/星守护标签是否支持点击跳转schema下发", r1, r1);
    }
}
