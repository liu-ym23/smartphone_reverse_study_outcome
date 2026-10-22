package ev1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m extends SettingKey<Boolean> {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_follower_share_api_dispose", "修复/aweme/v1/familiar/recommend/status/ 请求主动断开导致服务端499错误上升的问题", r1, r1);
    }
}
