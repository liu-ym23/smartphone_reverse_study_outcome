package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.lark.policy.model.b0;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import i8b.q;
import i8b.v;
import i8b.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends i8b.a {
    public final com.ss.android.lark.conditional.access.display.g b;

    public static final class a {
    }

    static {
    }

    @Override // i8b.a
    public final void a() {
    }

    @Override // i8b.a
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "tenantId");
    }

    public e(q r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        super(r2);
        LarkAppContext.Companion.getClass();
        this.b = (com.ss.android.lark.conditional.access.display.g) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.conditional.access.display.g.class);
    }

    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        if ((r9 instanceof w) == true) goto L5;
        return;
    L5:
        if (w4c.c.a().A() == false) goto L36;
        Collection<b0> r10 = ((v) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((w) r9)).a).b.values();
        ArrayList r0 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L25;
        b0 r1 = (b0) r11.next();
        int r4 = com.ss.android.lark.conditional.access.utils.e.a;
        List r2 = com.ss.android.lark.conditional.access.utils.e.d(r1.a());
        ArrayList r5 = new ArrayList();
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L24;
        DecisionData.Action r6 = (DecisionData.Action) r3.next();
        String r7 = r6.getParams().get("displayID");
        if (r7 != null) goto L15;
    L18:
        boolean r8 = true;
    L19:
        if (r8 == false) goto L21;
        String r12 = null;
    L22:
        if (r12 == null) goto L11;
        r5.add(r12);
        goto L11
    L21:
        r12 = r6.getParams().get("displayID");
        goto L22
    L15:
        if (r7.length() == 0) goto L18;
        r8 = false;
        goto L19
    L24:
        CollectionsKt.addAll(r0, r5);
        goto L8
    L25:
        List<String> r13 = CollectionsKt.distinct(r0);
        if ((!r13.isEmpty()) == false) goto L37;
        this.b.S5(r13, false);
        return;
    L37:
        return;
    }
}
