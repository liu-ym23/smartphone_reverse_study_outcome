package com.bytedance.android.live.broadcastgame.xplay;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s {
    public static final Set<g10.b> a = null;

    static {
        a = new LinkedHashSet();
    }

    public static List b() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = a.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        g10.b r2 = (g10.b) r1.next();
        if ((r2 instanceof g10.e) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }

    public static void a(IXplayMainService.State r1, Integer r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "state");
        int r4 = r.a[r1.ordinal()];
        if (r4 != 1) goto L5;
        Set<g10.b> r5 = a;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L19:
        if (r7.hasNext() == false) goto L23;
        Object r8 = r7.next();
        if ((r8 instanceof g10.c) == false) goto L19;
        r6.add(r8);
        goto L19
    L23:
        Iterator r9 = r6.iterator();
    L25:
        if (r9.hasNext() == false) goto L41;
        ((g10.c) r9.next()).f();
        goto L25
    L41:
        return;
    L5:
        if (r4 != 2) goto L27;
        Set<g10.b> r11 = a;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L13;
        Object r14 = r13.next();
        if ((r14 instanceof g10.c) == false) goto L9;
        r12.add(r14);
        goto L9
    L13:
        Iterator r15 = r12.iterator();
    L15:
        if (r15.hasNext() == false) goto L40;
        ((g10.c) r15.next()).b();
        goto L15
    L40:
        return;
    }
}
