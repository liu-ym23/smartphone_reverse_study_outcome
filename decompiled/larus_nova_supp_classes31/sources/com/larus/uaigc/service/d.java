package com.larus.uaigc.service;

import hq9.r3;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements r3 {
    public final /* synthetic */ List<z> a;

    @Override // hq9.r3
    public final void a() {
    }

    @Override // hq9.r3
    public final void d() {
    }

    @Override // hq9.r3
    public final void b() {
        z r0 = (z) CollectionsKt.getOrNull(this.a, 1);
        if (r0 == null) goto L8;
        Function0<Unit> r1 = r0.b;
        if (r1 == null) goto L9;
        r1.invoke();
        return;
    L9:
        return;
    }

    @Override // hq9.r3
    public final void c() {
        z r0 = (z) CollectionsKt.getOrNull(this.a, 0);
        if (r0 == null) goto L8;
        Function0<Unit> r1 = r0.b;
        if (r1 == null) goto L9;
        r1.invoke();
        return;
    L9:
        return;
    }

    public d(List<z> r1) {
        this.a = r1;
    }
}
