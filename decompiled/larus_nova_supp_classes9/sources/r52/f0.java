package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f0 extends SettingKey<Boolean> {
    public static final f0 a = null;

    static {
        a = new f0();
    }

    public f0() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_anchor_toolbar_comment", "主播侧底bar上是否允许展示评论入口", r1, r1);
    }
}
