package xx9;

import com.larus.trace.tracespan.span.b;
import com.larus.utils.logger.FLogger;
import io.opentelemetry.context.c;
import io.opentelemetry.context.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final wx9.a a(b r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        vx9.b.a.getClass();
        if (vx9.b.g == true) goto L6;
        wx9.b r6 = wx9.b.c;
        return wx9.b.c;
    L6:
        zx9.a r0 = null;
        c r1 = g.b;     // Catch: Throwable -> L11
        if ((r1 instanceof zx9.a) == false) goto L13;
        r0 = (zx9.a) r1;     // Catch: Throwable -> L11
    L13:
        if (r0 == null) goto L16;
        wx9.a r7 = r0.getContext(r5.getTraceId(), r5.a());
        if (r7 == null) goto L16;
        return r7;
    L16:
        wx9.b r8 = wx9.b.c;
        return wx9.b.c;
    L11:
        th = move-exception;
        FLogger.a.e("SpanExt", "get ContextStorage failed:" + th);
        goto L13
    }
}
