package com.ss.android.lark.keyboard.event;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface l {
    void a();

    void b(Function2<? super g, ? super j, Boolean> r1);

    <E extends q> void c(Class<E> r1, Function2<? super g, ? super E, Unit> r2);

    <S extends m> void d(Class<S> r1, Function3<? super g, ? super S, ? super S, Unit> r2);
}
