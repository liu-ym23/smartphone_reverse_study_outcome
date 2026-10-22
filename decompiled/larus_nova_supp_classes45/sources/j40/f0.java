package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 extends SettingKey<Map<String, ? extends Object>> {
    public static final f0 a = null;

    static {
        a = new f0();
    }

    public f0() {
        super("live_feature_handle_room_clear_real_time_white_list", "直播策略handle room清除实时特征白名单", new LinkedHashMap(), new LinkedHashMap());
    }
}
