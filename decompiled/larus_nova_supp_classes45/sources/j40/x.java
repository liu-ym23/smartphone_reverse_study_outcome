package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x extends SettingKey<Integer> {
    public static final x a = null;

    public x() {
        super("live_sdk_enable_player_drop_frame", "是否开启播放器丢帧", 0, 0);
    }

    static {
        a = new x();
    }
}
