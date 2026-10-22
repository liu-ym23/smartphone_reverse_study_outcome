package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w0 extends SettingKey<Boolean> {
    public static final w0 a = null;

    static {
        a = new w0();
    }

    public w0() {
        Boolean r1 = Boolean.FALSE;
        super("live_multi_block_zdanmaku", "UI自动化测试用屏蔽弹幕", r1, r1);
    }
}
