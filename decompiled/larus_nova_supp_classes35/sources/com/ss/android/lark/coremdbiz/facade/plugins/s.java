package com.ss.android.lark.coremdbiz.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkLinkThemeData;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public final /* synthetic */ LarkLinkPlugin a;

    public s(LarkLinkPlugin r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        LarkLinkPlugin r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "<this>");
        LarkLinkThemeData r1 = (LarkLinkThemeData) LarkThemeExtend.m.b(new LarkLinkPlugin$visitLink$theme$1(r6));
        if (r1.i() == true) goto L5;
        r6.g.d(((v7b.n) r6.d).j);
        return;
    L5:
        cab.b r2 = (cab.b) r1.g.getValue(r1, LarkLinkThemeData.n[0]);
        if (r2.a((v7b.n) r6.d) == true) goto L8;
        r6.g.d(r0.g(r6, (v7b.n) r6.d));
        return;
    L8:
        r6.g.e(((v7b.n) r6.d).j, new t(r2, r6, r0));
    }
}
