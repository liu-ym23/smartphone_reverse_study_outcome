package g32;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(e32.a r2) {
        Intrinsics.checkNotNullParameter(r2, "degradeRequest");
        ALogger.i("InteractivityDegradeLogger", "receive request. Type: " + r2.a.name() + ", Level: " + r2.b.logName() + ", Dimension: " + r2.c.name() + ' ');
    }
}
