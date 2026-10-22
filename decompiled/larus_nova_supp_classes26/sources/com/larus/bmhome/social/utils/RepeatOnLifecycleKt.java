package com.larus.bmhome.social.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class RepeatOnLifecycleKt {
    public static final Object a(Lifecycle r2, Lifecycle.State r3, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super Unit> r5) {
        if (r3 == Lifecycle.State.INITIALIZED) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        if (r2.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        Object r6 = CoroutineScopeKt.coroutineScope(new RepeatOnLifecycleKt$repeatOnLifecycle$3(r2, r3, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r6;
    L15:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L17:
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final Object b(LifecycleOwner r0, Lifecycle.State r1, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super Unit> r3) {
        Object r4 = a(r0.getLifecycle(), r1, r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }
}
