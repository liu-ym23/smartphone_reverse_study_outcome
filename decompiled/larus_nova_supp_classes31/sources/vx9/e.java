package vx9;

import androidx.collection.LruCache;
import io.opentelemetry.context.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e implements otc.e {
    public static final LruCache<String, String> b = null;
    public final AtomicBoolean a;

    public static final class a {
    }

    static {
        b = new LruCache(50);
    }

    public final ltc.d shutdown() {
        if (this.a.compareAndSet(false, true) == false) goto L5;
        ltc.d r0 = new ltc.d();
        r0.e();
        return r0;
    L5:
        return ltc.d.d;
    }

    public e() {
        this.a = new AtomicBoolean();
    }

    public final void close() {
        shutdown().c(TimeUnit.SECONDS);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [vx9.c] */
    public final ltc.d Jd(Collection<? extends ntc.f> r9) {
        Intrinsics.checkNotNullParameter(r9, "spans");
        if (this.a.get() == true) goto L5;
        Iterator<? extends ntc.f> r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L35;
        ntc.f r0 = r10.next();
        final JSONObject r1 = new JSONObject();
        io.opentelemetry.context.c r2 = g.b;
        wx9.a r4 = null;
        if ((r2 instanceof zx9.a) == false) goto L12;
        zx9.a r3 = (zx9.a) r2;
    L13:
        if (r3 == null) goto L15;
        r4 = r3.getContext(r0.getTraceId(), r0.a());
    L15:
        if (r4 == null) goto L22;
        JSONObject r5 = r4.getCommonParams();
        if (r5 == null) goto L22;
        Iterator<String> r6 = r5.keys();
    L20:
        if (r6.hasNext() == false) goto L22;
        String r7 = r6.next();
        r1.put(r7, r5.get(r7));
    L22:
        String r8 = r0.a();
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        String r11 = (String) b.remove(r8);
        if (r11 != null) goto L28;
        r11 = r0.e().c();
    L28:
        r1.put("trace_id", r0.getTraceId());
        r1.put("trace_parent_id", r0.b());
        r1.put("trace_span_id", r8);
        r1.put("trace_span_scene", r11);
        r1.put("trace_span_name", r0.getName());
        long r12 = 1000;
        r1.put("trace_span_start_timestamp", r0.c() / r12);
        r1.put("trace_span_duration", (r0.d() - r0.c()) / r12);
        itc.g r13 = r0.getAttributes();
        final ?? r14 = new c(r1);
        r13.forEach(new d(r14));
        yx9.c.c.d("span named $" + r0.getName() + " export params: " + r1);
        ntc.c r15 = (ntc.c) CollectionsKt.firstOrNull(r0.getEvents());
        if (r15 == null) goto L32;
        String r16 = r15.getName();
        if (r16 == null) goto L32;
    L33:
        yx9.f r17 = yx9.f.c;
        Intrinsics.checkNotNull(r16);
        r17.a(r16, r1);
    L32:
        r16 = r0.getName();
        goto L33
    L12:
        r3 = null;
        goto L13
    L35:
        return ltc.d.d;
    L5:
        return ltc.d.e;
    }
}
