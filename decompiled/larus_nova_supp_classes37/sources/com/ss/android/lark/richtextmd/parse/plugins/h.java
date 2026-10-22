package com.ss.android.lark.richtextmd.parse.plugins;

import com.ss.android.lark.coremd.base.parse.t;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h<T extends s> implements t {
    public final /* synthetic */ a a;

    public h(a r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.coremd.impl.parse.k r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        String r1 = r8.d.j;
        if (this.a.a.b == true) goto L5;
        Intrinsics.checkNotNull(r1);
        r1 = StringsKt.replace$default(r1, '\n', ' ', false, 4, null);
    L5:
        com.ss.android.lark.coremd.base.parse.s r9 = r8.g;
        Intrinsics.checkNotNull(r1);
        r9.d(r1);
    }
}
