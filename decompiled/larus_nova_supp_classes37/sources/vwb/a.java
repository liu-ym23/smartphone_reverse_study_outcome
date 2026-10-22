package vwb;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.ss.android.lark.officesdk.utils.di.g;
import com.ss.android.lark.officesdk.utils.di.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final CookieManager a;

    /* JADX INFO: renamed from: vwb.a$a, reason: collision with other inner class name */
    public static final class C0202a {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public a() {
        this.a = CookieManager.getInstance();     // Catch: Exception -> L8
        int r2 = g.a;     // Catch: Exception -> L8
        if (g.a.a("openplatform.enable.cookie.syncmanager") == false) goto L6;
        j.e("LarkCookieManager", "enableCookieSyncManager is true");     // Catch: Exception -> L8
        CookieSyncManager.getInstance();     // Catch: Exception -> L8
    L6:
        j.e("LarkCookieManager", "init LarkCookieManager");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        j.c("LarkCookieManager", "init LarkCookieManager error", e);
    }
}
