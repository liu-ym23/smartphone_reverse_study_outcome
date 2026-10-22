package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.coremd.base.theme.InlineCodeThemeData;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public e0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        InlineCodeThemeData r0 = com.ss.android.lark.coremd.base.parse.k.b.f(r6.getTheme());
        if (((Boolean) r0.d.getValue(r0, InlineCodeThemeData.h[0])).booleanValue() == false) goto L14;
        int r1 = r6.g.length();
        r6.g.g(" ");
        v7b.s r2 = r6.d;
        if (((v7b.d) r2).e != null) goto L11;
        com.ss.android.lark.coremd.base.parse.s r4 = r6.g;
        String r3 = ((v7b.d) r2).j;
        if (r3 != null) goto L10;
        r3 = BuildConfig.FLAVOR;
    L10:
        r4.d(r3);
    L12:
        r6.g.g(" ");
        com.ss.android.lark.coremd.base.parse.s.a.c(r6.g, r1, 0, 6);
        return;
    L11:
        r6.f.c(r2);
        goto L12
    }
}
