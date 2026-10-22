package com.ss.android.lark.richtextmd.parse.plugins;

import com.ss.android.lark.coremd.base.parse.t;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g<T extends s> implements t {
    public final /* synthetic */ a a;

    public g(a r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.coremd.impl.parse.k r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        v7b.d r0 = r8.d;
        if (((s) r0).e != null) goto L11;
        String r1 = r0.j;
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        String r2 = r1;
        if (this.a.a.b == true) goto L10;
        r8.g.d(StringsKt.replace$default(r2, '\n', ' ', false, 4, null));
        return;
    L10:
        r8.g.d(r2);
        return;
    L11:
        r8.f.c(r0);
        Unit r9 = Unit.INSTANCE;
    }
}
