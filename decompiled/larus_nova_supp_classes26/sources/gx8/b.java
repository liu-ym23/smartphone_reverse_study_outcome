package gx8;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final c a;
    public final Map<String, Long> b;

    public b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "uploader");
        this.a = r2;
        this.b = new LinkedHashMap();
    }

    public final void c(e r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        this.b.put(r4.getUniqueKey(), Long.valueOf(System.currentTimeMillis()));
    }

    public final void a(e r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r6, "extraAttributes");
        Map<String, Long> r0 = this.b;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Long r2 = (Long) r1.get(r5.getUniqueKey());
        if (r2 == null) goto L6;
        long r3 = r2.longValue();
        r6.put("duration", System.currentTimeMillis() - r3);
        r6.put("type", r5.getEventType());
        this.a.a(r5.getUploadName(), r6);
        Long r7 = this.b.remove(r5.getUniqueKey());
        return;
    }

    public final void b(e r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "extraAttributes");
        r4.put("type", r3.getEventType());
        this.a.a(r3.getUploadName(), r4);
    }
}
