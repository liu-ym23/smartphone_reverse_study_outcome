package l2a;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u {
    public static final boolean a = false;

    static {
        a = AppHost.a.isDebug();
    }

    public static void a(com.larus.video.impl.sdk.g r2) {
        Intrinsics.checkNotNullParameter("TTVideoControllerImpl", "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (a == true) goto L13;
        return;
    L13:
        FLogger r0 = FLogger.a;     // Catch: Exception -> L10
        String r3 = (String) r2.invoke();     // Catch: Exception -> L10
        if (r3 != null) goto L8;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        r0.d("video_common_log_TTVideoControllerImpl", r3);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e);
    }

    public static void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        FLogger.a.i("video_common_log_".concat(r2), r3);
    }
}
