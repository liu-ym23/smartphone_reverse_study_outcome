package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import com.ss.android.lark.coremd.base.parse.t;
import com.ss.android.lark.coremd.impl.parse.k;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f<T extends s> implements t {
    public f() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(k r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        int r0 = r5.g.length();
        r5.g.d("￼");
        com.ss.android.lark.coremd.base.parse.s.a.c(r5.g, r0, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.b(r5.g, r0);
    }
}
