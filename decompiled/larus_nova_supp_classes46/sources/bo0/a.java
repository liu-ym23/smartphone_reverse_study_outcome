package bo0;

import com.bytedance.android.livesdk.config.bj;
import com.bytedance.android.livesdk.config.cj;
import com.bytedance.android.livesdk.config.z11;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final Boolean a = null;
    public static final z11 b = null;

    static {
        a = (Boolean) cj.a.getValue();
        b = (z11) bj.a.getValue();
    }

    public static boolean a() {
        if (a.booleanValue() == false) goto L13;
        Map r0 = b.a();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.isEmpty() == true) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }
}
