package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w1 extends SettingKey<Boolean> {
    public static final w1 a = null;

    static {
        a = new w1();
    }

    public w1() {
        Boolean r1 = Boolean.FALSE;
        super("live_player_layout_fix_statusbar", "播放器布局修复statusbar的高度问题", r1, r1);
    }
}
