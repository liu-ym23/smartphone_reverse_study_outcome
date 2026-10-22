package nc;

import android.util.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.w;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11342a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArraySet<Logger> f11343b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f11344c = null;

    static {
        f11342a = new c();
        f11343b = new CopyOnWriteArraySet();
        LinkedHashMap r10 = new LinkedHashMap();
        Package r11 = w.class.getPackage();
        if (r11 == null) goto L5;
        String r12 = r11.getName();
    L6:
        if (r12 == null) goto L8;
        r10.put(r12, "OkHttp");
    L8:
        String r13 = w.class.getName();
        Intrinsics.checkNotNullExpressionValue(r13, "OkHttpClient::class.java.name");
        r10.put(r13, "okhttp.OkHttpClient");
        String r14 = mc.b.class.getName();
        Intrinsics.checkNotNullExpressionValue(r14, "Http2::class.java.name");
        r10.put(r14, "okhttp.Http2");
        String r15 = jc.e.class.getName();
        Intrinsics.checkNotNullExpressionValue(r15, "TaskRunner::class.java.name");
        r10.put(r15, "okhttp.TaskRunner");
        r10.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f11344c = MapsKt.toMap(r10);
        return;
    L5:
        r12 = null;
        goto L6
    }

    private c() {
    }

    private final void c(String r10, String r11) {
        Logger r12 = Logger.getLogger(r10);
        if (f11343b.add(r12) == false) goto L13;
        r12.setUseParentHandlers(false);
        if (Log.isLoggable(r11, 3) == false) goto L8;
        Level r13 = Level.FINE;
    L11:
        r12.setLevel(r13);
        r12.addHandler(d.f11345a);
        return;
    L8:
        if (Log.isLoggable(r11, 4) == false) goto L10;
        r13 = Level.INFO;
        goto L11
    L10:
        r13 = Level.WARNING;
        goto L11
    }

    private final String d(String r10) {
        String r11 = f11344c.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return StringsKt.take(r10, 23);
    }

    public final void a(String r10, int r11, String r12, Throwable r13) {
        Intrinsics.checkNotNullParameter(r10, "loggerName");
        Intrinsics.checkNotNullParameter(r12, "message");
        String r14 = d(r10);
        if (Log.isLoggable(r14, r11) == false) goto L16;
        if (r13 == null) goto L6;
        r12 = r12 + '\n' + Log.getStackTraceString(r13);
    L6:
        int r15 = 0;
        int r16 = r12.length();
    L7:
        if (r15 >= r16) goto L20;
        int r17 = StringsKt.indexOf$default(r12, '\n', r15, false, 4, null);
        if (r17 != (-1)) goto L12;
        r17 = r16;
    L12:
        int r18 = Math.min(r17, r15 + 4000);
        String r19 = r12.substring(r15, r18);
        Intrinsics.checkNotNullExpressionValue(r19, "this as java.lang.String…ing(startIndex, endIndex)");
        Log.println(r11, r14, r19);
        if (r18 >= r17) goto L14;
        r15 = r18;
        goto L12
    L14:
        r15 = r18 + 1;
        goto L7
    L20:
        return;
    }

    public final void b() {
        Iterator<Map.Entry<String, String>> r10 = f11344c.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<String, String> r11 = r10.next();
        c(r11.getKey(), r11.getValue());
        goto L4
    }
}
