package nq1;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends SSettingKey<Boolean> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
        Boolean r1 = Boolean.FALSE;
        super("live_vs_message_board_is_sync_to_story_enable", "留言墙是否支持投稿", r1, r1);
    }
}
