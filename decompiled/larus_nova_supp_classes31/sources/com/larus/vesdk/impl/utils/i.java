package com.larus.vesdk.impl.utils;

import com.larus.utils.t0;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i implements pq9.c {
    public final /* synthetic */ f a;

    public i(f r1) {
        this.a = r1;
    }

    @Override // pq9.c
    public final void onResult(final boolean r6) {
        f r0 = this.a;
        r0.e = Boolean.valueOf(r6);
        if (this.a.f.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r1 = new ArrayList();
        int r2 = this.a.f.size();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        final pq9.c r4 = this.a.f.get(r3);
        t0.e(new h(r4, r6));
        if ((r4 instanceof pq9.d) == false) goto L10;
        r1.add(r4);
    L10:
        r3 = r3 + 1;
        goto L6
    L11:
        CopyOnWriteArrayList<pq9.c> r7 = this.a.f;
        Set r5 = CollectionsKt.toSet(r1);
        TypeIntrinsics.asMutableCollection(r7).removeAll(r5);
    }
}
