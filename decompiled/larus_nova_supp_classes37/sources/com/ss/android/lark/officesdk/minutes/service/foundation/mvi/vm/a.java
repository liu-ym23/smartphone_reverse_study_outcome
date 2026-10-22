package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.k;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KProperty1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a<S extends l, E extends k, UE extends j> {
    <A> void selectSubscribe(CoroutineScope r1, KProperty1<S, ? extends A> r2, Function2<? super A, ? super Continuation<? super Unit>, ? extends Object> r3);

    <A, B> void selectSubscribe(CoroutineScope r1, KProperty1<S, ? extends A> r2, KProperty1<S, ? extends B> r3, Function3<? super A, ? super B, ? super Continuation<? super Unit>, ? extends Object> r4);

    void selectSubscribeVMEvent(CoroutineScope r1, Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> r2);
}
