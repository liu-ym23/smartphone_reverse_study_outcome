package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g extends SettingKey<Boolean> {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
        Boolean r1 = Boolean.TRUE;
        super("ttlive_anchor_share_mini_app_release_sensitive_permission", "直播分享小程序时释放合规权限", r1, r1);
    }
}
