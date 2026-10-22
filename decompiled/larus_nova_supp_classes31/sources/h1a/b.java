package h1a;

import com.ixigua.lib.track.TrackParams;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final void a(String r2, String r3, boolean r4, Long r5, Map<String, Long> r6) {
        TrackParams r0 = new TrackParams();
        if (r2 == null) goto L5;
        r0.put("message_id", r2);
    L5:
        if (r3 == null) goto L7;
        r0.put("task_id", r3);
    L7:
        r0.put("success", Integer.valueOf(r4 ? 1 : 0));
        if (r5 == null) goto L10;
        r0.put("duration", Long.valueOf(r5.longValue()));
    L10:
        if (r6 == null) goto L15;
        Iterator<Map.Entry<String, Long>> r7 = r6.entrySet().iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        Map.Entry<String, Long> r8 = r7.next();
        r0.put(r8.getKey(), Long.valueOf(r8.getValue().longValue()));
    L15:
        by7.a r9 = new by7.a("first_picture_render_finish");
        r9.a.merge(r0);
        r9.b();
    }
}
