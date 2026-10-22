package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j0 extends SettingKey<Boolean> {
    public static final j0 a = null;

    static {
        a = new j0();
    }

    public j0() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_load_history_v2", "历史评论功能客户端兜底开关", r1, r1);
    }
}
