package d80;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final int a = 0;
    public static final Boolean b = null;

    static {
        a = LiveInfraSettingKeys.LIVE_TETRIS_OPT.getValue().intValue();
        b = LiveInfraSettingKeys.LIVE_FIX_ASYNC_INFLATER_LEAK.getValue();
    }

    public static boolean a() {
        if ((a & 2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
