package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z3 extends SettingKey<Boolean> {
    public static final z3 a = null;

    static {
        a = new z3();
    }

    public z3() {
        Boolean r1 = Boolean.TRUE;
        super("live_quick_comment_enable", "观众端快捷评论开关", r1, r1);
    }
}
