package ht1;

import com.bytedance.android.live.core.setting.z0;
import com.bytedance.android.livesdk.config.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final Boolean a = null;

    static {
        a = (Boolean) z0.a.getValue();
    }

    public static boolean a() {
        if (a.booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (b0.a == true) goto L7;
        return true;
    }
}
