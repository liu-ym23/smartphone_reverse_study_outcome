package com.ss.android.lark.coremdbiz.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public c() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        int r0 = r5.g.length();
        r5.g.d("@" + ((eab.a) r5.d).j);
        if (((Boolean) LarkThemeExtend.m.b(new AtPlugin$configureVisitor$1$1(r5))).booleanValue() == false) goto L7;
        com.ss.android.lark.coremd.base.parse.s.a.c(r5.g, r0, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.a(r5.g, r0);
        com.ss.android.lark.coremd.base.parse.s.a.b(r5.g, r0);
        return;
    }
}
