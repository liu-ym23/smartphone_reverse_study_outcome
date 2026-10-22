package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y3 extends SettingKey<Boolean> {
    public static final y3 a = null;

    static {
        a = new y3();
    }

    public y3() {
        Boolean r1 = Boolean.TRUE;
        super("live_vs_enable_handle_schema", "活动指示器&&入场信息/官方弹幕是否启用节目直播间贴缩流处理", r1, r1);
    }
}
