package nq1;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends SSettingKey<oq1.b> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
        super("live_vs_interact_multi_instance_fix", "互动组件存在多个WebView实例修复", new oq1.b(), new oq1.b());
    }
}
