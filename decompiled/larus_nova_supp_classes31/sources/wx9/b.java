package wx9;

import com.larus.trace.tracespan.span.SpanWrapImpl;
import io.opentelemetry.context.f;
import java.util.Iterator;
import jtc.g;
import jtc.i;
import jtc.l;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements wx9.a {
    public static final b c = null;
    public final SpanWrapImpl a;
    public JSONObject b;

    public static final class a {
    }

    static {
        c = new b(new SpanWrapImpl(g.b, 0), null);
    }

    public final Object get() {
        Intrinsics.checkNotNullParameter(l.a, "key");
        i r0 = this.a.a;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0;
    }

    @Override // wx9.a
    public final SpanWrapImpl c() {
        return this.a;
    }

    @Override // wx9.a
    public final JSONObject getCommonParams() {
        return this.b;
    }

    public final synchronized b a(SpanWrapImpl r3) {
        f r0 = vx9.f.a;
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r0, "k1");     // Catch: Throwable -> L11
        JSONObject r1 = this.b;     // Catch: Throwable -> L11
        if (r1 == null) goto L7;
        JSONObject r2 = new JSONObject(r1.toString());     // Catch: Throwable -> L11
    L8:
        b r4 = new b(r3, r2);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4;
    L7:
        r2 = null;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // wx9.a
    public final synchronized void b(JSONObject r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "params");     // Catch: Throwable -> L15
        if (this.b != null) goto L6;
        this.b = new JSONObject(r5.toString());     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L6:
        Iterator<String> r0 = r5.keys();     // Catch: Throwable -> L15
    L8:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next();     // Catch: Throwable -> L15
        JSONObject r2 = this.b;     // Catch: Throwable -> L15
        if (r2 == null) goto L8;
        r2.put(r1, r5.get(r1));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public b(SpanWrapImpl r1, JSONObject r2) {
        this.a = r1;
        this.b = r2;
    }
}
