package com.ss.android.lark.compose.chat_member_list;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e<T> implements FlowCollector {
    public final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> a;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r1) {
        this.a = r1;
    }

    public final Object emit(T r2, Continuation<? super Unit> r3) {
        Object r4 = this.a.invoke(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }
}
