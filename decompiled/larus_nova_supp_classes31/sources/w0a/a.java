package w0a;

import com.larus.common.apphost.AppHost;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final boolean a = false;

    static {
        a = AppHost.a.isDebug();
    }

    public static void a(String r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (a == true) goto L13;
        return;
    L13:
        FLogger r1 = FLogger.a;     // Catch: Exception -> L10
        String r5 = "community_log_".concat(r3);     // Catch: Exception -> L10
        String r6 = (String) r4.invoke();     // Catch: Exception -> L10
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r1.d(r5, r6);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        g.a.ensureNotReachHere(e);
    }

    public static void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        FLogger.a.e("community_log_".concat(r2), r3);
    }

    public static void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        FLogger.a.i("community_log_".concat(r2), r3);
    }
}
