package e4a;

import com.ivy.ivykit.api.bridge.IBridgeService;
import com.larus.platform.service.z2;
import h4a.e;
import h4a.j;
import h4a.k;
import h4a.m;
import hq9.h5;
import hx7.d;
import hx7.f;
import hx7.g;
import hx7.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final Object a = null;
    public static final AtomicBoolean b = null;

    static {
        a = new Object();
        b = new AtomicBoolean(false);
    }

    public static void a() {
        Map r0 = com.ivy.ivykit.api.bridge.b.a;
        com.ivy.ivykit.api.bridge.b.b(hx7.a.class, new h4a.a());
        com.ivy.ivykit.api.bridge.b.b(f.class, new j());
        com.ivy.ivykit.api.bridge.b.b(g.class, new k());
        com.ivy.ivykit.api.bridge.b.b(h.class, new m());
        com.ivy.ivykit.api.bridge.b.b(hx7.c.class, new e());
        com.ivy.ivykit.api.bridge.b.b(hx7.e.class, new h4a.h());
        com.ivy.ivykit.api.bridge.b.b(d.class, new h4a.f());
        h5 r1 = z2.a.P();
        ArrayList r2 = new ArrayList();
        if (r1 == null) goto L7;
        List r3 = r1.b;
        if (r3 == null) goto L7;
    L8:
        r2.addAll(r3);
        r2.add("app.aisdk.local");
        IBridgeService.Companion r4 = IBridgeService.a;
        if (r1 == null) goto L11;
        boolean r5 = r1.a;
    L12:
        r4.a(new com.ivy.ivykit.api.bridge.a(r5, r2));
        return;
    L11:
        r5 = false;
    L7:
        r3 = CollectionsKt.emptyList();
        goto L8
    }
}
