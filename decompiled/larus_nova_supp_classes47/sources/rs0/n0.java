package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n0 extends SettingKey<Long> {
    public static final n0 a = null;

    static {
        a = new n0();
    }

    public n0() {
        super("live_profile_pre_inflate_delay_time", "资料卡布局资源预解析延时提交时间", 3000L, 3000L);
    }
}
