package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p extends SettingKey<Boolean> {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
        Boolean r4 = Boolean.FALSE;
        super("live_audience_contour_enable", "看播端是否开启绘制人像", r4, r4, true);
    }
}
