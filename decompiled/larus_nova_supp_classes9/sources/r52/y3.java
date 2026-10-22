package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y3 extends SettingKey<Boolean> {
    public static final y3 a = null;

    static {
        a = new y3();
    }

    public y3() {
        Boolean r1 = Boolean.TRUE;
        super("live_messagelist_height_video_chorus_opt_enable", "视频合唱公屏优化开关", r1, r1);
    }
}
