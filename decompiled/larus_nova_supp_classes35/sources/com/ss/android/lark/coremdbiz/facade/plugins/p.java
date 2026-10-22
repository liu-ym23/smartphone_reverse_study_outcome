package com.ss.android.lark.coremdbiz.facade.plugins;

import com.ss.android.lark.coremd.base.theme.ImageThemeData;
import com.ss.android.lark.coremd.impl.parse.MarkdownThemeImpl;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public p() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        com.ss.android.lark.coremd.base.parse.k.a r0 = com.ss.android.lark.coremd.base.parse.k.b;
        com.ss.android.lark.coremd.base.parse.j r1 = r5.getTheme();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        MarkdownThemeImpl.ThemeExtendImpl r2 = r0.c;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ImageThemeData r3 = (ImageThemeData) r2.c.getValue(r1, MarkdownThemeImpl.ThemeExtendImpl.l[0]);
        if (((Boolean) r3.d.getValue(r3, ImageThemeData.f[0])).booleanValue() == true) goto L5;
        r5.g.d(((v7b.l) r5.d).k);
        return;
    L5:
        r5.g.a();
        int r4 = r5.g.length();
        r5.g.d(((v7b.l) r5.d).k);
        com.ss.android.lark.coremd.base.parse.s.a.c(r5.g, r4, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.a(r5.g, r4);
        com.ss.android.lark.coremd.base.parse.s.a.b(r5.g, r4);
        r5.g.a();
    }
}
