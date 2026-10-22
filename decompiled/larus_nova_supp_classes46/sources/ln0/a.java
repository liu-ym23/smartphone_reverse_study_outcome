package ln0;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import pn0.d;
import pn0.g;
import rn0.c;
import rn0.e;
import sn0.l;
import sn0.m;
import sn0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int c = 0;
    public final rn0.b a;
    public final b b;

    /* JADX INFO: renamed from: ln0.a$a, reason: collision with other inner class name */
    public static final class C0234a {
    }

    static {
    }

    public final void b() {
        rn0.b r0 = this.a;
        r0.getClass();
        String r1 = r0.g.a + "entrance.json";
        b r2 = r0.g;
        if (r2.c.b == true) goto L6;
        return;
    L6:
        if (r2.d.b(r1) == false) goto L8;
        r0.g.e.a("LayoutConfigResManager", "tryPreloadGeckoRes: already loaded.", false);
        return;
    L8:
        r0.g.e.a("LayoutConfigResManager", "tryPreloadGeckoRes: start load.", true);
        r0.g.d.a(r1, new e(r0));
    }

    public a(b r2) {
        this.b = r2;
        this.a = new rn0.b(r2);
    }

    public final void a(d r9, on0.a r10) {
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r10, "listener");
        rn0.b r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r10, "listener");
        long r0 = System.currentTimeMillis();
        g r3 = r2.g.d.c().e(r9);
        r2.g.e.a("LayoutConfigResManager", "loadLayoutConfig: start load, request = " + r9 + ", modifiedRequestParams = " + r3, false);
        ArrayList r4 = new ArrayList();
        r4.add(new n.c(r2.c, r2));
        r4.add(new n.a(r2.a, r2));
        r4.add(new n.b(r2.b, r2));
        int r5 = n.a;
        Intrinsics.checkNotNullParameter(r4, "createConfigs");
        Iterator r6 = r4.iterator();
        l r7 = null;
    L4:
        if (r6.hasNext() == false) goto L6;
        r7 = ((m) r6.next()).a(r7);
        goto L4
    L6:
        if (r7 == null) goto L10;
        r7.a(r9, r3, new c(r2, r0, r10));
        return;
    }
}
