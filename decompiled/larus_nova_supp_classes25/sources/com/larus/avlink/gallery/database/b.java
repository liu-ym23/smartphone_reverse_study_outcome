package com.larus.avlink.gallery.database;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface b {
    int a(a r1);

    Object b(a r1, Continuation<? super Long> r2);

    Object c(List<String> r1, Continuation<? super Integer> r2);

    Object d(int r1, int r2, Continuation<? super List<a>> r3);

    Object e(List<Long> r1, Continuation<? super List<a>> r2);

    Object f(Continuation<? super Integer> r1);

    Object g(List<a> r1, Continuation<? super List<Long>> r2);

    Object h(Continuation<? super List<a>> r1);

    Object i(int r1, Continuation<? super List<a>> r2);

    Object j(String r1, Continuation<? super a> r2);

    Object k(String r1, ContinuationImpl r2);

    Object l(List<Integer> r1, Continuation<? super List<a>> r2);

    Object m(String r1, Continuation<? super Integer> r2);

    Object n(int r1, Continuation<? super List<a>> r2);
}
