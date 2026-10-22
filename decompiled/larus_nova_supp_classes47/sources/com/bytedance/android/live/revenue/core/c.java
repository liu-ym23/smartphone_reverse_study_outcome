package com.bytedance.android.live.revenue.core;

import com.bytedance.android.scope.l;
import e33.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final com.bytedance.live.kmp.core.e a;
    public final rh6.b b;

    public final void a() {
        if (l.b(this.b) == false) goto L5;
        List<rh6.a> r0 = f.a;
        ArrayList r1 = (ArrayList) r0;
        r1.remove(this.b);
        l.c(this.b);
    L5:
        ((LinkedHashMap) this.a.a).clear();
    }

    public c() {
        com.bytedance.live.kmp.core.e r0 = new com.bytedance.live.kmp.core.e();
        this.a = r0;
        cy0.e.a.getClass();
        rh6.b r1 = new rh6.b(cy0.e.a.a);
        Intrinsics.checkNotNullParameter(r1, "scope");
        Intrinsics.checkNotNullParameter(r0, "value");
        r1.e = r0;
        if (r0 != k.a) goto L5;
        String r2 = "previewDependencyResolver";
    L6:
        if (r2 != null) goto L10;
        this.b = r1;
        return;
    L10:
        throw new UninitializedPropertyAccessException(r2);
    L5:
        r2 = null;
        goto L6
    }
}
