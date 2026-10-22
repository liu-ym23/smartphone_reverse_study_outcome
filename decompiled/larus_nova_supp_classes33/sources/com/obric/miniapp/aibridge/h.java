package com.obric.miniapp.aibridge;

import com.obric.capabilitykit.entity.ResultCallback;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h implements ResultCallback<Unit> {
    public final /* synthetic */ f3.h<AbsIndexIcsDataMethodIDL.b> a;

    public h(f3.h<AbsIndexIcsDataMethodIDL.b> r1) {
        this.a = r1;
    }

    public final void onResult(int r2, String r3, Object r4) {
        Unit r5 = (Unit) r4;
        Intrinsics.checkNotNullParameter(r3, "errorMsg");
        if (r2 != 0) goto L5;
    L7:
        f3.h<AbsIndexIcsDataMethodIDL.b> r6 = this.a;
        Intrinsics.checkNotNullParameter(AbsIndexIcsDataMethodIDL.b.class, "<this>");
        f3.h.a.b(r6, k3.c.a(AbsIndexIcsDataMethodIDL.b.class));
        return;
    L5:
        if (r2 == 301) goto L7;
        f3.h.a.a(this.a, r2 + ": " + r3, null, null, 14);
    }
}
