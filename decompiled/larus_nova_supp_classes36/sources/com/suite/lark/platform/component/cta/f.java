package com.suite.lark.platform.component.cta;

import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import z5c.p2;
import z5c.v1;
import z5c.w0;
import z5c.x0;
import z5c.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements UDBaseDialogBuilder.c {
    public final /* synthetic */ goc.a a;
    public final /* synthetic */ goc.b.g b;
    public final /* synthetic */ b c;

    public final void beforeCreate(UDDialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
    }

    public final void a(UDDialog r6) {
        Intrinsics.checkNotNullParameter(r6, "dialog");
        goc.a r7 = this.a;
        if (r7 == null) goto L5;
        r7.onShow();
    L5:
        goc.b.h r8 = this.b.b();
        if (r8 != null) goto L8;
        r8 = new goc.b.h(0);
    L8:
        int r0 = moc.a.a;
        b r1 = this.c;
        String r2 = r1.a;
        String r3 = r1.b;
        String r4 = r8.b();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        boolean r5 = r8.a();
        boolean r9 = r8.d();
        Intrinsics.checkNotNullParameter(r2, "functionKey");
        Intrinsics.checkNotNullParameter(r3, "functionScene");
        Intrinsics.checkNotNullParameter(r4, "functionCategory");
        s5c.d r10 = s5c.d.b.b(y0.c.a(r2), x0.d.a(r3)).plus(w0.c.a(r4));
        if (r5 == false) goto L14;
        s5c.a r11 = z5c.e.c;
    L15:
        s5c.d r12 = r10.plus(r11);
        if (r9 == false) goto L18;
        s5c.a r13 = v1.d;
    L19:
        Statistics.sendEvent("common_pricing_popup_view", r12.plus(r13).plus(p2.c).toJson());
        return;
    L18:
        r13 = v1.c;
        goto L19
    L14:
        r11 = z5c.e.d;
        goto L15
    }

    public f(goc.a r1, goc.b.g r2, b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
