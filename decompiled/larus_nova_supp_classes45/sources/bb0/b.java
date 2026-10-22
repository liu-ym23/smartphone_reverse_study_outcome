package bb0;

import com.bytedance.android.live.ktv.common.model.KtvMode;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Deprecated(message = "后续不要使用这个单例回调到业务侧")
public final class b {
    public static a a;

    public static KtvMode a() {
        a r0 = a;
        if (r0 == null) goto L7;
        KtvMode r1 = r0.d();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return KtvMode.LIVE_KTV;
    }

    public static String b() {
        a r0 = a;
        if (r0 == null) goto L6;
        String r1 = r0.k();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "ttlive_ktv";
    }

    static {
    }
}
