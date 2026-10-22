package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x3 extends SettingKey<Boolean> {
    public static final x3 a = null;

    static {
        a = new x3();
    }

    public x3() {
        Boolean r1 = Boolean.TRUE;
        super("live_vs_enable_banner_handle_schema", "活动指示器是否启用节目直播间贴缩流处理", r1, r1);
    }
}
