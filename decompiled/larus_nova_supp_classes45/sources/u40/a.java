package u40;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.config.cq;
import com.bytedance.android.livesdk.config.dq;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final boolean a() {
        return ((Boolean) dq.a.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean b() {
        return ((Boolean) cq.a.getValue()).booleanValue();
    }

    static {
    }

    @JvmStatic
    public static final boolean c(boolean r0) {
        if (r0 == false) goto L6;
        return false;
    L6:
        return LiveInfraSettingKeys.LIVE_DYNAMIC_TOOLBAR_MODIFY_PERMUTATION.getValue().booleanValue();
    }
}
