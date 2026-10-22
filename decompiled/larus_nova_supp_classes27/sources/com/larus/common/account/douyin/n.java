package com.larus.common.account.douyin;

import android.os.Handler;
import android.os.Looper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n {
    public static final Handler a = null;
    public static m b;

    public static final class a implements f09.a.b {
        public a() {
        }

        public final void onAllActivityDestroyed() {
        }

        public final void onAppForeground() {
        }

        public final void onAppBackground() {
            n.a("app background");
        }
    }

    static {
        a = new Handler(Looper.getMainLooper());
        AppHost.a.a().j(new a());
    }

    public static void a(String r3) {
        m r0 = b;
        if (r0 == null) goto L6;
        FLogger.a.i("DouyinOauthTokenRefreshScheduler", "cancel task: ".concat(r3));
        a.removeCallbacks(r0);
        b = null;
        return;
    }
}
