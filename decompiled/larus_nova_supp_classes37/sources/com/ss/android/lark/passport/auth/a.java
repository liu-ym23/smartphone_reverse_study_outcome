package com.ss.android.lark.passport.auth;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements h {
    public final i a;
    public final j b;
    public final AtomicBoolean c;
    public final Object d;

    @Override // com.ss.android.lark.passport.auth.h
    public final void a() {
        Object r0 = this.d;
        monitor-enter(r0);
        this.c.get();     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passport.auth.h
    public final void dispose() {
        if (this.c.compareAndSet(false, true) == false) goto L12;
        Object r0 = this.d;
        monitor-enter(r0);
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r0);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passport.auth.h
    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "finalUrl");
        Object r4 = this.d;
        monitor-enter(r4);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.c.get() == false) goto L27;
        monitor-exit(r4);
        return;
    L27:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Object r1 = Result.constructor-impl(this.a.a(MapsKt.emptyMap()));     // Catch: Throwable -> L10
    L13:
        if (Result.exceptionOrNull-impl(r1) == null) goto L16;
        r1 = MapsKt.emptyMap();     // Catch: Throwable -> L24
    L16:
        Map<String, String> r2 = (Map) r1;     // Catch: Throwable -> L24
        if ((!r2.isEmpty()) == true) goto L19;
    L21:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r4);
        return;
    L19:
        if (this.c.get() == true) goto L21;
        this.b.a(r2);     // Catch: Throwable -> L24
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L24
        r1 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
        goto L13
    }

    public a(com.ss.android.lark.player.player.g r2, com.ss.android.lark.player.player.f r3) {
        Intrinsics.checkNotNullParameter(r2, "build");
        Intrinsics.checkNotNullParameter(r3, "onHeadersChanged");
        this.a = r2;
        this.b = r3;
        this.c = new AtomicBoolean(false);
        this.d = new Object();
    }
}
