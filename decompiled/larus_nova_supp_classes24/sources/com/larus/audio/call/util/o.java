package com.larus.audio.call.util;

import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o {
    public final long a;
    public long b;

    public o(long r1) {
        this.a = r1;
        this.b = -1;
    }

    public final void a(Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "block");
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - this.b) <= this.a) goto L6;
        r8.invoke();
        this.b = r0;
        return;
    }
}
