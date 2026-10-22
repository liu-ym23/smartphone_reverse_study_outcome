package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends SettingKey<Integer> {
    public static final e a = null;

    public e() {
        super("live_anchor_mention_message_show_style", "主播侧mention消息展示方式 0: 不做差异化，1: mention消息展示后公屏刷新降速 2:置顶展示", 0, 0);
    }

    static {
        a = new e();
    }
}
