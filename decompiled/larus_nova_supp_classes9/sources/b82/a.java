package b82;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        if (v.a() == false) goto L6;
        ALogger.i("TTLIVE_IM_INDUSTRY", r1);
        return;
    }

    public static void a(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        if (r2 != null) goto L5;
        ALogger.e("TTLIVE_IM_INDUSTRY", r1);
        return;
    L5:
        ALogger.e("TTLIVE_IM_INDUSTRY", r1, r2);
    }
}
