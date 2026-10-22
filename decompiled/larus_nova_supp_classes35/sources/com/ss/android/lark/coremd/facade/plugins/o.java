package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.coremd.base.theme.BlockQuoteThemeData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public final /* synthetic */ p a;

    public o(p r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r11) {
        Intrinsics.checkNotNullParameter(r11, "it");
        BlockQuoteThemeData r0 = com.ss.android.lark.coremd.base.parse.k.b.b(r11.getTheme());
        if (((Boolean) r0.d.getValue(r0, BlockQuoteThemeData.j[0])).booleanValue() == false) goto L27;
        r11.g.a();
        int r1 = r11.g.length();
        this.a.getClass();
        ArrayList r2 = new ArrayList();
        v7b.s r3 = ((v7b.b) r11.d).e;
    L6:
        if (r3 == null) goto L17;
        v7b.s r4 = r3.h;
        if ((r3 instanceof v7b.v) == false) goto L15;
        int r5 = r11.g.length();
        r11.f.a(r3);
        int r6 = r11.g.length();
        if (r5 >= r6) goto L14;
        int r8 = r5 + 1;
        if (Intrinsics.areEqual(r11.g.c(r5, r8), "\n") == false) goto L14;
        r5 = r8;
    L14:
        r2.add(new Triple(r3, Integer.valueOf(r5), Integer.valueOf(r6)));
    L16:
        r3 = r4;
        goto L6
    L15:
        r11.f.a(r3);
        goto L16
    L17:
        Iterator r7 = r2.iterator();
    L19:
        if (r7.hasNext() == false) goto L21;
        Triple r9 = (Triple) r7.next();
        v7b.v r10 = (v7b.v) r9.component1();
        int r12 = ((Number) r9.component2()).intValue();
        int r13 = ((Number) r9.component3()).intValue();
        com.ss.android.lark.coremd.base.parse.s r14 = r11.g;
        r14.setSpan(new com.ss.android.lark.coremd.impl.buildnode.a(r10, r14.c(r12, r13), false), r12, r13, 34);
        goto L19
    L21:
        com.ss.android.lark.coremd.base.parse.s r15 = r11.g;
        r15.f(r1, r15.length(), 65569);
        return;
    }
}
