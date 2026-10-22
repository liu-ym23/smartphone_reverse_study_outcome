package t89;

import com.bytedance.ies.xbridge.event.EventCenter;
import com.larus.settings.value.e10;
import com.larus.settings.value.ry;
import com.larus.utils.l0;
import java.util.Iterator;
import java.util.Map;
import uq9.h;
import uq9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    static {
    }

    public static void a() {
        e10 r0 = e10.a;
        Map r1 = ((h) l0.a(new h(null), new ry())).a();
        if (r1 == null) goto L11;
        Iterator r2 = r1.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L17;
        Map.Entry r3 = (Map.Entry) r2.next();
        i r4 = (i) r3.getValue();
        if (r4 == null) goto L6;
        EventCenter.registerJsEventSubscriber((String) r3.getKey(), new c(r4));
        goto L6
    L17:
        return;
    }
}
