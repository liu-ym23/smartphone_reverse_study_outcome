package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0 extends SettingKey<Long> {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    public c0() {
        super("live_profile_enter_timeout", "资料卡进场等待超时时间，毫秒", 500L, 500L);
    }
}
