package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.coremd.base.theme.ThematicBreakThemeData;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i1<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public i1() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        ThematicBreakThemeData r0 = com.ss.android.lark.coremd.base.parse.k.b.i(r5.getTheme());
        if (((Boolean) r0.d.getValue(r0, ThematicBreakThemeData.g[0])).booleanValue() == false) goto L7;
        r5.g.a();
        int r1 = r5.g.length();
        r5.g.d("\u200b");
        com.ss.android.lark.coremd.base.parse.s.a.c(r5.g, r1, 0, 6);
        r5.g.a();
        com.ss.android.lark.coremd.base.parse.s.a.b(r5.g, r1);
        return;
    }
}
