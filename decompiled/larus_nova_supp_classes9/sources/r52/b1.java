package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b1 extends SettingKey<Integer> {
    public static final b1 a = null;

    public b1() {
        super("live_mention_message_show_style", "看播侧mention消息展示方式 0: 不做差异化，1: mention消息展示后公屏刷新降速 2:置顶展示", 0, 0);
    }

    static {
        a = new b1();
    }
}
