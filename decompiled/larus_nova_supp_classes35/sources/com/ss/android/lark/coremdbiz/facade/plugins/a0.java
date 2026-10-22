package com.ss.android.lark.coremdbiz.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkTableThemeData;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public final /* synthetic */ b0 a;

    public a0(b0 r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        r6.g.a();
        int r0 = r6.g.length();
        LarkTableThemeData r1 = (LarkTableThemeData) LarkThemeExtend.m.b(new TablePlugin$configureVisitor$1$themeData$1(r6));
        if (((Boolean) r1.d.getValue(r1, LarkTableThemeData.e[0])).booleanValue() == true) goto L11;
        this.a.getClass();
        Iterator<T> r2 = ((eab.h) r6.d).l.iterator();
    L6:
        if (r2.hasNext() == false) goto L15;
        Iterator<T> r3 = ((eab.h.b) r2.next()).d.iterator();
    L9:
        if (r3.hasNext() == false) goto L6;
        eab.h.a r4 = (eab.h.a) r3.next();
        r6.f.a(r4.f);
        goto L9
    L15:
        return;
    L11:
        r6.g.d(uec.a.a());
        com.ss.android.lark.coremd.base.parse.s.a.c(r6.g, r0, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.a(r6.g, r0);
        r6.g.a();
    }
}
