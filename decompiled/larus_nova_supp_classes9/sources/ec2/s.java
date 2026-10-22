package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s extends SettingKey<Integer> {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
        super("live_comment_words_count_limit", "评论最大字数限制", 50, 50);
    }
}
