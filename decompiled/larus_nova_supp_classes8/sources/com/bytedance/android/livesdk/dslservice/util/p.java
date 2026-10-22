package com.bytedance.android.livesdk.dslservice.util;

import android.os.SystemClock;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p {
    public boolean a;
    public final long b;

    public p() {
        this.b = SystemClock.uptimeMillis();
    }

    public final void a(Consumer<Long> r5) {
        Intrinsics.checkNotNullParameter(r5, "func");
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        r5.accept(Long.valueOf(SystemClock.uptimeMillis() - this.b));
    }
}
