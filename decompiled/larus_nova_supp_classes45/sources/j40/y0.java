package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y0 extends SettingKey<Boolean> {
    public static final y0 a = null;

    static {
        a = new y0();
    }

    public y0() {
        Boolean r1 = Boolean.TRUE;
        super("live_landscape_media_split_anim_fix", "横屏媒体缩流分屏修复", r1, r1);
    }
}
