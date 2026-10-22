package com.bytedance.android.ec.core.arch.lifecycle;

import java.util.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends CoroutineDispatcher {
    public final b a;

    public f() {
        this.a = new b();
    }

    public final boolean isDispatchNeeded(CoroutineContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (Dispatchers.getMain().getImmediate().isDispatchNeeded(r10) == false) goto L5;
        return true;
    L5:
        b r11 = this.a;
        if (r11.b == false) goto L8;
    L11:
        boolean r12 = true;
    L13:
        return !r12;
    L8:
        if (r11.a == false) goto L11;
        r12 = false;
        goto L13
    }

    public final void dispatch(CoroutineContext r10, Runnable r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "block");
        b r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "runnable");
        MainCoroutineDispatcher r0 = Dispatchers.getMain().getImmediate();
        if (r0.isDispatchNeeded(r10) == false) goto L5;
    L18:
        r0.dispatch(r10, new a(r1, r10, r11));
        return;
    L5:
        if (r1.b == false) goto L7;
    L10:
        boolean r12 = true;
    L11:
        if (r12 == true) goto L18;
        if (((ArrayDeque) r1.d).offer(r11) == false) goto L17;
        r1.a();
        return;
    L17:
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    L7:
        if (r1.a == false) goto L10;
        r12 = false;
        goto L11
    }
}
