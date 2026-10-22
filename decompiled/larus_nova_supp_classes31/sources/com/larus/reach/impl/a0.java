package com.larus.reach.impl;

import android.app.Activity;
import com.larus.reach.api.ReachCloseReason;
import com.larus.reach.api.ReachPageScope;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class a0 implements Function0 {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ ns9.t b;
    public final /* synthetic */ ns9.g c;
    public final /* synthetic */ c0.b d;
    public final /* synthetic */ ns9.c e;

    public /* synthetic */ a0(c0 r1, ns9.t r2, ns9.g r3, c0.b r4, ns9.c r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke() {
        c0 r0 = this.a;
        ns9.t r8 = this.b;
        ns9.g r3 = this.c;
        c0.b r6 = this.d;
        ns9.c r7 = this.e;
        r0.i();
        Activity r9 = r0.c();
        if (r8.b.a() != ReachPageScope.Global) goto L27;
        if (r9 == null) goto L6;
    L8:
        c0.c r1 = (c0.c) CollectionsKt.lastOrNull(r0.h.values());
        if (r1 != null) goto L11;
    L16:
        int r2 = com.larus.reach.runtime.p.a;
        boolean r4 = com.larus.reach.runtime.p.b(r8.c.a);
        if (r9 == null) goto L19;
        WeakReference r5 = new WeakReference(r9);
    L20:
        c0.c r11 = new c0.c(r8, r3, r4, r5, r6, r7);
        r0.h.put(r8.a.h, r11);
        if (r9 == null) goto L23;
        r0.m(r9, r8.a.h, false);
        boolean r10 = true;
    L24:
        if (r10 == true) goto L29;
        r0.j(r11, ReachCloseReason.HOST_NOT_READY);
    L29:
        return Unit.INSTANCE;
    L23:
        r10 = r0.o(r8.a.h, false);
        goto L24
    L19:
        r5 = null;
        goto L20
    L11:
        if (r1.g == true) goto L14;
        r1 = null;
    L14:
        if (r1 == null) goto L16;
        r1.g = false;
        r1.b.a();
        goto L16
    L6:
        if (c0.p(r8) == true) goto L8;
    L27:
        r3.b(ReachCloseReason.HOST_NOT_READY);
        return Unit.INSTANCE;
    }
}
