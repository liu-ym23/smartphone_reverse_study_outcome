package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends SettingKey<Boolean> {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
        Boolean r1 = Boolean.FALSE;
        super("live_carnival_danmaku_debug", "狂欢弹幕调试开关", r1, r1);
    }
}
