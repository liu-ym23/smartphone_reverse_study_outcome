package org.koin.core.instance;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f21017b;

    @Override // org.koin.core.instance.c
    public final Object a(b r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r10 = this.f21017b;
        if (r10 == null) goto L6;
        if (r10 == null) goto L8;
        return r10;
    L8:
        throw new IllegalStateException("Single instance created couldn't return value");
    L6:
        return super.a(r5);
    }

    @Override // org.koin.core.instance.c
    public final Object b(final b r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Function0<Unit> r10 = new SingleInstanceFactory$get$1(this, r5);
        Intrinsics.checkNotNullParameter(this, "lock");
        Intrinsics.checkNotNullParameter(r10, "block");
        monitor-enter(this);
        r10.invoke();     // Catch: Throwable -> L11
        monitor-exit(this);
        Object r11 = this.f21017b;
        if (r11 == null) goto L10;
        return r11;
    L10:
        throw new IllegalStateException("Single instance created couldn't return value");
    L11:
        th = move-exception;
        throw th;
    }
}
