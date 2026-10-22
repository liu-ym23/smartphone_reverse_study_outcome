package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d1 extends SettingKey<Long> {
    public static final d1 a = null;

    static {
        a = new d1();
    }

    public d1() {
        super("live_comment_mention_list_req_time_rate", "mention请求频控时间，单位ms", 200L, 200L);
    }
}
