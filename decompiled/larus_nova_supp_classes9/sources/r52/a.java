package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends SettingKey<Boolean> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
        super("chat_need_bind_phone", Boolean.FALSE, "发评论是否需要绑定手机号", new String[]{"false:不需要绑定", "true:需要绑定"});
    }
}
