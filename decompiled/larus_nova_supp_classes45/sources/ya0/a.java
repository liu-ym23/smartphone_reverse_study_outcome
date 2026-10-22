package ya0;

import com.bytedance.android.live.initialize.api.IWTOLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static IWTOLogger a;

    static {
    }

    public static void c(String r2) {
        Intrinsics.checkNotNullParameter("wto_async_optimizer", "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        IWTOLogger r0 = a;
        if (r0 == null) goto L6;
        r0.i("wto_async_optimizer", r2);
        return;
    }

    public static void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sceneInfo");
        Intrinsics.checkNotNullParameter(r3, "msg");
        IWTOLogger r0 = a;
        if (r0 == null) goto L6;
        r0.i("WTO_", r2 + ",\n\t" + r3);
        return;
    }

    public static void b(String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        IWTOLogger r0 = a;
        if (r0 == null) goto L13;
        StringBuilder r1 = new StringBuilder();
        r1.append(r3);
        StackTraceElement[] r5 = null;
        if (r4 == null) goto L7;
        String r2 = r4.getMessage();
    L8:
        r1.append(r2);
        if (r4 == null) goto L11;
        r5 = r4.getStackTrace();
    L11:
        r1.append(r5);
        r0.e("WTO_SCHDULE_ERROR", r1.toString(), r4);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public static void d(com.bytedance.android.live.initialize.a r1, String r2, Map r3) {
        Intrinsics.checkNotNullParameter(r1, "executePeriod");
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r3, "info");
        String r4 = "{\n\t\"msg\":".concat(r2) + ",\n\t\"period\":" + r1.b;
        Iterator r5 = ((LinkedHashMap) r3).entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r6 = (Map.Entry) r5.next();
        r4 = r4 + ",\n\t\"" + ((String) r6.getKey()) + "\":" + r6.getValue();
        goto L4
    L6:
        String r7 = r4 + "\n}";
        IWTOLogger r8 = a;
        if (r8 == null) goto L11;
        r8.i("WTO_SCHDULE", r7);
        return;
    }
}
