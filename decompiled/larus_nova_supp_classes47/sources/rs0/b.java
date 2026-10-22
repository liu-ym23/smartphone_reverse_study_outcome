package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends SettingKey<Boolean> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
        Boolean r1 = Boolean.FALSE;
        super("fans_group_enable_media_room", "媒体直播间是否展示粉丝群", r1, r1);
    }
}
