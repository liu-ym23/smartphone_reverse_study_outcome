package gq1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static long a(String r2, String r3, long r4) {
        if (r3 != null) goto L4;
        return r4;
    L4:
        if (r3.length() != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L17;
        return CastLongProtector.parseLong(r3);
    L11:
        e = move-exception;
        ALogger.e("ReplayRoomActionHandler", r2 + " is not long " + r3 + ", " + e.getMessage());
        return r4;
    L17:
        return r4;
    L6:
        r0 = false;
        goto L7
    }
}
