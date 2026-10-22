package com.larksuite.arch.jack;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements c {
    public final Set<c> a;
    public volatile boolean b;

    @Override // com.larksuite.arch.jack.c
    public final void dispose() {
        if (this.b == true) goto L23;
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L6:
        if (this.b == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        this.b = true;     // Catch: Throwable -> L20
        Set<c> r0 = this.a;     // Catch: Throwable -> L20
        if (r0 == null) goto L17;
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L20
    L15:
        if (r1.hasNext() == false) goto L17;
        ((c) r1.next()).dispose();     // Catch: Throwable -> L20
    L17:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    }

    public b() {
        this.a = Collections.synchronizedSet(new LinkedHashSet());
    }

    public final boolean delete(c r3) {
        Intrinsics.checkNotNullParameter(r3, "d");
        if (this.b == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (this.b == false) goto L11;
        monitor-exit(this);
        return false;
    L11:
        if (this.a.remove(r3) == true) goto L14;
        monitor-exit(this);
        return false;
    L14:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        return true;
    }
}
