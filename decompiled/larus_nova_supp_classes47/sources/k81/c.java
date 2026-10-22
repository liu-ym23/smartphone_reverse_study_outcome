package k81;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdk.utils.v5;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final j81.a a() {
        String r0 = v5.b().getString("live.pref.SHARE_PANEL_CONFIG", "");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        ALogger.i("QrCodeConfig", "cache map is null");
        return null;
    L13:
        return (j81.a) JsonUtil.parse(r0, j81.a.class);
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    static {
    }

    public static boolean b(String r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length() <= 0) goto L6;
        return true;
    }
}
