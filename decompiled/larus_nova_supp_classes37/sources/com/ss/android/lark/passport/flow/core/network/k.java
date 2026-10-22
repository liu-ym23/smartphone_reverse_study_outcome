package com.ss.android.lark.passport.flow.core.network;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ AtomicReference<Disposable> b;
    public final /* synthetic */ kotlinx.coroutines.i<f> c;
    public final /* synthetic */ e d;

    public k(AtomicBoolean r1, AtomicReference r2, kotlinx.coroutines.j r3, e r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r8) {
        Throwable r5 = (Throwable) r8;
        if (this.a.compareAndSet(false, true) == false) goto L13;
        Disposable r9 = this.b.getAndSet(null);
        if (r9 == null) goto L9;
        r9.dispose();
    L9:
        if (this.c.isActive() == false) goto L12;
        kotlinx.coroutines.i<f> r10 = this.c;
        Result.Companion r0 = Result.Companion;
        String r1 = this.d.c;
        Intrinsics.checkNotNull(r5);
        r10.resumeWith(Result.constructor-impl(ResultKt.createFailure(new PassportHttpTransportException(r1, null, null, null, r5))));
        return;
    L12:
        return;
    }
}
