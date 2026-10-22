package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j extends SettingKey<Boolean> {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_jump_personal_page_when_online", "直播间聊天室麦上嘉宾能否跳转个人页", r1, r1);
    }
}
