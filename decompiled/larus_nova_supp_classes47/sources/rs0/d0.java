package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 extends SettingKey<Boolean> {
    public static final d0 a = null;

    static {
        a = new d0();
    }

    public d0() {
        Boolean r1 = Boolean.TRUE;
        super("live_profile_fix_profile_text_image_format", "修复资料卡富文本图片格式失效", r1, r1);
    }
}
