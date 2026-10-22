package com.bytedance.android.live.revlink.impl.multianchor.pk;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> {
    public final T a;
    public final T b;
    public final T c;

    public final Map<String, T> a(List<? extends af2.b> r7) {
        Intrinsics.checkNotNullParameter(r7, "scoreList");
        HashMap r0 = new HashMap();
        Iterator<? extends af2.b> r1 = r7.iterator();
        String r2 = null;
    L4:
        if (r1.hasNext() == false) goto L8;
        af2.b r3 = r1.next();
        if (((int) r3.getBattleRank()) != 1) goto L4;
        r2 = af2.c.a(r3);
        goto L4
    L8:
        Iterator<? extends af2.b> r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L20;
        af2.b r4 = r8.next();
        String r5 = af2.c.a(r4);
        if (r5 == null) goto L10;
        if (r2 == null) goto L15;
        if (Intrinsics.areEqual(r2, af2.c.a(r4)) == true) goto L18;
        r0.put(r5, this.b);
        goto L10
    L18:
        r0.put(r5, this.a);
        goto L10
    L15:
        r0.put(r5, this.c);
        goto L10
    L20:
        return r0;
    }

    public final Map<String, T> b(List<? extends af2.b> r10) {
        Intrinsics.checkNotNullParameter(r10, "scoreList");
        HashMap r0 = new HashMap();
        List<? extends af2.b> r1 = r10;
        boolean r5 = true;
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        if (((af2.b) r2.next()).getMultiPkTeamRank() != 1) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L9;
        r5 = false;
        goto L16
    L13:
        r6 = false;
    L16:
        if (r5 == false) goto L24;
        Iterator<? extends af2.b> r12 = r10.iterator();
    L19:
        if (r12.hasNext() == false) goto L23;
        String r3 = af2.c.a(r12.next());
        if (r3 == null) goto L19;
        r0.put(r3, this.c);
        goto L19
    L23:
        return r0;
    L24:
        Iterator<? extends af2.b> r13 = r10.iterator();
    L26:
        if (r13.hasNext() == false) goto L34;
        af2.b r4 = r13.next();
        String r7 = af2.c.a(r4);
        if (r7 == null) goto L26;
        if (r4.getMultiPkTeamRank() != 1) goto L32;
        T r8 = this.a;
    L33:
        r0.put(r7, r8);
        goto L26
    L32:
        r8 = this.b;
        goto L33
    L34:
        return r0;
    L5:
        if (r1.isEmpty() == false) goto L7;
        goto L7
    }

    public d(T r1, T r2, T r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
