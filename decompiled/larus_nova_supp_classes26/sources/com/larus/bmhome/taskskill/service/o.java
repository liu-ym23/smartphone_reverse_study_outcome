package com.larus.bmhome.taskskill.service;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o implements l, Function1<k, Unit> {
    public final Handler a;
    public final AtomicBoolean b;
    public final AtomicBoolean c;
    public volatile Function1<? super k, Unit> d;

    @Override // com.larus.bmhome.taskskill.service.l
    public final void dispose() {
        this.b.set(true);
        this.d = null;
    }

    public final Object invoke(Object r4) {
        final k r5 = (k) r4;
        Intrinsics.checkNotNullParameter(r5, "event");
        boolean r1 = false;
        if (this.b.get() == false) goto L5;
    L13:
        if (r1 == false) goto L27;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L18;
        this.a.post(new n(this, r5));
        goto L27
    L18:
        if (this.b.get() == true) goto L27;
        Function1<? super k, Unit> r0 = this.d;
        if ((r5 instanceof k.h) == false) goto L23;
        this.d = null;
    L23:
        if (r0 == null) goto L27;
        r0.invoke(r5);
    L27:
        return Unit.INSTANCE;
    L5:
        if ((r5 instanceof k.h) == false) goto L8;
        boolean r2 = this.c.compareAndSet(false, true);
    L11:
        if (r2 == false) goto L13;
        r1 = true;
        goto L13
    L8:
        if (this.c.get() == true) goto L10;
        r2 = true;
        goto L11
    L10:
        r2 = false;
        goto L11
    }

    public o(com.larus.bmhome.chat.standarduikit.interaction.viewmodel.h r2, Handler r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Intrinsics.checkNotNullParameter(r3, "mainHandler");
        this.a = r3;
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.d = r2;
    }
}
