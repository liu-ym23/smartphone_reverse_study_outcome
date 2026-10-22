package tr8;

import com.larus.common.apphost.AppHost;
import com.larus.platform.service.n0;
import ic8.n;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final String a(e r5) {
        if (n0.a.b() == true) goto L5;
    L7:
        int r0 = 2131894309;
    L8:
        AppHost.Companion r1 = AppHost.a;
        if (r1.isOversea() == false) goto L11;
        int r2 = 2131901981;
    L13:
        return r1.getApplication().getString(r2, new Object[]{n.g(r5, r1.getApplication().getString(r0))});
    L11:
        r2 = 2131901980;
        goto L13
    L5:
        if (AppHost.a.isOversea() == true) goto L7;
        r0 = 2131907244;
        goto L8
    }
}
