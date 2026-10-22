package ec2;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o1 extends SettingKey<List<? extends Integer>> {
    public static final o1 a = null;

    static {
        a = new o1();
    }

    public o1() {
        super("live_word_associate_ban_list", "直播间禁止文字联想的评论类型", new ArrayList(), new ArrayList());
    }
}
