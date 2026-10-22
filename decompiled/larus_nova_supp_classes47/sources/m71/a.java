package m71;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends SSettingKey<Boolean> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
        Boolean r1 = Boolean.FALSE;
        super("enable_live_common_card_mock", "开启右下角通用卡片mock", r1, r1);
    }
}
