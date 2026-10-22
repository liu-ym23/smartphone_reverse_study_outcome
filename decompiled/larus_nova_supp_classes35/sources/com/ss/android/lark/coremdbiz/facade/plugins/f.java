package com.ss.android.lark.coremdbiz.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public f() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        eab.b r0 = (eab.b) r8.d;
        int r1 = r8.g.length();
        String r2 = r0.k;
        if (StringsKt.startsWith$default(r2, '@', false, 2, null) == true) goto L5;
        r2 = "@" + r0.k;
    L5:
        r8.g.d(r2);
        int r3 = r0.l;
        boolean r4 = true;
        if (r3 == 1) goto L10;
        if (r3 == 2) goto L10;
        r4 = false;
    L10:
        if (r4 == true) goto L12;
        return;
    L12:
        if (((Boolean) LarkThemeExtend.m.b(new AtUserGroupPlugin$configureVisitor$1$1(r8))).booleanValue() == false) goto L17;
        com.ss.android.lark.coremd.base.parse.s.a.c(r8.g, r1, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.a(r8.g, r1);
        com.ss.android.lark.coremd.base.parse.s.a.b(r8.g, r1);
        return;
    }
}
