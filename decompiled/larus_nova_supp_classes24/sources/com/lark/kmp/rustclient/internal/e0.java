package com.lark.kmp.rustclient.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e0 extends BaseRustDispatcher implements hy7.d {
    public final r g;
    public final Object h;
    public final buc.a i;
    public final ArrayDeque<rpc.c> j;

    public static final class a {
    }

    static {
    }

    public final void a(gy7.u r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void b(gy7.u r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void c(gy7.u r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Object r4 = this.h;
        monitor-enter(r4);
        this.i.d(false);     // Catch: Throwable -> L11
        Iterator r0 = this.j.iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        j((rpc.c) r0.next());     // Catch: Throwable -> L11
        goto L6
    L8:
        this.j.clear();     // Catch: Throwable -> L11
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r4);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void f(gy7.u r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void h(rpc.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        k(r2);
    }

    public final void i(rpc.c r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Object r0 = this.h;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.i.c() == false) goto L10;
        this.j.addLast(r3);     // Catch: Throwable -> L14
    L8:
        if (this.j.size() <= 1000) goto L11;
        this.j.removeFirst();     // Catch: Throwable -> L14
    L11:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return;
    L10:
        j(r3);     // Catch: Throwable -> L14
        goto L11
    }

    public e0(r r3, List<? extends com.lark.kmp.rustclient.api.c> r4) {
        Intrinsics.checkNotNullParameter(r3, "definition");
        Intrinsics.checkNotNullParameter(r4, "interceptors");
        super(r4, r3.c(), r3.a());
        this.g = r3;
        this.h = new Object();
        this.i = buc.b.a(true);
        this.j = new ArrayDeque();
    }
}
