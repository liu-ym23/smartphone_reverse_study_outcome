package bb8;

import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j {
    public static final boolean a(i r6) {
        if (r6 == null) goto L4;
        Long r0 = r6.e();
    L6:
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r6.e().longValue() > 0) goto L11;
        return false;
    L11:
        if ((AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000)) < r6.e().longValue()) goto L15;
        return true;
    L15:
        return false;
    L4:
        r0 = null;
        goto L6
    }
}
