package nu0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public static void a(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$logD");
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        ALogger.d("VoiceChat#" + r2.getClass().getSimpleName() + "#", r3);
    }

    public static final void d(Object r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$logI");
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        StringBuilder r0 = new StringBuilder("VoiceChat#");
        r0.append(r2.getClass().getSimpleName());
        r0.append('#');
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.append(r4);
        ALogger.d(r0.toString(), r3);
    }

    public static final void b(Object r2, String r3, Throwable r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$logE");
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        StringBuilder r0 = new StringBuilder("VoiceChat#");
        r0.append(r2.getClass().getSimpleName());
        r0.append('#');
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.append(r5);
        ALogger.e(r0.toString(), r3, r4);
    }

    public static /* synthetic */ void c(Object r1, String r2, Throwable r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        b(r1, r2, r3, null);
    }
}
