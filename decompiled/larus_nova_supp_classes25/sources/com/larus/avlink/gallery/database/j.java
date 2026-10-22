package com.larus.avlink.gallery.database;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface j {
    Object a(long r1, String r3, Continuation<? super Integer> r4);

    Object b(long r1, String r3, ContinuationImpl r4);

    Object c(List<Long> r1, String r2, Continuation<? super Integer> r3);

    Object d(List<Long> r1, String r2, Continuation<? super List<i>> r3);

    Object e(i r1, Continuation<? super Long> r2);

    Object f(Continuation<? super List<i>> r1);

    Object g(i r1, Continuation<? super Integer> r2);
}
