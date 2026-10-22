package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p0 extends SSettingKey<Boolean> {
    public static final p0 a = null;

    static {
        a = new p0();
    }

    public p0() {
        Boolean r1 = Boolean.TRUE;
        super("live_interaction_open_more_use_datacenter", "是否使用datacenter打开更多面板", r1, r1);
    }
}
