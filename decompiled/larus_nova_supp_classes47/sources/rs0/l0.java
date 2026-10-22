package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l0 extends SettingKey<Boolean> {
    public static final l0 a = null;

    static {
        a = new l0();
    }

    public l0() {
        Boolean r1 = Boolean.TRUE;
        super("live_profile_parse_circle_image", "是否允许解析圆形图片", r1, r1);
    }
}
