package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i extends SettingKey<Boolean> {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_follow_status_use_local_db", "关注状态发生错误时是否使用兜底IM数据库", r1, r1);
    }
}
