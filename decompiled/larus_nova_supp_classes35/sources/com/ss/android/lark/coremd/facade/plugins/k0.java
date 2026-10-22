package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.coremd.base.theme.HeadingThemeData;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public k0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        HeadingThemeData r0 = com.ss.android.lark.coremd.base.parse.k.b.e(r5.getTheme());
        if (((Boolean) r0.d.getValue(r0, HeadingThemeData.g[0])).booleanValue() == false) goto L7;
        r5.g.a();
        int r1 = r5.g.length();
        r5.f.c(r5.d);
        com.ss.android.lark.coremd.base.parse.s.a.c(r5.g, r1, 0, 6);
        r5.g.a();
        return;
    }
}
