package l60;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        SettingKey<b> r0 = LiveInfraSettingKeys.LIVE_LAYER_FRAMEWORK_OPT;
        if (r0.getValue().a() == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.getValue().b() == false) goto L7;
        return true;
    }

    public static boolean b() {
        SettingKey<b> r0 = LiveInfraSettingKeys.LIVE_LAYER_FRAMEWORK_OPT;
        if (r0.getValue().a() == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.getValue().c() == false) goto L7;
        return true;
    }

    static {
    }
}
