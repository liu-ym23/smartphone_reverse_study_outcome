package com.suite.lark.platform.component.cta.newstyle;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.suite.lark.platform.component.cta.newstyle.adapter.BenefitListAdapter;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements joc.d {
    public final /* synthetic */ CTADialogFragment a;

    public f(CTADialogFragment r1) {
        this.a = r1;
    }

    @Override // joc.d
    public final void a(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "licensePlanKey");
        BenefitListAdapter r0 = this.a.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("benefitListAdapter");
        r0 = null;
    L5:
        List<goc.b.C0270b> r12 = ((goc.b.e) ListProtector.get(this.a.S90(), r10)).a();
        if (r12 != null) goto L8;
        r12 = CollectionsKt.emptyList();
    L8:
        List r13 = CollectionsKt.filterNotNull(r12);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r13, "items");
        r0.b.submitList(r13);
        goc.b r14 = this.a.f;
        if (r14 == null) goto L14;
        goc.b.g r15 = r14.b();
        if (r15 == null) goto L14;
        goc.b.h r16 = r15.b();
        if (r16 == null) goto L14;
    L15:
        int r1 = g.a;
        CTADialogFragment r2 = this.a;
        String r3 = r2.h;
        String r4 = r2.i;
        String r5 = r16.b();
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        boolean r6 = r16.a();
        boolean r7 = r16.d();
        String r17 = r16.c();
        if (r17 != null) goto L21;
        String r8 = "";
    L22:
        String r9 = r5;
        g.a(r3, r4, r9, r6, r7, r11, r8, r.W2);
        return;
    L21:
        r8 = r17;
    L14:
        r16 = new goc.b.h(0);
        goto L15
    }
}
