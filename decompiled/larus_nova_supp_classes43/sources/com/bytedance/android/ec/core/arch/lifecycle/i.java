package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public static final Object a(LifecycleOwner r10, Lifecycle.State r11, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r12, Continuation<? super Unit> r13) {
        Lifecycle r14 = r10.getLifecycle();
        if (r11 == Lifecycle.State.INITIALIZED) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L20;
        if (r14.getCurrentState() != Lifecycle.State.DESTROYED) goto L10;
        Object r15 = Unit.INSTANCE;
    L15:
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r15;
    L18:
        return Unit.INSTANCE;
    L10:
        r15 = CoroutineScopeKt.coroutineScope(new RepeatOnLifecycleKt$repeatOnLifecycle$3(r14, r11, r12, null), r13);
        if (r15 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        r15 = Unit.INSTANCE;
        goto L15
    L20:
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    L5:
        r0 = false;
        goto L6
    }
}
