package z51;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends SettingKey<Boolean> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
        Boolean r1 = Boolean.TRUE;
        super("live_record_publish_release_stream_enable", "录屏发布预览期间是否可以释放stream权限", r1, r1);
    }
}
