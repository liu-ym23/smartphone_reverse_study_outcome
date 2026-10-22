package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d3 extends SettingKey<Boolean> {
    public static final d3 a = null;

    static {
        a = new d3();
    }

    public d3() {
        super("live_strategy_handle_room_async", "handle room 异步", Boolean.FALSE, Boolean.TRUE);
    }
}
