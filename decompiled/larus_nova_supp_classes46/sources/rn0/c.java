package rn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import pn0.g;
import qn0.k;
import sn0.l;
import sn0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements sn0.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ long b;
    public final /* synthetic */ on0.a c;

    @Override // sn0.a
    public final void c(pn0.d r4, g r5) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "modifiedRequestParams");
        this.a.g.e.a("LayoutConfigResManager", "LayoutConfigGeckoResManager#onFailed: traceInfo = " + r4.e().a, false);
        this.c.b(r4);
    }

    public c(b r1, long r2, on0.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    @Override // sn0.a
    public final void b(pn0.d r11, g r12, LayoutConfigModel r13, ProducerResStep r14) {
        Intrinsics.checkNotNullParameter(r11, "request");
        Intrinsics.checkNotNullParameter(r12, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r13, "originLayoutConfig");
        Intrinsics.checkNotNullParameter(r14, "step");
        Map<String, LayoutConfigModel.a> r0 = r13.c();
        if (r0 == null) goto L7;
        LayoutConfigModel.a r1 = r0.get("android");
        if (r1 == null) goto L7;
        r13.E(r1.b());
    L7:
        this.a.g.e.a("LayoutConfigResManager", "loadLayoutConfig#onResult: request = " + r11 + ", step = " + r14 + ", duration = " + (System.currentTimeMillis() - this.b) + ", layoutConfig = " + r13 + ", \ntraceInfo: " + r11.e().a, false);
        b r2 = this.a;
        String r3 = r2.g.d.c().a(r11, r12);
        if (r2.c.containsKey(r3) == true) goto L10;
        r2.c.put(r3, r13.a());
    L10:
        b r4 = this.a;
        on0.a r9 = this.c;
        r4.getClass();
        if (r11.a() == false) goto L18;
        ArrayList r5 = new ArrayList();
        r5.add(new k.c(r4.f, r4));
        r5.add(new k.a(r4.d, r4.e, r4));
        r5.add(new k.b(r4.d, r4.e, r4));
        int r6 = k.a;
        Intrinsics.checkNotNullParameter(r5, "createConfigs");
        Iterator r7 = r5.iterator();
        l r8 = null;
    L14:
        if (r7.hasNext() == false) goto L16;
        r8 = ((m) r7.next()).a(r8);
        goto L14
    L16:
        if (r8 == null) goto L21;
        r8.a(r11, r12, new d(r4, r13, r14, r9));
        return;
    L21:
        return;
    L18:
        r4.e(r11, r13, null, r12, r14, r9);
    }
}
