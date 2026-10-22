package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l0 extends SettingKey<Boolean> {
    public static final l0 a = null;

    static {
        l0 r0 = new l0();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public l0() {
        Boolean r4 = Boolean.FALSE;
        super("live_follow_cover_pre_pullstream", "关注天窗首次滑动预拉流优化", r4, r4, new String[]{"true:使用预拉流", "false:不使用预拉流"});
    }
}
