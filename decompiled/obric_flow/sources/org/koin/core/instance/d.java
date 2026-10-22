package org.koin.core.instance;

import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap f21016b;

    @Override // org.koin.core.instance.c
    public final Object a(b r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        HashMap r10 = this.f21016b;
        if (r10.get(r5.f21013b.f21024b) == null) goto L11;
        org.koin.core.scope.a r11 = r5.f21013b;
        Object r12 = r10.get(r11.f21024b);
        if (r12 == null) goto L10;
        return r12;
    L10:
        throw new IllegalStateException(("Scoped instance not found for " + r11.f21024b + " in " + this.f21015a).toString());
    L11:
        return super.a(r5);
    }

    @Override // org.koin.core.instance.c
    public final Object b(final b r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (Intrinsics.areEqual(r5.f21013b.f21023a, this.f21015a.f21006a) == false) goto L17;
        Function0<Unit> r10 = new ScopedInstanceFactory$get$1(this, r5);
        Intrinsics.checkNotNullParameter(this, "lock");
        Intrinsics.checkNotNullParameter(r10, "block");
        monitor-enter(this);
        r10.invoke();     // Catch: Throwable -> L13
        monitor-exit(this);
        Object r11 = this.f21016b.get(r5.f21013b.f21024b);
        if (r11 == null) goto L12;
        return r11;
    L12:
        throw new IllegalStateException(("Scoped instance not found for " + r5.f21013b.f21024b + " in " + this.f21015a).toString());
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new IllegalStateException(("Wrong Scope: trying to open instance for " + r5.f21013b.f21024b + " in " + this.f21015a).toString());
    }
}
