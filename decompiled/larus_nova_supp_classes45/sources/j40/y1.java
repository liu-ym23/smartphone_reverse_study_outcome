package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y1 extends SettingKey<Boolean> {
    public static final y1 a = null;

    static {
        a = new y1();
    }

    public y1() {
        Boolean r1 = Boolean.TRUE;
        super("live_popup_service_enable", "面板下拉关闭功能开关", r1, r1);
    }
}
