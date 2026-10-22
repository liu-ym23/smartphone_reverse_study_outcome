package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s3 extends SettingKey<Boolean> {
    public static final s3 a = null;

    static {
        a = new s3();
    }

    public s3() {
        Boolean r1 = Boolean.FALSE;
        super("live_use_new_fold_recognize_api_opt", "是否对齐抖音折叠屏判断耗时优化", r1, r1);
    }
}
