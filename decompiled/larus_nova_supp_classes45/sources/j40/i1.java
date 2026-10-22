package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i1 extends SettingKey<Boolean> {
    public static final i1 a = null;

    static {
        a = new i1();
    }

    public i1() {
        Boolean r1 = Boolean.TRUE;
        super("live_landscape_to_landscape", "直播横屏更多直播支持跳转横屏", r1, r1);
    }
}
