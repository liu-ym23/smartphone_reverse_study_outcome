package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0 extends SettingKey<Boolean> {
    public static final h0 a = null;

    static {
        a = new h0();
    }

    public h0() {
        Boolean r1 = Boolean.FALSE;
        super("live_feed_inset_opt", "直播内流ViewPager容器Inset优化", r1, r1);
    }
}
