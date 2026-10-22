package gx8;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class a {
    public final b a;

    public abstract d b();

    public a() {
        c r0 = new c();
        this.a = new b(r0);
        r0.a = b();
    }

    public final void c(e r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.a.c(r2);
    }

    public final void a(e r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r6, "event");
        Intrinsics.checkNotNullParameter(r7, "extraAttributes");
        b r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "event");
        Intrinsics.checkNotNullParameter(r7, "extraAttributes");
        Map<String, Long> r0 = r2.b;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Long r3 = (Long) r1.get(r6.getUniqueKey());
        if (r3 == null) goto L6;
        long r4 = r3.longValue();
        r7.put("duration", System.currentTimeMillis() - r4);
        r7.put("type", r6.getEventType());
        r2.a.a(r6.getUploadName(), r7);
        return;
    }
}
