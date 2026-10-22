package ft1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.crash.Npth;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static final Map<String, String> a = null;
    public static int b;

    static {
        a = new LinkedHashMap();
        b = -1;
    }

    public static void a(int r5) {
    L15:
        e = move-exception;
        int r1 = b.a;
        ALogger.e("LiveCrashTagRecorder", "clear tag error:" + e.toString());
        return;
    L4:
        if (r5 != b) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L9;
        return;
    L9:
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Exception -> L15
        Iterator r4 = ((LinkedHashMap) a).keySet().iterator();     // Catch: Exception -> L15
    L11:
        if (r4.hasNext() == false) goto L13;
        r3.put((String) r4.next(), "null");     // Catch: Exception -> L15
        goto L11
    L13:
        Npth.addTags(r3);     // Catch: Exception -> L15
        ((LinkedHashMap) a).clear();     // Catch: Exception -> L15
        int r6 = b.a;     // Catch: Exception -> L15
        ALogger.i("LiveCrashTagRecorder", r5 + ":clear tag");     // Catch: Exception -> L15
        return;
    L6:
        r2 = false;
        goto L7
    }

    public static void d(int r3) {
        b = r3;     // Catch: Exception -> L5
        int r2 = b.a;     // Catch: Exception -> L5
        ALogger.i("LiveCrashTagRecorder", "update record code, current record code:" + r3);     // Catch: Exception -> L5
        a(r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        int r4 = b.a;
        ALogger.e("LiveCrashTagRecorder", r3 + ":update record code error:" + e.toString());
    }

    public static void b(String r3, int r4) {
        Intrinsics.checkNotNullParameter("live_room_scene", "tag");
        Intrinsics.checkNotNullParameter(r3, "tagValue");
    L11:
        e = move-exception;
        int r5 = b.a;
        ALogger.e("LiveCrashTagRecorder", "record extra key value error:" + e.toString());
        return;
    L4:
        if (r4 != b) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L9;
        return;
    L9:
        a.put("live_room_scene", r3);     // Catch: Exception -> L11
        Npth.addTags(MapsKt.mapOf(TuplesKt.to("live_room_scene", r3)));     // Catch: Exception -> L11
        int r6 = b.a;     // Catch: Exception -> L11
        ALogger.i("LiveCrashTagRecorder", r4 + ":record extra key value ");     // Catch: Exception -> L11
        return;
    L6:
        r1 = false;
        goto L7
    }

    public static void c(Map r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "outerMap");
    L15:
        e = move-exception;
        int r7 = b.a;
        ALogger.e("LiveCrashTagRecorder", "record extra map error:" + e.toString());
        return;
    L4:
        if (r6 != b) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L9;
        return;
    L9:
        Iterator r2 = r5.entrySet().iterator();     // Catch: Exception -> L15
    L11:
        if (r2.hasNext() == false) goto L13;
        Map.Entry r3 = (Map.Entry) r2.next();     // Catch: Exception -> L15
        a.put((String) r3.getKey(), (String) r3.getValue());     // Catch: Exception -> L15
        goto L11
    L13:
        Npth.addTags(r5);     // Catch: Exception -> L15
        int r8 = b.a;     // Catch: Exception -> L15
        ALogger.i("LiveCrashTagRecorder", r6 + ":record extra map");     // Catch: Exception -> L15
        return;
    L6:
        r1 = false;
        goto L7
    }
}
