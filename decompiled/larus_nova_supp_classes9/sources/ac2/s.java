package ac2;

import com.bytedance.android.live.core.log.ALogger;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s {
    public static CookieHandler a;

    static {
    }

    @JvmStatic
    public static final Map<String, String> a(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "url");
        URI r8 = com.bytedance.frameworks.baselib.network.http.util.l.a(r6);
        if (r7 == true) goto L5;
        a = CookieHandler.getDefault();
        ALogger.i("TraceClientMonitor", "get CookieHandler EveryTime");
    L49:
        HashMap r9 = new HashMap();     // Catch: Throwable -> L43
        CookieHandler r0 = a;     // Catch: Throwable -> L43
        if (r0 != null) goto L47;
    L14:
        Map<String, List<String>> r10 = null;
    L16:
        if (r10 != null) goto L18;
    L21:
        boolean r1 = true;
    L22:
        if (r1 == true) goto L46;
        Iterator<Map.Entry<String, List<String>>> r11 = r10.entrySet().iterator();     // Catch: Throwable -> L43
    L25:
        if (r11.hasNext() == false) goto L46;
        Map.Entry<String, List<String>> r2 = r11.next();     // Catch: Throwable -> L43
        String r3 = r2.getKey();     // Catch: Throwable -> L43
        List<String> r4 = r2.getValue();     // Catch: Throwable -> L43
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L43
        if (StringsKt.equals("X-SS-Cookie", r3, true) == true) goto L33;
        if (StringsKt.equals("Cookie", r3, true) == true) goto L33;
        if (StringsKt.equals("Cookie2", r3, true) == false) goto L25;
    L33:
        if ((!r4.isEmpty()) == false) goto L25;
        Iterator<String> r13 = r4.iterator();     // Catch: Throwable -> L43
        int r14 = 0;
    L36:
        if (r13.hasNext() == false) goto L41;
        String r15 = r13.next();     // Catch: Throwable -> L43
        if (r14 <= 0) goto L40;
        r5.append("; ");     // Catch: Throwable -> L43
    L40:
        r5.append(r15);     // Catch: Throwable -> L43
        r14 = r14 + 1;     // Catch: Throwable -> L43
        goto L36
    L41:
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to(r3, r5.toString())});
    L46:
        return new HashMap();
    L18:
        if (r10.isEmpty() == true) goto L21;
        r1 = false;
        goto L22
    L47:
        Intrinsics.checkNotNull(r0);     // Catch: IOException -> L12 Throwable -> L43
        r10 = r0.get(r8, r9);     // Catch: IOException -> L12 Throwable -> L43
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
        goto L46
    L5:
        if (a != null) goto L49;
        a = CookieHandler.getDefault();
        ALogger.i("TraceClientMonitor", "get CookieHandler Once");
        goto L49
    }
}
