package xea;

import android.os.Bundle;
import com.larus.applog.api.IApplog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public a() {
    }

    public static void b(String r3, String r4, Integer r5) {
        IApplog.a.b("obric_short_link_request_start", com.larus.utils.f.c(new Pair[]{TuplesKt.to("path", r3), TuplesKt.to("sequence_id", r4), TuplesKt.to("network_status", r5)}));
    }

    public static void a(String r2, String r3, Integer r4, Integer r5, Integer r6, String r7, Map r8) {
        Bundle r9 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("path", r2), TuplesKt.to("sequence_id", r3), TuplesKt.to("network_status", r4), TuplesKt.to("repeat_time", r5), TuplesKt.to("response_code", r6), TuplesKt.to("response_description", r7)});
        if (r8 == null) goto L26;
        Iterator r10 = r8.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L26;
        Map.Entry r11 = (Map.Entry) r10.next();
        String r12 = (String) r11.getKey();
        Object r13 = r11.getValue();
        if ((r13 instanceof Long) == true) goto L9;
        if ((r13 instanceof Integer) == true) goto L12;
        if ((r13 instanceof String) == true) goto L15;
        if ((r13 instanceof Float) == true) goto L18;
        if ((r13 instanceof Double) == true) goto L21;
        if (r13 == null) goto L24;
        String r14 = r13.toString();
    L25:
        r9.putString(r12, r14);
        goto L6
    L24:
        r14 = null;
        goto L25
    L21:
        r9.putDouble(r12, ((Number) r13).doubleValue());
        goto L6
    L18:
        r9.putFloat(r12, ((Number) r13).floatValue());
        goto L6
    L15:
        r9.putString(r12, (String) r13);
        goto L6
    L12:
        r9.putInt(r12, ((Number) r13).intValue());
        goto L6
    L9:
        r9.putLong(r12, ((Number) r13).longValue());
    L26:
        IApplog.a.b("obric_short_link_request_end", r9);
    }
}
