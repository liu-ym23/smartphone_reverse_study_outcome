package z2a;

import com.larus.trace.tracespan.span.SpanWrapImpl;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vx9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public g() {
    }

    public static void a(String r4) {
        if (r4 != null) goto L5;
        FLogger.a.w("RealtimeCallSpanManager", "endRootSpan failed, traceId is null");
        return;
    L5:
        b.a.getClass();
        SpanWrapImpl r1 = b.a(r4, "call");
        if (r1 == null) goto L13;
        List r2 = r1.k();
        if (r2 == null) goto L13;
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        ((com.larus.trace.tracespan.span.b) r3.next()).cancel(true);
    L13:
        b(r4, "call", null, null);
    }

    public static com.larus.trace.tracespan.span.b c(String r3, String r4) {
        if (r3 == null) goto L5;
        b.a.getClass();
        return b.a(r3, r4);
    L5:
        FLogger.a.w("RealtimeCallSpanManager", "getSpanByTag failed, traceId=" + r3 + ", tagName=" + r4);
        return null;
    }

    public static wx9.a d(String r4, String r5) {
        if (r4 == null) goto L8;
        b.a.getClass();
        com.larus.trace.tracespan.span.b r6 = b.a(r4, r5);
        if (r6 != null) goto L7;
        return null;
    L7:
        return xx9.a.a(r6);
    L8:
        FLogger.a.w("RealtimeCallSpanManager", "getSpanContext failed, traceId=" + r4 + ", spanName=" + r5);
        return null;
    }

    public static com.larus.trace.tracespan.span.b e(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "spanScene");
        Intrinsics.checkNotNullParameter(r4, "spanCommonParams");
        b.a r0 = new b.a();
        Intrinsics.checkNotNullParameter(r3, "spanEventName");
        r0.c = r3;
        Intrinsics.checkNotNullParameter("call", "spanName");
        r0.a = "call";
        Intrinsics.checkNotNullParameter(r3, "scene");
        r0.b = r3;
        r0.d = wx9.b.c;
        com.larus.trace.tracespan.span.b r5 = r0.a();
        r5.setTag("call");
        r5.b(r4);
        return r5;
    }

    public static void f(String r4, String r5, wx9.a r6) {
        Intrinsics.checkNotNullParameter(r4, "spanScene");
        Intrinsics.checkNotNullParameter(r5, "spanName");
        FLogger.a.i("RealtimeCallSpanManager", "startSpan, spanName=" + r5);
        b.a r1 = new b.a();
        Intrinsics.checkNotNullParameter(r4, "spanEventName");
        r1.c = r4;
        Intrinsics.checkNotNullParameter(r5, "spanName");
        r1.a = r5;
        Intrinsics.checkNotNullParameter(r4, "scene");
        r1.b = r4;
        if (r6 != null) goto L5;
        r6 = wx9.b.c;
    L5:
        r1.d = r6;
        r1.a().setTag(r5);
    }

    public static void b(String r4, String r5, Integer r6, String r7) {
        if (r4 == null) goto L12;
        b.a.getClass();
        SpanWrapImpl r8 = b.a(r4, r5);
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("endSpan, spanName=");
        r2.append(r5);
        r2.append(", isSpanExist=");
        if (r8 == null) goto L7;
        boolean r9 = true;
    L8:
        r2.append(r9);
        r1.i("RealtimeCallSpanManager", r2.toString());
        if (r8 == null) goto L14;
        r8.g(r6, r7);
        return;
    L14:
        return;
    L7:
        r9 = false;
        goto L8
    L12:
        FLogger.a.w("RealtimeCallSpanManager", "endSpan failed, traceId=" + r4 + ", spanName=" + r5);
    }
}
