package com.ss.android.lark.coremdbiz.facade;

import com.ss.android.lark.coremd.base.parse.t;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.q;
import v7b.s;
import v7b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T extends s> implements t {
    public c() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        s r0 = r5.d;
        v7b.a r1 = (v7b.a) ((q) r0).d;
        if ((r1 instanceof u) == false) goto L5;
    L7:
        int r2 = com.ss.android.lark.coremd.utils.d.a(r1);
        v7b.p r3 = (v7b.p) r1;
        if ((r3 instanceof u) == false) goto L11;
        String r4 = com.ss.android.lark.coremd.utils.d.c(com.ss.android.lark.coremd.utils.d.b((u) r1, r5.d), r2) + ' ';
    L14:
        String r6 = StringsKt.repeat("    ", r2);
        r5.g.a();
        r5.g.d(r6 + r4);
        r5.f.c(r5.d);
        return;
    L11:
        if ((r3 instanceof v7b.c) == false) goto L13;
        r4 = "- ";
        goto L14
    L13:
        r4 = BuildConfig.FLAVOR;
        goto L14
    L5:
        if ((r1 instanceof v7b.c) == true) goto L7;
        r5.f.c(r0);
    }
}
