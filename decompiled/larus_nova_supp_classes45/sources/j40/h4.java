package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h4 extends SettingKey<Boolean> {
    public static final h4 a = null;

    static {
        a = new h4();
    }

    public h4() {
        Boolean r1 = Boolean.FALSE;
        super("live_toolbar_icon_opt", "toolbar视觉降级，icon替换", r1, r1);
    }
}
