package ib;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import w26.g;
import y36.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends com.bytedance.ies.bullet.service.sdk.e {
    public final String a;

    public final String getName() {
        return "AnnieXLiteForestInterceptor";
    }

    public a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        this.a = r10;
    }

    public final boolean b(com.bytedance.ies.bullet.service.sdk.d r10) {
        Intrinsics.checkNotNullParameter(r10, "schemaData");
        r10.a("delay_preload", new y36.d(0), true);
        Map r0 = x26.a.a;
        g r1 = (g) x26.a.a(g.class);
        if (r1 == null) goto L9;
        w26.e r11 = (w26.e) r1.n0(w26.e.class);
        if (r11 == null) goto L9;
        Boolean r12 = r11.m1();
        if (r12 == null) goto L9;
        boolean r13 = r12.booleanValue();
    L10:
        if (r13 == true) goto L12;
    L14:
        return true;
    L12:
        if (Intrinsics.areEqual(this.a, "webcast") == false) goto L14;
        r10.a("enable_preload", new p("main"), true);
    L9:
        r13 = true;
        goto L10
    }
}
