package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z extends SettingKey<Boolean> {
    public static final z a = null;

    static {
        a = new z();
    }

    public z() {
        Boolean r4 = Boolean.TRUE;
        super("live_contour_can_draw_edge", "人脸是否开启描边绘制(部分机型不支持描边，兜底策略)", r4, r4, true);
    }
}
