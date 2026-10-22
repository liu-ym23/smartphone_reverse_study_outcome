package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkMediaThemeData;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public u0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        LarkMediaThemeData r0 = (LarkMediaThemeData) LarkThemeExtend.m.b(new IMMediaPlugin$configureVisitor$1$themeData$1(r5));
        if (((Boolean) r0.d.getValue(r0, LarkMediaThemeData.j[0])).booleanValue() == true) goto L5;
        r5.g.d(((eab.f) r5.d).j);
        return;
    L5:
        r5.g.a();
        int r1 = r5.g.length();
        r5.g.d(((eab.f) r5.d).j);
        com.ss.android.lark.coremd.base.parse.s.a.c(r5.g, r1, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.a(r5.g, r1);
        com.ss.android.lark.coremd.base.parse.s.a.b(r5.g, r1);
        r5.g.a();
    }
}
