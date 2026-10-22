package com.ss.android.lark.richtextmd.parse.plugins;

import com.ss.android.lark.coremd.base.parse.t;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.q;
import v7b.s;
import v7b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e<T extends s> implements t {
    public final /* synthetic */ a a;

    public e(a r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.coremd.impl.parse.k r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        q r0 = r5.d;
        u r1 = (v7b.a) ((s) r0).d;
        if ((r1 instanceof u) == false) goto L5;
    L7:
        int r2 = com.ss.android.lark.coremd.utils.d.a(r1);
        v7b.p r3 = (v7b.p) r1;
        if ((r3 instanceof u) == false) goto L11;
        String r4 = com.ss.android.lark.coremd.utils.d.c(com.ss.android.lark.coremd.utils.d.b(r1, r5.d), r2) + ' ';
    L15:
        if (this.a.a.b == false) goto L17;
        String r6 = StringsKt.repeat("    ", r2);
        r5.g.a();
        r5.g.d(r6 + r4);
    L18:
        r5.f.c(r5.d);
        return;
    L17:
        r5.g.d(r4);
        goto L18
    L11:
        if ((r3 instanceof v7b.c) == false) goto L13;
        r4 = "- ";
        goto L15
    L13:
        r4 = "";
        goto L15
    L5:
        if ((r1 instanceof v7b.c) == true) goto L7;
        r5.f.c(r0);
    }
}
