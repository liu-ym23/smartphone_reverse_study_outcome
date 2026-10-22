package com.ss.android.lark.coremdbiz.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkPhoneThemeData;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class x<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public x() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        int r0 = r6.g.length();
        r6.g.d(((eab.g) r6.d).j);
        LarkPhoneThemeData r1 = (LarkPhoneThemeData) LarkThemeExtend.m.b(new PhoneNumberPlugin$configureVisitor$1$themeData$1(r6));
        if (((Boolean) r1.d.getValue(r1, LarkPhoneThemeData.g[0])).booleanValue() == false) goto L7;
        com.ss.android.lark.coremd.base.parse.s.a.c(r6.g, r0, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.a(r6.g, r0);
        return;
    }
}
