package com.ss.ugc.live.sdk.msg.unify;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements kmc.a {
    public final ConcurrentHashMap<Long, c> a;

    public final List<c> b() {
        Collection<c> r0 = this.a.values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((!Intrinsics.areEqual(((c) r3).h(), c.d.b.a)) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    public final boolean d() {
        Collection<c> r0 = this.a.values();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L26;
        c r2 = (c) r1.next();
        if (Intrinsics.areEqual(r2.h(), c.d.C0221c.a) == false) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L9;
        return true;
    L13:
        if (Intrinsics.areEqual(r2.h(), c.d.a.a) == true) goto L16;
        r3 = false;
        goto L17
    L26:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public b() {
        this.a = new ConcurrentHashMap();
    }

    @Override // kmc.a
    public final imc.e a(long r1) {
        c r2 = c(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.f.c();
    }

    public final c c(long r2) {
        return this.a.get(Long.valueOf(r2));
    }
}
