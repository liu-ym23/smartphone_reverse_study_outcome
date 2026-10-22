package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i0 extends SettingKey<Boolean> {
    public static final i0 a = null;

    static {
        a = new i0();
    }

    public i0() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_left_avatar_entry_show", "评论框左侧是否展示一级入口", r1, r1);
    }
}
