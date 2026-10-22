package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b3 extends SettingKey<Boolean> {
    public static final b3 a = null;

    static {
        a = new b3();
    }

    public b3() {
        Boolean r1 = Boolean.FALSE;
        super("live_public_screen_enable_update_when_height_change", "公屏高度变化时更新数据", r1, r1);
    }
}
