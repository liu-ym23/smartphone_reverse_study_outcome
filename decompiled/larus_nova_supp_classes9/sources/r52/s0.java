package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s0 extends SettingKey<Boolean> {
    public static final s0 a = null;

    static {
        a = new s0();
    }

    public s0() {
        Boolean r1 = Boolean.FALSE;
        super("ttlive_input_adjust_resize_enable", "直播评论输入栏添加ADJUST_RESIZE属性", r1, r1);
    }
}
