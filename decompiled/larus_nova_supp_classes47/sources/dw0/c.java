package dw0;

import am2.x;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import ew0.d;
import ew0.f;
import ew0.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements b {
    public static final List<a> a = null;
    public static final c b = null;

    public c() {
    }

    static {
        c r0 = new c();
        b = r0;
        a = new ArrayList();
        Intrinsics.checkNotNullParameter(r0, "target");
        r0.a(ew0.b.a);
        r0.a(d.a);
        r0.a(g.a);
        r0.a(f.a);
        r0.a(ew0.c.a);
        r0.a(ew0.a.a);
    }

    @Override // dw0.b
    public final void a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        a.add(r2);
    }

    public final void b(Map<String, String> r3, String r4, Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "eventContext");
        Iterator r0 = ((ArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).a(r4, r3, r5);
        goto L4
    }

    public final void c(String r4, Map<String, String> r5, Collection<? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "eventProperties");
        Intrinsics.checkNotNullParameter(r6, "eventContext");
        LinkedHashMap r2 = new LinkedHashMap();
        b(r2, r4, r6);
        r2.putAll(r5);
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r2, "eventProperties");
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r7 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d(r4, r2, new Class[]{IRoom.class, x.class});
    }
}
