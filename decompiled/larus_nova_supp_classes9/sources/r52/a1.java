package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a1 extends SettingKey<Boolean> {
    public static final a1 a = null;

    static {
        a = new a1();
    }

    public a1() {
        Boolean r1 = Boolean.TRUE;
        super("live_mark_highlight_release_stream_enable", "预览高光期间是否可以释放stream权限", r1, r1);
    }
}
