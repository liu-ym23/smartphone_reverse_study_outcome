package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d3 extends SettingKey<Boolean> {
    public static final d3 a = null;

    static {
        a = new d3();
    }

    public d3() {
        Boolean r1 = Boolean.TRUE;
        super("live_public_screen_gift_message_decouple", "公屏礼物消息分离开关", r1, r1);
    }
}
