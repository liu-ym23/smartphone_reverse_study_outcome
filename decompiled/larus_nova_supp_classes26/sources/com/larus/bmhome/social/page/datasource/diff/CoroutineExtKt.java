package com.larus.bmhome.social.page.datasource.diff;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CoroutineExtKt {
    public static final Object a(CoroutineContext r5, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r6, Continuation<? super Job> r7) {
        if ((r7 instanceof CoroutineExtKt$launchChild$1) == false) goto L7;
        CoroutineExtKt$launchChild$1 r0 = (CoroutineExtKt$launchChild$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.ObjectRef r9 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L19:
        return r9.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        CoroutineExtKt$launchChild$2 r4 = new CoroutineExtKt$launchChild$2(r10, r5, r6, null);
        r0.L$0 = r10;
        r0.label = 1;
        if (CoroutineScopeKt.coroutineScope(r4, r0) != r2) goto L17;
        return r2;
    L17:
        r9 = r10;
    L7:
        r0 = new CoroutineExtKt$launchChild$1(r7);
        goto L8
    }
}
