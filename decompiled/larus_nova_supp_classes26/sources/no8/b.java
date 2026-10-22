package no8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public b() {
    }

    public static String a(com.larus.trace.tracespan.span.b r2, Integer r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        StringBuilder r0 = new StringBuilder("traceId=");
        r0.append(r2.getTraceId());
        r0.append(", parentSpanId=");
        com.larus.trace.tracespan.span.b r1 = r2.getParent();
        if (r1 == null) goto L5;
        String r5 = r1.a();
    L6:
        r0.append(r5);
        r0.append(", spanId=");
        r0.append(r2.a());
        r0.append(", tag=");
        r0.append(r2.getTag());
        r0.append(", errorCode:");
        r0.append(r3);
        r0.append(", errorMsg:");
        r0.append(r4);
        return r0.toString();
    L5:
        r5 = null;
        goto L6
    }
}
