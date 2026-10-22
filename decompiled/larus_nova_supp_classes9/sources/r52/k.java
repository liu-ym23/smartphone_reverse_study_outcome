package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends SettingKey<Boolean> {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_public_screen_exclude_pk", "主播公屏助手判断时是否排除pk", r1, r1);
    }
}
