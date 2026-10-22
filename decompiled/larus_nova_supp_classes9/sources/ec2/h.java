package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends SSettingKey<Boolean> {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
        Boolean r1 = Boolean.FALSE;
        super("live_answer_question_support_audience", "答题支持观众评论参与", r1, r1);
    }
}
