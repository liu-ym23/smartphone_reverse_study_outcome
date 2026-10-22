package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x0 extends SettingKey<Boolean> {
    public static final x0 a = null;

    static {
        a = new x0();
    }

    public x0() {
        Boolean r1 = Boolean.TRUE;
        super("new_profile_portrait_width_height_regress_enable", "新版资料卡竖屏某些情况下宽高错乱纠正开关", r1, r1);
    }
}
