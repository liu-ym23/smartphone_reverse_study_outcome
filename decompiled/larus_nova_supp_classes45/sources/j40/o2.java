package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o2 extends SettingKey<List<? extends String>> {
    public static final o2 a = null;

    static {
        a = new o2();
    }

    public o2() {
        super("live_samsung_fold_screen_device_list", "三星折叠屏设备白名单", new ArrayList(), new ArrayList());
    }
}
