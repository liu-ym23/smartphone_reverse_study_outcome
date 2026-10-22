package com.suite.lark.platform.component.cta.newstyle;

import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import z5c.e4;
import z5c.j3;
import z5c.p2;
import z5c.p3;
import z5c.v1;
import z5c.w0;
import z5c.x0;
import z5c.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1, String r2, String r3, boolean r4, boolean r5, String r6, String r7, s5c.a r8) {
        Intrinsics.checkNotNullParameter(r1, "functionKey");
        Intrinsics.checkNotNullParameter(r2, "functionScene");
        Intrinsics.checkNotNullParameter(r3, "functionCategory");
        Intrinsics.checkNotNullParameter(r6, "skuKey");
        Intrinsics.checkNotNullParameter(r7, "viewType");
        Intrinsics.checkNotNullParameter(r8, "click");
        s5c.a r0 = p3.c;
        r8.getClass();
        s5c.d r9 = s5c.d.b.b(r8, r0).plus(y0.c.a(r1)).plus(x0.d.a(r2)).plus(w0.c.a(r3)).plus(j3.c.a(r6)).plus(e4.e.a(r7));
        if (r4 == false) goto L5;
        s5c.a r10 = z5c.e.c;
    L6:
        s5c.d r11 = r9.plus(r10);
        if (r5 == false) goto L9;
        s5c.a r12 = v1.d;
    L10:
        Statistics.sendEvent("common_pricing_popup_click", r11.plus(r12).plus(p2.c).toJson());
        return;
    L9:
        r12 = v1.c;
        goto L10
    L5:
        r10 = z5c.e.d;
        goto L6
    }
}
