package com.suite.lark.platform.component.cta.newstyle;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import kotlin.jvm.internal.Intrinsics;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements joc.c {
    public final /* synthetic */ CTADialogFragment a;

    public c(CTADialogFragment r1) {
        this.a = r1;
    }

    @Override // joc.c
    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "userId");
        eoc.a r11 = (eoc.a) ClaymoreServiceLoader.loadFirst(eoc.a.class);
        this.a.requireContext();
        r11.b();
        goc.b r12 = this.a.f;
        if (r12 == null) goto L24;
        goc.b.g r13 = r12.b();
        if (r13 == null) goto L25;
        goc.b.h r14 = r13.b();
        if (r14 == null) goto L26;
        int r0 = g.a;
        CTADialogFragment r1 = this.a;
        String r2 = r1.h;
        String r3 = r1.i;
        String r4 = r14.b();
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        boolean r5 = r14.a();
        boolean r6 = r14.d();
        goc.b.e r7 = this.a.k;
        if (r7 == null) goto L15;
        String r8 = r7.d();
    L16:
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        String r15 = r14.c();
        if (r15 != null) goto L21;
        String r9 = "";
    L22:
        String r16 = r4;
        g.a(r2, r3, r16, r5, r6, r8, r9, r.M2);
        return;
    L21:
        r9 = r15;
        goto L22
    L15:
        r8 = null;
        goto L16
    L26:
        return;
    L25:
        return;
    }
}
