package ft1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.crash.Npth;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Map r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        Iterator r0 = r3.entrySet().iterator();     // Catch: Exception -> L9
    L5:
        if (r0.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) r0.next();     // Catch: Exception -> L9
        String r2 = (String) r1.getKey();     // Catch: Exception -> L9
        String r4 = (String) r1.getValue();     // Catch: Exception -> L9
        goto L5
    L7:
        Npth.addTags(r3);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        ALogger.e("LiveNpthHelper", "add tags error: " + e.getMessage());
    }
}
