package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b2 extends SettingKey<Boolean> {
    public static final b2 a = null;

    static {
        a = new b2();
    }

    public b2() {
        Boolean r1 = Boolean.TRUE;
        super("live_preview_paid_scope_enable_multi_camera", "预览流付费Scope服务支持子机位", r1, r1);
    }
}
