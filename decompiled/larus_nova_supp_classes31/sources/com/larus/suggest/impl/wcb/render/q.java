package com.larus.suggest.impl.wcb.render;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface q {
    Object a(l r1, Continuation<? super n> r2);

    Object b(Continuation<? super Unit> r1);

    void c();

    void cancel();

    boolean isActive();
}
