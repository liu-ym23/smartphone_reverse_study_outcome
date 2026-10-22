package com.ss.android.lark.coremdbiz.facade.table;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements com.ss.android.lark.coremd.base.parse.d {
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.d a;
    public final /* synthetic */ c b;

    public final CharSequence b(s r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        return a(r2, com.ss.android.lark.coremd.base.parse.b.a);
    }

    public b(com.ss.android.lark.coremd.base.parse.d r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.ss.android.lark.coremd.base.parse.d
    public final CharSequence a(s r3, com.ss.android.lark.coremd.base.parse.b r4) {
        Intrinsics.checkNotNullParameter(r3, "node");
        Intrinsics.checkNotNullParameter(r4, "markdownContext");
        return this.a.a(r3, this.b.d.b(r4));
    }
}
