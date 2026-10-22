package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v3 extends SettingKey<Boolean> {
    public static final v3 a = null;

    static {
        a = new v3();
    }

    public v3() {
        Boolean r1 = Boolean.FALSE;
        super("live_viewpager_bottom_filter", "直播容器下半屏渲染优化", r1, r1);
    }
}
