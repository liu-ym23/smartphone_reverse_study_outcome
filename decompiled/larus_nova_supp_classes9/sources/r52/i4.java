package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i4 extends SettingKey<Long> {
    public static final i4 a = null;

    static {
        a = new i4();
    }

    public i4() {
        super("live_toolbar_sync_interval_android", "当toolbar加载方式为1时，超时时间，单位毫秒", 1000L, 1000L);
    }
}
