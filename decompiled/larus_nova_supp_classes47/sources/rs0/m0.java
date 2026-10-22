package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m0 extends SettingKey<Integer> {
    public static final m0 a = null;

    public m0() {
        super("live_profile_pre_inflate", "资料卡布局预解析, 0 关闭，1 全量预解析，2 用户打开过资料卡之后再预解析", 0, 0);
    }

    static {
        a = new m0();
    }
}
